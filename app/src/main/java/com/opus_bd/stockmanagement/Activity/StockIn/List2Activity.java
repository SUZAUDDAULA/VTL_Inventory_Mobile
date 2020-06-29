package com.opus_bd.stockmanagement.Activity.StockIn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.opus_bd.stockmanagement.Activity.LoginActivity;
import com.opus_bd.stockmanagement.Adapter.NoticeListAdapter;
import com.opus_bd.stockmanagement.Adapter.RecivedFinishListAdapter;
import com.opus_bd.stockmanagement.Model.FabricDetails;
import com.opus_bd.stockmanagement.Model.FinishFebricsMaster;
import com.opus_bd.stockmanagement.Model.ReveivedFinishFabric;
import com.opus_bd.stockmanagement.R;
import com.opus_bd.stockmanagement.RetrofitService.RetrofitClientInstance;
import com.opus_bd.stockmanagement.RetrofitService.RetrofitService;
import com.opus_bd.stockmanagement.Utilts.SharedPrefManager;
import com.opus_bd.stockmanagement.Utilts.Utilities;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class List2Activity extends AppCompatActivity {


    @BindView(R.id.rvNotice)
    RecyclerView rvNotice;

    NoticeListAdapter noticeListAdapter;
    private ArrayList<FinishFebricsMaster> noticeArrayList = new ArrayList<>();  @BindView(R.id.rvRecived)
    RecyclerView rvRecived;

    RecivedFinishListAdapter recivedFinishListAdapter;
    private ArrayList<ReveivedFinishFabric> reveivedFinishFabrics = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);
        ButterKnife.bind(this);
        intRecyclerView();
        getAllList();
    }

    public void intRecyclerView() {
        noticeListAdapter = new NoticeListAdapter(noticeArrayList, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        rvNotice.setLayoutManager(layoutManager);
        rvNotice.setAdapter(noticeListAdapter);


        recivedFinishListAdapter = new RecivedFinishListAdapter(reveivedFinishFabrics, this);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this);
        layoutManager1.setReverseLayout(true);
        layoutManager1.setStackFromEnd(true);
        rvRecived.setLayoutManager(layoutManager1);
        rvRecived.setAdapter(recivedFinishListAdapter);
    }



    public void getAllList() {
       //  Call<LoginResponce> registrationRequest = retrofitService.GetFinishFabricReceivedList(userModel);
        String token = SharedPrefManager.getInstance(this).getToken();

        if (token != null) {
            RetrofitService retrofitService = RetrofitClientInstance.getRetrofitInstance().create(RetrofitService.class);
            Call<FabricDetails> registrationRequest = retrofitService.GetFinishFabricReceivedList(SharedPrefManager.BEARER + token);
            Utilities.showLogcatMessage(" "+token);

            try {
                registrationRequest.enqueue(new Callback<FabricDetails>() {
                    @Override
                    public void onResponse(Call<FabricDetails> call, @NonNull Response<FabricDetails> response) {
                        if (response.body() != null) {
                            Utilities.showLogcatMessage("response.body() "+response.body());
                            noticeArrayList.clear();
                            noticeArrayList.addAll(response.body().getFinishFebricsMasters());
                            noticeListAdapter.notifyDataSetChanged();


                            reveivedFinishFabrics.clear();
                            reveivedFinishFabrics.addAll(response.body().getReveivedFinishFabrics());
                            recivedFinishListAdapter.notifyDataSetChanged();
                        } else {
                            Utilities.showLogcatMessage("response.body() "+response.body());
                            Toasty.error(List2Activity.this, "SESSION_EXPIRED", Toast.LENGTH_SHORT).show();
                            SharedPrefManager.getInstance(List2Activity.this).clearToken();
                            Intent intent = new Intent(List2Activity.this, LoginActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<FabricDetails> call, Throwable t) {
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
