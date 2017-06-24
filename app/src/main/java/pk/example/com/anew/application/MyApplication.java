package pk.example.com.anew.application;

import android.app.Application;
import android.content.Context;

import ad0424.yls.example.com.news.utils.SPUtil;
import cn.bmob.v3.Bmob;


public class MyApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        mContext = getApplicationContext();
        Bmob.initialize(this, "88550df99426c362c26d3ee1151a6bc6");
        SPUtil.setIsNight(this,true);
    }

    public static Context getContext() {
        return mContext;
    }
}
