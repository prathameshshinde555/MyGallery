package com.example.waap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.waap.adapter.CAt_Imageadapter
import com.example.waap.adapter.Catadapter
import com.example.waap.databinding.ActivityCatBinding
import com.example.waap.model.BomModel
import com.example.waap.model.catModel
import com.google.firebase.firestore.FirebaseFirestore

class CatActivity : AppCompatActivity() {
    lateinit var binding: ActivityCatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCatBinding.inflate(layoutInflater)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(binding.root)

        val db= FirebaseFirestore.getInstance()
        val uid = intent.getStringExtra("uid")
        val name = intent.getStringExtra("name")

        db.collection("catogories").document(uid!!).collection("Wallpaper")
            .addSnapshotListener { value, error ->

            val listBestofthemonth = arrayListOf<BomModel>()
            val data = value?.toObjects(BomModel::class.java)
            listBestofthemonth.addAll(data!!)

                binding.catTitle.text=name.toString()
                binding.catCount.text= "${listBestofthemonth.size} Wallpaper Availables"

            binding.catRcv.layoutManager= StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
            binding.catRcv.adapter = CAt_Imageadapter(this,listBestofthemonth)
        }


    }
}