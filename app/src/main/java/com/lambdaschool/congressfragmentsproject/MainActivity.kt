package com.lambdaschool.congressfragmentsproject

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lambdaschool.congressfragmentsproject.api.CongressDao
import com.lambdaschool.congressfragmentsproject.api.CongresspersonDetails
import com.lambdaschool.congressfragmentsproject.api.CongresspersonOverview
import java.util.ArrayList

class MainActivity : AppCompatActivity(), CongresspersonOverviewFragment.OnListFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get an overview list for all members of congress
        val allMembers: ArrayList<CongresspersonOverview> = CongressDao.allMembers

        // get details for a single member of congress
        val singleMemberDetails: CongresspersonDetails? = allMembers[0].id?.let { CongressDao.getMemberDetails(it) }

        // get congressperson portrait
        val image: Bitmap? = allMembers[0].id?.let { CongressDao.getImage(it) }
    }

    override fun onListFragmentInteraction(item: CongresspersonOverview?) {
        val detailsFragment = DetailsFragment()
        val bundle = Bundle()
        bundle.putSerializable("item_key", item?.id)
        detailsFragment.arguments = bundle
        getSupportFragmentManager().beginTransaction().replace(R.layout.fragment_details, detailsFragment).commit()

    }
}
