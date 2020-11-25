package com.example.cuciin_android.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.cuciin_android.R;
import com.example.cuciin_android.data.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewAdapterOrderList extends RecyclerView.Adapter<RecycleViewAdapterOrderList.MyViewHolder>{
    private static List<Transaction.Data> mDataset;
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

    public RecycleViewAdapterOrderList(List<Transaction.Data> myDataset){
        mDataset = myDataset;
    }

    public RecycleViewAdapterOrderList.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_order_list, parent, false);
        RecycleViewAdapterOrderList.MyViewHolder myViewHolder = new RecycleViewAdapterOrderList.MyViewHolder(view);

        return myViewHolder;
    }

    public void onBindViewHolder(RecycleViewAdapterOrderList.MyViewHolder holder, int position){
        holder.tvOrderNumber.setText(mDataset.get(position).getPo_number());
        holder.tvLaundryName.setText(mDataset.get(position).getOutlet().getName());
        holder.tvPrice.setText(mDataset.get(position).getPrice());
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
