package com.example.ray.activitylog;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG,"activity is onCreate");
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart(){
        Log.i(TAG,"activity on start");
        super.onStart();
    }
    @Override
    protected void onResume(){
        Log.i(TAG,"activity on resume");
        super.onResume();
    }
    @Override
    protected void onPause(){
        Log.i(TAG,"activity on pause");
        super.onPause();
    }
    @Override
    protected  void onSaveInstantState(Bundle outState, PersistableBundle lolol){
        Log.i(TAG,"activity on Save Instant State");
        super.onSaveInstanceState(outState, lolol);
    }
    @Override
    protected void onStop(){
        Log.i(TAG, "Activate on stop call");
        super.onStop();
    }
    protected void onDestroy() {
        Log.i(TAG, "Activate on destroy call");
        super.onStop();
    }
}
