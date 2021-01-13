package com.example.cuciin_android.activity.modul.splash;

import android.view.View;

import com.example.cuciin_android.base.BaseFragmentHolderActivity;

public class SplashActivity extends BaseFragmentHolderActivity {
    SplashFragment splashFragment;

    protected void initializeFragment(){
        initializeView();

        vMenuBarShadow.setVisibility(View.GONE);
        toolbar.setVisibility(View.GONE);
        ibHome.setVisibility(View.GONE);
        ibCart.setVisibility(View.GONE);
        ibAccount.setVisibility(View.GONE);
        ibWashmachine.setVisibility(View.GONE);

        splashFragment = new SplashFragment(getApplicationContext());
        setCurrentFragment(splashFragment, true);
    }

    public void setTitle(String title){

    }
}
