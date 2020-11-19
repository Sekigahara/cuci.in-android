package com.example.cuciin_android.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.cuciin_android.R;
import com.example.cuciin_android.data.model.Outlet;

import java.util.ArrayList;

public class RecycleViewAdapterNearby extends RecyclerView.Adapter<RecycleViewAdapterNearby.MyViewHolder>{
    private static ArrayList<Outlet> mDataset;
    private static MyClickListener myClickListener;

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView ivLaundryPhoto;
        TextView tvLaundryName;
        TextView tvLaundryDistance;
        TextView tvOperationalHoursText;
        TextView tvOperationalHours;
        public MyViewHolder(View itemView){
            super(itemView);
            ivLaundryPhoto = (ImageView) itemView.findViewById(R.id.ivLaundryPhoto);
            tvLaundryName = (TextView) itemView.findViewById(R.id.tvLaundryName);
            tvLaundryDistance = (TextView) itemView.findViewById(R.id.tvLaundryDistance);
            tvOperationalHoursText = (TextView) itemView.findViewById(R.id.tvOperationalHoursText);
            tvOperationalHours = (TextView) itemView.findViewById(R.id.tvOperationalHours);
            itemView.setOnClickListener(this);
        }

        public void onClick(View view){
            int position = getAdapterPosition();
            myClickListener.onItemClick(position, view);
        }
    }

    public RecycleViewAdapterNearby(ArrayList<Outlet> myDataset){
        mDataset = myDataset;
    }

    public RecycleViewAdapterNearby.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_nearby_list, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    public void onBindViewHolder(MyViewHolder holder, int position){
        //holder.ivListImage.setImageResource(mDataset.get(position).getImage());
        //holder.tvTitle.setText(mDataset.get(position).getTitle());
        //holder.tvDescription.setText(mDataset.get(position).getDescription());
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
