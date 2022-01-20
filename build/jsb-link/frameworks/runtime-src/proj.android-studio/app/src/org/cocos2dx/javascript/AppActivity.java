/****************************************************************************
Copyright (c) 2015-2016 Chukong Technologies Inc.
Copyright (c) 2017-2018 Xiamen Yaji Software Co., Ltd.
 
http://www.cocos2d-x.org

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
****************************************************************************/
package org.cocos2dx.javascript;

import org.cocos2dx.lib.Cocos2dxActivity;
import org.cocos2dx.lib.Cocos2dxGLSurfaceView;
import org.cocos2dx.lib.Cocos2dxJavascriptJavaBridge;

import android.os.Bundle;

import android.content.Intent;
import android.content.res.Configuration;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.zh.pocket.ads.interstitial.InterstitialAD;
import com.zh.pocket.ads.interstitial.InterstitialADListener;
import com.zh.pocket.ads.reward_video.RewardVideoAD;
import com.zh.pocket.ads.reward_video.RewardVideoADListener;
import com.zh.pocket.error.ADError;

/*import com.zh.pocket.ads.banner.BannerAD;
import com.zh.pocket.ads.interstitial.InterstitialAD;
import com.zh.pocket.ads.reward_video.RewardVideoAD;*/

public class AppActivity extends Cocos2dxActivity
{
    public static AppActivity app = null;
    //移除SDKWrapper 用不着
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        app = this;
        // Workaround in
        // https://stackoverflow.com/questions/16283079/re-launch-of-activity-on-home-button-but-only-the-first-time/16447508
        if (!isTaskRoot()) {
            // Android launched another instance of the root activity into an existing task
            // so just quietly finish and go away, dropping the user back into the activity
            // at the top of the stack (ie: the last state of this task)
            // Don't need to finish it again since it's finished in super.onCreate .
            return;
        }
        // DO OTHER INITIALIZATION BELOW
       // SDKWrapper.getInstance().init(this);

    }

    @Override
    public Cocos2dxGLSurfaceView onCreateView() {
        Cocos2dxGLSurfaceView glSurfaceView = new Cocos2dxGLSurfaceView(this);
        // TestCpp should create stencil buffer
        glSurfaceView.setEGLConfigChooser(5, 6, 5, 0, 16, 8);
        //SDKWrapper.getInstance().setGLSurfaceView(glSurfaceView, this);

        return glSurfaceView;
    }

    @Override
    protected void onResume() {
        super.onResume();
        //SDKWrapper.getInstance().onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();
        //SDKWrapper.getInstance().onPause();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Workaround in https://stackoverflow.com/questions/16283079/re-launch-of-activity-on-home-button-but-only-the-first-time/16447508
        if (!isTaskRoot()) {
            return;
        }

        //SDKWrapper.getInstance().onDestroy();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //SDKWrapper.getInstance().onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        //SDKWrapper.getInstance().onNewIntent(intent);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //SDKWrapper.getInstance().onRestart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //SDKWrapper.getInstance().onStop();
    }

    @Override
    public void onBackPressed() {
        //SDKWrapper.getInstance().onBackPressed();
        super.onBackPressed();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        //SDKWrapper.getInstance().onConfigurationChanged(newConfig);
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        //SDKWrapper.getInstance().onRestoreInstanceState(savedInstanceState);
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //SDKWrapper.getInstance().onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onStart() {
        //SDKWrapper.getInstance().onStart();
        super.onStart();
    }
    public static void hello()
    {
        app.runOnUiThread(new Runnable() {
            @Override
            public void run()
            {
                Toast.makeText(app, "hello world", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public static void showAD(String type,String id)
    {
        Log.d("showAd","showAd被调用");
        Log.d("showAd","type:"+type+" id:"+id);
        app.runOnUiThread(new Runnable() {
            @Override
            public void run()
            {
                Toast.makeText(app, "showAd被调用,type:"+type+"id:"+id, Toast.LENGTH_SHORT).show();
                if(type.equals("inter"))
                {
                    InterstitialAD interstitialAD = new InterstitialAD(app,id);
                    interstitialAD.setInterstitialADListener(new InterstitialADListener() {
                        @Override
                        public void onFailed(ADError adError) {

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
                    RewardVideoAD rewardVideoAD = new RewardVideoAD(app,id);
                    rewardVideoAD.setRewardVideoADListener(new RewardVideoADListener() {
                        @Override
                        public void onFailed(ADError adError) {

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
