package com.pocket.zxpa;

import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/*import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;*/

import com.zh.pocket.PocketSdk;
import com.zh.pocket.ads.interstitial.InterstitialAD;
import com.zh.pocket.ads.interstitial.InterstitialADListener;
import com.zh.pocket.ads.reward_video.RewardVideoAD;
import com.zh.pocket.ads.reward_video.RewardVideoADListener;
import com.zh.pocket.error.ADError;

import org.cocos2dx.javascript.AppActivity;

//import com.zh.pocket.PocketSdk;

//此类仅用于测试 这是早期的口袋官方代码里拿出来的包名和对应参数
//注意 正式接入时请将此类移动到正式包名一致的前缀包名文件夹里
public class App extends Application
{
    /*@Override
    protected void attachBaseContext(Context base)
    {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }*/
    @Override
    public void onCreate()
    {
        super.onCreate();
        //初始化报错提示
        //SpiderMan.init(this);
        /*CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(this);*/
        Log.d("Pocket","初始化sdk！");
        PocketSdk.initSDK(this,"xiaomi","1");
    }
    //尝试符合包名
    public static void hello()
    {
        AppActivity.app.runOnUiThread(new Runnable() {
            @Override
            public void run()
            {
                Toast.makeText(AppActivity.app, "hello world", Toast.LENGTH_SHORT).show();
            }
        });

    }
    //尝试符合包名
    public static void showAD(String type,String id)
    {
        Log.d("showAd","showAd被调用");
        Log.d("showAd","type:"+type+" id:"+id);
        AppActivity.app.runOnUiThread(new Runnable() {
            @Override
            public void run()
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(AppActivity.app);
                Toast.makeText(AppActivity.app, "showAd被调用,type:"+type+"id:"+id, Toast.LENGTH_SHORT).show();
                if(type.equals("inter"))
                {
                    InterstitialAD interstitialAD = new InterstitialAD(AppActivity.app,id);
                    interstitialAD.setInterstitialADListener(new InterstitialADListener() {
                        @Override
                        public void onFailed(ADError adError)
                        {
                            Log.d("AdError",adError.toString());
                            builder.setTitle("广告错误");
                            builder.setMessage(adError.toString());
                            builder.show();
                            //return "AdError"+adError.toString();
                        }

                        @Override
                        public void onADExposure() {

                        }

                        @Override
                        public void onADClicked() {

                        }

                        @Override
                        public void onADClosed() {

                        }

                        @Override
                        public void onSuccess() {

                        }

                        @Override
                        public void onADLoaded() {

                        }
                    });
                    interstitialAD.showAD();
                }
                else if(type.equals("reward"))
                {
                    RewardVideoAD rewardVideoAD = new RewardVideoAD(AppActivity.app,id);
                    rewardVideoAD.setRewardVideoADListener(new RewardVideoADListener() {
                        @Override
                        public void onFailed(ADError adError)
                        {
                            Log.d("AdError",adError.toString());
                            builder.setTitle("广告错误");
                            builder.setMessage(adError.toString());
                            builder.show();
                        }

                        @Override
                        public void onSuccess() {

                        }

                        @Override
                        public void onVideoCached() {

                        }

                        @Override
                        public void onADShow() {

                        }

                        @Override
                        public void onADExposure() {

                        }

                        @Override
                        public void onReward() {

                        }

                        @Override
                        public void onADClicked() {

                        }

                        @Override
                        public void onADClosed() {

                        }

                        @Override
                        public void onVideoComplete() {

                        }

                        @Override
                        public void onSkippedVideo() {

                        }

                        @Override
                        public void onADLoaded() {

                        }
                    });
                    rewardVideoAD.loadAD();
                }
            }
        });

    }
}
