package com.herba.sdk.myapplication.viewpager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.herba.sdk.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TargetFragment extends Fragment {


    public TargetFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_target, container, false);
    }

}
