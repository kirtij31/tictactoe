package com.example.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.logging.XMLFormatter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    static TextView player_1;
    static Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,menu;

    static int x_player=1;
    static int o_player=2;
    static int active_player;

    static int[] occupied_tag={0,0,0,0,0,0,0,0,0};
    int[][] winning_position={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        player_1=(TextView)findViewById(R.id.player_1);

        active_player=x_player;

        btn1=(Button)findViewById(R.id.btn_1);
        btn2=(Button)findViewById(R.id.btn_2);
        btn3=(Button)findViewById(R.id.btn_3);
        btn4=(Button)findViewById(R.id.btn_4);
        btn5=(Button)findViewById(R.id.btn_5);
        btn6=(Button)findViewById(R.id.btn_6);
        btn7=(Button)findViewById(R.id.btn_7);
        btn8=(Button)findViewById(R.id.btn_8);
        btn9=(Button)findViewById(R.id.btn_9);
        menu=(Button)findViewById(R.id.btn_menu);


        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        menu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Button clicked_btn= findViewById(v.getId());
        int clicked_tag=Integer.parseInt(v.getTag().toString());

        if(clicked_tag==9){
            Intent i =new Intent(this,MENU.class);
            startActivity(i);
        }


        if(occupied_tag[clicked_tag] != 0)
              return;


          if(active_player==x_player)
          occupied_tag[clicked_tag]=1;
          else
          occupied_tag[clicked_tag]=2;



         if(active_player==x_player){
         clicked_btn.setText("X");
         player_1.setText("PLAYER 2");
         active_player=o_player;}
          else{
         clicked_btn.setText("O");
         player_1.setText("PLAYER 1");
         active_player=x_player;}


          winning_Logic();

     }




        public void winning_Logic(){
            for(int i=0;i<8;i++){
                int  a=winning_position[i][0];
                int  b=winning_position[i][1];
                int  c=winning_position[i][2];

                if(occupied_tag[a]!=0) {

                    if (occupied_tag[a] == occupied_tag[b] && occupied_tag[b] == occupied_tag[c]) {
                        if (active_player == o_player) {
                            showDialog("PLAYER 1 WINS");
                        }
                        else{
                            showDialog("PLAYER 2 WINS");
                        }
                    }

                }
            }


        }



        private void showDialog(String winnerText){
        new AlertDialog.Builder(this)
                .setTitle(winnerText)
                .setPositiveButton("Restart Game", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        restart();
                    }
                })
                .setNegativeButton("MENU", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i =new Intent(MainActivity.this,MENU.class);
                        startActivity(i);
                    }
                }).show();


        }



        public static void restart(){
            for(int j=0;j<9;j++){
             occupied_tag[j]=0;
         }
             active_player=x_player;
            player_1.setText("PLAYER 1");
             btn1.setText("");
             btn2.setText("");
             btn2.setText("");
             btn3.setText("");
             btn4.setText("");
             btn5.setText("");
             btn6.setText("");
             btn7.setText("");
             btn8.setText("");
             btn9.setText("");


         }





   }







