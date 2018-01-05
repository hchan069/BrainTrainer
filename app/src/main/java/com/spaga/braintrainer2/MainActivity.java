package com.spaga.braintrainer2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button startButton;
    ArrayList<Integer> answerArray = new ArrayList<>();
    int locationOfCorrectAns;

    public void chooseAnswer(View view) {

    }

    public void startButton(View view) {
        startButton.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.startButton);
        TextView sumTextView = findViewById(R.id.sumTextView);
        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);

        Random rand = new Random();

        int a = rand.nextInt(25);
        int b = rand.nextInt(25);

        sumTextView.setText(Integer.toString(a) + " + " + Integer.toString(b));

        locationOfCorrectAns = rand.nextInt(4);

        int incorrectAns;

        for (int i = 0; i < 4; i++) {
            if (i == locationOfCorrectAns)
                answerArray.add(a + b);
            else {
                incorrectAns = rand.nextInt(51);
                while (incorrectAns == a + b)
                    incorrectAns = rand.nextInt(51);
                answerArray.add(incorrectAns);
            }
        }

        button0.setText(Integer.toString(answerArray.get(0)));
        button1.setText(Integer.toString(answerArray.get(1)));
        button2.setText(Integer.toString(answerArray.get(2)));
        button3.setText(Integer.toString(answerArray.get(3)));
    }
}
