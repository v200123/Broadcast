package com.example.lc.broadcast;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "lc.lc.study";
    private DrawerLayout mdrawerLayout;
    TestBroadcast testBroadcast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       android.support.v7.widget.Toolbar toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.lc.broadcast.intent.action.TestBroadcast");
        registerReceiver(testBroadcast = new TestBroadcast(), intentFilter);
        mdrawerLayout = findViewById(R.id.drawerlayout);
        NavigationView navView = (NavigationView) findViewById(R.id.nav_view);
        ActionBar actionBar = getSupportActionBar();
            if(actionBar != null)
            {
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setHomeAsUpIndicator(R.drawable.ic_dns_red_a700_18dp);
            }

        navView.setCheckedItem(R.id.nav_call);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                mdrawerLayout.closeDrawers();
                return true;
            }
        });
        findViewById(R.id.btn_Another).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,com.example.lc.broadcast.another_view.Another_Activity_Main.class);
                startActivity(i);
            }
        });
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {           //这是广播消息的按钮

            @Override
            public void onClick(View v) {
                sendBroadcast(new Intent("com.example.lc.broadcast.intent.action.TestBroadcast"));
            }
        });
        findViewById(R.id.btn_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//这是卡片视图的
                Intent i = new Intent(MainActivity.this,Thread_Test.class);
                startActivity(i);
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View v) {

                call();
//
            }
        });

        findViewById(R.id.btn_Switch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, View_List.class);
                startActivity(i);
            }
        });


        findViewById(R.id.btn_Load).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  i = new Intent(MainActivity.this,com.example.lc.broadcast.load.LearnLoad.class);
                startActivity(i);
            }
        });
        findViewById(R.id.btn_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Test_Service.class);
                startActivity(i);
            }
        });
    }


            private void call() {
                try {
                    Intent i = new Intent(Intent.ACTION_CALL);
                    i.setData(Uri.parse("tel:10086"));

                    startActivity(i);
                }
                catch (SecurityException e){
                    e.printStackTrace();
                }
            }

            public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
                switch (requestCode) {
                    case 1:
                        if (grantResults.length > 0 && grantResults[0] == PackageManager.
                                PERMISSION_GRANTED) {
                            call();
                        } else {
                            Toast.makeText(getApplicationContext(), "You denied the permission", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    default:
                }
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mdrawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.delete:
                Toast.makeText(this, "You clicked Delete", Toast.LENGTH_SHORT).
                        show();
                break;
            case R.id.settings:
                Toast.makeText(this, "You clicked Settings", Toast.LENGTH_SHORT).
                        show();
                break;
            default:
        }
        return true;
    }
}

