package com.example.princetictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameActive=true;
    //player representation
    // 0-x
    // 1-o

    int activePlayer=0;
    int[] gamestate={2,2,2,2,2,2,2,2,2};
//    0-x
//    1-0
//    2-null
      int [][] winPositions={{0,1,2},{3,4,5},{6,7,8},
                             {0,3,6},{1,4,7},{2,5,8},
                             {0,4,8},{2,4,6}};

    public void playertap(View view){
        ImageView img = (ImageView) view;
        int tappedImage=Integer.parseInt(img.getTag().toString());
        if (!gameActive){
            gameReset(view);
        }
        if (gamestate[tappedImage]==2) {
            gamestate[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.x);
                activePlayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText("Prince says O`s Turn-Tap");
            } else {
                img.setImageResource(R.drawable.o);
                activePlayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("Prince says X`s Turn-Tap");
            }

            img.animate().translationYBy(1000f).setDuration(300);

        }
        // check if any player won
        for (int [] winPosition: winPositions){
            if(gamestate[winPosition[0]]==gamestate[winPosition[1]] &&
                    gamestate[winPosition[1]]==gamestate[winPosition[2]] &&
                    gamestate[winPosition[0]]!=2){
                //sombedy won
                String winnerStr;
                gameActive=false;
                if (gamestate[winPosition[0]]== 0){
                    winnerStr="Prince says X Won\uD83E\uDD73";
                }
                else{
                    winnerStr="Prince says O Won\uD83E\uDD73";
                }
                // update status for winner annoncement
                TextView status = findViewById(R.id.status);
                status.setText(winnerStr);
            }
        }
    }
    public void gameReset(View view){
        gameActive=true;
        activePlayer=0;
        for (int i=0;i<gamestate.length;i++){
            gamestate[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}