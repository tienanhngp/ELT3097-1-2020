package com.mathgames;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity{
    Button playButton;
    int highScore1;
    TextView highScoreDisplay;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        highScoreDisplay = findViewById(R.id.highScore);
        //actual game code
        playButton = findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , gameSetting.class);
                startActivity(intent);
                playButton.setBackgroundColor(R.drawable.batman);
            }
        });

        //shared prefrances to save game high score

        SharedPreferences highScoresp = this.getSharedPreferences("com.buzzhipster.adityarajput.quickmaths_braintrainer" , Context.MODE_PRIVATE);
        highScore1 = highScoresp.getInt("highScore", 0);

        highScoreDisplay.setText("High Score : " + Integer.toString(highScore1));
    }

    @Override
    protected void onResume() {
        super.onResume();
        playButton.setBackgroundColor(Color.TRANSPARENT);

    }
}
