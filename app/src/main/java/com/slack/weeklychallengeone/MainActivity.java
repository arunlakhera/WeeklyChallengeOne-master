package com.slack.weeklychallengeone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import com.slack.weeklychallengeone.Utils.Model;
import com.slack.weeklychallengeone.Utils.MyAdapter;

import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Model> mArrayList;
    private MyAdapter mAdapter;
    RecyclerView mRecyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        loadData();

    }


    private void initViews(){
        mRecyclerView = findViewById(R.id.recyler_view);
        mRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

    }

    private void loadData(){

        mArrayList = new ArrayList<>();

        mArrayList.add(new Model("Constraint Layout"));
        mArrayList.add(new Model("Linear Layout"));
        mArrayList.add(new Model("Relative Layout"));
        mArrayList.add(new Model("Card View"));
        mArrayList.add(new Model("Scroll Views"));
        mArrayList.add(new Model("Grid View"));


        mAdapter = new MyAdapter(mArrayList);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListner(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                String mTitle = mArrayList.get(position).getName();
                materialNameDescription(mTitle);

            }
        });

    }

    public void materialNameDescription(String mTitle) {

        Intent popIntent = new Intent(MainActivity.this,Pop.class);
        popIntent.putExtra("title",  String.valueOf(mTitle));
        startActivity(popIntent);


    }






}
