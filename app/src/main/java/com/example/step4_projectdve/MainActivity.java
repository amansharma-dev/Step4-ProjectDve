package com.example.step4_projectdve;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.sql.Time;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public static final String TAG ="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Date currentDateTime = Calendar.getInstance().getTime();
        Log.d(TAG, "onCreate:currentDateTime:: "+currentDateTime.toString());

        String formattedDate = DateFormat.getDateInstance(DateFormat.FULL).format(currentDateTime);
        Log.d(TAG, "onCreate:date is:: "+formattedDate);

        String time = DateFormat.getTimeInstance(DateFormat.SHORT).format(currentDateTime);
        Log.d(TAG, "onCreate:time is:: "+time);
    }
}
