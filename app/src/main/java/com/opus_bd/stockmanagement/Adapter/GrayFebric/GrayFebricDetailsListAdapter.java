package com.opus_bd.stockmanagement.Adapter.GrayFebric;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.opus_bd.stockmanagement.Activity.GrayFabric.RackIn.GrayFebricChangeActivity;
import com.opus_bd.stockmanagement.Activity.GrayFabric.RackIn.GrayFebricQrActivity;
import com.opus_bd.stockmanagement.Model.GrayFabric.GrayFabricDetailsViewModel;
import com.opus_bd.stockmanagement.R;
import com.opus_bd.stockmanagement.Utilts.Utilities;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GrayFebricDetailsListAdapter extends RecyclerView.Adapter<GrayFebricDetailsListAdapter.TransactionViewHolder> {
    private final Context context;
    private List<GrayFabricDetailsViewModel> items;

    public GrayFebricDetailsListAdapter(List<GrayFabricDetailsViewModel> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public TransactionViewHolder onCreateViewHolder(ViewGroup parent,
                                                    int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_gray_details_list, parent, false);
        return new TransactionViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TransactionViewHolder holder, int position) {
        GrayFabricDetailsViewModel item = items.get(position);
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

        @BindView(R.id.tvRollNo)
        TextView tvRollNo;
        @BindView(R.id.tvLocation)
        TextView tvLocation;
        @BindView(R.id.tvQuantity)
        TextView tvQuantity;      @BindView(R.id.btnRackIn)
        Button btnRackIn; @BindView(R.id.btnChange)
        Button btnChange;

        @BindView(R.id.rootLayout)
        CardView rootLayout;


        public TransactionViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void set(final GrayFabricDetailsViewModel item) {
            //UI setting code

            tvRollNo.setText(item.getRollNo());
            tvLocation.setText(item.getLocation());
            tvQuantity.setText(String.valueOf(item.getgQTY()));
            //Glide.with(context).load(R.drawable.qrcode).into(ivqr);
           /* tvfebrics.setText(item.getFebrics());
            tvcolor.setText(item.getColor());
            tvfinishQTY.setText(String.valueOf(item.getFinishQTY()));
            tvtotalQTY.setText(String.valueOf(item.getTotalQTY()));
            tvtotalRoll.setText(String.valueOf(item.getTotalRoll()));*/

            final int id = item.getDetailsId();

            Utilities.showLogcatMessage("id" + id);
            btnRackIn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, GrayFebricQrActivity.class);
                    intent.putExtra("Item getRollNo", item.getRollNo());
                    intent.putExtra("Item getQrCode", item.getQrCode());
                    intent.putExtra("Item getRackId", item.getRackId());
                    intent.putExtra("Item getDetailsId", item.getDetailsId());
                   // intent.putExtra("Item cellID", item.getCellNo());
                    // intent.putExtra("Item getAttachUrl", getAttachUrl());
                    Utilities.showLogcatMessage(" Item getRackId " + item.getRackId());
                    // Utilities.showLogcatMessage(" Item  "+getAttachUrl());
                    context.startActivity(intent);
                }
            });    btnChange.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, GrayFebricChangeActivity.class);
                    intent.putExtra("Item getRollNo", item.getRollNo());
                    intent.putExtra("Item getQrCode", item.getQrCode());
                    intent.putExtra("Item getRackId", item.getRackId());
                    intent.putExtra("Item getDetailsId", item.getDetailsId());
                   // intent.putExtra("Item cellID", item.getCellNo());
                    // intent.putExtra("Item getAttachUrl", getAttachUrl());
                    Utilities.showLogcatMessage(" Item getRackId " + item.getRackId());
                    // Utilities.showLogcatMessage(" Item  "+getAttachUrl());
                    context.startActivity(intent);
                }
            });


        }


    }


}
