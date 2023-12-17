package com.cyberfend.cyfsecurity;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.ViewGroup;
import androidx.core.app.NotificationCompat;
import com.akamai.botman.ah;
import com.akamai.botman.b;
import com.akamai.botman.d;
import com.akamai.botman.e;
import com.akamai.botman.f;
import com.akamai.botman.h;
import com.akamai.botman.q;
import com.akamai.botman.r;
import com.akamai.botman.y;
import com.akamai.botman.z;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Locale;

@Deprecated
/* loaded from: classes.dex */
public class CYFMonitor {
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int NONE = 15;
    public static final int WARN = 5;
    private static h a;
    private static boolean b;
    private static boolean c;
    private static boolean d;
    private static boolean e;

    @Deprecated
    public static void setAccessSensorDataFromBackground(boolean z) {
    }

    @Deprecated
    public static void setApiKey(String str) {
    }

    static {
        Log.i("CYFMonitor", "Initializing Akamai BMP SDK Version 3.3.0");
        final SensorDataBuilder a2 = SensorDataBuilder.a();
        new Thread(new Runnable() { // from class: com.cyberfend.cyfsecurity.SensorDataBuilder.1
            @Override // java.lang.Runnable
            public final void run() {
                SensorDataBuilder.this.initializeKeyN();
            }
        }).start();
        a = new h();
        b = false;
        c = false;
        d = false;
        e = false;
    }

    public static synchronized void initialize(Application application) {
        synchronized (CYFMonitor.class) {
            initialize(application, "");
        }
    }

    public static synchronized void initialize(Application application, String str) {
        synchronized (CYFMonitor.class) {
            Log.i("CYFMonitor", "Initializing Akamai BMP Monitor");
            if (d) {
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            ah.a("CYFMonitor", "Registering activity lifecycle callbacks", new Throwable[0]);
            final z a2 = z.a();
            a2.a = new WeakReference<>(application);
            new Thread(new Runnable() { // from class: com.akamai.botman.z.1
                @Override // java.lang.Runnable
                public final void run() {
                    z.a(z.this);
                }
            }).start();
            a(application);
            a.c(application);
            a.b(application);
            a.a(application);
            application.registerActivityLifecycleCallbacks(new b());
            d = true;
            c = true;
            if (str != null && str.length() > 0) {
                y.g().a(application, str);
            }
            ah.a("CYFMonitor", "Initialize-Time: " + (SystemClock.uptimeMillis() - uptimeMillis) + "ms", new Throwable[0]);
        }
    }

    public static synchronized String getSensorData() {
        String a2;
        synchronized (CYFMonitor.class) {
            a2 = a.a();
        }
        return a2;
    }

    public static void setLogLevel(int i) {
        if ((i < 4 || i > 6) && i != 15) {
            ah.c("CYFMonitor", "Invalid log level specified in setLogLevel(), ignoring.", new Throwable[0]);
        } else {
            ah.a.b = i;
        }
    }

    @Deprecated
    public static synchronized void startCollectingSensorData(Activity activity) {
        synchronized (CYFMonitor.class) {
            if (c) {
                return;
            }
            Application application = activity.getApplication();
            a(application);
            a.c(application);
            a.b(application);
            a.a(application);
            a(activity);
        }
    }

    @Deprecated
    public static synchronized void stopCollectingSensorData() {
        synchronized (CYFMonitor.class) {
            if (c) {
                return;
            }
            a();
        }
    }

    public static synchronized void enableBackground() {
        synchronized (CYFMonitor.class) {
            h.b();
        }
    }

    public static void setActivityVisible(boolean z) {
        e = z;
    }

    public static boolean isActivityVisible() {
        return e;
    }

    public static void a(Activity activity) {
        try {
            ah.a("CYFMonitor", "Start collecting sensor data", new Throwable[0]);
            if (d.c == 0) {
                d.c = SystemClock.uptimeMillis();
            }
            if (d.a == 0) {
                d.a = System.currentTimeMillis();
            }
            a.e();
            a.c();
            if (h.a(activity.getWindow())) {
                return;
            }
            a.b(activity.getWindow());
            a.a((ViewGroup) activity.findViewById(16908290));
        } catch (Exception e2) {
            new Throwable[1][0] = e2;
        }
    }

    public static void a() {
        try {
            ah.a("CYFMonitor", "Stop collecting sensor data", new Throwable[0]);
            a.f();
            a.d();
        } catch (Exception e2) {
            new Throwable[1][0] = e2;
        }
    }

    private static synchronized void a(Application application) {
        long j;
        boolean z;
        Pair pair;
        int i;
        synchronized (CYFMonitor.class) {
            if (!b && application != null) {
                try {
                    new r();
                    long uptimeMillis = SystemClock.uptimeMillis();
                    ah.a("SystemInfoListener", "Getting system information", new Throwable[0]);
                    if (application != null) {
                        application.getPackageManager();
                        DisplayMetrics displayMetrics = application.getResources().getDisplayMetrics();
                        int i2 = displayMetrics.heightPixels;
                        int i3 = displayMetrics.widthPixels;
                        Intent registerReceiver = application.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                        int i4 = 2;
                        if (registerReceiver == null) {
                            pair = new Pair(Boolean.FALSE, 0);
                        } else {
                            int intExtra = registerReceiver.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
                            if (intExtra != 2 && intExtra != 5) {
                                z = false;
                                pair = new Pair(Boolean.valueOf(z), Integer.valueOf(registerReceiver.getIntExtra("level", -1)));
                            }
                            z = true;
                            pair = new Pair(Boolean.valueOf(z), Integer.valueOf(registerReceiver.getIntExtra("level", -1)));
                        }
                        if (application.getResources().getConfiguration().orientation == 1) {
                            i4 = 1;
                        } else if (application.getResources().getConfiguration().orientation != 2) {
                            i4 = -1;
                        }
                        String language = Locale.getDefault().getLanguage();
                        String str = Build.VERSION.RELEASE;
                        int i5 = Settings.System.getInt(application.getContentResolver(), "accelerometer_rotation", 0) == 1 ? 1 : 0;
                        String str2 = Build.MODEL;
                        String str3 = Build.BOOTLOADER;
                        String str4 = Build.HARDWARE;
                        String packageName = application.getPackageName();
                        String a2 = r.a(application);
                        int i6 = application.getResources().getConfiguration().keyboard != 1 ? 1 : 0;
                        j = uptimeMillis;
                        int i7 = Settings.Global.getInt(application.getContentResolver(), "adb_enabled", 0);
                        String str5 = "-1";
                        String str6 = "-1";
                        String str7 = "-1";
                        String str8 = "-1";
                        String str9 = "-1";
                        String str10 = "-1";
                        String str11 = "-1";
                        String str12 = "-1";
                        String str13 = "-1";
                        String str14 = "-1";
                        String str15 = "-1";
                        String str16 = "-1";
                        String str17 = "-1";
                        String str18 = "-1";
                        try {
                            str5 = Build.VERSION.CODENAME;
                            str6 = Build.VERSION.INCREMENTAL;
                            i = Build.VERSION.SDK_INT;
                            try {
                                str7 = Build.MANUFACTURER;
                                str8 = Build.PRODUCT;
                                str9 = Build.TAGS;
                                str10 = Build.TYPE;
                                str11 = Build.USER;
                                str12 = Build.DISPLAY;
                                str13 = Build.BOARD;
                                str14 = Build.BRAND;
                                str15 = Build.DEVICE;
                                str16 = Build.FINGERPRINT;
                                str17 = Build.HOST;
                                str18 = Build.ID;
                            } catch (Exception unused) {
                            }
                        } catch (Exception unused2) {
                            i = -1;
                        }
                        String str19 = str6;
                        int i8 = i;
                        StringBuilder sb = new StringBuilder("-1,uaend,-1,");
                        sb.append(i2);
                        sb.append(",");
                        sb.append(i3);
                        sb.append(",");
                        sb.append(((Boolean) pair.first).booleanValue() ? 1 : 0);
                        sb.append(",");
                        sb.append(pair.second);
                        sb.append(",");
                        sb.append(i4);
                        sb.append(",");
                        sb.append(q.c(language));
                        sb.append(",");
                        sb.append(q.c(str));
                        sb.append(",");
                        sb.append(i5);
                        sb.append(",");
                        sb.append(q.c(str2));
                        sb.append(",");
                        sb.append(q.c(str3));
                        sb.append(",");
                        sb.append(q.c(str4));
                        sb.append(",");
                        sb.append(q.c("-1"));
                        sb.append(",");
                        sb.append(packageName);
                        sb.append(",");
                        sb.append(q.c("-1"));
                        sb.append(",-1,");
                        sb.append(a2);
                        sb.append(",-1,");
                        sb.append(i6);
                        sb.append(",");
                        sb.append(i7);
                        sb.append(",");
                        sb.append(q.c(str5));
                        sb.append(",");
                        sb.append(q.c(str19));
                        sb.append(",");
                        sb.append(i8);
                        sb.append(",");
                        sb.append(q.c(str7));
                        sb.append(",");
                        sb.append(q.c(str8));
                        sb.append(",");
                        sb.append(q.c(str9));
                        sb.append(",");
                        sb.append(q.c(str10));
                        sb.append(",");
                        sb.append(q.c(str11));
                        sb.append(",");
                        sb.append(q.c(str12));
                        sb.append(",");
                        sb.append(q.c(str13));
                        sb.append(",");
                        sb.append(q.c(str14));
                        sb.append(",");
                        sb.append(q.c(str15));
                        sb.append(",");
                        sb.append(q.c(str16));
                        sb.append(",");
                        sb.append(q.c(str17));
                        sb.append(",");
                        sb.append(q.c(str18));
                        String sb2 = sb.toString();
                        ah.a("SystemInfoListener", "System Info: ".concat(String.valueOf(sb2)), new Throwable[0]);
                        e.b = sb2;
                    } else {
                        j = uptimeMillis;
                    }
                    d.f = SystemClock.uptimeMillis() - j;
                    ah.a("CYFSystemInfoManager", "DeviceInfo-Time: " + d.f + "ms", new Throwable[0]);
                    b = true;
                } catch (Exception e2) {
                    e2.getMessage();
                    f.a(e2);
                }
            }
        }
    }

    public static HashMap<Integer, String> collectTestData() {
        try {
            h hVar = a;
            HashMap<Integer, String> hashMap = new HashMap<>();
            hashMap.put(0, Long.toString(hVar.d.d));
            hashMap.put(1, Integer.toString(hVar.d.b));
            hashMap.put(2, Integer.toString(50));
            hashMap.put(3, Integer.toString(hVar.d.c));
            hashMap.put(4, Integer.toString(50));
            hashMap.put(5, Long.toString(hVar.b.d.size()));
            hashMap.put(6, Integer.toString(0));
            hashMap.put(7, Integer.toString(128));
            hashMap.put(8, Long.toString(hVar.c.d.size()));
            hashMap.put(9, Integer.toString(0));
            hashMap.put(10, Integer.toString(128));
            if (hVar.a != null) {
                hashMap.put(11, Long.toString(hVar.a.f));
                hashMap.put(12, Integer.toString(hVar.a.e));
            } else {
                hashMap.put(11, Integer.toString(0));
                hashMap.put(12, Integer.toString(0));
            }
            hashMap.put(13, Integer.toString(9));
            hashMap.put(14, y.g().g);
            return hashMap;
        } catch (Exception unused) {
            return null;
        }
    }
}
