package com.example.cuciin_android.activity.modul.register;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.cuciin_android.R;
import com.example.cuciin_android.activity.modul.landing.LandingActivity;
import com.example.cuciin_android.base.BaseFragment;

public class RegisterFragment extends BaseFragment<RegisterActivity, RegisterContract.Presenter> implements RegisterContract.View {

    Button btSignUp;
    TextView tvSignIn;
    EditText etFullName;
    EditText etUsername;
    EditText etEmail;
    EditText etPhone;
    EditText etPassword;
    EditText etConfirmPassword;
    TextView icBtBack;

    public RegisterFragment(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.activity_register, container, false);
        mPresenter = new RegisterPresenter(this);
        mPresenter.start();

        btSignUp = fragmentView.findViewById(R.id.button_sign_up);
        tvSignIn = fragmentView.findViewById(R.id.textView_login);
        etFullName = fragmentView.findViewById(R.id.editText_full_name);
        etUsername = fragmentView.findViewById(R.id.editText_username);
        etEmail = fragmentView.findViewById(R.id.editText_email);
        etPhone = fragmentView.findViewById(R.id.editText_phone);
        etPassword = fragmentView.findViewById(R.id.editText_password);
        etConfirmPassword = fragmentView.findViewById(R.id.editText_confirm_password);
        icBtBack = fragmentView.findViewById(R.id.icBtBack);

        btSignUp.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

            }
        });

        icBtBack.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                gotoNewTask(new Intent(activity, LandingActivity.class));
            }
        });

        return fragmentView;
    }

    public void gotoNewTask(Intent intent){
        startActivity(intent);
        activity.finish();
    }

    public void setPresenter(RegisterContract.Presenter presenter){
        mPresenter = presenter;
    }
}
