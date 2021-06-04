package com.example.kotlin_recycleviewgridview

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_city_recycle.*
import java.text.FieldPosition
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random
import kotlin.random.Random.Default.nextInt

class CityRecycleActivity : AppCompatActivity(), RecycleAdapter.OnItemClick {
    private val image = arrayOf(R.drawable.ic_pic,R.drawable.ic_pic,R.drawable.ic_pic,R.drawable.ic_pic,R.drawable.ic_pic,R.drawable.ic_pic,
            R.drawable.ic_pic,R.drawable.ic_pic,R.drawable.ic_pic,R.drawable.ic_pic,R.drawable.ic_pic)

    private val contactList = ArrayList<Contact>()

    lateinit var adapter: RecycleAdapter // variable pathate hoy nah
    //private val adapter = RecycleAdapter(contactList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_recycle)

        setTitle("Contacts")

        val name = resources.getStringArray(R.array.name)
        val number = resources.getStringArray(R.array.number)

        for (i in name.indices){

            val contact = Contact(image[i], name[i], number[i])
            contactList.add(contact)
        }

        adapter= RecycleAdapter(contactList,this)
        recycleView.layoutManager= LinearLayoutManager(this)
        recycleView.setHasFixedSize(true)
        recycleView.adapter= adapter

        recycleRefresh.setOnRefreshListener {
            val index= Random.nextInt(10)
            val contact= Contact(image[index],name[index],number[index])
            contactList.add(contact)
            adapter.notifyDataSetChanged()
            recycleRefresh.isRefreshing= false
        }


    }

    override fun onItemClick(position: Int) {
        val value= contactList[position].name.toString()
        Snackbar.make(recycleLayout,value,Snackbar.LENGTH_LONG).show()
    }

    override fun onLongItemClick(position: Int) {
        val builder= AlertDialog.Builder(this)
        builder.setTitle("Alert")
        builder.setMessage("Do you want to delete ?")
        builder.setPositiveButton("Yes"){ dialogInterface: DialogInterface, i: Int ->

            contactList.removeAt(position)
            adapter.notifyItemRemoved(position)
        }
        builder.setNegativeButton("No",null)
        val dialoge= builder.create()
        dialoge.show()

    }
}