package com.calculator2.calculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.DrawableCompat;

import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;


public class MainActivity extends AppCompatActivity {


    TextView display;

    Button one,two,three,four,five,six,seven,eight,nine,zero,clear,add,subtract,multiply,divide, equal, n_p, dot, percent, sqr;

   String number_two=null, process=null;

   Boolean process_switch1 = false, process_switch2 =false;


   thousandseperatorcoma t_seperator = new thousandseperatorcoma();



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

      // display.setText("0");

       display.setText(t_seperator.set_text("0"));


       number_two=null; process=null;
       process_switch1 = false; process_switch2 =false;
       number_two="";
   }


   public void process(String process)
   {


       BigDecimal bg ;


       if(number_two!=null && process_switch2)
       {

               try {
                   switch (this.process)
                   {

                       case "%" :

                           bg = new BigDecimal(number_two);
                         //  number_two = bg.multiply(new BigDecimal(display.getText().toString())).toString();
                           number_two = bg.multiply(new BigDecimal(t_seperator.get_text())).toString();
                         bg = new BigDecimal(number_two);

                           number_two = bg.multiply(new BigDecimal("0.01")).toString();

                           bg = new BigDecimal(number_two);

                          if (Float.parseFloat(bg.subtract(new BigDecimal(bg.toBigInteger())).toString())==0.0f)
                          {
                              number_two =bg.toBigInteger().toString();
                          };

                         //  display.setText(number_two);
                           display.setText(t_seperator.set_text(number_two));

                           break;



                       case "*" :
                           bg = new BigDecimal(number_two);
                           //number_two = bg.multiply(new BigDecimal(display.getText().toString())).toString();
                           number_two = bg.multiply(new BigDecimal(t_seperator.get_text())).toString();
                          // display.setText(number_two);
                           display.setText(t_seperator.set_text(number_two));
                           break;


                       case "+" :

                           bg = new BigDecimal(number_two);
                           //number_two = bg.add(new BigDecimal(display.getText().toString())).toString();
                           number_two = bg.add(new BigDecimal(t_seperator.get_text())).toString();
                          // display.setText(number_two);
                           display.setText(t_seperator.set_text(number_two));
                           break;

                       case "-" :
                           bg = new BigDecimal(number_two);
                          // number_two = bg.subtract(new BigDecimal(display.getText().toString())).toString();
                           number_two = bg.subtract(new BigDecimal(t_seperator.get_text())).toString();
                          // display.setText(number_two);
                           display.setText(t_seperator.set_text(number_two));
                           break;

                       case "/" :

                           try {

                               bg = new BigDecimal(number_two);
                               MathContext mc = new MathContext(5, RoundingMode.HALF_EVEN) ;
                               // number_two = bg.divide(new BigDecimal(display.getText().toString()),mc).toString();
                               number_two = bg.divide(new BigDecimal(t_seperator.get_text()),mc).toString();
                              // display.setText(number_two);
                               display.setText(t_seperator.set_text(number_two));

                           }
                           catch (ArithmeticException ae)
                           {

                              msg_box("Err: Divided by zero");
                               clear();
                           }

                           break;


                       case "=" :
                          // bg = new BigDecimal(number_two);
                           // number_two = display.getText().toString();
                           number_two = t_seperator.get_text();
                          // display.setText(number_two);
                           display.setText(t_seperator.set_text(number_two));
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




          // number_two= display.getText().toString();

       number_two= t_seperator.get_text();

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
      // display.setText(remove_first_zero(numbers));
       display.setText(t_seperator.set_text(remove_first_zero(numbers)));
       process_switch1=false;
   } else
    // display.setText(remove_first_zero(display.getText()+numbers));
    //   display.setText(remove_first_zero(t_seperator.get_text()+numbers));
       display.setText(t_seperator.set_text(remove_first_zero(t_seperator.get_text()+numbers)));

   // if(display.getText().toString().indexOf(".")==0) display.setText(0+display.getText().toString());
     if(t_seperator.get_text().indexOf(".")==0) display.setText(t_seperator.set_text(0+t_seperator.get_text()) );


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
        percent =  (Button) findViewById(R.id.percent);
        sqr =  (Button) findViewById(R.id.sqr);



        clear = (Button) findViewById(R.id.clear);



        clear();

        sqr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




              try {

                    number_two=null; process=null;
                    process_switch1 = false; process_switch2 =false;


                    MathContext mc = new MathContext(5, RoundingMode.HALF_EVEN) ;

                    //Float rrf= Float.parseFloat(display.getText().toString());

                    String fde = t_seperator.get_text();
                   if(fde==null) fde = "9";
                    //msg_box(fde);
                    Float rrf= Float.parseFloat(fde);

                    BigDecimal number_three = new BigDecimal(Math.sqrt(rrf),mc);

                  //  display.setText(number_three.toString());

                    display.setText(t_seperator.set_text(number_three.toString()) );


              }
                catch (Exception e)
                {
                    msg_box(e.toString());
                }




            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               // if(!display.getText().toString().contains(".")) numbers(".");
                if(!t_seperator.get_text().contains(".")) numbers(".");
            }
        });

        n_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                //BigDecimal number_three = new BigDecimal(display.getText().toString());
                BigDecimal number_three = new BigDecimal(t_seperator.get_text());
                number_three = number_three.multiply(new BigDecimal("-1"));
                if(number_three.toString()!="0")
                {
                   // display.setText(number_three.toString());
                    display.setText(t_seperator.set_text(number_three.toString()));

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



              divide.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        divide.setBackgroundColor(Color.RED);
                        return true;
                    case MotionEvent.ACTION_UP:
                        divide.setBackgroundColor(Color.parseColor("#17615B"));
                        process("/");
                        return true;
                }
                return false;
            }
        });



/*

        divide.setOnClickListener(new View.OnClickListener() {
            @Override



            public void onClick(View v) {
                process("/");

            }
        });
 */






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

              //  msg_box(t_seperator.set_text("12345.22"));
               // t_seperator.get_text();

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



            }
        });

    }
}