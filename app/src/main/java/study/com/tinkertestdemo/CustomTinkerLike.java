package study.com.tinkertestdemo;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.multidex.MultiDex;

import com.tencent.tinker.anno.DefaultLifeCycle;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * Created by  HONGDA on 2018/9/11.
 */
//使用Tinker的注解库，使用ApplicationLike对象生成Application对象
@DefaultLifeCycle(application = ".MyApplication", flags = ShareConstants.TINKER_ENABLE_ALL, loadVerifyFlag = false)
public class CustomTinkerLike extends ApplicationLike {

    public CustomTinkerLike(Application application, int tinkerFlags, boolean tinkerLoadVerifyFlag, long applicationStartElapsedTime, long applicationStartMillisTime, Intent tinkerResultIntent) {
        super(application, tinkerFlags, tinkerLoadVerifyFlag, applicationStartElapsedTime, applicationStartMillisTime, tinkerResultIntent);
    }

    @Override
    public void onBaseContextAttached(Context base) {
        super.onBaseContextAttached(base);
        //使应用支持分包
        MultiDex.install(base);
        //安装Tinker
        TinkerManager.installTinker(this);
    }

}
