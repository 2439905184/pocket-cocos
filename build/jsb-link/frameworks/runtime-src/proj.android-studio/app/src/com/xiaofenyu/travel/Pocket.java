package com.xiaofenyu.travel;

import android.app.Application;
import android.util.Log;

import com.zh.pocket.PocketSdk;

//此类仅用于测试 这是早期的口袋官方代码里拿出来的包名和对应参数
//注意 正式接入时请将此类移动到正式包名一致的前缀包名文件夹里
public class Pocket extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        //初始化报错提示
        //SpiderMan.init(this);
        //PocketSdk.initSDK(this,"test", "10006");
        Log.d("Pocket","初始化sdk！");
    }
}
