package com.xuqingsong.bbc

import android.app.Application
import android.content.Context

/**
 * @author xuqingsong
 * @date 2021/10/29
 * @desc UI全局设置
 **/
class XUI {

    //=======================初始化设置===========================//
    companion object {
        private var sContext: Application? = null

        /**
         * 初始化
         *
         * @param context 上下文
         */
        fun init(context: Application?) {
            sContext = context
        }

        private fun testInitialize() {
            if (sContext == null) {
                throw ExceptionInInitializerError("请先在全局Application中调用 XUI.init() 初始化！")
            }
        }

        /**
         * 获取上下文
         */
        fun getContext(): Context? {
            testInitialize()
            return sContext
        }
    }


    //=======================屏幕尺寸===========================//

    //=======================屏幕尺寸===========================//
    /**
     * 检验设备屏幕的尺寸
     *
     * @param context
     * @return
     */
//    private fun checkScreenSize(context: Context): Int {
//        val screenSize =
//            context.resources.configuration.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK
//        return if (screenSize >= Configuration.SCREENLAYOUT_SIZE_LARGE) {
//            //证明是平板
//            if (screenSize >= Configuration.SCREENLAYOUT_SIZE_XLARGE) {
//                UIConsts.ScreenType.BIG_TABLET
//            } else {
//                UIConsts.ScreenType.SMALL_TABLET
//            }
//        } else {
//            UIConsts.ScreenType.PHONE
//        }
//    }

    /**
     * 判断是否平板设备
     *
     * @return true:平板,false:手机
     */
//    fun getScreenType(): Int {
//        if (sIsTabletChecked) {
//            return sScreenType
//        }
//        sScreenType = checkScreenSize(XUI.getContext())
//        sIsTabletChecked = true
//        return sScreenType
//    }

    /**
     * 是否是平板
     *
     * @return
     */
//    fun isTablet(): Boolean {
//        return getScreenType() == UIConsts.ScreenType.SMALL_TABLET || getScreenType() == UIConsts.ScreenType.BIG_TABLET
//    }

    /**
     * 初始化主题
     *
     * @param activity
     */
//    fun initTheme(activity: Activity) {
//        val screenType = getScreenType()
//        if (screenType == UIConsts.ScreenType.PHONE) {
//            activity.setTheme(R.style.XUITheme_Phone)
//        } else if (screenType == UIConsts.ScreenType.SMALL_TABLET) {
//            activity.setTheme(R.style.XUITheme_Tablet_Small)
//        } else {
//            activity.setTheme(R.style.XUITheme_Tablet_Big)
//        }
//    }

    /**
     * 获取主题色
     *
     * @param context 上下文
     * @return 主题色
     */
//    @ColorInt
//    fun getMainThemeColor(context: Context?): Int {
//        return ThemeUtils.getMainThemeColor(context)
//    }


}