package com.example.testproject.observable.with_interface

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.testproject.R
import com.example.testproject.observable.with_interface.`interface`.PressListener
import com.example.testproject.observable.with_interface.`interface`.PressListener2
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar

class ObserveActivity : AppCompatActivity(), PressListener2 {

    private lateinit var baseView: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_observe)
        baseView = findViewById(R.id.vBaseView)
        supportFragmentManager.beginTransaction().add(R.id.vContainer, ObserveFragment(object : PressListener{
            override fun onPressListener(text: String) {
                Snackbar.make(baseView, "from constructor", Snackbar.LENGTH_SHORT).show()
            }

        })).commit()

        findViewById<MaterialButton>(R.id.vToastButton).setOnClickListener {
            Snackbar.make(it, "Hello", Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun onPressListener(text: String) {
        Snackbar.make(baseView, "from implementation", Snackbar.LENGTH_SHORT).show()
    }


}