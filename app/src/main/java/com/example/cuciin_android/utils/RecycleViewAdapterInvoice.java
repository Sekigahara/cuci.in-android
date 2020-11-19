package com.example.cuciin_android.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.cuciin_android.R;
import com.example.cuciin_android.data.model.Outlet;
import com.example.cuciin_android.data.model.Transaction;

import java.util.ArrayList;

public class RecycleViewAdapterInvoice extends RecyclerView.Adapter<RecycleViewAdapterInvoice.MyViewHolder>{
    private static ArrayList<Transaction> mDataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvItem;
        TextView tvWeight;
        TextView tvPrice;
        TextView tvAmount;
        public MyViewHolder(View itemView){
            super(itemView);
            tvItem = (TextView) itemView.findViewById(R.id.tvItem);
            tvWeight = (TextView) itemView.findViewById(R.id.tvWeight);
            tvPrice = (TextView) itemView.findViewById(R.id.tvPrice);
            tvAmount = (TextView) itemView.findViewById(R.id.tvAmount);
            itemView.setOnClickListener(this);
        }

        public void onClick(View view){

        }
    }

    public RecycleViewAdapterInvoice(ArrayList<Transaction> myDataset){
        mDataset = myDataset;
    }

    public RecycleViewAdapterInvoice.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_detail_transaction, parent, false);
        RecycleViewAdapterInvoice.MyViewHolder myViewHolder = new RecycleViewAdapterInvoice.MyViewHolder(view);

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
}
