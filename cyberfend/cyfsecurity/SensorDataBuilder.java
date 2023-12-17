package com.cyberfend.cyfsecurity;

import android.util.Pair;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class SensorDataBuilder {
    private static final SensorDataBuilder a = new SensorDataBuilder();

    public final native synchronized String buildN(ArrayList<Pair<String, String>> arrayList);

    public final native synchronized void initializeKeyN();

    SensorDataBuilder() {
    }

    static {
        System.loadLibrary("akamaibmp");
    }

    public static SensorDataBuilder a() {
        return a;
    }
}
