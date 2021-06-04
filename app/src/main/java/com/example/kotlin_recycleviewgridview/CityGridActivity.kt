package com.example.kotlin_recycleviewgridview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_city_grid.*
import kotlin.random.Random

class CityGridActivity : AppCompatActivity() {
    private val image= arrayOf(R.drawable.dhk,R.drawable.raj,
            R.drawable.bari,R.drawable.ctg,R.drawable.com,R.drawable.khulna,
            R.drawable.rang,R.drawable.syl,R.drawable.srimangal,R.drawable.bhola, R.drawable.piroj,
            R.drawable.bagerhat,R.drawable.chand,R.drawable.bandar,R.drawable.cox, R.drawable.jessore,
            R.drawable.kuakata,R.drawable.mymen,R.drawable.natore,R.drawable.netro, R.drawable.ranga,R.drawable.sundar)

    private val cityList= ArrayList<CityModel>()
    private lateinit var adapter: GridAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_grid)

        setTitle("Grid View")

        val cityName= resources.getStringArray(R.array.city_name)
        val country= resources.getStringArray(R.array.country)

        for (i in cityName.indices){
            val city= CityModel(image[i],cityName[i],country[i])
            cityList.add(city)
        }

        adapter= GridAdapter(cityList,this)
        gridView.adapter= adapter

        refreshGrid.setOnRefreshListener {
            val index= Random.nextInt(21)
            val city= CityModel(image[index],cityName[index],country[index])
            cityList.add(city)
            adapter.notifyDataSetChanged()
            refreshGrid.isRefreshing= false
        }

    }
}