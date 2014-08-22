package com.codeboy.helper;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;

/**
 * Create Date 2014/8/22 16:04<br>
 * @uthor Leon Lee<br>
 * codeboy2013@gmail.com<br>
 * 广告处理基类
 */
public abstract class AdHelper {

    protected final Context mContext;
    private boolean isEnable = true;

    public AdHelper(Context context) {
        this.mContext = context;
    }

    public void onCreate(Bundle savedInstanceState) {

    }

    public void onPause() {

    }

    public void onResume() {

    }

    public void onDestroy () {

    }

    /** 设置广告栏View*/
    public abstract void setBannerAdView(ViewGroup parent);
    /** 是否支持广告栏广告*/
    public abstract boolean  isSupportBannerAdView();
    /** 显示插屏广告*/
    public abstract void showInterstitialAd();
    /** 是否支持插屏屏广告*/
    public abstract boolean isSupportInterstitialAd();

    /** 是否允许出现广告*/
    public boolean isEnable() {
        return isEnable;
    }

    /** 设置是否允许广告*/
    public void setEnable(boolean enable) {
        isEnable = enable;
    }
}
