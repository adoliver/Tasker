package com.example.allenoliver.tasker.storage.dao;

import com.example.allenoliver.tasker.storage.entities.Task;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface TaskDao {
    @Query("SELECT * FROM task")
    List<Task> getAll();

    @Insert
    void insertAll(Task... tasks);

    @Delete
    void delete(Task task);
}
