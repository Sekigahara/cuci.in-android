package com.example.cuciin_android.activity.modul.dashboard;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.telephony.CarrierConfigManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.cuciin_android.R;
import com.example.cuciin_android.base.BaseFragment;
import com.example.cuciin_android.utils.session.UserSessionRepositoryRepository;
import com.example.cuciin_android.utils.utility.UtilProvider;

public class DashboardFragment extends BaseFragment<DashboardActivity, DashboardContract.Presenter> implements DashboardContract.View {
    UserSessionRepositoryRepository userSession;
    ImageView ivNearby;
    ImageView ivLogout;

    public DashboardFragment(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.activity_dashboard, container, false);
        mPresenter = new DashboardPresenter(this);
        mPresenter.start();

        LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        boolean statusOfGPS = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

        ivNearby = fragmentView.findViewById(R.id.ivNearby);
        if(statusOfGPS == true){
            LocationTrack locationTrack = new LocationTrack(activity);

            final Double lat = locationTrack.getLatitude();
            final Double lng = locationTrack.getLongitude();
            UtilProvider.initKey("AIzaSyCi5K_CX39rkJPvxfULr1HZKMChpvvh1IM");
            //Toast.makeText(activity, "Lat : " + lat.toString() + " lng : " + lng.toString(), Toast.LENGTH_LONG).show();
            ivNearby.setOnClickListener(new View.OnClickListener(){
                public void onClick(View view){
                    mPresenter.fetchMaps(1500, "false","laundry",lat, lng,UtilProvider.getKey(), activity);
                }
            });
        }else{
            Toast.makeText(getActivity(), "Enable Your GPS", Toast.LENGTH_LONG).show();

            ivNearby.setOnClickListener(new View.OnClickListener(){
                public void onClick(View view){
                    gotoNewTask(new Intent(activity, DashboardActivity.class));
                }
            });
        }


        /*
        ivLogout = fragmentView.findViewById(R.id.imageView_log);
        ivLogout.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                getContext().getSharedPreferences("SessionSharedPreferences", Context.MODE_PRIVATE).edit().clear().apply();
            }
        });
         */

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
