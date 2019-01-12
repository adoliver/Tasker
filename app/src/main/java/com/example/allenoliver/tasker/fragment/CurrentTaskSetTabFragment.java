package com.example.allenoliver.tasker.fragment;


import android.os.AsyncTask;
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

    private TextView mNextActionsTitle = null;
    private RecyclerView mRecyclerViewNextActions = null;
    private RecyclerView.LayoutManager mLayoutManagerNextActions = null;
    private RecyclerView.Adapter mAdapterNextActions = null;
    private List<Task> mNextActionsList = new ArrayList<>();

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

        mNextActionsTitle = fragment.findViewById(R.id.nextActionsTitle);
        mNextActionsTitle.setText(getResources().getText(R.string.title_nextActions));

        mRecyclerViewNextActions = fragment.findViewById(R.id.scrollNextActions);

        mLayoutManagerNextActions = new LinearLayoutManager(getContext());
        mRecyclerViewNextActions.setLayoutManager(mLayoutManagerNextActions);

        mAdapterNextActions = new TaskListAdapter(mNextActionsList);
        mRecyclerViewNextActions.setAdapter(mAdapterNextActions);

        fragment.findViewById(R.id.testButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retrieveData(v);
            }
        });

        return fragment;
    }

    public void retrieveData(View v) {
        mNextActionsTitle.setText(getResources().getText(R.string.title_nextActions) + " ... loading...");
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                AppDatabase db = AppDatabase.getInstance(getContext());
                final List<Task> taskList = db.taskDao().getAll();
                // Now that data is retrieved get back on main UI thread and update UI
                if (isResumed()) {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            loadData(taskList);
                        }
                    });
                }
            }
        });

    }


    public void loadData(List<Task> taskList) {
        if (isResumed()) {
            mNextActionsTitle.setText(getResources().getText(R.string.title_nextActions));
            mNextActionsList.addAll(taskList);
            mAdapterNextActions.notifyDataSetChanged();
        }
    }



}
