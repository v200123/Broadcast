package com.example.lc.broadcast.load;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lc.broadcast.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LearnLoad extends AppCompatActivity implements View.OnClickListener {
    private EditText Input;
    private TextView Display;
    private Button btn_Loadin;
    String outputText;
    String input;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.load_test);
        Input = findViewById(R.id.load_EditText);
        Display = findViewById(R.id.load_display);
       btn_Loadin = findViewById(R.id.btn_load);
       btn_Loadin.setOnClickListener(this);
       outputText = load();
       if(!TextUtils.isEmpty(outputText))
       {
           Display.setText(outputText);
           Toast.makeText(this,"成功读入",Toast.LENGTH_SHORT).show();
       }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        input = Input.getText().toString();
        save(input);

        outputText = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_load :
                input = Input.getText().toString();
            save(input);
                outputText = load();
                if(!TextUtils.isEmpty(outputText))
                {
                    Display.setText(input);
                    Toast.makeText(this,"成功读入",Toast.LENGTH_SHORT).show();
                }
        }
    }

    private void save (String input)  {
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try {
            out = openFileOutput("data", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(input);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(writer!=null){
                    writer.close();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String load(){
        FileInputStream in = null;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();
        try {
            in = openFileInput("data");
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return content.toString();
    }
}
