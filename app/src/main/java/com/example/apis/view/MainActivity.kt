package com.example.apis.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apis.adapter.ProductAdapter
import com.example.apis.databinding.ActivityMainBinding
import com.example.apis.model.MyProductData
import com.example.apis.model.Product
import com.example.apis.model.Profile
import com.example.apis.util.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGetReq.setOnClickListener {
            startActivity(Intent(this, GetActivity::class.java) )
        }

        binding.btnPostReq.setOnClickListener {
            startActivity(Intent(this, PostActivity::class.java))
        }



    }
}