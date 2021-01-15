package com.example.cuciin_android.activity.modul.orderList;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.cuciin_android.data.model.transaction.PackedTransaction;
import com.example.cuciin_android.data.model.transaction.TransactionObj;
import com.example.cuciin_android.helper.ApiService;
import com.example.cuciin_android.helper.UtilsApi;
import com.example.cuciin_android.utils.session.UserSessionRepositoryRepository;
import com.google.android.gms.common.api.ApiException;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import com.google.android.libraries.places.api.net.PlacesClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderListPresenter implements OrderListContract.Presenter {
    private final OrderListContract.View view;
    private ArrayList<Place> listGooglePlace;
    ApiService mApiService;

    public OrderListPresenter(OrderListContract.View view) {
        this.view = view;
    }

    public void start() {
        listGooglePlace = new ArrayList<>();
    }

    public void getTransaction(final Activity activity, final Context context){
        String token = new UserSessionRepositoryRepository(context).getDataSession().getDataObj().getToken();
        int id = new UserSessionRepositoryRepository(context).getDataSession().getDataObj().getId();
        //UtilProvider.getUserSessionUtil().getSession().getSessionData().getDataObj().getId();

        mApiService = UtilsApi.getLocalAPIService();
        Call<TransactionObj> call = mApiService.getHistoryTransaction("Bearer " + token, id);
        call.enqueue(new Callback<TransactionObj>() {
            @Override
            public void onResponse(Call<TransactionObj> call, Response<TransactionObj> response) {
                if (response.isSuccessful() == true) {
                    TransactionObj transactionObj = response.body();
                    if (transactionObj.getSuccess() == true) {
                        view.setViewData(transactionObj);

                    } else
                        Toast.makeText(activity, "You Don't have any Transaction", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(activity, "You Don't have any Transaction", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(activity, t.getMessage(), Toast.LENGTH_LONG).show();
                view.setViewData(null);
            }
        });
    }

    private void getGoogleData(final String google_id, final String last_google_id, final Activity activity){
        final List<Place.Field> placeFields = Arrays.asList(Place.Field.ID, Place.Field.NAME, Place.Field.ADDRESS, Place.Field.NAME);
        final FetchPlaceRequest request = FetchPlaceRequest.newInstance(google_id, placeFields);

        PlacesClient placesClient = Places.createClient(activity);
        placesClient.fetchPlace(request).addOnSuccessListener((response) -> {
            Place place = response.getPlace();
            listGooglePlace.add(place);

            if(google_id.equals(last_google_id))
                view.setPackData(listGooglePlace);
            //Toast.makeText(activity, String.valueOf(listGooglePlace.size()), Toast.LENGTH_LONG).show();
        }).addOnFailureListener((exception) -> {
            if (exception instanceof ApiException) {
                final ApiException apiException = (ApiException) exception;
                Log.e("Response", "Place not found: " + exception.getMessage());
                final int statusCode = apiException.getStatusCode();
            }
        });
    }

    public ArrayList<PackedTransaction> packTransactionData(TransactionObj transactionObj, ArrayList<Place> listGoogle){
        ArrayList<PackedTransaction> listTransaction = new ArrayList<>();

        for(int i = 0 ; i < transactionObj.getData().size(); i++){
            PackedTransaction packedTransaction = new PackedTransaction();
            if(transactionObj.getData().get(i).getOutlet() == null && transactionObj.getData().get(i).getOutletGoogleId() != null){
                String google_id = transactionObj.getData().get(i).getOutletGoogleId();
                //Toast.makeText(view.getActivityView(), "test : " + String.valueOf(listGoogle.get(0).getAddress()), Toast.LENGTH_LONG).show();
                for(int k = 0 ; k < listGoogle.size(); k++){

                    Place placeDetail;
                    if(listGoogle.get(k).getId().equals(google_id)) {
                        placeDetail = listGoogle.get(k);

                        packedTransaction.setAddress(placeDetail.getAddress());
                        packedTransaction.setName(placeDetail.getName());
                        packedTransaction.setGoogle_id(placeDetail.getId());
                        packedTransaction.setPrice(transactionObj.getData().get(i).getPrice());
                        packedTransaction.setStatus(transactionObj.getData().get(i).getStatus());
                        packedTransaction.setPONumber(transactionObj.getData().get(i).getPoNumber());
                    }
                }
            }else{
                packedTransaction.setName(transactionObj.getData().get(i).getOutlet().getName());
                packedTransaction.setStatus(transactionObj.getData().get(i).getStatus());
                packedTransaction.setPrice(transactionObj.getData().get(i).getPrice());
                packedTransaction.setPONumber(transactionObj.getData().get(i).getPoNumber());
                packedTransaction.setAddress(transactionObj.getData().get(i).getOutlet().getAddress());
            }

            listTransaction.add(packedTransaction);
        }

        return listTransaction;
    }

    public void getDetailsGoogleOutlet(TransactionObj transactionObj, Activity activity){
        ArrayList<String> google_id = new ArrayList<>();

        for(int i = 0; i < transactionObj.getData().size(); i++){
            if(transactionObj.getData().get(i).getOutletGoogleId() != null)
                google_id.add(transactionObj.getData().get(i).getOutletGoogleId());
        }

        for(int i = 0; i < transactionObj.getData().size(); i++){
            if(transactionObj.getData().get(i).getOutletGoogleId() != null)
                getGoogleData(transactionObj.getData().get(i).getOutletGoogleId(), google_id.get(google_id.size() - 1), activity);
        }
    }
}