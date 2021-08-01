package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIME = 2500;
    Animation topAnim, bottomAnim;
    ImageView image;
    TextView title, website;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        // for hiding status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // for hiding status bar
        setContentView(R.layout.activity_main);

        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_anim);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.scale_in);

        image = findViewById(R.id.splash_image);
        title = findViewById(R.id.app_name);
        website = findViewById(R.id.website);

        image.setAnimation(topAnim);
        title.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                sharedPreferences = getSharedPreferences("sharedPreferences", MODE_PRIVATE);
                boolean isFirstTime = sharedPreferences.getBoolean("firstTime", true);

                if (isFirstTime) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("firstTime", false);
                    editor.commit();

                    Intent intent = new Intent(MainActivity.this, OnBoarding.class);
                    startActivity(intent);
                    finish();
                } else {

                    Intent intent = new Intent(MainActivity.this, Login.class);
                    // comment the previous line and uncomment the next line for one time onBoarding show

//                    Intent intent = new Intent(MainActivity.this, UserDashboard.class);
                    Pair[] pairs = new Pair[2];
                    pairs[0] = new Pair<View, String>(image, "splash_image");
                    pairs[1] = new Pair<View, String>(title, "app_name");

                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                    startActivity(intent, options.toBundle());
                    finish();
                }
            }
        }, SPLASH_TIME);
    }
}