package com.example.asynctask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTAG_";
    private ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progress = (ProgressBar) findViewById(R.id.prog_main);

        new ExampleTask(progress).execute();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    public void doMagic(View view) {

        Log.d(TAG, "doMagic: " + "HELLO WORD");
    }

    public void doMagic2(View view) {

        Intent intent = new Intent(this, MyService.class);
        startService(intent);
    }
}
