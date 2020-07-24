package com.lhy.multilanguages;

import android.content.res.Resources;

import androidx.appcompat.app.AppCompatActivity;

import com.lhy.library.LanguagesManager;


/**
 * @Author: lihanyang
 * @CreateDate: 2020/7/16
 * @Description: 基类
 */
public class BaseActivity extends AppCompatActivity {

//    @Override
//    protected void attachBaseContext(Context newBase) {
//        super.attachBaseContext(LanguagesManager.attach(newBase));
//    }

    @Override
   public Resources getResources() {
        /*
         * 为防止传入非ApplicationContext，这里做一次强制转化，目的是避免onConfigurationChange可能导致的问题，
         * 因为onConfigurationChange被触发时系统会更新ApplicationContext中的Resource，如果页面包含Runtime资源
         * （运行时动态加载的资源）时，有可能语言显示不一致。
         */
        //Log.e("BaseApplication", "BaseActivity getResources");
        //Resources res = super.getResources();
        //Configuration config = new Configuration();
        //config.setToDefaults();
        //res.updateConfiguration(config, res.getDisplayMetrics());
        //return res;
        return LanguagesManager.getAppLanguageResources(this);
    }
}
