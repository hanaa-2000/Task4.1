package com.example.task41;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class Fristactivity extends AppCompatActivity {
    long delay=2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fristactivity);
        Timer r=new Timer();
        TimerTask showsplash=new TimerTask() {
            @Override
            public void run() {
                Intent i=new Intent(Fristactivity.this,MainActivity.class);
                startActivity(i);
            }
        };
        r.schedule(showsplash,delay);

    }
}