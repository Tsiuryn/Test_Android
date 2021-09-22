package com.example.testproject.observable.with_interface

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.testproject.R
import com.example.testproject.observable.with_interface.`interface`.PressListener
import com.example.testproject.observable.with_interface.`interface`.PressListener2
import com.google.android.material.button.MaterialButton
import java.util.*

class ObserveFragment(
    private var fragmentObserver: PressListener? = null
) : Fragment(){

    private var observer: PressListener2? = null

    //todo if Activity implement Interface
    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            observer = context as PressListener2
        }catch (castException: ClassCastException){
            throw ClassCastException("${requireActivity()} must implement PressListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_observe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<MaterialButton>(R.id.vSendActivity).setOnClickListener{
            fragmentObserver?.onPressListener(UUID.randomUUID().toString())
        }

        view.findViewById<MaterialButton>(R.id.vSendActivity2).setOnClickListener{
            observer?.onPressListener(UUID.randomUUID().toString())
        }

    }

}