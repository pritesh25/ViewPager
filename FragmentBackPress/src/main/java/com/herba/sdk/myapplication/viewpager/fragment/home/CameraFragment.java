package com.herba.sdk.myapplication.viewpager.fragment.home;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.herba.sdk.myapplication.R;
import com.herba.sdk.myapplication.viewpager.adapter.CameraAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CameraFragment extends Fragment {

    private String TAG = this.getClass().getSimpleName();
    private RecyclerView cameraRecyclerView;
    private CameraAdapter adapter;
    private List<String> list = new ArrayList<>();

    public CameraFragment() {
        // Required empty public constructor
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Window window = getActivity().getWindow();// clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);// finally change the color
        window.setStatusBarColor(ContextCompat.getColor(getActivity(), R.color.colorBluePrimaryDark));


        return inflater.inflate(R.layout.fragment_camera, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setDataToList();

        adapter = new CameraAdapter(getContext(),list);

        cameraRecyclerView = view.findViewById(R.id.cameraRecyclerView);
        cameraRecyclerView.setHasFixedSize(true);
        cameraRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        cameraRecyclerView.setAdapter(adapter);


    }

    private void setDataToList() {

        for(int i = 1;i<51;i++)
        {
            list.add(String.valueOf(i));
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG,"onResumed called");
    }

    public void askPermission() {
        Log.d(TAG,"check for camera permission in camera fragment");
    }

}
