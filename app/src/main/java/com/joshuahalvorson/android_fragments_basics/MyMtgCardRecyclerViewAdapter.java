package com.joshuahalvorson.android_fragments_basics;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.joshuahalvorson.android_fragments_basics.MtgCardFragment.OnListFragmentInteractionListener;
import java.util.List;


public class MyMtgCardRecyclerViewAdapter extends RecyclerView.Adapter<MyMtgCardRecyclerViewAdapter.ViewHolder> {

    private final List<MtgCard> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyMtgCardRecyclerViewAdapter(List<MtgCard> mtgCards, OnListFragmentInteractionListener listener) {
        mValues = mtgCards;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_mtgcard, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        //set image
        //holder.cardImage.setText(mValues.get(position).id);
        holder.cardContent.setText(mValues.get(position).getText());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
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
        public final View mView;
        public final ImageView cardImage;
        public final TextView cardContent;
        public MtgCard mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            cardImage = view.findViewById(R.id.card_image);
            cardContent = view.findViewById(R.id.card_content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + cardContent.getText() + "'";
        }
    }
}
