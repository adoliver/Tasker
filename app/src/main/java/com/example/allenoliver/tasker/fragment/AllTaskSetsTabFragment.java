package com.example.allenoliver.tasker.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.allenoliver.tasker.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllTaskSetsTabFragment extends Fragment {


    public AllTaskSetsTabFragment() {
        // Required empty public constructor
    }

    public static AllTaskSetsTabFragment newInstance() {
        AllTaskSetsTabFragment fragment = new AllTaskSetsTabFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_task_sets_tab, container, false);
    }

}
