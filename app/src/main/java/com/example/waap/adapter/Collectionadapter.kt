package com.example.waap.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.waap.FinalWallpaper
import com.example.waap.R
import com.makeramen.roundedimageview.RoundedImageView
import kotlin.collections.ArrayList

class Collectionadapter(val requireContext: Context, val listBestofthemonth: ArrayList<String>) : RecyclerView.Adapter<Collectionadapter.bomViewHolder>(){

    inner class bomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val imageView=itemView.findViewById<RoundedImageView>(R.id.cat_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): bomViewHolder {
        return bomViewHolder(
          LayoutInflater.from(requireContext).inflate(R.layout.item_walpaper, parent, false)
        )
    }

    override fun onBindViewHolder(holder: bomViewHolder, position: Int) {

        Glide.with(requireContext).load(listBestofthemonth[position]).into(holder.imageView);

    }

    override fun getItemCount() = listBestofthemonth.size

    }


