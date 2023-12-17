package com.akamai.botman;

import com.bumptech.glide.load.Key;
import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
public final class q {
    public static int a(String str) {
        if (str == null || str.trim().equalsIgnoreCase("")) {
            return -1;
        }
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            try {
                char charAt = str.charAt(i2);
                if (charAt < 128) {
                    i += charAt;
                }
            } catch (Exception unused) {
                return -2;
            }
        }
        return i;
    }

    public static long b(String str) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    public static String c(String str) {
        try {
            byte[] bytes = str.getBytes(Key.STRING_CHARSET_NAME);
            StringBuffer stringBuffer = new StringBuffer(bytes.length);
            for (byte b : bytes) {
                if (b >= 33 && b <= 126 && b != 34 && b != 37 && b != 39 && b != 44 && b != 92) {
                    stringBuffer.append((char) b);
                }
                stringBuffer.append('%');
                char forDigit = Character.forDigit((b >> 4) & 15, 16);
                if (Character.isLetter(forDigit)) {
                    forDigit = (char) (forDigit - ' ');
                }
                stringBuffer.append(forDigit);
                char forDigit2 = Character.forDigit(b & 15, 16);
                if (Character.isLetter(forDigit2)) {
                    forDigit2 = (char) (forDigit2 - ' ');
                }
                stringBuffer.append(forDigit2);
            }
            return stringBuffer.toString();
        } catch (UnsupportedEncodingException unused) {
            return "utf8-encode-err";
        }
    }
}
