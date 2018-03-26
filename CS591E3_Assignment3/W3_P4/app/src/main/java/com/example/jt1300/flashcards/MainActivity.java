package com.example.jt1300.flashcards;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.submit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText n1 = findViewById(R.id.user);
                EditText n2 = findViewById(R.id.pass);
                String s1 = n1.getText().toString();
                String s2 = n2.getText().toString();
                String s3 = "guest";
                String s4 = "123456";
                boolean flag = true;
                if(s1.compareTo(s3) != 0){
                    flag = false;
                }
                if(s2.compareTo(s4) != 0){
                    flag = false;
                }
                if(flag){
                    Intent main = new Intent(getApplicationContext(), SecondActivity.class);
                    main.putExtra("User", s3);
                    startActivity(main);
                }
            }
        });
    }

}
