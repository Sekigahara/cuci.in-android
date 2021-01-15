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
import android.widget.Toast;

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
                onRegisterButtonClick(etFullName.getText().toString(), etUsername.getText().toString(),
                                        etEmail.getText().toString(), etPhone.getText().toString(),
                                        etPassword.getText().toString(), etConfirmPassword.getText().toString());
            }
        });

        icBtBack.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                gotoNewTask(new Intent(activity, LandingActivity.class));
            }
        });

        return fragmentView;
    }

    public void onRegisterButtonClick(String full_name, String username, String email, String phone, String password, String confirm){
        String message = mPresenter.onRegister(full_name, username, email, phone, password, confirm);

        if(message.equals("passed"))
            mPresenter.validateRegister(getActivity() ,full_name, username, email, phone, password, confirm);
        else{
            Toast.makeText(activity, message, Toast.LENGTH_LONG).show();
        }
    }

    public void gotoNewTask(Intent intent){
        startActivity(intent);
        activity.finish();
    }

    public void setPresenter(RegisterContract.Presenter presenter){
        mPresenter = presenter;
    }
}
