package com.example.cuciin_android.activity.modul.landing;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.cuciin_android.R;
import com.example.cuciin_android.activity.modul.login.LoginActivity;
import com.example.cuciin_android.activity.modul.register.RegisterActivity;
import com.example.cuciin_android.base.BaseFragment;

public class LandingFragment extends BaseFragment<LandingActivity, LandingContract.Presenter> implements LandingContract.View {
    Button btSignup;
    Button btLogin;

    public LandingFragment(){

    }

    public android.view.View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.activity_landing, container, false);
        mPresenter = new LandingPresenter(this);
        mPresenter.start();

        btSignup = fragmentView.findViewById(R.id.btSignup);
        btLogin = fragmentView.findViewById(R.id.btLogin);

        btSignup.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                gotoNewTask(new Intent(activity, RegisterActivity.class));
            }
        });

        btLogin.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                gotoNewTask(new Intent(activity, LoginActivity.class));
            }
        });

        return fragmentView;
    }

    public void gotoNewTask(Intent intent){
        startActivity(intent);
        activity.finish();
    }

    public void setPresenter(LandingContract.Presenter presenter){
        mPresenter = presenter;
    }
}
