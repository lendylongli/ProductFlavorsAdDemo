package com.codeboy.productflavors.addemo;

import android.content.Context;

import com.codeboy.helper.AdHelper;
import com.codeboy.helper.FeiWoAdHelper;

/**
 * Create Date 2014/8/22 20:22<br>
 * @uthor Leon Lee<br>
 * codeboy2013@gmail.com<br>
 * 适配Google Play的Application
 */
public class AnZhiApplication extends ProductFlavorsAdDemoApplication {

    static final String FEIWOAPIKEY = "6df53cef666327a334686e16b14d0faa";

    //测试appkey
    //static final String FEIWOAPIKEY = "93db85ed909c13838ff95ccfa94cebd9";

    @Override
    public AdHelper getAdHelper(Context context) {
        return new FeiWoAdHelper(context, FEIWOAPIKEY);
    }
}