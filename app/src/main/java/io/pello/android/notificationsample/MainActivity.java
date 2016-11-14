package io.pello.android.notificationsample;

import android.app.NotificationManager;
import android.app.PendingIntent;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;

/**
 * Shows the use of notifications
 * @author Pello Altadill
 * Check documentation at:
 * https://developer.android.com/guide/topics/ui/notifiers/notifications.html
 */
public class MainActivity extends AppCompatActivity {
    private int notifyId = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void notifySomething (View v) {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setSmallIcon(R.drawable.notify);
        mBuilder.setContentTitle("New notification by Sample App");
        mBuilder.setContentText("Somebody has a message for you");

        // This will be called from the notification
        Intent resultIntent = new Intent(this, CalledFromNotification.class);

        // We create a stack for the new Activity
        // when we enter the notification and click back we will appear in the main.
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);

       // // Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(CalledFromNotification.class);

        // Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);

        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // notifyId allows us to update the notification, changing the number
        mNotificationManager.notify(notifyId, mBuilder.build());
    }
}
