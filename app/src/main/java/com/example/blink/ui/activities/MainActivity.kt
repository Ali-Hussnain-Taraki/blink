package com.example.blink.ui.activities

import android.os.Bundle
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.blink.R
import com.example.blink.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView)
        val navController = navHostFragment?.findNavController()
        val popUpMenu = PopupMenu(this, null)
        popUpMenu.inflate(R.menu.bottom_nav)
        if (navController != null) {
            binding.bottomNavBar.setupWithNavController(navController)
            navController.addOnDestinationChangedListener(NavController.OnDestinationChangedListener { _, destination, _ ->
                title = when (destination.id) {
                    R.id.cartScreen -> "Cart"
                    R.id.profileScreen -> "Profile"
                    else -> "Home"

                }
            })


        }
    }
}