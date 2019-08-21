package com.lambdaschool.congressfragmentsproject.adapter

import android.net.Uri
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.lambdaschool.congressfragmentsproject.R
import com.lambdaschool.congressfragmentsproject.fragment.CongresspersonOverviewFragment.OnListFragmentInteractionListener
import com.lambdaschool.congressfragmentsproject.model.CongresspersonOverview
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
        val image: ImageView = mView.iv_image
        val nameFull: TextView = mView.tv_name
        val partyAffiliation: TextView = mView.tv_party
        val missedVotesPercent: TextView = mView.tv_missed_votes
        val totalPresent: TextView = mView.tv_total_present
        val jobTitle: TextView = mView.tv_title
        val leadershipRole: TextView = mView.tv_leadership_role
        val seniority: TextView = mView.tv_seniority
        val inOffice: TextView = mView.tv_in_office
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
        val nameConstruction = "${item.lastName}, ${item.firstName} ${item.middleName}"
        val inOfficeString = inOfficeConverter(item.isInOffice)

        hodler.image.setImageURI(Uri.parse(item.apiUri))
        hodler.nameFull.text = nameConstruction
        hodler.partyAffiliation.text = item.party
        hodler.missedVotesPercent.text = item.missedVotesPct.toString()
        hodler.totalPresent.text = item.totalPresent.toString()
        hodler.jobTitle.text = item.title
        hodler.leadershipRole.text = item.leadershipRole
        hodler.seniority.text = item.seniority
        hodler.inOffice.text = inOfficeString

        with(hodler.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    private fun inOfficeConverter(data: Boolean): String {
        return when (data) {
            true -> "Is in Office"
            else -> "Is not in Office"
        }
    }
}
