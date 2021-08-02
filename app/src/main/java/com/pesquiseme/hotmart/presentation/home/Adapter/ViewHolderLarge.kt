package com.pesquiseme.hotmart.presentation.home.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pesquiseme.hotmart.R
import com.pesquiseme.hotmart.databinding.HolderLocationLargeBinding
import com.pesquiseme.hotmart.domain.models.Location

class ViewHolderLarge(val binding: HolderLocationLargeBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(location: Location, onItemClick: ((Location) -> Unit)?) {
        binding.tvName.text = location.name
        binding.tvCategory.text = location.type
        binding.tvReview.text = location.review.toString()

        getStars(binding, location)

        binding.cvLocation.setOnClickListener {
            onItemClick?.invoke(location)
        }
    }

    fun getStars(binding: HolderLocationLargeBinding, location: Location){

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
        fun from(parent: ViewGroup): RecyclerView.ViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = HolderLocationLargeBinding.inflate(layoutInflater, parent, false)
            return ViewHolderLarge(binding)
        }
    }

}