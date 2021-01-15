package com.example.cuciin_android.activity.modul.about_us;

import android.view.View;
import com.example.cuciin_android.base.BaseFragmentHolderActivity;

public class AboutUsActivity extends BaseFragmentHolderActivity {
    AboutUsFragment aboutUsFragment;

    protected void initializeFragment(){
        initializeView();

        vMenuBarShadow.setVisibility(View.GONE);
        toolbar.setVisibility(View.GONE);
        ibHome.setVisibility(View.GONE);
        ibCart.setVisibility(View.GONE);
        ibAccount.setVisibility(View.GONE);
        ibWashmachine.setVisibility(View.GONE);

        aboutUsFragment = new AboutUsFragment(getApplicationContext());
        setCurrentFragment(aboutUsFragment, true);
    }

    public void setTitle(String title){

    }
}
