package com.example.cuciin_android.base;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.cuciin_android.R;


public abstract class BaseFragmentHolderActivity extends BaseActivity {

    protected ImageButton ibHome;
    protected ImageButton ibCart;
    protected ImageButton ibWashmachine;
    protected ImageButton ibAccount;
    protected RelativeLayout rlActivityFragmentHolder;

    @Override
    protected void initializeView() {

        setContentView(R.layout.base_activity);
        ibHome = (ImageButton) findViewById(R.id.ibHome);
        ibCart = (ImageButton) findViewById(R.id.ibCart);
        ibWashmachine = (ImageButton) findViewById(R.id.ibWashmachine);
        ibAccount = (ImageButton) findViewById(R.id.ibAccount);
        rlActivityFragmentHolder = (RelativeLayout) findViewById(R.id.rlActivityFragmentHolder);
    }
}
