package com.example.cuciin_android.activity.modul.nearby;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cuciin_android.R;
import com.example.cuciin_android.base.BaseFragment;
import com.example.cuciin_android.data.model.Outlet;
import com.example.cuciin_android.utils.RecycleViewAdapterNearby;

import java.util.ArrayList;

public class NearbyFragment extends BaseFragment<NearbyActivity, NearbyContract.Presenter> implements NearbyContract.View {
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    RecyclerView mRecyclerView;
    SearchView svNearby;
    public NearbyFragment(){

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

        final ArrayList<Outlet> data = mPresenter.getDataset();
        mAdapter = new RecycleViewAdapterNearby(data);
        mRecyclerView.setAdapter(mAdapter);



        svNearby = fragmentView.findViewById(R.id.svNearby);

        /*
        ((RecycleViewAdapterNearby) mAdapter).setOnItemClickListener(new RecycleViewAdapterNearby.MyClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                String id = data.get(position).getId();
                Log.d("Dashboard", ">>>>" + position);
                goToSchedule(id);
            }
        });
        */
        return fragmentView;
    }

    public void gotoNewTask(){

    }

    public void setPresenter(NearbyContract.Presenter presenter){
        mPresenter = presenter;
    }
}
