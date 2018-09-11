package study.com.tinkertestdemo;

import android.content.Context;

import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.loader.app.ApplicationLike;

/**
 * Created by  HONGDA on 2018/9/11.
 */
public class TinkerManager {

    private static boolean isInstalled = false;
    private static ApplicationLike mAppLike;

    public static void installTinker(ApplicationLike applicationLike) {
        mAppLike = applicationLike;
        if (isInstalled) {
            return;
        }
        TinkerInstaller.install(mAppLike);//判断Tinker是否已经初始化(安装)过，如果没有初始化则初始化，初始化了则直接return
        isInstalled = true;
    }

    //完成patch文件的加载
    public static void loadPatch(String path) {
        if (Tinker.isTinkerInstalled()) {
            TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(), path);
        }
    }

    //通过ApplicationLike对象获取Context
    private static Context getApplicationContext() {
        if (mAppLike != null) {
            return mAppLike.getApplication().getApplicationContext();
        }
        return null;
    }

}
