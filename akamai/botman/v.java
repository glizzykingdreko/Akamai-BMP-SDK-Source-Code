package com.akamai.botman;

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
public final class v implements Observer {
    public int b;
    public int c;
    Future<Pair<String, Long>> g;
    long h;
    long a = 0;
    public long d = 0;
    String e = "";
    ArrayList<aa> f = new ArrayList<>();
    private AtomicBoolean i = new AtomicBoolean(false);

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.util.Pair<java.lang.String, java.lang.Long> a() {
        /*
            r6 = this;
            java.util.concurrent.Future<android.util.Pair<java.lang.String, java.lang.Long>> r0 = r6.g
            r1 = 0
            java.lang.String r2 = "Failed to get touch data: "
            java.lang.String r3 = "TouchManager"
            if (r0 == 0) goto L3d
            java.lang.Object r0 = r0.get()     // Catch: java.util.concurrent.ExecutionException -> L10 java.lang.InterruptedException -> L27
            android.util.Pair r0 = (android.util.Pair) r0     // Catch: java.util.concurrent.ExecutionException -> L10 java.lang.InterruptedException -> L27
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
            if (r0 != 0) goto L7f
            android.util.Pair r0 = r6.b()
            if (r0 != 0) goto L7f
            java.util.concurrent.Future<android.util.Pair<java.lang.String, java.lang.Long>> r4 = r6.g
            if (r4 == 0) goto L7f
            java.lang.Object r4 = r4.get()     // Catch: java.util.concurrent.ExecutionException -> L52 java.lang.InterruptedException -> L69
            android.util.Pair r4 = (android.util.Pair) r4     // Catch: java.util.concurrent.ExecutionException -> L52 java.lang.InterruptedException -> L69
            r0 = r4
            goto L7f
        L52:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r2)
            java.lang.String r2 = r4.getMessage()
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            java.lang.Throwable[] r1 = new java.lang.Throwable[r1]
            com.akamai.botman.ah.b(r3, r2, r1)
            goto L7f
        L69:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r2)
            java.lang.String r2 = r4.getMessage()
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            java.lang.Throwable[] r1 = new java.lang.Throwable[r1]
            com.akamai.botman.ah.b(r3, r2, r1)
        L7f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.akamai.botman.v.a():android.util.Pair");
    }

    @Override // java.util.Observer
    public final void update(Observable observable, Object obj) {
        Future<Pair<String, Long>> future;
        try {
            Objects.toString(Thread.currentThread());
            if (obj != null && !this.i.get()) {
                this.d++;
                w wVar = (w) obj;
                int pointerCount = wVar.a.getPointerCount();
                if ((wVar.c != 1 || this.b >= 50) && (wVar.c == 1 || this.c >= 50)) {
                    return;
                }
                if (wVar.c == 1) {
                    for (int i = 0; i < pointerCount; i++) {
                        if (this.b < 50) {
                            this.f.add(new aa(wVar.b, wVar.a.getEventTime() - this.a, wVar.c, pointerCount, wVar.a.getY(i), wVar.a.getX(i), wVar.a.getToolType(i)));
                            this.b++;
                        }
                    }
                }
                if (wVar.c != 1) {
                    this.f.add(new aa(wVar.b, wVar.a.getEventTime() - this.a, wVar.c, pointerCount, wVar.a.getY(wVar.a.getActionIndex()), wVar.a.getX(wVar.a.getActionIndex()), wVar.a.getToolType(wVar.a.getActionIndex())));
                    this.c++;
                }
                if (this.b >= 50 && this.c >= 50 && ((future = this.g) == null || future.isCancelled() || this.g.isDone())) {
                    ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(1);
                    this.g = newFixedThreadPool.submit(new a());
                    newFixedThreadPool.shutdown();
                }
                this.a = wVar.a.getEventTime();
            }
        } catch (Exception e) {
            ah.b("TouchManager", "Exception in processing touch event", e);
            f.a(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Pair<String, Long> b() {
        aa next;
        if (this.f.size() == 0) {
            return new Pair<>("", 0L);
        }
        if (this.i.compareAndSet(false, true)) {
            try {
                try {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    Iterator<aa> it = this.f.iterator();
                    while (it.hasNext()) {
                        this.e += (next.a + "," + next.d + ",0,0," + next.b + ",1," + next.c + ",-1;");
                        this.h += it.next().d + next.a;
                    }
                    long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                    ah.a("TouchManager", "Touch Event Count: " + this.f.size() + " (move: " + this.b + ", updown: " + this.c + ")", new Throwable[0]);
                    StringBuilder sb = new StringBuilder("Touch SDCalc-Time: ");
                    sb.append(uptimeMillis2);
                    sb.append("ms");
                    ah.a("TouchManager", sb.toString(), new Throwable[0]);
                    return new Pair<>(this.e, Long.valueOf(this.h));
                } catch (Exception e) {
                    ah.b("TouchManager", "Exception in getting touch events", e);
                    f.a(e);
                    this.i.set(false);
                    return new Pair<>("", 0L);
                }
            } finally {
                this.i.set(false);
            }
        }
        return null;
    }

    /* loaded from: classes.dex */
    class a implements Callable<Pair<String, Long>> {
        a() {
        }

        @Override // java.util.concurrent.Callable
        public final /* synthetic */ Pair<String, Long> call() throws Exception {
            return v.this.b();
        }
    }
}
