package com.example.allenoliver.tasker.storage;

import android.content.Context;

import com.example.allenoliver.tasker.storage.dao.TaskDao;
import com.example.allenoliver.tasker.storage.entities.Task;

import java.util.concurrent.Executors;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Task.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;

    public abstract TaskDao taskDao();

    public static synchronized AppDatabase getInstance(final Context context) {
        if (instance == null) {
            instance = buildDatabase(context);
            //instance.taskDao().insertAll(Task.prePopulate());
        }
        return instance;
    }

    private static AppDatabase buildDatabase(final Context context){
        AppDatabase db = Room.databaseBuilder(
                context.getApplicationContext(),
                AppDatabase.class,
                "database-tasker-data")

                //Add callback to prepopulate data into the newly created database
//                .addCallback(new Callback() {
//                    @Override
//                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
//                        // This gets called after the build() initialization has been run.
//                        // At this point the database has been created and the AppDatabase instance exists
//                        super.onCreate(db);
//                        Executors.newSingleThreadExecutor().execute(new Runnable() {
//                            @Override
//                            public void run() {
//                                getInstance(context).taskDao().insertAll(Task.prePopulate());
//                            }
//                        });
//                    }
//                })

                .build(); // Generate the database if it hasn't been created yet.
        return db;
    }
}
