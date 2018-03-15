package com.example.ray.w5_p2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements BlankFragment.ControlFragmentListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void changePicture(int currDrawableIndex){
        DrawableFragment drawableFragment = (DrawableFragment)getSupportFragmentManager().findFragmentById(R.id.fragment_drawable);
        drawableFragment.changePicture(currDrawableIndex);
    }
}
