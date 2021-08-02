package com.pesquiseme.hotmart.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.pesquiseme.hotmart.R
import com.pesquiseme.hotmart.presentation.component.bottom_navigation.BottomNavigationDestination
import com.pesquiseme.hotmart.presentation.component.bottom_navigation.BottomNavigationListener
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), BottomNavigationListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun goHome() {
        findNavController(R.id.navHostFragment).navigate(R.id.actionHome)
        bottomNavigation.selectMenuForScreen(BottomNavigationDestination.HOME)
    }

    override fun goMap() {
        findNavController(R.id.navHostFragment).navigate(R.id.actionMap)
        bottomNavigation.selectMenuForScreen(BottomNavigationDestination.MAP)
    }

    override fun goProfile() {
        findNavController(R.id.navHostFragment).navigate(R.id.actionProfile)
        bottomNavigation.selectMenuForScreen(BottomNavigationDestination.PROFILE)
    }
}