package com.viewpager;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.View;

public class ZoomOutPageTransformer implements ViewPager.PageTransformer {

   private static float MIN_SCALE = 0.85f;
   private static float MIN_ALPHA = 0.5f;

    @Override
    public void transformPage(@NonNull View view, float v) {
        int pageWidth = view.getWidth();
        int pageHeight = view.getHeight();

        if (v < -1){
            view.setAlpha(0);
        }else if (v <= 1){
            float scaleFactor = Math.max(MIN_SCALE,1 - Math.abs(v));
            float vertMargin = pageHeight * (1 - scaleFactor) /2;
            float horzMargin = pageWidth *(1 - scaleFactor) /2;
            if (v < 0 ){
                view.setTranslationX(horzMargin - vertMargin / 2);
            }else {
                view.setTranslationX(-horzMargin + vertMargin /2);
            }
            view.setAlpha(MIN_ALPHA + (scaleFactor - MIN_SCALE)/ (1 - MIN_SCALE)*(1 - MIN_ALPHA));
        }else {
            view.setAlpha(0);
        }
    }
}
