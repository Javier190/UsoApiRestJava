package com.example.usoapirestjava;

import androidx.room.Database;
import androidx.room.RoomDatabase;
//ROOM
@Database(entities = EmployeeEntity.class, version = 1)
public abstract class DataBaseApp extends RoomDatabase {
    public abstract EmployeeDAO employeeDAO();
}