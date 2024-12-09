package com.example.ltts.presentation.car_list

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ltts.R
import com.example.ltts.data.dto.model.CarModelDto
import com.example.ltts.databinding.FragmentCarListBinding
import com.example.ltts.domain.model.CarModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CarListFragment : Fragment() {
    private lateinit var binding : FragmentCarListBinding
    private lateinit var carList : ArrayList<CarModelDto>
    private val viewModel by lazy { ViewModelProvider(this).get(CarListViewModel::class.java) }
    private val carListAdapter by lazy { CarListAdapter() }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCarListBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listInitialize()
        setUpData()

        carListAdapter.setOnItemClickListener{
            val bundle = Bundle().apply {
               putSerializable("car", it)
            }
            findNavController().navigate(R.id.action_carListFragment_to_carDetailsFragment,bundle)
        }


    }

    private fun listInitialize(){
        carList = ArrayList()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setUpData(){
      lifecycleScope.launch {

          viewModel.uiStateFlow.collect{
             when(it){
                 is MainUiState.Error -> {
                  Toast.makeText(context,it.error.toString(),Toast.LENGTH_SHORT).show()
                 }
                 MainUiState.Init -> {

                 }
                 MainUiState.Loading -> {
                     binding.progressBar.visibility = View.VISIBLE
                 }
                 is MainUiState.Success -> {
                     binding.progressBar.visibility = View.GONE
                     carList = it.cars as ArrayList<CarModelDto>
                     binding.rvCar.apply {
                         setHasFixedSize(true)
                         layoutManager = LinearLayoutManager(activity)
                         carListAdapter.differ.submitList(carList)
                         adapter = carListAdapter
                     }
                 }

                 else -> {}
             }
          }
      }
    }


}