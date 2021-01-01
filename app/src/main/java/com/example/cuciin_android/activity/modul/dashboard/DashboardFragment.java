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
import com.example.cuciin_android.activity.modul.nearby.NearbyActivity;
import com.example.cuciin_android.activity.modul.nearby.NearbyFragment;
import com.example.cuciin_android.base.BaseFragment;
import com.example.cuciin_android.utils.session.UserSessionRepositoryRepository;
import com.example.cuciin_android.utils.utility.UtilProvider;
import com.google.android.libraries.places.api.Places;

import java.util.Locale;

public class DashboardFragment extends BaseFragment<DashboardActivity, DashboardContract.Presenter> implements DashboardContract.View {
    UserSessionRepositoryRepository userSession;
    ImageView ivNearby;
    private Context context;

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
                    gotoNewTask(new Intent(activity, NearbyActivity.class));
                }else{
                    Toast.makeText(getActivity(), "Enable Your GPS", Toast.LENGTH_LONG).show();
                }
            }
        });

        return fragmentView;
    }

    public void gotoNewTask(Intent intent){
        startActivity(intent);
    }

    public void setPresenter(DashboardContract.Presenter presenter){
        mPresenter = presenter;
    }
}
