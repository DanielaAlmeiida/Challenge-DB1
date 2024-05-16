package br.com.fiap.sowa.model

import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import androidx.core.app.NotificationCompat
import br.com.fiap.sowa.R
import kotlin.random.Random

class NotificationHandler(private val context: Context) {
    private val notificationManager = context.getSystemService(NotificationManager::class.java)
    private val notificationChannelID = "notification_channel_id"

    // Notificação expandida com texto grande
    fun showExpandedNotificationWithBigText() {
        val bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.mm_a_icon)

        val notification = NotificationCompat.Builder(context, notificationChannelID)
            .setContentTitle("Matchmaking!")
            .setContentText("Ver descrição")
            .setSmallIcon(R.drawable.mma_text)
            .setLargeIcon(bitmap) // Definição do ícone grande com a imagem PNG
            .setPriority(NotificationManager.IMPORTANCE_HIGH)
            .setAutoCancel(true)
            .setStyle(
                NotificationCompat.BigTextStyle()
                    .bigText("Você acabou de dar match com um(a) novo(a) mentor(a)!")
            )
            .build() // Finalização da criação da notificação

        notificationManager.notify(Random.nextInt(), notification)
    }
}