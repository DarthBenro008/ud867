package com.benrostudios.jokedisplayer;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class JokeDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);
        Intent rec = getIntent();
        String joke = rec.getStringExtra("joke");
        Log.d("hello","libactivity"+joke);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragContainer,JokeDisplayFragment.newInstance(joke)).commit();
    }
}
