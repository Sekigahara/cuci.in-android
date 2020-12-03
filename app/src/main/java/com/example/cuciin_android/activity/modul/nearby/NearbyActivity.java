package com.example.cuciin_android.activity.modul.nearby;

import android.os.Bundle;
import android.view.View;

import com.example.cuciin_android.base.BaseFragmentHolderActivity;
import com.example.cuciin_android.data.model.OutletTestObj;
import com.example.cuciin_android.data.model.outlet.OutletObj;

public class NearbyActivity extends BaseFragmentHolderActivity {
    NearbyFragment nearbyFragment;
    protected void initializeFragment(){
        initializeView();

        ibHome.setVisibility(View.VISIBLE);
        ibCart.setVisibility(View.VISIBLE);
        ibAccount.setVisibility(View.VISIBLE);
        ibWashmachine.setVisibility(View.VISIBLE);

        Bundle extras = getIntent().getExtras();
        //OutletTestObj outletTestObj = (OutletTestObj) extras.getSerializable("outlet");
        //OutletObj outletObj = (OutletObj) extras.getSerializable("outlet");

        //nearbyFragment = new NearbyFragment(outletTestObj);
        nearbyFragment = new NearbyFragment();
        setCurrentFragment(nearbyFragment, true);
    }

    public void setTitle(String title){

    }
}
