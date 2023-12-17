package com.akamai.botman;

import android.app.Application;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import com.facebook.imageutils.JfifUtil;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class h {
    private static final ArrayList<Integer> f = new ArrayList<>();
    private static boolean h = false;
    public t a = null;
    public j b = null;
    public n c = null;
    public v d = null;
    private c e = null;
    private AtomicBoolean g = new AtomicBoolean(false);
    private boolean i = false;

    /* JADX WARN: Can't wrap try/catch for region: R(42:12|(2:113|114)|14|(1:16)|17|(1:19)|20|21|(3:25|(1:27)(1:38)|(7:29|(1:31)|32|33|34|35|36))|39|(1:41)|42|(1:44)(2:108|(1:110)(1:111))|45|46|47|(1:49)(2:105|(1:107))|50|51|(1:53)(1:104)|54|(1:56)(1:103)|57|(1:59)(1:102)|60|(1:101)|64|65|66|(3:68|(1:72)|73)|74|(3:76|(1:80)|81)|82|(2:84|(3:86|(1:90)|91))|92|(1:94)|95|96|33|34|35|36) */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0512, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0514, code lost:
        r0.getMessage();
        com.akamai.botman.f.a(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized java.lang.String a() {
        /*
            Method dump skipped, instructions count: 1373
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.akamai.botman.h.a():java.lang.String");
    }

    private void g() {
        Objects.toString(Thread.currentThread());
        if (com.cyberfend.cyfsecurity.CYFMonitor.isActivityVisible()) {
            f();
            d();
            e();
            c();
        }
    }

    public static synchronized boolean a(Window window) throws Exception {
        synchronized (h.class) {
            int hashCode = window.hashCode();
            int i = 0;
            while (true) {
                ArrayList<Integer> arrayList = f;
                if (i < arrayList.size()) {
                    if (hashCode == arrayList.get(i).intValue()) {
                        return true;
                    }
                    i++;
                } else {
                    arrayList.add(Integer.valueOf(hashCode));
                    return false;
                }
            }
        }
    }

    public final void a(ViewGroup viewGroup) {
        try {
            ArrayList<View> a = p.a(viewGroup);
            for (int i = 0; i < a.size(); i++) {
                View view = a.get(i);
                if (view instanceof EditText) {
                    if (!this.i) {
                        this.a = new t();
                        this.i = true;
                    }
                    view.toString();
                    t tVar = this.a;
                    EditText editText = (EditText) view;
                    ah.a("TextChangeManager", "Listening on edit text: " + editText.getId(), new Throwable[0]);
                    int a2 = q.a(String.valueOf(editText.getId()));
                    if (!e.a.toLowerCase().contains(Integer.toString(a2).toLowerCase())) {
                        e.a += a2 + ";";
                    }
                    if ((editText.getInputType() & 129) != 129 && (editText.getInputType() & 18) != 18 && (editText.getInputType() & 145) != 145 && (editText.getInputType() & JfifUtil.MARKER_APP1) != 225) {
                        s sVar = new s(a2, false);
                        editText.addTextChangedListener(sVar);
                        sVar.addObserver(tVar.a);
                    }
                    s sVar2 = new s(a2, true);
                    editText.addTextChangedListener(sVar2);
                    sVar2.addObserver(tVar.a);
                }
            }
        } catch (Exception e) {
            ah.c("CYFManager", "Exception in creating text listener", e);
            f.a(e);
        }
    }

    public static void b() {
        u.a();
    }

    public final void b(Window window) {
        try {
            if (this.d == null) {
                this.d = new v();
            }
            v vVar = this.d;
            ah.a("TouchManager", "Listening on window", new Throwable[0]);
            vVar.a = SystemClock.uptimeMillis();
            vVar.b = 0;
            vVar.c = 0;
            u uVar = new u(window.getCallback());
            window.setCallback(uVar);
            uVar.addObserver(vVar);
        } catch (Exception e) {
            ah.c("CYFManager", "Exception in creating touch manager", e);
            f.a(e);
        }
    }

    public final synchronized void a(Application application) {
        if (this.c != null) {
            return;
        }
        this.c = new n(application);
    }

    public final void c() {
        Objects.toString(Thread.currentThread());
        try {
            this.c.a();
        } catch (Exception e) {
            ah.c("CYFManager", "Exception in starting orientation manager", e);
            f.a(e);
        }
    }

    public final synchronized void d() {
        Objects.toString(Thread.currentThread());
        try {
            this.c.b();
        } catch (Exception e) {
            ah.c("CYFManager", "Exception in stopping orientation manager", e);
            f.a(e);
        }
    }

    public final synchronized void b(Application application) {
        if (this.b != null) {
            return;
        }
        this.b = new j(application);
    }

    public final synchronized void e() {
        boolean z;
        Objects.toString(Thread.currentThread());
        try {
            j jVar = this.b;
            if (jVar.d.size() >= 128) {
                return;
            }
            if (jVar.f.get()) {
                return;
            }
            i iVar = jVar.a;
            iVar.b = iVar.a.getDefaultSensor(1);
            iVar.c = iVar.a.getDefaultSensor(4);
            iVar.d = new HandlerThread("CYFMotionListener");
            iVar.d.start();
            Handler handler = new Handler(iVar.d.getLooper());
            iVar.f = iVar.a.registerListener(iVar, iVar.b, 3, handler);
            iVar.g = iVar.a.registerListener(iVar, iVar.c, 3, handler);
            ah.a("MotionListener", "GyroScope status " + iVar.g + " and Accelerometer status " + iVar.f, new Throwable[0]);
            if (!iVar.f && !iVar.g) {
                ah.c("MotionListener", "Failed to register motion listener", new Throwable[0]);
                iVar.a();
                z = false;
            } else {
                iVar.i = !iVar.f;
                iVar.h = !iVar.g;
                iVar.e = SystemClock.uptimeMillis();
                iVar.k = (float) System.nanoTime();
                iVar.l = 0;
                z = true;
            }
            if (!z) {
                ah.c("MotionManager", "Motion listener registration failed", new Throwable[0]);
                return;
            }
            jVar.b = true;
            jVar.a.addObserver(jVar);
        } catch (Exception e) {
            ah.c("CYFManager", "Exception in starting motion manager", e);
            f.a(e);
        }
    }

    public final synchronized void f() {
        Objects.toString(Thread.currentThread());
        try {
            this.b.a();
        } catch (Exception e) {
            ah.c("CYFManager", "Exception in stopping motion manager", e);
            f.a(e);
        }
    }

    public final synchronized void c(Application application) {
        if (!h) {
            this.e = new c();
            application.registerActivityLifecycleCallbacks(this.e);
            h = true;
        }
    }
}
