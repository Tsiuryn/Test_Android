package com.example.testproject.observable.with_view_model

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.testproject.R
import com.example.testproject.observable.with_view_model.viewmodel.MyViewModel
import kotlinx.coroutines.flow.collect

class SubscriberActivity : AppCompatActivity() {

    private val viewModel by viewModels<MyViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_observable)
        observe()
        supportFragmentManager.beginTransaction().add(R.id.fragment_container_view, ObserveFragmentWithViewModel()).commit()


    }

    private fun observe() {
        lifecycleScope.launchWhenStarted {
            viewModel.subscribeData.collect {
                Toast.makeText(this@SubscriberActivity, it , Toast.LENGTH_SHORT).show()
            }
        }
    }

}