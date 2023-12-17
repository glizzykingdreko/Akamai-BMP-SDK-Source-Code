package com.akamai.botman;

import android.util.Log;

/* loaded from: classes.dex */
public final class ah {
    public static final ah a = new ah();
    public int b = 5;

    private void a(int i, String str, String str2, Throwable... thArr) {
        if (i < this.b) {
            return;
        }
        if (thArr.length > 0) {
            a(i, str, str2 + '\n' + Log.getStackTraceString(thArr[0]));
            return;
        }
        a(i, str, str2);
    }

    private static void a(int i, String str, String str2) {
        String concat = "BMP:".concat(String.valueOf(str));
        if (str2.length() > 4000) {
            int length = str2.length() / 4000;
            int i2 = 0;
            while (i2 <= length) {
                int i3 = i2 + 1;
                int i4 = i3 * 4000;
                if (i4 >= str2.length()) {
                    Log.println(i, concat, "Part " + i2 + ": " + str2.substring(i2 * 4000));
                } else {
                    Log.println(i, concat, "Part " + i2 + ": " + str2.substring(i2 * 4000, i4));
                }
                i2 = i3;
            }
            return;
        }
        Log.println(i, concat, str2);
    }

    public static void a(String str, String str2, Throwable... thArr) {
        a.a(4, str, str2, thArr);
    }

    public static void b(String str, String str2, Throwable... thArr) {
        a.a(5, str, str2, thArr);
    }

    public static void c(String str, String str2, Throwable... thArr) {
        a.a(6, str, str2, thArr);
    }
}
