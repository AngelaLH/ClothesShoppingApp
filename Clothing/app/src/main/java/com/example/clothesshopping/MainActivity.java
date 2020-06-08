package com.example.clothesshopping;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CardView catergoryCardView = (CardView) findViewById(R.id.card_view_category);
        catergoryCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(getBaseContext(), ListActivity.class);
                numbersIntent.putExtra("MessageFromMainActivity", "This message came from Main Activity");
                startActivity(numbersIntent);
            }
        });
    }


}