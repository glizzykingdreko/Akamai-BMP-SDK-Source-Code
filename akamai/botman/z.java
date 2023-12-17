package com.akamai.botman;

import android.content.Context;
import android.content.SharedPreferences;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class z {
    private static final z c = new z();
    public WeakReference<Context> a = null;
    String b = null;

    public static z a() {
        return c;
    }

    private synchronized void b() {
        Context context = this.a.get();
        if (context == null) {
            ah.b("SensorDataCache", "loadData: Context is null", new Throwable[0]);
        } else {
            this.b = context.getSharedPreferences("com.akamai.botman.preferences", 0).getString("sensor_data", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c() {
        Context context = this.a.get();
        if (context == null) {
            ah.b("SensorDataCache", "saveData: Context is null", new Throwable[0]);
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences("com.akamai.botman.preferences", 0).edit();
        edit.putString("sensor_data", this.b);
        edit.commit();
    }

    public final synchronized void a(String str) {
        Context context = this.a.get();
        if (context == null) {
            ah.b("SensorDataCache", "savePoWResponse: Context is null", new Throwable[0]);
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences("com.akamai.botman.preferences", 0).edit();
        edit.putString("pow_response", str);
        edit.commit();
    }

    static /* synthetic */ void a(z zVar) {
        ah.a("SensorDataCache", "Initializing cache", new Throwable[0]);
        zVar.b();
    }
}
