package com.example.cuciin_android.activity.modul.nearby;

import android.view.View;

import com.example.cuciin_android.base.BaseFragmentHolderActivity;

public class NearbyActivity extends BaseFragmentHolderActivity {
    NearbyFragment nearbyFragment;
    protected void initializeFragment(){
        initializeView();

        ibHome.setVisibility(View.VISIBLE);
        ibCart.setVisibility(View.VISIBLE);
        ibAccount.setVisibility(View.VISIBLE);
        ibWashmachine.setVisibility(View.VISIBLE);

        nearbyFragment = new NearbyFragment();
        setCurrentFragment(nearbyFragment, true);
    }

    public void setTitle(String title){

    }
}
