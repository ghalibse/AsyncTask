package com.example.asynctask;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;

/**
 * Created by admin on 7/29/2016.
 */
public class ExampleTask extends AsyncTask<Void, Integer, Void> {

    private static final String TAG = "ExampleTaskTAG_";

    private ProgressBar progressBar;

    public ExampleTask(ProgressBar progressBar){

        this.progressBar = progressBar;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        Log.d(TAG, "onPreExecute: " + Thread.currentThread());
    }

    @Override
    protected Void doInBackground(Void... voids) {

        Log.d(TAG, "doInBackground: " + Thread.currentThread());



        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1000);
                Log.d(TAG, "doInBackground: " + i);
                publishProgress(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();

        Log.d(TAG, "onCancelled: " + Thread.currentThread());
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

        Log.d(TAG, "onProgressUpdate: " + Thread.currentThread());
        progressBar.setProgress(values[0]);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        Log.d(TAG, "onPostExecute: " + Thread.currentThread());
    }
}
