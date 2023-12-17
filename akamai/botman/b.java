package com.akamai.botman;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: classes.dex */
public final class b implements Application.ActivityLifecycleCallbacks {
    private int a = 0;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        ah.a("LifecycleCallbacks", "Activity Created: " + activity.getLocalClassName(), new Throwable[0]);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        ah.a("LifecycleCallbacks", "Activity Destroyed: " + activity.getLocalClassName(), new Throwable[0]);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        ah.a("LifecycleCallbacks", "Activity Paused: " + activity.getLocalClassName(), new Throwable[0]);
        int i = this.a + (-1);
        this.a = i;
        if (i == 0) {
            com.cyberfend.cyfsecurity.CYFMonitor.a();
            com.cyberfend.cyfsecurity.CYFMonitor.setActivityVisible(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        ah.a("LifecycleCallbacks", "Activity Resumed:" + activity.getLocalClassName(), new Throwable[0]);
        if (this.a == 0) {
            com.cyberfend.cyfsecurity.CYFMonitor.a(activity);
            com.cyberfend.cyfsecurity.CYFMonitor.setActivityVisible(true);
        }
        this.a++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        ah.a("LifecycleCallbacks", "Activity Started:" + activity.getLocalClassName(), new Throwable[0]);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        ah.a("LifecycleCallbacks", "Activity Stopped:" + activity.getLocalClassName(), new Throwable[0]);
    }
}
