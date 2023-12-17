package com.akamai.botman;

import android.util.Pair;

/* loaded from: classes.dex */
public final class ad {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x018b  */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.util.Pair<java.lang.String, java.lang.Long> a(float[] r20, float r21) {
        /*
            Method dump skipped, instructions count: 407
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.akamai.botman.ad.a(float[], float):android.util.Pair");
    }

    private static float a(float f) {
        return Math.round(f * 100.0f) / 100.0f;
    }

    private static Pair<Float, Float> a(float[] fArr) {
        float f = fArr[0];
        float f2 = f;
        for (float f3 : fArr) {
            if (f3 < f) {
                f = f3;
            } else if (f3 > f2) {
                f2 = f3;
            }
        }
        return new Pair<>(Float.valueOf(f), Float.valueOf(f2));
    }
}
