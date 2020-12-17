package com.example.cuciin_android.activity.modul.nearby;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cuciin_android.R;
import com.example.cuciin_android.activity.modul.dashboard.DashboardActivity;
import com.example.cuciin_android.activity.modul.nearby.LocationTrack;
import com.example.cuciin_android.activity.modul.orderList.OrderListActivity;
import com.example.cuciin_android.base.BaseFragment;
import com.example.cuciin_android.data.model.login.LoginObj;
import com.example.cuciin_android.data.model.OutletTestObj;
import com.example.cuciin_android.data.model.nearby.PackedOutlet;
import com.example.cuciin_android.data.model.outlet.DataOutletObj;
import com.example.cuciin_android.data.model.outlet.OutletObj;
import com.example.cuciin_android.utils.recycler.RecycleViewAdapterNearby;
import com.example.cuciin_android.utils.utility.UtilProvider;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.LOCATION_SERVICE;

public class NearbyFragment extends BaseFragment<NearbyActivity, NearbyContract.Presenter> implements NearbyContract.View {
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private OutletTestObj outletTestObj;
    private OutletObj outletObj;
    RecyclerView mRecyclerView;
    SearchView svNearby;
    TextView icBtBack;

    public NearbyFragment(OutletTestObj outletTestObj){
        this.outletTestObj = outletTestObj;
    }

    public NearbyFragment(OutletObj outletObj){
        this.outletObj = outletObj;
    }

    public NearbyFragment(){

    }

    public android.view.View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_nearby, container, false);
        mPresenter = new NearbyPresenter(this);
        mPresenter.start();

        LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        boolean statusOfGPS = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

        LocationManager mLocationManager;
        mLocationManager = (LocationManager) getContext().getSystemService(LOCATION_SERVICE);
        List<String> providers = mLocationManager.getProviders(true);
        Location bestLocation = null;
        for (String provider : providers) {
            Location l = mLocationManager.getLastKnownLocation(provider);
            if (l == null) {
                continue;
            }
            if (bestLocation == null || l.getAccuracy() < bestLocation.getAccuracy()) {
                // Found best last known location: %s", l);
                bestLocation = l;
            }
        }

        final Double lat = bestLocation.getLatitude();
        final Double lng = bestLocation.getLongitude();
        UtilProvider.initKey("AIzaSyCi5K_CX39rkJPvxfULr1HZKMChpvvh1IM");

        mPresenter.fetchMaps(1500, "false","laundry",lat, lng,UtilProvider.getKey(), activity);

        mRecyclerView = fragmentView.findViewById(R.id.rvNearby);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(activity);
        mRecyclerView.setLayoutManager(mLayoutManager);

        svNearby = fragmentView.findViewById(R.id.svNearby);
        icBtBack = fragmentView.findViewById(R.id.icBtBack);

        icBtBack.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                gotoNewTask(new Intent(activity, DashboardActivity.class));
            }
        });

        /*
        ((RecycleViewAdapterNearby) mAdapter).setOnItemClickListener(new RecycleViewAdapterNearby.MyClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                //int id = listOutlet.get(position).getId();
                Log.d("Dashboard", ">>>>" + position);

            }
        });
        */
        return fragmentView;
    }

    public void viewNearby(OutletObj outletObj){
        final List<DataOutletObj> listOutlet = outletObj.getResults();
        mPresenter.fetchLocalMaps(listOutlet, activity);
    }

    public void showAllView(ArrayList<PackedOutlet> dataOutlet){
        final ArrayList<PackedOutlet> data = mPresenter.sortByAscending(dataOutlet);

        mAdapter = new RecycleViewAdapterNearby(data, getResources());
        mRecyclerView.setAdapter(mAdapter);

        ((RecycleViewAdapterNearby) mAdapter).setOnItemClickListener(new RecycleViewAdapterNearby.MyClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                gotoNewTask(new Intent(activity, OrderListActivity.class), data.get(position), "DATAOUTLET");
            }
        });
    }

    public void gotoNewTask(Intent intent){
        startActivity(intent);
        activity.finish();
    }

    public void gotoNewTask(Intent intent, PackedOutlet packedOutlet, String intentMessage){
        intent.putExtra(intentMessage, packedOutlet);
        startActivity(intent);
        activity.finish();
    }

    public void gotoNewTask(Intent intent,LoginObj loginObj ,int id){
        intent.putExtra("session", loginObj);
        intent.putExtra("id", id);
        startActivity(intent);
        activity.finish();
    }

    public void setPresenter(NearbyContract.Presenter presenter){
        mPresenter = presenter;
    }
}
