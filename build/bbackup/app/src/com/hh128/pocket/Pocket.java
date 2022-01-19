package com.hh128.pocket;

import android.app.Application;

import com.zh.pocket.PocketSdk;

//注意 正式接入时请将此类移动到正式包名一致的前缀包名文件夹里
public class Pocket extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        PocketSdk.initSDK(this,"test", "10006");
    }
}
