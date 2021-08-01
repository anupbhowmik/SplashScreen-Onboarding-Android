package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;

import java.util.ArrayList;
import java.util.List;

public class UserDashboard extends AppCompatActivity {

    ViewPager viewPager;
    ViewPagerAdapter adapter;
    ArrayList<Model> models;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        models = new ArrayList<>();
        models.add(new Model(R.drawable.three, "Physics"));
        models.add(new Model(R.drawable.two, "Chemistry"));
        models.add(new Model(R.drawable.one, "Biology"));
        models.add(new Model(R.drawable.four, "Math"));
        models.add(new Model(R.drawable.three, "Physics"));
        models.add(new Model(R.drawable.two, "Chemistry"));
        models.add(new Model(R.drawable.one, "Biology"));
        models.add(new Model(R.drawable.four, "Math"));

        adapter = new ViewPagerAdapter(models, this);

        viewPager = findViewById(R.id.viewPager_new);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(320, 0, 320, 0);

    }
}