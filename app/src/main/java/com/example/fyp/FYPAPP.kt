package com.example.fyp

import android.app.Application
import com.cloudinary.android.MediaManager

class FYPAPP : Application() {
    override fun onCreate() {
        super.onCreate()
        initateMediaManger()
    }

    private fun initateMediaManger() {
        val config = mapOf(
            "cloud_name" to "djd7stvwg",
            "api_key" to "138931765972126",
            "api_secret" to "LVzZS46qrFQiVRuXsjjEEHbRptE",
            "secure" to true
        )
        MediaManager.init(this,config)
    }
}