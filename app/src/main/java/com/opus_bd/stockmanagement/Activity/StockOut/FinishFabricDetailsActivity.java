package com.opus_bd.stockmanagement.Activity.StockOut;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.opus_bd.stockmanagement.Activity.LoginActivity;
import com.opus_bd.stockmanagement.Activity.StockIn.CurrentFebricDetailsActivity;
import com.opus_bd.stockmanagement.Activity.StockIn.List2Activity;
import com.opus_bd.stockmanagement.Adapter.CurrentFebricDetailsListAdapter;
import com.opus_bd.stockmanagement.Adapter.StockOutFebricDetailsListAdapter;
import com.opus_bd.stockmanagement.Model.CurrentFebricDetails;
import com.opus_bd.stockmanagement.R;
import com.opus_bd.stockmanagement.RetrofitService.RetrofitClientInstance;
import com.opus_bd.stockmanagement.RetrofitService.RetrofitService;
import com.opus_bd.stockmanagement.Utilts.SharedPrefManager;
import com.opus_bd.stockmanagement.Utilts.Utilities;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FinishFabricDetailsActivity extends AppCompatActivity {

    @BindView(R.id.rvNotice)
    RecyclerView rvNotice;

    StockOutFebricDetailsListAdapter noticeListAdapter;
    private ArrayList<CurrentFebricDetails> noticeArrayList = new ArrayList<>();
    int ID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_febric_details);
        ButterKnife.bind(this);
        intRecyclerView();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            ID = bundle.getInt("Item getId");
            getAllList(ID);
        }

    }

    public void intRecyclerView() {
        noticeListAdapter = new StockOutFebricDetailsListAdapter(noticeArrayList, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        rvNotice.setLayoutManager(layoutManager);
        rvNotice.setAdapter(noticeListAdapter);
    }



    public void getAllList(int id) {
        RetrofitService retrofitService = RetrofitClientInstance.getRetrofitInstance().create(RetrofitService.class);
        //  Call<LoginResponce> registrationRequest = retrofitService.GetFinishFabricReceivedList(userModel);
        String token = SharedPrefManager.getInstance(this).getToken();

        if (token != null) {
            Call<List<CurrentFebricDetails>> registrationRequest = retrofitService.GetFinishFabricDetailsListForIssueById(SharedPrefManager.BEARER + token,id);

            try {
                registrationRequest.enqueue(new Callback<List<CurrentFebricDetails>>() {
                    @Override
                    public void onResponse(Call<List<CurrentFebricDetails>> call, @NonNull Response<List<CurrentFebricDetails>> response) {
                        if (response.body() != null) {
                            noticeArrayList.clear();
                            noticeArrayList.addAll(response.body());
                            noticeListAdapter.notifyDataSetChanged();
                        } else {
                            Toasty.error(FinishFabricDetailsActivity.this, "SESSION_EXPIRED", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(FinishFabricDetailsActivity.this, StockOutListActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<CurrentFebricDetails>> call, Throwable t) {
                        Utilities.showLogcatMessage("error " + t.toString());
                    }
                });

            } catch (Exception e) {
            }
        } else {
            Toasty.error(this, "SESSION_EXPIRED", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }


}


