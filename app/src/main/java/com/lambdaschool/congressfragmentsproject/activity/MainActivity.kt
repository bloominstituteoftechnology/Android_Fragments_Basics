package com.lambdaschool.congressfragmentsproject.activity

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.lambdaschool.congressfragmentsproject.R
import com.lambdaschool.congressfragmentsproject.data.CongressDao
import com.lambdaschool.congressfragmentsproject.fragment.CongresspersonOverviewFragment
import com.lambdaschool.congressfragmentsproject.model.CongresspersonDetails
import com.lambdaschool.congressfragmentsproject.model.CongresspersonOverview
import java.util.ArrayList

class MainActivity : AppCompatActivity(), CongresspersonOverviewFragment.OnListFragmentInteractionListener {
    override fun onListFragmentInteraction(item: CongresspersonOverview?) {
        Toast.makeText(this, "MainActivity fragment", Toast.LENGTH_SHORT).show()
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