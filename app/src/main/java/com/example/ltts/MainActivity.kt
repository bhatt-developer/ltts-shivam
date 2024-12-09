package com.example.ltts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.ltts.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var navHostFragment: NavHostFragment? = null
    private lateinit var _navController: NavController
    val navController : NavController get() = _navController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // binding = ActivityMainBinding.inflate(layoutInflater)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
    }


    override fun onStart() {
        super.onStart()
        setNavigationGraph()
    }

    private fun setNavigationGraph() {
        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_home) as NavHostFragment?
        assert(navHostFragment != null)
        _navController = navHostFragment!!.navController
        val inflater = navController.navInflater
        val graph = inflater.inflate(R.navigation.car_nav_graph)
        navController.graph = graph
    }
    private fun navigationGraph(){

    }
}