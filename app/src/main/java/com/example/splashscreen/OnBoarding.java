package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rd.PageIndicatorView;

public class OnBoarding extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout dotsLayout;

    SliderAdapter sliderAdapter;

    Button letsGo, skip, next;
    Animation fadeInAnim, fadeOutAnim;
    int currentPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        viewPager = findViewById(R.id.slider);
        letsGo = findViewById(R.id.lets_go_btn);
        skip = findViewById(R.id.skip_btn);
        next = findViewById(R.id.next_btn);

        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);
        viewPager.addOnPageChangeListener(changeListener);
    }

    public void skip(View view) {
        startActivity(new Intent(this, Login.class));
        finish();
    }

    public void next(View view) {
        viewPager.setCurrentItem(currentPos + 1);
    }

    public void letsGo(View view) {
        startActivity(new Intent(this, Login.class));
        finish();
    }


//    private void addDots(int position) {
//        dots = new TextView[numberofPages];
//        dotsLayout.removeAllViews();
//
//        for (int i = 0; i < dots.length; i++) {
//            dots[i] = new TextView(this);
//            dots[i].setText(Html.fromHtml("&#8226;"));
//            dots[i].setTextSize(35);
//
//            dotsLayout.addView(dots[i]);
//
//        }
//
//        if (dots.length > 0) {
//            dots[position].setTextColor(getResources().getColor(R.color.colorPrimary));
//
//        }
//    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            currentPos = position;
            if (position == 0) {
                letsGo.setVisibility(View.INVISIBLE);
                skip.setVisibility(View.VISIBLE);
                next.setVisibility(View.VISIBLE);

            } else if (position == 1) {
                letsGo.setVisibility(View.INVISIBLE);
                skip.setVisibility(View.VISIBLE);
                next.setVisibility(View.VISIBLE);

            } else {
                fadeInAnim = AnimationUtils.loadAnimation(OnBoarding.this, R.anim.slide_anim);
                letsGo.setAnimation(fadeInAnim);
                fadeOutAnim = AnimationUtils.loadAnimation(OnBoarding.this, R.anim.exit_anim);
                skip.setAnimation(fadeOutAnim);
                next.setAnimation(fadeOutAnim);
                letsGo.setVisibility(View.VISIBLE);
                skip.setVisibility(View.INVISIBLE);
                next.setVisibility(View.INVISIBLE);

            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}