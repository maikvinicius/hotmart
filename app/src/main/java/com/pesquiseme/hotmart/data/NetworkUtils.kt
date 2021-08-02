package com.pesquiseme.hotmart.data

import android.content.Context
import android.net.ConnectivityManager

object NetworkUtils {
    fun isConnectedOrConnecting(context: Context): Boolean {
        val connection = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connection.activeNetworkInfo
        return networkInfo?.isConnectedOrConnecting == true
    }
    fun isConnected(context: Context): Boolean {
        val connection = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connection.activeNetworkInfo
        return networkInfo?.isConnected == true
    }
}