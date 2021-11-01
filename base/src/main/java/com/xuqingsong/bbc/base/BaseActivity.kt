package com.xuqingsong.bbc.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<Binding : ViewBinding> : AppCompatActivity() {
    lateinit var binding: Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //
        binding = inflateBinding()
        setContentView(binding.root)
    }

    /**
     * 返回ViewBinding
     */
    abstract fun inflateBinding(): Binding;

}