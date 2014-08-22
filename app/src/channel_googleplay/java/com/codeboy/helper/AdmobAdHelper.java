package com.codeboy.helper;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

/**
 * Create Date 2014/8/22 20:20<br>
 * @uthor Leon Lee<br>
 * codeboy2013@gmail.com<br>
 * Admob广告
 */
public class AdmobAdHelper extends AdHelper {

    private AdView mBannerAdView;
    private String mBannerAdUnitId;
    private String mInterstitiaAdUnitId;
    private InterstitialAd mInterstitialAd;

    private boolean isLoadedBannerAd = false;
    private boolean isLoadedInterstitiaAd = false;

    private boolean isInterstitiaAdShow = false;

    public AdmobAdHelper(Context context, String bannerAdUnitId, String intersistialAdUnitId) {
        super(context);
        mBannerAdUnitId = bannerAdUnitId;
        mInterstitiaAdUnitId = intersistialAdUnitId;
    }

    public void setBannerAdUnitId(String bannerAdUnitId) {
        mBannerAdUnitId  = bannerAdUnitId;
    }

    public void setInterstitiaAdUnitId(String interstitiaAdUnitId) {
        mInterstitiaAdUnitId = interstitiaAdUnitId;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBannerAdView = new AdView(mContext);
        mBannerAdView.setAdUnitId(mBannerAdUnitId);
        mBannerAdView.setAdSize(AdSize.BANNER);

        loadBannerAd();

        // 制作插页式广告。
        mInterstitialAd = new InterstitialAd(mContext);
        mInterstitialAd.setAdUnitId(mInterstitiaAdUnitId);

        loadInterstitialAd();
    }

    /** 加载Banner广告*/
    public void loadBannerAd() {
        if(isLoadedBannerAd) {
            return;
        }
        // 启动一般性请求。
        AdRequest adRequest = new AdRequest.Builder().build();
        // 在adView中加载广告请求。
        mBannerAdView.loadAd(adRequest);
        isLoadedBannerAd = true;
    }

    /** 加载大屏广告*/
    public void loadInterstitialAd() {
        if(isLoadedInterstitiaAd) {
            return;
        }
        // 创建广告请求。
        AdRequest adRequest = new AdRequest.Builder().build();
        // 在adView中加载广告请求。
        mBannerAdView.loadAd(adRequest);

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                if(!isEnable()) {
                    return;
                }
                if(isInterstitiaAdShow && mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
            }
        });
        // 开始加载插页式广告。
        mInterstitialAd.loadAd(adRequest);
        isLoadedInterstitiaAd = true;
    }

    @Override
    public void onResume() {
        mBannerAdView.resume();
    }

    @Override
    public void onPause() {
        mBannerAdView.pause();
    }

    @Override
    public void onDestroy() {
        mBannerAdView.destroy();
    }

    @Override
    public void setBannerAdView(ViewGroup parent) {
        if(!isEnable()) {
            return;
        }
        loadBannerAd();
        parent.addView(mBannerAdView);
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
        loadInterstitialAd();
        isInterstitiaAdShow = true;
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }

    @Override
    public boolean isSupportInterstitialAd() {
        return true;
    }
}