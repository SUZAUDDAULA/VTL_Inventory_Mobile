package com.opus_bd.stockmanagement.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.opus_bd.stockmanagement.Activity.StockIn.CurrentFebricDetailsActivity;

import com.opus_bd.stockmanagement.Activity.StockOut.FinishFabricDetailsActivity;
import com.opus_bd.stockmanagement.Model.Stockout.GetFinishFabricListForIssue;
import com.opus_bd.stockmanagement.R;
import com.opus_bd.stockmanagement.Utilts.Utilities;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StockOutListAdapter extends RecyclerView.Adapter<StockOutListAdapter.TransactionViewHolder> {
    private final Context context;
    private List<GetFinishFabricListForIssue> items;

    public StockOutListAdapter(List<GetFinishFabricListForIssue> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public TransactionViewHolder onCreateViewHolder(ViewGroup parent,
                                                    int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_notice_list, parent, false);
        return new TransactionViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TransactionViewHolder holder, int position) {
        GetFinishFabricListForIssue item = items.get(position);
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
        @BindView(R.id.tvreceiveDate)
        TextView tvreceiveDate;  @BindView(R.id.tvreceiveBy)
        TextView tvreceiveBy;  @BindView(R.id.tvMonthName)
        TextView tvMonthName;
        @BindView(R.id.rootLayout)
        CardView rootLayout;


        public TransactionViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void set(final GetFinishFabricListForIssue item) {
            //UI setting code

            tvreceiveNo.setText(item.getReceiveNo());
            tvreceiveDate.setText(item.getReceiveDate());
            tvreceiveBy.setText(item.getReceiveBy());
            tvMonthName.setText(item.getMonthName());


            final int id = item.getId();

            Utilities.showLogcatMessage("id" + id);
            rootLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, FinishFabricDetailsActivity.class);
                    intent.putExtra("Item getId", id);
                    Utilities.showLogcatMessage(" Item Id " + id);
                    context.startActivity(intent);
                }
            });


        }


    }


}
