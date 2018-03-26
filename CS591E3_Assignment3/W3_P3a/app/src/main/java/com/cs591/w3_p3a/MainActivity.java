package com.cs591.w3_p3a;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.cs591.w3_p3a.R;

public class MainActivity extends AppCompatActivity {

    TextView tvCelsius, tvFahrenheit;
    SeekBar sbCelsius, sbFahrenheit;
    EditText edtCelsius, edtFahrenheit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCelsius = (TextView) findViewById(R.id.tvCelsius);
        tvFahrenheit = (TextView) findViewById(R.id.tvFahrenheit);

        sbCelsius = (SeekBar) findViewById(R.id.sbCelsius);
        sbFahrenheit = (SeekBar) findViewById(R.id.sbFahrenheit);
        sbCelsius.setMax(100);
        sbCelsius.setProgress(0);
        sbFahrenheit.setMax(212);
        sbFahrenheit.setProgress(32);

        edtCelsius = (EditText) findViewById(R.id.edtCelsius);
        edtFahrenheit = (EditText) findViewById(R.id.edtFahrenheit);

        edtCelsius.setText(Double.toString(0.0));
        edtFahrenheit.setText(Double.toString(convertCelsToFah(0.0)));

        sbCelsius.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            int progressCels;

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                progressCels = i;
                edtCelsius.setText(Double.toString(i));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                edtCelsius.setText(Double.toString(progressCels));
                double convFah = convertCelsToFah(progressCels);
                sbFahrenheit.setProgress((int)convFah);
                edtFahrenheit.setText(Double.toString(convFah));

            }
        });

        sbFahrenheit.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            int progressFah;

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                progressFah = i;
                edtFahrenheit.setText(Double.toString(i));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                edtFahrenheit.setText(Double.toString(progressFah));
                double convCels = convertFahToCels(progressFah);
                sbCelsius.setProgress((int)convCels);
                edtCelsius.setText(Double.toString(convCels));

            }
        });

    }

    protected double convertCelsToFah(double celsius) {
        return celsius * (9.0/5) + 32.0;
    }

    protected double convertFahToCels(double fahrenheit) {
        return (fahrenheit - 32) * (5.0/9);
    }

}
