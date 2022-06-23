package org.d3if4080.test_assesment2_muhammaddaffa6706204080

import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import org.d3if4080.test_assesment2_muhammaddaffa6706204080.Adapter.ResourceListAdapter
import org.d3if4080.test_assesment2_muhammaddaffa6706204080.DataBase.dao.RoomDb
import org.d3if4080.test_assesment2_muhammaddaffa6706204080.Models.History
import org.d3if4080.test_assesment2_muhammaddaffa6706204080.Repository.HistoryRepository
import org.d3if4080.test_assesment2_muhammaddaffa6706204080.ViewModel.HistoryViewModel
import org.d3if4080.test_assesment2_muhammaddaffa6706204080.ViewModel.HistoryViewModelFactory
import org.d3if4080.test_assesment2_muhammaddaffa6706204080.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {

    private lateinit var historyAdapter: ResourceListAdapter
    private lateinit var binding: FragmentHistoryBinding
    val ViewModel: HistoryViewModel by lazy {
        val factory = HistoryViewModelFactory()
        ViewModelProvider(this, factory)[HistoryViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)

        // Inflate the layout for this fragment
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        historyAdapter = ResourceListAdapter(ViewModel, requireContext())
        with(binding.historyRec) {
            adapter = historyAdapter
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
        }
        ViewModel.getData().observe(viewLifecycleOwner, {
            Log.d("data-api", it.toString())
            historyAdapter.updateData(it)
//            historyAdapter.submitList(it)
        })
//        ViewModel.getAllResource.observe(viewLifecycleOwner){
//            historyAdapter.submitList(it)
//        }
        ViewModel.getStatus().observe(viewLifecycleOwner){
            updateProgress(it)
        }
    }

    private fun updateProgress(status: TemperatureApi.ApiStatus?) {
        when (status) {
            TemperatureApi.ApiStatus.LOADING -> {
                binding.progressBar.visibility = View.VISIBLE
            }
            TemperatureApi.ApiStatus.SUCCESS -> {
                binding.progressBar.visibility = View.GONE
            }
            TemperatureApi.ApiStatus.FAILED -> {
                binding.progressBar.visibility = View.GONE
                binding.networkError.visibility = View.VISIBLE
            }
        }
    }
}
