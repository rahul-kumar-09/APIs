package com.example.apis.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apis.R
import com.example.apis.databinding.ActivityPatchactivityBinding

class PATCHactivity : AppCompatActivity() {
    private lateinit var binding: ActivityPatchactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPatchactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}