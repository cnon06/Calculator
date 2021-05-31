package com.calculator4.calculator;

import android.content.DialogInterface;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


class thousandseperatorcoma extends AppCompatActivity {




   String get_text="";






 String get_text()
    {


     return get_text;

    }




     String set_text(String yh1) {

  get_text=yh1;

          String yh2 = yh1;




        try {
            yh2 = yh2.substring(0, yh2.indexOf("."));

        } catch (Exception e) {

        }

        String yh3 = "";

        try {

            yh3 = yh1.substring(yh1.indexOf("."));
        } catch (Exception e) {

        }


        String yh4 = "";

        int k = 0;

        for (int i = yh2.length() - 1; i >= 0; i--) {
            k++;
            yh4 = yh2.charAt(i) + yh4;

            if ((k) % 3 == 0 && i != 0) yh4 = ',' + yh4;
        }


         String ss = yh4 + yh3;


        try {
             Integer.parseInt(ss.charAt(0)+"");
         }
         catch (Exception e)
         {

             try {
                 if(ss.charAt(1)==',')  ss=ss.replaceFirst(",","");
             }
             catch ( Exception er)
             {

             }


         }




         if(ss.contains("."))
         {
             String wea3 = ss.substring(ss.indexOf(".")+1);

             Integer ngg4 = Integer.parseInt(wea3);

             if(ngg4==0)
             {
                 ss = ss.substring(0,ss.indexOf("."));
             }



            // Log.d("",wea2);
         }


        return ss;


     }

}



