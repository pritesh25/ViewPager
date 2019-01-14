package com.herba.sdk.myapplication.viewpager.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.herba.sdk.myapplication.R;
import com.herba.sdk.myapplication.viewpager.MainViewPagerActivity;
import com.herba.sdk.myapplication.viewpager.fragment.home.HomeFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment {

    ImageView ic_movies,
            ic_shopping,
            ic_map,
            ic_restaurant,
            ic_favorite;

    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_map, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        ic_movies = view.findViewById(R.id.ic_movies);
        ic_movies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFragment(new HomeFragment());
            }
        });

        ic_shopping = view.findViewById(R.id.ic_shopping);
        ic_shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFragment(new ShoppingFragment());
            }
        });

        ic_map = view.findViewById(R.id.ic_map);
        ic_map.setColorFilter(Color.WHITE);
        ic_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

}
