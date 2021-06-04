package com.example.kotlin_recycleviewgridview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.single_recycle_item.view.*

class RecycleAdapter(private val contactList: List<Contact>, private val listener: OnItemClick) :
        RecyclerView.Adapter<RecycleAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_recycle_item, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {

        return contactList.size
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.image.setImageResource(contactList[position].image)
        holder.name.text = contactList[position].name
        holder.number.text = contactList[position].number
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener, View.OnLongClickListener {

        val image: CircleImageView = itemView.singleRecycleImage
        val name: TextView = itemView.singleRecycleName
        val number: TextView = itemView.singleRecycleNum

        init {
            itemView.setOnClickListener(this)
            itemView.setOnLongClickListener(this)
        }


        override fun onClick(p0: View?) {

            val position: Int = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }

        override fun onLongClick(p0: View?): Boolean {

            val position: Int = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onLongItemClick(position)
            }
            return false
        }

    }

    interface OnItemClick {
        fun onItemClick(position: Int)
        fun onLongItemClick(position: Int)
    }

}