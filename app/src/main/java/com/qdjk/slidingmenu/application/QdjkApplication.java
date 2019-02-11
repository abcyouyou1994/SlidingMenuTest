package com.qdjk.slidingmenu.application;

import android.app.Application;
import org.xutils.x;

public class QdjkApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.setDebug(true);
        x.Ext.init(this);


    }
}
