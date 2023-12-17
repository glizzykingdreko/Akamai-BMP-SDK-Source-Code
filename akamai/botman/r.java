package com.akamai.botman;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings;
import java.util.Locale;
import java.util.UUID;

/* loaded from: classes.dex */
public final class r {
    public static String a(Application application) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Settings.Secure.getString(application.getContentResolver(), "android_id");
        }
        SharedPreferences sharedPreferences = application.getSharedPreferences("com.akamai.botman.preferences", 0);
        String string = sharedPreferences.getString("ifv", "-1");
        if (string == "-1") {
            String uuid = UUID.randomUUID().toString();
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("ifv", uuid);
            edit.commit();
            return uuid;
        }
        return string;
    }

    public static String a() {
        return "Akamai BMPSDK/3.3.0 (Android; " + Build.VERSION.RELEASE + "; " + Build.MANUFACTURER + "; " + Build.MODEL + "; " + Locale.getDefault().getLanguage() + ")";
    }
}
