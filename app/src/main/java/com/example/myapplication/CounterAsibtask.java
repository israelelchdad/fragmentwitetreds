package com.example.myapplication;

import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;

import java.lang.ref.WeakReference;

public class CounterAsibtask extends AsyncTask<Integer,Integer,String> {
    private WeakReference<ActivAsinc> weakReference;

    public CounterAsibtask(ActivAsinc activAsinc) {
        this.weakReference =  new WeakReference<ActivAsinc>(activAsinc);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        ActivAsinc activAsinc = weakReference.get();
        if (activAsinc == null || activAsinc.isFinishing()){
            return;
        }

        activAsinc.mytext.setText(" i am asinc task");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected String doInBackground(Integer... integers) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i =integers[0]; i >= 0; i--) {
            if (isCancelled()){
                break;
            }
            publishProgress(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
        return "done";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        ActivAsinc activAsinc = weakReference.get();
        if (activAsinc == null || activAsinc.isFinishing()) {
            return;
        }
        activAsinc.mytext.setText(String.valueOf(values[0]));

    }
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        ActivAsinc activAsinc = weakReference.get();
        if (activAsinc == null || activAsinc.isFinishing()){
            return;
        }
        Toast.makeText(activAsinc,s,Toast.LENGTH_SHORT).show();
        activAsinc.mytext.setText("finishd");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//       activAsinc.mytext.setVisibility(View.GONE);

    }
}
