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
    EditText User_Name,User_Passcode;
    Button btn_login;
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
                String Name = User_Name.getText().toString();
                String Passcode = User_Passcode.getText().toString();
                if(Name.equals("v200123")&&Passcode.equals("123456"))
                {editor = pref.edit();
                    if (remember.isChecked()) { // 检查复选框是否被选中
                        editor.putBoolean("remember_password", true);
                        editor.putString("account", Name);
                        editor.putString("password", Passcode);
                    } else {
                        editor.clear();}
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
        }
    }
}
