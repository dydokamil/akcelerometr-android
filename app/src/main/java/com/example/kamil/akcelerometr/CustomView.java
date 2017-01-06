package com.example.kamil.akcelerometr;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by kamil on 06.01.17.
 */

public class CustomView extends View implements SensorEventListener {

    private Rect rectangle;
    private Paint paint;

    private TextView xText, yText, zText;
    private Sensor mySensor;
    private SensorManager sm;
    private float x, y;
    private int sideLength;
    private int w, h;

    public CustomView(Context context, SensorManager sm) {

        super(context);

        this.sm = sm;
        mySensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this, mySensor, SensorManager.SENSOR_DELAY_FASTEST);

        x = 50;
        y = 50;
        sideLength = 200;

        rectangle = new Rect((int) x, (int) y, sideLength, sideLength);

        paint = new Paint();
        paint.setColor(Color.BLACK);

    }

    @Override
    public void onDraw(Canvas canvas) {

        canvas.drawColor(Color.WHITE);
        canvas.drawRect(x, y, x + sideLength, y + sideLength, paint);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        this.w = w;
        this.h = h;
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (Math.abs(sensorEvent.values[0]) >= 0.8)
            if (x - sensorEvent.values[0] * 2 <= w - sideLength && x - sensorEvent.values[0] * 2 >= 0)
                x -= sensorEvent.values[0] * 2;
        if (Math.abs(sensorEvent.values[1]) >= 0.8)
            if (y + sensorEvent.values[0] * 2 <= h - sideLength && y + sensorEvent.values[0] * 2 >= 0)
                y += sensorEvent.values[1] * 2;
        invalidate();
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
