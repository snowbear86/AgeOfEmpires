package com.example.ageofempires

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_civilization_details.*
import kotlinx.android.synthetic.main.activity_civilization_details.view.*
import kotlinx.android.synthetic.main.civilization_row.view.*



class CivilizationDetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        val cname =

            super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_civilization_details)

        textView_name_details.setText("Strategies")


    }

}