package com.example.kulinerapps

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kulinerapps.databinding.FragmentKulinerBinding

class KulinerFragment : Fragment(), FoodAdapter.OnItemClickListener {

    private var _binding: FragmentKulinerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentKulinerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val kulinerList = listOf(
            FoodItem("Gudeg Jogja", "Kuliner khas Jogja dengan bahan nangka muda", R.drawable.gudeg),
            FoodItem("Bakpia Pathok", "Kue isi kacang hijau yang terkenal di Jogja", R.drawable.bakpia),
            FoodItem("Sate Klatak", "Sate kambing khas Jogja", R.drawable.sate)
        )

        binding.kulinerRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.kulinerRecyclerView.adapter = FoodAdapter(kulinerList, this)
    }

    override fun onItemClick(foodItem: FoodItem) {
        val dialog = FoodDetailDialogFragment.newInstance(foodItem)
        dialog.show(childFragmentManager, "FoodDetailDialog")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
