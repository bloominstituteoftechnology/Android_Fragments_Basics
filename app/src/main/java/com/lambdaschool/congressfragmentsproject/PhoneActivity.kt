package com.lambdaschool.congressfragmentsproject

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class PhoneActivity : AppCompatActivity(), DetailsFragment.OnFragmentInteractionListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone)
    }

    override fun onFragmentInteraction(uri: Uri) {
        val fragment = DetailsFragment()
        val bundle = Bundle()
        val item_id = intent.getStringExtra("item_key")
        bundle.putString("item_key", item_id)

        supportFragmentManager.beginTransaction()
            .replace(R.id.phone_frame_layout, fragment)
            .commit()
    }
}
