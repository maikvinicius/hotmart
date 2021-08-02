package com.pesquiseme.hotmart.presentation.component.bottom_navigation

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.widget.RelativeLayout
import com.pesquiseme.hotmart.R
import com.pesquiseme.hotmart.presentation.component.bottom_navigation_icon.BottomNavigationIcon
import kotlinx.android.synthetic.main.component_bottom_navigation.view.*

class BottomNavigation(context: Context?, attrs: AttributeSet?) :
    RelativeLayout(context, attrs) {

    private val navigationListener: BottomNavigationListener

    init {
        if (context is BottomNavigationListener) {
            navigationListener = context
        } else {
            throw RuntimeException("BottomNavigation's context MUST implement BottomNavigationListener interface")
        }

        LayoutInflater.from(context).inflate(R.layout.component_bottom_navigation, this, true)

        setOnClickListenerForMenuItem(menuHome)
        setOnClickListenerForMenuItem(menuMap)
        setOnClickListenerForMenuItem(menuProfile)

        menuHome.setChecked(true)
    }

    fun selectMenuForScreen(destination: BottomNavigationDestination) {
        unSelectAll()
        getFirstLevelMenuItemForDestination(destination)?.setChecked(true)
    }

    private fun setOnClickListenerForMenuItem(menuItem: BottomNavigationIcon) {
        menuItem.setOnClickListener(
            when (menuItem) {
                menuHome -> OnClickListener {
                    goHome()
                }
                menuMap -> OnClickListener {
                    goMap()
                }
                menuProfile -> OnClickListener {
                    goProfile()
                }
                else -> null
            }
        )
    }

    private fun getFirstLevelMenuItemForDestination(destination: BottomNavigationDestination): BottomNavigationIcon? {
        return when (destination) {
            BottomNavigationDestination.HOME -> menuHome
            BottomNavigationDestination.MAP -> menuMap
            BottomNavigationDestination.PROFILE -> menuProfile
            else -> null
        }
    }

    private fun unSelectAll() {
        menuHome.setChecked(false)
        menuMap.setChecked(false)
        menuProfile.setChecked(false)
    }

    private fun goHome() {
        selectMenuForScreen(BottomNavigationDestination.HOME)
        navigationListener.goHome()
    }

    private fun goMap() {
        selectMenuForScreen(BottomNavigationDestination.MAP)
        navigationListener.goMap()
    }

    private fun goProfile() {
        selectMenuForScreen(BottomNavigationDestination.PROFILE)
        navigationListener.goProfile()
    }

}