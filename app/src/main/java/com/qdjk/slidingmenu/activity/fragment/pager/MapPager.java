package com.qdjk.slidingmenu.activity.fragment.pager;

import android.content.Context;

public class MapPager extends BasePager {
    public MapPager(Context context) {
        super(context);
    }

    @Override
    public void initData() {
        super.initData();
        tvTitle.setText("地图显示");
    }
}
