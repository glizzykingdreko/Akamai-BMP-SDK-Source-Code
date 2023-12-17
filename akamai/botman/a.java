package com.akamai.botman;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.util.TypedValue;
import com.akamai.botman.CYFMonitor;
import com.cyberfend.cyfsecurity.CCADialogActivity;
import com.cyberfend.cyfsecurity.R;

/* loaded from: classes.dex */
public class a {
    private static final String d = "a";
    private static final a e = new a();
    public InterfaceC0008a a;
    public float b;
    public String c = "";
    private CYFMonitor.ChallengeActionCallback f;
    private int g;

    /* renamed from: com.akamai.botman.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0008a {
        void a();

        void a(float f);
    }

    static /* synthetic */ int c(a aVar) {
        aVar.g = 0;
        return 0;
    }

    public static a a() {
        return e;
    }

    public final boolean a(Context context, String str, String str2, String str3, CYFMonitor.ChallengeActionCallback challengeActionCallback, String str4) {
        if (this.g == 1 || challengeActionCallback == null) {
            return false;
        }
        this.f = challengeActionCallback;
        if (x.a().c == null || x.a().c.equals("")) {
            this.f.onChallengeActionFailure("CCA is not configured");
            return false;
        }
        this.c = str4;
        Intent intent = new Intent(context, CCADialogActivity.class);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new TypedValue().data, new int[]{R.attr.colorPrimary});
        int color = obtainStyledAttributes.getColor(0, 0);
        obtainStyledAttributes.recycle();
        intent.putExtra("CCA Title", str);
        intent.putExtra("CCA Message", str2);
        intent.putExtra("CCA Cancel Button", str3);
        intent.putExtra("Theme Color", color);
        context.startActivity(intent);
        synchronized (this) {
            this.g = 1;
        }
        return true;
    }

    public static void b() {
        x a = x.a();
        if (a.d == 1) {
            a.b(2);
        } else if (a.d == 3) {
            a.b(0);
        }
    }
}
