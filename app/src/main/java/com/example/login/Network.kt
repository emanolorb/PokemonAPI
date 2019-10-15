package com.example.login

import android.content.Context
import android.net.ConnectivityManager
import android.os.StrictMode
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class Network {


    companion object{
        fun checkRed(activity:AppCompatActivity):Boolean{
            val conectivityManager = activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = conectivityManager.activeNetworkInfo
            return networkInfo != null && networkInfo.isConnected
        }
    }
}