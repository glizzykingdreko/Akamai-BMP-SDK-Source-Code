package com.cyberfend.cyfsecurity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.akamai.botman.a;
import com.akamai.botman.x;

/* loaded from: classes.dex */
public class CCADialogActivity extends AppCompatActivity {
    private static final String a = "CCADialogActivity";
    private TextView b;
    private TextView c;
    private Button d;
    private CircleProgressBar e;
    private a.InterfaceC0008a f = new a.InterfaceC0008a() { // from class: com.cyberfend.cyfsecurity.CCADialogActivity.1
        @Override // com.akamai.botman.a.InterfaceC0008a
        public final void a() {
            String unused = CCADialogActivity.a;
            CCADialogActivity.this.e.a.removeCallbacksAndMessages(null);
            CCADialogActivity.this.finish();
        }

        @Override // com.akamai.botman.a.InterfaceC0008a
        public final void a(final float f) {
            String unused = CCADialogActivity.a;
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cyberfend.cyfsecurity.CCADialogActivity.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    CCADialogActivity.this.e.setProgress(f);
                }
            });
        }
    };

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_ccadialog);
        setFinishOnTouchOutside(false);
        this.e = (CircleProgressBar) findViewById(R.id.dialogActivity_dialog_progressBar);
        String stringExtra = getIntent().getStringExtra("CCA Title");
        String stringExtra2 = getIntent().getStringExtra("CCA Message");
        String stringExtra3 = getIntent().getStringExtra("CCA Cancel Button");
        TextView textView = (TextView) findViewById(R.id.dialogActivity_dialog_title);
        this.b = textView;
        textView.setText(stringExtra);
        TextView textView2 = (TextView) findViewById(R.id.dialogActivity_dialog_message);
        this.c = textView2;
        textView2.setText(stringExtra2);
        Button button = (Button) findViewById(R.id.dialogActivity_dialog_button);
        this.d = button;
        button.setText(stringExtra3);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.cyberfend.cyfsecurity.CCADialogActivity.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a.a();
                a.b();
            }
        });
        int intExtra = getIntent().getIntExtra("Theme Color", getResources().getColor(R.color.akamaiCCAcolorPrimary));
        this.d.setTextColor(intExtra);
        this.e.setProgressBarColor(intExtra);
        final a a2 = a.a();
        a2.a = this.f;
        x.a aVar = new x.a() { // from class: com.akamai.botman.a.1
            @Override // com.akamai.botman.x.a
            public final void a() {
                if (a.this.g == 0) {
                    return;
                }
                a.this.a.a();
                String unused = a.d;
                synchronized (this) {
                    a.c(a.this);
                    a.this.b = 0.0f;
                }
            }

            @Override // com.akamai.botman.x.a
            public final void b() {
                a.this.f.onChallengeActionSuccess();
            }

            @Override // com.akamai.botman.x.a
            public final void a(float f) {
                a.this.b = f;
                a.this.a.a(a.this.b);
            }

            @Override // com.akamai.botman.x.a
            public final void a(String str) {
                a.this.f.onChallengeActionFailure(str);
            }

            @Override // com.akamai.botman.x.a
            public final void c() {
                a.this.f.onChallengeActionCancel();
            }
        };
        x a3 = x.a();
        String str = a2.c;
        int i = a3.d;
        a3.a = aVar;
        if (a3.d != 1 && a3.d != 3) {
            a3.b = str;
            a3.a(100L, 1);
        }
        a2.a.a(a2.b);
    }
}
