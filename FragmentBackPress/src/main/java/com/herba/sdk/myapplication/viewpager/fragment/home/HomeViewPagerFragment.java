package com.herba.sdk.myapplication.viewpager.fragment.home;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
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
public class HomeViewPagerFragment extends Fragment {

    private final String TAG = this.getClass().getSimpleName();

    static int NUM_ITEMS = 3;
    static ViewPager mPager;
    private SlidePagerAdapter mPagerAdapter;
    private boolean isPause = false;

    public HomeViewPagetFragmentCallback callback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callback = (HomeViewPagetFragmentCallback)context;
    }

    public HomeViewPagerFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

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

                    if(callback != null)
                    {
                        callback.onCameraPermission();
                    }
                    else
                    {
                        Log.d(TAG,"callback is null");
                    }

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    public void setDefaultPager() {
        //mPager.setCurrentItem(mPager.getCurrentItem() - 1,true);
        mPager.setCurrentItem(1,true);
    }

    public static class SlidePagerAdapter extends FragmentStatePagerAdapter{

        private ChatFragment chatRecentFragment     = new ChatFragment();
        private FeedFragment feedFragment = new FeedFragment();
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
                    Log.d(TAG,"feedFragment");
                    return feedFragment;
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

    public interface HomeViewPagetFragmentCallback {
        void onCameraPermission();
    }
}