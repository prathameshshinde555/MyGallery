package com.example.waap.fragments

import android.os.Bundle
import android.os.Environment
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.waap.adapter.Collectionadapter
import com.example.waap.databinding.FragmentDownlodBinding
import java.io.File


class DownlodFragment : Fragment() {

lateinit var binding: FragmentDownlodBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentDownlodBinding.inflate(layoutInflater,container, false)

        val allfiles:Array<File>
        val imagelist = arrayListOf<String>()
        val targetPath=Environment.getExternalStorageDirectory().absolutePath+"/Pictures/Gr8 Wallpaper"

        val targetFile= File(targetPath)
        allfiles = targetFile.listFiles()!!

        for (data in allfiles)
        {
            imagelist.add(data.absolutePath)
        }

        binding.rcvcollection.layoutManager= StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        binding.rcvcollection.adapter=Collectionadapter(requireContext(),imagelist)
        return binding.root
    }


            }
