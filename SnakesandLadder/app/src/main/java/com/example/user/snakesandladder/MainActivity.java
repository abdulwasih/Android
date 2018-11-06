package com.example.user.snakesandladder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    int[] mydices= {
            R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four,
            R.drawable.five,
            R.drawable.six
    };

    public void rollTapped(View view)
    {
        Random ran= new Random();
        int randomnumber = ran.nextInt(6) + 1;

        ImageView dice =(ImageView) findViewById(R.id.dice);

        dice.setImageResource(mydices[randomnumber]);
    }







    @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
