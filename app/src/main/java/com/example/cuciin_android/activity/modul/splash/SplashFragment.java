package com.example.cuciin_android.activity.modul.splash;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.cuciin_android.R;
import com.example.cuciin_android.activity.modul.about_us.AboutUsActivity;
import com.example.cuciin_android.activity.modul.dashboard.DashboardActivity;
import com.example.cuciin_android.activity.modul.landing.LandingActivity;
import com.example.cuciin_android.activity.modul.nearby.NearbyActivity;
import com.example.cuciin_android.base.BaseFragment;
import com.example.cuciin_android.utils.session.UserSessionRepositoryRepository;
import com.example.cuciin_android.utils.utility.UtilProvider;
import com.google.android.libraries.places.api.Places;

import java.util.List;

import pub.devrel.easypermissions.EasyPermissions;

public class SplashFragment extends BaseFragment<SplashActivity, SplashContract.Presenter> implements SplashContract.View {
    private Context context;
    private TextView tv_aboutus;
    private FrameLayout flRedirect;

    public SplashFragment(Context context){
        this.context = context;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        if(new UserSessionRepositoryRepository(context).getDataSession()!= null) {
            gotoNewTask(new Intent(activity, DashboardActivity.class));
        }
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.splash_screen, container, false);
        mPresenter = new SplashPresenter(this);
        mPresenter.start();

        tv_aboutus = (TextView) fragmentView.findViewById(R.id.tv_about_us);
        tv_aboutus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                gotoNewTask(new Intent(activity, AboutUsActivity.class));
            }
        });

        flRedirect = (FrameLayout) fragmentView.findViewById(R.id.flRedirect);
        flRedirect.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                gotoNewTask(new Intent(activity, LandingActivity.class));
            }
        });

        return fragmentView;
    }

    public void gotoNewTask(Intent intent){
        startActivity(intent);
        activity.finish();
    }

    public void setPresenter(SplashContract.Presenter presenter){
        mPresenter = presenter;
    }
}
