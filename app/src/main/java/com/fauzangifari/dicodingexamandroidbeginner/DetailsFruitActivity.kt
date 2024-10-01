package com.fauzangifari.dicodingexamandroidbeginner

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide

class DetailsFruitActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_fruit)

        val fruitName = intent.getStringExtra("name")
        val fruitDescription = intent.getStringExtra("description")
        val fruitBenefit = intent.getStringExtra("benefit")
        val fruitPhoto = intent.getIntExtra("photo", 0)

        val imgPhoto: ImageView = findViewById(R.id.fruit_photo_details)
        val tvName: TextView = findViewById(R.id.fruit_name_details)
        val tvDescription: TextView = findViewById(R.id.fruit_desc_details)
        val tvBenefit: TextView = findViewById(R.id.fruit_benefit_details)

        tvName.text = fruitName
        tvDescription.text = fruitDescription
        tvBenefit.text = fruitBenefit
        Glide.with(this)
            .load(fruitPhoto)
            .into(imgPhoto)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_details, menu)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onContextItemSelected(item)
    }
}