package com.herba.sdk.myapplication.viewpager.fragment.home;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.herba.sdk.myapplication.R;
import com.herba.sdk.myapplication.viewpager.MainViewPagerActivity;
import com.herba.sdk.myapplication.viewpager.fragment.FavoriteFragment;
import com.herba.sdk.myapplication.viewpager.fragment.MapFragment;
import com.herba.sdk.myapplication.viewpager.fragment.RestaurantFragment;
import com.herba.sdk.myapplication.viewpager.fragment.SearchFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFeedFragment extends Fragment {

    private String TAG = this.getClass().getSimpleName();

    ImageView   ic_movies,
                ic_shopping,
                ic_map,
                ic_restaurant,
                ic_favorite;

    public HomeFeedFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_feed, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ic_movies = view.findViewById(R.id.ic_movies);
        ic_movies.setColorFilter(Color.WHITE);
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
                switchFragment(new MapFragment());
            }
        });

        ic_restaurant = view.findViewById(R.id.ic_restaurant);
        ic_restaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFragment(new RestaurantFragment());
            }
        });

        ic_favorite = view.findViewById(R.id.ic_favorite);
        ic_favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFragment(new FavoriteFragment());
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

/*    public void switchFragment (Fragment fragment) {
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
        Log.d(TAG,"onResumed called");
    }
}