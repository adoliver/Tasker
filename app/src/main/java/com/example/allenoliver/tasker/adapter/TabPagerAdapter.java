package com.example.allenoliver.tasker.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabPagerAdapter extends FragmentPagerAdapter {
    public static final int TAB_CURRENT = 0;
    public static final int TAB_CONTEXT_LIST = 1;
    public static final int TAB_ALL_LISTS = 2;

    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (TAB_CURRENT == position) {

        } else if (TAB_CONTEXT_LIST == position) {

        } else if (TAB_ALL_LISTS == position) {

        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
