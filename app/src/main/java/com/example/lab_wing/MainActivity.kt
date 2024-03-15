package com.example.lab_wing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val cToF_btn = findViewById<LinearLayout>(R.id.cToF_btn)
        val map_btn = findViewById<LinearLayout>(R.id.map_btn)
        cToF_btn.setOnClickListener(){
            startActivity(Intent(this@MainActivity, CToFActivity::class.java))
        }
        map_btn.setOnClickListener(){
            startActivity(Intent(this@MainActivity, MapsActivity::class.java))
        }
    }
}