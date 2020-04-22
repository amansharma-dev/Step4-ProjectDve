package com.example.step4_projectdve.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.step4_projectdve.Model.Name;
import com.example.step4_projectdve.R;
import com.example.step4_projectdve.Util.Util;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    public static final String TAG = "DbHandler";

    public DatabaseHandler(@Nullable Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //create table
        String CREATE_TABLE = " CREATE TABLE "+ Util.DATABASE_TABLE_NAME + "("
                +Util.COLUMN_ID + " INTEGER PRIMARY KEY,"
                +Util.COLUMN_NAME  + " TEXT,"
                +Util.COLUMN_DATE  + " LONG,"
                +Util.COLUMN_TIME  + " LONG" + ")";

        sqLiteDatabase.execSQL(CREATE_TABLE);

        Log.d(TAG, "onCreate: table created ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        String DROP_TABLE = String.valueOf((R.string.drop_table));
        sqLiteDatabase.execSQL(DROP_TABLE,new String[]{Util.DATABASE_NAME});

        onCreate(sqLiteDatabase);
    }

    //create

    public void addItem(Name name){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Util.COLUMN_NAME,name.getName());
        contentValues.put(Util.COLUMN_DATE,java.lang.System.currentTimeMillis());
        contentValues.put(Util.COLUMN_TIME,java.lang.System.currentTimeMillis());


        sqLiteDatabase.insert(Util.DATABASE_TABLE_NAME,null,contentValues);
        Log.d(TAG, "addItem: item inserted");
        sqLiteDatabase.close();

    }


    public Name readSingleItem(int id){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor= sqLiteDatabase.query(Util.DATABASE_TABLE_NAME,
                new String[]{
                        Util.COLUMN_ID, Util.COLUMN_NAME,Util.COLUMN_DATE,Util.COLUMN_TIME
                },Util.COLUMN_ID + "=?",new String[]{String.valueOf(id)},
                null,null,null);

        if(cursor!=null)
            cursor.moveToFirst();
        Name name= new Name();
        name.setId(cursor.getInt(cursor.getColumnIndex(Util.COLUMN_ID)));
        name.setName(cursor.getString(cursor.getColumnIndex(Util.COLUMN_NAME)));



        DateFormat date = DateFormat.getDateInstance(DateFormat.FULL);
        DateFormat time = DateFormat.getTimeInstance(DateFormat.SHORT);

        String formattedDate = date.format(new Date(cursor.getLong(cursor.getColumnIndex(Util.COLUMN_DATE))).getTime());
        Log.d(TAG, "getAllItems: DATE ::::" +formattedDate);
        String formattedTime = time.format(new Date(cursor.getLong(cursor.getColumnIndex(Util.COLUMN_TIME))).getTime());
        Log.d(TAG, "getAllItems: TIME ::::" +formattedTime);

        name.setDate(formattedDate);
        name.setTime(formattedTime);
        return name;
    }


    public List<Name> getAllItems(){
        List<Name> nameList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(Util.DATABASE_TABLE_NAME,
                new String[]{
                        Util.COLUMN_ID,
                        Util.COLUMN_NAME,
                        Util.COLUMN_DATE,
                        Util.COLUMN_TIME
                }, null,null,null,null,
                Util.COLUMN_TIME + " DESC");

        if (cursor.moveToFirst()){
            do {

                Name name= new Name();
                name.setId(cursor.getInt(cursor.getColumnIndex(Util.COLUMN_ID)));
                name.setName(cursor.getString(cursor.getColumnIndex(Util.COLUMN_NAME)));

                DateFormat date = DateFormat.getDateInstance(DateFormat.FULL);
                DateFormat time = DateFormat.getTimeInstance(DateFormat.SHORT);

                String formattedDate = date.format(new Date(cursor.getLong(cursor.getColumnIndex(Util.COLUMN_DATE))).getTime());
                Log.d(TAG, "getAllItems: DATE ::::" +formattedDate);
                String formattedTime = time.format(new Date(cursor.getLong(cursor.getColumnIndex(Util.COLUMN_TIME))).getTime());
                Log.d(TAG, "getAllItems: TIME ::::" +formattedTime);

                name.setDate(formattedDate);
                name.setTime(formattedTime);
                nameList.add(name);

            }while (cursor.moveToNext());
        }
        return nameList;
    }
}
