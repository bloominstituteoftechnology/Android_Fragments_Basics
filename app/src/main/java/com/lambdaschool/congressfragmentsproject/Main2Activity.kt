package com.lambdaschool.congressfragmentsproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Main2Activity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val fragment = DetailsFragment()

        val bundle = Bundle()
        val itemID=intent.getStringExtra("itemKey")
        bundle.putString("itemkey", itemID)
        fragment.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.Phone_Details_View_Holder, fragment)
          //  .addToBackStack(null)
            .commit()
    }
}
