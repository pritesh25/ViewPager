package com.herba.sdk.myapplication.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.herba.sdk.myapplication.R;

import static com.herba.sdk.myapplication.viewpager.MyConfiguration.ISHOME;

public class MainViewPagerActivity extends AppCompatActivity implements GamesFragment.GamesFragmentCallback{

    private String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_viewpager);

        fragmentTransaction(new HomeFragment());
    }

    @Override
    public void onBackPressed() {

        Log.d(TAG,"fragment count = "+getSupportFragmentManager().getBackStackEntryCount());

        if (Integer.parseInt(MyConfiguration.getPreferences(getApplicationContext(), MyConfiguration.COUNTER)) != 1) {
            //Log.d(TAG,"other than 1 position");

            if (Boolean.parseBoolean(MyConfiguration.getPreferences(getApplicationContext(), ISHOME))) {
                Log.d(TAG, "yes home");
                new HomeFragment().setDefaultPager();
            } else {
                Log.d(TAG, "not home");
                super.onBackPressed();
            }
        } else {
            Log.d(TAG, "onBackPress called");
            finish();
        }
    }

    @Override
    public void goToTarget() {
        fragmentTransaction(new TargetFragment());
    }

    private void fragmentTransaction(Fragment fragment) {
        FragmentTransaction managerTransaction = getSupportFragmentManager().beginTransaction();
        managerTransaction.replace(R.id.frameLayout, fragment, fragment.getTag());
        managerTransaction.addToBackStack(fragment.getTag());
        managerTransaction.commit();
    }
}