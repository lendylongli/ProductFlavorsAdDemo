/*
 * Copyright (c) 2014. CodeBoyTeam
 */

package com.codeboy.helper;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;

import com.qq.e.ads.AdRequest;
import com.qq.e.ads.AdSize;
import com.qq.e.ads.AdView;
import com.qq.e.ads.InterstitialAd;
import com.qq.e.ads.InterstitialAdListener;

/**
 * Create Date 2014/8/22 21:31<br>
 *
 * @author LeonLee<br>
 * codeboy2013@gmail.com<br>
 * Description
 */
public class GdtmobAdHelper extends AdHelper {

    private AdView bannerAD;
    private  InterstitialAd interstitialAd;

    private String mAppId;
    private String mBannerPosId;
    private String mInterstitiaPosId;

    private boolean isInterstitiaAdShow = false;
    private boolean isInterstitiaAdLoaded = false;

    public GdtmobAdHelper(Context context, String appid, String bannerposId, String interstitiaposId) {
        super(context);
        mAppId = appid;
        mBannerPosId = bannerposId;
        mInterstitiaPosId = interstitiaposId;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bannerAD = new AdView((Activity)mContext, AdSize.BANNER, mAppId, mBannerPosId);
        interstitialAd = new InterstitialAd((Activity)mContext, mAppId, mInterstitiaPosId);

        interstitialAd.setAdListener(new InterstitialAdListener() {
            @Override
            public void onBack() {}

            @Override
            public void onFail() {}

            @Override
            public void onAdReceive() {
                isInterstitiaAdLoaded = true;
                if(!isEnable()) {
                    return;
                }
                if(isInterstitiaAdShow) {
                    interstitialAd.show((Activity)mContext);
                }
            }
        });
        interstitialAd.loadAd();
    }

    @Override
    public void setBannerAdView(ViewGroup parent) {
        if(!isEnable()) {
            return;
        }
        parent.addView(bannerAD);
        AdRequest adr = new AdRequest();
        //adr.setTestAd(true);
        adr.setRefresh(35);
        bannerAD.fetchAd(adr);
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
        isInterstitiaAdShow = true;
        if(isInterstitiaAdLoaded) {
            interstitialAd.show((Activity)mContext);
        }
    }

    @Override
    public boolean isSupportInterstitialAd() {
        return true;
    }
}
