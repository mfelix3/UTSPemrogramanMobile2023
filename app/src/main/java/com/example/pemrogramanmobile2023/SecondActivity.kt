package com.example.pemrogramanmobile2023

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private lateinit var filmName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        filmName = intent.getStringExtra("filmName") ?: ""

        val imageView: ImageView = findViewById(R.id.imageView)

        val filmImage = getFilmImage(filmName)
        imageView.setImageResource(filmImage)

        val callButton: Button = findViewById(R.id.callButton)
        val smsButton: Button = findViewById(R.id.smsButton)

        imageView.setOnClickListener {
            searchFilmOnWeb()
        }

        callButton.setOnClickListener {
            makePhoneCall()
        }

        smsButton.setOnClickListener {
            sendSMS()
        }
    }
    private fun getFilmImage(filmName: String): Int {
        return when (filmName) {
            "The Super Mario Bros. Movie (2023)" -> R.drawable.film_image1
            "Guardians of the Galaxy Vol. 3 (2023)" -> R.drawable.film_image2
            "Ant-Man and the Wasp: Quantumania (2023)" -> R.drawable.film_image3
            else -> R.drawable.film_image
        }
    }
    private fun searchFilmOnWeb() {
        val searchQuery = filmName.replace(" ", "+")
        val url = "https://www.google.com/search?q=$searchQuery"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    private fun makePhoneCall() {
        val phoneNumber = when (filmName) {
            "The Super Mario Bros. Movie (2023)" -> "087839997075"
            "Guardians of the Galaxy Vol. 3 (2023)" -> "087839997077"
            "Ant-Man and the Wasp: Quantumania (2023)" -> "087839997079"
            else -> ""
        }

        if (phoneNumber.isNotEmpty()) {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
            startActivity(intent)
        } else {
            Toast.makeText(this, "Phone number not available", Toast.LENGTH_SHORT).show()
        }
    }

    private fun sendSMS() {
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("smsto:")
        intent.putExtra("sms_body", filmName)
        startActivity(intent)
    }
}
