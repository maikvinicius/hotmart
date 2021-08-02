package com.pesquiseme.hotmart.presentation.home.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pesquiseme.hotmart.R
import com.pesquiseme.hotmart.databinding.HolderLocationSmallBinding
import com.pesquiseme.hotmart.domain.models.Location

class ViewHolderSmall(val binding: HolderLocationSmallBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(location: Location, onItemClick: ((Location) -> Unit)?, position: Int) {
        binding.tvName.text = location.name
        binding.tvCategory.text = location.type
        binding.tvReview.text = location.review.toString()

        binding.ivPhoto.layoutParams.height = (300..600).random()

        when(location.type){
            TypeEnum.BARBEARIA.type -> binding.ivPhoto.setImageResource(R.color.green_water)
            TypeEnum.BARES.type -> binding.ivPhoto.setImageResource(R.color.pink_baby)
            TypeEnum.CAFETERIA.type -> binding.ivPhoto.setImageResource(R.color.pastel_yellow)
            TypeEnum.COWORKING.type -> binding.ivPhoto.setImageResource(R.color.green_water)
            TypeEnum.RESTAURANTE.type -> binding.ivPhoto.setImageResource(R.color.pink_baby)
            TypeEnum.PADARIA.type -> binding.ivPhoto.setImageResource(R.color.pastel_yellow)
            TypeEnum.SUCOS_NATURAIS.type -> binding.ivPhoto.setImageResource(R.color.green_water)
            TypeEnum.PRODUTOS_NATURAIS.type -> binding.ivPhoto.setImageResource(R.color.pink_baby)
            TypeEnum.SUPERMERCADO.type -> binding.ivPhoto.setImageResource(R.color.pastel_yellow)
            else -> {
                binding.ivPhoto.setImageResource(R.color.green_water)
            }
        }

        getStars(binding, location)

        binding.cvLocation.setOnClickListener {
            onItemClick?.invoke(location)
        }
    }

    fun getStars(binding: HolderLocationSmallBinding, location: Location){

        binding.ivStar1.setImageResource(R.drawable.star_large_incomplete)
        binding.ivStar2.setImageResource(R.drawable.star_large_incomplete)
        binding.ivStar3.setImageResource(R.drawable.star_large_incomplete)
        binding.ivStar4.setImageResource(R.drawable.star_large_incomplete)
        binding.ivStar5.setImageResource(R.drawable.star_large_incomplete)

        if(location.review > 0.5 && location.review <= 1.5){
            binding.ivStar1.setImageResource(R.drawable.star_large)
        }

        if(location.review > 1.5 && location.review <= 2.5){
            binding.ivStar1.setImageResource(R.drawable.star_large)
            binding.ivStar2.setImageResource(R.drawable.star_large)
        }

        if(location.review > 2.5 && location.review <= 3.5){
            binding.ivStar1.setImageResource(R.drawable.star_large)
            binding.ivStar2.setImageResource(R.drawable.star_large)
            binding.ivStar3.setImageResource(R.drawable.star_large)
        }

        if(location.review > 3.5 && location.review <= 4.5){
            binding.ivStar1.setImageResource(R.drawable.star_large)
            binding.ivStar2.setImageResource(R.drawable.star_large)
            binding.ivStar3.setImageResource(R.drawable.star_large)
            binding.ivStar4.setImageResource(R.drawable.star_large)
        }

        if(location.review > 4.5 && location.review <= 5){
            binding.ivStar1.setImageResource(R.drawable.star_large)
            binding.ivStar2.setImageResource(R.drawable.star_large)
            binding.ivStar3.setImageResource(R.drawable.star_large)
            binding.ivStar4.setImageResource(R.drawable.star_large)
            binding.ivStar5.setImageResource(R.drawable.star_large)
        }

    }

    companion object {
        fun from(parent: ViewGroup): ViewHolderSmall {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = HolderLocationSmallBinding.inflate(layoutInflater, parent, false)
            return ViewHolderSmall(binding)
        }
    }

}