package com.opus_bd.stockmanagement.Activity.GrayFabric.RackIn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.opus_bd.stockmanagement.Activity.GrayFabric.GaryFebricActivity;
import com.opus_bd.stockmanagement.Activity.LoginActivity;
import com.opus_bd.stockmanagement.Activity.StockIn.List2Activity;
import com.opus_bd.stockmanagement.Adapter.GrayFebric.RollListAdapter;
import com.opus_bd.stockmanagement.Model.GrayFabric.MultipleRollRackInModel;
import com.opus_bd.stockmanagement.Model.GrayFabric.Roll;
import com.opus_bd.stockmanagement.Model.GrayFabric.Scan.GrayRollDetailInfo;
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

import static android.widget.Toast.LENGTH_LONG;

public class QRActivity extends AppCompatActivity {
    public int counterRoll = 0, counterCell = 0, btncode;
    @BindView(R.id.buttonScanRoll)
    Button buttonScanRoll;
    @BindView(R.id.buttonScanQRCode)
    Button buttonScanQRCode;
    int c = 0, rackid, detailsid;
    String qr;
    ArrayList<String> rollList = new ArrayList<String>();
    ArrayList<String> cellList = new ArrayList<String>();
    ArrayList<Roll> rollArrayList = new ArrayList<>();
    ArrayList<Roll> cellLocationArrayList = new ArrayList<>();

    List<GrayRollDetailInfo> grayRollDetailInfoList = new ArrayList<>();

    RollListAdapter rollListAdapter;
    @BindView(R.id.rvRoll)
    RecyclerView rvRoll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_r);
        ButterKnife.bind(this);

        buttonScanRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btncode = 1;
                try {
                    (new IntentIntegrator(QRActivity.this)).initiateScan();
                } catch (Exception e) {
                    Utilities.showLogcatMessage(" No Error e   =  " + e.toString());
                }

            }
        });
        buttonScanQRCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btncode = 2;
                try {
                    (new IntentIntegrator(QRActivity.this)).initiateScan();
                } catch (Exception e) {
                    Utilities.showLogcatMessage(" No Error e   =  " + e.toString());
                }

            }
        });


        rollListAdapter = new RollListAdapter(rollList, this);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this);
        rvRoll.setLayoutManager(layoutManager1);
        rvRoll.setAdapter(rollListAdapter);

    }


    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Utilities.showLogcatMessage(" No Error");

        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "Cancelled", LENGTH_LONG).show();
            } else {
                if (btncode == 1) {
                    GetGrayRollDetailInfo(result.getContents());
                } else {
                    submitToServer(result.getContents());
                }


            }
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
                            Addroll(id);
                            Roll roll1 = new Roll();
                            roll1.setDetailsId(response.body().getGrayFebricsDetailId());
                            if (response.body().getGrayFebricsStorageDetail().getCellNo()!=null){
                                rollArrayList.add(rollArrayList.size(), roll1);
                            }
                            qr = response.body().getGrayFebricsStorageDetail().getQrCode();
                            rackid = response.body().getId();
                            detailsid = response.body().getGrayFebricsDetailId();

                            grayRollDetailInfoList.add(response.body());
                            rollListAdapter.setGrayRollDetailInfoList(grayRollDetailInfoList);

                        } else {
                            Toasty.error(QRActivity.this, "Not Found", Toast.LENGTH_SHORT).show();
//                            Intent intent = new Intent(QRActivity.this, List2Activity.class);
//                            startActivity(intent);
//                            finish();
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

    private void submitToServer(String rack) {

        String token = SharedPrefManager.getInstance(this).getToken();
        MultipleRollRackInModel multipleRollRackInModel = new MultipleRollRackInModel();
        multipleRollRackInModel.setQrCode(rack);
        multipleRollRackInModel.setRolls(rollArrayList);

        RetrofitService retrofitService = RetrofitClientInstance.getRetrofitInstance().create(RetrofitService.class);
        Call<String> registrationRequest = retrofitService.UpdateGrayFabricMultipleRollRackIn(SharedPrefManager.BEARER + token, multipleRollRackInModel);
        registrationRequest.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                try {
                    if (response.body() != null) {
                        Toast.makeText(QRActivity.this, response.body(), Toast.LENGTH_SHORT).show();
                        //   finish();
                        startActivity(new Intent(QRActivity.this, GaryFebricActivity.class));

                    } else {
                        Toast.makeText(QRActivity.this, "Invalid Credentials!", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(QRActivity.this, "Something went Wrong! Please try again later", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

                Toast.makeText(QRActivity.this, "Fail to connect " + t.toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }


    @Override
    public void onBackPressed() {

        Intent intent = new Intent(this, GaryFebricActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }


    public void Addroll(String rollNO) {
        counterRoll++;

        try {
            rollList.add(counterRoll + ". " + rollNO);
            rollListAdapter.notifyDataSetChanged();

            for (int i = 0; i < rollList.size(); i++) {
                Utilities.showLogcatMessage("notifyDataSetChanged " + rollList.get(i));
            }
        } catch (Exception e) {
            Utilities.showLogcatMessage("notifyDataSetChanged " + e.toString());
        }


    }

//    public void AddCellLocation(String cellNo) {
//        counterCell++;
//
//        try {
//            cellList.add(counterCell + ". " + cellNo);
//            rollListAdapter.notifyDataSetChanged();
//
//            for (int i = 0; i < cellList.size(); i++) {
//                Utilities.showLogcatMessage("notifyDataSetChanged " + cellList.get(i));
//            }
//        } catch (Exception e) {
//            Utilities.showLogcatMessage("notifyDataSetChanged " + e.toString());
//        }
//
//
//    }


}
