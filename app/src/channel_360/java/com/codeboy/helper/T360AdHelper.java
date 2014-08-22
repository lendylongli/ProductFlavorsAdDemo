package com.codeboy.helper;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;

import com.pubukeji.diandeows.AdType;
import com.pubukeji.diandeows.adviews.DiandeAdView;
import com.pubukeji.diandeows.adviews.DiandeBanner;

/**
 * Create Date 2014/8/22 21:18<br>
 *
 * @author LeonLee<br>
 * codeboy2013@gmail.com<br>
 * 360广告联盟
 */
public class T360AdHelper extends AdHelper {

    private final String banner_AD_ID;
    private final String insert_AD_ID;

    private DiandeBanner banner;
    private DiandeAdView insert;

    public T360AdHelper(Context context, String bannerId, String insertId) {
        super(context);
        banner_AD_ID = bannerId;
        insert_AD_ID = insertId;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        banner = new DiandeBanner(mContext, banner_AD_ID);
        insert = new DiandeAdView(mContext, insert_AD_ID, AdType.INSERTSCREEN);
    }

    @Override
    public void setBannerAdView(ViewGroup parent) {
        if(!isEnable()) {
            return;
        }
        parent.addView(banner);
        banner.show();
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
        insert.load();
        insert.show();
    }

    @Override
    public boolean isSupportInterstitialAd() {
        return true;
    }
}
