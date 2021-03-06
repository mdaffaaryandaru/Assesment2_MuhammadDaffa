package org.d3if4080.test_assesment2_muhammaddaffa6706204080.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import org.d3if4080.test_assesment2_muhammaddaffa6706204080.Models.History
import org.d3if4080.test_assesment2_muhammaddaffa6706204080.ViewModel.HistoryViewModel
import org.d3if4080.test_assesment2_muhammaddaffa6706204080.data.Temperature
import org.d3if4080.test_assesment2_muhammaddaffa6706204080.databinding.ItemHistoryBinding

class ResourceListAdapter(val viewModel: HistoryViewModel, val context: Context) :
    RecyclerView.Adapter<ResourceListAdapter.ViewHolder>() {

    private val data = mutableListOf<Temperature>()

    fun updateData(newData: List<Temperature>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    companion object {
        private val DIFF_CALLBACK =
            object : DiffUtil.ItemCallback<History>() {
                override fun areItemsTheSame(
                    oldItem: History,
                    newItem: History
                ): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(
                    oldItem: History,
                    newItem: History
                ): Boolean {
                    return oldItem == newItem
                }
            }
    }

    class ViewHolder(
        val binding: ItemHistoryBinding,
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Temperature) = with(binding) {
            input.text = item.input.toString()
            type.text = item.type
            convert.text = item.convert.toString()
//            CelciusTab.text =
//                if (item.celcius !== 0) item.celcius.toString() else if (item.fahrenheit !== 0) item.fahrenheit.toString() else "0"


//            DeleteButton.setOnClickListener {
//                MaterialAlertDialogBuilder(context).setMessage("Yakin Nih Mau Delete?")
//                    .setPositiveButton("Yes") { _, _ ->
////                        viewModel.deleteHistory(item.id)
//
//                    }
//                    .setNegativeButton("No"){dialog,_->
//                        dialog.cancel()
//            }.show()
//
//        }


    }
}


override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

    val inflater = LayoutInflater.from(parent.context)
    val binding = ItemHistoryBinding.inflate(inflater, parent, false)
    return ViewHolder(binding)
}

override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(data[position])
}

    override fun getItemCount(): Int = data.size

}