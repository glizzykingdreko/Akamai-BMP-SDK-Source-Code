package com.akamai.botman;

/* loaded from: classes.dex */
public final class af {
    public static String a(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            char charAt = str.charAt(i);
            int i3 = 1;
            while (i2 < length && charAt == str.charAt(i2)) {
                i3++;
                i2++;
            }
            if (i3 > 1) {
                sb.append(String.valueOf(i3));
            }
            sb.append(charAt);
            i = i2;
        }
        return sb.toString();
    }
}
