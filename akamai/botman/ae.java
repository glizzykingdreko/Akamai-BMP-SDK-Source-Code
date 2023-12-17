package com.akamai.botman;

/* loaded from: classes.dex */
public final class ae {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(float[] fArr, int i, int i2, float[] fArr2) {
        if (i2 == 1) {
            return;
        }
        int i3 = i2 / 2;
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i + i4;
            float f = fArr[i5];
            float f2 = fArr[((i + i2) - 1) - i4];
            fArr2[i5] = f + f2;
            fArr2[i5 + i3] = (f - f2) / (((float) Math.cos(((i4 + 0.5d) * 3.141592653589793d) / i2)) * 2.0f);
        }
        a(fArr2, i, i3, fArr);
        int i6 = i + i3;
        a(fArr2, i6, i3, fArr);
        for (int i7 = 0; i7 < i3 - 1; i7++) {
            int i8 = (i7 * 2) + i;
            int i9 = i + i7;
            fArr[i8 + 0] = fArr2[i9];
            int i10 = i9 + i3;
            fArr[i8 + 1] = fArr2[i10] + fArr2[i10 + 1];
        }
        int i11 = i + i2;
        fArr[i11 - 2] = fArr2[i6 - 1];
        int i12 = i11 - 1;
        fArr[i12] = fArr2[i12];
    }
}
