package com.xiaofenyu.travel;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

//闪退捕获
public class CrashHandler implements Thread.UncaughtExceptionHandler {
    public static final String tag = "CrashHandler";
    private Thread.UncaughtExceptionHandler mHandler;
    //实例
    private static CrashHandler instance;
    //用来存储设备信息和异常信息
    private Map<String, String> infos = new HashMap<>();
    //用于格式化日期，作为日志文件的一部分
    //private DataFormat
    public Context mContext;

    public CrashHandler() {
    }

    public static CrashHandler getInstance() {
        if (instance == null) {
            instance = new CrashHandler();
        }
        return instance;
    }

    //初始化
    public void init(Context context) {
        mContext = context;
        //取默认处理器
        mHandler = Thread.getDefaultUncaughtExceptionHandler();
        //设置此类为处理器
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    //当发生异常时
    @Override
    public void uncaughtException(@NonNull Thread thread, @NonNull Throwable ex) {
        //如果没处理 系统默认处理
        if (!handelException(ex) && mHandler != null) {
            mHandler.uncaughtException(thread, ex);
        } else {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Log.e(tag, "error", e);
            }
        }
        //退出程序
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }

    public boolean handelException(Throwable ex)
    {
        if(ex == null)
        {
            return false;
        }
        //收集设备参数信息
        collectDeviceInfo(mContext);
        //使用Toast显示异常
        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                Toast.makeText(mContext,"程序异常！",Toast.LENGTH_LONG).show();
                Looper.loop();
            }
        }).start();
        //保存日志文件
        saveCrashInfo(ex);
        //重启客户端
        restartApplication();
        return true;
    }

    private void restartApplication()
    {
        final Intent intent = mContext.getPackageManager().getLaunchIntentForPackage(mContext.getPackageName());
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        mContext.startActivity(intent);
    }
    //保存错误文件
    private String saveCrashInfo(Throwable ex)
    {
        Log.d(tag,ex.getMessage());
        StringBuffer sb = new StringBuffer();
        Writer writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);
        ex.printStackTrace(printWriter);
        Throwable cause = ex.getCause();
        while (cause != null)
        {
            cause.printStackTrace(printWriter);
            cause = cause.getCause();
        }
        printWriter.close();
        String result = writer.toString();
        sb.append(result);
        try{
            long timestamp = System.currentTimeMillis();
            String fileName = "crash-" + timestamp + ".log";
            String file_dir = getFilePath();
            File dir = new File(file_dir);
            if(!dir.exists())
            {
                dir.mkdir();
            }
            File file = new File(file_dir + fileName);
            if(!file.exists())
            {
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(sb.toString().getBytes());
            fos.close();
            return fileName;
        }catch (Exception e)
        {
            Log.d(tag,"写报错日志异常！",e);
        }
        return null;
    }

    private String getFilePath()
    {
        String file_dir = "";
        boolean is_sdcard_exist = Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
        boolean is_root_exist = mContext.getExternalFilesDir("cocos_crash_log").exists();
        if (is_sdcard_exist && is_root_exist)
        {
            file_dir = mContext.getExternalFilesDir("cocos_crash_log").getAbsolutePath();
        }else
            {

            }
        return file_dir;
    }

    private void collectDeviceInfo(Context mContext) {
    }
}
