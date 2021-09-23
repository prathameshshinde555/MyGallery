package com.example.waap.adapter

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.waap.FinalWallpaper
import com.example.waap.R
import com.example.waap.model.colourtonemodel
import kotlin.collections.ArrayList

class colortoneadapter(val requireContext: Context, val listcolortone: ArrayList<colourtonemodel>) : RecyclerView.Adapter<colortoneadapter.bomViewHolder>(){

    inner class bomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val CardBack=itemView.findViewById<CardView>(R.id.item_card)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): bomViewHolder {
        return bomViewHolder(
          LayoutInflater.from(requireContext).inflate(R.layout.item_colourtone, parent, false)
        )
    }

    override fun onBindViewHolder(holder: bomViewHolder, position: Int) {
       val color = listcolortone[position].colour
       holder.CardBack.setCardBackgroundColor(Color.parseColor(color!!))

        holder.itemView.setOnClickListener{
            val intent = Intent(requireContext, FinalWallpaper::class.java)
            intent.putExtra("link",listcolortone[position].link)
            requireContext.startActivity(intent)
        }

    }

    override fun getItemCount() = listcolortone.size

    }


