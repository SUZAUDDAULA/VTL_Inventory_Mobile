package com.opus_bd.stockmanagement.Activity.RackOut;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.opus_bd.stockmanagement.Adapter.NoticeListAdapter;
import com.opus_bd.stockmanagement.Adapter.RecivedFinishListAdapter;
import com.opus_bd.stockmanagement.Model.FinishFebricsMaster;
import com.opus_bd.stockmanagement.Model.ReveivedFinishFabric;
import com.opus_bd.stockmanagement.R;

import java.util.ArrayList;

import butterknife.BindView;

public class RackOutListActivity extends AppCompatActivity {
    @BindView(R.id.rvNotice)
    RecyclerView rvNotice;

    NoticeListAdapter noticeListAdapter;
    private ArrayList<FinishFebricsMaster> noticeArrayList = new ArrayList<>();  @BindView(R.id.rvRecived)
    RecyclerView rvRecived;

    RecivedFinishListAdapter recivedFinishListAdapter;
    private ArrayList<ReveivedFinishFabric> reveivedFinishFabrics = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rack_out_list);
    }
}
