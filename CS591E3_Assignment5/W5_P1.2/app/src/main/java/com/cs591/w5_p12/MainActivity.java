package com.cs591.w5_p12;

import android.graphics.drawable.Drawable;
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

    @Override
    public void setBG(int bgPosition) {
        ImgFragment receivingFragment = (ImgFragment)getSupportFragmentManager().findFragmentById(R.id.fgImage);
        switch (bgPosition) {
            case 0:
                receivingFragment.getView().setBackgroundResource(R.drawable.squareburger);
                break;
            case 1:
                receivingFragment.getView().setBackgroundResource(R.drawable.hotdog);
                break;
            case 2:
                receivingFragment.getView().setBackgroundResource(R.drawable.pizza);
                break;
            case 3:
                receivingFragment.getView().setBackgroundResource(R.drawable.frenchfries);
                break;
            case 4:
                receivingFragment.getView().setBackgroundResource(R.drawable.friedicecream);
                break;
        }
    }

}