package com.example.cuciin_android.activity.modul.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cuciin_android.R;
import com.example.cuciin_android.activity.modul.dashboard.DashboardActivity;
import com.example.cuciin_android.activity.modul.landing.LandingActivity;
import com.example.cuciin_android.activity.modul.register.RegisterActivity;
import com.example.cuciin_android.base.BaseFragment;
import com.example.cuciin_android.data.model.User;

public class LoginFragment extends BaseFragment<LoginActivity, LoginContract.Presenter> implements LoginContract.View {
    EditText etUsername;
    EditText etPassword;
    Button btLogin;
    TextView tvSignUp;
    TextView icBtBack;

    public LoginFragment(){

    }

    public android.view.View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.activity_login, container, false);
        mPresenter = new LoginPresenter(this, getActivity());
        mPresenter.start();

        etUsername = fragmentView.findViewById(R.id.editTextTextPersonName2);
        etPassword = fragmentView.findViewById(R.id.editTextTextPassword);
        tvSignUp = fragmentView.findViewById(R.id.textView_signUp);
        btLogin = fragmentView.findViewById(R.id.buttonLogin);
        icBtBack = fragmentView.findViewById(R.id.icBtBack);

        btLogin.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                setBtnLoginOnClick(new User(etUsername.getText().toString(), etPassword.getText().toString()));
            }
        });

        tvSignUp.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                gotoNewTask(new Intent(activity, RegisterActivity.class));
            }
        });

        icBtBack.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                gotoNewTask(new Intent(activity, LandingActivity.class));
            }
        });

        return fragmentView;
    }

    public void setBtnLoginOnClick(final User user){
        int loginCode = mPresenter.onLogin(user);

        if(loginCode == 0)
            Toast.makeText(getActivity(), "You Must Enter Your Username", Toast.LENGTH_LONG).show();
        else if(loginCode == 1)
            Toast.makeText(getActivity(), "Password Must be Greater than 6 Characters", Toast.LENGTH_LONG).show();
        else {
            mPresenter.validateLogin(user, getActivity());
        }
    }

    public void gotoNewTask(Intent intent){
        startActivity(intent);
        activity.finish();
    }

    public void gotoDashboard(){
        gotoNewTask(new Intent(activity, DashboardActivity.class));
    }

    public void setPresenter(LoginContract.Presenter presenter){
        mPresenter = presenter;
    }
}
