package com.lhy.multilanguages;

import android.app.Application;
import android.content.Context;

import com.lhy.library.LanguagesManager;


/**
 * @Author: lihanyang
 * @CreateDate: 2020/7/16
 * @Description:
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化
        LanguagesManager.init(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        // 国际化适配（绑定语言）
        super.attachBaseContext(LanguagesManager.attach(base));
    }
}
