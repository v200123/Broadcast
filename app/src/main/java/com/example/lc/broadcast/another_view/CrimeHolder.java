package com.example.lc.broadcast.another_view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.lc.broadcast.R;

import java.util.List;

/**
 * 这个是Adpter的程序
 */
public class CrimeHolder extends RecyclerView.Adapter<CrimeHolder.ViewHolder>{
    private List<Crime> mCrimeList;
    private Context mContext;
    public CrimeHolder(List<Crime> crimeList) {
        mCrimeList = crimeList;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(mContext ==null)
        {
            mContext=parent.getContext();
        }
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
       View v =  layoutInflater.inflate(R.layout.crime_cycle_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Crime crime = mCrimeList.get(position);
            holder.mInformation.setText(crime.getTitle());
            holder.mCheckBox.setChecked(crime.getSolved());
    }

    @Override
    public int getItemCount() {
        return mCrimeList.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder  {
        TextView    mInformation,mDate;
        CheckBox    mCheckBox;
        public ViewHolder(View itemView) {
            super(itemView);
            mInformation = itemView.findViewById(R.id.Crime_Information);
            mDate = itemView.findViewById(R.id.Crime_Date);
            mCheckBox = itemView.findViewById(R.id.Crime_ensure_CheckBox);
        }


    }
}
