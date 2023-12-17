package com.akamai.botman;

/* loaded from: classes.dex */
public final class ai<A, B, C> {
    public final A a;
    public final B b;
    public final C c;

    public ai(A a, B b, C c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ai) {
            ai aiVar = (ai) obj;
            return aiVar.a.equals(this.a) && aiVar.b.equals(this.b) && aiVar.c.equals(this.c);
        }
        return false;
    }

    public final int hashCode() {
        A a = this.a;
        int hashCode = a == null ? 0 : a.hashCode();
        B b = this.b;
        int hashCode2 = hashCode ^ (b == null ? 0 : b.hashCode());
        C c = this.c;
        return hashCode2 ^ (c != null ? c.hashCode() : 0);
    }
}
