package com.example.usoapirestjava;

import android.app.Application;
import androidx.room.Room;
//ROOM
public class EmployeeApp extends Application {
    public static DataBaseApp databaseApp;

    @Override
    public void onCreate() {
        super.onCreate();
        EmployeeApp.databaseApp = Room.databaseBuilder(this, DataBaseApp.class, "app-db").build();
    }
}