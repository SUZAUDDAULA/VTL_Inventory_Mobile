package com.opus_bd.stockmanagement.Activity.GrayFabric.RackIn;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

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

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.widget.Toast.LENGTH_LONG;

public class GrayFebricScanActivity extends AppCompatActivity {
    @BindView(R.id.buttonScanRoll)
    Button buttonScanRoll;

    @BindView(R.id.buttonScanQRCode)
    Button buttonScanQRCode;

    @BindView(R.id.text)
    TextView text;

    @BindView(R.id.tvRollNo)
    TextView tvRollNo;
    @BindView(R.id.tvLocation)
    TextView tvLocation;
    @BindView(R.id.tvQuantity)
    TextView tvQuantity;
    @BindView(R.id.tvStatus)
    TextView tvStatus;
    int c = 0, rackid, detailsid;
    String qr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gray_febric_scan);
        ButterKnife.bind(this);
        buttonScanQRCode.setVisibility(View.GONE);

        buttonScanRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    (new IntentIntegrator(GrayFebricScanActivity.this)).initiateScan();
                } catch (Exception e) {
                    Utilities.showLogcatMessage(" No Error e   =  " + e.toString());
                }

            }
        });
    }


    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Utilities.showLogcatMessage(" No Error");
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "Cancelled", LENGTH_LONG).show();
            } else {
                text.setText(result.getContents());
                text.setTextColor(getResources().getColor(R.color.errorColor));


                c++;
                if (c == 1) {
                    GetGrayRollDetailInfo(result.getContents());
                    buttonScanRoll.setText("Scan Rack");
                } else if (c == 2 & result.getContents().equals(qr)) {
                    text.setText("QR code Matched");

                    submitToServer(rackid, detailsid);
                    Toast.makeText((Context) this, (CharSequence) ("Scanned: " + result.getContents()), LENGTH_LONG).show();
                    c = 0;
                } else if (c == 2 & !result.getContents().equals(qr)) {
                    text.setText("QR code Not Matched");
                    // submitToServer(rackid,detailsid);
                    showAlert(detailsid, result.getContents());
                    Toast.makeText((Context) this, (CharSequence) ("Scanned: " + result.getContents()), LENGTH_LONG).show();
                    c = 0;
                }

                // Toast.makeText((Context)this, (CharSequence)("Scanned: " + result.getContents()), LENGTH_LONG).show();
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
                            tvRollNo.setText(response.body().getGrayFebricsDetail().getRollNo());
                            tvLocation.setText(response.body().getGrayFebricsStorageDetail().getCellNo());

                            tvQuantity.setText(String.valueOf(response.body().getGrayFebricsDetail().getGQTY()));

                            if (response.body().getStatusId() == 3) {
                                tvStatus.setText("Already Stored");
                            } else {
                                tvStatus.setText("Not Yet Stored");
                            }

                            qr = response.body().getGrayFebricsStorageDetail().getQrCode();
                            rackid = response.body().getId();
                            detailsid = response.body().getGrayFebricsDetailId();
                        } else {
                            Toasty.error(GrayFebricScanActivity.this, "SESSION_EXPIRED", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(GrayFebricScanActivity.this, List2Activity.class);
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

    private void submitToServer(int rack, int detail) {

        String token = SharedPrefManager.getInstance(this).getToken();

        RetrofitService retrofitService = RetrofitClientInstance.getRetrofitInstance().create(RetrofitService.class);
        Call<String> registrationRequest = retrofitService.UpdateGrayFabricReceiveStatusAPI(SharedPrefManager.BEARER + token, rack, detail);
        registrationRequest.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                try {
                    if (response.body() != null) {
                        Toast.makeText(GrayFebricScanActivity.this, response.body(), Toast.LENGTH_SHORT).show();
                        //   finish();
                        startActivity(new Intent(GrayFebricScanActivity.this, GaryFebricActivity.class));

                    } else {
                        Toast.makeText(GrayFebricScanActivity.this, "Invalid Credentials!", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(GrayFebricScanActivity.this, "Something went Wrong! Please try again later", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

                Toast.makeText(GrayFebricScanActivity.this, "Fail to connect " + t.toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void submitToServerforChange(int di, String qr) {

        String token = SharedPrefManager.getInstance(this).getToken();

        RetrofitService retrofitService = RetrofitClientInstance.getRetrofitInstance().create(RetrofitService.class);
        Call<String> registrationRequest = retrofitService.UpdateGrayFabricReceiveStatusAndLocationAPI(SharedPrefManager.BEARER + token, di, qr);
        registrationRequest.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                try {
                    if (response.body() != null) {
                        Toast.makeText(GrayFebricScanActivity.this, response.body(), Toast.LENGTH_SHORT).show();
                        //   finish();
                        startActivity(new Intent(GrayFebricScanActivity.this, GaryFebricActivity.class));

                    } else {
                        Toast.makeText(GrayFebricScanActivity.this, "Invalid Credentials!", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(GrayFebricScanActivity.this, "Something went Wrong! Please try again later", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

                Toast.makeText(GrayFebricScanActivity.this, "Fail to connect " + t.toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void showAlert(int detail, String Qrc) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("QR code not matched . Are you sure to submit here?");
        alertDialogBuilder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        submitToServerforChange(detail, Qrc);
                    }
                });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(this, GrayFebricDetailsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}

