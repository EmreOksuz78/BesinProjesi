package com.emreoksuz.besinprojesi.util

import android.content.Context
import android.content.SharedPreferences


class OzelSharedPreferences {

    companion object {

        private val TIME = "time"
        private var sharedPreferences:SharedPreferences? = null

        @Volatile
        private var instance: OzelSharedPreferences? = null

        private val lock = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(lock) {
            instance ?: ozelSharedPreferencesOlustur(context).also {
                instance = it
            }
        }

        private fun ozelSharedPreferencesOlustur(context: Context) : OzelSharedPreferences {
            sharedPreferences = androidx.preference.PreferenceManager.getDefaultSharedPreferences(context)
            return OzelSharedPreferences()
        }

    }

    fun zamaniKaydet(zaman : Long){
        sharedPreferences?.edit()?.putLong(TIME,zaman)?.apply()
    }
    fun zamaniAl() = sharedPreferences?.getLong(TIME,0)
}