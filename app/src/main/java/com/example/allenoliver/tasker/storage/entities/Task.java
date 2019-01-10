package com.example.allenoliver.tasker.storage.entities;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public class Task {
    @PrimaryKey
    public String id;

    @ColumnInfo(name="name")
    public String name;

    @ColumnInfo(name="notes")
    public String notes;

    @ColumnInfo(name="status")
    public String status;

    private Task(
            String id,
            String name
    ) {
        this(
                id,
                name,
                "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem.",
                "INCOMPLETE"
        );
    }

    private Task(
            String id,
            String name,
            String notes,
            String status
    ) {
        this.id = id;
        this.name = name;
        this.notes = notes;
        this.status = status;
    }

    public static Task[] prePopulate() {
        return new Task[] {
            new Task("1", "Task One"),
                new Task("2", "Task Two"),
                new Task("3", "Task Three"),
                new Task("4", "Task Four"),
                new Task("5", "Task Five")
        };
    }
}
