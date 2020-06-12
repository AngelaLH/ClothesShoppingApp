package com.example.clothesshopping;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static com.example.clothesshopping.DataProvider.getTopPicks;


public class MainActivity extends AppCompatActivity implements TopPicks_Adapter.OnItemClickListener {
    private RecyclerView mHorizontalRecyclerView;
    private TopPicks_Adapter mTopPicksAdapter;
    private ArrayList<ClothingItem> TopPicks;
    public static final String EXTRA_URL = "imageUrl";
    public static final String EXTRA_CREATOR = "creatorName";
    public static final String EXTRA_LIKES = "likeCount";
    public static final String EXTRA_ORDERS = "orderCount";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        TopPicks = getTopPicks();
        mHorizontalRecyclerView = findViewById(R.id.horizontal_recycler_view);
        //mHorizontalRecyclerView.setHasFixedSize(true);
        mHorizontalRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mTopPicksAdapter = new TopPicks_Adapter(MainActivity.this, TopPicks);
        mHorizontalRecyclerView.setAdapter(mTopPicksAdapter);

        mTopPicksAdapter.setOnItemClickListener((TopPicks_Adapter.OnItemClickListener) MainActivity.this);


        CardView catergoryCardView = (CardView) findViewById(R.id.card_view_category);
        CardView catergoryCardView2 = (CardView) findViewById(R.id.card_view_category2);
        CardView catergoryCardView3 = (CardView) findViewById(R.id.card_view_category3);
        CardView catergoryCardView4 = (CardView) findViewById(R.id.card_view_category4);
        //CardView catergoryCardView5 = (CardView) findViewById(R.id.card_view_category5);
        catergoryCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent BottomIntent = new Intent(getBaseContext(), ListActivity.class);
                BottomIntent.putExtra("MessageFromMainActivity", "Bottom");
                startActivity(BottomIntent);
            }
        });
        catergoryCardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(getBaseContext(), ListActivity.class);
                numbersIntent.putExtra("MessageFromMainActivity", "Dress");
                startActivity(numbersIntent);
            }
        });
        catergoryCardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(getBaseContext(), ListActivity.class);
                numbersIntent.putExtra("MessageFromMainActivity", "Top");
                startActivity(numbersIntent);
            }
        });
        catergoryCardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(getBaseContext(), ListActivity.class);
                numbersIntent.putExtra("MessageFromMainActivity", "Search All");
                startActivity(numbersIntent);
            }
        });
//        catergoryCardView5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent numbersIntent = new Intent(getBaseContext(), ListActivity.class);
//                numbersIntent.putExtra("MessageFromMainActivity", "Top Picks");
//                startActivity(numbersIntent);
//            }
//        });

    }


    @Override
    public void onItemClick(int position) {
        Intent detailIntent = new Intent(this, DetailActivity.class);
        ClothingItem clickedItem = TopPicks.get(position);
        detailIntent.putExtra(EXTRA_URL, clickedItem.getImagefilenames());
        detailIntent.putExtra(EXTRA_CREATOR, clickedItem.getClotheName());
        detailIntent.putExtra(EXTRA_LIKES, clickedItem.getPrice());
        detailIntent.putExtra(EXTRA_ORDERS, clickedItem.getOrders());
        startActivity(detailIntent);
    }
}