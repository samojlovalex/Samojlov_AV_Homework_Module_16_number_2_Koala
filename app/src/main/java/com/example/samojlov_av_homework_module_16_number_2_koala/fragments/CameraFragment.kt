package com.example.samojlov_av_homework_module_16_number_2_koala.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.samojlov_av_homework_module_16_number_2_koala.R
import com.example.samojlov_av_homework_module_16_number_2_koala.databinding.FragmentCameraBinding


class CameraFragment : Fragment() {

    private lateinit var binding: FragmentCameraBinding
    private lateinit var photoIV: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentCameraBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }
    @SuppressLint("CommitTransaction")
    private fun init(){
        photoIV = binding.photoIV

        photoIV.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.add(R.id.containerFragmentFCV,StartFragment())
                ?.remove(this)
                ?.commit()
        }

    }

}