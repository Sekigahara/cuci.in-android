package com.example.cuciin_android.activity.modul.landing;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cuciin_android.R;
import com.example.cuciin_android.base.BaseFragment;
import com.example.cuciin_android.data.model.Outlet;
import com.example.cuciin_android.utils.RecycleViewAdapterNearby;

import java.util.ArrayList;

public class LandingFragment extends BaseFragment<LandingActivity, LandingContract.Presenter> implements LandingContract.View {
    Button btSignup;
    Button btLogin;
    SearchView svNearby;
    public LandingFragment(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.activity_landing, container, false);
        mPresenter = new LandingPresenter(this);
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

    public void setPresenter(LandingContract.Presenter presenter){
        mPresenter = presenter;
    }
}
