package com.xuqingsong.bbc.net

import com.xuqingsong.bbc.entity.ActiveInfo
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * @author xuqingsong
 * @date 2021/11/2
 * @desc 描述网络请求 的接口
 **/
interface ReqService {
    /**
     * 激活设备
     */
    @POST("/lecent-meeting/app/device/activeDevice")
    suspend fun active(@Body info: ActiveInfo): Response<Reception<Boolean>>
}