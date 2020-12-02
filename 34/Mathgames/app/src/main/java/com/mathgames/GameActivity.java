package com.mathgames;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import java.util.ArrayList;
import java.util.Random;

    public class GameActivity extends Activity {
        //two variable one each for difficulty level and for time value
        int level;
        int time;
        //custom needed variables

        int difLevel = 50;
        int incre = 2;
        int decre = 1;
        ArrayList<Integer> options = new ArrayList<Integer>();
        int locationOfCorrectAnswer;
        int score = 0;
        int numberOfQuestions;
        int correctAnswers;
        Random rand;
        Button option1;
        Button option4;
        Button option3;
        Button option2;
        TextView questionView;

        TextView responseView;
        TextView pointsView;
        TextView timeView;


        public void playAgain(View view) {
            score = 0;
            numberOfQuestions = 0;
            correctAnswers = 0;
            responseView.setText("");
            timeView.setText("0s");
            pointsView.setText("0");
            option1.setVisibility(View.VISIBLE);
            option2.setVisibility(View.VISIBLE);
            option3.setVisibility(View.VISIBLE);
            option4.setVisibility(View.VISIBLE);
            int milli = 30100;

            //setting assignment of time
            if (time == 1) {
                milli = 30100;
            } else if (time == 2) {
                milli = 60100;
            }
            //over


            new CountDownTimer(milli, 1000) {


                @Override
                public void onTick(long millisUntilFinished) {
                    timeView.setText(String.valueOf(millisUntilFinished / 1000 + "s"));
                    responseView.setOnClickListener(null);

                }

                @Override
                public void onFinish() {
                    timeView.setText("Time Over");
                    responseView.setText("Finished");
                    option1.setVisibility(View.INVISIBLE);
                    option2.setVisibility(View.INVISIBLE);
                    option3.setVisibility(View.INVISIBLE);
                    option4.setVisibility(View.INVISIBLE);
                    questionView.setText("");
                    responseView.setText("Play Again");

                    responseView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            playAgain(findViewById(R.id.responseView));
                        }
                    });
                    Intent gameover = new Intent(getApplicationContext(), gameOver.class);
                    gameover.putExtra("score", score);
                    gameover.putExtra("questions", numberOfQuestions);
                    gameover.putExtra("correct", correctAnswers);
                    startActivity(gameover);

                }
            }.start();


        }

        public void generateQuestions() {

            //getting the code working for difficulty level
            if (level == 1) {
                difLevel = 50;
            } else if (level == 2) {
                difLevel = 1000;
                incre = 3;
                decre = 1;
            } else if (level == 3) {
                difLevel = 10000;
                incre = 4;
                decre = 2;
            }

            int a = rand.nextInt(difLevel + 1);
            int b = rand.nextInt(difLevel + 1);
            //declaring textview to display question
            questionView.setText(Integer.toString(a) + " + " + Integer.toString(b));
            pointsView.setText(Integer.toString(score));
            //making options to work
            locationOfCorrectAnswer = rand.nextInt(4);
            options.clear();
            int incorrectAnswer;
            for (int i = 0; i <= 3; i++) {
                if (i == locationOfCorrectAnswer) {
                    options.add(a + b);
                } else {
                    incorrectAnswer = rand.nextInt((difLevel * 2) + 1);
                    while (incorrectAnswer == a + b) {
                        incorrectAnswer = rand.nextInt((difLevel * 2) + 1);
                    }
                    options.add(incorrectAnswer);
                }

            }

            //setting text on buttons of options
            option1.setText(Integer.toString(options.get(0)));
            option2.setText(Integer.toString(options.get(1)));
            option3.setText(Integer.toString(options.get(2)));
            option4.setText(Integer.toString(options.get(3)));

        }


        //choosen option method
        public void chooseAnswer(View view) {
            if (view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))) {
                //correct Answer Code
                score = score + incre;
                correctAnswers++;
                responseView.setText("Correct Answer !");
            } else {
                //incorrect Answer code
                score = score - decre;
                responseView.setText("Incorrect Answer !");

            }
            numberOfQuestions++;

            long start = System.currentTimeMillis();
            long end = start + 250; // 60 seconds * 1000 ms/sec
            while (System.currentTimeMillis() < end) {
                // run
            }
            generateQuestions();
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.game);

            //getting data from intent into local variables
            level = getIntent().getIntExtra("LEVEL", 0);

            time = getIntent().getIntExtra("TIME", 1);

            rand = new Random();

            //declaring option fields
            option1 = findViewById(R.id.option1View);
            option2 = findViewById(R.id.option2View);
            option3 = findViewById(R.id.option3View);
            option4 = findViewById(R.id.option4View);
            responseView = findViewById(R.id.responseView);
            pointsView = findViewById(R.id.pointsView);
            timeView = findViewById(R.id.timeView);
            questionView = findViewById(R.id.questionView);
            generateQuestions();
            playAgain(findViewById(R.id.option1View));
            // declaring random variables to be operated
        }
    }

