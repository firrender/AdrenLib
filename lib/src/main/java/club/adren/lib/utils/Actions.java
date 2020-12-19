package club.adren.lib.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

/**
 * Creator: adren
 * CreTime: 2020/12/9
 * Descrip:
 */
public class Actions {


    /**
     * 获取metadata
     *
     * @param name
     * @return
     */
    public static Object getMetaData(Context context, String name) {
        try {
            ApplicationInfo appInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            return appInfo.metaData.get(name);
        } catch (Exception e) {
        }
        return null;
    }


}
