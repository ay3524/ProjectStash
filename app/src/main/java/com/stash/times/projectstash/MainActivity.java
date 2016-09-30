package com.stash.times.projectstash;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Model m;
    ArrayList<Model> modelArrayList;
    CustomList adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        m = new Model(MainActivity.this);
        modelArrayList = m.getData();
        adapter = new CustomList(modelArrayList,this);

        listView = (ListView)findViewById(R.id.listview);
        listView.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m.setText("Item");
                Drawable d = getResources().getDrawable(R.mipmap.ic_launcher);
                m.setImage(d);
                modelArrayList.add(0,m);

                adapter.notifyDataSetChanged();
                listView.setAdapter(adapter);
            }
        });
    }
}
