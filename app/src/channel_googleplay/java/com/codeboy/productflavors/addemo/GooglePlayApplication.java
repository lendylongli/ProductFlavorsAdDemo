package com.codeboy.productflavors.addemo;

import android.content.Context;

import com.codeboy.helper.AdHelper;
import com.codeboy.helper.AdmobAdHelper;

/**
 * Create Date 2014/8/22 20:22<br>
 * @uthor Leon Lee<br>
 * codeboy2013@gmail.com<br>
 * 适配Google Play的Application
 */
public class GooglePlayApplication extends ProductFlavorsAdDemoApplication {

    /** 广告栏的单元广告ID*/
    static final String ADMOB_BANNER_AD_UNITID = "ca-app-pub-4153488707541252/9266563325";
    /** 插屏广告的单元广告ID*/
    static final String ADMOB_INTERSTITIA_AD_UNITID = "ca-app-pub-4153488707541252/3060409326";

    /** 覆写返回Admob广告的AdHelper*/
    @Override
    public AdHelper getAdHelper(Context context, boolean isAutoLoadBannerAd, boolean isAutoLoadInterstitiaAd) {
        return new AdmobAdHelper(context, ADMOB_BANNER_AD_UNITID, ADMOB_INTERSTITIA_AD_UNITID);
    }
}