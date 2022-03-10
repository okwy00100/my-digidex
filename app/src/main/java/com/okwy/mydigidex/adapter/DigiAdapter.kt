package com.okwy.mydigidex.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.okwy.mydigidex.databinding.ItemDigimonCardBinding
import com.okwy.mydigidex.entity.Digimon
import java.util.*
import kotlin.collections.ArrayList

class DigiAdapter(
    private val listItemClickListener: ListItemClickListener
) : ListAdapter<Digimon, DigiAdapter.DigiViewHolder>(DigimonComparator()) {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DigiViewHolder {
        val binding =
            ItemDigimonCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DigiViewHolder(binding)
    }


    override fun onBindViewHolder(holder: DigiViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null)
            holder.bind(item, listItemClickListener)
    }




    interface ListItemClickListener {
        fun onListItemClick(digimon: Digimon, adapterPosition: Int)
    }



    class DigiViewHolder(private val binding: ItemDigimonCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(digimon: Digimon, listItemClickListener: ListItemClickListener) {
            binding.apply {
                Glide.with(root)
                    .load(digimon.img)
                    .centerCrop()
                    .into(digimonImage)

                digimonName.text = digimon.name
                digimonLevel.text = digimon.level
                root.setOnClickListener {
                    listItemClickListener.onListItemClick(
                        digimon,
                        this@DigiViewHolder.adapterPosition
                    )
                }

            }
        }
    }


    class DigimonComparator : DiffUtil.ItemCallback<Digimon>() {
        override fun areItemsTheSame(oldItem: Digimon, newItem: Digimon) =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: Digimon, newItem: Digimon) = oldItem == newItem

    }




}

