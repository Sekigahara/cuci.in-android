package com.example.cuciin_android.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.cuciin_android.R;
import com.example.cuciin_android.data.model.DataOutletTestObj;
import com.example.cuciin_android.data.model.outlet.DataOutletObj;
import com.example.cuciin_android.data.model.outlet.Location;
import com.example.cuciin_android.data.source.util.LocationUtil;
import com.example.cuciin_android.data.source.util.UtilProvider;
import com.example.cuciin_android.helper.UtilsApi;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.SphericalUtil;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecycleViewAdapterNearby extends RecyclerView.Adapter<RecycleViewAdapterNearby.MyViewHolder>{
    private static List<DataOutletObj> mDataset;
    private static MyClickListener myClickListener;

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView ivLaundryPhoto;
        TextView tvLaundryName;
        TextView tvLaundryDistance;
        TextView tvOperationalHoursText;
        TextView tvOperationalHours;
        TextView tvRating;
        Button btStatus;
        public MyViewHolder(View itemView){
            super(itemView);
            ivLaundryPhoto = (ImageView) itemView.findViewById(R.id.ivLaundryPhoto);
            tvLaundryName = (TextView) itemView.findViewById(R.id.tvLaundryName);
            tvLaundryDistance = (TextView) itemView.findViewById(R.id.tvLaundryDistance);
            tvRating = (TextView) itemView.findViewById(R.id.tvRating);
            btStatus = (Button) itemView.findViewById(R.id.btStatus);
            itemView.setOnClickListener(this);
        }

        public void onClick(View view){
            int position = getAdapterPosition();
            myClickListener.onItemClick(position, view);
        }
    }

    public RecycleViewAdapterNearby(List<DataOutletObj> myDataset){
        mDataset = myDataset;
    }

    public RecycleViewAdapterNearby.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_nearby_list, parent, false);
        RecycleViewAdapterNearby.MyViewHolder myViewHolder = new RecycleViewAdapterNearby.MyViewHolder(view);

        return myViewHolder;
    }

    public void onBindViewHolder(MyViewHolder holder, int position){
        //Logic Set Distance
        Double fromLat = UtilProvider.getLocationUtil().getLocationLatitude();
        Double fromLng = UtilProvider.getLocationUtil().getLocationLongitude();
        LatLng from = new LatLng(fromLat, fromLng);

        Double toLat = mDataset.get(position).getGeometry().getLocation().getLat();
        Double toLng = mDataset.get(position).getGeometry().getLocation().getLng();
        LatLng to  = new LatLng(toLat, toLng);

        Double distance = countDistance(from, to);
        holder.tvLaundryDistance.setText(String.format("%.2f", distance) + " KM");

        //Set Laundry Name
        holder.tvLaundryName.setText(mDataset.get(position).getName());

        //Set Rating
        if(mDataset.get(position).getRating() == null)
            holder.tvRating.setText("unrated");
        else
            holder.tvRating.setText(mDataset.get(position).getRating().toString());


        holder.ivLaundryPhoto.setImageResource(R.mipmap.ic_notfound);
        //Set Photo
        if(mDataset.get(position).getPhotos() == null || mDataset.get(position).getPhotos().get(0).getPhotoReference() == null)
            holder.ivLaundryPhoto.setImageResource(R.mipmap.ic_notfound);
        else{
            String URL = settingUpURL("400", "400", mDataset.get(position).getPhotos().get(0).getPhotoReference());
            Picasso.get().load(URL).into(holder.ivLaundryPhoto);
        }

        //Set Status Open

        if(mDataset.get(position).getOpeningHours() == null){
            holder.btStatus.setText("Close");
            holder.btStatus.setBackgroundColor(R.attr.closeStatusColor);
        }else {
            if(mDataset.get(position).getOpeningHours().getOpenNow() == true){
                holder.btStatus.setText("Open");
                holder.btStatus.setBackgroundColor(R.attr.openStatusColor);
            }else{
                holder.btStatus.setText("Close");
                holder.btStatus.setBackgroundColor(R.attr.closeStatusColor);
            }
        }
    }

    private String settingUpURL(String width, String height, String reference){
        String URL = "https://maps.googleapis.com/maps/api/place/photo?maxwidth="+width
                +"&maxheight="+height+"&photoreference="+reference+"&key="+UtilProvider.getKey();

        return URL;
    }

    private Double countDistance(LatLng from, LatLng to){
        return SphericalUtil.computeDistanceBetween(from ,to) / 1000;
    }

    public int getItemCount(){
        return mDataset.size();
    }

    public void setOnItemClickListener(MyClickListener myClickListener){
        this.myClickListener = myClickListener;
    }

    public interface MyClickListener{
        public void onItemClick(int position, View view);
    }
}
