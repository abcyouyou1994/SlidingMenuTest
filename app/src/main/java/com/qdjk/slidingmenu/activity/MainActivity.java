package com.qdjk.slidingmenu.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.yoojia.slidingmenu.SlidingMenu;
import com.github.yoojia.slidingmenu.app.SlidingFragmentActivity;
import com.qdjk.slidingmenu.R;
import com.qdjk.slidingmenu.activity.fragment.ContentFragment;
import com.qdjk.slidingmenu.activity.fragment.LeftFragment;

public class MainActivity extends SlidingFragmentActivity {

    private static final String LEFT_MENU_TAG = "left";
    private static final String MAIN_MENU_TAG ="main" ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        initData();
    }

    private void initData() {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction transaction =fm.beginTransaction();
        transaction.replace(R.id.left_menu_framelayout,new LeftFragment(),LEFT_MENU_TAG);
        transaction.replace(R.id.frame_main,new ContentFragment(),MAIN_MENU_TAG);
        transaction.commit();
    }

    private void initView() {
        //1.设置主界面
        setContentView(R.layout.activity_main);
        //2.设置左侧菜单
        setBehindContentView(R.layout.left_fragment);
        //3.设置滑动模式(左侧滑动)
        SlidingMenu slidingMenu=getSlidingMenu();
        slidingMenu.setMode(SlidingMenu.LEFT);
        //4.设置滑动点
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        //5.设置主界面侧滑位置
        slidingMenu.setBehindOffset(200);

    }
}
