package com.example.cuciin_android.activity.modul.detail_transaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cuciin_android.R;
import com.example.cuciin_android.activity.modul.dashboard.DashboardActivity;
import com.example.cuciin_android.activity.modul.orderList.OrderListActivity;
import com.example.cuciin_android.base.BaseFragment;
import com.example.cuciin_android.data.model.OutletTestObj;
import com.example.cuciin_android.data.model.login.LoginObj;
import com.example.cuciin_android.data.model.outlet.DataOutletObj;
import com.example.cuciin_android.data.model.outlet.OutletObj;
import com.example.cuciin_android.data.model.transaction.DataTransactionObj;
import com.example.cuciin_android.utils.recycler.RecycleViewAdapterNearby;

import java.util.List;

public class DetailFragment extends BaseFragment<DetailActivity, DetailContract.Presenter> implements DetailContract.View {
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private DataTransactionObj dataTransactionObj;
    RecyclerView mRecyclerView;
    TextView icBtBack;
    TextView tvLaundryName;
    TextView tvLaundryLocation;

    public DetailFragment(DataTransactionObj dataTransactionObj){
        this.dataTransactionObj = dataTransactionObj;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.activity_detail_transaction, container, false);
        mPresenter = new DetailPresenter(this);
        mPresenter.start();

        mRecyclerView = fragmentView.findViewById(R.id.rvTransaction);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(activity);
        mRecyclerView.setLayoutManager(mLayoutManager);

        tvLaundryName = (TextView) fragmentView.findViewById(R.id.textView_laundry_name_fill);
        tvLaundryLocation = (TextView) fragmentView.findViewById(R.id.textView_location_fill);

        tvLaundryName.setText(dataTransactionObj.getOutlet().getName());
        tvLaundryLocation.setText(dataTransactionObj.getOutlet().getAddress());
        //final List<DataOutletObj> listOutlet =outletObj.getResults();
        //mAdapter = new RecycleViewAdapterNearby(listOutlet, getResources());
        //mRecyclerView.setAdapter(mAdapter);
        //final List<DataOutletTestObj> listOutlet = outletTestObj.getData();
        //mAdapter = new RecycleViewAdapterNearby(listOutlet);
        //mRecyclerView.setAdapter(mAdapter);

        icBtBack = fragmentView.findViewById(R.id.icBtBack);
        icBtBack.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                gotoNewTask(new Intent(activity, OrderListActivity.class));
            }
        });

        return fragmentView;
    }

    public void gotoNewTask(Intent intent){
        startActivity(intent);
        activity.finish();
    }

    public void setPresenter(DetailContract.Presenter presenter){
        mPresenter = presenter;
    }
}
