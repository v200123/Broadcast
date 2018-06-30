package com.example.lc.broadcast.another_view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.lc.broadcast.R;

public  abstract class SingleFragment extends AppCompatActivity {
    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.Fragment_contain);
        if(fragment==null)
        {
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.Fragment_contain,fragment)
                    .commit();
        }

    }
}
