package com.lambdaschool.congressfragmentsproject.activity

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.lambdaschool.congressfragmentsproject.R
import com.lambdaschool.congressfragmentsproject.data.CongressDao
import com.lambdaschool.congressfragmentsproject.fragment.CongresspersonOverviewFragment
import com.lambdaschool.congressfragmentsproject.fragment.DetailsFragment
import com.lambdaschool.congressfragmentsproject.model.CongresspersonDetails
import com.lambdaschool.congressfragmentsproject.model.CongresspersonOverview
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity(), CongresspersonOverviewFragment.OnListFragmentInteractionListener {

    companion object {
        const val FRAGMENT_KEY = "098HF18672G4FPIJH"
    }

    override fun onListFragmentInteraction(item: CongresspersonOverview?) {

        val fragment = DetailsFragment()

        val bundle = Bundle()
        bundle.putSerializable(FRAGMENT_KEY, item?.id)
        fragment.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_activity_fragment_hodler, fragment)
            .addToBackStack(null)
            .commit()
    }

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
}