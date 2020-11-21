package com.example.cuciin_android.activity.modul.dashboard;

import android.os.Bundle;
import android.view.View;

import com.example.cuciin_android.base.BaseFragmentHolderActivity;
import com.example.cuciin_android.data.model.DataLoginObj;
import com.example.cuciin_android.data.model.LoginObj;
import com.example.cuciin_android.data.source.session.UserSessionRepositoryRepository;

public class DashboardActivity extends BaseFragmentHolderActivity {
    DashboardFragment dashboardFragment;

    protected void initializeFragment(){
        initializeView();

        vMenuBarShadow.setVisibility(View.VISIBLE);
        toolbar.setVisibility(View.VISIBLE);
        ibHome.setVisibility(View.VISIBLE);
        ibCart.setVisibility(View.VISIBLE);
        ibAccount.setVisibility(View.VISIBLE);
        ibWashmachine.setVisibility(View.VISIBLE);

        dashboardFragment = new DashboardFragment();
        setCurrentFragment(dashboardFragment, true);
    }

    public void setTitle(String title){

    }
}
