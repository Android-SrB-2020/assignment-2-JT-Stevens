package com.nbcc.assignmnet2_richardandmortimertrivia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.nbcc.assignmnet2_richardandmortimertrivia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var drawrLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(
                this,
                R.layout.activity_main
            )

        navController = this.findNavController(R.id.navHostFragment)
        drawrLayout = binding.drawerLayout

        NavigationUI.setupActionBarWithNavController(this, navController, drawrLayout)

        NavigationUI.setupWithNavController(
            binding.navView,
            navController
        )
    }

    override fun onSupportNavigateUp(): Boolean {
//        val navController = this.findNavController(R.id.navHostFragment)
//        return navController.navigateUp()
        return NavigationUI.navigateUp(navController, drawrLayout)
    }
}
