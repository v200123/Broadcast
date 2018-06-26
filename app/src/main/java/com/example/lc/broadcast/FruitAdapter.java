package com.example.lc.broadcast;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    public FruitAdapter(List<Fruit> fruitList) {
        this.fruitList = fruitList;
    }

    private List<Fruit> fruitList = new ArrayList<>();
    private Context mContext;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(mContext == null )
        {
            mContext = parent.getContext();
        }
        View v = LayoutInflater.from(mContext).inflate(R.layout.test_cardview,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Fruit fruit = fruitList.get(position);
            holder.fruitName.setText(fruit.getName());
            Glide.with(mContext).load(fruit.getImageId()).into(holder.fruitImage);
    }

    @Override
    public int getItemCount() {
        return fruitList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView fruitImage;
        TextView fruitName;
        public ViewHolder(View itemView) {
            super(itemView);
            cardView =(CardView)itemView;
            fruitImage = itemView.findViewById(R.id.fruit_image);
            fruitName = itemView.findViewById(R.id.fruit_name);
        }
    }
}
