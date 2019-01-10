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

        TextView nextActions = fragment.findViewById(R.id.nextActionsTitle);
        nextActions.setText(getResources().getText(R.string.title_nextActions));

        mRecyclerViewNextActions = fragment.findViewById(R.id.scrollNextActions);

        mLayoutManagerNextActions = new LinearLayoutManager(getContext());
        mRecyclerViewNextActions.setLayoutManager(mLayoutManagerNextActions);

//        mAdapterNextActions = new NextActionsAdapter();
//        mRecyclerViewNextActions.setAdapter(mAdapterNextActions);

        return fragment;
    }

}
