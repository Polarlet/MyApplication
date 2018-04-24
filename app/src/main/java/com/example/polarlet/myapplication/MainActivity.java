package com.example.polarlet.myapplication;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button alarmOn;
    EditText editAlarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alarmOn = (Button) findViewById(R.id.alarmOn);
        editAlarm = (EditText) findViewById(R.id.editAlarm);

        alarmOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int time = Integer.parseInt(editAlarm.getText().toString());
                Intent i = new Intent(MainActivity.this, Timer.class);
                PendingIntent pi = PendingIntent.getBroadcast(getApplicationContext(),
                        0, i, 0);
                AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
                am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + time * 1000,pi);
            }
        });
    }
}
