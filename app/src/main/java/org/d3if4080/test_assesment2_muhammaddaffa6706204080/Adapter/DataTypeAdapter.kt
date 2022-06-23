package org.d3if4080.test_assesment2_muhammaddaffa6706204080.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.d3if4080.test_assesment2_muhammaddaffa6706204080.data.Temperature
import org.d3if4080.test_assesment2_muhammaddaffa6706204080.databinding.ItemTemperatureBinding

class DataTypeAdapter : RecyclerView.Adapter<DataTypeAdapter.ViewHolder>() {

    private val data = mutableListOf<Temperature>()

    fun updateData(newData: List<Temperature>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    class ViewHolder(
        val binding: ItemTemperatureBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Temperature) = with(binding) {
            input.text = item.input.toString()
            type.text = item.type
            convert.text = item.convert.toString()
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTemperatureBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }
}