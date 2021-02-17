package com.example.suhitkoyani.cspitexampaper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by suhitkoyani on 7/9/2017.
 */

public class Splash extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
     Thread mythread = new Thread(){
         @Override
         public  void run(){
             try{
                 sleep(3000);
                 Intent i =new Intent(getApplicationContext(),MainActivity.class);
                 startActivity(i);
                 finish();
             }
             catch(InterruptedException e){
                  e.printStackTrace();
             }
         }
     };
     mythread.start();
    }
}
