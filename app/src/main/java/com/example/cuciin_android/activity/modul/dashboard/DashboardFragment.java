package com.example.cuciin_android.activity.modul.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.cuciin_android.R;
import com.example.cuciin_android.base.BaseFragment;
import com.example.cuciin_android.data.source.session.UserSessionRepositoryRepository;
import com.example.cuciin_android.data.source.util.UtilProvider;

public class DashboardFragment extends BaseFragment<DashboardActivity, DashboardContract.Presenter> implements DashboardContract.View {
    UserSessionRepositoryRepository userSession;
    ImageView ivNearby;
    ImageView ivLogout;

    public DashboardFragment(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.activity_dashboard, container, false);
        mPresenter = new DashboardPresenter(this);
        mPresenter.start();

        final Double lat = -7.313053;
        final Double lng = 112.717466;
        UtilProvider.initKey("AIzaSyCi5K_CX39rkJPvxfULr1HZKMChpvvh1IM");
        ivNearby = fragmentView.findViewById(R.id.imageView_Nearby);
        ivNearby.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                //String queryURL = mPresenter.getGoogleQueryLink("-7.313053, 112.717466", "1500", "AIzaSyD0_sZhy7fJoeUcIGTmkTZbl5FNxYr2N-o");
                mPresenter.fetchMaps(1500, "false","laundry",lat, lng,UtilProvider.getKey(), activity);
                //mPresenter.getOutletData(activity, getContext());
                //gotoNewTask(new Intent(activity, NearbyActivity.class));
            }
        });

        /*
        ivLogout = fragmentView.findViewById(R.id.imageView_log);
        ivLogout.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                getContext().getSharedPreferences("SessionSharedPreferences", Context.MODE_PRIVATE).edit().clear().apply();
            }
        });
         */

        return fragmentView;
    }

    public void gotoNewTask(Intent intent){
        startActivity(intent);
        activity.finish();
    }

    public void setPresenter(DashboardContract.Presenter presenter){
        mPresenter = presenter;
    }
}
