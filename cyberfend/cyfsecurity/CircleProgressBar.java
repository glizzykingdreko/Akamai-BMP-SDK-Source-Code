package com.cyberfend.cyfsecurity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.imagepipeline.common.RotationOptions;

/* loaded from: classes.dex */
public class CircleProgressBar extends View {
    private static final String b = "CircleProgressBar";
    Handler a;
    private float c;
    private float d;
    private float e;
    private int f;
    private int g;
    private int h;
    private RectF i;
    private Paint j;
    private Paint k;
    private int l;
    private Runnable m;

    static /* synthetic */ int b(CircleProgressBar circleProgressBar) {
        int i = circleProgressBar.l;
        circleProgressBar.l = i + 1;
        return i;
    }

    static /* synthetic */ float c(CircleProgressBar circleProgressBar) {
        float f = circleProgressBar.e;
        circleProgressBar.e = 1.0f + f;
        return f;
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 20.0f;
        this.d = 20.0f;
        this.e = 0.0f;
        this.f = 100;
        this.g = 0;
        this.h = RotationOptions.ROTATE_270;
        this.l = 0;
        this.a = new Handler();
        this.m = new Runnable() { // from class: com.cyberfend.cyfsecurity.CircleProgressBar.1
            @Override // java.lang.Runnable
            public final void run() {
                String unused = CircleProgressBar.b;
                if (CircleProgressBar.this.l < 9) {
                    String unused2 = CircleProgressBar.b;
                    CircleProgressBar.b(CircleProgressBar.this);
                    CircleProgressBar.c(CircleProgressBar.this);
                    CircleProgressBar.this.postInvalidate();
                    CircleProgressBar.this.a.postDelayed(CircleProgressBar.this.m, 100L);
                    return;
                }
                String unused3 = CircleProgressBar.b;
            }
        };
        this.i = new RectF();
        Paint paint = new Paint(1);
        this.j = paint;
        paint.setColor(context.getResources().getColor(R.color.akamaiCCAcolorProgressBackground));
        this.j.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.k = paint2;
        paint2.setColor(context.getResources().getColor(R.color.akamaiCCAcolorProgressForeground));
        this.k.setStyle(Paint.Style.FILL);
        this.a.postDelayed(this.m, 100L);
    }

    public void setProgressBarColor(int i) {
        this.k.setColor(i);
        this.j.setColor(Color.argb(Math.round(Color.alpha(i) * 0.25f), Color.red(i), Color.green(i), Color.blue(i)));
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int min = Math.min(getDefaultSize(getSuggestedMinimumWidth(), i), getDefaultSize(getSuggestedMinimumHeight(), i2));
        setMeasuredDimension(min, min);
        RectF rectF = this.i;
        float f = this.d;
        float f2 = min;
        rectF.set((f / 2.0f) + 0.0f, (f / 2.0f) + 0.0f, f2 - (f / 2.0f), f2 - (f / 2.0f));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawOval(this.i, this.j);
        canvas.drawArc(this.i, this.h, (this.e * 360.0f) / this.f, true, this.k);
    }

    public synchronized void setProgress(float f) {
        this.e = f * this.f;
        this.l = 0;
        this.a.postDelayed(this.m, 100L);
        postInvalidate();
    }
}
