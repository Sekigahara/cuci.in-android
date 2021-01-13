package com.example.cuciin_android.activity.modul.nearby;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cuciin_android.R;
import com.example.cuciin_android.activity.modul.dashboard.DashboardActivity;
import com.example.cuciin_android.activity.modul.order.OrderActivity;
import com.example.cuciin_android.base.BaseFragment;
import com.example.cuciin_android.data.model.login.LoginObj;
import com.example.cuciin_android.data.model.OutletTestObj;
import com.example.cuciin_android.data.model.PackedOutlet;
import com.example.cuciin_android.data.model.outlet.DataOutletObj;
import com.example.cuciin_android.data.model.outlet.OutletObj;
import com.example.cuciin_android.utils.recycler.RecycleViewAdapterNearby;
import com.example.cuciin_android.utils.session.UserSessionRepositoryRepository;
import com.example.cuciin_android.utils.utility.UtilProvider;

import java.util.ArrayList;
import java.util.List;

import pub.devrel.easypermissions.EasyPermissions;

import static android.content.Context.LOCATION_SERVICE;

public class NearbyFragment extends BaseFragment<NearbyActivity, NearbyContract.Presenter> implements NearbyContract.View {
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private OutletTestObj outletTestObj;
    private OutletObj outletObj;
    RecyclerView mRecyclerView;
    SearchView svNearby;
    TextView icBtBack;

    public NearbyFragment(){

    }

    public android.view.View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_nearby, container, false);
        mPresenter = new NearbyPresenter(this);
        mPresenter.start();

        findNearby();

        return fragmentView;
    }

    private void findNearby(){
        LocationManager locationManager = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);
        boolean statusOfGPS = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

        if(statusOfGPS){
            mPresenter.fetchMaps(1500, "false","laundry", UtilProvider.getKey(), activity);

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
        }else{
            Toast.makeText(activity, "Enable your GPS", Toast.LENGTH_SHORT).show();
            gotoNewTask(new Intent(activity, DashboardActivity.class));
        }
    }

    public void viewNearby(OutletObj outletObj){
        final List<DataOutletObj> listOutlet = outletObj.getResults();
        mPresenter.fetchLocalMaps(listOutlet, activity, new UserSessionRepositoryRepository(getContext()).getDataSession().getDataObj().getToken());
    }

    public void showAllView(ArrayList<PackedOutlet> dataOutlet){
        final ArrayList<PackedOutlet> data = mPresenter.sortByAscending(dataOutlet);

        mAdapter = new RecycleViewAdapterNearby(data, getResources());
        mRecyclerView.setAdapter(mAdapter);

        ((RecycleViewAdapterNearby) mAdapter).setOnItemClickListener(new RecycleViewAdapterNearby.MyClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                gotoNewTask(new Intent(activity, OrderActivity.class), data.get(position), "DATAOUTLET");
            }
        });
    }

    public void gotoNewTask(Intent intent){
        startActivity(intent);
    }

    public void gotoNewTask(Intent intent, PackedOutlet packedOutlet, String intentMessage){
        intent.putExtra(intentMessage, packedOutlet);
        startActivity(intent);
    }

    public void gotoNewTask(Intent intent,LoginObj loginObj ,int id){
        intent.putExtra("session", loginObj);
        intent.putExtra("id", id);
        startActivity(intent);
    }

    public void setPresenter(NearbyContract.Presenter presenter){
        mPresenter = presenter;
    }
}
