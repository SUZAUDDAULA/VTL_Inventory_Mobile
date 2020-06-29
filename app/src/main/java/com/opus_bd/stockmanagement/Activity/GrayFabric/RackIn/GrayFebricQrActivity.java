package com.opus_bd.stockmanagement.Activity.GrayFabric.RackIn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.opus_bd.stockmanagement.Activity.GrayFabric.GaryFebricActivity;
import com.opus_bd.stockmanagement.R;
import com.opus_bd.stockmanagement.RetrofitService.RetrofitClientInstance;
import com.opus_bd.stockmanagement.RetrofitService.RetrofitService;
import com.opus_bd.stockmanagement.Utilts.Constants;
import com.opus_bd.stockmanagement.Utilts.SharedPrefManager;
import com.opus_bd.stockmanagement.Utilts.Utilities;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.widget.Toast.LENGTH_LONG;

public class GrayFebricQrActivity extends AppCompatActivity {
    Button button_scan_qr_code;
    TextView text;
    int detailsid,rackID,c=0;
    String RollNo,QrCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gray_febric_qr);
        button_scan_qr_code= findViewById(R.id.button_scan_qr_code);
        text= findViewById(R.id.text);
        button_scan_qr_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                (new IntentIntegrator(GrayFebricQrActivity.this)).initiateScan();
            }
        });
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            detailsid = bundle.getInt("Item getDetailsId");
            rackID = bundle.getInt("Item getRackId");
            RollNo = bundle.getString("Item getRollNo");
            QrCode = bundle.getString("Item getQrCode");
        }
    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Utilities.showLogcatMessage(" No Error");
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            for (int i = 0; i < Constants.rollList.size(); i++) {
                if (result.getContents() == null) {
                    Toast.makeText(this, "Cancelled", LENGTH_LONG).show();
                } else if (result.getContents().equals(Constants.rollList.get(i)) | result.getContents().equals(Constants.qrList.get(i))) {
                    text.setText("Matched Successfully Scan Again");
                    text.setTextColor(getResources().getColor(R.color.successColor));
                    c++;
                    Utilities.showLogcatMessage(" C++ "+c);
                    if(c==2){
                        submitToServer(Constants.rackIdList.get(i), Constants.detailsList.get(i));
                        text.setText("Matched Successfully ");
                        text.setTextColor(getResources().getColor(R.color.successColor));
                        c=0;
                    }

                    //Toast.makeText((Context)this, (CharSequence)("Scanned: " + result.getContents()), LENGTH_LONG).show();
                }else /*if(!result.getContents().equals(itemname))*/ {
                    c = 0;
                    text.setText(" Not Matched!!");
                    text.setTextColor(getResources().getColor(R.color.errorColor));
                    //submitToServer(4);
                    //Toast.makeText((Context)this, (CharSequence)("Scanned: " + result.getContents()), LENGTH_LONG).show();
                }
            }


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
                        Toast.makeText(GrayFebricQrActivity.this, response.body(), Toast.LENGTH_SHORT).show();
                        //   finish();
                        startActivity(new Intent(GrayFebricQrActivity.this, GaryFebricActivity.class));

                    } else {
                        Toast.makeText(GrayFebricQrActivity.this, "Invalid Credentials!", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(GrayFebricQrActivity.this, "Something went Wrong! Please try again later", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

                Toast.makeText(GrayFebricQrActivity.this, "Fail to connect " + t.toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(this, GrayFebricDetailsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
