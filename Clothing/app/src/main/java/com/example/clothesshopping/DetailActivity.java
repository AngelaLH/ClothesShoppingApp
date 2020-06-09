package com.example.clothesshopping;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.squareup.picasso.Picasso;

import static com.example.clothesshopping.ListActivity.*;
public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();

        String imagefilename = intent.getStringExtra(EXTRA_URL);
        String clotheName = intent.getStringExtra(EXTRA_CREATOR);
        String price = intent.getStringExtra(EXTRA_LIKES);

        ImageView imageView = findViewById(R.id.image_view_detail);
        TextView textViewClotheName = findViewById(R.id.text_view_creator_detail);
        TextView textViewPrice = findViewById(R.id.text_view_like_detail);

        //Picasso.get().load(imageUrl).fit().centerInside().into(imageView);
        int i = getResources().getIdentifier(imagefilename, "drawable", getPackageName());
        imageView.setImageResource(i);
        textViewClotheName.setText(clotheName);
        textViewPrice.setText("Price: " + price);
    }


}