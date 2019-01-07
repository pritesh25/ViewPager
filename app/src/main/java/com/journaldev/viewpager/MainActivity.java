package com.journaldev.viewpager;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    FragmentTransaction managerTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        managerTransaction = getSupportFragmentManager().beginTransaction();
        managerTransaction.add(R.id.frameLayout,new HomeFragment(),new HomeFragment().getTag());
        managerTransaction.addToBackStack(new HomeFragment().getTag());
        managerTransaction.commit();

    }

    @Override
    public void onBackPressed() {


        if(Integer.parseInt(MyConfiguration.getPreferences(getApplicationContext(),MyConfiguration.COUNTER)) != 1)
        {
            Log.d(TAG,"other than 1 position");
            new HomeFragment().setDefaultPager();
        }
        else
        {
            Log.d(TAG,"onBackPress called");
            finish();
            //super.onBackPressed();
        }
    }
}
