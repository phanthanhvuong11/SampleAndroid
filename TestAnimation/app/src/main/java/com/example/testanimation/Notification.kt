package com.example.testanimation

import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_notification.*
import java.util.*

class Notification : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        btnSend.setOnClickListener {
            sendNotification()
        }
    }

    private fun sendNotification() {
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.banks)
        val notification = NotificationCompat.Builder(this, MyApplication.CHANNEL_ID)
            .setContentTitle("Title push Notification")
            .setContentText("Message push Notification")
            .setSmallIcon(R.drawable.hotels)
            .setLargeIcon(bitmap)
            .build()

        val manager: NotificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(getNotificationId(), notification)

    }

    private fun getNotificationId():Int{
        return Date().time.toInt()
    }
}