package com.akamai.botman;

import android.app.Application;
import android.os.SystemClock;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class j implements Observer {
    i a;
    boolean b;
    long c;
    Future<ai<Pair<String, String>, Long, Long>> e;
    public ArrayList<k> d = new ArrayList<>();
    AtomicBoolean f = new AtomicBoolean(false);

    public j(Application application) {
        ah.a("MotionManager", "Initializing motion manager", new Throwable[0]);
        this.c = SystemClock.uptimeMillis();
        this.a = new i(application);
    }

    public final void a() throws Exception {
        Objects.toString(Thread.currentThread());
        this.a.a();
        this.a.deleteObservers();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.akamai.botman.ai<android.util.Pair<java.lang.String, java.lang.String>, java.lang.Long, java.lang.Long> b() throws java.lang.Exception {
        /*
            r6 = this;
            java.util.concurrent.Future<com.akamai.botman.ai<android.util.Pair<java.lang.String, java.lang.String>, java.lang.Long, java.lang.Long>> r0 = r6.e
            r1 = 0
            java.lang.String r2 = "Failed to get motion data: "
            java.lang.String r3 = "MotionManager"
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
            r6.a()
            com.akamai.botman.ai r0 = r6.c()
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
        throw new UnsupportedOperationException("Method not decompiled: com.akamai.botman.j.b():com.akamai.botman.ai");
    }

    @Override // java.util.Observer
    public final void update(Observable observable, Object obj) {
        if (obj == null) {
            return;
        }
        try {
            if (this.d.size() >= 128) {
                a();
                Future<ai<Pair<String, String>, Long, Long>> future = this.e;
                if (future == null || future.isCancelled() || this.e.isDone()) {
                    ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(1);
                    this.e = newFixedThreadPool.submit(new a());
                    newFixedThreadPool.shutdown();
                    return;
                }
                return;
            }
            this.d.add((k) obj);
        } catch (Exception e) {
            ah.b("MotionManager", "Exception in processing motion event", e);
            f.a(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ai<Pair<String, String>, Long, Long> c() {
        j jVar;
        String str;
        Object obj;
        Long l;
        long uptimeMillis;
        int a2;
        float[] fArr;
        float[] fArr2;
        float[] fArr3;
        float[] fArr4;
        float[] fArr5;
        float[] fArr6;
        float[] fArr7;
        float[] fArr8;
        String str2;
        float[] fArr9;
        float[] fArr10;
        Pair pair;
        long longValue;
        long uptimeMillis2;
        StringBuilder sb;
        Iterator<k> it;
        k next;
        j jVar2 = this;
        String str3 = "MotionManager";
        Objects.toString(Thread.currentThread());
        if (jVar2.d.size() <= 1) {
            return new ai<>(new Pair("", ""), 0L, 0L);
        }
        if (jVar2.f.compareAndSet(false, true)) {
            try {
                try {
                    uptimeMillis = SystemClock.uptimeMillis();
                    a2 = (int) ag.a(jVar2.d.size());
                    fArr = new float[a2];
                    fArr2 = new float[a2];
                    fArr3 = new float[a2];
                    fArr4 = new float[a2];
                    fArr5 = new float[a2];
                    fArr6 = new float[a2];
                    fArr7 = new float[a2];
                    fArr8 = new float[a2];
                    l = 0L;
                } catch (Throwable th) {
                    th = th;
                    jVar = jVar2;
                }
            } catch (Exception e) {
                e = e;
                str = "MotionManager";
                obj = "";
                l = 0L;
            }
            try {
                float[] fArr11 = new float[a2];
                obj = "";
                try {
                    float[] fArr12 = new float[a2];
                    long j = jVar2.c;
                    Iterator<k> it2 = jVar2.d.iterator();
                    int i = 0;
                    while (true) {
                        if (!it2.hasNext()) {
                            str2 = str3;
                            fArr9 = fArr8;
                            fArr10 = fArr11;
                            break;
                        }
                        try {
                            try {
                                it = it2;
                                next = it2.next();
                                str2 = str3;
                            } catch (Throwable th2) {
                                th = th2;
                                jVar = this;
                                jVar.f.set(false);
                                throw th;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            jVar = this;
                            str = str3;
                            ah.b(str, "Exception in getting motion events", e);
                            f.a(e);
                            jVar.f.set(false);
                            Object obj2 = obj;
                            Pair pair2 = new Pair(obj2, obj2);
                            Long l2 = l;
                            return new ai<>(pair2, l2, l2);
                        }
                        try {
                            fArr[i] = next.d;
                            fArr2[i] = next.e;
                            fArr3[i] = next.f;
                            fArr4[i] = next.a;
                            fArr5[i] = next.b;
                            fArr6[i] = next.c;
                            fArr7[i] = next.g;
                            fArr8[i] = next.h;
                            fArr11[i] = next.i;
                            long j2 = next.j - j;
                            fArr9 = fArr8;
                            fArr10 = fArr11;
                            fArr12[i] = (float) Math.max(0L, j2);
                            SystemClock.uptimeMillis();
                            long j3 = next.j;
                            float f = fArr[i];
                            float f2 = fArr2[i];
                            float f3 = fArr3[i];
                            float f4 = fArr4[i];
                            float f5 = fArr5[i];
                            float f6 = fArr6[i];
                            float f7 = fArr7[i];
                            float f8 = fArr9[i];
                            float f9 = fArr10[i];
                            long j4 = next.j;
                            i++;
                            if (i >= a2) {
                                break;
                            }
                            fArr8 = fArr9;
                            fArr11 = fArr10;
                            it2 = it;
                            j = j4;
                            str3 = str2;
                            jVar2 = this;
                        } catch (Exception e3) {
                            e = e3;
                            jVar = this;
                            str = str2;
                            ah.b(str, "Exception in getting motion events", e);
                            f.a(e);
                            jVar.f.set(false);
                            Object obj22 = obj;
                            Pair pair22 = new Pair(obj22, obj22);
                            Long l22 = l;
                            return new ai<>(pair22, l22, l22);
                        }
                    }
                    Pair<String, Long> a3 = ad.a(fArr, 0.6f);
                    Pair<String, Long> a4 = ad.a(fArr2, 0.6f);
                    Pair<String, Long> a5 = ad.a(fArr3, 0.6f);
                    Pair<String, Long> a6 = ad.a(fArr4, 0.6f);
                    Pair<String, Long> a7 = ad.a(fArr5, 0.6f);
                    Pair<String, Long> a8 = ad.a(fArr6, 0.6f);
                    Pair<String, Long> a9 = ad.a(fArr7, 0.6f);
                    Pair<String, Long> a10 = ad.a(fArr9, 0.6f);
                    Pair<String, Long> a11 = ad.a(fArr10, 0.6f);
                    pair = new Pair(((String) a3.first) + ":" + ((String) a4.first) + ":" + ((String) a5.first) + ":" + ((String) a6.first) + ":" + ((String) a7.first) + ":" + ((String) a8.first) + ":" + ((String) a9.first) + ":" + ((String) a10.first) + ":" + ((String) a11.first), ad.a(fArr12, 0.0f).first);
                    longValue = ((Long) a3.second).longValue() + ((Long) a4.second).longValue() + ((Long) a5.second).longValue() + ((Long) a6.second).longValue() + ((Long) a7.second).longValue() + ((Long) a8.second).longValue() + ((Long) a9.second).longValue() + ((Long) a10.second).longValue() + ((Long) a11.second).longValue();
                    uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                    sb = new StringBuilder("Motion Event Count: ");
                    sb.append(a2);
                    sb.append("/");
                    jVar = this;
                } catch (Exception e4) {
                    e = e4;
                    jVar = jVar2;
                }
            } catch (Exception e5) {
                e = e5;
                str = "MotionManager";
                obj = "";
                jVar = jVar2;
                ah.b(str, "Exception in getting motion events", e);
                f.a(e);
                jVar.f.set(false);
                Object obj222 = obj;
                Pair pair222 = new Pair(obj222, obj222);
                Long l222 = l;
                return new ai<>(pair222, l222, l222);
            }
            try {
                try {
                    sb.append(jVar.d.size());
                    str = str2;
                    try {
                        ah.a(str, sb.toString(), new Throwable[0]);
                        ah.a(str, "Motion SDCalc-Time: " + uptimeMillis2 + "ms", new Throwable[0]);
                        ai<Pair<String, String>, Long, Long> aiVar = new ai<>(pair, Long.valueOf(longValue), Long.valueOf((long) a2));
                        jVar.f.set(false);
                        return aiVar;
                    } catch (Exception e6) {
                        e = e6;
                        ah.b(str, "Exception in getting motion events", e);
                        f.a(e);
                        jVar.f.set(false);
                        Object obj2222 = obj;
                        Pair pair2222 = new Pair(obj2222, obj2222);
                        Long l2222 = l;
                        return new ai<>(pair2222, l2222, l2222);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    jVar.f.set(false);
                    throw th;
                }
            } catch (Exception e7) {
                e = e7;
                str = str2;
                ah.b(str, "Exception in getting motion events", e);
                f.a(e);
                jVar.f.set(false);
                Object obj22222 = obj;
                Pair pair22222 = new Pair(obj22222, obj22222);
                Long l22222 = l;
                return new ai<>(pair22222, l22222, l22222);
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
            return j.this.c();
        }
    }
}
