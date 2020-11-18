package com.example.cuciin_android.activity.modul.landing;

import android.view.View;

import com.example.cuciin_android.base.BaseFragmentHolderActivity;

public class LandingActivity extends BaseFragmentHolderActivity {
    LandingFragment landingFragment;
    protected void initializeFragment(){
        initializeView();

        ibHome.setVisibility(View.GONE);
        ibCart.setVisibility(View.GONE);
        ibAccount.setVisibility(View.GONE);
        ibWashmachine.setVisibility(View.GONE);

        landingFragment = new LandingFragment();
        setCurrentFragment(landingFragment, true);
    }

    public void setTitle(String title){

    }
}
