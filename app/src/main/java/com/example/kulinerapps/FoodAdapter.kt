package com.example.kulinerapps

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kulinerapps.databinding.ItemFoodBinding

class FoodAdapter(
    private val kulinerList: List<FoodItem>,
    private val itemClickListener: OnItemClickListener
) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    inner class FoodViewHolder(private val binding: ItemFoodBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        init {
            binding.root.setOnClickListener(this) // Set listener untuk item
        }

        fun bind(foodItem: FoodItem) {
            binding.foodName.text = foodItem.name
            binding.foodDescription.text = foodItem.description
            binding.foodImage.setImageResource(foodItem.imageResId)
        }

        override fun onClick(v: View?) {
            // Memanggil metode dari listener saat item diklik
            itemClickListener.onItemClick(kulinerList[adapterPosition])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val binding = ItemFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bind(kulinerList[position])
    }

    override fun getItemCount() = kulinerList.size

    interface OnItemClickListener {
        fun onItemClick(foodItem: FoodItem)
    }
}
