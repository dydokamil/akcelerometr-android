package com.example.kamil.akcelerometr;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        SensorManager sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        setContentView(new CustomView(this, sm));
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        /*xText.setText("X: " + sensorEvent.values[0]);
        yText.setText("Y: " + sensorEvent.values[1]);
        zText.setText("Z: " + sensorEvent.values[2]);*/
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
