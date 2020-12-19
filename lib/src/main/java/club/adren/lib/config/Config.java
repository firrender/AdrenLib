package club.adren.lib.config;

import android.app.Application;

import club.adren.lib.utils.Actions;

/**
 * Creator: adren
 * CreTime: 2020/12/9
 * Descrip:
 */
public class Config {

    public static void init(Application app) {
        int versionType = - 2;
        try {
            versionType = (Integer) Actions.getMetaData(app, "VERSION_TYPE");
        } catch (Exception e) {
        }
        TYPE = versionType;

        System.out.println("当前版本：" + TYPE);
    }

    public static final int TYPE_RELEASE = 2;// release版本

    // 版本
    public static int TYPE;
}
