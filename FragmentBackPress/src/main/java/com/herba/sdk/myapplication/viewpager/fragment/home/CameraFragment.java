package com.herba.sdk.myapplication.viewpager.fragment.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.herba.sdk.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CameraFragment extends Fragment {

    private String TAG = this.getClass().getSimpleName();

    public CameraFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_camera, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG,"onResumed called");
    }
}
