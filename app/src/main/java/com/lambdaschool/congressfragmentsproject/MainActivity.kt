package com.lambdaschool.congressfragmentsproject

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Explode
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.lambdaschool.congressfragmentsproject.api.CongressDao
import com.lambdaschool.congressfragmentsproject.api.CongresspersonDetails
import com.lambdaschool.congressfragmentsproject.api.CongresspersonOverview
import com.lambdaschool.congressfragmentsproject.fragments.CongresspersonOverviewFragment
import java.util.ArrayList

class MainActivity : AppCompatActivity(), CongresspersonOverviewFragment.OnListFragmentInteractionListener  {
    override fun onListFragmentInteraction(item: CongresspersonOverview) {
            Toast.makeText(this, "Fragment Interacted ${item.twitterAccount}", Toast.LENGTH_SHORT).show()

            // show fragment as dialog
            /*val dialogFragment: DetailFragment = DetailFragment() // DetailFragment must extend DialogFragment

            val bundle = Bundle()
            bundle.putSerializable(ItemDetail.ITEM_KEY, item)

            dialogFragment.arguments = bundle
            dialogFragment.show(supportFragmentManager, "Detail Fragment")*/

            // show fragment in main window
            val fragment = CongresspersonOverviewFragment()

            /*   val bundle = Bundle()
                bundle.putSerializable(, item)

                    fragment.arguments = bundle
                    fragment.enterTransition = Explode()
                    fragment.exitTransition = Explode()*/

            /*  if(secondary_fragment_holder == null) {*/
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_fragment_holder, fragment)
                .addToBackStack(null)
                .commit()
            /*  } else {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.secondary_fragment_holder, fragment)
                    .commit()
            }*/

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
        .2:TODO 1.6 update xml once we know if everything works
            added quick fragment generator so i could make sure things were working
        .31 we are likely to have to return to 1.5, 1.6, 1.7
         */


            // get an overview list for all members of congress
            val allMembers: ArrayList<CongresspersonOverview> = CongressDao.allMembers

            // get details for a single member of congress
            val singleMemberDetails: CongresspersonDetails? = allMembers[0].id?.let { CongressDao.getMemberDetails(it) }

            // get congressperson portrait
            val image: Bitmap? = allMembers[0].id?.let { CongressDao.getImage(it) }
        }
    }

