package com.akamai.botman;

import android.os.Handler;
import android.os.HandlerThread;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import java.util.Objects;
import java.util.Observable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class u extends Observable implements Window.Callback {
    private static final HandlerThread b = new HandlerThread("CYFTouchManager");
    private static boolean c = false;
    private final Window.Callback a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(Window.Callback callback) {
        this.a = callback;
        if (c) {
            HandlerThread handlerThread = b;
            if (handlerThread.isAlive()) {
                return;
            }
            Objects.toString(handlerThread);
            handlerThread.start();
        }
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.a.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        return this.a.onWindowStartingActionMode(callback, i);
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested(SearchEvent searchEvent) {
        return this.a.onSearchRequested(searchEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.a.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            a(motionEvent, 2);
            return this.a.dispatchTouchEvent(motionEvent);
        } else if (action == 1) {
            a(motionEvent, 3);
            return this.a.dispatchTouchEvent(motionEvent);
        } else if (action == 2) {
            a(motionEvent, 1);
            return this.a.dispatchTouchEvent(motionEvent);
        } else if (action == 5) {
            a(motionEvent, 2);
            return this.a.dispatchTouchEvent(motionEvent);
        } else if (action == 6) {
            a(motionEvent, 3);
            return this.a.dispatchTouchEvent(motionEvent);
        } else {
            return this.a.dispatchTouchEvent(motionEvent);
        }
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.a.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.a.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.a.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.Window.Callback
    public final View onCreatePanelView(int i) {
        return this.a.onCreatePanelView(i);
    }

    @Override // android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i, Menu menu) {
        return this.a.onCreatePanelMenu(i, menu);
    }

    @Override // android.view.Window.Callback
    public final boolean onPreparePanel(int i, View view, Menu menu) {
        return this.a.onPreparePanel(i, view, menu);
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuOpened(int i, Menu menu) {
        return this.a.onMenuOpened(i, menu);
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return this.a.onMenuItemSelected(i, menuItem);
    }

    @Override // android.view.Window.Callback
    public final void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.a.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.view.Window.Callback
    public final void onContentChanged() {
        this.a.onContentChanged();
    }

    @Override // android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z) {
        this.a.onWindowFocusChanged(z);
    }

    @Override // android.view.Window.Callback
    public final void onAttachedToWindow() {
        this.a.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.a.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public final void onPanelClosed(int i, Menu menu) {
        this.a.onPanelClosed(i, menu);
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested() {
        return this.a.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.a.onWindowStartingActionMode(callback);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeStarted(ActionMode actionMode) {
        this.a.onActionModeStarted(actionMode);
    }

    public static void a() {
        c = true;
    }

    public static boolean b() {
        return c;
    }

    private void a(final MotionEvent motionEvent, final int i) {
        try {
            if (c) {
                HandlerThread handlerThread = b;
                if (handlerThread.isAlive()) {
                    new Handler(handlerThread.getLooper()).post(new Runnable() { // from class: com.akamai.botman.u.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            d.d = 1;
                            d.e = 1;
                            u.this.setChanged();
                            u uVar = u.this;
                            MotionEvent motionEvent2 = motionEvent;
                            int i2 = i;
                            uVar.notifyObservers(new w(motionEvent2, i2 != 1 ? 0 : 1, i2));
                        }
                    });
                    return;
                }
            }
            int i2 = 1;
            d.d = 1;
            d.e = 1;
            setChanged();
            if (i != 1) {
                i2 = 0;
            }
            notifyObservers(new w(motionEvent, i2, i));
        } catch (Exception e) {
            f.a(e);
        }
    }

    @Override // android.view.Window.Callback
    public final void onActionModeFinished(ActionMode actionMode) {
        this.a.onActionModeFinished(actionMode);
    }
}
