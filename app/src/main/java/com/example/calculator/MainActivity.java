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
import java.math.MathContext;
import java.math.RoundingMode;

import static java.math.BigDecimal.ROUND_HALF_UP;






public class MainActivity extends AppCompatActivity {


    TextView display;

    Button one,two,three,four,five,six,seven,eight,nine,zero,clear,add,subtract,multiply,divide, equal, n_p, dot, percent, sqr;

   String number_two=null, process=null;

   Boolean process_switch1 = false, process_switch2 =false;


   thousandseperatorcoma t_seperator;


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


   public void clear()
   {
       display.setText("0");
       number_two=null; process=null;
       process_switch1 = false; process_switch2 =false;
       number_two="";
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

                       case "%" :
                           //msg_box("percent");
                           bg = new BigDecimal(number_two);
                           number_two = bg.multiply(new BigDecimal(display.getText().toString())).toString();

                         bg = new BigDecimal(number_two);

                           number_two = bg.multiply(new BigDecimal("0.01")).toString();

                           bg = new BigDecimal(number_two);

                          if (Float.parseFloat(bg.subtract(new BigDecimal(bg.toBigInteger())).toString())==0.0f)
                          {
                              number_two =bg.toBigInteger().toString();
                          };

                           display.setText(number_two);
                           break;



                       case "*" :
                           bg = new BigDecimal(number_two);
                           number_two = bg.multiply(new BigDecimal(display.getText().toString())).toString();
                           display.setText(number_two);
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

                       case "/" :

                           try {

                               bg = new BigDecimal(number_two);
                               MathContext mc = new MathContext(5, RoundingMode.HALF_EVEN) ;
                               number_two = bg.divide(new BigDecimal(display.getText().toString()),mc).toString();
                               display.setText(number_two);

                           }
                           catch (ArithmeticException ae)
                           {
                            //msg_box(ae.toString());
                              msg_box("Err: Divided by zero");
                               clear();
                           }

                           break;


                       case "=" :
                           bg = new BigDecimal(number_two);
                           number_two = display.getText().toString();
                           display.setText(number_two);
                           break;

                       default:

                           break;

                   }


               }
               catch (Exception e)
               {
              //  msg_box(e.toString());
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

/*
 public static BigDecimal sqrt(BigDecimal A, final int SCALE) {
        BigDecimal x0 = new BigDecimal("0");
        BigDecimal x1 = new BigDecimal(Math.sqrt(A.doubleValue()));
        while (!x0.equals(x1)) {
            x0 = x1;
            x1 = A.divide(x0, SCALE, ROUND_HALF_UP);
            x1 = x1.add(x0);
            x1 = x1.divide(TWO, SCALE, ROUND_HALF_UP);

        }
        return x1;
    }
 */





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
        percent =  (Button) findViewById(R.id.percent);
        sqr =  (Button) findViewById(R.id.sqr);




        clear = (Button) findViewById(R.id.clear);


        sqr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               // BigDecimal number_three = new BigDecimal("81");
               MathContext mc = new MathContext(5, RoundingMode.HALF_EVEN) ;
                //number_three = number_three.
                //number_three = number_three.pow( 2,mc);

                Float rrf= Float.parseFloat(display.getText().toString());

              BigDecimal number_three = new BigDecimal(Math.sqrt(rrf),mc);

             //msg_box(number_three.toString());
                display.setText(number_three.toString());



            }
        });

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



            //String ght2=null;


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


        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                process("%");

            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                process("=");

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
                process("/");

            }
        });



        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process("*");

            }
        });



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


              process("+");
                msg_box(t_seperator.thousand_separator("11.22"));
                //msg_box("ffd");

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

               clear();

               /*

                   display.setText("0");
                number_two=null; process=null;
                process_switch1 = false; process_switch2 =false;
                number_two="";
                */



            }
        });

    }
}