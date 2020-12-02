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
    TextView Kid,Pro,Legend,basic30,advance,playbtn;
    int difficultLevel = 1;
    int timeSelect = 1;
    //on difficulty  level click method
    public void difficultyLevel(View view)
    {
        int choice =Integer.parseInt(view.getTag().toString());
        if(choice == 1)
        {
            Kid.setTextColor(Color.WHITE);
            Pro.setBackgroundColor(Color.TRANSPARENT);
            Pro.setTextColor(Color.TRANSPARENT);
            Legend.setBackgroundColor(Color.TRANSPARENT);
            Legend.setTextColor(Color.TRANSPARENT);
            difficultLevel = 1;
        }
        else if(choice == 2 )
        {
            Pro.setTextColor(Color.WHITE);
            Kid.setBackgroundColor(Color.TRANSPARENT);
            Kid.setTextColor(Color.TRANSPARENT);
            Legend.setBackgroundColor(Color.TRANSPARENT);
            Kid.setTextColor(Color.TRANSPARENT);
            difficultLevel = 2;
        }
        else if(choice == 3)
        {
            Legend.setTextColor(Color.WHITE);
            Pro.setBackgroundColor(Color.TRANSPARENT);
            Pro.setTextColor(Color.TRANSPARENT);
            Kid.setBackgroundColor(Color.TRANSPARENT);
            Kid.setTextColor(Color.TRANSPARENT);
            difficultLevel = 3;
        }

    }


    //time selection method

    public void timeSelect(View view)
    {
        int timeChoice = Integer.parseInt(view.getTag().toString());
        if(timeChoice == 11)
        {
            basic30.setTextColor(Color.WHITE);
            advance.setBackgroundColor(Color.TRANSPARENT);
            advance.setTextColor(Color.TRANSPARENT);
            timeSelect = 1;
        }
        else if(timeChoice == 12)
        {
            advance.setTextColor(Color.WHITE);
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
        Kid = findViewById(R.id.Kid);
        Pro = findViewById(R.id.Pro);
        Legend = findViewById(R.id.Legend);
        basic30 = findViewById(R.id.basic30);
        advance = findViewById(R.id.advance);
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
