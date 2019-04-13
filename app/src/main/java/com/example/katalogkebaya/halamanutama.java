package com.example.katalogkebaya;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.support.v7.app.AppCompatActivity;

public class halamanutama extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halamanutama);
    }

    public void opendaftarkebaya(View view) {
        Log.d(LOG_TAG, "Button clicked");
        Intent intent = new Intent(this, daftarkatalogkebaya.class);
        startActivity(intent);
    }

    public void openabout(View view) {
        Intent intent = new Intent(halamanutama.this, about.class);
        startActivity(intent);
    }
}
