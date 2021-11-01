package com.xuqingsong.bbc

import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.alibaba.android.arouter.launcher.ARouter
import com.xuqingsong.bbc.util.AppUtils
import com.xuqingsong.bbc.util.KVUtils

/**
 * base 基础类
 * 1、BaseActivity
 * 2、BaseFragment
 * 3、网络请求框架
 * 4、基础工具类
 * 5、上传到远程仓库
 * 6、默认使用ARouter路由
 */
open class ModuleApplication : MultiDexApplication() {
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        //初始化XUI
        XUI.init(this)
        //初始化KV键值对工具
        KVUtils.get().init(this);

        if (AppUtils.isDebug()) {           // These two lines must be written before init, otherwise these configurations will be invalid in the init process
            ARouter.openLog();     // Print log
            ARouter.openDebug();   // Turn on debugging mode (If you are running in InstantRun mode, you must turn on debug mode! Online version needs to be closed, otherwise there is a security risk)
        }
        ARouter.init(this); // As early as possible, it is recommended to initialize in the Application
    }
}