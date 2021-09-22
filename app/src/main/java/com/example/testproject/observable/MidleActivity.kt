package com.example.testproject.observable

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testproject.R
import com.example.testproject.observable.with_interface.ObserveActivity
import com.example.testproject.observable.with_view_model.SubscriberActivity
import com.google.android.material.button.MaterialButton

class MidleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_midle)

        findViewById<MaterialButton>(R.id.vWithInterface).setOnClickListener {
            startActivity(Intent(this, ObserveActivity::class.java))
        }

        findViewById<MaterialButton>(R.id.vWithViewModel).setOnClickListener {
            startActivity(Intent(this, SubscriberActivity::class.java))
        }
    }
}