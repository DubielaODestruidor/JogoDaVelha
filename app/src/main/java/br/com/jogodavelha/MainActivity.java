package br.com.jogodavelha;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    boolean gameActive = true;

    int activePlayer = 0;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    int[][] winPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}};
    public static int counter = 0;

    @SuppressLint("SetTextI18n")
    public void playerTap(View view) {
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());


        if (!gameActive) {
            gameReset(view);
        }


        if (gameState[tappedImage] == 2) {

            counter++;


            if (counter == 9) {
                gameActive = false;
            }


            gameState[tappedImage] = activePlayer;


            img.setTranslationY(-1000f);


            if (activePlayer == 0) {

                img.setImageResource(R.drawable.sapo);
                activePlayer = 1;
                TextView status = findViewById(R.id.status);


                status.setText("Vez da capivara");
            } else {

                img.setImageResource(R.drawable.capivara);
                activePlayer = 0;
                TextView status = findViewById(R.id.status);


                status.setText("Vez do sapo");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        int flag = 0;

        for (int[] winPosition : winPositions) {
            if (gameState[winPosition[0]] == gameState[winPosition[1]] &&
                    gameState[winPosition[1]] == gameState[winPosition[2]] &&
                    gameState[winPosition[0]] != 2) {
                flag = 1;


                String winnerStr;


                gameActive = false;
                if (gameState[winPosition[0]] == 0) {
                    winnerStr = "Sapo ganhou!";
                } else {
                    winnerStr = "Capivara ganhou!";
                }

                TextView status = findViewById(R.id.status);
                status.setText(winnerStr);
            }
        }

        if (counter == 9 && flag == 0) {
            TextView status = findViewById(R.id.status);
            status.setText("Empate!");
        }
    }


    @SuppressLint("SetTextI18n")
    public void gameReset(View view) {
        gameActive = true;
        activePlayer = 0;
        Arrays.fill(gameState, 2);

        ((ImageView) findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        status.setText("Vez do sapo");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}