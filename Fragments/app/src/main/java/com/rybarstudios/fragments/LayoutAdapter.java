package com.rybarstudios.fragments;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class LayoutAdapter extends RecyclerView.Adapter<LayoutAdapter.ArrestViewHolder> {

   Context context;
   ArrayList<ArrestData> data;

    @NonNull
    @Override
    public ArrestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.nfl_arrest_item_list, parent, false);
        return new ArrestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArrestViewHolder arrestViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }

    class ArrestViewHolder extends RecyclerView.ViewHolder {
        View parentLayout;
        TextView arrestView;

        public ArrestViewHolder(@NonNull View itemView) {
            super(itemView);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            arrestView = itemView.findViewById(R.id.arrest_text_view);
        }
    }

}
