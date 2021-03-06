package com.example.cuciin_android.activity.modul.dashboard;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.cuciin_android.R;
import com.example.cuciin_android.activity.modul.login.LoginActivity;
import com.example.cuciin_android.activity.modul.nearby.NearbyActivity;
import com.example.cuciin_android.base.BaseFragment;
import com.example.cuciin_android.utils.session.UserSessionRepositoryRepository;
import com.example.cuciin_android.utils.utility.UtilProvider;
import com.google.android.libraries.places.api.Places;

import java.util.List;

import pub.devrel.easypermissions.EasyPermissions;

public class DashboardFragment extends BaseFragment<DashboardActivity, DashboardContract.Presenter> implements DashboardContract.View, EasyPermissions.PermissionCallbacks {
    UserSessionRepositoryRepository userSession;
    ImageView ivNearby;
    private Context context;
    private final int REQUEST_LOCATION_PERMISSION = 1;
    private Boolean isGranted = false;

    public DashboardFragment(Context context){
        this.context = context;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.activity_dashboard, container, false);
        mPresenter = new DashboardPresenter(this);
        mPresenter.start();

        UtilProvider.initKey("AIzaSyCi5K_CX39rkJPvxfULr1HZKMChpvvh1IM");
        UtilProvider.initServerKey("AIzaSyD0_sZhy7fJoeUcIGTmkTZbl5FNxYr2N-o");

        if(!Places.isInitialized())
            Places.initialize(context, UtilProvider.getKey());

        ivNearby = fragmentView.findViewById(R.id.ivNearby);
        ivNearby.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
                boolean statusOfGPS = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
                if(statusOfGPS == true){
                    requestLocationPermission();
                }else{
                    Toast.makeText(getActivity(), "Enable Your GPS", Toast.LENGTH_LONG).show();
                }
            }
        });

        activity.getIbAccount().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(activity);
                alert.setTitle("Do You Want to Logout ?");

                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogBox, int id) {
                        new UserSessionRepositoryRepository(activity).destroy();
                        Intent intent = new Intent(activity, LoginActivity.class);
                        startActivity(intent);
                    }
                });

                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogBox, int id) {
                        dialogBox.cancel();
                    }
                });

                AlertDialog dialog = alert.create();
                dialog.show();
            }
        });

        return fragmentView;
    }

    public void onRequestPermissionsResult(int requestCode, String[] permission, int[] grantResult){
        super.onRequestPermissionsResult(requestCode, permission, grantResult);

        //forward to easy permission lib
        EasyPermissions.onRequestPermissionsResult(requestCode, permission, grantResult, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        isGranted = true;
        gotoNewTask(new Intent(activity, NearbyActivity.class));
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        isGranted = false;
        if(isGranted == false){
            Toast.makeText(activity, "Please Grant Permission to use the Apps", Toast.LENGTH_LONG).show();
            gotoNewTask(new Intent(activity, DashboardActivity.class));
            activity.finish();
        }
    }

    public void requestLocationPermission(){
        String[] perms = {Manifest.permission.ACCESS_FINE_LOCATION};
        if(EasyPermissions.hasPermissions(getContext(), perms)){
            gotoNewTask(new Intent(activity, NearbyActivity.class));
        }else{
            EasyPermissions.requestPermissions(this, "Grant Permission to Continue", REQUEST_LOCATION_PERMISSION, perms);
        }
    }

    public void gotoNewTask(Intent intent){
        startActivity(intent);
    }

    public void setPresenter(DashboardContract.Presenter presenter){
        mPresenter = presenter;
    }
}
