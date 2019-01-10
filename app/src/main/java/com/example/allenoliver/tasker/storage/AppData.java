package com.example.allenoliver.tasker.storage;

import android.content.Context;

import androidx.room.Room;

public class AppData {
    private static AppData singleton = null;

    private AppDatabase db = null;

    private AppData(Context context){
        db = Room.databaseBuilder(context, AppDatabase.class, "task-data").build();
    }

    public AppData getInstance(Context context) {
        if (singleton == null) {
            singleton = new AppData(context.getApplicationContext());
        }
        return singleton;
    }

    public AppDatabase getDatabase() {
        return db;
    }

}
