package com.akamai.botman;

import android.app.Application;
import com.bumptech.glide.load.Key;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* loaded from: classes.dex */
public class x extends y {
    private static final String h = "x";
    private static final x i = new x();
    public a a;
    public String b;
    private String j;
    private String k;
    private long l = System.currentTimeMillis();
    private String m = "";

    /* loaded from: classes.dex */
    public interface a {
        void a();

        void a(float f);

        void a(String str);

        void b();

        void c();
    }

    private x() {
    }

    public static x a() {
        return i;
    }

    @Override // com.akamai.botman.y
    public final void a(Application application, String str) {
        b(application, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized String b() {
        if (this.j != null && System.currentTimeMillis() <= this.l) {
            return this.j;
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0190, code lost:
        if (r4 != null) goto L45;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x019a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean b(java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 440
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.akamai.botman.x.b(java.lang.String):boolean");
    }

    @Override // com.akamai.botman.y
    final String c() {
        StringBuilder sb = new StringBuilder(this.c + "/_bm/get_params?type=sdk-cca");
        try {
            String str = this.b;
            if (str != null && !str.equals("")) {
                sb.append("&context=");
                sb.append(URLEncoder.encode(this.b, Key.STRING_CHARSET_NAME));
            }
            String str2 = this.m;
            if (str2 != null && !str2.equals("")) {
                sb.append("&payload=");
                sb.append(URLEncoder.encode(this.m, Key.STRING_CHARSET_NAME));
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        this.m = "";
        return sb.toString();
    }

    @Override // com.akamai.botman.y
    protected final void d() {
        new Thread(new Runnable() { // from class: com.akamai.botman.x.1
            @Override // java.lang.Runnable
            public final void run() {
                x xVar = x.this;
                xVar.b(xVar.f);
                String unused = x.h;
            }
        }).start();
    }

    @Override // com.akamai.botman.y
    protected final void a(int i2) {
        this.a.a(i2 / 10.0f);
    }

    @Override // com.akamai.botman.y
    protected final void a(String str) {
        ah.c(h, "Error: ".concat(String.valueOf(str)), new Throwable[0]);
        this.a.a();
        this.a.a(str);
    }

    @Override // com.akamai.botman.y
    protected final void e() {
        super.e();
        this.a.a();
        this.a.c();
        b(0);
    }
}
