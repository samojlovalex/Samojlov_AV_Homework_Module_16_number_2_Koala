package com.example.samojlov_av_homework_module_16_number_2_koala.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.samojlov_av_homework_module_16_number_2_koala.R
import com.example.samojlov_av_homework_module_16_number_2_koala.models.PhoneBook

class PhoneBookAdapter(private val list: MutableList<PhoneBook>) :
    RecyclerView.Adapter<PhoneBookAdapter.PhoneBookViewHolder>() {


    private var onPhoneBookClickListener: OnPhoneBookClickListener? = null

    interface OnPhoneBookClickListener {
        fun onPhoneClick(phoneBook: PhoneBook, position: Int)
    }

    class PhoneBookViewHolder(itemVieW: View) : RecyclerView.ViewHolder(itemVieW) {
        val name = itemVieW.findViewById<TextView>(R.id.nameTV)!!
        val phone = itemVieW.findViewById<TextView>(R.id.phoneTV)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneBookViewHolder {
        val itemVieW = LayoutInflater.from(parent.context)
            .inflate(R.layout.phone_book_item, parent, false)
        return PhoneBookViewHolder(itemVieW)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: PhoneBookViewHolder, position: Int) {
        val phoneBookPosition = list[position]
        holder.name.text = phoneBookPosition.name
        holder.phone.text = phoneBookPosition.phone

        holder.itemView.setOnClickListener {
            if (onPhoneBookClickListener != null) {
                onPhoneBookClickListener!!.onPhoneClick(phoneBookPosition, position)
            }
        }
    }

    fun setOnPhoneBookClickListener(onPhoneBookClickListener: OnPhoneBookClickListener) {
        this.onPhoneBookClickListener = onPhoneBookClickListener
    }

}