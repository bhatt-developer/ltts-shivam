package com.example.ltts.presentation.car_details

import android.app.Dialog
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.ltts.R
import com.example.ltts.data.dto.model.CarModelDto
import com.example.ltts.databinding.BottomSheetBinding
import com.example.ltts.databinding.FragmentCarDetailsBinding
import com.example.ltts.domain.model.CarModel
import com.example.ltts.presentation.car_list.CartDetailsUiState
import com.example.ltts.presentation.car_list.MainUiState
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CarDetailsFragment : Fragment() {
    private lateinit var binding : FragmentCarDetailsBinding
    private lateinit var car : CarModel
    private lateinit  var carDetails : CarModelDto
    private val viewModel by lazy { ViewModelProvider(this).get(CarDetailsViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            carDetails =  CarDetailsFragmentArgs.fromBundle(it).car
            viewModel.getCarDetails(carDetails.number)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layoutInflater = LayoutInflater.from(context)
        binding =  FragmentCarDetailsBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            binding.progressBar.visibility
            viewModel.state.collect{
                when(it){
                    is CartDetailsUiState.Error -> { Toast.makeText(requireContext(),it.error.toString(), Toast.LENGTH_SHORT).show()}
                    CartDetailsUiState.Init -> {}
                    CartDetailsUiState.Loading -> {binding.progressBar.visibility = View.VISIBLE}
                    is CartDetailsUiState.Success -> {
                        binding.progressBar.visibility = View.GONE
                       carDetails =  it.car
                        binding.apply {
                            Glide.with(imagePaths).load(carDetails.imageUrl).centerCrop().into(imagePaths)
                            "Car brand   :  ${carDetails.brand}".also { brandTv.text = it }
                            "Car name   :  ${carDetails.name}".also { nameTv.text = it }
                           // "Car number   :${carDetails.number}".also { numberTv.text = it }
                            "Car Description   :\n ${carDetails.desc}".also { descTv.text = it }
                        }
                    }
                }
            }
        }

binding.cardUpdate.setOnClickListener {
    openBottomSheet()
}

    }





    private fun openBottomSheet(){
        val dialog = BottomSheetDialog(requireActivity(), R.style.BottomSheetDialog)
        dialog.behavior.state = BottomSheetBehavior.STATE_EXPANDED
        val inflate = LayoutInflater.from(requireActivity())
        val bottomSheet = DataBindingUtil.inflate<BottomSheetBinding>(inflate, R.layout.bottom_sheet,
            null, false)

        bottomSheet.saveBtn.setOnClickListener {
           val brandName = bottomSheet.brandNameEt.text.toString().trim()
           val carName =   bottomSheet.nameEt.text.toString().trim()
           val desc =      bottomSheet.descEt.text.toString().trim()

           val validationResult =  viewModel.brandNameValidateCredentials(brandName,carName , desc)
           if (validationResult.first){
               viewModel.updateBrand(carDetails.number,brandName,carName,desc)
           }else{
               Toast.makeText(requireContext(),validationResult.second, Toast.LENGTH_SHORT).show()
           }
       }
        dialog.apply {
        setContentView(bottomSheet.root)
        setCancelable(true)
       show()
   }

    }

}