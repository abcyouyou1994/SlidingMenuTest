package com.qdjk.slidingmenu.activity.fragment.pager;

import android.content.Context;

public class ReportPager extends BasePager {
    public ReportPager(Context context) {
        super(context);
    }

    @Override
    public void initData() {
        super.initData();
        tvTitle.setText("告警信息");
    }
}
