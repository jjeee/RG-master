package edu.dtcc.cis282student.recipegenerator;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

class GridPagerAdapter extends FragmentPagerAdapter {

    GridPagerAdapter(FragmentManager mgr) {
        super(mgr);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Fragment getItem(int position) {
        return GridFragment.newInstance(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return GridFragment.getTitle(position);
    }
}