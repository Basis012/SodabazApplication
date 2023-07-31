package com.sodabazapplication;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(@NonNull RemoteMessage message) {
        super.onMessageReceived(message);
           getFirebaseMessage(message.getNotification().getTitle(),message.getNotification().getBody());
    }
    public void getFirebaseMessage(String title,String message){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"myFirebasechannel")
                .setSmallIcon(R.drawable.ic_baseline_menu_24)
                .setContentTitle(title)
                .setContentText(message)
                .setAutoCancel(true);
        NotificationManagerCompat manager = NotificationManagerCompat.from(this);
        manager.notify(101,builder.build());
    }
}
