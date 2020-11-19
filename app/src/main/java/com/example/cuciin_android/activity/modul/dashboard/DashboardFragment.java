package com.example.cuciin_android.activity.modul.dashboard;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.cuciin_android.R;
import com.example.cuciin_android.activity.modul.login.LoginActivity;
import com.example.cuciin_android.activity.modul.register.RegisterActivity;
import com.example.cuciin_android.base.BaseFragment;

public class DashboardFragment extends BaseFragment<DashboardActivity, DashboardContract.Presenter> implements DashboardContract.View {
    ImageView ivNearby;

    public DashboardFragment(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.activity_dashboard, container, false);
        mPresenter = new DashboardPresenter(this);
        mPresenter.start();

        ivNearby = fragmentView.findViewById(R.id.imageView_Nearby);
        ivNearby.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

            }
        });


        return fragmentView;
    }

    public void gotoNewTask(Intent intent){
        startActivity(intent);
        activity.finish();
    }

    public void setPresenter(DashboardContract.Presenter presenter){
        mPresenter = presenter;
    }
}
