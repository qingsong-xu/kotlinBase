package com.xuqingsong.bbc.net

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author xuqingsong
 * @date 2021/10/29
 * @desc 网络请求类，单例
 **/
class Repository private constructor() {
    private val DEFAULT_TIME_CONNECT = 60L;


    //伴生对象
    companion object {
        val baseUrl: String = ""
        val INSTANCE: Repository by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            Repository().Builder().build(baseUrl)
        }
    }

    //内部类
    inner class Builder {

        fun build(url: String): Repository {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            val okHttpClient = OkHttpClient.Builder().retryOnConnectionFailure(true)
                .connectTimeout(DEFAULT_TIME_CONNECT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIME_CONNECT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIME_CONNECT, TimeUnit.SECONDS)
                .addInterceptor { chain ->
                    val request = chain.request().newBuilder()
                        .addHeader("x-deviceId", "test")
                        .build()
                    chain.proceed(request)
                }
                .addInterceptor(loggingInterceptor)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)//设置网络请求baseUrl
                .addConverterFactory(GsonConverterFactory.create())//设置数据解析器
                .client(okHttpClient)//设置okhttpClient
                .build()


            val reqService = retrofit.create(ReqService::class.java)

            return Repository()
        }
    }


}