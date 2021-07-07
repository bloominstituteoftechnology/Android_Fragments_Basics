package com.lambda.android_fragments_basics;

import android.text.method.DateTimeKeyListener;

import org.apache.commons.beanutils.converters.DateTimeConverter;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Weight {
    double dDateAndTime;
    int  iGram;
    int iBMIx10;

    public Weight(double dDateAndTime, int iGram, int iBMVx10) {
        this.dDateAndTime = dDateAndTime;
        this.iGram = iGram;
        this.iBMIx10 = iBMVx10;
    }

    public Weight(String strAll){
        String[] straAll=strAll.split( "\n" );
        String[] straLine;
        DateTimeConverter dtc;
        for(int i=0;i<straAll.length;i++){
            straLine=straAll[i].split( " " );
            for(int j=0;j<straLine.length;j++){
                if(straLine[j].equals( "" )){

                }else{
                    String date=straLine[j];
                    String time=straLine[j+1];
                    String weight=straLine[j+3];
                    String BMI=straLine[j+4];
                    iGram=(int)(1000*Float.parseFloat( weight ));
                    iBMIx10=(int)(10*Float.parseFloat( BMI ));
                }
            }
         //   dDateAndTime= (double) SimpleDateFormat.getDateInstance().format(  straLine[0]);
        }

    }
}
