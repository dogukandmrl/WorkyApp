package com.dogukandemirel.workshopapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class WorkShopAdapter extends RecyclerView.Adapter<WorkShopAdapter.WsViewHolder> {
    Context context;
    ArrayList<Workshops> workshopsArrayList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
    public WorkShopAdapter(Context context, ArrayList<Workshops> workshopsArrayList) {
        this.context = context;
        this.workshopsArrayList = workshopsArrayList;
    }

    @NonNull
    @Override
    public WsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new WsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull WsViewHolder holder, int position) {
        Workshops workshops = workshopsArrayList.get(position);
        holder.tvHeading.setText(workshops.heading);
        holder.titleImage.setImageResource(workshops.titleImage);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onItemClick(position);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return workshopsArrayList.size();
    }

    public static class WsViewHolder extends RecyclerView.ViewHolder {
        ShapeableImageView titleImage;
        TextView tvHeading;

        public WsViewHolder(@NonNull View itemView) {
            super(itemView);
            titleImage = itemView.findViewById(R.id.title_image);
            tvHeading = itemView.findViewById(R.id.tvHeading);
        }
    }
}
