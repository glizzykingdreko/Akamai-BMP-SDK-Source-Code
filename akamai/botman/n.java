package com.akamai.botman;

import android.app.Application;
import android.hardware.SensorManager;
import android.os.SystemClock;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class n implements Observer {
    m a;
    boolean b;
    long c;
    Future<ai<Pair<String, String>, Long, Long>> e;
    public ArrayList<l> d = new ArrayList<>();
    private AtomicBoolean f = new AtomicBoolean(false);

    public n(Application application) {
        ah.a("OrientationManager", "Initializing orientation manager", new Throwable[0]);
        this.c = SystemClock.uptimeMillis();
        this.a = new m(application);
    }

    public final void a() throws Exception {
        if (this.d.size() < 128 && !this.f.get()) {
            if (!this.a.a()) {
                ah.c("OrientationManager", "Orientation listener registration failed", new Throwable[0]);
                return;
            }
            this.b = true;
            this.a.addObserver(this);
        }
    }

    public final void b() throws Exception {
        this.a.b();
        this.a.deleteObservers();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.akamai.botman.ai<android.util.Pair<java.lang.String, java.lang.String>, java.lang.Long, java.lang.Long> c() throws java.lang.Exception {
        /*
            r6 = this;
            java.util.concurrent.Future<com.akamai.botman.ai<android.util.Pair<java.lang.String, java.lang.String>, java.lang.Long, java.lang.Long>> r0 = r6.e
            r1 = 0
            java.lang.String r2 = "Failed to get orientation data: "
            java.lang.String r3 = "OrientationManager"
            if (r0 == 0) goto L3d
            java.lang.Object r0 = r0.get()     // Catch: java.util.concurrent.ExecutionException -> L10 java.lang.InterruptedException -> L27
            com.akamai.botman.ai r0 = (com.akamai.botman.ai) r0     // Catch: java.util.concurrent.ExecutionException -> L10 java.lang.InterruptedException -> L27
            goto L3e
        L10:
            r0 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r2)
            java.lang.String r0 = r0.getMessage()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            java.lang.Throwable[] r4 = new java.lang.Throwable[r1]
            com.akamai.botman.ah.b(r3, r0, r4)
            goto L3d
        L27:
            r0 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r2)
            java.lang.String r0 = r0.getMessage()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            java.lang.Throwable[] r4 = new java.lang.Throwable[r1]
            com.akamai.botman.ah.b(r3, r0, r4)
        L3d:
            r0 = 0
        L3e:
            if (r0 != 0) goto L82
            r6.b()
            com.akamai.botman.ai r0 = r6.d()
            if (r0 != 0) goto L82
            java.util.concurrent.Future<com.akamai.botman.ai<android.util.Pair<java.lang.String, java.lang.String>, java.lang.Long, java.lang.Long>> r4 = r6.e
            if (r4 == 0) goto L82
            java.lang.Object r4 = r4.get()     // Catch: java.util.concurrent.ExecutionException -> L55 java.lang.InterruptedException -> L6c
            com.akamai.botman.ai r4 = (com.akamai.botman.ai) r4     // Catch: java.util.concurrent.ExecutionException -> L55 java.lang.InterruptedException -> L6c
            r0 = r4
            goto L82
        L55:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r2)
            java.lang.String r2 = r4.getMessage()
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            java.lang.Throwable[] r1 = new java.lang.Throwable[r1]
            com.akamai.botman.ah.b(r3, r2, r1)
            goto L82
        L6c:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r2)
            java.lang.String r2 = r4.getMessage()
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            java.lang.Throwable[] r1 = new java.lang.Throwable[r1]
            com.akamai.botman.ah.b(r3, r2, r1)
        L82:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.akamai.botman.n.c():com.akamai.botman.ai");
    }

    @Override // java.util.Observer
    public final void update(Observable observable, Object obj) {
        if (obj == null) {
            return;
        }
        try {
            if (this.d.size() >= 128) {
                b();
                Future<ai<Pair<String, String>, Long, Long>> future = this.e;
                if (future == null || future.isCancelled() || this.e.isDone()) {
                    ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(1);
                    this.e = newFixedThreadPool.submit(new a());
                    newFixedThreadPool.shutdown();
                    return;
                }
                return;
            }
            this.d.add((l) obj);
        } catch (Exception e) {
            ah.b("OrientationManager", "Exception in processing orientation event", e);
            f.a(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ai<Pair<String, String>, Long, Long> d() {
        n nVar;
        String str;
        Long l;
        int a2;
        long j;
        Pair pair;
        long longValue;
        long uptimeMillis;
        StringBuilder sb;
        l next;
        Iterator<l> it;
        n nVar2 = this;
        String str2 = "";
        Long l2 = 0L;
        if (nVar2.d.size() <= 1) {
            return new ai<>(new Pair("", ""), l2, l2);
        }
        if (nVar2.f.compareAndSet(false, true)) {
            try {
                long uptimeMillis2 = SystemClock.uptimeMillis();
                a2 = (int) ag.a(nVar2.d.size());
                float[] fArr = new float[a2];
                float[] fArr2 = new float[a2];
                float[] fArr3 = new float[a2];
                float[] fArr4 = new float[a2];
                long j2 = nVar2.c;
                Iterator<l> it2 = nVar2.d.iterator();
                int i = 0;
                while (true) {
                    if (!it2.hasNext()) {
                        str = str2;
                        l = l2;
                        j = uptimeMillis2;
                        break;
                    }
                    try {
                        try {
                            next = it2.next();
                            it = it2;
                            l = l2;
                        } catch (Exception e) {
                            e = e;
                            str = str2;
                            l = l2;
                        }
                        try {
                            float[] fArr5 = new float[9];
                            str = str2;
                            try {
                                if (SensorManager.getRotationMatrix(fArr5, new float[9], next.a, next.b)) {
                                    float[] fArr6 = new float[3];
                                    SensorManager.getOrientation(fArr5, fArr6);
                                    float degrees = (float) Math.toDegrees(fArr6[0]);
                                    float degrees2 = (float) Math.toDegrees(fArr6[1]);
                                    j = uptimeMillis2;
                                    float degrees3 = (float) Math.toDegrees(fArr6[2]);
                                    float f = degrees * (-1.0f);
                                    if (f < 0.0f) {
                                        f += 360.0f;
                                    }
                                    fArr[i] = f;
                                    fArr2[i] = degrees2 * (-1.0f);
                                    fArr3[i] = degrees3;
                                    fArr4[i] = (float) Math.max(0L, next.c - j2);
                                    SystemClock.uptimeMillis();
                                    long j3 = next.c;
                                    float f2 = fArr[i];
                                    float f3 = fArr2[i];
                                    float f4 = fArr3[i];
                                } else {
                                    j = uptimeMillis2;
                                    fArr[i] = 0.0f;
                                    fArr2[i] = 0.0f;
                                    fArr3[i] = 0.0f;
                                    ah.b("OrientationManager", "Failed to get rotation matrix", new Throwable[0]);
                                }
                                long j4 = next.c;
                                int i2 = i + 1;
                                if (i2 >= a2) {
                                    break;
                                }
                                i = i2;
                                j2 = j4;
                                it2 = it;
                                l2 = l;
                                str2 = str;
                                uptimeMillis2 = j;
                                nVar2 = this;
                            } catch (Exception e2) {
                                e = e2;
                                nVar = this;
                                ah.b("OrientationManager", "Exception in getting orientation events", e);
                                f.a(e);
                                nVar.f.set(false);
                                String str3 = str;
                                Pair pair2 = new Pair(str3, str3);
                                Long l3 = l;
                                return new ai<>(pair2, l3, l3);
                            }
                        } catch (Exception e3) {
                            e = e3;
                            str = str2;
                            nVar = this;
                            ah.b("OrientationManager", "Exception in getting orientation events", e);
                            f.a(e);
                            nVar.f.set(false);
                            String str32 = str;
                            Pair pair22 = new Pair(str32, str32);
                            Long l32 = l;
                            return new ai<>(pair22, l32, l32);
                        }
                    } catch (Throwable th) {
                        th = th;
                        nVar = this;
                        nVar.f.set(false);
                        throw th;
                    }
                }
                Pair<String, Long> a3 = ad.a(fArr, 0.6f);
                Pair<String, Long> a4 = ad.a(fArr2, 0.6f);
                Pair<String, Long> a5 = ad.a(fArr3, 0.6f);
                Pair<String, Long> a6 = ad.a(fArr4, 0.0f);
                pair = new Pair(((String) a3.first) + ":" + ((String) a4.first) + ":" + ((String) a5.first), a6.first);
                longValue = ((Long) a3.second).longValue() + ((Long) a4.second).longValue() + ((Long) a5.second).longValue();
                uptimeMillis = SystemClock.uptimeMillis() - j;
                sb = new StringBuilder("Orientation Event Count: ");
                sb.append(a2);
                sb.append("/");
                nVar = this;
            } catch (Exception e4) {
                e = e4;
                nVar = nVar2;
                str = str2;
                l = l2;
            } catch (Throwable th2) {
                th = th2;
                nVar = nVar2;
            }
            try {
                try {
                    sb.append(nVar.d.size());
                    ah.a("OrientationManager", sb.toString(), new Throwable[0]);
                    ah.a("OrientationManager", "Orientation SDCalc-Time: " + uptimeMillis + "ms", new Throwable[0]);
                    ai<Pair<String, String>, Long, Long> aiVar = new ai<>(pair, Long.valueOf(longValue), Long.valueOf((long) a2));
                    nVar.f.set(false);
                    return aiVar;
                } catch (Throwable th3) {
                    th = th3;
                    nVar.f.set(false);
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                ah.b("OrientationManager", "Exception in getting orientation events", e);
                f.a(e);
                nVar.f.set(false);
                String str322 = str;
                Pair pair222 = new Pair(str322, str322);
                Long l322 = l;
                return new ai<>(pair222, l322, l322);
            }
        }
        return null;
    }

    /* loaded from: classes.dex */
    class a implements Callable<ai<Pair<String, String>, Long, Long>> {
        a() {
        }

        @Override // java.util.concurrent.Callable
        public final /* synthetic */ ai<Pair<String, String>, Long, Long> call() throws Exception {
            return n.this.d();
        }
    }
}
