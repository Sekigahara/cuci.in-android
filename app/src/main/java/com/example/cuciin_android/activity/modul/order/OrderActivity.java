package com.example.cuciin_android.activity.modul.order;

import android.os.Bundle;
import android.view.View;

import com.example.cuciin_android.base.BaseFragmentHolderActivity;
import com.example.cuciin_android.data.model.LaundryType;
import com.example.cuciin_android.data.model.outlet.DataOutletObj;
import com.example.cuciin_android.data.model.login.LoginObj;

public class OrderActivity extends BaseFragmentHolderActivity {
    OrderFragment orderFragment;
    @Override
    protected void initializeFragment() {
        initializeView();

        ibHome.setVisibility(View.GONE);
        ibCart.setVisibility(View.GONE);
        ibAccount.setVisibility(View.GONE);
        ibWashmachine.setVisibility(View.GONE);

        Bundle extras = getIntent().getExtras();
        DataOutletObj dataOutletObj = (DataOutletObj) extras.getSerializable("dataOutletObj");
        LaundryType laundryType = (LaundryType) extras.getSerializable("laundryType");
        LoginObj loginObj = (LoginObj) extras.getSerializable("session");

        orderFragment = new OrderFragment(dataOutletObj, laundryType, loginObj);
        setCurrentFragment(orderFragment, true);
    }

    @Override
    public void setTitle(String title) {

    }
}
