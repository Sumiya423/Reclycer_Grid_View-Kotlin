package com.example.kotlin_recycleviewgridview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


    }

    fun goRecycle(view: View) {
        startActivity(Intent(this,CityRecycleActivity::class.java))
    }

    fun goGrid(view: View) {
        startActivity(Intent(this,CityGridActivity::class.java))
    }
}