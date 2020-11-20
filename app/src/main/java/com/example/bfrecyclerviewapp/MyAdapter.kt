package com.example.bfrecyclerviewapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitapp.MyDataClass

class MyAdapter(var userList: ArrayList<MyDataClass>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        fun myBindViews(user: MyDataClass){
            var textViewName = itemView.findViewById(R.id.textViewName) as TextView
            var textViewPh = itemView.findViewById(R.id.textViewPhone) as TextView
            var textViewAdd = itemView.findViewById(R.id.textViewAddress) as TextView

            textViewName.setText(""+ user.id)
            textViewPh.setText(user.name)
            textViewAdd.setText(user.username)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        var v = LayoutInflater.from(parent.context).inflate(R.layout.item_layout2,parent,false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.myBindViews(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }
 
    // using this method, refreshing the data...
    fun refreshList(list: ArrayList<MyDataClass>){
        userList = list
        notifyDataSetChanged()
    }
}