package com.example.testproject.observable.with_view_model

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.testproject.R
import com.example.testproject.observable.with_view_model.viewmodel.MyViewModel
import com.google.android.material.button.MaterialButton

class ObserveFragmentWithViewModel: Fragment(){

    private val viewModel by activityViewModels<MyViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_observe_with_viewmodel, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       view.findViewById<MaterialButton>(R.id.vSendActivity).setOnClickListener {
           viewModel.sendData("send text from fragment by viewModel")
       }
    }
}