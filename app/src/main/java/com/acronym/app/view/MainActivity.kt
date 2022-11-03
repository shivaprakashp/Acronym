package com.acronym.app.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.acronym.app.R
import com.acronym.app.adapter.AcronymAdapter
import com.acronym.app.retrofit.Apiiinterface
import com.acronym.app.retrofit.RetrofitClient
import com.acronym.app.viewmodel.MainActivityViewModel
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerview : RecyclerView
    private lateinit var context: Context

    private lateinit var mainActivityViewModel: MainActivityViewModel

    private lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setRecyclerView()
        getListData()
    }

    private fun setRecyclerView(){

        editText = findViewById(R.id.edtAcro)
        // getting the recyclerview by its id
        recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)


    }

    private fun getListData(){

        context = this@MainActivity

        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        findViewById<Button>(R.id.btnClick).setOnClickListener {
            mainActivityViewModel.getUser(editText.text.toString())!!.observe(this, Observer { serviceSetterGetter ->

                val adapter = AcronymAdapter(serviceSetterGetter.lfs)

                recyclerview.adapter = adapter

            })
        }
    }
}