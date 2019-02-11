package com.qdjk.slidingmenu.activity.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.qdjk.slidingmenu.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class LeftFragment extends BaseFragment {
    ListView proLV;

    @Override
    protected View initView() {
        View view=View.inflate(mActivity,R.layout.left_fragment,null);
        proLV=view.findViewById(R.id.pro_lv);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
    }
   // public void setLeftMenuData(ArrayList<>)
}
