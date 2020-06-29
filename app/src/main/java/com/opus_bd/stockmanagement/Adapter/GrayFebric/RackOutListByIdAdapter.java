package com.opus_bd.stockmanagement.Adapter.GrayFebric;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.opus_bd.stockmanagement.Activity.GrayFabric.Rackout.GrayfebricRackOutQrActivity;
import com.opus_bd.stockmanagement.Model.GrayFabric.RackOut.GrayFabricIssueDetail;
import com.opus_bd.stockmanagement.R;
import com.opus_bd.stockmanagement.Utilts.Utilities;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RackOutListByIdAdapter extends RecyclerView.Adapter<RackOutListByIdAdapter.TransactionViewHolder> {
    private final Context context;
    private List<GrayFabricIssueDetail> items;

    public RackOutListByIdAdapter(List<GrayFabricIssueDetail> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public TransactionViewHolder onCreateViewHolder(ViewGroup parent,
                                                    int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rackout_by_id_list, parent, false);
        return new TransactionViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TransactionViewHolder holder, int position) {
        GrayFabricIssueDetail item = items.get(position);
        holder.set(item);
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }

    public class TransactionViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvreceiveNo)
        TextView tvreceiveNo;
        @BindView(R.id.tvMaterial)
        TextView tvMaterial;
        @BindView(R.id.tvTotalQuantity)
        TextView tvTotalQuantity;
        @BindView(R.id.ivView)
        ImageView ivView;


        public TransactionViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void set(final GrayFabricIssueDetail item) {
            //UI setting code

            tvreceiveNo.setText(item.getGrayFebricsDetail().getRollNo());
            tvMaterial.setText(item.getGrayFebricsDetail().getMaterialNo());
            tvTotalQuantity.setText(String.valueOf(item.getGrayFebricsDetail().getGQTY()));


            final String rollno = item.getGrayFebricsDetail().getRollNo();
            final int id = item.getId();

            Utilities.showLogcatMessage("id" + rollno);
            ivView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, GrayfebricRackOutQrActivity.class);
                    intent.putExtra("Item getRollNo", rollno);
                    intent.putExtra("Item getId", id);
                    Utilities.showLogcatMessage(" Item getRollNo " + rollno);
                    context.startActivity(intent);
                }
            });


        }


    }


}
