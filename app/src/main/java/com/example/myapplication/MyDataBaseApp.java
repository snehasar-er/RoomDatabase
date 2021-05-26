package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = {User.class},version = 1)
public abstract class MyDataBaseApp extends RoomDatabase {
	public abstract UserDao myDao();
}
