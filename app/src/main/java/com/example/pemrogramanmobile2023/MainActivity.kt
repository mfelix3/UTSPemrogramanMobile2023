package com.example.pemrogramanmobile2023

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val filmList = arrayOf(
        "The Super Mario Bros. Movie (2023)",
        "Guardians of the Galaxy Vol. 3 (2023)",
        "Ant-Man and the Wasp: Quantumania (2023)"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.listView)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, filmList)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedFilm = filmList[position]
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("filmName", selectedFilm)
            startActivity(intent)
        }
    }
}
