package com.example.clothesshopping;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static com.example.clothesshopping.DataProvider.*;

public class ListActivity extends AppCompatActivity implements ExampleAdapter.OnItemClickListener {
    public static final String EXTRA_URL = "imageUrl";
    public static final String EXTRA_NAME = "Name";
    public static final String EXTRA_PRICE = "price";
    public static final String EXTRA_ORDERS = "orderCount";
    public static final String EXTRA_DESC = "desc";
    private RecyclerView mRecyclerView;
    private ExampleAdapter mExampleAdapter;
    private ArrayList<ClothingItem> ClothingList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Intent intent = getIntent();
        String message = intent.getStringExtra("MessageFromMainActivity");
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        if (message.equals("Bottom")) {
            ClothingList = getBottoms();
        } else if (message.equals("Dress")) {
            ClothingList = getDresses();
        } else if (message.equals("Top")){
            ClothingList = getTops();
        } else {
            ClothingList = getAll();
        }

        mExampleAdapter = new ExampleAdapter(ListActivity.this, ClothingList);
        mRecyclerView.setAdapter(mExampleAdapter);
        mExampleAdapter.setOnItemClickListener(ListActivity.this);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_foreground);
    }
    @Override
    public void onItemClick(int position) {
        Intent detailIntent = new Intent(this, DetailActivity.class);
        ClothingItem clickedItem = ClothingList.get(position);
        detailIntent.putExtra(EXTRA_URL, clickedItem.getImagefilenames());
        detailIntent.putExtra(EXTRA_NAME, clickedItem.getClothesName());
        detailIntent.putExtra(EXTRA_PRICE, clickedItem.getPrice());
        detailIntent.putExtra(EXTRA_ORDERS, clickedItem.getOrders());
        detailIntent.putExtra(EXTRA_DESC, clickedItem.getDesc());
        startActivity(detailIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView =
                (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mExampleAdapter.getFilter().filter(newText);
                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }

}