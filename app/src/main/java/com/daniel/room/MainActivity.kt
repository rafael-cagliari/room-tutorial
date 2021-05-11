package com.daniel.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.daniel.room.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val binding : ActivityMainBinding? = null

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding?.recyclerview?.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = RecyclerViewAdapter()
        }

    }
}