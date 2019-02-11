package com.qdjk.slidingmenu.activity.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.github.yoojia.slidingmenu.SlidingMenu;
import com.qdjk.slidingmenu.R;
import com.qdjk.slidingmenu.activity.MainActivity;
import com.qdjk.slidingmenu.activity.fragment.pager.BasePager;
import com.qdjk.slidingmenu.activity.fragment.pager.HomePager;
import com.qdjk.slidingmenu.activity.fragment.pager.MapPager;
import com.qdjk.slidingmenu.activity.fragment.pager.ReportPager;
import com.qdjk.slidingmenu.activity.fragment.viewui.NoScrollViewPager;

import org.xutils.x;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContentFragment extends BaseFragment {
private RadioButton homerb,maprb,reportrb;
private FrameLayout mainFrame;
private NoScrollViewPager  viewPager;
private RadioGroup viewCheck;
private ArrayList<BasePager> basePagers;

    @Override
    protected View initView() {
        View view=View.inflate(mActivity,R.layout.content_fragment,null);
        homerb=(RadioButton)view.findViewById(R.id.home_press);
        reportrb=(RadioButton)view.findViewById(R.id.report_press);
        maprb=(RadioButton)view.findViewById(R.id.map_press);
        mainFrame=(FrameLayout)view.findViewById(R.id.frame_main);
        viewPager= (NoScrollViewPager) view.findViewById(R.id.view_pager);
        viewCheck=(RadioGroup)view.findViewById(R.id.view_check);
        x.view().inject(ContentFragment.this,view);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        //设置默认选中的首页


        basePagers=new ArrayList<>();
        basePagers.add(new HomePager(mActivity));

        basePagers.add(new ReportPager(mActivity));
        basePagers.add(new MapPager(mActivity));
        viewPager.setAdapter(new ContentFragmentAdapter());

        viewCheck.setOnCheckedChangeListener(new MyonCheckedChangeListener());

        viewPager.addOnPageChangeListener(new MyOnPageChangeListener());
        viewCheck.check(R.id.home_press);
        basePagers.get(0).initData();

    }
    class MyOnPageChangeListener implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            BasePager basePager=basePagers.get(i);
            basePager.initData();
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    }
class  MyonCheckedChangeListener implements RadioGroup.OnCheckedChangeListener{

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.home_press://站牌信息
                viewPager.setCurrentItem(0,false);
                isEnableSlidingMenu(SlidingMenu.TOUCHMODE_FULLSCREEN);
                break;
            case R.id.report_press://告警信息
                viewPager.setCurrentItem(1,false);
                isEnableSlidingMenu(SlidingMenu.TOUCHMODE_NONE);
                break;
            case R.id.map_press://地图
                viewPager.setCurrentItem(2,false);
                isEnableSlidingMenu(SlidingMenu.TOUCHMODE_NONE);
                break;
        }
    }
}

    private void isEnableSlidingMenu(int touchmode) {
        MainActivity mainActivity=(MainActivity) mActivity;
        mainActivity.getSlidingMenu().setTouchModeAbove(touchmode);

    }

    class ContentFragmentAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return basePagers.size();
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
           BasePager basePager=basePagers.get(position);
           View rootView=basePager.rootView;
           basePager.initData();
           container.addView(rootView);
            return rootView;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view==o;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }
    }
}
