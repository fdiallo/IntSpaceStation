package com.fallaye.intspacestation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.fallaye.intspacestation.R
import com.fallaye.intspacestation.models.ISSModel
import kotlinx.android.synthetic.main.iss_item.view.*

class ISSAdapter(val context : Context, val issList : List<ISSModel>) :
    RecyclerView.Adapter<ISSAdapter.ISSViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ISSViewHolder {
        val inflater : LayoutInflater = LayoutInflater.from(context)
        val view : View = inflater.inflate(R.layout.iss_item, parent, false)
        return ISSViewHolder(view)
    }

    override fun onBindViewHolder(holder: ISSViewHolder, position: Int) {
        val issModel : ISSModel = issList.get(position)
        holder.itemView.latitude.text = issList.get(position)?.latitude
        holder.itemView.longitude.text = issList.get(position)?.longitude
    }

    override fun getItemCount(): Int {
       return issList.size
    }

    class ISSViewHolder(view : View) : RecyclerView.ViewHolder(view)

}