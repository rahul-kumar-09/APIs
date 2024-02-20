package com.example.apis.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.apis.R
import com.example.apis.databinding.ActivityGetBinding
import com.example.apis.databinding.ActivityMainBinding
import com.example.apis.model.Profile
import com.example.apis.util.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.log

class GetActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        Log.d("res", "main -- ")

        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.1.3:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val retrofitModel = retrofit.getPorfile()
            .enqueue(object : Callback<Profile> {
                override fun onResponse(call: Call<Profile>, response: Response<Profile>) {
                    val responseBody = response.body()
                    if (response.isSuccessful && response.body() != null){
                        val n = responseBody?.name
                        val a = responseBody?.address
                        val m = responseBody?.mobile

                        binding.txtName.text = n
                        binding.txtAddress.text = a
                        binding.txtMobile.text = m
                        Log.d("name", responseBody?.name.toString())


                    }

                    Log.d("res", "main " + responseBody.toString())
                }
                override fun onFailure(call: Call<Profile>, t: Throwable) {
                    Log.d("res", "main error " + t.toString())
                }

            })
    }
}