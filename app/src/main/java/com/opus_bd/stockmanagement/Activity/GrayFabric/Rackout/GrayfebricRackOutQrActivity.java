package com.opus_bd.stockmanagement.Activity.GrayFabric.Rackout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.opus_bd.stockmanagement.Activity.GrayFabric.GaryFebricActivity;
import com.opus_bd.stockmanagement.Activity.LoginActivity;
import com.opus_bd.stockmanagement.Activity.StockIn.List2Activity;
import com.opus_bd.stockmanagement.Model.GrayFabric.Scan.GrayRollDetailInfo;
import com.opus_bd.stockmanagement.R;
import com.opus_bd.stockmanagement.RetrofitService.RetrofitClientInstance;
import com.opus_bd.stockmanagement.RetrofitService.RetrofitService;
import com.opus_bd.stockmanagement.Utilts.SharedPrefManager;
import com.opus_bd.stockmanagement.Utilts.Utilities;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.widget.Toast.LENGTH_LONG;

public class GrayfebricRackOutQrActivity extends AppCompatActivity {
    Button button_scan_qr_code;

    int detailsid;
    String RollNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grayfebric_rack_out_qr);
        button_scan_qr_code = findViewById(R.id.buttonScanRoll);

        button_scan_qr_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                (new IntentIntegrator(GrayfebricRackOutQrActivity.this)).initiateScan();
            }
        });
        /*Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            detailsid = bundle.getInt("Item getId");

            RollNo = bundle.getString("Item getRollNo");

        }*/
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "Cancelled", LENGTH_LONG).show();
            } /*else if (result.getContents().equals(RollNo)) {


                submitToServer(detailsid);
               *//* c++;
                Utilities.showLogcatMessage(" C++ "+c);
                if(c==2){
                    submitToServer(3);
                    text.setText("Matched Successfully ");
                    text.setTextColor(getResources().getColor(R.color.successColor));
                    c=0;
                }*//*

                //Toast.makeText((Context)this, (CharSequence)("Scanned: " + result.getContents()), LENGTH_LONG).show();
            } */ else {
                GetGrayRollDetailInfo(result.getContents());
            }
        }
    }

    public void GetGrayRollDetailInfo(String id) {
        Utilities.showLogcatMessage(" Gray response 0");
        RetrofitService retrofitService = RetrofitClientInstance.getRetrofitInstance().create(RetrofitService.class);
        //  Call<LoginResponce> registrationRequest = retrofitService.GetFinishFabricReceivedList(userModel);
        String token = SharedPrefManager.getInstance(this).getToken();

        if (token != null) {
            Utilities.showLogcatMessage(" Gray response token");
            Call<GrayRollDetailInfo> registrationRequest = retrofitService.GetGrayRollDetailInfo(SharedPrefManager.BEARER + token, id);

            try {
                Utilities.showLogcatMessage(" Gray response 1");
                registrationRequest.enqueue(new Callback<GrayRollDetailInfo>() {
                    @Override
                    public void onResponse(Call<GrayRollDetailInfo> call, @NonNull Response<GrayRollDetailInfo> response) {
                        Utilities.showLogcatMessage(" Gray response 2" + response.body());
                        if (response.body() != null) {
                            Utilities.showLogcatMessage(" Gray response 3" + response.body());
                            detailsid = response.body().getGrayFebricsDetailId();
                            submitToServer(detailsid);

                        } else {
                            Toasty.error(GrayfebricRackOutQrActivity.this, "SESSION_EXPIRED", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(GrayfebricRackOutQrActivity.this, List2Activity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
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
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }

    private void submitToServer(int status) {

        String token = SharedPrefManager.getInstance(this).getToken();
        Utilities.showLogcatMessage("token " + token);
        RetrofitService retrofitService = RetrofitClientInstance.getRetrofitInstance().create(RetrofitService.class);
        Utilities.showLogcatMessage("detailsid " + status);
        Call<String> registrationRequest = retrofitService.GrayFabricRackOutEditAPI(SharedPrefManager.BEARER + token, status);
        registrationRequest.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Gson gson = new Gson();
                Utilities.showLogcatMessage(gson.toJson(response.body()));
                Utilities.showLogcatMessage(gson.toJson(response));

                try {
                    if (response.body() != null) {
                        Utilities.showLogcatMessage("response.msg() " + response.message());
                        Utilities.showLogcatMessage("response.body() " + response.body());
                        Utilities.showLogcatMessage("response.full() " + response.toString());
                        Utilities.showLogcatMessage("response.len() " + response.body().length());
                        if (!response.body().contains("item")) {
                            Toasty.success(GrayfebricRackOutQrActivity.this, "Success").show();
                            ;//   finish();

                        } else {
                            Toasty.error(GrayfebricRackOutQrActivity.this, "Item Not Found").show();
                            ;//   finish();
                        }
                        //Toast.makeText(GrayfebricRackOutQrActivity.this, response.body().toString(), Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(GrayfebricRackOutQrActivity.this, GaryFebricActivity.class));

                    } else {
                        Toasty.error(GrayfebricRackOutQrActivity.this, "Invalid Credentials!").show();
                        ;//   finish();

                        //Toast.makeText(GrayfebricRackOutQrActivity.this, , Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toasty.error(GrayfebricRackOutQrActivity.this, "Something went Wrong! Please try again later!").show();
                    ;//   finish();

                    //  Toast.makeText(GrayfebricRackOutQrActivity.this, "Something went Wrong! Please try again later", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

                Toast.makeText(GrayfebricRackOutQrActivity.this, "Fail to connect " + t.toString(), Toast.LENGTH_SHORT).show();
                Utilities.showLogcatMessage("Fail to connect " + t.toString());
            }
        });
    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(this, GaryFebricActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

}