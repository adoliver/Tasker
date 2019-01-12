package com.example.allenoliver.tasker.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.allenoliver.tasker.R;
import com.example.allenoliver.tasker.storage.DataConstants;
import com.example.allenoliver.tasker.storage.entities.Task;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.TaskViewHolder> {
    private List<Task> taskList;

    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        public View taskView;
        public TaskViewHolder(View taskView) {
            super(taskView);
            this.taskView = taskView;
        }
    }

    public TaskListAdapter(List<Task> taskList) {
        this.taskList = taskList;
    }

    /**
     * Generate a new View to load data into. Invoked by the LayoutManager
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View taskView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_task_list_item, parent, false);

        return new TaskViewHolder(taskView);
    }

    /**
     * Replace the contents of a view with the data of the specified position. Invoked by the LayoutManager
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        CheckBox status = holder.taskView.findViewById(R.id.task_status);
        TextView taskName = holder.taskView.findViewById(R.id.task_name);
        Task taskData = taskList.get(position);
        status.setChecked(DataConstants.Task.STATUS_COMPLETE.equals(taskData.status));
        taskName.setText(taskData.name);
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }
}
