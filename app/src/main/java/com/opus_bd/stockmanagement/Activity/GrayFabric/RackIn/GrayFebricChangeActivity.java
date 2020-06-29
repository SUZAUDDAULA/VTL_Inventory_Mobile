package com.opus_bd.stockmanagement.Activity.GrayFabric.RackIn;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.opus_bd.stockmanagement.Activity.GrayFabric.GaryFebricActivity;
import com.opus_bd.stockmanagement.R;
import com.opus_bd.stockmanagement.RetrofitService.RetrofitClientInstance;
import com.opus_bd.stockmanagement.RetrofitService.RetrofitService;
import com.opus_bd.stockmanagement.Utilts.SharedPrefManager;
import com.opus_bd.stockmanagement.Utilts.Utilities;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.widget.Toast.LENGTH_LONG;

public class GrayFebricChangeActivity extends AppCompatActivity {
    Button button_scan_qr_code;
    TextView text;
    int detailsid,rackID,c=0;
    String RollNo,QrCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gray_febric_change);
        button_scan_qr_code= findViewById(R.id.button_scan_qr_code);
        text= findViewById(R.id.text);
        button_scan_qr_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                (new IntentIntegrator((Activity) GrayFebricChangeActivity.this)).initiateScan();
            }
        });
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            detailsid = bundle.getInt("Item getDetailsId");
            rackID = bundle.getInt("Item getRackId");
            RollNo = bundle.getString("Item getRollNo");
           // QrCode = bundle.getString("Item getQrCode");
        }
    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText((Context)this, (CharSequence)"Cancelled", LENGTH_LONG).show();
            }/* else if(result.getContents().equals(RollNo)|result.getContents().equals(QrCode) ) {
                text.setText("Matched Successfully Scan Again");
                text.setTextColor(getResources().getColor(R.color.successColor));
                c++;
                Utilities.showLogcatMessage(" C++ "+c);
                if(c==2){
                    submitToServer(3);
                    text.setText("Matched Successfully ");
                    text.setTextColor(getResources().getColor(R.color.successColor));
                    c=0;
                }

                //Toast.makeText((Context)this, (CharSequence)("Scanned: " + result.getContents()), LENGTH_LONG).show();
            }*/else /*if(!result.getContents().equals(itemname))*/ {
                QrCode=result.getContents();
                Utilities.showLogcatMessage("QrCode "+QrCode);
                text.setText(" Successfully Scaned!!");
                text.setTextColor(getResources().getColor(R.color.successColor));
              submitToServer(4);
                //Toast.makeText((Context)this, (CharSequence)("Scanned: " + result.getContents()), LENGTH_LONG).show();
            }
        }

    }

    private void submitToServer(int status) {

        String token = SharedPrefManager.getInstance(this).getToken();

        RetrofitService retrofitService = RetrofitClientInstance.getRetrofitInstance().create(RetrofitService.class);
        Call<String> registrationRequest = retrofitService.UpdateGrayFabricReceiveStatusAndLocationAPI(SharedPrefManager.BEARER + token,detailsid,QrCode);
        registrationRequest.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                try {
                    if (response.body() != null) {
                        Toast.makeText(GrayFebricChangeActivity.this, response.body(), Toast.LENGTH_SHORT).show();
                        //   finish();
                        startActivity(new Intent(GrayFebricChangeActivity.this, GaryFebricActivity.class));

                    } else {
                        Toast.makeText(GrayFebricChangeActivity.this, "Invalid Credentials!", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(GrayFebricChangeActivity.this, "Something went Wrong! Please try again later", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

                Toast.makeText(GrayFebricChangeActivity.this, "Fail to connect " + t.toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
