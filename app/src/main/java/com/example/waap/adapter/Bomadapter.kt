package com.example.waap.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.waap.FinalWallpaper
import com.example.waap.R
import com.example.waap.model.BomModel
import java.util.ArrayList

class Bomadapter(val requireContext: Context, val listBestofthemonth: ArrayList<BomModel>) : RecyclerView.Adapter<Bomadapter.bomViewHolder>(){

    inner class bomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val imageView=itemView.findViewById<ImageView>(R.id.bomimage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): bomViewHolder {
        return bomViewHolder(
          LayoutInflater.from(requireContext).inflate(R.layout.item_bom, parent, false)
        )
    }

    override fun onBindViewHolder(holder: bomViewHolder, position: Int) {

        Glide.with(requireContext).load(listBestofthemonth[position].link).into(holder.imageView);
        holder.itemView.setOnClickListener{
            val intent = Intent(requireContext,FinalWallpaper::class.java)
            intent.putExtra("link",listBestofthemonth[position].link)
            requireContext.startActivity(intent)
        }
    }

    override fun getItemCount() = listBestofthemonth.size

    }


