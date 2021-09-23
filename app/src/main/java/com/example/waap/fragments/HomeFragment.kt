 package com.example.waap.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.waap.adapter.Bomadapter
import com.example.waap.adapter.Catadapter
import com.example.waap.adapter.colortoneadapter
import com.example.waap.databinding.FragmentHomeBinding
import com.example.waap.model.BomModel
import com.example.waap.model.catModel
import com.example.waap.model.colourtonemodel
import com.google.firebase.firestore.FirebaseFirestore


 class HomeFragment : Fragment() {
     lateinit var binding: FragmentHomeBinding
     lateinit var db:FirebaseFirestore


     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         arguments?.let {

         }
     }

     override fun onCreateView(
         inflater: LayoutInflater, container: ViewGroup?,
         savedInstanceState: Bundle?
     ): View? {
         binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

         db= FirebaseFirestore.getInstance()

         db.collection("Bom").addSnapshotListener { value, error ->
             val listBestofthemonth = arrayListOf<BomModel>()
             val data = value?.toObjects(BomModel::class.java)
             listBestofthemonth.addAll(data!!)

             binding.rcvBom.layoutManager =
                 LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
             binding.rcvBom.adapter = Bomadapter(requireContext(), listBestofthemonth)

         }
             db.collection("colour tone").addSnapshotListener { value, error ->
                 val ListTheColourTone= arrayListOf<colourtonemodel>()
                 val data = value?.toObjects(colourtonemodel::class.java)
                 ListTheColourTone.addAll(data!!)

              // binding.rcvTct.layoutManager =
                //   LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                // binding.rcvTct.adapter = colortoneadapter(requireContext(), ListTheColourTone)
         }

         db.collection("catogories").addSnapshotListener { value, error ->

             val Listofcategories= arrayListOf<catModel>()
             val data= value?.toObjects(catModel::class.java)
             Listofcategories.addAll(data!!)

             binding.rcvCat.layoutManager =
                 GridLayoutManager(requireContext(),2 )
             binding.rcvCat.adapter= Catadapter(requireContext(),Listofcategories)
         }

         return binding.root
     }
 }

