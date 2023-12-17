package com.akamai.botman;

import android.app.Application;
import android.content.Context;
import android.os.SystemClock;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
public class y {
    private static final Locale a = Locale.US;
    private static final y b = new y();
    String c;
    long e;
    private String j;
    private long k;
    private long l;
    private long m;
    private long n;
    private String o;
    private String p;
    private long q;
    private String r;
    private int s;
    private int t;
    private long u;
    private int i = -1;
    private ArrayList<String> v = new ArrayList<>();
    private ArrayList<Long> w = new ArrayList<>();
    private ArrayList<Integer> x = new ArrayList<>();
    private String y = "";
    String f = "";
    private int z = 0;
    public String g = "";
    public int d = 0;
    private int h = 0;

    protected void a(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
    }

    public static y g() {
        return b;
    }

    public void a(Application application, String str) {
        b(application, str);
        a(1000L, 0);
    }

    public final synchronized String h() {
        if (this.i == 0) {
            return "";
        }
        if (this.f.length() == 0) {
            if (this.y.length() != 0) {
                return this.y;
            }
            Context context = z.a().a.get();
            if (context == null) {
                ah.b("SensorDataCache", "getPoWResponse: Context is null", new Throwable[0]);
            } else {
                String string = context.getSharedPreferences("com.akamai.botman.preferences", 0).getString("pow_response", null);
                if (string != null) {
                    return string;
                }
            }
            return "";
        }
        int i = this.z + 1;
        this.z = i;
        if (i >= this.m * 0.9d) {
            a(100L, 0);
        }
        return this.f;
    }

    public final void a(long j, final int i) {
        new Timer().schedule(new TimerTask() { // from class: com.akamai.botman.y.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public final void run() {
                new Thread(new Runnable() { // from class: com.akamai.botman.y.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        y.a(y.this, i);
                    }
                }).start();
            }
        }, j);
    }

    public final void b(Application application, String str) {
        this.c = str;
        this.p = r.a(application);
    }

    private void b(long j, final int i) {
        new Timer().schedule(new TimerTask() { // from class: com.akamai.botman.y.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public final void run() {
                new Thread(new Runnable() { // from class: com.akamai.botman.y.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        y.b(y.this, i);
                    }
                }).start();
            }
        }, j);
    }

    private static long a(byte[] bArr, long j) {
        long j2 = 0;
        for (byte b2 : bArr) {
            j2 = ((j2 << 8) | (b2 & 255)) % j;
        }
        return j2;
    }

    private void a() {
        this.s = 0;
        this.t = 0;
        this.v = new ArrayList<>();
        this.w = new ArrayList<>();
        this.x = new ArrayList<>();
        e();
    }

    private void b() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.y);
        sb.append(";");
        Iterator<String> it = this.v.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(";");
        Iterator<Long> it2 = this.w.iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(";");
        Iterator<Integer> it3 = this.x.iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        synchronized (this) {
            this.f = sb.toString();
            this.z = 0;
        }
        ah.a("PoW", "PoW Data: " + this.f, new Throwable[0]);
        long uptimeMillis = SystemClock.uptimeMillis() - this.q;
        ah.a("PoW", "Time taken to solve PoW challenge: " + uptimeMillis + "ms", new Throwable[0]);
        this.g = "Solved in " + uptimeMillis + "ms";
    }

    String c() {
        return this.c + "/_bm/get_params?type=sdk-pow";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(int i) {
        synchronized (this) {
            this.d = i;
        }
    }

    protected void d() {
        z.a().a(this.f);
    }

    protected void a(String str) {
        ah.c("PoW", "Error: ".concat(String.valueOf(str)), new Throwable[0]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x012d, code lost:
        if (r3 == null) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ void a(com.akamai.botman.y r9, int r10) {
        /*
            Method dump skipped, instructions count: 495
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.akamai.botman.y.a(com.akamai.botman.y, int):void");
    }

    static /* synthetic */ void b(y yVar, int i) {
        long j;
        if (yVar.d == 2) {
            yVar.a();
            return;
        }
        ah.a("PoW", "computeProofOfWork, Challenge Count: " + yVar.s, new Throwable[0]);
        yVar.g = "Solving MC: " + yVar.s;
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            long j2 = yVar.k + yVar.s;
            Random random = new Random();
            DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(a);
            decimalFormat.applyPattern("#.############");
            boolean z = false;
            long j3 = 0;
            while (true) {
                if (z) {
                    break;
                }
                String format = decimalFormat.format(random.nextDouble());
                int i2 = yVar.t;
                String str = yVar.r + j2 + format;
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                messageDigest.update(str.getBytes());
                if (a(messageDigest.digest(), j2) == 0) {
                    long uptimeMillis2 = SystemClock.uptimeMillis();
                    j3 = uptimeMillis2 - uptimeMillis;
                    j = j2;
                    long j4 = uptimeMillis2 - yVar.u;
                    ah.a("PoW", "Challenge (" + str + ") " + yVar.s + " solved at iteration: " + yVar.t + " in " + j4 + "ms", new Throwable[0]);
                    yVar.v.add(format);
                    yVar.x.add(Integer.valueOf(yVar.t));
                    yVar.w.add(Long.valueOf(j4));
                    z = true;
                } else {
                    j = j2;
                    int i3 = yVar.t + 1;
                    yVar.t = i3;
                    if (i3 % 1000 == 0) {
                        j3 = SystemClock.uptimeMillis() - uptimeMillis;
                        long j5 = yVar.n;
                        if (j3 > j5 && yVar.d != 2) {
                            yVar.b(j5 + 1000, i);
                            break;
                        }
                    }
                }
                if (yVar.d == 2) {
                    yVar.a();
                    return;
                }
                j2 = j;
            }
            if (z) {
                yVar.s++;
                yVar.u = SystemClock.uptimeMillis();
                yVar.a(yVar.s);
                if (yVar.s < 10) {
                    yVar.t = 0;
                    yVar.b(yVar.l + j3, i);
                    return;
                }
                yVar.t = 0;
                yVar.b();
                yVar.v = new ArrayList<>();
                yVar.w = new ArrayList<>();
                yVar.x = new ArrayList<>();
                yVar.b(0);
                if (SystemClock.uptimeMillis() - yVar.q > yVar.e * 1000 && i == 0) {
                    yVar.a(100L, i);
                }
                yVar.d();
            }
        } catch (NoSuchAlgorithmException e) {
            ah.c("PoW", "computeProofOfWork: " + e.toString(), new Throwable[0]);
        }
    }
}
