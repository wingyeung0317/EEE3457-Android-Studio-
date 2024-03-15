package com.example.lab_wing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.navigation.ui.AppBarConfiguration
import com.example.lab_wing.databinding.ActivityCToFBinding

class CToFActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityCToFBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("run","run")
        super.onCreate(savedInstanceState)

        binding = ActivityCToFBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val return_to_main = findViewById<ImageView>(R.id.return_to_main)
        return_to_main.setOnClickListener {
            startActivity(Intent(this@CToFActivity, MainActivity::class.java))
        }

        val editC = findViewById<EditText>(R.id.editC)
        val editF = findViewById<EditText>(R.id.editF)
        val editK = findViewById<EditText>(R.id.editK)

        fun c_to_other(value:Float){
            var F = (value * 1.8) + 32
            var K = value + 273.15
            editF.setText(String.format("%.1f", F))
            editK.setText(String.format("%.1f", K))
        }

        fun f_to_other(value:Float){
            var C = (value-32)*5/9
            var K = (value-32)*5/9+273.15
            editC.setText(String.format("%.1f", C))
            editK.setText(String.format("%.1f", K))
        }

        fun k_to_other(value:Float){
            var C = value-273.15
            var F = (value-273.15)*1.8+32
            editC.setText(String.format("%.1f", C))
            editF.setText(String.format("%.1f", F))
        }

        fun onInput(type:String, value:Float){
            when(type){
                "C" -> c_to_other(value)
                "F" -> f_to_other(value)
                "K" -> k_to_other(value)
            }
        }

        editC.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (event.action == KeyEvent.ACTION_UP) {
                try {
                    onInput("C", editC.text.toString().toFloat())
                }catch (e:Exception){
                    editF.setText("")
                    editK.setText("")
                }
                return@OnKeyListener true
            }
            false
        })
        editF.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (event.action == KeyEvent.ACTION_UP) {
                try {
                    onInput("F", editF.text.toString().toFloat())
                }catch (e:Exception){
                    editC.setText("")
                    editK.setText("")
                }
                return@OnKeyListener true
            }
            false
        })
        editK.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (event.action == KeyEvent.ACTION_UP) {
                try {
                    onInput("K", editK.text.toString().toFloat())
                }catch (e:Exception){
                    editC.setText("")
                    editF.setText("")
                }
                return@OnKeyListener true
            }
            false
        })
    }
}