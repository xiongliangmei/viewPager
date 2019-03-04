package com.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class FragmentAdapter extends  FragmentPagerAdapter{

    private FragmentManager fragmentManager;
    private List<Fragment> listfragment;

    public FragmentAdapter(FragmentManager fm,List<Fragment> list) {
        super(fm);
        this.fragmentManager = fm;
        this.listfragment = list;
    }

    @Override
    public Fragment getItem(int i) {

        return listfragment.get(i);
    }

    @Override
    public int getCount() {

        return listfragment.size();
    }
}
