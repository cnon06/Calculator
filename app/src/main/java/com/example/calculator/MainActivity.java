package com.example.calculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/*
class MyDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("App Title");
        builder.setMessage("This is an alert with no consequence");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // You don't have to do anything here if you just
                // want it dismissed when clicked
            }
        });

        // Create the AlertDialog object and return it
        return builder.create();
    }
}

 */


public class MainActivity extends AppCompatActivity {


    TextView display;

    Button one,two,three,four,five,six,seven,eight,nine,zero,clear,add,subtract,multiply,divide, equal;

    //DialogFragment dialog = new MyDialogFragment();

    Boolean lock_unlock =false;

    String dsp="0", div_wrt="",Process="";
   Float number_one =0.0F,number_four=0.0F;
   // Integer  number_one=0,number_two=0;


   // boolean sub_cont=true,add_cont=true, div_cont=true;



    public  void remove_zero()
   {
       Integer number_two = (int)Math.floor(number_one);

       Float number_three = number_one - (float)number_two;
       boolean zero_or_not = true;
       if(number_three==0.0F)
       {
           display.setText(number_two+"");
       }
       else
       {
           display.setText(number_one+"");
       }
       //zero_or_not=true; else  zero_or_not = false;


   }


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

    public  void process()
    {
       if(lock_unlock)
       {
           in_process();
           lock_unlock=false;
       }
    }

    public  void in_process()
    {
        //msg_box(Process+" number_one: "+number_one);



       switch (Process)
       {

           case "=":

               number_one=Float.parseFloat(display.getText().toString());
               remove_zero();

               break;


           case "":
               number_one=Float.parseFloat(display.getText().toString());
               break;




           case "/":

                       number_one/=Float.parseFloat(display.getText().toString());
               remove_zero();

               break;

           case "*":




                   number_one*= Float.parseFloat(display.getText().toString());
               remove_zero();

               break;

           case "+":
               number_one+= Float.parseFloat(display.getText().toString());
               remove_zero();
               break;

           case "-":

               number_one-= Float.parseFloat(display.getText().toString());
               remove_zero();
               break;




       }


        //number_one=Float.parseFloat(display.getText().toString());
        dsp="";






    }
   


    public void numbers(String number)
    {


 dsp+=number;

        if(dsp.charAt(0)=='0')
        {
            dsp =dsp.substring(1,dsp.length());
        }

        display.setText(dsp);


           lock_unlock=true;


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




        clear = (Button) findViewById(R.id.clear);


        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                process();
                Process="=";

            }
        });


        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                process();
                Process="-";

            }
        });



        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                process();
                Process="/";


            }
        });



        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                process();
                Process="*";

            }
        });



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                    process();
                Process="+";


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
                dsp="0";
                number_one=0.F;
                display.setText(dsp);
               Process="";

                // sub_cont=true;
               // div_cont=true;
            }
        });

    }
}