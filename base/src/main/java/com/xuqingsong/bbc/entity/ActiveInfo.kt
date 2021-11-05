package com.xuqingsong.bbc.entity

/**
 * @author xuqingsong
 * @date 2021/11/2
 * @desc 设备激活参数类
 **/
data class ActiveInfo(
    val activeCode: String,
    val buildId: String,
    val cpu: String,
    val currentAndroidVersionCode: String,
    val currentAndroidVersionName: String,
    val emoryUsage: Int,
    val hardwareVer: String,
    val imei: String,
    val ip: String,
    val mac: String,
    val motherBoard: String,
    val networkType: String,
    val ram: Float,
    val softwareVer: String,
    val storage: Float,
    val tenantId: String
)