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

        ibHome.setVisibility(View.GONE);
        ibCart.setVisibility(View.GONE);
        ibAccount.setVisibility(View.GONE);
        ibWashmachine.setVisibility(View.GONE);

        loginFragment = new LoginFragment();
        setCurrentFragment(loginFragment, true);
    }

    public void setTitle(String title){

    }
}