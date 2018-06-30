package com.example.lc.broadcast.another_view;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.example.lc.broadcast.R;

/**
 * 这个是Crime_Flagment的Fragment的程序
 */
public class Crime_Flagment  extends Fragment {
    private Crime mCrime;
    private EditText CrimeText;
    private Button btn_Date;
    private CheckBox mCheckBox;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.crime_fragment,container,false);
        mCrime =new Crime();
        CrimeText = v.findViewById(R.id.CrimeInformation);
        btn_Date = v.findViewById(R.id.Date);
        mCheckBox = v.findViewById(R.id.Crime_CheckBox);
        CrimeText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mCrime.setTitle(s.toString());
            }
        });
        btn_Date.setText(mCrime.getDate());
        btn_Date.setEnabled(false);
        mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            mCrime.setSolved(isChecked);
            }
        });
        return v;
    }
}
