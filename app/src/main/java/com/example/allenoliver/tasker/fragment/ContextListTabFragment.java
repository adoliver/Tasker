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
public class ContextListTabFragment extends Fragment {


    public ContextListTabFragment() {
        // Required empty public constructor
    }

    public static ContextListTabFragment newInstance() {
        ContextListTabFragment fragment = new ContextListTabFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_context_list_tab, container, false);
    }

}
