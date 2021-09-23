package com.example.waap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.waap.databinding.ActivityMainBinding
import com.example.waap.fragments.DownlodFragment
import com.example.waap.fragments.HomeFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(binding.root)
         replaceFragment(HomeFragment())
        binding.icHome.setOnClickListener{
            replaceFragment(HomeFragment())
        }

        binding.icDownload.setOnClickListener{
            replaceFragment(DownlodFragment())
        }
    }
    fun replaceFragment(fragment:Fragment)
    {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.Fragreplace, fragment)
        transaction.commit()

    }
}