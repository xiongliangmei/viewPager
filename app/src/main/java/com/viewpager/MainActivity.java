package com.viewpager;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.viewpager.fragment.Fragment1;
import com.viewpager.fragment.Fragment2;
import com.viewpager.fragment.Fragment3;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //1.定义不同颜色的菜单项的标识:
    final private int RED = 110;
    final private int GREEN = 111;
    final private int BLUE = 112;
    final private int YELLOW = 113;
    final private int GRAY= 114;
    final private int CYAN= 115;
    final private int BLACK= 116;

    private TextView tv_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // setVp();
        tv_test = findViewById(R.id.tv_test);
    }

    private void setVp(){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 3;i++){
            list.add("第"+i+"个View");
        }
        ViewPager vp = findViewById(R.id.viewpager);
        vp.setAdapter(new PagerAdapter(this,list));
        //vp.setPageTransformer(false,new DepthPageTransformer());
        //vp.setPageTransformer(false,new ZoomOutPageTransformer());
        vp.setPageTransformer(false,new RotatePageTransformer());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(1,RED,4,"红色");
        menu.add(1,GREEN,4,"绿色");
        menu.add(1,BLUE,4,"蓝色");
        menu.add(1,YELLOW,4,"黄色");
        menu.add(1,GRAY,4,"灰色");
        menu.add(1,CYAN,4,"蓝绿色");
        menu.add(1,BLACK,4,"黑色");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case RED:
                tv_test.setTextColor(Color.RED);
                break;
            case GREEN:
                tv_test.setTextColor(Color.GREEN);
                break;
            case BLUE:
                tv_test.setTextColor(Color.BLUE);
                break;
            case YELLOW:
                tv_test.setTextColor(Color.YELLOW);
                break;
            case GRAY:
                tv_test.setTextColor(Color.GRAY);
                break;
            case CYAN:
                tv_test.setTextColor(Color.CYAN);
                break;
            case BLACK:
                tv_test.setTextColor(Color.BLACK);
                break;
        }
        return super.onOptionsItemSelected(item);
    }



}
