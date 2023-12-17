package com.akamai.botman;

import android.app.Application;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import java.util.Observable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m extends Observable implements SensorEventListener {
    private SensorManager b;
    private Sensor c;
    private Sensor d;
    private Sensor e;
    private HandlerThread f;
    private boolean g = false;
    private boolean h = false;
    private boolean i = false;
    private boolean j = false;
    private boolean k = false;
    boolean a = false;
    private long l = 0;
    private float[] m = new float[3];
    private float[] n = new float[3];

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Application application) {
        try {
            this.b = (SensorManager) application.getSystemService("sensor");
        } catch (NullPointerException e) {
            ah.c("OrientationListener", "Exception on getting sensor service", e);
            f.a(e);
        }
    }

    public final boolean a() throws Exception {
        this.c = this.b.getDefaultSensor(1);
        this.d = this.b.getDefaultSensor(2);
        HandlerThread handlerThread = new HandlerThread("CYFOrientationListener");
        this.f = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(this.f.getLooper());
        this.g = this.b.registerListener(this, this.c, 3, handler);
        this.h = this.b.registerListener(this, this.d, 3, handler);
        Sensor defaultSensor = this.b.getDefaultSensor(9);
        this.e = defaultSensor;
        boolean registerListener = this.b.registerListener(this, defaultSensor, 3, handler);
        this.i = registerListener;
        if (registerListener) {
            this.b.unregisterListener(this, this.c);
            this.g = false;
            d.g = 1;
        } else {
            d.g = 0;
        }
        this.l = SystemClock.uptimeMillis();
        if ((this.g || this.i) && this.h) {
            return true;
        }
        ah.c("OrientationListener", "Failed to register orientation listener", new Throwable[0]);
        b();
        return false;
    }

    public final void b() throws Exception {
        if (this.h) {
            this.b.unregisterListener(this, this.d);
            this.h = false;
        }
        if (this.i) {
            this.b.unregisterListener(this, this.e);
            this.i = false;
        }
        if (this.g) {
            this.b.unregisterListener(this, this.c);
            this.g = false;
        }
        this.a = false;
        HandlerThread handlerThread = this.f;
        if (handlerThread == null || !handlerThread.isAlive()) {
            return;
        }
        this.f.quitSafely();
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (!this.a && sensorEvent.accuracy == 0) {
                ah.b("OrientationListener", "Unreliable orientation sensor data...", new Throwable[0]);
                this.a = true;
            }
            int type = sensorEvent.sensor.getType();
            if (type == 9) {
                this.m = (float[]) sensorEvent.values.clone();
                this.j = true;
            } else if (type == 1) {
                this.m = (float[]) sensorEvent.values.clone();
                this.j = true;
            } else if (type == 2) {
                this.n = (float[]) sensorEvent.values.clone();
                this.k = true;
            }
            if (this.j && this.k) {
                long j = sensorEvent.timestamp;
                if (uptimeMillis - this.l >= 100 || d.e == 1) {
                    boolean z = d.e != 0;
                    d.e = 0;
                    this.l = uptimeMillis;
                    setChanged();
                    notifyObservers(new l(this.m, this.n, this.l, z ? 2 : 1));
                    this.j = false;
                    this.k = false;
                }
            }
        } catch (Exception e) {
            ah.b("OrientationListener", "Exception in processing orientation event", e);
            f.a(e);
        }
    }
}
