package edu.dtcc.cis282student.recipegenerator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class GridPagerFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_grid_pager, container, false);
        ViewPager pager = (ViewPager) v.findViewById(R.id.fragment_grid_pager);
        pager.setAdapter(new GridPagerAdapter(getChildFragmentManager()));
        pager.setOffscreenPageLimit(2);
        return v;
    }
}