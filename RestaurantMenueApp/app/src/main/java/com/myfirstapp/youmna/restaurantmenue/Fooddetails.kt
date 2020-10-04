package com.myfirstapp.youmna.restaurantmenue

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_food_details.*


class Fooddetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_details)
        val b=intent.extras
        ivdfood.setImageResource(b.getInt("image"))
        tvName.text=b.getString("name")
        tvdes.text=b.getString("des")
    }
}
