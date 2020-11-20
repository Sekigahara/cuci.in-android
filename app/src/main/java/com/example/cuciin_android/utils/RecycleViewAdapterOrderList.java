package com.example.cuciin_android.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.cuciin_android.R;

import java.util.ArrayList;

public class RecycleViewAdapterOrderList extends RecyclerView.Adapter<RecycleViewAdapterOrderList.MyViewHolder>{
    //private static ArrayList<Transaction> mDataset;
    private static RecycleViewAdapterOrderList.MyClickListener myClickListener;

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvOrderNumber;
        TextView tvLaundryName;
        TextView tvPrice;

        public MyViewHolder(View itemView){
            super(itemView);
            tvOrderNumber = (TextView) itemView.findViewById(R.id.textView_OrderNumber);
            tvLaundryName = (TextView) itemView.findViewById(R.id.textView_Laundry_name_Order_List);
            tvPrice = (TextView) itemView.findViewById(R.id.textView_total_price_order_list);
            itemView.setOnClickListener(this);
        }

        public void onClick(View view){
            int position = getAdapterPosition();
            myClickListener.onItemClick(position, view);
        }
    }

    public RecycleViewAdapterOrderList(/*ArrayList<Transaction> myDataset*/){
        //mDataset = myDataset;
    }

    public RecycleViewAdapterOrderList.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_order_list, parent, false);
        RecycleViewAdapterOrderList.MyViewHolder myViewHolder = new RecycleViewAdapterOrderList.MyViewHolder(view);

        return myViewHolder;
    }

    public void onBindViewHolder(RecycleViewAdapterOrderList.MyViewHolder holder, int position){
        //holder.ivListImage.setImageResource(mDataset.get(position).getImage());
        //holder.tvTitle.setText(mDataset.get(position).getTitle());
        //holder.tvDescription.setText(mDataset.get(position).getDescription());
    }

    public int getItemCount(){
        return 0;//mDataset.size();
    }

    public void setOnItemClickListener(RecycleViewAdapterOrderList.MyClickListener myClickListener){
        this.myClickListener = myClickListener;
    }

    public interface MyClickListener{
        public void onItemClick(int position, View view);
    }
}
