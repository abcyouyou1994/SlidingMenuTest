package com.qdjk.slidingmenu.activity.fragment.pager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.qdjk.slidingmenu.R;

public class BasePager {
    public final Context context;
    public View rootView;
    public TextView tvTitle;
    public ImageButton ibMenu;
    public FrameLayout flContent;
    public BasePager(Context context) {
       this.context = context;
       rootView=initView();
    }

    private View initView() {
        View view=View.inflate(context, R.layout.base_fragment,null);
        tvTitle=view.findViewById(R.id.base_title);
        flContent=view.findViewById(R.id.fl_content);
        ibMenu=view.findViewById(R.id.id_menu);
        return view;
    }
    public void initData(){

    }
}
