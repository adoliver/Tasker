package com.example.allenoliver.tasker.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.allenoliver.tasker.R;
import com.example.allenoliver.tasker.adapter.TaskListAdapter;
import com.example.allenoliver.tasker.storage.AppDatabase;
import com.example.allenoliver.tasker.storage.DataConstants;
import com.example.allenoliver.tasker.storage.entities.Task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CurrentTaskSetTabFragment extends Fragment {

    public static final String TAG = CurrentTaskSetTabFragment.class.getSimpleName();

    private RecyclerView mRecyclerViewNextActions = null;
    private RecyclerView.LayoutManager mLayoutManagerNextActions = null;
    private RecyclerView.Adapter mAdapterNextActions = null;

    public CurrentTaskSetTabFragment() {
        // Required empty public constructor
    }

    public static CurrentTaskSetTabFragment newInstance() {
        CurrentTaskSetTabFragment fragment = new CurrentTaskSetTabFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragment = inflater.inflate(R.layout.fragment_current_task_set, container, false);

        AppDatabase db = AppDatabase.getInstance(getContext());
        //db.taskDao().insertAll(new Task(1,"Allen", "my notes", DataConstants.Task.STATUS_INCOMPLETE));

        TextView nextActions = fragment.findViewById(R.id.nextActionsTitle);
        nextActions.setText(getResources().getText(R.string.title_nextActions));

        mRecyclerViewNextActions = fragment.findViewById(R.id.scrollNextActions);

        mLayoutManagerNextActions = new LinearLayoutManager(getContext());
        mRecyclerViewNextActions.setLayoutManager(mLayoutManagerNextActions);

        mAdapterNextActions = new TaskListAdapter(Arrays.asList(Task.prePopulate()));
//        mAdapterNextActions = new TaskListAdapter(
//                AppDatabase.getInstance(getContext()).actionDao().getAll()); // Load Tasks into adapter
        mRecyclerViewNextActions.setAdapter(mAdapterNextActions);

        return fragment;
    }

}
