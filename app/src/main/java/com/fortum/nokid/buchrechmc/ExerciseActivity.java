package com.fortum.nokid.buchrechmc;

import android.os.Bundle;
import android.support.design.widget.TabLayout;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class ExerciseActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);


        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ExerciseViewPagerAdapter adapter = new ExerciseViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new TabFragmentPage(), "Aufgabe");// Fragment and Title
        adapter.addFragment(new TabFragmentPage(), "BS");
        adapter.addFragment(new TabFragmentPage(), "Kontoliste");
        viewPager.setAdapter(adapter);
    }
}
