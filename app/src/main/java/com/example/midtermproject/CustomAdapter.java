package com.example.midtermproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private ArrayList info_id, info_title, info_topic, info_pages;
    CustomAdapter(Context context,
                  ArrayList info_id,
                  ArrayList info_title,
                  ArrayList info_topic,
                  ArrayList info_pages){
        this.context = context;
        this.info_id = info_id;
        this.info_title = info_title;
        this.info_topic = info_topic;
        this.info_pages = info_pages;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.info_id_txt.setText(String.valueOf(info_id.get(position)));
        holder.info_title_txt.setText(String.valueOf(info_title.get(position)));
        holder.info_topic_txt.setText(String.valueOf(info_topic.get(position)));
        holder.info_pages_txt.setText(String.valueOf(info_pages.get(position)));
    }

    @Override
    public int getItemCount() {
        return info_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView info_id_txt, info_title_txt, info_topic_txt, info_pages_txt;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            info_id_txt = itemView.findViewById(R.id.info_id_txt);
            info_title_txt = itemView.findViewById(R.id.info_title_txt);
            info_topic_txt = itemView.findViewById(R.id.info_topic_txt);
            info_pages_txt = itemView.findViewById(R.id.info_pages_txt);
        }
    }
}
