package com.earthdefensesystem.android_fragments_basics;

import android.content.Context;
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

import com.earthdefensesystem.android_fragments_basics.dummy.DummyContent;
import com.earthdefensesystem.android_fragments_basics.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class ComicFragmentFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    static ArrayList<Comic> comicArrayList;
    MyComicFragmentRecyclerViewAdapter adapter;
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ComicFragmentFragment() {
    }

    // TODO: Customize parameter initialization
    public static ComicFragmentFragment newInstance(int columnCount) {
        ComicFragmentFragment fragment = new ComicFragmentFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        comicArrayList = new ArrayList<Comic>();
        View view = inflater.inflate(R.layout.fragment_comicfragment_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            adapter = new MyComicFragmentRecyclerViewAdapter(comicArrayList, mListener, getActivity());
            recyclerView.setAdapter(adapter);
        }
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        new Thread(new Runnable() {
            @Override
            public void run() {
                final Comic comic1 = ComicDao.getComic(1);
                final Comic comic2 = ComicDao.getComic(2);
                final Comic comic3 = ComicDao.getComic(3);
                final Comic comic4 = ComicDao.getComic(4);
                final Comic comic5 = ComicDao.getComic(5);
                final Comic comic6 = ComicDao.getComic(6);
                final Comic comic7 = ComicDao.getComic(7);
                final Comic comic8 = ComicDao.getComic(8);
                final Comic comic9 = ComicDao.getComic(9);


                comicArrayList.add(comic1);
                comicArrayList.add(comic2);
                comicArrayList.add(comic3);
                comicArrayList.add(comic4);
                comicArrayList.add(comic5);
                comicArrayList.add(comic6);
                comicArrayList.add(comic7);
                comicArrayList.add(comic8);
                comicArrayList.add(comic9);

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
        void onListFragmentInteraction(Comic item);
    }
}
