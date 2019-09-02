package com.lambdaschool.congressfragmentsproject.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.lambdaschool.congressfragmentsproject.R
import com.lambdaschool.congressfragmentsproject.fragment.CongresspersonOverviewFragment.OnListFragmentInteractionListener
import com.lambdaschool.congressfragmentsproject.model.CongresspersonOverview
import com.lambdaschool.congressfragmentsproject.util.CongresspersonStringConstruction
import kotlinx.android.synthetic.main.fragment_congresspersonoverview2.view.*

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class MyCongresspersonOverviewRecyclerViewAdapter(
    private val mValues: List<CongresspersonOverview>,
    private val mListener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<MyCongresspersonOverviewRecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val nameFull: TextView = mView.tv_name
        val partyAffiliationState: TextView = mView.tv_party
        val missedVotesPercent: TextView = mView.tv_missed_votes
        val totalPresent: TextView = mView.tv_total_present
    }

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as CongresspersonOverview
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_congresspersonoverview2, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = mValues.size

    override fun onBindViewHolder(hodler: ViewHolder, position: Int) {
        val item = mValues[position]

        hodler.nameFull.text = CongresspersonStringConstruction.nameConstruction(item.firstName, item.middleName, item.lastName)
        hodler.partyAffiliationState.text = CongresspersonStringConstruction.partyStateConstruction(item.party, item.state)
        hodler.missedVotesPercent.text = CongresspersonStringConstruction.votesMissedConstruction(item.missedVotesPct)
        hodler.totalPresent.text = item.totalPresent.toString()

        hodler.mView.setOnClickListener {
            if (mListener != null) {
                mListener.onListFragmentInteraction(mValues[position])
            }
        }
    }
}
