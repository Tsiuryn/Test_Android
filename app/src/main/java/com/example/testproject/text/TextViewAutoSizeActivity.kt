package com.example.testproject.text

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged
import com.example.testproject.R

class TextViewAutoSizeActivity : AppCompatActivity(R.layout.activity_text_view_auto_size) {
    private lateinit var vStep: TextView
    private lateinit var vEditText: EditText
    private lateinit var vEditText2: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vStep = findViewById(R.id.vStep)
        vEditText = findViewById(R.id.vEditText)
        vEditText2 = findViewById(R.id.vEditText2)
        vEditText2.doAfterTextChanged { text ->
            val first = vEditText.text.toString()
            vStep.text = getTextSpannable(first, text.toString())
        }
    }

    private fun getTextSpannable(currentStep: String, allStep: String): SpannableString{
        val span = SpannableString("$currentStep/$allStep")
        span.setSpan(
            ForegroundColorSpan(Color.parseColor("#D6D6D6")),
            currentStep.length ,
            span.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        return span
    }
}