package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myapplication.AjustesFragment
import com.example.myapplication.HomeFragment
import com.example.myapplication.R
import com.example.myapplication.SinistrosFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configura o BottomNavigationView
        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation)

        // Define o fragmento inicial (HomeFragment)
        loadFragment(HomeFragment())

        // Configura o listener para alternar entre os fragmentos
        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> loadFragment(HomeFragment())
                R.id.navigation_sinistros -> loadFragment(SinistrosFragment())
                R.id.navigation_ajustes -> loadFragment(AjustesFragment())
            }
            true
        }
    }

    private fun loadFragment(fragment: Fragment) {
        // Carrega o fragmento fornecido no FrameLayout
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
