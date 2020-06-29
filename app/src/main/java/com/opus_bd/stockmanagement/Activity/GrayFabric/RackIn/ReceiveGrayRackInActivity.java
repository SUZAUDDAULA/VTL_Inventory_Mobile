package com.opus_bd.stockmanagement.Activity.GrayFabric.RackIn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.opus_bd.stockmanagement.Activity.LoginActivity;
import com.opus_bd.stockmanagement.Activity.StockIn.List2Activity;
import com.opus_bd.stockmanagement.Adapter.GrayFebric.ReceivedGrayFabricListAdapter;
import com.opus_bd.stockmanagement.Model.GrayFabric.ReceivedGrayFabric;
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

public class ReceiveGrayRackInActivity extends AppCompatActivity {
@BindView(R.id.rvGrayRackIn)
    RecyclerView rvGrayRackIn;
ReceivedGrayFabricListAdapter receivedGrayFabricListAdapter;
 ArrayList<ReceivedGrayFabric> receivedGrayFabricList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_gray_rack_in);
        ButterKnife.bind(this);
        iniviews();
        getAllList();
    }

    public void iniviews()
    {
        receivedGrayFabricListAdapter=new ReceivedGrayFabricListAdapter(receivedGrayFabricList,this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        rvGrayRackIn.setLayoutManager(layoutManager);
        rvGrayRackIn.setAdapter(receivedGrayFabricListAdapter);
    }

    public void getAllList() {
        RetrofitService retrofitService = RetrofitClientInstance.getRetrofitInstance().create(RetrofitService.class);
        //  Call<LoginResponce> registrationRequest = retrofitService.GetFinishFabricReceivedList(userModel);
        String token = SharedPrefManager.getInstance(this).getToken();

        if (token != null) {
            Call<List<ReceivedGrayFabric>> registrationRequest = retrofitService.GetReceivedGrayFabricBeforeRackIn(SharedPrefManager.BEARER + token);

            try {
                registrationRequest.enqueue(new Callback<List<ReceivedGrayFabric>>() {
                    @Override
                    public void onResponse(Call<List<ReceivedGrayFabric>> call, @NonNull Response<List<ReceivedGrayFabric>> response) {

                        Utilities.showLogcatMessage(" Response 1"+response);
                        if (response.body() != null) {
                            Utilities.showLogcatMessage(" Response "+response.body());
                            receivedGrayFabricList.clear();
                            receivedGrayFabricList.addAll(response.body());
                            receivedGrayFabricListAdapter.notifyDataSetChanged();
                        } else {
                            Toasty.error(ReceiveGrayRackInActivity.this, "SESSION_EXPIRED", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(ReceiveGrayRackInActivity.this, List2Activity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<ReceivedGrayFabric>> call, Throwable t) {
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
