package com.akamai.botman;

import android.os.SystemClock;
import kotlin.time.DurationKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o {
    public static String a() {
        int i;
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            int i2 = 1;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i2 >= 1000000) {
                    break;
                }
                if (((4508713 % i2) * 11) % i2 == 0) {
                    i3++;
                }
                if (i2 % 100 == 0 && SystemClock.uptimeMillis() - uptimeMillis > 2) {
                    break;
                }
                i4++;
                i2++;
            }
            int i5 = i4 / 100;
            long uptimeMillis2 = SystemClock.uptimeMillis();
            float f = 33.34f;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 1; i8 < 1000000; i8++) {
                f += i8;
                if ((19.239f * f) / 3.56f < 10000.0f) {
                    i6++;
                }
                if (i8 % 100 == 0 && SystemClock.uptimeMillis() - uptimeMillis2 > 2) {
                    break;
                }
                i7++;
            }
            int i9 = i7 / 100;
            long uptimeMillis3 = SystemClock.uptimeMillis();
            int i10 = 0;
            int i11 = 0;
            for (double d = 1.0d; d < 1000000.0d; d += 1.0d) {
                if (Math.sqrt(d) > 30.0d) {
                    i10++;
                }
                if (((int) d) % 100 == 0 && SystemClock.uptimeMillis() - uptimeMillis3 > 2) {
                    break;
                }
                i11++;
            }
            int i12 = i10;
            int i13 = i11 / 100;
            long uptimeMillis4 = SystemClock.uptimeMillis();
            int i14 = 1;
            int i15 = 0;
            int i16 = 0;
            for (i = DurationKt.NANOS_IN_MILLIS; i14 < i; i = DurationKt.NANOS_IN_MILLIS) {
                if (Math.acos(i14 / i) + Math.asin(i14 / i) + Math.atan(i14 / DurationKt.NANOS_IN_MILLIS) > 1.5d) {
                    i15++;
                }
                if (i14 % 100 == 0 && SystemClock.uptimeMillis() - uptimeMillis4 > 2) {
                    break;
                }
                i16++;
                i14++;
            }
            int i17 = i16 / 100;
            long uptimeMillis5 = SystemClock.uptimeMillis();
            int i18 = 0;
            for (int i19 = 1; i19 < 1000000 && SystemClock.uptimeMillis() - uptimeMillis5 <= 2; i19++) {
                i18++;
            }
            return i3 + "," + i5 + "," + i6 + "," + i9 + "," + i12 + "," + i13 + "," + i15 + "," + i17 + "," + i18;
        } catch (Exception e) {
            f.a(e);
            return "-1,-1,-1,-1,-1,-1,-1,-1,-1";
        }
    }
}
