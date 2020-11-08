package com.example.maichel.soundtrack;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class CountingGame extends AppCompatActivity {

    private LinearLayout numbersHolder;
    private Button btnOne, btnTwo, btnThree, btnFour;
    private TextView txtFirst, txtSecond, txtThird, txtFourth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counting_game);

        numbersHolder = findViewById(R.id.num_holder);
        btnOne = findViewById(R.id.btn_one);
        btnTwo = findViewById(R.id.btn_two);
        btnThree = findViewById(R.id.btn_three);
        btnFour = findViewById(R.id.btn_four);
        txtFirst = findViewById(R.id.first_txt);
        txtSecond = findViewById(R.id.second_txt);
        txtThird = findViewById(R.id.third_txt);
        txtFourth = findViewById(R.id.fourth_txt);

        final MediaPlayer countingSound = MediaPlayer.create(this, R.raw.counting);
        countingSound.start();
        countingSound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                numbersHolder.setVisibility(View.VISIBLE);
                if (MainActivity.changeFormula == true) {
                    firstFormula();
                } else {
                    secondFormula();
                }
            }
        });
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int btnText = Integer.valueOf(btnOne.getText().toString());
                randomize(btnText);
            }
        });
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int btnText = Integer.valueOf(btnTwo.getText().toString());
                randomize(btnText);
            }
        });
        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int btnText = Integer.valueOf(btnThree.getText().toString());
                randomize(btnText);
            }
        });
        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int btnText = Integer.valueOf(btnFour.getText().toString());
                randomize(btnText);
            }
        });
    }

    private void firstFormula() {
        btnOne.setText(R.string.three);
        btnTwo.setText(R.string.one);
        btnThree.setText(R.string.four);
        btnFour.setText(R.string.two);
        MainActivity.changeFormula = false;
    }

    private void secondFormula() {
        btnOne.setText(R.string.two);
        btnTwo.setText(R.string.three);
        btnThree.setText(R.string.four);
        btnFour.setText(R.string.one);
        MainActivity.changeFormula = true;
    }

    private void randomize(int btnText) {
        String firstSlot = txtFirst.getText().toString();
        String secondSlot = txtSecond.getText().toString();
        String thirdSlot = txtThird.getText().toString();
        String fourthSlot = txtFourth.getText().toString();
        if(firstSlot.equals("-")) {
            if(btnText==4) {
                txtFirst.setText(String.valueOf(btnText));
            } else {
                Toast.makeText(CountingGame.this, "wrong choice please try again", Toast.LENGTH_LONG).show();
            }
        } else if(secondSlot.equals("-")) {
            if((btnText+1)==Integer.valueOf(firstSlot)) {
                txtSecond.setText(String.valueOf(btnText));
            } else {
                Toast.makeText(CountingGame.this, "wrong choice please try again", Toast.LENGTH_LONG).show();
            }
        } else if(thirdSlot.equals("-")) {
            if((btnText+1)==Integer.valueOf(secondSlot)) {
                txtThird.setText(String.valueOf(btnText));
            } else {
                Toast.makeText(CountingGame.this, "wrong choice please try again", Toast.LENGTH_LONG).show();
            }
        } else if(fourthSlot.equals("-")) {
            if((btnText+1)==Integer.valueOf(thirdSlot)) {
                txtFourth.setText(String.valueOf(btnText));
            } else {
                Toast.makeText(CountingGame.this, "wrong choice please try again", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(CountingGame.this, "wrong choice please try again", Toast.LENGTH_LONG).show();
        }
    }
}
