package com.example.testproject.slider

import android.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.view.marginStart
import androidx.lifecycle.lifecycleScope
import com.example.testproject.R
import com.google.android.material.slider.RangeSlider
import com.google.android.material.slider.Slider
import kotlinx.coroutines.*

class SliderActivity : AppCompatActivity() {

    companion object{
        private const val min = 13.56f
        private const val max = 110.5f
        private const val defValue = 16f
        private const val step = 13f
    }



    private val defDispatcher: CoroutineDispatcher = Dispatchers.IO
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slider)
        val container = findViewById<LinearLayoutCompat>(R.id.vContainer)
        val slider = setUpSlider()
        container.addView(slider)
        val editText = findViewById<EditText>(R.id.vText)


        slider.addOnChangeListener { _, value, fromUser ->
            if(fromUser){
                editText.setText(value .toString())
            }
        }

       GlobalScope.launch(defDispatcher){
            ensureActive()
        }
        val job2 = CoroutineScope(defDispatcher).launch {

        }

        val job3 = lifecycleScope.launch(defDispatcher){

        }


    }

    private fun setUpSlider (): Slider{
        return Slider(this).apply {
            valueFrom = min
            valueTo = checkMax()
            stepSize = step
            value = checkValue()
        }
    }

    private fun checkMax(): Float{
        return when {
            step == 0f -> max
            (max - min) % step == 0f -> {
                max
            }
            else -> {
                val bal = (max - min) % step
                max - bal
            }
        }
    }

    private fun checkValue(): Float{
        return when {
            step == 0f -> defValue
            (defValue - min) % step == 0f -> {
                defValue
            }
            else -> {
                val balance = (defValue - min) % step
                defValue - balance
            }
        }
    }


}