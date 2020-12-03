package com.example.cuciin_android.activity.modul.nearby;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import com.example.cuciin_android.activity.modul.dashboard.LocationTrack;
import com.example.cuciin_android.activity.modul.order.OrderActivity;
import com.example.cuciin_android.base.BaseFragment;
import com.example.cuciin_android.data.model.login.LoginObj;
import com.example.cuciin_android.data.model.OutletTestObj;
import com.example.cuciin_android.data.model.outlet.DataOutletObj;
import com.example.cuciin_android.data.model.outlet.OutletObj;
import com.example.cuciin_android.utils.recycler.RecycleViewAdapterNearby;
import com.example.cuciin_android.utils.utility.UtilProvider;

import java.util.List;

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

        if(statusOfGPS == true){
            LocationTrack locationTrack = new LocationTrack(activity);

            final Double lat = locationTrack.getLatitude();
            final Double lng = locationTrack.getLongitude();
            UtilProvider.initKey("AIzaSyCi5K_CX39rkJPvxfULr1HZKMChpvvh1IM");

            mPresenter.fetchMaps(1500, "false","laundry",lat, lng,UtilProvider.getKey(), activity);
        }else{
            Toast.makeText(getActivity(), "Enable Your GPS", Toast.LENGTH_LONG).show();
            gotoNewTask(new Intent(activity, DashboardActivity.class));
        }

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

        ((RecycleViewAdapterNearby) mAdapter).setOnItemClickListener(new RecycleViewAdapterNearby.MyClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                Log.d("Dashboard", " >>>> " + position);
                mPresenter.orderItem(activity, listOutlet.get(position));
            }
        });
        return fragmentView;
    }

    public void viewNearby(OutletObj outletObj){
        final List<DataOutletObj> listOutlet = outletObj.getResults();
        mAdapter = new RecycleViewAdapterNearby(listOutlet, getResources());
        mRecyclerView.setAdapter(mAdapter);

        //final List<DataOutletTestObj> listOutlet = outletTestObj.getData();
        //mAdapter = new RecycleViewAdapterNearby(listOutlet);
        //mRecyclerView.setAdapter(mAdapter);
    }

    public void gotoNewTask(Intent intent){
        startActivity(intent);
        activity.finish();
    }

    public void gotoNewTask(Intent intent, LoginObj loginObj){
        intent.putExtra("session", loginObj);
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
