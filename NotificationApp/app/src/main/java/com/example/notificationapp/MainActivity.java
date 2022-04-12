package com.example.notificationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void genNotification(View view) {
        int id = 1;
        int icon = android.R.drawable.ic_dialog_info;

        Intent intent = new Intent(this, ReceiverActivity.class);
        PendingIntent pIntent =
                PendingIntent.getActivity(this, id, intent, 0);

        Notification n = new Notification.Builder(this)
                .setContentTitle("Necessário atualização")
                .setContentText("App precisa de atualização urgente!")
                .setSmallIcon(icon)
                .setContentIntent(pIntent)
                .setAutoCancel(true)
                .addAction(icon, "call", pIntent)
                .addAction(icon, "More", pIntent)
                .addAction(icon, "And more", pIntent).build();

        NotificationManager nm = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        nm.notify(id, n);
    }
}