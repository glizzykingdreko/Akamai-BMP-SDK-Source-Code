package com.akamai.botman;

import android.app.Activity;
import android.app.Application;
import java.util.HashMap;

/* loaded from: classes.dex */
public class CYFMonitor {
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int NONE = 15;
    public static final int WARN = 5;
    private static final String a = "CYFMonitor";

    /* loaded from: classes.dex */
    public interface ChallengeActionCallback {
        void onChallengeActionCancel();

        void onChallengeActionFailure(String str);

        void onChallengeActionSuccess();
    }

    public static synchronized void initialize(Application application) {
        synchronized (CYFMonitor.class) {
            com.cyberfend.cyfsecurity.CYFMonitor.initialize(application);
        }
    }

    public static synchronized void initialize(Application application, String str) {
        synchronized (CYFMonitor.class) {
            com.cyberfend.cyfsecurity.CYFMonitor.initialize(application, str);
        }
    }

    public static synchronized void configureChallengeAction(Application application, String str) {
        synchronized (CYFMonitor.class) {
            if (str != null) {
                if (str.length() > 0) {
                    x.a().b(application, str);
                }
            }
        }
    }

    public static synchronized void enableBackground() {
        synchronized (CYFMonitor.class) {
            com.cyberfend.cyfsecurity.CYFMonitor.enableBackground();
        }
    }

    public static synchronized String getSensorData() {
        String sensorData;
        synchronized (CYFMonitor.class) {
            sensorData = com.cyberfend.cyfsecurity.CYFMonitor.getSensorData();
        }
        return sensorData;
    }

    public static void setLogLevel(int i) {
        com.cyberfend.cyfsecurity.CYFMonitor.setLogLevel(i);
    }

    public static HashMap<Integer, String> collectTestData() {
        return com.cyberfend.cyfsecurity.CYFMonitor.collectTestData();
    }

    public static boolean showChallengeAction(Activity activity, String str, int i, int i2, int i3, ChallengeActionCallback challengeActionCallback) {
        return showChallengeAction(activity, str, activity.getString(i), activity.getString(i2), activity.getString(i3), challengeActionCallback);
    }

    public static boolean showChallengeAction(Activity activity, String str, String str2, String str3, String str4, ChallengeActionCallback challengeActionCallback) {
        return a.a().a(activity, str2, str3, str4, challengeActionCallback, str);
    }
}
