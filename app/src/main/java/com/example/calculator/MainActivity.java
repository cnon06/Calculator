package com.example.calculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;


public class MainActivity extends AppCompatActivity {


    TextView display;

    Button one,two,three,four,five,six,seven,eight,nine,zero,clear,add,subtract,multiply,divide, equal, n_p, dot;

   String number_two=null, process=null;

   Boolean process_switch1 = false, process_switch2 =false;


   public void msg_box(String msg)
   {

  AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage(msg);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });


        alertDialog.show();

   }


   public void process(String process)
   {


       BigDecimal bg ;


       if(number_two!=null && process_switch2)
       {
           //if(process_switch2 )
           //{
               try {
                   switch (this.process)
                   {

                       case "*" :

                           break;


                       case "+" :

                           bg = new BigDecimal(number_two);
                           number_two = bg.add(new BigDecimal(display.getText().toString())).toString();
                           display.setText(number_two);

                           break;

                       case "-" :
                           bg = new BigDecimal(number_two);
                           number_two = bg.subtract(new BigDecimal(display.getText().toString())).toString();
                           display.setText(number_two);
                           break;


                       default:

                           break;

                   }


               }
               catch (Exception e)
               {
               //    msg_box(process);
               }
       }



       //}
           number_two= display.getText().toString();

           this.process=process;
           process_switch1 =true;
           process_switch2 = false;
       process_switch1 =true;
       process_switch2 = false;

   }


   public String remove_first_zero(String numbers)
   {
       if(numbers.charAt(0)=='0' && numbers.length()!=1) numbers=numbers.substring(1);
       return numbers;
   }

 public  void numbers (String numbers)
 {
    process_switch2 =true;


   if(process_switch1)
   {
       display.setText(remove_first_zero(numbers));
       process_switch1=false;
   } else
     display.setText(remove_first_zero(display.getText()+numbers));

   if(display.getText().toString().indexOf(".")==0) display.setText(0+display.getText().toString());




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
        multiply = (Button) findViewById(R.id.multiple);
        divide = (Button) findViewById(R.id.divide);
        equal = (Button) findViewById(R.id.equal);
        n_p = (Button) findViewById(R.id.n_p);
        dot =  (Button) findViewById(R.id.dot);




        clear = (Button) findViewById(R.id.clear);



        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             //   if(!display.getText().toString().contains(".") || !process_switch2) numbers(".");
                if(!display.getText().toString().contains(".")) numbers(".");

            }
        });

        n_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            String ght2=null;


                BigDecimal number_three = new BigDecimal(display.getText().toString());
                number_three = number_three.multiply(new BigDecimal("-1"));
                if(number_three.toString()!="0")
                {
                    display.setText(number_three.toString());

                    if(  process_switch1 && !process_switch2 )
                    {
                        number_two = number_three.toString();
                    }
                }




            }
        });


        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });


        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                process("-");
            }
        });



        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });



        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


              process("+");
                //msg_box(number_two.toString());

            }
        });





        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        numbers("1");
                        }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbers("2");

            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbers("3");


            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                numbers("4");

            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                numbers("5");

            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbers("6");


            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbers("7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                numbers("8");

            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                numbers("9");

            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            numbers("0");

            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText("0");
                number_two=null; process=null;
                process_switch1 = false; process_switch2 =false;

                number_two="";
            }
        });

    }
}