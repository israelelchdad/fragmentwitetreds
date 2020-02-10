package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivAsinc extends AppCompatActivity implements View.OnClickListener {
    Button creat;
    Button start;
    Button cencel;
    CounterAsibtask mycounterAsibtask;

    TextView mytext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asyntastask);
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
                mytext.setText("if you want start click start");
                break;
            case R.id.start:
                mycounterAsibtask = new CounterAsibtask(this);
                mycounterAsibtask.execute(10);
                break;
            case R.id.cencel:
                mycounterAsibtask.cancel(true);

                break;
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mycounterAsibtask.cancel(true);
    }
}
