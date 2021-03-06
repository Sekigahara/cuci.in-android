package com.example.cuciin_android.activity.modul.orderList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cuciin_android.R;
import com.example.cuciin_android.activity.modul.dashboard.DashboardActivity;
import com.example.cuciin_android.activity.modul.detail_transaction.DetailActivity;
import com.example.cuciin_android.base.BaseFragment;
import com.example.cuciin_android.data.model.transaction.PackedTransaction;
import com.example.cuciin_android.data.model.transaction.TransactionObj;
import com.example.cuciin_android.utils.recycler.RecycleViewAdapterOrderList;
import com.google.android.libraries.places.api.model.Place;

import java.util.ArrayList;

public class OrderListFragment extends BaseFragment<OrderListActivity, OrderListContract.Presenter> implements OrderListContract.View {
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private TransactionObj transactionObj;
    RecyclerView mRecyclerView;
    TextView icBtBack;

    public OrderListFragment(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.activity_order_list, container, false);
        mPresenter = new OrderListPresenter(this);
        mPresenter.start();

        mPresenter.getTransaction(activity, getContext());
        mRecyclerView = fragmentView.findViewById(R.id.rvOrderList);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(activity);
        mRecyclerView.setLayoutManager(mLayoutManager);

        icBtBack = fragmentView.findViewById(R.id.icBtBack);
        icBtBack.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                gotoNewTask(new Intent(activity, DashboardActivity.class));
            }
        });

        return fragmentView;
    }

    public void setViewData(TransactionObj transactionObj){
        this.transactionObj = transactionObj;

        if(transactionObj == null){
            Toast.makeText(activity, "There is no Transaction History", Toast.LENGTH_LONG).show();
        }else{
            //Toast.makeText(activity, "Transaction History is exist", Toast.LENGTH_LONG).show();
            mPresenter.getDetailsGoogleOutlet(transactionObj, activity);
        }
    }

    public void setPackData(ArrayList<Place> listPlace){
        final ArrayList<PackedTransaction> listTransaction = mPresenter.packTransactionData(transactionObj, listPlace);

        mAdapter = new RecycleViewAdapterOrderList(listTransaction);
        mRecyclerView.setAdapter(mAdapter);

        ((RecycleViewAdapterOrderList) mAdapter).setOnItemClickListener(new RecycleViewAdapterOrderList.MyClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                PackedTransaction packedTransaction = listTransaction.get(position);
                gotoNewTask(new Intent(activity, DetailActivity.class), packedTransaction);
            }
        });
    }

    public Activity getActivityView(){
        return activity;
    }

    public void gotoNewTask(Intent intent){
        startActivity(intent);
    }

    public void gotoNewTask(Intent intent, PackedTransaction data){
        intent.putExtra("transaction", data);
        startActivity(intent);
    }

    public void setPresenter(OrderListContract.Presenter presenter){
        mPresenter = presenter;
    }
}
