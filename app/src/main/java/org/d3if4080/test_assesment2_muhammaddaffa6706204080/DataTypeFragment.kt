package org.d3if4080.test_assesment2_muhammaddaffa6706204080

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import org.d3if4080.test_assesment2_muhammaddaffa6706204080.Adapter.DataTypeAdapter
import org.d3if4080.test_assesment2_muhammaddaffa6706204080.Adapter.ResourceListAdapter
import org.d3if4080.test_assesment2_muhammaddaffa6706204080.ViewModel.DataViewModel
import org.d3if4080.test_assesment2_muhammaddaffa6706204080.ViewModel.DataViewModelFactory
import org.d3if4080.test_assesment2_muhammaddaffa6706204080.ViewModel.HistoryViewModel
import org.d3if4080.test_assesment2_muhammaddaffa6706204080.ViewModel.HistoryViewModelFactory
import org.d3if4080.test_assesment2_muhammaddaffa6706204080.databinding.FragmentDataTypeBinding
import org.d3if4080.test_assesment2_muhammaddaffa6706204080.databinding.FragmentHistoryBinding


class DataTypeFragment : Fragment() {
    private lateinit var dataTypeAdapter: DataTypeAdapter
    private lateinit var binding: FragmentDataTypeBinding
    val ViewModel: DataViewModel by lazy {
        val factory = DataViewModelFactory()
        ViewModelProvider(this, factory)[DataViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDataTypeBinding.inflate(inflater, container, false)

        // Inflate the layout for this fragment
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataTypeAdapter = DataTypeAdapter()
        with(binding.recyclerView) {
            adapter = dataTypeAdapter
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
        }
        ViewModel.getData().observe(viewLifecycleOwner, {
            Log.d("data-api", it.toString())
            dataTypeAdapter.updateData(it)
//            historyAdapter.submitList(it)
        })
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