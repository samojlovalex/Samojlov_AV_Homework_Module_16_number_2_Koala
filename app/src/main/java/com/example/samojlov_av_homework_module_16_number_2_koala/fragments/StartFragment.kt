package com.example.samojlov_av_homework_module_16_number_2_koala.fragments

import android.Manifest
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.samojlov_av_homework_module_16_number_2_koala.R
import com.example.samojlov_av_homework_module_16_number_2_koala.databinding.FragmentStartBinding


class StartFragment : Fragment() {

    private lateinit var binding: FragmentStartBinding
    private lateinit var cameraPermissionBT: Button
    private lateinit var contactPermissionBT: Button

    private var fragment: Fragment? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentStartBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    @SuppressLint("CommitTransaction")
    private fun init() {
        cameraPermissionBT = binding.cameraPermissionBT
        contactPermissionBT = binding.contactPermissionBT

        cameraPermissionBT.setOnClickListener {
            val permission = Manifest.permission.CAMERA
            fragment = CameraFragment()
            permissionLauncherSingle.launch(permission)
        }

        contactPermissionBT.setOnClickListener {
            val permission = Manifest.permission.READ_CONTACTS
            fragment = ContactsFragment()
            permissionLauncherSingle.launch(permission)
        }
    }

    private val permissionLauncherSingle = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            if (fragment != null) {
                singlePermissionGranted(fragment!!)
            }
        } else {
            Toast.makeText(
                context,
                getString(R.string.permissionLauncherSingle_Toast_else), Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun singlePermissionGranted(fragment: Fragment) {
        activity?.supportFragmentManager?.beginTransaction()
            ?.add(R.id.containerFragmentFCV, fragment)
            ?.remove(this)
            ?.commit()
    }

}