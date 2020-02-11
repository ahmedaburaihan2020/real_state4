package com.estate.real.ui;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.estate.real.R;

import java.util.List;

public class MessagesListAdapter extends RecyclerView.Adapter<MessagesListAdapter.ViewHolder> {
    private List<ChatItemObject> itemList;
    private Context context;
    private ItemClickListener clickListener;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title_tv, message_tv, date_tv;
        ImageView profImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title_tv = itemView.findViewById(R.id.message_title);
            message_tv = itemView.findViewById(R.id.message_text);
            profImage = itemView.findViewById(R.id.message_image);
            date_tv = itemView.findViewById(R.id.date_textview);
        }
    }


    public  MessagesListAdapter(Context context, List<ChatItemObject> itemList) {

        this.itemList = itemList;
        this.context = context;
    }

    @NonNull
    @Override
    public MessagesListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_listitems,parent,false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MessagesListAdapter.ViewHolder holder, final int position) {
        holder.title_tv.setText(itemList.get(position).getTitle());
        holder.message_tv.setText(itemList.get(position).getMessage());
        holder.profImage.setImageResource(itemList.get(position).getPhoto());
        holder.date_tv.setText(itemList.get(position).getDate());

        holder.profImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clickListener != null) clickListener.itemClick(v, position);
            }
        });
        holder.profImage.setTag(holder);
    }

    public void setClickListener(ItemClickListener itemClickListener){
        this.clickListener = itemClickListener;
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    public interface  ItemClickListener {
        public void itemClick(View view, int position);
    }
}
