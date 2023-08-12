package com.example.noteapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteapp.databinding.FragmentListBinding
import java.lang.Exception
import java.util.ArrayList

class ListFragment : Fragment() {
    val notList= ArrayList<String>()
    lateinit var adapter: NotAdapter
private lateinit var binding: FragmentListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       binding.recyliew.layoutManager=LinearLayoutManager(context)
         adapter=NotAdapter(notList)
        binding.recyliew.adapter=adapter

        try {
            activity?.let {
                val database=it.openOrCreateDatabase("Notlar", Context.MODE_PRIVATE,null)
                val cursor=  database.rawQuery("SELECT *FROM notlar",null)
                val columnIndex=cursor.getColumnIndex("notum")
notList.clear()
                while (cursor.moveToNext()){
                    notList.add(cursor.getString(columnIndex))
                }

                adapter.notifyDataSetChanged()
                cursor.close()

            }

        }
      catch (e:Exception){
          e.printStackTrace()

      }

        super.onViewCreated(view, savedInstanceState)
    }


}