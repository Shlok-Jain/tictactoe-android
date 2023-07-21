package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

//    o -> 0
//    x -> 1
    int [][] winning_boxes = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int turn = 0;
//    0 -> o
//    1 -> x
//    2 -> null
    int [] state = {2,2,2,2,2,2,2,2,2};

    public int checkWin(){
        int winner = 2;
        for (int[] winning_box : winning_boxes) {
            if (state[winning_box[0]] == state[winning_box[1]] && state[winning_box[0]] == state[winning_box[2]] && state[winning_box[0]] != 2) {
                winner = state[winning_box[0]];
            }
        }

        return winner;
    }

    public void replay(View view){
        turn = 0;
        Arrays.fill(state, 2);
        setStatus("Turn of : O");

        ImageView vw2 = findViewById(R.id.imageView2); vw2.setImageResource(0);
        vw2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userClicked(vw2);
            }
        });
        ImageView vw3 = findViewById(R.id.imageView3); vw3.setImageResource(0);
        vw3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userClicked(vw3);
            }
        });
        ImageView vw4 = findViewById(R.id.imageView4); vw4.setImageResource(0);
        vw4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userClicked(vw4);
            }
        });
        ImageView vw5 = findViewById(R.id.imageView5); vw5.setImageResource(0);
        vw5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userClicked(vw5);
            }
        });
        ImageView vw6 = findViewById(R.id.imageView6); vw6.setImageResource(0);
        vw6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userClicked(vw6);
            }
        });
        ImageView vw7 = findViewById(R.id.imageView7); vw7.setImageResource(0);
        vw7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userClicked(vw7);
            }
        });
        ImageView vw8 = findViewById(R.id.imageView8); vw8.setImageResource(0);
        vw8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userClicked(vw8);
            }
        });
        ImageView vw9 = findViewById(R.id.imageView9); vw9.setImageResource(0);
        vw9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userClicked(vw9);
            }
        });
        ImageView vw10 = findViewById(R.id.imageView10); vw10.setImageResource(0);
        vw10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userClicked(vw10);
            }
        });

    }

    public boolean checkDraw(){
        for (int j : state) {
            if (j == 2) {
                return false;
            }
        }
        int winner = checkWin();
        return winner == 2;
    }

    public void setStatus(String str){
        TextView tv = findViewById(R.id.textView2);
        tv.setText(str);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(turn==0){
            setStatus("Turn of: O");
        }
        else{
            setStatus("Turn of: X");
        }
    }

    public void userClicked(View view){
        ImageView vw = (ImageView) view;
        int tapped_img = Integer.parseInt(vw.getTag().toString());
        if(state[tapped_img]==2){
            state[tapped_img] = turn;
            vw.setTranslationY(-1000f);

            if(turn==0){
                vw.setImageResource(R.drawable.o);
                setStatus("Turn of: X");
                turn = 1;
            }
            else{
                vw.setImageResource(R.drawable.x);
                setStatus("Turn of: O");
                turn = 0;
            }
            vw.animate().translationYBy(1000f).setDuration(300);
            int winner = checkWin();
            if(winner!=2){
                if(winner==0){
                    setStatus("Winner is : O");
                }
                else{
                    setStatus("Winner is : X");
                }
                findViewById(R.id.imageView2).setOnClickListener(null);
                findViewById(R.id.imageView3).setOnClickListener(null);
                findViewById(R.id.imageView4).setOnClickListener(null);
                findViewById(R.id.imageView5).setOnClickListener(null);
                findViewById(R.id.imageView6).setOnClickListener(null);
                findViewById(R.id.imageView7).setOnClickListener(null);
                findViewById(R.id.imageView8).setOnClickListener(null);
                findViewById(R.id.imageView9).setOnClickListener(null);
                findViewById(R.id.imageView10).setOnClickListener(null);
            }
            else{
                boolean bol = checkDraw();
                if(bol)setStatus("It is a DRAW");
            }
        }
//        Toast.makeText(this, "clicked: "+ tapped_img, Toast.LENGTH_SHORT).show();
    }
}