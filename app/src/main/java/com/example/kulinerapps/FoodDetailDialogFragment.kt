package com.example.kulinerapps

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.kulinerapps.databinding.DialogFoodDetailBinding

class FoodDetailDialogFragment : DialogFragment() {

    companion object {
        private const val ARG_FOOD_ITEM = "food_item"

        fun newInstance(foodItem: FoodItem): FoodDetailDialogFragment {
            val fragment = FoodDetailDialogFragment()
            val args = Bundle().apply {
                putParcelable(ARG_FOOD_ITEM, foodItem)
            }
            fragment.arguments = args
            return fragment
        }
    }

    private lateinit var foodItem: FoodItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        foodItem = arguments?.getParcelable(ARG_FOOD_ITEM)
            ?: throw IllegalArgumentException("FoodItem must not be null")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DialogFoodDetailBinding.inflate(inflater, container, false)

        // Mengisi data dari foodItem ke tampilan
        binding.foodName.text = foodItem.name
        binding.foodDescription.text = foodItem.description
        binding.foodImage.setImageResource(foodItem.imageResId)

        // Mengatur ukuran dialog agar sesuai dengan ukuran konten
        dialog?.window?.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)

        return binding.root
    }
}
