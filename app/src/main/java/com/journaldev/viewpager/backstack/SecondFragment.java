package com.journaldev.viewpager.backstack;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.journaldev.viewpager.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {

    private String TAG = this.getClass().getSimpleName();

    public SecondFragmentCallback secondFragmentCallback;

    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        secondFragmentCallback = (SecondFragmentCallback)context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(secondFragmentCallback != null)
                {
                    secondFragmentCallback.goToFirst();
                }
                else
                {
                    Log.d(TAG,"null callkback");
                }
            }
        });

    }

    public interface SecondFragmentCallback {
        void goToFirst();
    }
}