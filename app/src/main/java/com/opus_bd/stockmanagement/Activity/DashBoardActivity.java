package com.opus_bd.stockmanagement.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.opus_bd.stockmanagement.Adapter.AllStorageDetailsInfoListAdapter;
import com.opus_bd.stockmanagement.Model.DashBoard.AllStorageDetailsInfo;
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

public class DashBoardActivity extends AppCompatActivity {
    @BindView(R.id.rvNotice)
    RecyclerView rvNotice;

    AllStorageDetailsInfoListAdapter AllStorageDetailsInfoListAdapter;
    private ArrayList<AllStorageDetailsInfo> noticeArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        ButterKnife.bind(this);
        intRecyclerView();
        getAllList();
    }


    public void intRecyclerView() {
        AllStorageDetailsInfoListAdapter = new AllStorageDetailsInfoListAdapter(noticeArrayList, this);
        GridLayoutManager layoutManager = new GridLayoutManager(this,3);
/*        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);*/
        rvNotice.setLayoutManager(layoutManager);
        rvNotice.setAdapter(AllStorageDetailsInfoListAdapter);


      
    }



    public void getAllList() {
        Utilities.showProgress(this);
        //  Call<LoginResponce> registrationRequest = retrofitService.GetFinishFabricReceivedList(userModel);
        String token = SharedPrefManager.getInstance(this).getToken();

        if (token != null) {
            RetrofitService retrofitService = RetrofitClientInstance.getRetrofitInstance().create(RetrofitService.class);
            Call<List<AllStorageDetailsInfo>> registrationRequest = retrofitService.GetAllStorageDetailsInfo(SharedPrefManager.BEARER + token);
            Utilities.showLogcatMessage(" "+token);

            try {
                registrationRequest.enqueue(new Callback<List<AllStorageDetailsInfo>>() {
                    @Override
                    public void onResponse(Call<List<AllStorageDetailsInfo>> call, @NonNull Response<List<AllStorageDetailsInfo>> response) {
                        Utilities.hideProgress(DashBoardActivity.this);
                        if (response.body() != null) {
                            Utilities.showLogcatMessage("response.body() "+response.body());
                            noticeArrayList.clear();
                            noticeArrayList.addAll(response.body());
                            AllStorageDetailsInfoListAdapter.notifyDataSetChanged();
                            
                        } else {
                            Utilities.showLogcatMessage("response.body() "+response.body());
                            Toasty.error(DashBoardActivity.this, "SESSION_EXPIRED", Toast.LENGTH_SHORT).show();
                            SharedPrefManager.getInstance(DashBoardActivity.this).clearToken();
                            Intent intent = new Intent(DashBoardActivity.this, LoginActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<AllStorageDetailsInfo>> call, Throwable t) {
                        Utilities.hideProgress(DashBoardActivity.this);
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
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            Intent intent = new Intent(this, ListActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(this, ListActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
