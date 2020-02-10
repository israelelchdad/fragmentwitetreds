package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TherdAvctivity extends AppCompatActivity implements View.OnClickListener {
    Button creat;
    Button start;
    Button cencel;
    TextView mytext;
    Handler myHendler;
    int myint = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState!= null){
            myint = savedInstanceState.getInt("MyInt");

        }
        setContentView(R.layout.activity_therd_avctivity);
        myHendler = new Handler(Looper.getMainLooper());
        mytext = findViewById(R.id.text_async);
        creat = findViewById(R.id.creat);
        creat.setOnClickListener(this);
        start = findViewById(R.id.start);
        start.setOnClickListener(this);
        cencel = findViewById(R.id.cencel);
        cencel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.creat:
                mytext.setVisibility(View.VISIBLE);
                mytext.setText("if you want start click start");
                break;
            case R.id.start:
                mytext.setVisibility(View.VISIBLE);
//                mytext.setText("im start");
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if(myint ==0){
                            myint=10;
                        }
                        for (int i = myint; i >=0 ; i--) {


                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            myint= i;
                            myHendler.post(new Runnable() {
                                @Override
                                public void run() {
                                    mytext.setText(String.valueOf(myint));

                                    if(myint == 0){
                                        Toast.makeText(getBaseContext(),"done",Toast.LENGTH_SHORT).show();
//                                    mytext.setText("finishd");
                                    }


                                }
                            });

                        }

                    }
                });
                thread.start();

                break;
            case R.id.cencel:
                mytext.setVisibility(View.GONE);

                break;
        }

    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);


        savedInstanceState.putInt("MyInt", myint);

    }
}
