package com.example.ltts.presentation.car_list

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.ltts.R
import com.example.ltts.data.dto.model.CarModelDto
import com.example.ltts.databinding.ItemCatListBinding
import com.example.ltts.domain.model.CarModel

class CarListAdapter : RecyclerView.Adapter<CarListAdapter.CarListViewHolder>() {
 private  var  onItemClickListener : ((CarModelDto) -> Unit)? = null

    //private val carList : List<CarModel>
//TODO : Using DiffUtil
 private val differCallback = object : DiffUtil.ItemCallback<CarModelDto>(){
    override fun areItemsTheSame(oldItem: CarModelDto, newItem: CarModelDto): Boolean {
        return oldItem.imageUrl == newItem.imageUrl
    }

    override fun areContentsTheSame(oldItem: CarModelDto, newItem: CarModelDto): Boolean {
        return oldItem == newItem
    }
 }
    //TODO : AsyncListDiffer which can simplify the use of DiffUtil on a background thread
     val differ = AsyncListDiffer(this,differCallback)


    inner class CarListViewHolder(private val binding: ItemCatListBinding) : ViewHolder(binding.root){
        val rootLayout = binding.rootLayout
         @SuppressLint("SuspiciousIndentation")
         fun bind(car : CarModelDto){
             binding.apply {
                 brandNameTv.text = car.brand
                 carNameTv.text = car.name
                 descTv.text = car.desc
                 Glide.with(imagePaths).load(car.imageUrl).centerCrop().into(imagePaths)
             }

         }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemCatListBinding>(layoutInflater,R.layout.item_cat_list,parent,false )
        return CarListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: CarListViewHolder, position: Int) {
             val car =  differ.currentList[position]
             holder.bind(car)



        holder.rootLayout.setOnClickListener {
            onItemClickListener?.let {itemLambda ->
                itemLambda(car)
            }
        }
    }


    fun setOnItemClickListener(listener : (CarModelDto) -> Unit){
        onItemClickListener = listener
    }

}