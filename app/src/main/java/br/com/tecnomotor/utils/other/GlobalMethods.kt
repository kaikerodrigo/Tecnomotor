package br.com.tecnomotor.utils.other

import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.util.Log
import java.net.UnknownHostException
import java.text.MessageFormat

class GlobalMethods {

    fun saveSharedPreferences(sharedPreferences: SharedPreferences, key: String?, value: String?) {
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun saveSharedPreferences(sharedPreferences: SharedPreferences, key: String?, value: Long) {
        val editor = sharedPreferences.edit()
        editor.putLong(key, value)
        editor.apply()
    }

    fun recoverSharedPreferences(sharedPreferences: SharedPreferences, key: String?): String? {
        return sharedPreferences.getString(key, "")
    }

    fun clearSharedPreferences(sharedPreferences: SharedPreferences) {
        val editor = sharedPreferences.edit()
        editor.clear().apply()
    }

    fun recoverSharedPreferencesLong(sharedPreferences: SharedPreferences, key: String?): Long {
        return sharedPreferences.getLong(key, 0)
    }

    fun removeSharedPreferences(sharedPreferences: SharedPreferences.Editor, key: String?) : Boolean {
        sharedPreferences.remove(key)
        return sharedPreferences.commit()
    }

    fun isNetworkConnected(context: Context): Boolean {
        try {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
            val netInfo = cm!!.activeNetworkInfo
            return netInfo != null && netInfo.isConnectedOrConnecting
        } catch (e: UnknownHostException) {
            Log.e("ERROR not connected internet", MessageFormat.format("{0}", e))
        }
        return false
    }

}