package com.example.testproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testproject.cardView.CardViewActivity
import com.example.testproject.compose.ComposeActivity
import com.example.testproject.observable.MidleActivity
import com.example.testproject.observable.with_interface.ObserveActivity
import com.example.testproject.slider.SliderActivity
import com.example.testproject.text.TextViewAutoSizeActivity
import com.example.testproject.themes.ThemesActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<MaterialButton>(R.id.updateThemes).setOnClickListener{
            startActivity(Intent(this@MainActivity, ThemesActivity::class.java))
        }

        findViewById<MaterialButton>(R.id.vSlider).setOnClickListener{
            startActivity(Intent(this@MainActivity, SliderActivity::class.java))
        }

        findViewById<MaterialButton>(R.id.vCardView).setOnClickListener{
            startActivity(Intent(this@MainActivity, CardViewActivity::class.java))
        }
        findViewById<MaterialButton>(R.id.vTextActivity).setOnClickListener{
            startActivity(Intent(this@MainActivity, TextViewAutoSizeActivity::class.java))
        }
        findViewById<MaterialButton>(R.id.vObservableActivity).setOnClickListener{
            startActivity(Intent(this@MainActivity, MidleActivity::class.java))
        }
        findViewById<MaterialButton>(R.id.vComposeActivity).setOnClickListener{
            startActivity(Intent(this@MainActivity, ComposeActivity::class.java))
        }

    }
}