package com.mathgames;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class gameSetting extends Activity {
    TextView Easy,Medium,Hard,basic30,advance60,playbtn;
    int difficultLevel = 1;
    int timeSelect = 1;
    //on difficulty  level click method
    public void difficultyLevel(View view)
    {
        int choice =Integer.parseInt(view.getTag().toString());
        if(choice == 1)
        {
            Easy.setTextColor(Color.BLACK);
            Medium.setBackgroundColor(Color.TRANSPARENT);
            Medium.setTextColor(Color.TRANSPARENT);
            Hard.setBackgroundColor(Color.TRANSPARENT);
            Hard.setTextColor(Color.TRANSPARENT);
            difficultLevel = 1;
        }
        else if(choice == 2 )
        {
            Medium.setTextColor(Color.BLACK);
            Easy.setBackgroundColor(Color.TRANSPARENT);
            Easy.setTextColor(Color.TRANSPARENT);
            Hard.setBackgroundColor(Color.TRANSPARENT);
            Hard.setTextColor(Color.TRANSPARENT);
            difficultLevel = 2;
        }
        else if(choice == 3)
        {
            Hard.setTextColor(Color.BLACK);
            Medium.setBackgroundColor(Color.TRANSPARENT);
            Medium.setTextColor(Color.TRANSPARENT);
            Easy.setBackgroundColor(Color.TRANSPARENT);
            Easy.setTextColor(Color.TRANSPARENT);
            difficultLevel = 3;
        }

    }


    //time selection method

    public void timeSelect(View view)
    {
        int timeChoice = Integer.parseInt(view.getTag().toString());
        if(timeChoice == 11)
        {
            basic30.setTextColor(Color.BLACK);
            advance60.setBackgroundColor(Color.TRANSPARENT);
            advance60.setTextColor(Color.TRANSPARENT);
            timeSelect = 1;
        }
        else if(timeChoice == 12)
        {
            advance60.setTextColor(Color.BLACK);
            basic30.setTextColor(Color.TRANSPARENT);
            basic30.setBackgroundColor(Color.TRANSPARENT);
            timeSelect = 2;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_setting);

        //linking xml layouts to java
        Easy = findViewById(R.id.Easy);
        Medium = findViewById(R.id.Medium);
        Hard = findViewById(R.id.Hard);
        basic30 = findViewById(R.id.basic30);
        advance60 = findViewById(R.id.advance60);
        playbtn = findViewById(R.id.playbtn);


        //onclick listner on playbtn to go to second activity sending two variables with intent

        playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent =  new Intent(gameSetting.this, GameActivity.class);
                myintent.putExtra("LEVEL",difficultLevel);
                myintent.putExtra("TIME" , timeSelect);
                startActivity(myintent);
            }
        });



    }
}
