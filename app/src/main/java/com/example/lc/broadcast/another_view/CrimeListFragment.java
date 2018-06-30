package com.example.lc.broadcast.another_view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lc.broadcast.R;

import java.util.List;

public class CrimeListFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private CrimeHolder mAdapter;
    private List<Crime> mCrimeList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.crime_list_fragment,container,false);
        mRecyclerView = v.findViewById(R.id.Crime_List_RecycleView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        CrimeLab crimeLab = CrimeLab.get();
        mCrimeList =crimeLab.getCrimeList();
        mAdapter = new CrimeHolder(mCrimeList);
        mRecyclerView.setAdapter(mAdapter);
        return v;
    }
}
