package com.herba.sdk.myapplication.viewpager.fragment.home;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.herba.sdk.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
*/

public class ChatFragment extends Fragment {

    private String TAG = this.getClass().getSimpleName();
    public GamesFragmentCallback gamesFragmentCallback;
    private FloatingActionButton floatingActionButton;
    boolean isWhite = false;

    public ChatFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        gamesFragmentCallback = (GamesFragmentCallback)getActivity();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        Window window = getActivity().getWindow();// clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);// finally change the color
        window.setStatusBarColor(ContextCompat.getColor(getActivity(), R.color.colorBluePrimaryDark));

        return inflater.inflate(R.layout.fragment_chat, container, false);
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

        floatingActionButton = view.findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator.ofFloat(floatingActionButton, "rotation", 0f, 360f).setDuration(800).start();
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (isWhite){
                            floatingActionButton.setImageDrawable(getResources().getDrawable(R.drawable.ic_add_fab));
                            isWhite = false;
                        } else {
                            floatingActionButton.setImageDrawable(getResources().getDrawable(R.drawable.ic_add_fab));
                            isWhite = true;
                        }
                    }
                }, 400);
            }
        });

    }

    public interface GamesFragmentCallback {
        void goToTarget();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG,"onResumed called");
    }
}