package com.herba.sdk.myapplication.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.herba.sdk.myapplication.R;
import com.herba.sdk.myapplication.viewpager.fragment.home.CameraFragment;
import com.herba.sdk.myapplication.viewpager.fragment.home.ChatFragment;
import com.herba.sdk.myapplication.viewpager.fragment.home.HomeViewPagerFragment;

import static com.herba.sdk.myapplication.viewpager.MyConfiguration.ISHOME;

public class MainViewPagerActivity extends AppCompatActivity implements ChatFragment.GamesFragmentCallback,HomeViewPagerFragment.HomeViewPagetFragmentCallback {

    private String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_viewpager);

        getSupportActionBar().hide();

        replaceFragment(new HomeViewPagerFragment());
    }

    @Override
    public void onBackPressed() {

        Log.d(TAG,"fragment count = "+getSupportFragmentManager().getBackStackEntryCount());

        if (Integer.parseInt(MyConfiguration.getPreferences(getApplicationContext(), MyConfiguration.COUNTER)) != 1) {
            //Log.d(TAG,"other than 1 position");

            if (Boolean.parseBoolean(MyConfiguration.getPreferences(getApplicationContext(), ISHOME))) {
                Log.d(TAG, "yes home");
                new HomeViewPagerFragment().setDefaultPager();
            } else {
                Log.d(TAG, "not home");
                super.onBackPressed();
            }
        } else {

            super.onBackPressed();
            Log.d(TAG, "onBackPress called");

            if(getSupportFragmentManager().getBackStackEntryCount() == 0)
            {
                Log.d(TAG, "onBackPress finish");
                finish();
            }
            else
            {
                Log.d(TAG, "onBackPress else");
            }
        }

        /*super.onBackPressed();
        Log.d(TAG,"fragment count = "+getSupportFragmentManager().getBackStackEntryCount());

        if(getSupportFragmentManager().getBackStackEntryCount() == 0)
        {
            Log.d(TAG,"if backpress");
            finish();
        }
        else
        {
            Log.d(TAG,"else backpress");
        }*/

    }

    @Override
    public void goToTarget() {
        replaceFragment(new TargetFragment());
    }

    /* public void replaceFragment(Fragment fragment) {
        FragmentTransaction managerTransaction = getSupportFragmentManager().beginTransaction();
        managerTransaction.replace(R.id.frameLayout, fragment, fragment.getTag());
        managerTransaction.addToBackStack(fragment.getTag());
        managerTransaction.commit();
    }*/

    public void replaceFragment (Fragment fragment) {
        String backStateName = fragment.getClass().getName();

        FragmentManager manager = getSupportFragmentManager();
        boolean fragmentPopped = manager.popBackStackImmediate(backStateName, 0);

        if (!fragmentPopped) { //fragment not in back stack, create it.
            FragmentTransaction ft = manager.beginTransaction();
//            ft.setCustomAnimations
//                    (
//                    R.anim.fragment_slide_right_enter,
//                    R.anim.fragment_slide_right_exit,
//                    R.anim.fragment_slide_right_enter,
//                    R.anim.fragment_slide_right_exit
//                    );
            ft.replace(R.id.frameLayout, fragment);
            ft.addToBackStack(backStateName);
            ft.commit();
        }
    }

    @Override
    public void onCameraPermission() {
        new CameraFragment().askPermission();
    }
}