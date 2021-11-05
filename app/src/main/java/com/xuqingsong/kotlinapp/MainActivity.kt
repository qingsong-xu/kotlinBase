package com.xuqingsong.kotlinapp

import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import com.xuqingsong.bbc.base.BaseActivity
import com.xuqingsong.kotlinapp.databinding.ActivityMainBinding
import java.util.concurrent.Flow

class MainActivity : BaseActivity<ActivityMainBinding>() {
    val pkName = "cn.demo.prison"

    //    kotlin中取消了static关键字，直接声明val变量相当于final，但是并不是静态的，静态变量用通过伴生对象（companion object）的成员来生成
    companion object {
        val tag: String = MainActivity.javaClass.simpleName;
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //如何使用
        binding.tvName.setText("这是修改的")
        binding.btnC.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                Log.d("Main", "点击了按钮")
                binding.tvName.setText("我被点击了")
                val isExist = APPUtil.checkApkExist(this@MainActivity, pkName);
                if (isExist) {//启动app的指定页面
                    startLaunchAPK(this@MainActivity, pkName, "cc.lecent.prison.BootActivity")
                }
            }
        })

        binding.btnExit.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                System.exit(0)
            }
        })

        binding.btnA.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

            }
        })
    }


    //通过包名启动第三方应用启动页
    fun startLaunchAPK(context: Context, packageName: String) {
        Log.d(tag, "启动中。。。" + packageName)
        var mainAct: String? = null
        val pkgMag = context.packageManager
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_LAUNCHER)
        intent.flags = Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED or Intent.FLAG_ACTIVITY_NEW_TASK
        //如果已经启动apk，则直接将apk从后台调到前台运行（类似home键之后再点击apk图标启动），如果未启动apk，则重新启动
        @SuppressLint("WrongConstant")
        val list = pkgMag.queryIntentActivities(
            intent,
            PackageManager.GET_ACTIVITIES
        )
        for (i in list.indices) {
            val info = list[i]
            if (info.activityInfo.packageName == packageName) {
                mainAct = info.activityInfo.name
                break
            }
        }
        if (TextUtils.isEmpty(mainAct)) {
            return
        }
        //启动到app的主页或启动到原来留下的位置
        intent.component = ComponentName(packageName, mainAct!!)
        //启动app
        context.startActivity(intent)
        Log.d(tag, "启动成功。。。")
    }

    /**
     * 该方法，通过包名，调起指定类
     */
    fun startLaunchAPK(context: Context, packageName: String, activityName: String) {
        val intent = Intent()
        Log.d(tag, "指定类名跳转 >>> pkgName " + packageName + "   activityName >>> " + activityName)
        // 启动指定的activity页面
        intent.component = ComponentName(packageName, activityName)
        //启动app
        context.startActivity(intent)
        Log.d(tag, "启动成功。。。")
    }

    fun startAPKBySchema(context: Context) {
//        val data: Uri = Uri.parse("arouter://cc.lecent.prison/ca/CaActivity?token='xxxx'&name='jjjj'")
//        val data: Uri = Uri.parse("arouter://cc.lecent.prison/home/HomeActivity?token='xxxx'&name='jjjj'")
        val data: Uri =
            Uri.parse("arouter://cc.lecent.prison/boot/BootActivity?token='xxxx'&name='jjjj'")
        val intent = Intent(Intent.ACTION_VIEW, data)
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        //启动app
        context.startActivity(intent)
        Log.d(tag, "启动成功。。。")
    }

    override fun inflateBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }
}