package com.akamai.botman;

import android.os.SystemClock;

/* loaded from: classes.dex */
public final class d {
    public static long a = System.currentTimeMillis();
    public static String b = "sensor_data";
    public static long c = 0;
    public static int d = 0;
    public static int e = 0;
    public static long f = 0;
    public static int g = -1;

    public static void a() {
        ah.a("Constants", "Resetting values", new Throwable[0]);
        c = SystemClock.uptimeMillis();
        a = System.currentTimeMillis();
    }
}
