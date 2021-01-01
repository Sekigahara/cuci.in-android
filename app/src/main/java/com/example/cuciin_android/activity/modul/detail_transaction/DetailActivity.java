package com.example.cuciin_android.activity.modul.detail_transaction;

import android.os.Bundle;
import android.view.View;

import com.example.cuciin_android.base.BaseFragmentHolderActivity;
import com.example.cuciin_android.data.model.outlet.OutletObj;
import com.example.cuciin_android.data.model.transaction.DataTransactionObj;
import com.example.cuciin_android.data.model.transaction.PackedTransaction;

public class DetailActivity extends BaseFragmentHolderActivity {
    DetailFragment detailFragment;
    protected void initializeFragment(){
        initializeView();

        ibHome.setVisibility(View.VISIBLE);
        ibCart.setVisibility(View.VISIBLE);
        ibAccount.setVisibility(View.VISIBLE);
        ibWashmachine.setVisibility(View.VISIBLE);

        Bundle extras = getIntent().getExtras();
        PackedTransaction packedTransaction = (PackedTransaction) extras.getSerializable("transaction");

        detailFragment = new DetailFragment(packedTransaction);
        setCurrentFragment(detailFragment, true);
    }

    public void setTitle(String title){

    }
}
