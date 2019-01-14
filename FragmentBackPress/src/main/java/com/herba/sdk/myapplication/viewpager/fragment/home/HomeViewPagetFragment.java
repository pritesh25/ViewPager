package com.herba.sdk.myapplication.viewpager.fragment.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.herba.sdk.myapplication.R;
import com.herba.sdk.myapplication.viewpager.MyConfiguration;

import static com.herba.sdk.myapplication.viewpager.MyConfiguration.COUNTER;
import static com.herba.sdk.myapplication.viewpager.MyConfiguration.ISHOME;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeViewPagetFragment extends Fragment {

    private final String TAG = this.getClass().getSimpleName();

    static int NUM_ITEMS = 3;
    static ViewPager mPager;
    private SlidePagerAdapter mPagerAdapter;
    private boolean isPause = false;

    public HomeViewPagetFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        MyConfiguration.setPreferences(getContext(),ISHOME,"true");

        mPager = view.findViewById(R.id.viewpager);

        mPagerAdapter = new SlidePagerAdapter(getChildFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mPager.setCurrentItem(1);

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if (position == 0) {
                    //chat recent fragment
                    Log.d(TAG, "chat recent fragment is visible");
                    Log.d(TAG, "position = " + position);
                    //getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                    MyConfiguration.setPreferences(getContext(),COUNTER,String.valueOf(position));
                }
                if (position == 1) {
                    Log.d(TAG, "home fragment is visible");
                    Log.d(TAG, "position = " + position);
                    //getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                    MyConfiguration.setPreferences(getContext(),COUNTER,String.valueOf(position));
                }
                if (position == 2) {
                    Log.d(TAG, "camera fragment is visible");
                    Log.d(TAG, "position = " + position);
                    //getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
                    MyConfiguration.setPreferences(getContext(),COUNTER,String.valueOf(position));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        return view;
    }

    public void setDefaultPager() {
        //mPager.setCurrentItem(mPager.getCurrentItem() - 1,true);
        mPager.setCurrentItem(1,true);
    }

    public static class SlidePagerAdapter extends FragmentPagerAdapter {

        private ChatFragment chatRecentFragment     = new ChatFragment();
        private HomeFragment homeFragment           = new HomeFragment();
        private CameraFragment storyMainFragment    = new CameraFragment();
        private String TAG = this.getClass().getSimpleName();

        public SlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    Log.d(TAG,"chatRecentFragment");
                    return chatRecentFragment;
                case 1:
                    Log.d(TAG,"homeFragment");
                    return homeFragment;
                case 2:
                    Log.d(TAG,"storyMainFragment");
                    return storyMainFragment;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            Log.d(TAG,"getCount = "+NUM_ITEMS);
            return NUM_ITEMS;
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        MyConfiguration.setPreferences(getContext(),ISHOME,"false");
        isPause = true;
        MyConfiguration.setPreferences(getContext(),COUNTER,String.valueOf(mPager.getCurrentItem()));

    }

    @Override
    public void onResume() {
        super.onResume();

        MyConfiguration.setPreferences(getContext(),ISHOME,"true");

//        if(isPause)
//        {
//            mPager.setCurrentItem(Integer.parseInt(MyConfiguration.getPreferences(getContext(),COUNTER)));
//        }
    }
}