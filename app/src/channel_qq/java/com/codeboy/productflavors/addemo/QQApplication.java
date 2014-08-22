/*
 * Copyright (c) 2014. CodeBoyTeam
 */

package com.codeboy.productflavors.addemo;

import android.content.Context;

import com.codeboy.helper.AdHelper;
import com.codeboy.helper.GdtmobAdHelper;

/**
 * Create Date 2014/8/22 21:39<br>
 *
 * @author LeonLee<br>
 * codeboy2013@gmail.com<br>
 * Description
 */
public class QQApplication extends ProductFlavorsAdDemoApplication {

    static final String APPId = "1102147386";
    static final String BannerPosId = "1060402020016054";
    static final String InterteristalPosId = "8050702090715095";

    //Test
    /*public static final String APPId = "1101152570";
    public static final String BannerPosId = "9079537218417626401";
    public static final String APPWallPosId = "9007479624379698465";
    public static final String InterteristalPosId = "8575134060152130849";
    public static final String SplashPosId = "8863364436303842593";
    public static final String GridAppWallPosId = "9007479624379698465";
    public static final String FeedsPosId  =   "8647191654190058785";*/

    @Override
    public AdHelper getAdHelper(Context context) {
        return new GdtmobAdHelper(context, APPId, BannerPosId, InterteristalPosId);
    }
}
