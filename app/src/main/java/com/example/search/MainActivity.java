package com.example.search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;

    List<String> stockList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stockList = new ArrayList<String>();


        recyclerView = findViewById(R.id.recycleView);
        recyclerAdapter = new RecyclerAdapter(stockList);

        //待補充
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(recyclerAdapter);

        //item細線分隔
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        //位置邏輯待釐清
        stockList.add("1101TN");
        stockList.add("1102YN");
        stockList.add("1216TY");
        stockList.add("1301TS");
        stockList.add("1303NY");
        stockList.add("1326TH");
        stockList.add("1402UDS");
        stockList.add("2002CK");
        stockList.add("2105CS");
        stockList.add("2207HT");
        stockList.add("2227UZ");
        stockList.add("2301BG");
        stockList.add("2303LD");
        stockList.add("2308TD");
        stockList.add("2317HH");
        stockList.add("2327GG");
        stockList.add("2330TGD");
        stockList.add("2352GSD");
        stockList.add("2357HS");
        stockList.add("2382GD");
        stockList.add("2395YH");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        androidx.appcompat.widget.SearchView searchView= (androidx.appcompat.widget.SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                recyclerAdapter.getFilter().filter(newText);

                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}