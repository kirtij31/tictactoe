package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MENU extends AppCompatActivity implements View.OnClickListener {

    Button newGame;
    Spinner spinner ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_e_n_u);

        newGame=(Button)findViewById(R.id.new_game);

        newGame.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.new_game:
                Intent a = new Intent(this,MainActivity.class);
                startActivity(a);
                MainActivity.restart();
                break;





        }
    }






}