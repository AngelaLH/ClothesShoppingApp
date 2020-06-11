package com.example.clothesshopping;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CardView catergoryCardView = (CardView) findViewById(R.id.card_view_category);
        CardView catergoryCardView2 = (CardView) findViewById(R.id.card_view_category2);
        CardView catergoryCardView3 = (CardView) findViewById(R.id.card_view_category3);
        CardView catergoryCardView4 = (CardView) findViewById(R.id.card_view_category4);
        CardView catergoryCardView5 = (CardView) findViewById(R.id.card_view_category5);
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
        catergoryCardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(getBaseContext(), ListActivity.class);
                numbersIntent.putExtra("MessageFromMainActivity", "Top Picks");
                startActivity(numbersIntent);
            }
        });
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }


}