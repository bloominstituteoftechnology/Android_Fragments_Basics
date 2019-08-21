package com.lambdaschool.congressfragmentsproject.fragments.activity

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lambdaschool.congressfragmentsproject.R
import com.lambdaschool.congressfragmentsproject.api.CongressDao
import com.lambdaschool.congressfragmentsproject.api.CongresspersonDetails
import com.lambdaschool.congressfragmentsproject.api.CongresspersonOverview
import com.lambdaschool.congressfragmentsproject.fragments.CongresspersonOverviewFragment
import com.lambdaschool.congressfragmentsproject.fragments.DetailsFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList


class MainActivity : AppCompatActivity(), CongresspersonOverviewFragment.OnListFragmentInteractionListener,
    DetailsFragment.OnFragmentInteractionListener {

    companion object {
        const val ITEM_KEY = "shipping and recieving"
    }
    override fun onFragmentInteraction() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onListFragmentInteraction(item: CongresspersonOverview) {


        val fragment = DetailsFragment()

        val bundle = Bundle()
        bundle.putString(ITEM_KEY, item.id)

        //fragment.arguments = bundle
            fragment.setArguments(bundle)

        if(getResources().getBoolean(R.bool.is_tablet)) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.secondary_fragment_holder, fragment)
                .commit()

            /*supportFragmentManager.beginTransaction()
                .replace(R.id.main_fragment_holder, fragment)
                .addToBackStack("yus")
                .commit()*/
        } else {
            val intent = Intent(this, ActivityTwo::class.java)
            intent.putExtras(bundle)
            startActivity(intent)

        }

    }


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            /*
        .0 Jack Seymour, Android Fragments 8/20/2019 12:05 pm
        .1 maybe this stuff will be useful:
                        objectkind: CongresspersonOverview
                fragment classnames : CongresspersonOverviewFragment
                     object content layout file name: fragment_congresspersonoverview
            List layout file name: fragment_congresspersonoverview_list
                adapterclass: MyCongresspersonOverviewRecyclerViewAdapter
        .2:TO/DOne 1.6 update xml once we know if everything works
            added quick fragment generator so i could make sure things were working
        .31 we are likely to have to return to 1.5, 1.6, 1.7
        .4 small revisions to xml, if possible we can return to fragment list last and make even more changes
        .4.9-4.12 debugging
        .5.0 and we're over to 5
        .5.2
        5.4 we are technically done. Looks terrible and barely gets any of the data displayed but it completes the project reqs
         we enter the application, if the size is 600 or less (our bool remains false) then we switch intents to activity two on click,
         passing an id which is then passed to the detail fragment presented within frame.
         TODO: ActivityTwo back button doesn't work well, but why? try to remember to ask basil about this or something
         TODO: actually make it display anything useful
         TODO: see if we can get one of these pictures to display
         TODO: make it a popup dialog instead as per challenge.
         final note: thanks to a couple dumb bugs I've had to step through this with the debugger too much, but what i do know is you can pull id virtually anytime


         */


            // get an overview list for all members of congress
            val allMembers: ArrayList<CongresspersonOverview> = CongressDao.allMembers

            // get details for a single member of congress
            val singleMemberDetails: CongresspersonDetails? = allMembers[0].id?.let { CongressDao.getMemberDetails(it) }

            // get congressperson portrait
            val image: Bitmap? = allMembers[0].id?.let { CongressDao.getImage(it) }




            /* val bundle = Bundle()

        //todo implement this if possible
                    fragment.arguments = bundle
                    fragment.enterTransition = Explode()
                    fragment.exitTransition = Explode()*/

            val fragment = CongresspersonOverviewFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_fragment_holder, fragment)
                .commit()
        }
    }

