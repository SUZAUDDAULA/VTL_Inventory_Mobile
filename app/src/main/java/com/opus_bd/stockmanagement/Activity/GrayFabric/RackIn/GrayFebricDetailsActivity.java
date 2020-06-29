package com.opus_bd.stockmanagement.Activity.GrayFabric.RackIn;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.opus_bd.stockmanagement.Activity.LoginActivity;
import com.opus_bd.stockmanagement.Activity.StockIn.List2Activity;
import com.opus_bd.stockmanagement.Adapter.GrayFebric.GrayFebricDetailsListAdapter;
import com.opus_bd.stockmanagement.Model.GrayFabric.GrayFabricDetailsViewModel;
import com.opus_bd.stockmanagement.Model.GrayFabric.GrayFebricDetails;
import com.opus_bd.stockmanagement.R;
import com.opus_bd.stockmanagement.RetrofitService.RetrofitClientInstance;
import com.opus_bd.stockmanagement.RetrofitService.RetrofitService;
import com.opus_bd.stockmanagement.Utilts.Constants;
import com.opus_bd.stockmanagement.Utilts.SharedPrefManager;
import com.opus_bd.stockmanagement.Utilts.Utilities;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GrayFebricDetailsActivity extends AppCompatActivity {
    @BindView(R.id.rvGrayFebricDetails)
    RecyclerView rvGrayFebricDetails;

    GrayFebricDetailsListAdapter noticeListAdapter;
    private ArrayList<GrayFabricDetailsViewModel> noticeArrayList = new ArrayList<>();
    int ID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gray_febric_details);
        ButterKnife.bind(this);
        intRecyclerView();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            ID = bundle.getInt("Item getId");
            getAllList(ID);
        }

    }

    public void intRecyclerView() {
        noticeListAdapter = new GrayFebricDetailsListAdapter(noticeArrayList, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        rvGrayFebricDetails.setLayoutManager(layoutManager);
        rvGrayFebricDetails.setAdapter(noticeListAdapter);
    }



    public void getAllList(int id) {
        RetrofitService retrofitService = RetrofitClientInstance.getRetrofitInstance().create(RetrofitService.class);
        //  Call<LoginResponce> registrationRequest = retrofitService.GetFinishFabricReceivedList(userModel);
        String token = SharedPrefManager.getInstance(this).getToken();

        if (token != null) {
            Call<GrayFebricDetails> registrationRequest = retrofitService.GetAllCurrentGrayFebricDetailsByReceiveIdApi(SharedPrefManager.BEARER + token,id);

            try {
                Utilities.showLogcatMessage(" Gray response 1");
                registrationRequest.enqueue(new Callback<GrayFebricDetails>() {
                    @Override
                    public void onResponse(Call<GrayFebricDetails> call, @NonNull Response<GrayFebricDetails> response) {
                        if (response.body() != null) {
                            Utilities.showLogcatMessage(" Gray response 2"+response.body());
                            Constants.rollList.clear();
                            Constants.qrList.clear();
                            Constants.rackIdList.clear();
                            Constants.detailsList.clear();
                            for (int i = 0; i < response.body().getGrayFabricDetailsViewModels().size(); i++) {
                                Constants.rollList.add(response.body().getGrayFabricDetailsViewModels().get(i).getRollNo());
                                Constants.qrList.add(response.body().getGrayFabricDetailsViewModels().get(i).getQrCode());
                                Constants.rackIdList.add(response.body().getGrayFabricDetailsViewModels().get(i).getRackId());
                                Constants.detailsList.add(response.body().getGrayFabricDetailsViewModels().get(i).getDetailsId());
                                Utilities.showLogcatMessage("QR LIst " + Constants.qrList.get(i));
                            }

                            noticeArrayList.clear();
                            noticeArrayList.addAll(response.body().getGrayFabricDetailsViewModels());
                            noticeListAdapter.notifyDataSetChanged();
                        } else {
                            Toasty.error(GrayFebricDetailsActivity.this, "SESSION_EXPIRED", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(GrayFebricDetailsActivity.this, List2Activity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<GrayFebricDetails> call, Throwable t) {
                        Utilities.showLogcatMessage("error " + t.toString());
                    }
                });

            } catch (Exception e) {
                Utilities.showLogcatMessage("error " + e.toString());
            }
        } else {
            Toasty.error(this, "SESSION_EXPIRED", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }

    @OnClick(R.id.btnRackIn)
    public void Rackin() {
        Intent intent = new Intent(GrayFebricDetailsActivity.this, QRActivity.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {

        Intent intent = new Intent(this, GrayFebricRackInActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
