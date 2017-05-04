package edu.dtcc.cis282student.recipegenerator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class GridFragment extends Fragment {
    static final String POSITION = "POSITION";
    int position;

    static GridFragment newInstance(int position) {
        GridFragment fragment = new GridFragment();
        Bundle args = new Bundle();
        args.putInt(GridFragment.POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_grid, container, false);
        position = getArguments().getInt(POSITION);
        return v;
    }

    static CharSequence getTitle(int position) {
        return "Page " + (position + 1);
    }
}