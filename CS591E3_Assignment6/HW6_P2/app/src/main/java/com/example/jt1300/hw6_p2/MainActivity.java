package com.example.jt1300.hw6_p2;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set up the view
        TextView TV = (TextView)findViewById(R.id.tv);
        EditText ET = (EditText)findViewById(R.id.et);
        final CheckBox cb1 = (CheckBox)findViewById(R.id.checkBox);
        final CheckBox cb2 = (CheckBox)findViewById(R.id.checkBox2);
        final CheckBox cb3 = (CheckBox)findViewById(R.id.checkBox3);

        //get shared preferences if any and apply them to the view
        SharedPreferences preferences = getSharedPreferences("ActivityOneInfo", Context.MODE_PRIVATE);
        ConstraintLayout bgElement = (ConstraintLayout) findViewById(R.id.container);
        if(preferences.contains("checked1") && preferences.getBoolean("checked1",false) == true) {
            cb1.setChecked(true);
            bgElement.setBackgroundColor(Color.RED);
        }else {
            cb1.setChecked(false);
        }

        if(preferences.contains("checked2") && preferences.getBoolean("checked2",false) == true) {
            cb2.setChecked(true);
            bgElement.setBackgroundColor(Color.GREEN);
        }else {
            cb2.setChecked(false);
        }

        if(preferences.contains("checked3") && preferences.getBoolean("checked3",false) == true) {
            cb3.setChecked(true);
            bgElement.setBackgroundColor(Color.BLUE);
        }else {
            cb3.setChecked(false);
        }


        //on check change listeners
        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                TextView TV = (TextView)findViewById(R.id.tv);
                EditText ET = (EditText)findViewById(R.id.et);
                TV.setText("Red");
                ET.setText("Red");
                ConstraintLayout bgElement = (ConstraintLayout) findViewById(R.id.container);
                bgElement.setBackgroundColor(Color.RED);
                SharedPreferences Info = getSharedPreferences("ActivityOneInfo", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = Info.edit();
                if(cb1.isChecked()) {
                    editor.putBoolean("checked1", true);
                    editor.apply();
                }else{
                    editor.putBoolean("checked1", false);
                    editor.apply();
                }
            }
        });

        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                TextView TV = (TextView)findViewById(R.id.tv);
                EditText ET = (EditText)findViewById(R.id.et);
                TV.setText("Green");
                ET.setText("Green");
                ConstraintLayout bgElement = (ConstraintLayout) findViewById(R.id.container);
                bgElement.setBackgroundColor(Color.GREEN);
                SharedPreferences Info = getSharedPreferences("ActivityOneInfo", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = Info.edit();
                if(cb1.isChecked()) {
                    editor.putBoolean("checked2", true);
                    editor.apply();
                }else{
                    editor.putBoolean("checked2", false);
                    editor.apply();
                }
            }
        });


        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                TextView TV = (TextView)findViewById(R.id.tv);
                EditText ET = (EditText)findViewById(R.id.et);
                TV.setText("Blue");
                ET.setText("Blue");
                ConstraintLayout bgElement = (ConstraintLayout) findViewById(R.id.container);
                bgElement.setBackgroundColor(Color.BLUE);
                SharedPreferences Info = getSharedPreferences("ActivityOneInfo", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = Info.edit();
                if(cb1.isChecked()) {
                    editor.putBoolean("checked3", true);
                    editor.apply();
                }else{
                    editor.putBoolean("checked3", false);
                    editor.apply();
                }
            }
        });

    }
}
