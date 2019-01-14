package com.example.lambda_school_loaner_47.fragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Person> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();

        list.add(new Person("John", "Brown", "txy.com","8709876543", 1));
        list.add(new Person("Jerry", "Chris", "txz.com","8709870000", 2));
        list.add(new Person("Gary", "Blue", "txc.com","8709870000",3));
        list.add(new Person("Dale", "Jones", "txc.com","8709870000", 4));
        list.add(new Person("Chuck", "Berry", "txd.com","8709870000", 5));
        list.add(new Person("Kobe", "Jordan", "txf.com","8709870000",6));
        list.add(new Person("Rick", "Wrestler", "txj.com","8709870000",7));
        list.add(new Person("Cherry", "Orange", "txb.com","8709870000",8));

    }
}
