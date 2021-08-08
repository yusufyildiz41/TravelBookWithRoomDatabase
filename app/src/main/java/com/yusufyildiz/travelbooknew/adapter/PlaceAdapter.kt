package com.yusufyildiz.travelbooknew.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.Placeholder
import androidx.recyclerview.widget.RecyclerView
import com.yusufyildiz.travelbooknew.databinding.ActivityMainBinding
import com.yusufyildiz.travelbooknew.databinding.RecyclerRowBinding
import com.yusufyildiz.travelbooknew.model.Place
import com.yusufyildiz.travelbooknew.view.MapsActivity
import java.util.zip.Inflater

class PlaceAdapter(val placeList : List<Place>) : RecyclerView.Adapter<PlaceAdapter.PlaceHolder>() {
    class PlaceHolder(val myRecyclerRowBinding: RecyclerRowBinding) : RecyclerView.ViewHolder(myRecyclerRowBinding.root)
    {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceHolder {
        var rowInflater = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PlaceHolder(myRecyclerRowBinding = RecyclerRowBinding.bind(rowInflater.root))

    }

    override fun onBindViewHolder(holder: PlaceHolder, position: Int) {
        holder.myRecyclerRowBinding.recyclerViewTextView.text = placeList.get(position).name
        holder.itemView.setOnClickListener{

            val intent = Intent(holder.itemView.context,MapsActivity::class.java)
            intent.putExtra("selectedPlace",placeList.get(position))
            intent.putExtra("info","old")
            holder.itemView.context.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {
        return placeList.size
    }


}