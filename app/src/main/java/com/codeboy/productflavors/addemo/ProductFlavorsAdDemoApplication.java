package com.codeboy.productflavors.addemo;

import android.app.Application;
import android.content.Context;
import android.view.ViewGroup;

import com.codeboy.helper.AdHelper;

/**
 * Create Date 2014/8/22 16:11<br>
 * @uthor Leon Lee<br>
 * codeboy2013@gmail.com<br>
 * Application基类
 */
public class ProductFlavorsAdDemoApplication extends Application {

    /** 获取广告处理类*/
    public AdHelper getAdHelper(Context context) {
        return new AdHelper(context) {

            @Override
            public boolean isEnable() {
                return false;
            }

            @Override
            public void setBannerAdView(ViewGroup parent) {

            }

            @Override
            public boolean isSupportBannerAdView() {
                return false;
            }

            @Override
            public void showInterstitialAd() {

            }

            @Override
            public boolean isSupportInterstitialAd() {
                return false;
            }
        };
    }
}
