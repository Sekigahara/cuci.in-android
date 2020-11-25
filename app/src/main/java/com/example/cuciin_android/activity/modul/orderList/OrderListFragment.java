package com.example.cuciin_android.activity.modul.orderList;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cuciin_android.R;
import com.example.cuciin_android.base.BaseFragment;
import com.example.cuciin_android.data.model.Transaction;
import com.example.cuciin_android.utils.RecycleViewAdapterNearby;
import com.example.cuciin_android.utils.RecycleViewAdapterOrderList;

import java.util.ArrayList;
import java.util.List;

public class OrderListFragment extends BaseFragment<OrderListActivity, OrderListContract.Presenter> implements OrderListContract.View {
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    RecyclerView mRecyclerView;
    Transaction transaction;

    public OrderListFragment(Transaction transaction){
        this.transaction = transaction;
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

        final List<Transaction.Data> data = transaction.getData();
        mAdapter = new RecycleViewAdapterOrderList(data);
        mRecyclerView.setAdapter(mAdapter);

//        ((RecycleViewAdapterNearby) mAdapter).setOnItemClickListener(new RecycleViewAdapterNearby.MyClickListener() {
//            @Override
//            public void onItemClick(int position, View view) {
//                String id = data.get(position).getId();
//                Log.d("Dashboard", ">>>>" + position);
//                goToDetailTransaksi(id);
//            }
//        });

        return fragmentView;
    }

    public void gotoNewTask(Intent intent){

    }

    public void goToDetailTransaksi(int id) {
    }

    public void setPresenter(OrderListContract.Presenter presenter){
        mPresenter = presenter;
    }

    @Override
    public void gotoNewTask() {

    }
}
