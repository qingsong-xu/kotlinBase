package com.xuqingsong.bbc.util

import android.util.DisplayMetrics
import com.xuqingsong.bbc.XUI

/**
 * @author xuqingsong
 * @date 2021/10/29
 * @desc 设备分辨率工具
 **/
class DensityUtils {
    companion object {
        fun getDisplayMetrics(): DisplayMetrics {
            return XUI.getContext()!!.resources!!.displayMetrics;
        }
    }
}