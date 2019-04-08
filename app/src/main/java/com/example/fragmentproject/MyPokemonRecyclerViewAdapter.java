package com.example.fragmentproject;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fragmentproject.PokemonFragment.OnListFragmentInteractionListener;

import java.util.List;

public class MyPokemonRecyclerViewAdapter extends RecyclerView.Adapter<MyPokemonRecyclerViewAdapter.ViewHolder> {

    private final List<Pokemon> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyPokemonRecyclerViewAdapter(List<Pokemon> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_pokemon, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.mIdView.setText(mValues.get(position).getName());
        holder.mItem = mValues.get(position);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //TODO: and fix this shitt
        public final View mView;
        public final TextView mIdView;
        public Pokemon mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = view.findViewById(R.id.pokemon_name);
        }
    }
}
