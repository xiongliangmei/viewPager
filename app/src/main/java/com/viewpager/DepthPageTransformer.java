package com.viewpager;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.View;

public class DepthPageTransformer implements ViewPager.PageTransformer {

    private  static  float MIN_SCALE = 0.75f;
    @Override
    public void transformPage(@NonNull View view, float v) {
        int pageWidth = view.getWidth();

        if (v < -1){
            view.setAlpha(0);
        }else if ( v <= 0){
            view.setAlpha(1);
            view.setTranslationX(0);
            view.setScaleX(1);
            view.setScaleY(1);
        }else if ( v <= 1){
            view.setAlpha(1 - v);
            view.setTranslationX(pageWidth * -v);
            // Scale the page down (between MIN_SCALE and 1)
            float scaleFactor = MIN_SCALE
                    + (1 - MIN_SCALE) * (1 - Math.abs(v));
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);
        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
            view.setAlpha(0);
        }

    }
}
