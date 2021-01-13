package com.example.cuciin_android.activity.modul.about_us;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.cuciin_android.R;
import com.example.cuciin_android.activity.modul.about_us.AboutUsActivity;
import com.example.cuciin_android.activity.modul.nearby.NearbyActivity;
import com.example.cuciin_android.base.BaseFragment;
import com.example.cuciin_android.utils.session.UserSessionRepositoryRepository;
import com.example.cuciin_android.utils.utility.UtilProvider;
import com.google.android.libraries.places.api.Places;

import java.util.List;

import pub.devrel.easypermissions.EasyPermissions;

public class AboutUsFragment extends BaseFragment<AboutUsActivity, AboutUsContract.Presenter> implements AboutUsContract.View{
    private Context context;

    public AboutUsFragment(Context context){
        this.context = context;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.about_us, container, false);
        mPresenter = new AboutUsPresenter(this);
        mPresenter.start();

        return fragmentView;
    }

    public void gotoNewTask(Intent intent){
        startActivity(intent);
    }

    public void setPresenter(AboutUsContract.Presenter presenter){
        mPresenter = presenter;
    }
}
