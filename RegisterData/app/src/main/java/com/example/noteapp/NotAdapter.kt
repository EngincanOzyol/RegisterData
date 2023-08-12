package com.example.noteapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.databinding.RecyliewRowBinding
import java.util.ArrayList

class NotAdapter(var notList:ArrayList<String>):RecyclerView.Adapter<NotAdapter.NotHolder>() {
    class NotHolder(itemView: View):RecyclerView.ViewHolder(itemView){
   var binding=RecyliewRowBinding.bind(itemView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotHolder {
       val view=LayoutInflater.from(parent.context).inflate(R.layout.recyliew_row,parent,false)
       return NotHolder(view)
    }

    override fun onBindViewHolder(holder: NotHolder, position: Int) {
     holder.binding.textview.text=notList.get(position)
    }

    override fun getItemCount(): Int {
       return notList.size
    }
}