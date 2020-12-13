//package com.example.cuciin_android.utils;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.ImageButton;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.cuciin_android.R;
//import com.example.cuciin_android.data.model.DataLaundryType;
//import com.example.cuciin_android.data.model.DataOutletObj;
//import com.example.cuciin_android.data.model.LaundryType;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class RecycleViewOrder extends RecyclerView.Adapter<RecycleViewOrder.MyViewHolder>{
//    private static List<DataLaundryType> mDataset;
//    private static MyClickListener myClickListener;
//    int[] amountItem;
//
//    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
//        ImageView ivLaundryTypePhoto;
//        TextView tvLaundryTypeName;
//        TextView tvLaundryTypeDescrition;
//        TextView tvLaundryTypePrice;
//        TextView tvAmountItem;
//        ImageButton btnAddItem;
//
//        public MyViewHolder(View itemView){
//            super(itemView);
//            ivLaundryTypePhoto = (ImageView) itemView.findViewById(R.id.ivLaundryPhoto);
//            tvLaundryTypeName = (TextView) itemView.findViewById(R.id.textViewTitleItem);
//            tvLaundryTypeDescrition=  (TextView) itemView.findViewById(R.id.textViewDescriptionItem);
//            tvLaundryTypePrice = (TextView) itemView.findViewById(R.id.textViewPrice);
//            tvAmountItem = (TextView) itemView.findViewById(R.id.textViewAmountItem);
//            btnAddItem = (ImageButton) itemView.findViewById(R.id.imageButtonAddData);
//            //itemView.setOnClickListener(this);
//        }
//
//        public void onClick(View view){
//            btnAddItem.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    int position = getAdapterPosition();
//                    myClickListener.onItemClick(position, v);
//                }
//            });
//        }
//    }
//
//    public RecycleViewOrder(List<DataLaundryType> myDataset){
//        mDataset = myDataset;
//        setDataIndex();
//    }
//
//    public RecycleViewOrder.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_nearby_list, parent, false);
//        MyViewHolder myViewHolder = new MyViewHolder(view);
//
//        return myViewHolder;
//    }
//
//    public void onBindViewHolder(MyViewHolder holder, int position){
//        holder.tvLaundryTypeName.setText(mDataset.get(position).getName());
//        holder.tvAmountItem.setText(String.valueOf(amountItem));
//    }
//
//    public void setDataIndex() {
//        amountItem = new int[getItemCount()];
//        for(int i = 0; i < getItemCount(); i++)
//            amountItem[i] = 0;
//    }
//
//    public int getItemCount() {
//        return mDataset.size();
//    }
//
//    public void setOnItemClickListener(MyClickListener myClickListener){
//        this.myClickListener = myClickListener;
//    }
//
//    public void tambahItem(int position){}
//
//    public interface MyClickListener{
//        public void onItemClick(int position, View view);
//    }
//}
