package com.example.testanimation

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class MyApplication : Application() {
    companion object {
        const val CHANNEL_ID: String = "CHANNEL_1"
        const val CHANNEL_ID_2: String = "CHANNEL_2"
    }


    override fun onCreate() {
        super.onCreate()

        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Create the NotificationChannel
            val name = getString(R.string.channel_name)
            val descriptionText = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val mChannel = NotificationChannel(CHANNEL_ID, name, importance)
            mChannel.description = descriptionText

            //Channel two
            val name2 = getString(R.string.channel_name_2)
            val descriptionText2 = getString(R.string.channel_description_2)
            val importance2 = NotificationManager.IMPORTANCE_DEFAULT
            val mChannel2 = NotificationChannel(CHANNEL_ID, name2, importance2)
            mChannel2.description = descriptionText2

            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(mChannel)
            notificationManager.createNotificationChannel(mChannel2)
        }
    }
}