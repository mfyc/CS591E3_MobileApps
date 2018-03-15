package com.cs591.w5_p1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MsgFragment.ControlFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // implement our sendMessage here because we promised to do so in ControlFragmentListener
    @Override
    public void sendMessage(String msg) {
        ImgFragment receivingFragment = (ImgFragment)getSupportFragmentManager().findFragmentById(R.id.fgImage);
        receivingFragment.setMessage(msg);
    }

}
