package com.opus_bd.stockmanagement.Activity.GrayFabric;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.opus_bd.stockmanagement.Activity.GrayFabric.FindLocation.FindLocationActivity;
import com.opus_bd.stockmanagement.Activity.GrayFabric.RackIn.GrayFebricRackInActivity;
import com.opus_bd.stockmanagement.Activity.GrayFabric.RackIn.QRActivity;
import com.opus_bd.stockmanagement.Activity.GrayFabric.Rackout.GrayfebricRackOutQrActivity;
import com.opus_bd.stockmanagement.Activity.ListActivity;
import com.opus_bd.stockmanagement.Activity.WareHouseActivity;
import com.opus_bd.stockmanagement.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GaryFebricActivity extends AppCompatActivity {
    @BindView(R.id.ivFinishedFebric)
    ImageView ivFinishedFebric;

    @BindView(R.id.ivGrayFebric)
    ImageView ivGrayFebric;
    @BindView(R.id.ivGrayFebricTrans)
    ImageView ivGrayFebricTrans;

    @BindView(R.id.findLocationIV)
    ImageView findLocationIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gary_febric);
        ButterKnife.bind(this);

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        ButterKnife.bind(this);
        imageload();
    }

    public void imageload() {
        Glide.with(this).load(R.drawable.ic_rackin).into(ivFinishedFebric);
        Glide.with(this).load(R.drawable.ic_rackout).into(ivGrayFebric);
        Glide.with(this).load(R.drawable.finised_febric).into(ivGrayFebricTrans);
        Glide.with(this).load(R.drawable.ic_find_location).into(findLocationIV);

    }

    @OnClick(R.id.btnScan)
    public void btnScan() {
        Intent intent = new Intent(GaryFebricActivity.this, QRActivity.class);
        startActivity(intent);

    }
    @OnClick(R.id.cvFinishedFebric)
    public void cvFinishedFebricOnclick() {
        Intent intent = new Intent(GaryFebricActivity.this, GrayFebricRackInActivity.class);
        startActivity(intent);
        finish();

    }

    @OnClick(R.id.cvGrayFebric)
    public void cvGrayFebricOnclick() {
        Intent intent = new Intent(GaryFebricActivity.this, GrayfebricRackOutQrActivity.class);
        startActivity(intent);
        finish();

    }

    @OnClick(R.id.btnFindLocation)
    public void btnFindLocationOnclick() {
        Intent intent = new Intent(GaryFebricActivity.this, FindLocationActivity.class);
        startActivity(intent);
        finish();

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

        Intent intent = new Intent(this, WareHouseActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
