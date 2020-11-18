package com.example.cuciin_android.activity.modul.register;

import android.view.View;

import com.example.cuciin_android.base.BaseFragmentHolderActivity;

public class RegisterActivity extends BaseFragmentHolderActivity {
    RegisterFragment registerFragment;
    protected void initializeFragment(){
        initializeView();

        ibHome.setVisibility(View.GONE);
        ibCart.setVisibility(View.GONE);
        ibAccount.setVisibility(View.GONE);
        ibWashmachine.setVisibility(View.GONE);

        registerFragment = new RegisterFragment();
        setCurrentFragment(registerFragment, true);
    }

    public void setTitle(String title){

    }
}
