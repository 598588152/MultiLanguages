package com.lhy.library;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;


import androidx.annotation.NonNull;

import java.util.Locale;

/**
 * @Author: lihanyang
 * @CreateDate: 2020/7/16
 * @Description: 系统语言改变监听
 */
public class LanguagesChange implements ComponentCallbacks {

    private static Locale systemLanguage;

    static {
        // 获取当前系统的语言
        systemLanguage(Resources.getSystem().getConfiguration());
    }

    /**
     * 获取当前系统的语言
     *
     * @param configuration
     */
    static void systemLanguage(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            systemLanguage = configuration.getLocales().get(0);
        } else {
            systemLanguage = configuration.locale;
        }
    }

    /**
     * 获取系统的语言
     */
    static Locale getSystemLanguage() {
        return systemLanguage;
    }


    /**
     * 注册系统语言变化监听
     */
    static void register(Context context) {
        context.registerComponentCallbacks(new LanguagesChange());
    }

    /**
     * 手机的语言发生了变化
     */
    @Override
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        // 更新记录的系统语言
        systemLanguage(configuration);
    }

    @Override
    public void onLowMemory() {
    }
}
