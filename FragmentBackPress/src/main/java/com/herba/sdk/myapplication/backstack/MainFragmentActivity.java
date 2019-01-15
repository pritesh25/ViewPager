package com.herba.sdk.myapplication.backstack;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.herba.sdk.myapplication.R;
import com.herba.sdk.myapplication.backstack.FirstFragment;
import com.herba.sdk.myapplication.backstack.SecondFragment;

public class MainFragmentActivity extends AppCompatActivity implements FirstFragment.FirstFragmentCallback,SecondFragment.SecondFragmentCallback {

    private String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragment);

        getSupportActionBar().hide();

        replaceFragment(new FirstFragment());

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.d(TAG,"fragment count = "+getSupportFragmentManager().getBackStackEntryCount());

        if(getSupportFragmentManager().getBackStackEntryCount() == 0)
        {
            Log.d(TAG,"if backpress");
            finish();
        }
        else
        {
            Log.d(TAG,"else backpress");
        }
    }

    private void replaceFragment (Fragment fragment) {
        String backStateName = fragment.getClass().getName();

        FragmentManager manager = getSupportFragmentManager();
        boolean fragmentPopped = manager.popBackStackImmediate(backStateName, 0);

        if (!fragmentPopped) { //fragment not in back stack, create it.
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.frameLayout, fragment);
            ft.addToBackStack(backStateName);
            ft.commit();
        }
    }

    @Override
    public void goToSecond() {
        replaceFragment(new SecondFragment());
    }

    @Override
    public void goToFirst() {
        replaceFragment(new FirstFragment());
    }

}
