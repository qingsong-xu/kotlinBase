package com.xuqingsong.bbc.net

/**
 * @author xuqingsong
 * @date 2021/11/2
 * @desc
 * 根据返回数据的格式和数据解析方式（Json、XML等）定义
 * 下面会在实例进行说明
 **/
class Reception<T> {
    var code = 500 //var code :Integer 为什么不行
    var msg: String? = null
    var data: T? = null
}