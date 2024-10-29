package com.example.kulinerapps

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kulinerapps.databinding.FragmentWisataBinding

class WisataFragment : Fragment(), FoodAdapter.OnItemClickListener {

    private var _binding: FragmentWisataBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWisataBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val wisataList = listOf(
            FoodItem("Candi Prambanan", "Candi Buddha terbesar di dunia", R.drawable.prambanan),
            FoodItem("Keraton Yogyakarta", "lorem ipsum", R.drawable.keraton),
            FoodItem("Taman Sari", "Tempat peman", R.drawable.taman)
        )

        binding.wisataRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.wisataRecyclerView.adapter = FoodAdapter(wisataList, this)
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
