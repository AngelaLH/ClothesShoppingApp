package com.example.clothesshopping;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static com.example.clothesshopping.DataProvider.*;

public class ListActivity extends AppCompatActivity implements ExampleAdapter.OnItemClickListener {
    public static final String EXTRA_URL = "imageUrl";
    public static final String EXTRA_CREATOR = "creatorName";
    public static final String EXTRA_LIKES = "likeCount";
    public static final String EXTRA_ORDERS = "orderCount";
    public static final String EXTRA_DESC = "desc";
    private RecyclerView mRecyclerView;
    private ExampleAdapter mExampleAdapter;
    private ArrayList<ClothingItem> ClothingList;
    //private RequestQueue mRequestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Intent intent = getIntent();
        String message = intent.getStringExtra("MessageFromMainActivity");
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //mExampleList = new ArrayList<>();
        //mRequestQueue = Volley.newRequestQueue(this);


        if (message.equals("Bottom")) {
            ClothingList = getBottoms();
        } else if (message.equals("Dress")) {
            ClothingList = getDresses();
        } else if (message.equals("Top")){
            ClothingList = getTops();
        } else if (message.equals("Top Picks")){
            ClothingList = getTopPicks();
        } else {
            ClothingList = getAll();
        }

        mExampleAdapter = new ExampleAdapter(ListActivity.this, ClothingList);
        mRecyclerView.setAdapter(mExampleAdapter);
        mExampleAdapter.setOnItemClickListener(ListActivity.this);

        //parseJSON();
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }
//    private void parseJSON() {
//        String url = "https://pixabay.com/api/?key=5303976-fd6581ad4ac165d1b75cc15b3&q=kitten&image_type=photo&pretty=true";
//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                            JSONArray jsonArray = response.getJSONArray("hits");
//                            for (int i = 0; i < jsonArray.length(); i++) {
//                                JSONObject hit = jsonArray.getJSONObject(i);
//                                String creatorName = hit.getString("user");
//                                String imageUrl = hit.getString("webformatURL");
//                                int likeCount = hit.getInt("likes");
//                                mExampleList.add(new ClothingItem(imageUrl, creatorName, String.valueOf(likeCount)));
//                            }
//                            mExampleAdapter = new ExampleAdapter(ListActivity.this, mExampleList);
//                            mRecyclerView.setAdapter(mExampleAdapter);
//                            mExampleAdapter.setOnItemClickListener(ListActivity.this);
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                error.printStackTrace();
//            }
//        });
//        mRequestQueue.add(request);
//    }
    @Override
    public void onItemClick(int position) {
        Intent detailIntent = new Intent(this, DetailActivity.class);
        ClothingItem clickedItem = ClothingList.get(position);
        detailIntent.putExtra(EXTRA_URL, clickedItem.getImagefilenames());
        detailIntent.putExtra(EXTRA_CREATOR, clickedItem.getClotheName());
        detailIntent.putExtra(EXTRA_LIKES, clickedItem.getPrice());
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