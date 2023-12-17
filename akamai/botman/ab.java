package com.akamai.botman;

import android.os.SystemClock;

/* loaded from: classes.dex */
public final class ab {
    public static long a(long j, int i) {
        long uptimeMillis = SystemClock.uptimeMillis();
        int i2 = (int) j;
        int i3 = (int) (j >> 32);
        int i4 = 0;
        while (i4 < 16) {
            i4++;
            int i5 = i2;
            i2 = i3 ^ (((i << i4) | (i >>> (32 - i4))) ^ i2);
            i3 = i5;
        }
        long j2 = (i3 << 32) | (i2 & 4294967295L);
        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
        ah.a("FeistelCipher", "FeistelCipherEncode-Time: " + uptimeMillis2 + "ms", new Throwable[0]);
        return j2;
    }
}
