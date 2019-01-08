package com.journaldev.viewpager;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
*/

public class GamesFragment extends Fragment {

    private final String TAG = this.getClass().getSimpleName();
    public GamesFragmentCallback gamesFragmentCallback;

    public GamesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        gamesFragmentCallback = (GamesFragmentCallback)getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_games, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(gamesFragmentCallback != null)
                {
                    Log.d(TAG,"callback is not null");
                    gamesFragmentCallback.goToTarget();
                }
                else
                {
                    Log.d(TAG,"callback is null");
                }
            }
        });

    }

    public interface GamesFragmentCallback {
        void goToTarget();
    }
}