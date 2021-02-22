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
import android.widget.TextView;
import android.widget.Toast;



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







public class MainActivity extends AppCompatActivity {


    TextView display;

    Button one,two,three,four,five,six,seven,eight,nine,zero,clear,add,subtract,multiply,divide, equal, n_p, dot;





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


 public  void  numbers (String numbers)
 {

if(display.getText().toString().length()<8)   if(!display.getText().toString().contains("."))  if(numbers!=".") if(0==Float.parseFloat(display.getText().toString())) display.setText("");
     display.setText(display.getText()+numbers);
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

                if(!display.getText().toString().contains(".")) numbers(".");
                //msg_box("sinan".contains("z")+"");


            }
        });

        n_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if(display.getText().toString().length()<8)   if(!display.getText().toString().contains("."))  if(numbers!=".") if(0==Float.parseFloat(display.getText().toString())) display.setText("");


                if(0!=Float.parseFloat(display.getText().toString()))
                {
                    String trr = display.getText().toString();
                    //display.setText("-"+trr);

                    if(trr.contains("-"))
                    {
                        //msg_box("sinan");
                        trr= trr.replaceFirst("-","");
                    }

                    else
                        trr = "-" + trr;

                    display.setText(trr);
                }







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
                numbers("0");

            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText("0");
            }
        });

    }
}