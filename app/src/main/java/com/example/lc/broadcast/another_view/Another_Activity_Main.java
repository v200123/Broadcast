package com.example.lc.broadcast.another_view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.lc.broadcast.R;

public class Another_Activity_Main extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.another_main_activity);
    findViewById(R.id.TextBrian).setOnClickListener(this);
    findViewById(R.id.Criminallntent).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
                switch (v.getId()){
                    case        R.id.TextBrian  :
                        Intent i = new Intent(Another_Activity_Main.this,Text_Brain.class);
                        startActivity(i);
                        break;
                    case R.id.Criminallntent :
                            Intent i1= new Intent(Another_Activity_Main.this,CrimeList.class);
                            startActivity(i1);
                            break;
                }
    }
}
