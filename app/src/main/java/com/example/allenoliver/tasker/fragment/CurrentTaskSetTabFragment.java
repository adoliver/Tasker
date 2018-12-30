package com.example.allenoliver.tasker.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.allenoliver.tasker.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CurrentTaskSetTabFragment extends Fragment {


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
        View fragment = inflater.inflate(R.layout.fragment_simple, container, false);

        TextView text = fragment.findViewById(R.id.simple_textview);
        text.setText(getResources().getText(R.string.fragment_current_task_set_tab));

        return fragment;
    }

}
