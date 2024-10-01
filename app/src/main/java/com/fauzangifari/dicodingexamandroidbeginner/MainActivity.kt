package com.fauzangifari.dicodingexamandroidbeginner

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvFruits: RecyclerView
    private var list = ArrayList<DataFruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvFruits = findViewById(R.id.fruits_recycler_view)
        rvFruits.setHasFixedSize(true)

        list.addAll(getListFruits())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                rvFruits.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                rvFruits.layoutManager = GridLayoutManager(this, 2)
            }
            R.id.about_page -> {
                val intent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(intent)
            }
        }

        return super.onOptionsItemSelected(item)
    }

    @SuppressLint("Recycle")
    private fun getListFruits(): ArrayList<DataFruit>{
        val dataName = resources.getStringArray(R.array.fruits_data_name)
        val dataDescription = resources.getStringArray(R.array.fruits_data_description)
        val dataBenefit = resources.getStringArray(R.array.fruits_data_benefit)
        val dataPhoto = resources.obtainTypedArray(R.array.fruits_data_photo)
        val listFruit = ArrayList<DataFruit>()
        for (i in dataName.indices){
            val fruit = DataFruit(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), dataBenefit[i])
            listFruit.add(fruit)
        }
        return listFruit
    }

    private fun showRecyclerList() {
        rvFruits.layoutManager = LinearLayoutManager(this)
        val listFruitAdapter = FruitAdapter(list)
        rvFruits.adapter = listFruitAdapter

        listFruitAdapter.setOnItemClickCallback(object : FruitAdapter.OnItemClickCallback {
            override fun onItemClicked(data: DataFruit) {
                showSelectedHero(data)
            }
        })
    }

    private fun showSelectedHero(fruit: DataFruit) {
        val intent = Intent(this@MainActivity, DetailsFruitActivity::class.java)

        intent.putExtra("name", fruit.name)
        intent.putExtra("description", fruit.description)
        intent.putExtra("benefit", fruit.benefit)
        intent.putExtra("photo", fruit.photo)

        startActivity(intent)
    }
}