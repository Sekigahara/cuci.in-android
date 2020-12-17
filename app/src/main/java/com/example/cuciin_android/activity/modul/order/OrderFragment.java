 package com.example.cuciin_android.activity.modul.order;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cuciin_android.R;
import com.example.cuciin_android.base.BaseFragment;
import com.example.cuciin_android.data.model.DataLaundryType;
import com.example.cuciin_android.data.model.LaundryType;
import com.example.cuciin_android.data.model.nearby.PackedOutlet;
import com.example.cuciin_android.data.model.outlet.DataOutletObj;
import com.example.cuciin_android.data.model.login.LoginObj;
import com.example.cuciin_android.utils.RecycleViewAdapterLaundryType;
import com.example.cuciin_android.utils.utility.UtilProvider;

import java.util.List;


 public class OrderFragment extends BaseFragment<OrderActivity, OrderContract.Presenter> implements OrderContract.View {
     PackedOutlet packedOutlet;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    RecyclerView mRecyclerView;
    private TextView titleOutlet;
    private TextView alamatOutlet;
    private TextView manhours;
    private TextView rating;
    private Button buttonOrder;
    int[] id;

    public OrderFragment(PackedOutlet packedOutlet) {
        this.packedOutlet = packedOutlet;
    }

     @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.order_view, container, false);
        mPresenter = new OrderPresenter(this);
        mPresenter.start();

        setDataOutlet();

        mRecyclerView = fragmentView.findViewById(R.id.recyclerViewListTypeLaundry);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(activity);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mPresenter.orderItem(activity);
        return fragmentView;
    }

    public void viewLaundryTypeData(final LaundryType laundryType){
        final List<DataLaundryType> listLaundryType = laundryType.getData();
        mAdapter = new RecycleViewAdapterLaundryType(listLaundryType);
        mRecyclerView.setAdapter(mAdapter);
        id = new int[listLaundryType.size()];
        tambahData(listLaundryType.size());

        ((RecycleViewAdapterLaundryType) mAdapter).setOnItemClickListener(new RecycleViewAdapterLaundryType.MyClickListener() {
            @Override
            public void onAddClick(int position, View view) {
                Toast.makeText(activity, "tambah data" + position, Toast.LENGTH_LONG).show();
                ((RecycleViewAdapterLaundryType) mAdapter).addAmount(position);
            }
        });

        buttonOrder = fragmentView.findViewById(R.id.buttonOrder);

        buttonOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final LaundryType laundryTypeYeet = laundryType;
                mPresenter.addTransaction(activity, packedOutlet, ((RecycleViewAdapterLaundryType) mAdapter).getAmount(), laundryTypeYeet);
            }
        });
    }

    @Override
    public void setPresenter(OrderContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override

    public void setDataOutlet() {
        titleOutlet = fragmentView.findViewById(R.id.textViewNamaLaundry);

        titleOutlet.setText(packedOutlet.getName());
    }

     @Override
     public void setDataTipeLaundry() {

     }

     @Override
     public void goToNewTask(Intent intent) {
        startActivity(intent);
        activity.finish();
     }

     public void setTypeLaundry(){

     }

     public void addItem(int position){
        id[position]++;
     }

     public void tambahData(int length) {
        id = mPresenter.setData(length);
     }
}
