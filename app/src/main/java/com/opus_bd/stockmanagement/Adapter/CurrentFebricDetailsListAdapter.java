package com.opus_bd.stockmanagement.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.opus_bd.stockmanagement.Activity.StockIn.List3Activity;
import com.opus_bd.stockmanagement.Model.CurrentFebricDetails;
import com.opus_bd.stockmanagement.R;
import com.opus_bd.stockmanagement.Utilts.Utilities;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CurrentFebricDetailsListAdapter extends RecyclerView.Adapter<CurrentFebricDetailsListAdapter.TransactionViewHolder> {
    private final Context context;
    private List<CurrentFebricDetails> items;

    public CurrentFebricDetailsListAdapter(List<CurrentFebricDetails> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public TransactionViewHolder onCreateViewHolder(ViewGroup parent,
                                                    int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_current_febric_details, parent, false);
        return new TransactionViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TransactionViewHolder holder, int position) {
        CurrentFebricDetails item = items.get(position);
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

        @BindView(R.id.tvorderNo)
        TextView tvorderNo;
        @BindView(R.id.tvitemName)
        TextView tvitemName;
        @BindView(R.id.tvfebrics)
        TextView tvfebrics;
        @BindView(R.id.tvbuyerName)
        TextView tvbuyerName;
        @BindView(R.id.tvcolor)
        TextView tvcolor;
        @BindView(R.id.tvfinishQTY)
        TextView tvfinishQTY;
        @BindView(R.id.tvtotalQTY)
        TextView tvtotalQTY;
        @BindView(R.id.tvtotalRoll)
        TextView tvtotalRoll;
        @BindView(R.id.rootLayout)
        CardView rootLayout;


        public TransactionViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void set(final CurrentFebricDetails item) {
            //UI setting code

            tvorderNo.setText(item.getOrderNo());
            tvitemName.setText(item.getItemName());
            tvbuyerName.setText(item.getBuyerName());
            tvfebrics.setText(item.getFebrics());
            tvcolor.setText(item.getColor());
            tvfinishQTY.setText(String.valueOf(item.getFinishQTY()));
            tvtotalQTY.setText(String.valueOf(item.getTotalQTY()));
            tvtotalRoll.setText(String.valueOf(item.getTotalRoll()));

            final int id = item.getDetailsId();

            Utilities.showLogcatMessage("id" + id);
            rootLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, List3Activity.class);
                    intent.putExtra("Item getId", id);
                    Utilities.showLogcatMessage(" Item Id " + id);
                    context.startActivity(intent);
                }
            });


        }


    }


}
