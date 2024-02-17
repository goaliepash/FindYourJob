package ru.practicum.android.diploma.ui

import android.app.Application
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatDelegate

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(getPhoneNightModeValue())
    }

    private fun getPhoneNightModeValue(): Int {
        return applicationContext.resources.configuration.uiMode.and(Configuration.UI_MODE_NIGHT_MASK)
    }
}
