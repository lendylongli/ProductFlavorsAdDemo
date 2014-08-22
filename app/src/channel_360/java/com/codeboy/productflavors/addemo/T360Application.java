package com.codeboy.productflavors.addemo;

import android.content.Context;

import com.codeboy.helper.AdHelper;
import com.codeboy.helper.T360AdHelper;

/**
 * Create Date 2014/8/22 21:19<br>
 *
 * @author LeonLee<br>
 * codeboy2013@gmail.com<br>
 * 安智广告入口
 */
public class T360Application extends ProductFlavorsAdDemoApplication {

    static final String BANNER_AD_ID = "e77ed68b292ec1ea4b3b0061a642445d";
    static final String INSERT_AD_ID = "3f3ad0af63474e66f8ae72e2f1e24c03";

    /*//Test bannerid
    static final String BANNER_AD_ID = "bb92999153bbc9861de3399be84c3a14";
    //Test insertid
    static final String INSERT_AD_ID = "78c5db4fd9bb8367ba26868893847738";*/

    @Override
    public AdHelper getAdHelper(Context context) {
        return new T360AdHelper(context, BANNER_AD_ID, INSERT_AD_ID);
    }
}
