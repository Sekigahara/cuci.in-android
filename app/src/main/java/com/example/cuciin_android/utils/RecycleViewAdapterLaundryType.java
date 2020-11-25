package com.example.cuciin_android.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.cuciin_android.R;
import com.example.cuciin_android.data.model.DataLaundryType;

import java.util.List;

public class RecycleViewAdapterLaundryType extends RecyclerView.Adapter<RecycleViewAdapterLaundryType.MyViewHolder>{
    private static List<DataLaundryType> mDataset;
    private static MyClickListener myClickListener;
    private static int[] amountItem;

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvLaundryTitle;
        TextView tvLaundryAmount;
        TextView tvLaundryDistance;
        TextView tvOperationalHoursText;
        TextView tvOperationalHours;
        TextView tvAmount;
        ImageButton ibLaundryButton;
        public MyViewHolder(View itemView){
            super(itemView);
            tvLaundryTitle = (TextView) itemView.findViewById(R.id.textViewTitleItem);
            tvLaundryAmount = (TextView) itemView.findViewById(R.id.textViewAmountItem);
            ibLaundryButton = (ImageButton) itemView.findViewById(R.id.imageButtonAddData);
            ibLaundryButton.setOnClickListener(this);
        }

        public void onClick(View view){
            int position = getAdapterPosition();
            myClickListener.onAddClick(position, view);
        }
    }

        public RecycleViewAdapterLaundryType(List<DataLaundryType> myDataset){
        mDataset = myDataset;
        amountItem = new int[myDataset.size()];
        setDefaultAmountData();
    }

    public RecycleViewAdapterLaundryType.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_order, parent, false);
        RecycleViewAdapterLaundryType.MyViewHolder myViewHolder = new RecycleViewAdapterLaundryType.MyViewHolder(view);

        return myViewHolder;
    }

    private void setDefaultAmountData() {
        for(int i = 0; i < mDataset.size(); i++)
            amountItem[i] = 0;
    }

    public void addAmount(int position) {
        amountItem[position]++;
    }

    public void onBindViewHolder(MyViewHolder holder, int position){
        holder.tvLaundryTitle.setText(mDataset.get(position).getName());
        holder.tvLaundryAmount.setText(amountItem[position]);
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
        public void onAddClick(int position, View view);
    }
}
