package com.herba.sdk.myapplication.viewpager.fragment.home;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.herba.sdk.myapplication.R;
import com.herba.sdk.myapplication.viewpager.MainViewPagerActivity;
import com.herba.sdk.myapplication.viewpager.fragment.other.ProfileFragment;
import com.herba.sdk.myapplication.viewpager.fragment.other.AddFragment;
import com.herba.sdk.myapplication.viewpager.fragment.other.LikeFragment;
import com.herba.sdk.myapplication.viewpager.fragment.other.SearchFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class FeedFragment extends Fragment {

    private String TAG = this.getClass().getSimpleName();

    ImageView ic_movies,
            ic_shopping,
            ic_map,
            ic_restaurant,
            ic_favorite;

    public FeedFragment() {
        // Required empty public constructor
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

        return inflater.inflate(R.layout.fragment_feed, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ic_movies = view.findViewById(R.id.ic_movies);
        ic_movies.setColorFilter(getResources().getColor(R.color.colorBluePrimary));
        ic_movies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        ic_shopping = view.findViewById(R.id.ic_shopping);
        ic_shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFragment(new SearchFragment());
            }
        });

        ic_map = view.findViewById(R.id.ic_map);
        ic_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFragment(new AddFragment());
            }
        });

        ic_restaurant = view.findViewById(R.id.ic_restaurant);
        ic_restaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFragment(new LikeFragment());
            }
        });

        ic_favorite = view.findViewById(R.id.ic_favorite);
        ic_favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFragment(new ProfileFragment());
            }
        });
    }

    public void switchFragment(Fragment mFragment) {
        if (getContext() == null)
            return;
        if (getContext() instanceof MainViewPagerActivity) {
            MainViewPagerActivity mainActivity = (MainViewPagerActivity) getContext();
            Fragment frag = mFragment;
            mainActivity.replaceFragment(frag);
        }
    }

    /*public void switchFragment (Fragment fragment) {
        String backStateName = fragment.getClass().getName();
        FragmentManager manager = getFragmentManager();
        boolean fragmentPopped = manager.popBackStackImmediate(backStateName, 0);

        if (!fragmentPopped) { //fragment not in back stack, create it.
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.fragmentFrameLayout, fragment);
            ft.addToBackStack(backStateName);
            ft.commit();
        }
    }*/

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResumed called");
    }
}