package com.example.step4_projectdve;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.step4_projectdve.Data.DatabaseHandler;
import com.example.step4_projectdve.Model.Name;

import java.sql.Time;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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


        DatabaseHandler databaseHandler = new DatabaseHandler(this);

//
//        Name name29= new Name();
//        name29.setName("james299");
//        databaseHandler.addItem(name29);

//        Name name19= new Name();
////        name19.setName("james19");
////        databaseHandler.addItem(name19);

//        Name name16= new Name();
//        name16.setName("james16");
//        databaseHandler.addItem(name16);


//        Name name26= new Name();
//        name26.setName("james26");
//        databaseHandler.addItem(name26);




//        Name name= new Name();
//        name.setName("james");
//        databaseHandler.addItem(name);
//
//        Name name12= new Name();
//        name12.setName("james");
//        databaseHandler.addItem(name12);
//
//        Name name13= new Name();
//        name13.setName("james");
//        databaseHandler.addItem(name13);
//
//        Name name14= new Name();
//        name14.setName("james");
//        databaseHandler.addItem(name14);
//
//        Name name15= new Name();
//        name15.setName("james");
//        databaseHandler.addItem(name15);




        List<Name> names = databaseHandler.getAllItems();
        for (Name name1 : names){
            Log.d(TAG, "onCreate: "+"Id::: "+name1.getId()+", name:::"+name1.getName()+", date::: "+name1.getDate()+", time::: "+name1.getTime());
        }

    }
}
