package com.lambdaschool.congressfragmentsproject
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lambdaschool.congressfragmentsproject.api.CongresspersonOverview


class MainActivity : AppCompatActivity(),CongresspersonOverviewFragment.OnListFragmentInteractionListener {
    override fun onListFragmentInteraction(item: CongresspersonOverview?) {
    if(getResources().getBoolean(R.bool.is_tablet)) {
        val fragment = DetailsFragment()

        val bundle = Bundle()
        bundle.putString("itemkey", item?.id)
        fragment.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.secondary_fragment_holder, fragment)
            .addToBackStack(null)
            .commit()
    }
        else if(!getResources().getBoolean(R.bool.is_tablet)) {
        val intent = Intent(this,Main2Activity::class.java)
        intent.putExtra("itemkey", item?.id)
        startActivity(intent)
    }
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // get an overview list for all members of congress
       /* val allMembers: ArrayList<CongresspersonOverview> = CongressDao.allMembers

        // get details for a single member of congress
        val singleMemberDetails: CongresspersonDetails? = allMembers[0].id?.let { CongressDao.getMemberDetails(it) }

        // get congressperson portrait
        val image: Bitmap? = allMembers[0].id?.let { CongressDao.getImage(it) }*/
    }

}
