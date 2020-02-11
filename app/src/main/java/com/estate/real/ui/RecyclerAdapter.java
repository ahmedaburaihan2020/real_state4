package com.estate.real.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.estate.real.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<Item> itemsList;
    private OnItemClickListener listener;

    public RecyclerAdapter(List<Item> itemsList){
        this.itemsList = itemsList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final Item item = itemsList.get(position);

        holder.tvName.setText(item.getName());
        holder.tvPrice.setText(item.getPrice());
        holder.tvPublisherName.setText(item.getPublisher());
        holder.tvTime.setText(item.getTime());
        holder.tvArea.setText(item.getArea());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(view, item, position);
            }
        });
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return itemsList == null ? 0 : itemsList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName, tvPrice, tvPublisherName, tvTime, tvArea;
        private ImageView ivThumbnail, ivPublisherLogo;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvItemName);
            tvPrice = itemView.findViewById(R.id.tvItemPrice);
            tvPublisherName = itemView.findViewById(R.id.tvItemPublisherName);
            tvTime = itemView.findViewById(R.id.tvTime);
            tvArea = itemView.findViewById(R.id.tvArea);

            ivThumbnail = itemView.findViewById(R.id.itemThumbnail);
            ivPublisherLogo = itemView.findViewById(R.id.itemPublisherLogo);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View v, Item item, int position);
    }
}
