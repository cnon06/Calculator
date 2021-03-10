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





public class MainActivity extends AppCompatActivity {


    TextView display;

    Button one,two,three,four,five,six,seven,eight,nine,zero,clear,add,subtract,multiply,divide, equal, n_p, dot;


    String process = "";

   String number_one = "0";
    //Long number_one = 0;
    //Double tt3 = 0.0d;


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


   public  void remove_zero(String de )
   {

   }

   public void process()
   {

       switch (process)
       {

           case "*" :



               break;


           case "+" :


               break;

           case "-" :



               break;

       }



   }


   public String remove_first_zero(String numbers)
   {
       if(numbers.charAt(0)=='0') numbers=numbers.substring(1);
       return numbers;
   }

 public  void numbers (String numbers)
 {
    // Integer yh = Integer.parseInt(numbers);


number_one = number_one+ numbers;


display.setText(remove_first_zero(number_one));
//Long ty = Long.parseLong("20");

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

               if(!number_one.contains("."))

               {
                  if(number_one=="0") numbers("0."); else  numbers(".");
               }


            }
        });

        n_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {






            }
        });


        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            //msg_box("sinan");


            }
        });


        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


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
             if(number_one!="0")   numbers("0");

            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText("0");
               number_one="0";

                process="";
            }
        });

    }
}