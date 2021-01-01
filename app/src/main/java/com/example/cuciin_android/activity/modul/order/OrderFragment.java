 package com.example.cuciin_android.activity.modul.order;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cuciin_android.R;
import com.example.cuciin_android.base.BaseFragment;
import com.example.cuciin_android.data.model.DataLaundryType;
import com.example.cuciin_android.data.model.LaundryType;
import com.example.cuciin_android.data.model.PackedOutlet;
import com.example.cuciin_android.utils.recycler.RecycleViewAdapterLaundryType;
import com.squareup.picasso.Picasso;

import java.util.List;


 public class OrderFragment extends BaseFragment<OrderActivity, OrderContract.Presenter> implements OrderContract.View {
     PackedOutlet packedOutlet;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    RecyclerView mRecyclerView;
    private TextView titleOutlet;
    private TextView rating;
    private ImageView outletIcon;
    private TextView status;
    private Button buttonOrder;
    private View cardViewLaundry;
    private View baseView;
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

        mPresenter.orderItem(activity, getContext());
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


        buttonOrder = (Button) fragmentView.findViewById(R.id.buttonOrder);

        buttonOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.addTransaction(activity, getContext(), packedOutlet, ((RecycleViewAdapterLaundryType) mAdapter).getAmount(), laundryType);
            }
        });
    }

    @Override
    public void setPresenter(OrderContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override

    public void setDataOutlet() {
        rating = fragmentView.findViewById(R.id.textViewRating);
        outletIcon = fragmentView.findViewById(R.id.imageCardProfile);
        titleOutlet = fragmentView.findViewById(R.id.textViewNamaLaundry);
        status = fragmentView.findViewById(R.id.textViewStatus);
        cardViewLaundry = fragmentView.findViewById(R.id.background);

        titleOutlet.setText(packedOutlet.getName());
        rating.setText(String.valueOf(packedOutlet.getRating()));

        if (packedOutlet.getPhoto() == null) {
            outletIcon.setImageResource(R.mipmap.ic_notfound);
        }else {
            String URL = mPresenter.getUrlLoad(packedOutlet.getPhoto(), 400, 400);
            Picasso.get().load(URL).into(outletIcon);
        }

        Drawable greenButton = getResources().getDrawable(R.drawable.custom_status);
        Drawable redButton =getResources().getDrawable(R.drawable.custom_status_red);

        if(packedOutlet.getOpen() == true){
            status.setText("Open");
            status.setBackground(greenButton);
        }else{
            status.setText("Close");
            status.setBackground(redButton);
        }

        cardViewLaundry.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(packedOutlet.getLat() == null || packedOutlet.getLng() == null)
                    Toast.makeText(activity, "This Outlet Doesn't Recorded in Gmaps", Toast.LENGTH_LONG).show();
                else{
                    String URL =mPresenter.settingGmapsRedirectURL(
                            packedOutlet.getLat(),
                            packedOutlet.getLng(),
                            packedOutlet.getName()
                    );

                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL));
                    getContext().startActivity(intent);
                }
            }
        });
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
