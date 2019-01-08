package com.journaldev.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import static com.journaldev.viewpager.MyConfiguration.ISHOME;

public class MainActivity extends AppCompatActivity implements GamesFragment.GamesFragmentCallback {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentTransaction(new HomeFragment());


    }

    @Override
    public void onBackPressed() {

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