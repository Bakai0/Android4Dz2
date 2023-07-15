package com.example.kitsu_android4.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsu_android4.R
import com.example.kitsu_android4.databinding.ActivityMainBinding
import com.example.kitsu_android4.utils.PrefernceHelper

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding by viewBinding (ActivityMainBinding::bind)
    private lateinit var navController: NavController

    override fun onStart() {
        super.onStart()
        initialize()
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(binding.root)
    }

    private fun initialize() {
        val prefernceHelper = PrefernceHelper()
        prefernceHelper.unit(this)
        val check = prefernceHelper.saveBoolean
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        if (check == false) {
            val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)
            navController.graph = navGraph
        }

    }

}
}