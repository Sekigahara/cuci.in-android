package com.example.cuciin_android.activity.modul.nearby;

import com.example.cuciin_android.data.model.Outlet;

import java.util.ArrayList;

public class NearbyPresenter implements NearbyContract.Presenter{
    private final NearbyContract.View view;

    public NearbyPresenter(NearbyContract.View view){
        this.view = view;
    }

    public void start(){

    }

    public ArrayList<Outlet> getDataset(){
        ArrayList<Outlet> data = new ArrayList<>();

        return data;
    }
}
