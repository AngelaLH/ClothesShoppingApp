package com.example.clothesshopping;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import static com.example.clothesshopping.ListActivity.*;
public class DetailActivity extends AppCompatActivity {
    CarouselView carouselView;
    String[] sampleImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();

        sampleImages = intent.getStringArrayExtra(EXTRA_URL);
        String clotheName = intent.getStringExtra(EXTRA_CREATOR);
        String price = intent.getStringExtra(EXTRA_LIKES);

        TextView textViewClotheName = findViewById(R.id.text_view_creator_detail);
        TextView textViewPrice = findViewById(R.id.text_view_like_detail);

        //Picasso.get().load(imageUrl).fit().centerInside().into(imageView);
        textViewClotheName.setText(clotheName);
        textViewPrice.setText("Price: " + price);

        carouselView = findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            int i = getResources().getIdentifier(sampleImages[position], "drawable", getPackageName());
            imageView.setImageResource(i);
        }
    };

}