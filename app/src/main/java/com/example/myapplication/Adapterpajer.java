package com.example.myapplication;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class Adapterpajer extends FragmentStatePagerAdapter {
    List<Fragment> myfragments;
    public Adapterpajer(FragmentManager fm , List<Fragment>fragments) {
        super(fm);
        myfragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return myfragments.get(position);
    }

    @Override
    public int getCount() {
        return myfragments.size();
    }
}
