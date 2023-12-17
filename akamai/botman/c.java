package com.akamai.botman;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Pair;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c implements Application.ActivityLifecycleCallbacks {
    private ArrayList<Pair<String, Long>> a = new ArrayList<>();

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        if (this.a.size() < 10) {
            this.a.add(new Pair<>(ExifInterface.GPS_MEASUREMENT_2D, Long.valueOf(System.currentTimeMillis())));
        }
        ah.a("BackgroundEventManager", "Activity paused: " + activity.getLocalClassName(), new Throwable[0]);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        if (this.a.size() < 10) {
            this.a.add(new Pair<>(ExifInterface.GPS_MEASUREMENT_3D, Long.valueOf(System.currentTimeMillis())));
        }
        ah.a("BackgroundEventManager", "Activity resumed: " + activity.getLocalClassName(), new Throwable[0]);
    }

    public final String a() {
        Iterator<Pair<String, Long>> it = this.a.iterator();
        String str = "";
        while (it.hasNext()) {
            Pair<String, Long> next = it.next();
            str = str + ((String) next.first) + "," + next.second + ";";
        }
        this.a.clear();
        return str;
    }
}
