package com.opus_bd.stockmanagement.Adapter.GrayFebric;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.opus_bd.stockmanagement.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RollListAdapter extends RecyclerView.Adapter<RollListAdapter.TransactionViewHolder> {
    private final Context context;
    private List<String> items;

    public RollListAdapter(List<String> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public TransactionViewHolder onCreateViewHolder(ViewGroup parent,
                                                    int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_roll_list, parent, false);
        return new TransactionViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TransactionViewHolder holder, int position) {
        String item = items.get(position);
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

        @BindView(R.id.tvString)
        TextView tvString;

        public TransactionViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void set(final String item) {
            //UI setting code

            tvString.setText(item);


        }


    }


}
