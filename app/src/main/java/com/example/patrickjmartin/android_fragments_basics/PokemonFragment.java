package com.example.patrickjmartin.android_fragments_basics;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.patrickjmartin.android_fragments_basics.PokemonAPI.Pokemon;
import com.example.patrickjmartin.android_fragments_basics.PokemonAPI.PokemonDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class PokemonFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    static ArrayList<Pokemon> pokemonArrayList;
    public static MyPokemonRecyclerViewAdapter adapter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public PokemonFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static PokemonFragment newInstance(int columnCount) {
        PokemonFragment fragment = new PokemonFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        new Thread(new Runnable() {
            @Override
            public void run() {
                final Pokemon pokemon1 = PokemonDAO.getPokemon(25);
                final Pokemon pokemon2 = PokemonDAO.getPokemon(50);
                final Pokemon pokemon3 = PokemonDAO.getPokemon(75);
                final Pokemon pokemon4 = PokemonDAO.getPokemon(100);
                final Pokemon pokemon5 = PokemonDAO.getPokemon(150);
                final Pokemon pokemon6 = PokemonDAO.getPokemon(200);
                final Pokemon pokemon7 = PokemonDAO.getPokemon(250);
                final Pokemon pokemon8 = PokemonDAO.getPokemon(300);
                final Pokemon pokemon9 = PokemonDAO.getPokemon(400);
                final Pokemon pokemon10 = PokemonDAO.getPokemon(500);
                final Pokemon pokemon11 = PokemonDAO.getPokemon(600);
                final Pokemon pokemon12 = PokemonDAO.getPokemon(700);

                pokemonArrayList.add(pokemon1);
                pokemonArrayList.add(pokemon2);
                pokemonArrayList.add(pokemon3);
                pokemonArrayList.add(pokemon4);
                pokemonArrayList.add(pokemon5);
                pokemonArrayList.add(pokemon6);
                pokemonArrayList.add(pokemon7);
                pokemonArrayList.add(pokemon8);
                pokemonArrayList.add(pokemon9);
                pokemonArrayList.add(pokemon10);
                pokemonArrayList.add(pokemon11);
                pokemonArrayList.add(pokemon12);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        }).start();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pokemon_list, container, false);
        pokemonArrayList = new ArrayList<Pokemon>();

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            adapter = new MyPokemonRecyclerViewAdapter(getActivity(), pokemonArrayList, mListener);
            recyclerView.setAdapter(adapter);


        }
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Pokemon item);
    }
}
