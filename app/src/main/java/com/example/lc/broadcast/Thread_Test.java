package com.example.lc.broadcast;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Thread_Test extends AppCompatActivity implements View.OnClickListener {
                private Fruit[] fruits = {new Fruit("Orange", R.mipmap.p21),
                        new Fruit("Watermelon",R.mipmap.p21),
                new Fruit("Pear", R.mipmap.p21), new Fruit("Grape", R.mipmap.picture),
                new Fruit("Pineapple", R.mipmap.p21),
                        new Fruit("Strawberry",R.mipmap.navigate),
                new Fruit("Cherry", R.mipmap.navigate), new Fruit("Mango", R.mipmap.navigate)};
                    private List<Fruit> fruitList= new ArrayList<>();
                    private FruitAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_cardview);
        initFruits();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.Fruit_RecycleView);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);

    }

    private void initFruits() {
        fruitList.clear();
        for (int i = 0 ;i<50;i++)
                {
                    Random random = new Random();
                    int index = random.nextInt(fruits.length);
                    fruitList.add(fruits[index]);
                }
    }

    @Override
    public void onClick(View v) {

    }
}
