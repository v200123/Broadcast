package com.example.lc.broadcast;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainLogin extends AppCompatActivity implements View.OnClickListener {
    EditText User_Name,User_Passcode,change_Name,change_Passcode;
    String mUser_name,mUser_Passcode;
    Button btn_login,btn_change,btn_changed;
    CheckBox remember;
    
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_view);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        User_Name = findViewById(R.id.Login_UserName);
        User_Passcode = findViewById(R.id.Login_Passcode);
        btn_login = findViewById(R.id.btn_login_in);
        change_Name = findViewById(R.id.Changed_User_Name);
        change_Passcode = findViewById(R.id.Changed_User_Passcode);
        btn_change = findViewById(R.id.change_passcode);
        btn_changed = findViewById(R.id.Ensure_Changed);
        mUser_name = pref.getString("Own_Name","v200123");
        mUser_Passcode= pref.getString("Own_Passcode","123456");
        btn_change.setOnClickListener(this);
        btn_changed.setOnClickListener(this);
        btn_login.setOnClickListener(this);

        remember =findViewById(R.id.ChoiceRemember);
        boolean isRemember = pref.getBoolean("remember_password", false);
            if(isRemember)
        {
            String account = pref.getString("account", "");
            String password = pref.getString("password", "");

            User_Name.setText(account);
            User_Passcode.setText(password);
            remember.setChecked(true);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_login_in :
                mUser_name = pref.getString("Own_Name","v200123");
                mUser_Passcode= pref.getString("Own_Passcode","123456");
                String Name = User_Name.getText().toString();
                String Passcode = User_Passcode.getText().toString();
                if(Name.equals(mUser_name)&&Passcode.equals(mUser_Passcode))
                {editor = pref.edit();
                    if (remember.isChecked()) { // 检查复选框是否被选中
                        editor.putBoolean("remember_password", true);
                        editor.putString("account", Name);
                        editor.putString("password", Passcode);
                    } else {
                        editor.clear();
                    }
                    Intent i  =new Intent(MainLogin.this,MainActivity.class);
                    startActivity(i);

                    editor.apply();
                }
                else
                {
                    Toast.makeText(this,"用户名或者密码错误",Toast.LENGTH_SHORT).show();
                    User_Name.setText("");
                    User_Passcode.setText("");
                }
                break;
            case R.id.change_passcode:
                change_Name.setVisibility(View.VISIBLE);
                change_Passcode.setVisibility(View.VISIBLE);
                btn_changed.setVisibility(View.VISIBLE);
                break;
            case R.id.Ensure_Changed :
                String NewName,NewPasscode;
                editor = pref.edit();
                NewName = change_Name.getText().toString();
                NewPasscode= change_Passcode.getText().toString();
                if(NewName.equals("")&&NewPasscode.equals(""))
                {
                    change_Name.setVisibility(View.GONE);
                    change_Passcode.setVisibility(View.GONE);
                    btn_changed.setVisibility(View.GONE);
                    Toast.makeText(getApplicationContext(),"你没有修改密码",Toast.LENGTH_SHORT).show();
                }
                else {
                    if(!NewName.equals("")){
                editor.putString("Own_Name",NewName);}
                    if(!NewPasscode.equals("")){
                editor.putString("Own_Passcode",NewPasscode);}
                    editor.apply();
                    change_Name.setVisibility(View.GONE);
                    change_Passcode.setVisibility(View.GONE);
                    btn_changed.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(),"你修改了密码",Toast.LENGTH_SHORT).show();
                    change_Name.setText("");
                    change_Passcode.setText("");}
        }
    }
}
