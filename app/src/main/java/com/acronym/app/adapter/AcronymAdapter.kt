package com.acronym.app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.acronym.app.R
import com.acronym.app.model.Lf

class AcronymAdapter(private val mListData : List<Lf>) :
    RecyclerView.Adapter<AcronymAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val data :  Lf = mListData[position]

        holder.textData.text = data.lf
    }

    override fun getItemCount(): Int {
        return mListData.size
    }


    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView){

        val textData : TextView = itemView.findViewById(R.id.txtAcrName)
    }
}