package com.opus_bd.stockmanagement.Adapter.GrayFebric;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.opus_bd.stockmanagement.Activity.GrayFabric.RackIn.GrayFebricDetailsActivity;
import com.opus_bd.stockmanagement.Model.GrayFabric.ReceivedGrayFabric;
import com.opus_bd.stockmanagement.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReceivedGrayFabricListAdapter extends RecyclerView.Adapter<ReceivedGrayFabricListAdapter.TransactionViewHolder> {
    private final Context context;
    private List<ReceivedGrayFabric> items;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    String url;

    public String getAttachUrl() {
        return attachUrl;
    }

    public void setAttachUrl(String attachUrl) {
        this.attachUrl = attachUrl;
    }

    String attachUrl;

    public ReceivedGrayFabricListAdapter(List<ReceivedGrayFabric> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public TransactionViewHolder onCreateViewHolder(ViewGroup parent,
                                                    int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_receive_gray_febric, parent, false);
        return new TransactionViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TransactionViewHolder holder, int position) {
        ReceivedGrayFabric item = items.get(position);
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
        @BindView(R.id.tvTotalRoll)
        TextView tvTotalRoll;
        @BindView(R.id.tvTotalQuantity)
        TextView tvTotalQuantity;
        @BindView(R.id.tvStatus)
        TextView tvStatus;
        @BindView(R.id.rootLayout)
        CardView rootLayout;      @BindView(R.id.ivView)
        ImageView ivView;


        public TransactionViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void set(final ReceivedGrayFabric item) {
            //UI setting code

            tvreceiveNo.setText(item.getReceiveNo());
            tvTotalRoll.setText(String.valueOf(item.getTotalRoll()));
            tvTotalQuantity.setText(String.valueOf(item.getTotalQTY()));
            tvStatus.setText(item.getStatus());

            final int id = item.getId();

            //getPDF(id);

            ivView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, GrayFebricDetailsActivity.class);
                    intent.putExtra("Item getId", id);
                    // intent.putExtra("Item getAttachUrl", getAttachUrl());
                    context.startActivity(intent);
                }
            });


        }


    }


}
