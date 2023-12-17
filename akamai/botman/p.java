package com.akamai.botman;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p {
    public static ArrayList<View> a(View view) throws Exception {
        if (!(view instanceof ViewGroup)) {
            ArrayList<View> arrayList = new ArrayList<>();
            arrayList.add(view);
            return arrayList;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        ViewGroup viewGroup = (ViewGroup) view;
        arrayList2.add(view);
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(a(viewGroup.getChildAt(i)));
            arrayList2.addAll(arrayList3);
        }
        return arrayList2;
    }
}
