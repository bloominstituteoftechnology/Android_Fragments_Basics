package com.example.fragmentdemo;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyTrumpQuoteRecyclerViewAdapter extends RecyclerView.Adapter<MyTrumpQuoteRecyclerViewAdapter.ViewHolder> {

    private ArrayList<TrumpQuote> listItems;
    private TrumpQuoteFragment.OnListFragmentInteractionListener listener;

    public MyTrumpQuoteRecyclerViewAdapter(ArrayList<TrumpQuote> listItems, TrumpQuoteFragment.OnListFragmentInteractionListener listener) {
        this.listItems = listItems;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(
                LayoutInflater
                        .from(viewGroup.getContext())
                        .inflate(
                                R.layout.fragment_trumpquote,
                                viewGroup,
                                false
                        )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final TrumpQuote trumpQuote = listItems.get(i);

        viewHolder.spaceImageItemNameText.setText(trumpQuote.getQuote());

        viewHolder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null){
                    //              listener.onFragmentInteraction(spaceImageListItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private ConstraintLayout parent;
        private TextView spaceImageItemNameText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            spaceImageItemNameText = itemView.findViewById(R.id.content);
        }
    }
}
