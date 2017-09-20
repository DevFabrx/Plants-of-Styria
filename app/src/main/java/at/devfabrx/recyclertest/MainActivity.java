package at.devfabrx.recyclertest;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.util.AsyncListUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebScraper webScraper = new WebScraper();
        PlantsListQueryTask plantsListQueryTask = new PlantsListQueryTask();

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        new PlantsListQueryTask().execute();

    }

    public class PlantsListQueryTask extends AsyncTask<Void, Void, ArrayList<String>>{
        @Override
        protected ArrayList<String> doInBackground(Void... params) {
            WebScraper webScraper = new WebScraper();
            return webScraper.getPlantList();
        }

        @Override
        protected void onPostExecute(ArrayList<String> plantNames) {
            RecyclerAdapter recyclerAdapter = new RecyclerAdapter(plantNames);
            mRecyclerView.setAdapter(recyclerAdapter);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        }
    }




}
