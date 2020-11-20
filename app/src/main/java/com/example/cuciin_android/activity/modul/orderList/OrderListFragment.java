package com.example.cuciin_android.activity.modul.orderList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cuciin_android.R;
import com.example.cuciin_android.base.BaseFragment;
import com.example.cuciin_android.utils.RecycleViewAdapterOrderList;

import java.util.ArrayList;

public class OrderListFragment extends BaseFragment<OrderListActivity, OrderListContract.Presenter> implements OrderListContract.View {
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    RecyclerView mRecyclerView;
    public OrderListFragment(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.activity_order_list, container, false);
        mPresenter = new OrderListPresenter(this);
        mPresenter.start();

        mRecyclerView = fragmentView.findViewById(R.id.rvOrderList);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(activity);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //final ArrayList<Transaction> data = mPresenter.getDataset();
        //mAdapter = new RecycleViewAdapterOrderList(data);
        //mRecyclerView.setAdapter(mAdapter);


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

    public void setPresenter(OrderListContract.Presenter presenter){
        mPresenter = presenter;
    }
}
