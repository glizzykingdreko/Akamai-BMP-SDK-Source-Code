package com.akamai.botman;

import android.app.Application;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.HandlerThread;
import android.os.SystemClock;
import java.util.Observable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i extends Observable implements SensorEventListener {
    SensorManager a;
    Sensor b;
    Sensor c;
    HandlerThread d;
    long e = 0;
    boolean f = false;
    boolean g = false;
    boolean h = false;
    boolean i = false;
    boolean j = false;
    private float m = -1.0f;
    private float n = -1.0f;
    private float o = -1.0f;
    private float p = -1.0f;
    private float q = -1.0f;
    private float r = -1.0f;
    private float s = -1.0f;
    private float t = -1.0f;
    private float u = -1.0f;
    float k = 0.0f;
    private final float[] v = {0.0f, 0.0f, 0.0f};
    int l = 0;

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public i(Application application) {
        try {
            this.a = (SensorManager) application.getSystemService("sensor");
        } catch (Exception e) {
            ah.c("MotionListener", "Exception on getting sensor service", e);
            f.a(e);
        }
    }

    public final void a() throws Exception {
        if (this.g) {
            this.a.unregisterListener(this, this.c);
            this.g = false;
        }
        if (this.f) {
            this.a.unregisterListener(this, this.b);
            this.f = false;
        }
        this.j = false;
        HandlerThread handlerThread = this.d;
        if (handlerThread == null || !handlerThread.isAlive()) {
            return;
        }
        this.d.quitSafely();
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        k kVar;
        k kVar2;
        int i;
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (!this.j && sensorEvent.accuracy == 0) {
                ah.b("MotionListener", "Unreliable motion sensors data...", new Throwable[0]);
                this.j = true;
            }
            int type = sensorEvent.sensor.getType();
            if (type == 4) {
                if (this.g) {
                    this.s = sensorEvent.values[0];
                    this.t = sensorEvent.values[1];
                    this.u = sensorEvent.values[2];
                    this.h = true;
                }
            } else if (type == 1 && this.f) {
                this.m = sensorEvent.values[0];
                this.n = sensorEvent.values[1];
                this.o = sensorEvent.values[2];
                float[] fArr = sensorEvent.values;
                int i2 = this.l + 1;
                this.l = i2;
                float nanoTime = 1.0f / (i2 / ((((float) System.nanoTime()) - this.k) / 1.0E9f));
                float f = 0.18f / (((Float.isNaN(nanoTime) || Float.isInfinite(nanoTime)) ? 0.0f : 0.0f) + 0.18f);
                float[] fArr2 = this.v;
                float f2 = 1.0f - f;
                fArr2[0] = (fArr2[0] * f) + (fArr[0] * f2);
                fArr2[1] = (fArr2[1] * f) + (fArr[1] * f2);
                fArr2[2] = (f * fArr2[2]) + (f2 * fArr[2]);
                float[] fArr3 = {0.0f, 0.0f, 0.0f};
                float f3 = fArr[0] - fArr2[0];
                fArr3[0] = f3;
                fArr3[1] = fArr[1] - fArr2[1];
                fArr3[2] = fArr[2] - fArr2[2];
                if (Float.isNaN(f3) || Float.isInfinite(fArr3[0])) {
                    fArr3[0] = 0.0f;
                }
                if (Float.isNaN(fArr3[1]) || Float.isInfinite(fArr3[1])) {
                    fArr3[1] = 0.0f;
                }
                if (Float.isNaN(fArr3[2]) || Float.isInfinite(fArr3[2])) {
                    fArr3[2] = 0.0f;
                }
                float f4 = fArr3[0];
                float f5 = fArr3[1];
                float f6 = fArr3[2];
                this.m *= -1.0f;
                this.n *= -1.0f;
                this.o *= -1.0f;
                this.p = f4 * (-1.0f);
                this.q = f5 * (-1.0f);
                this.r = f6 * (-1.0f);
                this.i = true;
            }
            if (this.h && this.i) {
                if (uptimeMillis - this.e >= 100 || d.d == 1) {
                    this.e = uptimeMillis;
                    boolean z = d.d != 0;
                    d.d = 0;
                    setChanged();
                    float f7 = this.m;
                    float f8 = this.n;
                    float f9 = this.o;
                    float f10 = this.p;
                    float f11 = this.q;
                    float f12 = this.r;
                    float f13 = this.s;
                    float f14 = this.t;
                    float f15 = this.u;
                    long j = this.e;
                    if (z) {
                        kVar2 = kVar;
                        i = 2;
                    } else {
                        kVar2 = kVar;
                        i = 1;
                    }
                    new k(f7, f8, f9, f10, f11, f12, f13, f14, f15, j, i);
                    notifyObservers(kVar2);
                    this.h = !this.g;
                    this.i = !this.f;
                }
            }
        } catch (Exception e) {
            ah.b("MotionListener", "Exception in processing motion event", e);
            f.a(e);
        }
    }
}
