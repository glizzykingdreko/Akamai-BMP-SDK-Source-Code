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
public final class t {
    Future<Pair<String, Long>> d;
    public int e;
    public long f;
    ArrayList<g> b = new ArrayList<>();
    AtomicBoolean c = new AtomicBoolean(false);
    final b a = new b(this, (byte) 0);

    /* JADX INFO: Access modifiers changed from: package-private */
    public t() {
        a();
    }

    public final void a() {
        this.a.a = SystemClock.uptimeMillis();
        this.e = 0;
        this.f = 0L;
        this.b.clear();
        d();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.util.Pair<java.lang.String, java.lang.Long> b() throws java.lang.Exception {
        /*
            r6 = this;
            java.util.concurrent.Future<android.util.Pair<java.lang.String, java.lang.Long>> r0 = r6.d
            r1 = 0
            java.lang.String r2 = "Failed to get Text data: "
            java.lang.String r3 = "TextChangeManager"
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
            android.util.Pair r0 = r6.c()
            if (r0 != 0) goto L7f
            java.util.concurrent.Future<android.util.Pair<java.lang.String, java.lang.Long>> r4 = r6.d
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
        throw new UnsupportedOperationException("Method not decompiled: com.akamai.botman.t.b():android.util.Pair");
    }

    final Pair<String, Long> c() throws Exception {
        long j = 0;
        String str = "";
        if (this.b.size() == 0) {
            return new Pair<>("", 0L);
        }
        if (this.c.compareAndSet(false, true)) {
            Iterator<g> it = this.b.iterator();
            while (it.hasNext()) {
                g next = it.next();
                String str2 = next.b + "," + Long.valueOf(next.a) + "," + next.c;
                if (next.d) {
                    str2 = str2 + ",1";
                }
                str = str + (str2 + ";");
                j += next.a + q.b(next.b) + next.c;
                Long valueOf = Long.valueOf((SystemClock.uptimeMillis() - d.c) - next.a);
                this.b.size();
                Objects.toString(valueOf);
            }
            this.c.set(false);
            return new Pair<>(str, Long.valueOf(j));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Observer {
        long a;
        private int c;

        private b() {
            this.c = -1;
        }

        /* synthetic */ b(t tVar, byte b) {
            this();
        }

        @Override // java.util.Observer
        public final void update(Observable observable, Object obj) {
            try {
                t.this.f++;
                if (obj == null || t.this.b.size() >= 50 || t.this.c.get()) {
                    return;
                }
                g gVar = (g) obj;
                g gVar2 = new g(gVar.a - this.a, gVar.b, gVar.c, gVar.d);
                if (this.c != gVar.c) {
                    t.this.e = 0;
                    this.c = gVar.c;
                }
                if (t.this.e < 9) {
                    t.this.e++;
                    t.this.b.add(gVar2);
                }
                this.a = gVar.a;
                if (t.this.b.size() >= 50) {
                    t tVar = t.this;
                    if (tVar.d == null || tVar.d.isCancelled() || tVar.d.isDone()) {
                        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(1);
                        tVar.d = newFixedThreadPool.submit(new a());
                        newFixedThreadPool.shutdown();
                    }
                }
            } catch (Exception e) {
                ah.b("TextChangeManager", "Exception in processing text change event", e);
                f.a(e);
            }
        }
    }

    private void d() {
        Future<Pair<String, Long>> future = this.d;
        if (future != null) {
            if (!future.isCancelled() && !this.d.isDone()) {
                this.d.cancel(true);
            }
            this.d = null;
        }
    }

    /* loaded from: classes.dex */
    class a implements Callable<Pair<String, Long>> {
        a() {
        }

        @Override // java.util.concurrent.Callable
        public final /* synthetic */ Pair<String, Long> call() throws Exception {
            return t.this.c();
        }
    }
}
