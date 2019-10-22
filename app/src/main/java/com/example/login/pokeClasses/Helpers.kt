package com.example.login.pokeClasses

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService

class Helpers {


    companion object{
        fun View.hideKeyboard(): Boolean {
            try {
                val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                return inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
            } catch (ignored: RuntimeException) { }
            return false
        }
    }
}