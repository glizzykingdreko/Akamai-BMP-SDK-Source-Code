package com.akamai.botman;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class ag {
    public static long a(long j) {
        if (j == 0) {
            return 0L;
        }
        long j2 = j | (j >>> 1);
        long j3 = j2 | (j2 >>> 2);
        long j4 = j3 | (j3 >>> 4);
        long j5 = j4 | (j4 >>> 8);
        long j6 = j5 | (j5 >>> 16);
        return j6 - (j6 >>> 1);
    }

    public static String a(float[] fArr) {
        if (fArr == null) {
            return "(null)";
        }
        if (fArr.length == 0) {
            return "(empty)";
        }
        StringBuilder sb = new StringBuilder("(");
        for (int i = 0; i < fArr.length; i++) {
            if (i > 0) {
                sb.append(',');
            }
            sb.append(String.format("%.2f", Float.valueOf(fArr[i])));
        }
        sb.append(")");
        return sb.toString();
    }

    public static float a(float[] fArr, float f) {
        int length = fArr.length;
        Float[] fArr2 = new Float[length];
        for (int i = 0; i < length; i++) {
            fArr2[i] = Float.valueOf(Math.abs(fArr[i]));
        }
        Arrays.sort(fArr2);
        float floatValue = fArr2[(int) Math.floor((length - 1) * f)].floatValue();
        for (int i2 = 0; i2 < length; i2++) {
            if (Math.abs(fArr[i2]) < floatValue) {
                fArr[i2] = 0.0f;
            }
        }
        return floatValue;
    }

    public static String a(float[] fArr, float f, float f2) {
        int length = fArr.length;
        StringBuilder sb = new StringBuilder();
        float f3 = (f2 - f) / 60.0f;
        for (int i = 0; i < length; i++) {
            char floor = (char) (((int) Math.floor((fArr[i] - f) / f3)) + 65);
            if (fArr[i] == f2) {
                floor = '}';
            }
            if (floor == '\\') {
                floor = '.';
            } else if (floor == '.') {
                floor = '\\';
            }
            sb.append(floor);
        }
        return sb.toString();
    }
}
