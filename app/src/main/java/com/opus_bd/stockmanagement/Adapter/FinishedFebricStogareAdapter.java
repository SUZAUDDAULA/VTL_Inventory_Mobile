package com.opus_bd.stockmanagement.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.opus_bd.stockmanagement.Activity.MainActivity;
import com.opus_bd.stockmanagement.Model.FinishFabricStorageByRecevedNo;
import com.opus_bd.stockmanagement.R;
import com.opus_bd.stockmanagement.Utilts.Utilities;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FinishedFebricStogareAdapter extends RecyclerView.Adapter<FinishedFebricStogareAdapter.TransactionViewHolder> {
    private final Context context;
    private List<FinishFabricStorageByRecevedNo> items;

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
    public FinishedFebricStogareAdapter(List<FinishFabricStorageByRecevedNo> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public TransactionViewHolder onCreateViewHolder(ViewGroup parent,
                                                    int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recived_febric_list, parent, false);
        return new TransactionViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TransactionViewHolder holder, int position) {
        FinishFabricStorageByRecevedNo item = items.get(position);
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

        @BindView(R.id.tvTitle)
        TextView tvTitle;
        @BindView(R.id.tvNoticeType)
        TextView tvNoticeType;  @BindView(R.id.tvCellno)
        TextView tvCellno;  @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.rootLayout)
        CardView rootLayout;


        public TransactionViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void set(final FinishFabricStorageByRecevedNo item) {
            //UI setting code

            tvTitle.setText("Rack Id : "+String.valueOf(item.getRackId()));
            tvNoticeType.setText("Receive No : "+item.getReceiveNo());
            tvCellno.setText("Cell No : "+item.getCellNo());

            try{
                if(item.getStatusId()==3){
                    image.setVisibility(View.GONE);
                }
                else{
                    image.setVisibility(View.VISIBLE);
                    Glide.with(context).load(R.drawable.qrcode).into(image);
                }
            }
            catch (Exception e){}


            final int id = item.getId();

            //getPDF(id);

            Utilities.showLogcatMessage("id" + id);
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                           Intent intent = new Intent(context, MainActivity.class);
                    intent.putExtra("Item getId", id);
                    intent.putExtra("Item racID", item.getRackId());
                    intent.putExtra("Item cellID", item.getCellNo());
                    // intent.putExtra("Item getAttachUrl", getAttachUrl());
                    Utilities.showLogcatMessage(" Item Id " + id);
                    // Utilities.showLogcatMessage(" Item  "+getAttachUrl());
                    context.startActivity(intent);
                }
            });


        }


    }


}
