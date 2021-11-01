package com.xuqingsong.bbc.util

import com.xuqingsong.bbc.BuildConfig

/**
 * @author xuqingsong
 * @date 2021/10/29
 * @desc 创建app管理类，提供整个app的全局状态设置和获取，如是否是debug模式，将activity加入栈管理等
 **/
class AppUtils {
    //静态方法必须在伴生对象中
    companion object {
        //返回是否是debug模式
        fun isDebug(): Boolean {
            return BuildConfig.DEBUG
        }



    }
}