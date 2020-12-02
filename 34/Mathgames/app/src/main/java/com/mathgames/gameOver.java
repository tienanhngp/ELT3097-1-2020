package com.mathgames;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.AdRequest;


public class gameOver extends Activity {
    int highscoreOrg;
    int newHighScore;
    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        TextView currentScore = findViewById(R.id.scoreView);
        TextView noofques = findViewById(R.id.highScoreView);
        Button playAgain = findViewById(R.id.tryAgainButton);
        TextView questionss = findViewById(R.id.questions);


        //ads code goes here
        // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
        MobileAds.initialize(this, "ca-app-pub-6819368301265177~3947722135");
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-6819368301265177/7540663383");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener()
                                      {
                                          @Override
                                          public void onAdClosed() {
                                              super.onAdClosed();
                                              startActivity(new Intent(getApplicationContext(), GameActivity.class));
                                              mInterstitialAd.loadAd(new AdRequest.Builder().build());
                                          }
                                      }


        );
        //


        //getting high-score from shared preferances and comparing it with new high-score
        SharedPreferences highScoresp = this.getSharedPreferences("com.buzzhipster.adityarajput.quickmaths_braintrainer" , Context.MODE_PRIVATE);
        highscoreOrg = highScoresp.getInt("highScore" , 0);
        //

        //getting score from intent

        int score = getIntent().getIntExtra("score" , 0);
        int questions = getIntent().getIntExtra("questions" , 0);
        int correct = getIntent().getIntExtra("correct" , 0);
        currentScore.setText("Your Score : " + Integer.toString(score));

        //setting highscore
        if(score > highscoreOrg) {
            highScoresp.edit().putInt("highScore", score).apply();
            highscoreOrg = score;
            noofques.setText("New High Score : " + highscoreOrg);
        }

        else
        {
            noofques.setText("High Score : " + highscoreOrg);
        }
        //

        questionss.setText("Correct :" + Integer.toString(correct));

    }
    public void playAgainm(View view) {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            startActivity(new Intent(getApplicationContext(), GameActivity.class));
        }
    }
    public void goHome(View view){
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
}
