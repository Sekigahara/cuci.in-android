package com.example.cuciin_android.activity.modul.order;

import android.os.Bundle;
import android.view.View;

import com.example.cuciin_android.base.BaseFragmentHolderActivity;
import com.example.cuciin_android.data.model.LaundryType;
import com.example.cuciin_android.data.model.nearby.PackedOutlet;
import com.example.cuciin_android.data.model.outlet.DataOutletObj;
import com.example.cuciin_android.data.model.login.LoginObj;

public class OrderActivity extends BaseFragmentHolderActivity {
    OrderFragment orderFragment;
    @Override
    protected void initializeFragment() {
        initializeView();

        vMenuBarShadow.setVisibility(View.GONE);
        toolbar.setVisibility(View.GONE);
        ibHome.setVisibility(View.GONE);
        ibCart.setVisibility(View.GONE);
        ibAccount.setVisibility(View.GONE);
        ibWashmachine.setVisibility(View.GONE);

        Bundle extras = getIntent().getExtras();
        PackedOutlet packedOutlet = (PackedOutlet) extras.getSerializable("DATAOUTLET");

        orderFragment = new OrderFragment(packedOutlet);
        setCurrentFragment(orderFragment, true);
    }

    @Override
    public void setTitle(String title) {

    }
}
