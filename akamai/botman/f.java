package com.akamai.botman;

import android.util.Log;
import com.adobe.marketing.mobile.analytics.internal.AnalyticsConstants;

/* loaded from: classes.dex */
public final class f {
    public static void a(Exception exc) {
        try {
            if (e.c.length() < 10000) {
                StringBuilder sb = new StringBuilder();
                sb.append(e.c);
                sb.append(";");
                String stackTraceString = Log.getStackTraceString(exc);
                if (stackTraceString != null && stackTraceString.length() > 500) {
                    stackTraceString = stackTraceString.substring(0, AnalyticsConstants.Default.DEFAULT_LAUNCH_DEEPLINK_DATA_WAIT_TIMEOUT);
                }
                sb.append(q.c(stackTraceString));
                e.c = sb.toString();
            }
        } catch (Exception unused) {
        }
    }
}
