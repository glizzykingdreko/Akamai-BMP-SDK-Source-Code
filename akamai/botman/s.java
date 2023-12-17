package com.akamai.botman;

import android.os.SystemClock;
import android.text.Editable;
import android.text.TextWatcher;
import androidx.exifinterface.media.ExifInterface;
import java.util.Observable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class s extends Observable implements TextWatcher {
    private static int c = -1;
    private final int a;
    private boolean b;
    private int d = 0;
    private boolean e = false;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(int i, boolean z) {
        this.a = i;
        this.b = z;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.length() - this.d > 1) {
            this.e = true;
        } else {
            this.e = false;
        }
        setChanged();
        notifyObservers(new g(Long.valueOf(SystemClock.uptimeMillis()).longValue(), ExifInterface.GPS_MEASUREMENT_2D, this.a, this.e));
        this.d = charSequence.length();
    }
}
