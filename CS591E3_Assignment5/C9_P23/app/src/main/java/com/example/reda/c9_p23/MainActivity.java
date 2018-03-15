package com.example.reda.c9_p23;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements SliderControlFragment.ControlFragmentListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void sendTransparency(int trans_value){
        DimmedFragment receivingFragment = (DimmedFragment) getSupportFragmentManager().findFragmentById(R.id.fgDimmed);
        receivingFragment.setTransparency(trans_value);
    }
}