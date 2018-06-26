package com.example.lc.broadcast.another_view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lc.broadcast.R;

import java.util.ArrayList;
import java.util.List;

public class Text_Brain extends AppCompatActivity implements  View.OnClickListener {
    private TextView mTextView;
    private final String key_index="com.lc.study.save";
    private Button btn_Right,btn_Wrong;
    private int index = 0;
    private List<issue_collection> mCollectionList = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_brain);
        if(savedInstanceState!=null)
        {
                    index = savedInstanceState.getInt(key_index,0);
        }
        issue_items issue_items =  new issue_items(mCollectionList);
        mCollectionList = issue_items.getList();

        btn_Right= findViewById(R.id.ChoiceRight);
        mTextView = findViewById(R.id.Question);
        btn_Wrong = findViewById(R.id.ChoiceWrong);
        btn_Right.setOnClickListener(this);
        btn_Wrong.setOnClickListener(this);
        UpdateUI();
    }
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.ChoiceRight:
                if(mCollectionList.get(index).getAnswer().equals(true)){
                    Toast.makeText(getApplicationContext(),"回答正确",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"回答错误",Toast.LENGTH_SHORT).show();
                }
                index = (index + 1) % mCollectionList.size();
                UpdateUI();
                break;
            case R.id.ChoiceWrong:
                if(!mCollectionList.get(index).getAnswer().equals(true)){
                    Toast.makeText(getApplicationContext(),"回答正确",Toast.LENGTH_SHORT).show();
                }
                else {
            Toast.makeText(getApplicationContext(),"回答错误",Toast.LENGTH_SHORT).show();
        }
        index = (index + 1) % mCollectionList.size();
        UpdateUI();
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(key_index, index);
    }

    private void  UpdateUI(){
        String question = mCollectionList.get(index).getIssue_number()+"          ："+mCollectionList.get(index).getQuestion();
        mTextView.setText(question);
    }

}
