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
        stockList.add("台　泥 (1101)");
        stockList.add("亞　泥 (1102)");
        stockList.add("統　一 (1216)");
        stockList.add("台　塑 (1301)");
        stockList.add("南　亞 (1303)");
        stockList.add("台　化 (1326)");
        stockList.add("遠東新 (1402)");
        stockList.add("中　鋼 (2002)");
        stockList.add("正　新 (2105)");
        stockList.add("和泰車 (2207)");
        stockList.add("裕日車 (2227)");
        stockList.add("光寶科 (2301)");
        stockList.add("聯　電 (2303)");
        stockList.add("台達電 (2308)");
        stockList.add("鴻　海 (2317)");
        stockList.add("國　巨 (2327)");
        stockList.add("台積電 (2330)");
        stockList.add("佳世達 (2352)");
        stockList.add("華　碩 (2357)");
        stockList.add("廣　達 (2382)");
        stockList.add("研　華 (2395)");

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
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}