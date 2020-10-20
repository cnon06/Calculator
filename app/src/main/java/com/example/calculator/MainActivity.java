package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView display;

    Button one,two,three,clear;

    String dsp="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = (TextView) findViewById(R.id.display);

        one = (Button) findViewById(R.id.one);
        clear = (Button) findViewById(R.id.clear);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(dsp=="0") dsp="";
                dsp+="1";
                display.setText(dsp);
                        }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dsp="0";
                display.setText(dsp);
            }
        });

    }
}