package com.opus_bd.stockmanagement.Activity.GrayFabric.FindLocation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.opus_bd.stockmanagement.Activity.GrayFabric.RackIn.QRActivity;
import com.opus_bd.stockmanagement.Activity.LoginActivity;
import com.opus_bd.stockmanagement.Model.GrayFabric.Roll;
import com.opus_bd.stockmanagement.Model.GrayFabric.Scan.GrayRollDetailInfo;
import com.opus_bd.stockmanagement.R;
import com.opus_bd.stockmanagement.RetrofitService.RetrofitClientInstance;
import com.opus_bd.stockmanagement.RetrofitService.RetrofitService;
import com.opus_bd.stockmanagement.Utilts.SharedPrefManager;
import com.opus_bd.stockmanagement.Utilts.Utilities;
import com.opus_bd.stockmanagement.databinding.ActivityFindLocationBinding;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.widget.Toast.LENGTH_LONG;

public class FindLocationActivity extends AppCompatActivity {

    ActivityFindLocationBinding activityFindLocationBinding;

    private IntentIntegrator qrScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityFindLocationBinding = DataBindingUtil.setContentView(this, R.layout.activity_find_location);

        qrScan = new IntentIntegrator(this);

        initToolbar();
        allClickAction();

    }

    public void allClickAction() {
        activityFindLocationBinding.buttonScanRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qrScan.initiateScan();
            }
        });
    }

    public void initToolbar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        setTitle("Find Location");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            //if qrcode has nothing in it
            if (result.getContents() == null) {
                Toasty.normal(getApplicationContext(), "Result Not Found.");
            } else {
                String scanId = result.getContents().toString();
                GetGrayRollDetailInfo(scanId);

            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void GetGrayRollDetailInfo(String id) {

        RetrofitService retrofitService = RetrofitClientInstance.getRetrofitInstance().create(RetrofitService.class);
        String token = SharedPrefManager.getInstance(this).getToken();

        if (token != null) {
            Call<GrayRollDetailInfo> registrationRequest = retrofitService.GetGrayRollDetailInfo(SharedPrefManager.BEARER + token, id);
            try {
                registrationRequest.enqueue(new Callback<GrayRollDetailInfo>() {
                    @Override
                    public void onResponse(Call<GrayRollDetailInfo> call, @NonNull Response<GrayRollDetailInfo> response) {
                        if (response.body() != null) {
                            activityFindLocationBinding.locationNameTv.setText("" + response.body().getGrayFebricsStorageDetail().getCellNo());
                            activityFindLocationBinding.discriptionTv.setText("" + response.body().getGrayFebricsDetail().getMaterialDescription());
                        } else {

                        }
                    }

                    @Override
                    public void onFailure(Call<GrayRollDetailInfo> call, Throwable t) {
                        Utilities.showLogcatMessage("error " + t.toString());
                    }
                });

            } catch (Exception e) {
                Utilities.showLogcatMessage("error " + e.toString());
            }
        } else {
            Toasty.error(this, "SESSION_EXPIRED", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
}