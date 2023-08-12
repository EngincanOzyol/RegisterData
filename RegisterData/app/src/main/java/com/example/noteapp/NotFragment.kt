package com.example.noteapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.noteapp.databinding.FragmentNotBinding


class NotFragment : Fragment() {
private lateinit var binding: FragmentNotBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentNotBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
binding.button.setOnClickListener {
    try {
        context?.let {
            val database=it.openOrCreateDatabase("Notlar", Context.MODE_PRIVATE,null)
            database.execSQL("CREATE TABLE IF NOT EXISTS notlar (id INT PRIMARY KEY,notum VARCHAR )")
            val query="INSERT INTO notlar (notum) VALUES(?)"
            val statement=database.compileStatement(query)
            statement.bindString(1,binding.editText.text.toString())
            statement.execute()


        }
    }
    catch (e:Exception){
        e.printStackTrace()
    }
    val action=NotFragmentDirections.actionNotFragmentToListFragment()
    Navigation.findNavController(it).navigate(action)



}
        super.onViewCreated(view, savedInstanceState)
    }




}