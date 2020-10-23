package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView display;

    Button one,two,three,four,five,six,seven,eight,nine,zero,clear,add,subtract;

    String dsp="0";
    Integer number_one=0,number_two=0;

    boolean sub_cont=true,add_cont=true;


    public void numbers(String number)
    {
        if(dsp=="0") dsp="";
        dsp+=number;
        display.setText(dsp);
        add_cont=true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        display = (TextView) findViewById(R.id.display);

        one = (Button) findViewById(R.id.one);
        two= (Button) findViewById(R.id.two );
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        zero = (Button) findViewById(R.id.zero);
        add = (Button) findViewById(R.id.add);
        subtract = (Button) findViewById(R.id.subtract);

        clear = (Button) findViewById(R.id.clear);

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // if(dsp=="0") dsp="";
                // dsp+="1";

                int subb2=Integer.parseInt(display.getText().toString());



                   if(sub_cont && subb2!=0)
                   {
                       number_one=subb2;
                       sub_cont=false;
                   }

                   else

                   {
                       number_one-=subb2;



                       // number_two=

                       //display.setText("");

                   }

                dsp="";
                display.setText(number_one+"");

            }
        });


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(add_cont)
                {
                    number_one+=Integer.parseInt(display.getText().toString());
                    dsp="";
                    display.setText(number_one+"");
                    add_cont=false;
                }

            }
        });





        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                numbers("1");
                /*
                   if(dsp=="0") dsp="";
                dsp+="1";
                display.setText(dsp);
                 */

                        }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             numbers("2");
             /*
               if(dsp=="0") dsp="";
                dsp+="2";
                display.setText(dsp);
              */

            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbers("3");
                /*
                  if(dsp=="0") dsp="";
                dsp+="3";
                display.setText(dsp);
                 */

            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbers("4");
                /*
                   if(dsp=="0") dsp="";
                dsp+="4";
                display.setText(dsp);
                 */

            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbers("5");
               /*
                if(dsp=="0") dsp="";
                dsp+="5";
                display.setText(dsp);
                */

            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbers("6");
                /*
                 if(dsp=="0") dsp="";
                dsp+="6";
                display.setText(dsp);
                 */

            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               numbers("7");
               /*
                if(dsp=="0") dsp="";
                dsp+="7";
                display.setText(dsp);
                */

            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               numbers("8");
               /*
                 if(dsp=="0") dsp="";
                dsp+="8";
                display.setText(dsp);
                */

            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                numbers("9");
                /*
                  if(dsp=="0") dsp="";
                dsp+="9";
                display.setText(dsp);
                 */
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dsp !="0") dsp+="0";;

                display.setText(dsp);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dsp="0";
                number_one=0;
                display.setText(dsp);
                sub_cont=true;
            }
        });

    }
}