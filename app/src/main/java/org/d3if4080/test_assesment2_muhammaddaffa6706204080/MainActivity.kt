package org.d3if4080.test_assesment2_muhammaddaffa6706204080

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.d3if4080.test_assesment2_muhammaddaffa6706204080.databinding.ActivityMainBinding
import org.d3if4080.test_assesment2_muhammaddaffa6706204080.databinding.FragmentDataTypeBinding
import org.d3if4080.test_assesment2_muhammaddaffa6706204080.databinding.FragmentHomeBinding

class MainActivity : AppCompatActivity() {

    private var aboutFragment = AboutFragment()
    private var historyFragment = HistoryFragment()
    private var homeFragment = HomeFragment()
    private var dataFragment = DataTypeFragment()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)


        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)


        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {

                R.id.homeic -> {
                    homeFragment = HomeFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragmentContainerView, homeFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                R.id.historyic -> {
                    historyFragment = HistoryFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragmentContainerView, historyFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                R.id.aboutic -> {
                    aboutFragment = AboutFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragmentContainerView, aboutFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                R.id.icdata -> {
                    dataFragment = DataTypeFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragmentContainerView, dataFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()

                }
            }
            true
        }


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()

    }
}








