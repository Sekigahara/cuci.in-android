package com.example.cuciin_android.activity.modul.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;

import com.example.cuciin_android.R;
import com.example.cuciin_android.activity.modul.landing.LandingActivity;
import com.example.cuciin_android.base.BaseFragment;

public class LoginFragment extends BaseFragment<LandingActivity, LoginContract.Presenter> implements LoginContract.View {
    Button btSignup;
    Button btLogin;
    SearchView svNearby;
    public LoginFragment(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.activity_landing, container, false);
        mPresenter = new LoginPresenter(this);
        mPresenter.start();

        btSignup = fragmentView.findViewById(R.id.btSignup);
        btLogin = fragmentView.findViewById(R.id.btLogin);

        btSignup.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

            }
        });

        btLogin.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

            }
        });

        return fragmentView;
    }

    public void gotoNewTask(){

    }

    public void setPresenter(LoginContract.Presenter presenter){
        mPresenter = presenter;
    }
}
