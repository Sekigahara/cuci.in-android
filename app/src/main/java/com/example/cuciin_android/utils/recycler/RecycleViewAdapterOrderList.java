package com.example.cuciin_android.utils.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.cuciin_android.R;

import java.util.ArrayList;
import com.example.cuciin_android.data.model.transaction.PackedTransaction;

public class RecycleViewAdapterOrderList extends RecyclerView.Adapter<RecycleViewAdapterOrderList.MyViewHolder>{
    private static ArrayList<PackedTransaction> mDataset;
    private static RecycleViewAdapterOrderList.MyClickListener myClickListener;

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvOrderNumber;
        TextView tvLaundryName;
        TextView tvStatus;
        TextView tvPrice;

        public MyViewHolder(View itemView){
            super(itemView);
            tvOrderNumber = (TextView) itemView.findViewById(R.id.textView_OrderNumber);
            tvLaundryName = (TextView) itemView.findViewById(R.id.textView_Laundry_name_Order_List);
            tvStatus = (TextView) itemView.findViewById(R.id.textView_Status);
            tvPrice = (TextView) itemView.findViewById(R.id.textView_total_price_order_list);
            itemView.setOnClickListener(this);
        }

        public void onClick(View view){
            int position = getAdapterPosition();
            myClickListener.onItemClick(position, view);
        }
    }

    public RecycleViewAdapterOrderList(ArrayList<PackedTransaction> myDataset){
        mDataset = myDataset;
    }

    public RecycleViewAdapterOrderList.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_order_list, parent, false);
        RecycleViewAdapterOrderList.MyViewHolder myViewHolder = new RecycleViewAdapterOrderList.MyViewHolder(view);

        return myViewHolder;
    }

    public void onBindViewHolder(RecycleViewAdapterOrderList.MyViewHolder holder, int position){
        if(mDataset.get(position).getName() == null)
            holder.tvLaundryName.setText("Undefined Name");
        else
            holder.tvLaundryName.setText(mDataset.get(position).getName());

        if(mDataset.get(position).getPONumber() == null)
            holder.tvLaundryName.setText("Undefined PO");
        else
            holder.tvOrderNumber.setText(mDataset.get(position).getPONumber());


        Double price = mDataset.get(position).getPrice();
        String status = mDataset.get(position).getStatus();

        if(price == null)
            price = 0.0;
        if(status == null)
            status = "On Process";

        holder.tvPrice.setText("Rp. " + price.toString());
        holder.tvStatus.setText(status);

        //holder.ivListImage.setImageResource(mDataset.get(position).getImage());
        //holder.tvTitle.setText(mDataset.get(position).getTitle());
        //holder.tvDescription.setText(mDataset.get(position).getDescription());
    }

    public int getItemCount(){
        return mDataset.size();
    }

    public void setOnItemClickListener(RecycleViewAdapterOrderList.MyClickListener myClickListener){
        this.myClickListener = myClickListener;
    }

    public interface MyClickListener{
        public void onItemClick(int position, View view);
    }
}
