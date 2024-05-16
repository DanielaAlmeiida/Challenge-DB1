package br.com.fiap.sowa.model

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager

class NotificationApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val notificationChannel = NotificationChannel(
            "notification_channel_id",
            "Notification name",
            NotificationManager.IMPORTANCE_HIGH
        )
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        // Configurando o channel
        notificationManager.createNotificationChannel(notificationChannel)
    }
}