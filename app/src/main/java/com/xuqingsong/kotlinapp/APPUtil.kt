package com.xuqingsong.kotlinapp

import android.content.Context
import android.content.pm.PackageManager
import android.text.TextUtils

object APPUtil {
    //根据包名 判断某APP是否安装
    fun checkApkExist(context: Context, packageName: String): Boolean {
        //  检查app是否有安装
        if (TextUtils.isEmpty(packageName))
            return false
        try {
            val info = context.packageManager
                .getApplicationInfo(
                    packageName,
                    PackageManager.GET_UNINSTALLED_PACKAGES
                )
            // Timber.d(info.toString()) // Timber 是我打印 log 用的工具，这里只是打印一下 log
            return true
        } catch (e: PackageManager.NameNotFoundException) {
            // Timber.d(e.toString()) // Timber 是我打印 log 用的工具，这里只是打印一下 log
            return false
        }

    }
}