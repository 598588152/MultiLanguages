package com.lhy.multilanguages;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lhy.library.LanguagesManager;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * @Author: lihanyang
 * @CreateDate: 2020/7/16
 * @Description: 参考项目地址：
 * https://github.com/getActivity/MultiLanguages
 * https://github.com/MichaelJokAr/MultiLanguages
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.tv_language_system)
    TextView tvLanguageSystem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        systemLanguage();
    }


    @OnClick({R.id.bt_auto, R.id.bt_cn, R.id.bt_tw, R.id.bt_en})
    public void onViewClicked(View view) {
        boolean restart = false;
        switch (view.getId()) {
            case R.id.bt_auto:
                //跟随系统
                restart = LanguagesManager.setSystemLanguage(this);
                break;
            case R.id.bt_cn:
                //简体中文
                restart = LanguagesManager.setAppLanguage(this, Locale.CHINA);
                break;
            case R.id.bt_tw:
                //繁体中文
                restart = LanguagesManager.setAppLanguage(this, Locale.TAIWAN);
                break;
            case R.id.bt_en:
                //英语
                restart = LanguagesManager.setAppLanguage(this, Locale.ENGLISH);
                break;
        }
        if (restart)
            reStart();
    }

    //显示系统语言
    private void systemLanguage() {
        String systemLanguage = LanguagesManager.getLanguageString(this, LanguagesManager.getSystemLanguage(), R.string.current_language);
        tvLanguageSystem.setText(systemLanguage);
    }

    //重新启动
    private void reStart() {
        startActivity(new Intent(this, MainActivity.class));
        overridePendingTransition(R.anim.activity_alpha_in, R.anim.activity_alpha_out);
        finish();
    }
}