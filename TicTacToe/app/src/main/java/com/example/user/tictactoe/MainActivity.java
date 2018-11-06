package com.example.user.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    int myActivePlayer =0;
    int[] myGameState = {2,2,2,2,2,2,2,2,2};



    public void imageTapped(View view)
    {
        ImageView myTapped = (ImageView) view;
        int tappedImageTag =Integer.parseInt(myTapped.getTag().toString());

        if(myGameState[tappedImageTag]==2) {
            myGameState[tappedImageTag]=myActivePlayer;

            if (myActivePlayer == 0) {
                myTapped.setImageResource(R.drawable.cross);
                myTapped.animate().rotation(360).setDuration(1000);
                myActivePlayer = 1;

            } else {
                myTapped.setImageResource(R.drawable.circle);
                myTapped.animate().rotation(360).setDuration(1000);
                myActivePlayer = 0;

            }
        }
        else
        {

        }

    }
    public void playAgain(View view)
    {
        for (int i=0;i<myGameState.length;i++)
        {
            myGameState[i]=2;
        }

        myActivePlayer=0;

        LinearLayout linearLayout =(LinearLayout) findViewById(R.id.lineone);
        for(int i=0; i< linearLayout.getChildCount();i++)
        {
            ((ImageView) linearLayout.getChildAt(i)).setImageResource(R.mipmap.ic_launcher_round);

        }

        LinearLayout linearLayoutOne =(LinearLayout) findViewById(R.id.linetwo);
        for(int i=0; i< linearLayoutOne.getChildCount();i++)
        {
            ((ImageView) linearLayoutOne.getChildAt(i)).setImageResource(R.mipmap.ic_launcher_round);

        }


        LinearLayout linearLayoutTwo =(LinearLayout) findViewById(R.id.linethree);
        for(int i=0; i< linearLayoutTwo.getChildCount();i++)
        {
            ((ImageView) linearLayoutTwo.getChildAt(i)).setImageResource(R.mipmap.ic_launcher_round);

        }




    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
