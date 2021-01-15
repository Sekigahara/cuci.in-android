package com.example.cuciin_android.base;

import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import androidx.appcompat.widget.Toolbar;

import com.example.cuciin_android.R;
import com.example.cuciin_android.activity.modul.dashboard.DashboardActivity;
import com.example.cuciin_android.activity.modul.orderList.OrderListActivity;


public abstract class BaseFragmentHolderActivity extends BaseActivity {

    protected Toolbar toolbar;
    protected ImageButton ibHome;
    protected ImageButton ibCart;
    protected ImageButton ibWashmachine;
    protected ImageButton ibAccount;
    protected View vMenuBarShadow;
    protected RelativeLayout rlActivityFragmentHolder;

    @Override
    protected void initializeView() {
        setContentView(R.layout.base_activity);
        toolbar = (Toolbar) findViewById(R.id.bottomToolbar);
        ibHome = (ImageButton) findViewById(R.id.ibHome);
        ibCart = (ImageButton) findViewById(R.id.ibCart);
        ibWashmachine = (ImageButton) findViewById(R.id.ibWashmachine);
        ibAccount = (ImageButton) findViewById(R.id.ibAccount);
        vMenuBarShadow = findViewById(R.id.vMenuBarShadow);
        rlActivityFragmentHolder = (RelativeLayout) findViewById(R.id.rlActivityFragmentHolder);

        ibCart.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getBaseContext(), OrderListActivity.class);
                startActivity(intent);
            }
        });

        ibHome.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getBaseContext(), DashboardActivity.class);
                startActivity(intent);
            }
        });

        ibWashmachine.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

            }
        });

        ibAccount.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

            }
        });
    }

    public ImageButton getIbAccount() {
        return ibAccount;
    }
}
