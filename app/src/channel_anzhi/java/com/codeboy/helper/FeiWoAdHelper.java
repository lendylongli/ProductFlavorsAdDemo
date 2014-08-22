package com.codeboy.helper;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;

import com.feiwo.view.FwBannerManager;
import com.feiwo.view.FwInterstitialManager;

/**
 * Create Date 2014/8/22 20:20<br>
 * @uthor Leon Lee<br>
 * codeboy2013@gmail.com<br>
 * 飞沃广告
 */
public class FeiWoAdHelper extends AdHelper {

    final String feiwoAppkey;

    public FeiWoAdHelper(Context context, String appkey) {
        super(context);
        feiwoAppkey = appkey;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //初始化插屏
        FwInterstitialManager.init(mContext, feiwoAppkey);
        //初始化应用墙
        //FwRecommendManage.getInstance().init(mContext, feiwoAppkey);
        //初始化banner
        FwBannerManager.init(mContext, feiwoAppkey);
    }

    @Override
    public void setBannerAdView(ViewGroup parent) {
        if(!isEnable()) {
            return;
        }
        FwBannerManager.setParentView(parent);
    }

    @Override
    public boolean isSupportBannerAdView() {
        return true;
    }

    @Override
    public void showInterstitialAd() {
        if(!isEnable()) {
            return;
        }
        //FwInterstitialManager.showInterstitial();
        FwInterstitialManager.showFullScreenInterstitial();
    }

    @Override
    public boolean isSupportInterstitialAd() {
        return true;
    }
}