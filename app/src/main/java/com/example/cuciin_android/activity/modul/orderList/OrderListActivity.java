package com.example.cuciin_android.activity.modul.orderList;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;

import com.example.cuciin_android.activity.modul.dashboard.DashboardActivity;
import com.example.cuciin_android.base.BaseFragmentHolderActivity;
import com.example.cuciin_android.data.model.Transaction;

public class OrderListActivity extends BaseFragmentHolderActivity {
    OrderListFragment orderListFragment;
    protected void initializeFragment(){
        initializeView();

        ibHome.setVisibility(View.VISIBLE);
        ibCart.setVisibility(View.VISIBLE);
        ibAccount.setVisibility(View.VISIBLE);
        ibWashmachine.setVisibility(View.VISIBLE);

        Bundle extras = getIntent().getExtras();
        //Transaction transaction = (Transaction) extras.getSerializable("transaction");

        orderListFragment = new OrderListFragment();
        setCurrentFragment(orderListFragment, true);
    }

    public void setTitle(String title){

    }
}
