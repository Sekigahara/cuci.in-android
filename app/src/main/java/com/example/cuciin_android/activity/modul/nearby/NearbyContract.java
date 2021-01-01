package com.example.cuciin_android.activity.modul.nearby;

import android.app.Activity;
import android.content.Intent;

import com.example.cuciin_android.base.BasePresenter;
import com.example.cuciin_android.base.BaseView;
import com.example.cuciin_android.data.model.PackedOutlet;
import com.example.cuciin_android.data.model.outlet.DataOutletObj;
import com.example.cuciin_android.data.model.outlet.OutletObj;
import com.example.cuciin_android.data.model.outlet_local.OutletLocal;

import java.util.ArrayList;
import java.util.List;

public interface NearbyContract {
    interface View extends BaseView<Presenter> {
        void gotoNewTask(Intent intent);
        void gotoNewTask(Intent intent, PackedOutlet packedOutlet, String intentMessage);
        void viewNearby(OutletObj outletObj);
        void showAllView(ArrayList<PackedOutlet> dataOutlet);
    }

    interface Presenter extends BasePresenter {
        void fetchMaps(int radius, String sensor, String types, Double lat, Double lng, String key, final Activity activity);
        void fetchLocalMaps(List<DataOutletObj> data, final Activity activity, final String token);
        void packingData(final List<DataOutletObj> data, OutletLocal outletLocal);
        ArrayList<PackedOutlet> sortByAscending(ArrayList<PackedOutlet> data);
    }
}
