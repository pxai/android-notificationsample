package io.pello.android.notificationsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CalledFromNotification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_called_from_notification);
    }
}
