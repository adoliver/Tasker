package com.example.allenoliver.tasker.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.allenoliver.tasker.R;
import com.example.allenoliver.tasker.adapter.TabPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    private int currentTabResId = 0; // TODO: Make this persistent during the lifecycle
    private ViewPager mViewPagerTabs = null;
    private PagerAdapter mViewPagerAdapterTabs = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Log.d(TAG, String.format("onNavigationItemSelected: %d", menuItem.getItemId()));
                return loadTab(menuItem.getItemId());
            }
        });

        mViewPagerTabs = findViewById(R.id.tabFrame);
        mViewPagerAdapterTabs = new TabPagerAdapter(getSupportFragmentManager());
        mViewPagerTabs.setAdapter(mViewPagerAdapterTabs);
    }

    protected boolean loadTab(int resId) {
        Log.d(TAG, String.format("loadTab[%d,%d,%d] = %d",
                R.id.action_current_task_set,
                R.id.action_context_list,
                R.id.action_all_task_sets,
                resId));
        boolean isSelected = false;
        if (resId == R.id.action_current_task_set) {
            isSelected = true;
            currentTabResId = resId;
            mViewPagerTabs.setCurrentItem(TabPagerAdapter.TAB_CURRENT);
        } else if (resId == R.id.action_context_list) {
            isSelected = true;
            currentTabResId = resId;
            mViewPagerTabs.setCurrentItem(TabPagerAdapter.TAB_CONTEXT_LIST);
        } else if (resId == R.id.action_all_task_sets) {
            isSelected = true;
            currentTabResId = resId;
            mViewPagerTabs.setCurrentItem(TabPagerAdapter.TAB_ALL_LISTS);
        }
        return isSelected;
    }
}
