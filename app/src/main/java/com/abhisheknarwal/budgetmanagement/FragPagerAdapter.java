package com.abhisheknarwal.budgetmanagement;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class FragPagerAdapter extends FragmentStatePagerAdapter {
    private int numOfTabs;
    public FragPagerAdapter(@NonNull FragmentManager fm,int numOfTabs) {
        super(fm,numOfTabs);
        this.numOfTabs = numOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new TodayFragment();
            case 1:
                return new WeekFragment();
            case 2:
                return new MonthFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
