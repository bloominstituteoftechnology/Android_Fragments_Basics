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

    }
}
