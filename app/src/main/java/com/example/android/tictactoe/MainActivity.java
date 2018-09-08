package com.example.android.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //0-yellow,1-red
    int player=0;
    int result=0;
    boolean gameActive=true;
    //2-unplayed
    int []state ={2,2,2,2,2,2,2,2,2};
    int [][]winpos={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void playAgain(View view){
        gameActive=true;
        LinearLayout layout=(LinearLayout)findViewById(R.id.playAgainLayout);
        layout.setVisibility(View.INVISIBLE);
         player=0;
        //2-unplayed

         for(int i=0;i<state.length;i++)
             state[i]=2;
        GridLayout gridlayout=(GridLayout)findViewById(R.id.gridLayout);
        for(int i=0 ;i<gridlayout.getChildCount();i++)
        {
            ((ImageView)gridlayout.getChildAt(i)).setImageResource(0) ;
        }
    }
public void drop(View view){

    ImageView counter= (ImageView)view;
    int tappedCounter=Integer.parseInt(counter.getTag().toString());
    if (state[tappedCounter]==2&&gameActive){
    if(player==0){

        state[tappedCounter]=player;
        counter.setTranslationY(-1000f);
    counter.setImageResource(R.drawable.yellow);
    player=1;}
    else{state[tappedCounter]=player;
        counter.setTranslationY(-1000f);
        counter.setImageResource(R.drawable.red);
    player=0;
    }

    counter.animate().translationYBy(1000f).rotation(3600).setDuration(300);}
for(int [] win: winpos){
    if((state[win[0]]==state[win[1]])
            &&(state[win[1]]==state[win[2]])
            &&(state[win[0]]!=2)
            ){
        result=1;
        String winner ="red";
        TextView msg=(TextView) findViewById(R.id.winmsg);
        if(state[win[0]]==0)
            winner="Yellow";
        msg.setText(winner+" Won");
        gameActive=false;
        LinearLayout layout=(LinearLayout)findViewById(R.id.playAgainLayout);
        layout.setVisibility(View.VISIBLE);
    }
    else{
        boolean isGameOver=true;
        for(int counterState:state){
            if(counterState==2)
                isGameOver=false;

        }
        if(isGameOver&&result==0){
            TextView msg=(TextView) findViewById(R.id.winmsg);
            msg.setText(" Draw");
            LinearLayout layout=(LinearLayout)findViewById(R.id.playAgainLayout);
            layout.setVisibility(View.VISIBLE);
        }
    }

}
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
