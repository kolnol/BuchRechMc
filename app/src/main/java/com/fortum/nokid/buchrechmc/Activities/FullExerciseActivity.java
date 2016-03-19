package com.fortum.nokid.buchrechmc.Activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.fortum.nokid.buchrechmc.Adapters.TabViewPagerAdapter;
import com.fortum.nokid.buchrechmc.Fragments.ExerciseTextFragment;
import com.fortum.nokid.buchrechmc.Fragments.TabFragmentPage;
import com.fortum.nokid.buchrechmc.R;

public class FullExerciseActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);


        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ExerciseTextFragment exerciseTextFragment= ExerciseTextFragment.newInstance("Das ist Aufgabe Text","Das ist Beleg Text");

        TabViewPagerAdapter adapter = new TabViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(exerciseTextFragment, "Aufgabe");// Fragment and Title
        adapter.addFragment(new TabFragmentPage(), "BS");
        adapter.addFragment(new TabFragmentPage(), "Kontoliste");
        viewPager.setAdapter(adapter);
    }
}
