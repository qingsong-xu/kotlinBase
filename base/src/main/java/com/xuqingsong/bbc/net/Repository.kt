package com.xuqingsong.bbc.net

/**
 * @author xuqingsong
 * @date 2021/10/29
 * @desc 网络请求类，单例
 **/
class Repository private constructor() {
    companion object {
        @Volatile private var instance: Repository? = null

    }


    inner class Builder {

    }


}