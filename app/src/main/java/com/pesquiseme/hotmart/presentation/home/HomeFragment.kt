package com.pesquiseme.hotmart.presentation.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.pesquiseme.hotmart.R
import com.pesquiseme.hotmart.databinding.FragmentHomeBinding
import com.pesquiseme.hotmart.presentation.Utils
import com.pesquiseme.hotmart.presentation.home.Adapter.LocationAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val viewModel: HomeFragmentViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        getMessageError(viewModel)
        getAdapter(binding, viewModel)
        return binding.root
    }

    private fun getAdapter(binding:FragmentHomeBinding, viewModel: HomeFragmentViewModel){
        val adapter = LocationAdapter()
        binding.rvLocation.adapter = adapter
        binding.rvLocation.layoutManager = LinearLayoutManager(context)

        adapter.onItemClick = { location ->
            Log.d("MAIK", "MAIK $location.name")
        }

        viewModel.locations.observe(viewLifecycleOwner) {
            if (!it.isNullOrEmpty()){
                adapter.updateList(it)
            }
        }
    }

    private fun getMessageError(viewModel: HomeFragmentViewModel){
        viewModel.error.observe(viewLifecycleOwner) { error ->
            if(error != null){
                if(error.isEmpty())
                    context?.let { it -> Utils.showError(it.getString(R.string.alert_message_error), it) }
                else
                    context?.let { it -> Utils.showError(error, it) }
            }
        }
    }

}