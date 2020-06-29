package com.opus_bd.stockmanagement.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.opus_bd.stockmanagement.Model.DashBoard.AllStorageDetailsInfo;
import com.opus_bd.stockmanagement.R;
import com.opus_bd.stockmanagement.Utilts.Utilities;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AllStorageDetailsInfoListAdapter extends RecyclerView.Adapter<AllStorageDetailsInfoListAdapter.TransactionViewHolder> {
    private final Context context;
    private List<AllStorageDetailsInfo> items;
    Double i, j;
    int k,l;

    public AllStorageDetailsInfoListAdapter(List<AllStorageDetailsInfo> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public TransactionViewHolder onCreateViewHolder(ViewGroup parent,
                                                    int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_all_storage_list, parent, false);
        return new TransactionViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TransactionViewHolder holder, int position) {
        AllStorageDetailsInfo item = items.get(position);
        holder.set(item);
        if(item.getExistingQTY()!=null  )
        {
            i = ((item.getMaxCapacity()- item.getExistingQTY())*150/item.getMaxCapacity());
            j = (item.getExistingQTY())*150/item.getMaxCapacity();
             k=i.intValue();
             l=j.intValue();
            holder.tvEmptyQty.setHeight(k);
            holder.tvExixtingQty.setHeight(l);
           if(item.getMaxCapacity().intValue()==item.getExistingQTY().intValue()){
                holder.tvEmptyQty.setVisibility(View.GONE);
               Utilities.showLogcatMessage(" Color 1");
                holder.tvExixtingQty.setBackgroundColor(context.getResources().getColor(R.color.errorColor));

            }
            else
            {
                Utilities.showLogcatMessage(" Color ");
                holder.tvEmptyQty.setVisibility(View.VISIBLE);
                holder.tvExixtingQty.setBackgroundColor(context.getResources().getColor(R.color.color_sales));
                holder.tvEmptyQty.setBackgroundColor(context.getResources().getColor(R.color.blue_grey_200));
            }

        }



    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }

    public class TransactionViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvRackNo)
        TextView tvRackNo;
        @BindView(R.id.tvEmptyQty)
        TextView tvEmptyQty;
        @BindView(R.id.tvExixtingQty)
        TextView tvExixtingQty;
        @BindView(R.id.ll1)
        LinearLayout ll1;


        public TransactionViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

        public void set(final AllStorageDetailsInfo item) {
            //UI setting code

           /* try {
                int i = Integer.parseInt(String.valueOf(item.getMaxCapacity() - item.getExistingQTY()));
                int j = Integer.parseInt(String.valueOf(item.getExistingQTY()));
                tvEmptyQty.setHeight(200);
                tvExixtingQty.setHeight(100);
            } catch (Exception e) {
            }*/
/* if(item.getMaxCapacity()==item.getExistingQTY()){
         ll1.setBackgroundColor(context.getResources().getColor(R.color.errorColor));

        }
        else
        if (item.getExistingQTY() == null) {
            ll1.setBackgroundColor(context.getResources().getColor(R.color.colorWhite));
            tvExixtingQty.setVisibility(View.GONE);
        } else {
        }*/
            tvRackNo.setText(item.getCellNo());
            try {
                tvEmptyQty.setText(String.valueOf(item.getMaxCapacity() - item.getExistingQTY()));
                tvExixtingQty.setText(String.valueOf(item.getExistingQTY()));
            } catch (Exception e) {
            }


            final int id = item.getId();

            Utilities.showLogcatMessage("id" + id);


        }


    }


}
