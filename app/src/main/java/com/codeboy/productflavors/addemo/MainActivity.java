package com.codeboy.productflavors.addemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup;

import com.codeboy.helper.AdHelper;

/**
 * Create Date 2014/8/22 20:05<br>
 * @uthor Leon Lee<br>
 * codeboy2013@gmail.com<br>
 * 主界面
 */
public class MainActivity extends Activity {

    private AdHelper mAdHelper;
    //是否已经按过返回键的标识
    private boolean isPressedBack = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //获取各个渠道实现的AdHelper
        mAdHelper = ((ProductFlavorsAdDemoApplication)getApplication()).getAdHelper(this);
        mAdHelper.onCreate(savedInstanceState);

        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ad_container);
        //加入广告栏
        mAdHelper.setBannerAdView(viewGroup);
    }

    @Override
    protected void onResume() {
        mAdHelper.onResume();
        super.onResume();
    }

    @Override
    protected void onPause() {
        mAdHelper.onPause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        mAdHelper.onDestroy();
        super.onDestroy();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            if(isPressedBack) {
                return super.onKeyDown(keyCode, event);
            }
            isPressedBack = true;
            //首次按下返回显示插屏广告
            mAdHelper.showInterstitialAd();
        }
        return super.onKeyDown(keyCode, event);
    }
}
