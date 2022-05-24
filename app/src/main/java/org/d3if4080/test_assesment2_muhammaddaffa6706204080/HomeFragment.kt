package org.d3if4080.test_assesment2_muhammaddaffa6706204080

import android.app.AlertDialog
import android.app.AlertDialog.Builder
import android.content.DialogInterface
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import org.d3if4080.test_assesment2_muhammaddaffa6706204080.DataBase.dao.HistoryDao
import org.d3if4080.test_assesment2_muhammaddaffa6706204080.DataBase.dao.RoomDb
import org.d3if4080.test_assesment2_muhammaddaffa6706204080.Models.History
import org.d3if4080.test_assesment2_muhammaddaffa6706204080.Repository.HistoryRepository
import org.d3if4080.test_assesment2_muhammaddaffa6706204080.ViewModel.HistoryViewModel
import org.d3if4080.test_assesment2_muhammaddaffa6706204080.ViewModel.HistoryViewModelFactory
import org.d3if4080.test_assesment2_muhammaddaffa6706204080.databinding.ActivityMainBinding
import org.d3if4080.test_assesment2_muhammaddaffa6706204080.databinding.FragmentHomeBinding
import java.text.DecimalFormat


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    lateinit var selectedUnit: String
    val ViewModel : HistoryViewModel by lazy {
        val db = RoomDb.getInstance(requireContext())
        val repo = HistoryRepository (db.HistoryDao)
        val factory = HistoryViewModelFactory (repo)
        ViewModelProvider(this,factory)[HistoryViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val df = DecimalFormat("#.##")//Decimal formatter
        selectedUnit = "Fahrenheit"

        binding.selectType.setOnClickListener() {


        }

        binding.ButtonInp.setOnClickListener() {
            val resultText: String
            var inputVal = binding.editInput.text.toString()
            var history:History
            if (inputVal.isNotEmpty()) {
                var doubleInput = inputVal.toDouble()
                if (selectedUnit == "Fahrenheit") {
                    val rumus = (doubleInput - 32) * 5 / 9
                    resultText = df.format(rumus)
                    binding.textResultType.text = "Celcius"
                    history = History(0, 0,rumus.toInt())
                } else {
                    //(0°C × 9/5) + 32
                        val rumus = ((doubleInput * 9 / 5) + 32)
                    resultText = df.format(rumus)
                    binding.textResultType.text = "Fahrenheit"
                    history = History(0, rumus.toInt(),0)
                }
                ViewModel.InsertHistory(history)
                ViewModel.getAllResource.observe(requireActivity()) {
                    Log.d("tes","size histpry: " + it.size)
                }
                binding.textResult.text = resultText
            }
        }

        binding.SwitchDark.setOnCheckedChangeListener() { CompoundButton, isChecked ->
            when (isChecked) {
                true -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)


                }
                false -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

                }
            }

        }


    }




//    private fun showAlertDialog() {
//        val alertDialog: Builder = Builder(this@HomeFragment)
//        alertDialog.setTitle("Select Unit") //Setting title for alertBox
//        val items = arrayOf("Fahrenheit", "Celsius")
//        val checkedItem = -1
//        alertDialog.setSingleChoiceItems(items, checkedItem,
//            DialogInterface.OnClickListener { dialog, which ->
//                selectedUnit = items[which]
//                binding.textType.setText(items[which])
//            })
//        alertDialog.setPositiveButton(
//            android.R.string.ok,
//            DialogInterface.OnClickListener { dialog, which ->
//                dialog.dismiss()
//            })
//        val alert: AlertDialog = alertDialog.create()
//        alert.setCanceledOnTouchOutside(false)
//        alert.show()
//    }
}










