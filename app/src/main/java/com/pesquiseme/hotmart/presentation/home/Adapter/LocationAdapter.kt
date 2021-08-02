package com.pesquiseme.hotmart.presentation.home.Adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pesquiseme.hotmart.domain.models.Location

class LocationAdapter() : RecyclerView.Adapter<ViewHolderSmall>() {

    var locationList = ArrayList<Location>()
    var onItemClick: ((Location) -> Unit)? = null

    fun updateList(locations: List<Location>) {
        locationList.clear()
        locationList.addAll(locations)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderSmall {
        return ViewHolderSmall.from(parent)
    }

    override fun getItemCount(): Int {
        return this.locationList.size
    }

    override fun onBindViewHolder(holder: ViewHolderSmall, position: Int) {
        val location = locationList[position]
        holder.bind(location, onItemClick, position)
    }


}
