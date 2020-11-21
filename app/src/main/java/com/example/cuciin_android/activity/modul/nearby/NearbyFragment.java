package com.example.cuciin_android.activity.modul.nearby;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cuciin_android.R;
import com.example.cuciin_android.activity.modul.dashboard.DashboardActivity;
import com.example.cuciin_android.base.BaseFragment;
import com.example.cuciin_android.data.model.DataOutletObj;
import com.example.cuciin_android.data.model.LoginObj;
import com.example.cuciin_android.data.model.OutletObj;
import com.example.cuciin_android.utils.RecycleViewAdapterNearby;

import java.util.List;

public class NearbyFragment extends BaseFragment<NearbyActivity, NearbyContract.Presenter> implements NearbyContract.View {
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private OutletObj outletObj;
    RecyclerView mRecyclerView;
    SearchView svNearby;
    TextView icBtBack;

    public NearbyFragment(OutletObj outletObj){
        this.outletObj = outletObj;
    }

    public android.view.View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_nearby, container, false);
        mPresenter = new NearbyPresenter(this);
        mPresenter.start();

        mRecyclerView = fragmentView.findViewById(R.id.rvNearby);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(activity);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //String queryLink = mPresenter.getGoogleQueryLink("-7.313053, 112.717466", "1500", "AIzaSyD0_sZhy7fJoeUcIGTmkTZbl5FNxYr2N-o");

        final List<DataOutletObj> listOutlet = outletObj.getData();
        mAdapter = new RecycleViewAdapterNearby(listOutlet);
        mRecyclerView.setAdapter(mAdapter);

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
                int id = listOutlet.get(position).getId();
                Log.d("Dashboard", ">>>>" + position);

            }
        });
        return fragmentView;
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
