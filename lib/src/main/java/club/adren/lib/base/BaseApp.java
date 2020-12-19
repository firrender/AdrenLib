package club.adren.lib.base;

import android.content.res.Resources;

import androidx.multidex.MultiDexApplication;

import club.adren.lib.config.Config;
import club.adren.lib.http.HttpUtils;
import club.adren.lib.utils.ScreenHelper;

/**
 * Creator: adren
 * CreTime: 2020/11/3
 * Descrip:
 */
public class BaseApp extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        Config.init(this);

        HttpUtils.getInstance().init(this);

    }


    /**
     *
     * 屏幕适配-PT方式
     */
    @Override
    public Resources getResources() {
        int o = super.getResources().getConfiguration().orientation;
        if (o == android.content.res.Configuration.ORIENTATION_LANDSCAPE)
            return ScreenHelper.adaptHeight(super.getResources(), 750);
        else return ScreenHelper.adaptWidth(super.getResources(), 750);
    }
}
