package com.example.apis.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.apis.databinding.ActivityPostBinding
import com.example.apis.model.Profile
import com.example.apis.util.ApiInterface
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class PostActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPostBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        binding.btnPost.setOnClickListener {
            val n = binding.userName.text.toString()
            val a = binding.userAddress.text.toString()
            val m = binding.userMobile.text.toString()

            Log.d("res", "main -- ")

            val gson = GsonBuilder()
                .setLenient()
                .create()

            val retrofit = Retrofit.Builder()
                .baseUrl("http://192.168.1.3:8080/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(ApiInterface::class.java)



            val postRequest = retrofit.postProfile(Profile(n, a, m))
            postRequest.enqueue(object : Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    // Handle the response here
                    val responseBody = response.body()
                    Log.d("res", responseBody.toString())
                    Toast.makeText(applicationContext, "Successfully POST", Toast.LENGTH_SHORT).show()


                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    // Handle failure here
                    Log.d("res", " failed " + t.toString())
                }
            })

        }
    }
}