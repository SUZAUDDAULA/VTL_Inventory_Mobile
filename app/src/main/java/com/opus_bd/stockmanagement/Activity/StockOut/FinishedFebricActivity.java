package com.opus_bd.stockmanagement.Activity.StockOut;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.opus_bd.stockmanagement.Activity.LoginActivity;
import com.opus_bd.stockmanagement.Activity.StockIn.List3Activity;
import com.opus_bd.stockmanagement.Adapter.FinishedFebricStogareAdapter;
import com.opus_bd.stockmanagement.Model.FinishFabricStorageByRecevedNo;
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

public class FinishedFebricActivity extends AppCompatActivity {

    @BindView(R.id.rvNotice)
    RecyclerView rvNotice;

    FinishedFebricStogareAdapter noticeListAdapter;
    private ArrayList<FinishFabricStorageByRecevedNo> noticeArrayList = new ArrayList<>();
    int ID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list3);
        setResult(RESULT_OK);
        ButterKnife.bind(this);
        intRecyclerView();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            ID = bundle.getInt("Item getId");
            getAllList(ID);
        }

    }

    public void intRecyclerView() {
        noticeListAdapter = new FinishedFebricStogareAdapter(noticeArrayList, this);
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
            Call<List<FinishFabricStorageByRecevedNo>> registrationRequest = retrofitService.GetFinishFabricRackStorageForIssue(SharedPrefManager.BEARER + token,id);

            try {
                registrationRequest.enqueue(new Callback<List<FinishFabricStorageByRecevedNo>>() {
                    @Override
                    public void onResponse(Call<List<FinishFabricStorageByRecevedNo>> call, @NonNull Response<List<FinishFabricStorageByRecevedNo>> response) {
                        if (response.body() != null) {
                            noticeArrayList.clear();
                            noticeArrayList.addAll(response.body());
                            noticeListAdapter.notifyDataSetChanged();
                        } else {
                            Toasty.error(FinishedFebricActivity.this, "SESSION_EXPIRED", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(FinishedFebricActivity.this, LoginActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<FinishFabricStorageByRecevedNo>> call, Throwable t) {
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
