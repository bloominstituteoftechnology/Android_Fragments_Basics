package com.vivekvishwanath.android_fragments_basics;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vivekvishwanath.android_fragments_basics.PokemonFragment.OnListFragmentInteractionListener;

import java.util.List;


public class MyPokemonRecyclerViewAdapter extends RecyclerView.Adapter<MyPokemonRecyclerViewAdapter.ViewHolder> {

    private final List<Pokemon> pokemonList;
    private final OnListFragmentInteractionListener mListener;

    public MyPokemonRecyclerViewAdapter(List<Pokemon> pokemonList, OnListFragmentInteractionListener listener) {
        this.pokemonList = pokemonList;
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
        holder.pokemon = pokemonList.get(position);
        holder.pokemonId.setText(pokemonList.get(position).getId());
        holder.pokemonName.setText(pokemonList.get(position).getName());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.pokemon);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView pokemonId;
        public final TextView pokemonName;
        public Pokemon pokemon;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            pokemonId = (TextView) view.findViewById(R.id.pokedex_id);
            pokemonName = (TextView) view.findViewById(R.id.pokemon_name);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + pokemonName.getText() + "'";
        }
    }
}
