package com.example.jt1300.flashcards;

/**
 * Created by Jt1300 on 2/11/18.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class SecondActivity extends AppCompatActivity{
    private int counter = 0;
    private int correct = 0;
    private EditText answer;
    private TextView num1;
    private TextView num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        answer = findViewById(R.id.ans);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        Button btn = findViewById(R.id.replay);
        Toast toast;
        Context context = getApplicationContext();
        String secretMsg;
        Bundle bundle = getIntent().getExtras();

        secretMsg = bundle.getString("User");
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, "Welcome " + secretMsg, duration).show();
        btn.setVisibility(View.GONE);

        //setup first problem
        Random rand = new Random();
        int q = rand.nextInt(100) + 1;
        int d = rand.nextInt(q/2 + 1) + 1;
        boolean f2 = true;
        if(q % d != 0){
            f2 = false;
        }
        if(!f2){
            while(q % d != 0){
                q = rand.nextInt(100) + 1;
                d = rand.nextInt(q/2 + 1) + 1;
            }
        }
        num1.setText(String.valueOf(q));
        num2.setText(String.valueOf(d));
        counter++;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("answer", answer.getText().toString());
        outState.putString("num1", num1.getText().toString());
        outState.putString("num2", num2.getText().toString());
        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        answer.setText(savedInstanceState.getString("answer"));
        num1.setText(savedInstanceState.getString("num1"));
        num2.setText(savedInstanceState.getString("num2"));

    }

    //get the next problem
    public void Next(View v){
        counter++;
        if(counter == 11){
            //display score, play again and restart
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_LONG;
            Toast.makeText(context, "Results: " + String.valueOf(correct) + " out of 10", duration).show();
            restart();
        } else{
            boolean f1 = confirm(num1.getText().toString(), num2.getText().toString());
            if (f1){
                correct++;
            }
            Random rand = new Random();
            int q = rand.nextInt(100) + 1;
            int d = rand.nextInt(q/2 + 1) + 1;
            boolean f2 = true;
            if(q % d != 0){
                f2 = false;
            }
            if(!f2){
                while(q % d != 0){
                    q = rand.nextInt(100) + 1;
                    d = rand.nextInt(q/2 + 1) + 1;
                }
            }
            num1.setText(String.valueOf(q));
            num2.setText(String.valueOf(d));
            answer.setText("");
        }
    }
    //validate the given asnwer
    public boolean confirm(String s1, String s2){
        int temp = Integer.parseInt(s1);
        int temp2 = Integer.parseInt(s2);
        int temp3 = Integer.parseInt(answer.getText().toString());
        if(temp/temp2 == temp3){
            return true;
        }
        else{
            return false;
        }
    }
    //restart the game
    public void restart(){
        Button btn = findViewById(R.id.replay);
        btn.setVisibility(View.VISIBLE);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent restart = getIntent();
                finish();
                startActivity(restart);

            }
        });
    }
}
