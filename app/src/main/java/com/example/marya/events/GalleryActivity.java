package com.example.marya.events;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;

import com.bumptech.glide.Glide;

public class GalleryActivity extends AppCompatActivity {

    private static final String TAG = "GalleryActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_pop_up);
        Log.d(TAG, "onCreate: started.");
        getIncomingIntent();
    }

    private void getIncomingIntent() {
        Log.d(TAG, "getIncomingIntent: checking for incoming intent");

        if (getIntent().hasExtra("Title") && getIntent().hasExtra("Description") && getIntent().hasExtra("image_URL")) {
            Log.d(TAG, "getIncomingIntent: found intent extras.");

            String title = getIntent().getStringExtra("Title");
            String description = getIntent().getStringExtra("Description");
            String imageURL = getIntent().getStringExtra("image_URL");

            setImage(imageURL, title, description);
        }
    }

    private void setImage(String imageURL, String title, String description) {
        Log.d(TAG, "setImage: setting to image and name to widgets");

        TextView name = findViewById(R.id.Text);
        name.setText(title);

        TextView desc = findViewById(R.id.Description);
        desc.setText(description);


        ImageView image = findViewById(R.id.imageView);
        Glide.with(this)
                .asBitmap()
                .load(imageURL)
                .into(image);

    }

    public void buttonOnClick(View v) {
        Button button = (Button) v;
        ((Button) v).setText("Added to calendar");
    }

    public void buttonOnClick2(View v) {
        Button button = (Button) v;
        setContentView(R.layout.calendar);

    }


}


