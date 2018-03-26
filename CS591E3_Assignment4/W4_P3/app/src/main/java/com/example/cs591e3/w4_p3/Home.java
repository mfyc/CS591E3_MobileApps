package com.example.cs591e3.w4_p3;


import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    private GestureDetector mDetector;
    private TextView txtHome;

    // The following are used for the shake detection
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private ShakeDetector mShakeDetector;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        mDetector = new GestureDetector(this, new GestureListener());
        txtHome = (TextView)findViewById(R.id.tvHome);


        // ShakeDetector initialization
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager
                .getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new ShakeDetector();
        mShakeDetector.setOnShakeListener(new ShakeDetector.OnShakeListener() {

            @Override
            public void onShake(int count) {
				/*
				 * The following method, "handleShakeEvent(count):" is a stub //
				 * method you would use to setup whatever you want done once the
				 * device has been shook.
				 */
                Animation anim = AnimationUtils.loadAnimation(Home.this, R.anim.shake);
                txtHome.startAnimation(anim);
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        this.mDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    // For shake event
    @Override
    public void onResume() {
        super.onResume();
        // Add the following line to register the Session Manager Listener onResume
        mSensorManager.registerListener(mShakeDetector, mAccelerometer,	SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onPause() {
        // Add the following line to unregister the Sensor Manager onPause
        mSensorManager.unregisterListener(mShakeDetector);
        super.onPause();
    }

    // Register different swipes to their activities
    private void onSwipeLeft() {
        Toast t = Toast.makeText(this, "Left swipe", Toast.LENGTH_LONG);
        t.show();
        Intent intent = new Intent(Home.this,WestActivity.class);
        startActivity(intent);
    }

    private void onSwipeRight() {
        Toast t = Toast.makeText(this, "Right swipe", Toast.LENGTH_LONG);
        t.show();
        Intent intent = new Intent(Home.this, EastActivity.class);
        startActivity(intent);
    }

    private void onSwipeTop() {
        Toast t = Toast.makeText(this, "Up swipe", Toast.LENGTH_LONG);
        t.show();
        Intent intent = new Intent(Home.this, NorthActivity.class);
        startActivity(intent);
    }

    private void onSwipeBottom() {
        Toast t = Toast.makeText(this, "Down swipe", Toast.LENGTH_LONG);
        t.show();
        Intent intent = new Intent(Home.this, SouthActivity.class);
        startActivity(intent);
    }

    class GestureListener extends GestureDetector.SimpleOnGestureListener {
        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            boolean result = false;
            try {
                float diffY = e2.getY() - e1.getY();
                float diffX = e2.getX() - e1.getX();
                if (Math.abs(diffX) > Math.abs(diffY)) {
                    if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffX > 0) {
                            onSwipeRight();
                        } else {
                            onSwipeLeft();
                        }
                        result = true;
                    }
                }
                else if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffY > 0) {
                        onSwipeBottom();
                    } else {
                        onSwipeTop();
                    }
                    result = true;
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            return result;
        }
    }
}
