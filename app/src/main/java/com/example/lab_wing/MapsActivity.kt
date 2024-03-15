package com.example.lab_wing

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.lab_wing.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val return_to_main = findViewById<ImageView>(R.id.return_to_main)
        return_to_main.setOnClickListener {
            startActivity(Intent(this@MapsActivity, MainActivity::class.java))
        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        val map_redirect = findViewById<Button>(R.id.redirect_map_btn)
        map_redirect.setOnClickListener {
            var it = Intent(Intent.ACTION_VIEW)
            it.setData(Uri.parse("geo:22.33484,114.15294?z=18&q=restaurants"));
            startActivity(it);
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val l = LatLng(22.33484, 114.15294)
        mMap.addMarker(MarkerOptions().position(l).title("Marker Location"))
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(l, 12.0f))
    }
}