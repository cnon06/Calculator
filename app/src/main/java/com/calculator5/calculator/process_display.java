package com.calculator5.calculator;

import android.content.DialogInterface;
import android.util.Log;

import androidx.appcompat.app.AlertDialog;


public class process_display
{




    public String output(String ss)

    {



/*
if(ss.contains(".")) {
    String wea3 = ss.substring(ss.indexOf(".") + 1);

    Integer ngg4 = Integer.parseInt(wea3);

    if (ngg4 == 0) {
        ss = ss.substring(0, ss.indexOf("."));
    }
}
 */

        try {
            if(ss.contains(".")) {
                String jg7=ss;

                int ewt = 0;



                for(int i=jg7.length()-1;i>=0;i--)
                {

                    if(jg7.charAt(i)!='0') {  ewt=i; break;}


                }
                ss=jg7.substring(0,ewt+1);


                if(ss.charAt(ss.length()-1)=='.') ss=ss.substring(0,ss.length()-1);

            }

        }
        catch (Exception e)
        {

        }









        return  ss;
    }


}
