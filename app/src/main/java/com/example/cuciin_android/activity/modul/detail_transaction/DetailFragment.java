package com.example.cuciin_android.activity.modul.detail_transaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cuciin_android.R;
import com.example.cuciin_android.activity.modul.orderList.OrderListActivity;
import com.example.cuciin_android.base.BaseFragment;
import com.example.cuciin_android.data.model.transaction.PackedTransaction;

public class DetailFragment extends BaseFragment<DetailActivity, DetailContract.Presenter> implements DetailContract.View {
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private PackedTransaction packedTransaction;
    RecyclerView mRecyclerView;
    TextView icBtBack;
    TextView tvLaundryName;
    TextView tvLaundryLocation;
    TextView tvTotal;
    TextView tvPONumber;

    public DetailFragment(PackedTransaction packedTransaction){
        this.packedTransaction = packedTransaction;
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
        tvTotal = (TextView) fragmentView.findViewById(R.id.textView_total_fill);
        tvPONumber = (TextView) fragmentView.findViewById(R.id.textView_nomor_order);

        tvLaundryName.setText(packedTransaction.getName());
        tvLaundryLocation.setText(packedTransaction.getAddress());
        tvPONumber.setText("#" + packedTransaction.getPONumber());

        double price;
        if(packedTransaction.getPrice() == null)
            price = 0.0;
        else
            price = packedTransaction.getPrice();
        tvTotal.setText("Rp. " + price);
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
