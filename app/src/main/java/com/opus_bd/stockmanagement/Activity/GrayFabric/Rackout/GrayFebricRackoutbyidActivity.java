package com.opus_bd.stockmanagement.Activity.GrayFabric.Rackout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.opus_bd.stockmanagement.Activity.LoginActivity;
import com.opus_bd.stockmanagement.Adapter.GrayFebric.RackOutListByIdAdapter;
import com.opus_bd.stockmanagement.Adapter.RecivedFinishListAdapter;
import com.opus_bd.stockmanagement.Model.GrayFabric.RackOut.GrayFabricIssueDetail;
import com.opus_bd.stockmanagement.Model.GrayFabric.RackOut.RackoutById;
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

public class GrayFebricRackoutbyidActivity extends AppCompatActivity {
    @BindView(R.id.rvNotice)
    RecyclerView rvNotice;

    int ID;

    RackOutListByIdAdapter noticeListAdapter;
    ArrayList<GrayFabricIssueDetail> noticeArrayList = new ArrayList<>();
    RecivedFinishListAdapter recivedFinishListAdapter;
    private ArrayList<ReveivedFinishFabric> reveivedFinishFabrics = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gray_febric_rackoutbyid);
        ButterKnife.bind(this);
        intRecyclerView();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            ID = bundle.getInt("Item getId");
            getAllList(ID);
        }
    }

    public void intRecyclerView() {
        noticeListAdapter = new RackOutListByIdAdapter(noticeArrayList, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        rvNotice.setLayoutManager(layoutManager);
        rvNotice.setAdapter(noticeListAdapter);

    }


    public void getAllList(int id) {
        //  Call<LoginResponce> registrationRequest = retrofitService.GetFinishFabricReceivedList(userModel);
        String token = SharedPrefManager.getInstance(this).getToken();

        if (token != null) {
            RetrofitService retrofitService = RetrofitClientInstance.getRetrofitInstance().create(RetrofitService.class);
            Call<RackoutById> registrationRequest = retrofitService.GrayFabricRackOutEditListAPI(SharedPrefManager.BEARER + token, id);
            Utilities.showLogcatMessage(" " + token);

            try {
                registrationRequest.enqueue(new Callback<RackoutById>() {
                    @Override
                    public void onResponse(Call<RackoutById> call, @NonNull Response<RackoutById> response) {
                        if (response.body() != null) {
                            Utilities.showLogcatMessage("response.body() " + response.body());
                            noticeArrayList.clear();
                            noticeArrayList.addAll(response.body().getGrayFabricIssueDetails());
                           /* for(int i=0;i<response.body().getGrayFabricIssueDetails().size();i++){
                                noticeArrayList.add(response.body().getGrayFabricIssueDetails());
                                response.body().getGrayFabricIssueDetails().get(i).getId();        }
*/


                            noticeListAdapter.notifyDataSetChanged();


                            /*reveivedFinishFabrics.clear();
                            reveivedFinishFabrics.addAll(response.body().getReveivedFinishFabrics());
                            recivedFinishListAdapter.notifyDataSetChanged();*/
                        } else {
                            Utilities.showLogcatMessage("response.body() " + response.body());
                            Toasty.error(GrayFebricRackoutbyidActivity.this, "SESSION_EXPIRED", Toast.LENGTH_SHORT).show();
                            SharedPrefManager.getInstance(GrayFebricRackoutbyidActivity.this).clearToken();
                            Intent intent = new Intent(GrayFebricRackoutbyidActivity.this, LoginActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<RackoutById> call, Throwable t) {
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

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(this, GrayFebricRackOutActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

}
