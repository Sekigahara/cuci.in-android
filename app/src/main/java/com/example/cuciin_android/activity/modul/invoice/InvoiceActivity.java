package com.example.cuciin_android.activity.modul.invoice;

import android.view.View;

import com.example.cuciin_android.base.BaseFragmentHolderActivity;

public class InvoiceActivity extends BaseFragmentHolderActivity {
    InvoiceFragment invoiceFragment;
    protected void initializeFragment(){
        initializeView();

        ibHome.setVisibility(View.VISIBLE);
        ibCart.setVisibility(View.VISIBLE);
        ibAccount.setVisibility(View.VISIBLE);
        ibWashmachine.setVisibility(View.VISIBLE);

        invoiceFragment = new InvoiceFragment();
        setCurrentFragment(invoiceFragment, true);
    }

    public void setTitle(String title){

    }
}
