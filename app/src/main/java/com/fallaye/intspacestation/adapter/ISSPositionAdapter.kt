package com.fallaye.intspacestation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fallaye.intspacestation.R
import com.fallaye.intspacestation.data.db.entities.ISSPosition
import kotlinx.android.synthetic.main.iss_item.view.*

class ISSPositionAdapter(val context : Context, val issList : List<ISSPosition>) :
    RecyclerView.Adapter<ISSPositionAdapter.ISSViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ISSViewHolder {
        val inflater : LayoutInflater = LayoutInflater.from(context)
        val view : View = inflater.inflate(R.layout.iss_item, parent, false)
        return ISSViewHolder(view)
    }

    override fun onBindViewHolder(holder: ISSViewHolder, position: Int) {
        val issModel : ISSPosition = issList.get(position)
        holder.itemView.latitude.text = "Latitude: " + issList.get(position)?.latitude
        holder.itemView.longitude.text = "Longitude: " + issList.get(position)?.longitude
    }

    override fun getItemCount(): Int {
       return issList.size
    }

    class ISSViewHolder(view : View) : RecyclerView.ViewHolder(view)

}