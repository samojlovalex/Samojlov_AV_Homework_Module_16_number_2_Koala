package com.example.samojlov_av_homework_module_16_number_2_koala.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.samojlov_av_homework_module_16_number_2_koala.R
import com.example.samojlov_av_homework_module_16_number_2_koala.databinding.FragmentContactsBinding
import com.example.samojlov_av_homework_module_16_number_2_koala.models.PhoneBook
import com.example.samojlov_av_homework_module_16_number_2_koala.utils.PhoneBookAdapter

class ContactsFragment : Fragment() {

    private lateinit var binding: FragmentContactsBinding
    private lateinit var listContactsRV: RecyclerView

    private var adapter: PhoneBookAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentContactsBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        item()
    }

    private fun item() {

        listContactsRV = binding.listContactsRV
        listContactsRV.layoutManager = LinearLayoutManager(context)

        adapter = PhoneBookAdapter(PhoneBook.phoneBook)
        listContactsRV.adapter = adapter
        listContactsRV.setHasFixedSize(true)

        adapter!!.setOnPhoneBookClickListener(object : PhoneBookAdapter.OnPhoneBookClickListener {
            override fun onPhoneClick(phoneBook: PhoneBook, position: Int) {
                activity?.supportFragmentManager?.beginTransaction()
                    ?.add(R.id.containerFragmentFCV, StartFragment())
                    ?.remove(this@ContactsFragment)
                    ?.commit()
            }

        })

    }
}