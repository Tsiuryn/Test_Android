package com.example.testproject.cardView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.example.testproject.R

class CardViewActivity : AppCompatActivity() {
    private var container: LinearLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_view)
        container = findViewById(R.id.vContainer)
        container?.addView(ExpandableCard(this).apply {
            textTitle = "hello world"
        })

    }
}