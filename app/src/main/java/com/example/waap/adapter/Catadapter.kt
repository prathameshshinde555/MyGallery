package com.example.waap.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.waap.CatActivity
import com.example.waap.FinalWallpaper
import com.example.waap.R
import com.example.waap.model.catModel
import kotlin.collections.ArrayList

class Catadapter(val requireContext: Context, val Listofcat: ArrayList<catModel>) : RecyclerView.Adapter<Catadapter.bomViewHolder>(){

    inner class bomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val imageView=itemView.findViewById<ImageView>(R.id.cat_image)
        val name = itemView.findViewById<TextView>(R.id.cat_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): bomViewHolder {
        return bomViewHolder(
          LayoutInflater.from(requireContext).inflate(R.layout.item_cat, parent, false)
        )
    }

    override fun onBindViewHolder(holder: bomViewHolder, position: Int) {
        holder.name.text = Listofcat[position].name
        Glide.with(requireContext).load(Listofcat[position].link).into(holder.imageView);

        holder.itemView.setOnClickListener{
            val intent = Intent(requireContext, CatActivity::class.java)
            intent.putExtra("uid",Listofcat[position].id)
            intent.putExtra("name",Listofcat[position].name)
            requireContext.startActivity(intent)
        }

    }

    override fun getItemCount() = Listofcat.size

    }


