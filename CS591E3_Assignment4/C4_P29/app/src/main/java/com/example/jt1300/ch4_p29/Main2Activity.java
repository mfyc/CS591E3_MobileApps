package com.example.jt1300.ch4_p29;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Jt1300 on 2/26/18.
 */

public class Main2Activity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button bttn1 = (Button)findViewById(R.id.btn1);
        Button bttn2 = (Button)findViewById(R.id.btn2);
        Button bttn3 = (Button)findViewById(R.id.btn3);
        Button bttn4 = (Button)findViewById(R.id.btn4);
        Button bttn5 = (Button)findViewById(R.id.btn5);
        bttn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        TextView tv = findViewById(R.id.tv);
                        tv.setText("Bonjour le monde!");
                }
        });

        bttn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        TextView tv = findViewById(R.id.tv);
                        tv.setText("Hallo Wereld!");
                }
        });

        bttn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        TextView tv = findViewById(R.id.tv);
                        tv.setText("Orbis Terrarum salve!");
                }
        });

        bttn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        TextView tv = findViewById(R.id.tv);
                        tv.setText("Selam Dünya!");
                }
        });

        bttn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        TextView tv = findViewById(R.id.tv);
                        tv.setText("Chào thế giới!");
                }
        });
    }
}
