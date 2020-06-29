package com.opus_bd.stockmanagement.Adapter.GrayFebric;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.opus_bd.stockmanagement.Activity.GrayFabric.Rackout.GrayFebricRackoutbyidActivity;
import com.opus_bd.stockmanagement.Model.GrayFabric.RackOut.GrayFabricIssueMaster;
import com.opus_bd.stockmanagement.R;
import com.opus_bd.stockmanagement.Utilts.Utilities;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RackOutListAdapter extends RecyclerView.Adapter<RackOutListAdapter.TransactionViewHolder> {
    private final Context context;
    private List<GrayFabricIssueMaster> items;

    public RackOutListAdapter(List<GrayFabricIssueMaster> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public TransactionViewHolder onCreateViewHolder(ViewGroup parent,
                                                    int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rackout_list, parent, false);
        return new TransactionViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TransactionViewHolder holder, int position) {
        GrayFabricIssueMaster item = items.get(position);
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
        TextView tvreceiveDate;
        @BindView(R.id.tvreceiveBy)
        TextView tvreceiveBy;
        @BindView(R.id.tvMonthName)
        TextView tvMonthName;
        @BindView(R.id.rootLayout)
        CardView rootLayout;


        public TransactionViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void set(final GrayFabricIssueMaster item) {
            //UI setting code

            tvreceiveNo.setText(item.getIssueNo());
            tvreceiveDate.setText(item.getIssueBy());
            tvreceiveBy.setText(String.valueOf(item.getTotalQTY()));
            tvMonthName.setText(String.valueOf(item.getTotalRoll()));


            final int id = item.getId();

            Utilities.showLogcatMessage("id" + id);
            rootLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, GrayFebricRackoutbyidActivity.class);
                    intent.putExtra("Item getId", id);
                    Utilities.showLogcatMessage(" Item Id " + id);
                    context.startActivity(intent);
                }
            });


        }


    }


}
