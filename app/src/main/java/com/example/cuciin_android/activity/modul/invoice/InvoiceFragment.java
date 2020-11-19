package com.example.cuciin_android.activity.modul.invoice;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cuciin_android.R;
import com.example.cuciin_android.base.BaseFragment;
import com.example.cuciin_android.data.model.Transaction;
import com.example.cuciin_android.utils.RecycleViewAdapterInvoice;

import java.util.ArrayList;

public class InvoiceFragment extends BaseFragment<InvoiceActivity, InvoiceContract.Presenter> implements InvoiceContract.View {
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    RecyclerView mRecyclerView;
    TextView tvLaundryName;
    TextView tvLocation;
    TextView tvTotal;

    public InvoiceFragment(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.activity_detail_transaction, container, false);
        mPresenter = new InvoicePresenter(this);
        mPresenter.start();

        mRecyclerView = fragmentView.findViewById(R.id.rvTransaction);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(activity);
        mRecyclerView.setLayoutManager(mLayoutManager);

        final ArrayList<Transaction> data = mPresenter.getDataset();
        mAdapter = new RecycleViewAdapterInvoice(data);
        mRecyclerView.setAdapter(mAdapter);

        tvLaundryName = (TextView) fragmentView.findViewById(R.id.textView_laundry_name_fill);
        tvLocation = (TextView) fragmentView.findViewById(R.id.textView_location_fill);
        tvTotal = (TextView) fragmentView.findViewById(R.id.textView_total_fill);
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

    public void setPresenter(InvoiceContract.Presenter presenter){
        mPresenter = presenter;
    }
}
