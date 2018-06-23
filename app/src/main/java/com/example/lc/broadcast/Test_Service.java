package com.example.lc.broadcast;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class Test_Service extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service);
        findViewById(R.id.btn_StopService).setOnClickListener(this);
        findViewById(R.id.btn_StartService).setOnClickListener(this);
        FloatingActionButton floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "只是一个测试", Snackbar.LENGTH_SHORT)
                        .setAction("Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(Test_Service.this, "Data restored",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this,MyService.class);
        switch (v.getId()){

            case R.id.btn_StartService :

                startService(i);
                break;
            case R.id.btn_StopService :

                stopService(i);
                break;
        }
    }
}
