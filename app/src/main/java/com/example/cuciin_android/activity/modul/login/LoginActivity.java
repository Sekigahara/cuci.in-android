package com.example.cuciin_android.activity.modul.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.cuciin_android.R;
import com.example.cuciin_android.activity.modul.nearby.NearbyFragment;
import com.example.cuciin_android.base.BaseFragmentHolderActivity;

public class LoginActivity extends BaseFragmentHolderActivity {
    LoginFragment loginFragment;
    protected void initializeFragment(){
        initializeView();

        vMenuBarShadow.setVisibility(View.GONE);
        toolbar.setVisibility(View.GONE);
        ibHome.setVisibility(View.GONE);
        ibCart.setVisibility(View.GONE);
        ibAccount.setVisibility(View.GONE);
        ibWashmachine.setVisibility(View.GONE);

        loginFragment = new LoginFragment();
        setCurrentFragment(loginFragment, false);
    }

    public void setTitle(String title){

    }
}