package com.lambdaschool.congressfragmentsproject.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lambdaschool.congressfragmentsproject.R
import com.lambdaschool.congressfragmentsproject.fragment.DetailsFragment

class MainActivityTwo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_two)
        val fragment = DetailsFragment()

        val bundle = Bundle()
        val congresspersonID = intent.getStringExtra(MainActivity.FRAGMENT_KEY)
        bundle.putString(MainActivity.FRAGMENT_KEY, congresspersonID)
        fragment.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_activity_two_fragment_holder, fragment)
            //.addToBackStack(null)
            .commit()

    }
}
