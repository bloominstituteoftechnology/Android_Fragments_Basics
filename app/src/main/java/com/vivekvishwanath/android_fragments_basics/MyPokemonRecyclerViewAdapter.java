package com.vivekvishwanath.android_fragments_basics;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vivekvishwanath.android_fragments_basics.PokemonListFragment.OnPokemonListFragmentInteractionListener;

import java.util.List;


public class MyPokemonRecyclerViewAdapter extends RecyclerView.Adapter<MyPokemonRecyclerViewAdapter.ViewHolder> {

    private final List<Pokemon> pokemonList;
    private final PokemonListFragment.OnPokemonListFragmentInteractionListener mListener;

    public MyPokemonRecyclerViewAdapter(List<Pokemon> pokemonList, OnPokemonListFragmentInteractionListener listener) {
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
        final Pokemon pokemon = pokemonList.get(position);
        holder.pokemonId.setText(Integer.toString(pokemon.getId()));
        holder.pokemonName.setText(pokemon.getName());

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.OnPokemonListFragmentInteractionListener(pokemon);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView pokemonId;
        private TextView pokemonName;
        private LinearLayout parent;

        public ViewHolder(View view) {
            super(view);
            pokemonId = view.findViewById(R.id.pokedex_id);
            pokemonName = view.findViewById(R.id.pokemon_name);
            parent = view.findViewById(R.id.parent);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + pokemonName.getText() + "'";
        }
    }
}
