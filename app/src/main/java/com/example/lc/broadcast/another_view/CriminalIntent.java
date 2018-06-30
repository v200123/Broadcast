package com.example.lc.broadcast.another_view;

import android.support.v4.app.Fragment;

public class CriminalIntent extends SingleFragment {

    @Override
    protected Fragment createFragment() {
        return new Crime_Flagment();
    }
}
