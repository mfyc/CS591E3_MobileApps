package com.example.cs591e3.w4_p3;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class WestActivity extends AppCompatActivity {

    private TextView txtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_west);

        txtMessage = (TextView)findViewById(R.id.txtWest);

    }
}
