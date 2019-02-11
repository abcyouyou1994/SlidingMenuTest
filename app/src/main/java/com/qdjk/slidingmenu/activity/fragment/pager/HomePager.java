package com.qdjk.slidingmenu.activity.fragment.pager;

import android.content.Context;
import android.os.SystemClock;
import android.provider.SyncStateContract;
import android.text.TextUtils;
import android.widget.ListView;

import com.google.gson.Gson;
import com.qdjk.slidingmenu.utils.CacheUtils;
import com.qdjk.slidingmenu.utils.ConstantUtils;

import org.xutils.common.Callback;
import org.xutils.common.util.LogUtil;
import org.xutils.http.RequestParams;
import org.xutils.x;

public class   HomePager extends BasePager{
    private long startTime;
    public HomePager(Context context) {
        super(context);
    }

    @Override
    public void initData() {
        super.initData();
        tvTitle.setText("站牌信息");
        //ListView listView=new ListView();



        String saveJson= CacheUtils.getString(context,ConstantUtils.STATION_URL);
        if(!TextUtils.isEmpty(saveJson)){
            processData(saveJson);
        }

        startTime = SystemClock.uptimeMillis();

        //联网请求
        getDataFromNet();


    }

    private void processData(String json) {
        Gson gson=new Gson();
       // gson.fromJson(json,)

    }

    private void getDataFromNet() {
        RequestParams params=new RequestParams(ConstantUtils.BASE_URL);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                LogUtil.e("使用xutils3联网请求成功"+result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                LogUtil.e("使用xutils3联网请求失败"+ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                LogUtil.e("使用xutils3联网请求取消"+cex.getMessage());
            }

            @Override
            public void onFinished() {
                LogUtil.e("使用xutils3联网请求结束");
            }
        });
    }
}
