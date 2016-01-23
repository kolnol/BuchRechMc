package com.fortum.nokid.buchrechmc.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.ndk.CrashlyticsNdk;
import com.fortum.nokid.buchrechmc.Entities.Exercise;
import com.fortum.nokid.buchrechmc.Entities.Konto;
import com.fortum.nokid.buchrechmc.Fragments.ExerciseListTabFragment;
import com.fortum.nokid.buchrechmc.InitializationRealm;
import com.fortum.nokid.buchrechmc.RealmClasses.RealmInteger;
import com.fortum.nokid.buchrechmc.RealmClasses.Migration;
import com.fortum.nokid.buchrechmc.Entities.Page;
import com.fortum.nokid.buchrechmc.Entities.Question;
import com.fortum.nokid.buchrechmc.Fragments.QuestionListTabFragment;
import com.fortum.nokid.buchrechmc.Adapters.QuestionsAdapterRecycleView;
import com.fortum.nokid.buchrechmc.R;
import com.fortum.nokid.buchrechmc.RealmClasses.RealmString;
import com.fortum.nokid.buchrechmc.Sprint.SprintSetupActivity;
import com.fortum.nokid.buchrechmc.Fragments.TabFragmentPage;
import com.fortum.nokid.buchrechmc.Adapters.TabViewPagerAdapter;
import com.fortum.nokid.buchrechmc.Entities.VorlesungPDF;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import io.fabric.sdk.android.Fabric;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmList;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import io.realm.exceptions.RealmError;
import io.realm.exceptions.RealmMigrationNeededException;

public class MainActivity extends AppCompatActivity
                            implements NavigationView.OnNavigationItemSelectedListener{
    public static Context contextMain;
    public static Realm realm;

    private RealmResults<Question> results;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics(), new CrashlyticsNdk());
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


        contextMain=this;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startSprint();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //Check if it is first run
        Boolean isFirstRun=getSharedPreferences("Preference",MODE_PRIVATE)
                .getBoolean("isFirstRun", true);
        //If it is first run the we have to initialize the realm database
        if(isFirstRun){
            String path = copyBundledRealmFile(this.getResources().openRawResource(R.raw.default0),"default0");

            //Set the trigger to false
            getSharedPreferences("Preference",MODE_PRIVATE).edit()
                    .putBoolean("isFirstRun",false).commit();
        }

        initDatabase();

    }

    private void initRealmTest(){
        RealmConfiguration config1 = new RealmConfiguration.Builder(this)
                .name("default0")
                .schemaVersion(0)
                .migration(new Migration())
                .build();

        try{
            realm = Realm.getInstance(config1);
        }catch (RealmError er){
            Snackbar.make(this.viewPager, er.getMessage(),Snackbar.LENGTH_SHORT).show();
        }

        InitializationRealm.getInstance(realm).initRealm();
    }

    private void setupViewPager(ViewPager viewPager) {
        TabViewPagerAdapter adapter = new TabViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new QuestionListTabFragment(), "MC");// Fragment and Title

        // todo uncomment this
        // adapter.addFragment(new ExerciseListTabFragment(), "Übung");

        viewPager.setAdapter(adapter);
    }

    private String copyBundledRealmFile(InputStream inputStream, String outFileName) {
        try {
            File file = new File(this.getFilesDir(), outFileName);
            FileOutputStream outputStream = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buf)) > 0) {
                outputStream.write(buf, 0, bytesRead);
            }
            outputStream.close();
            return file.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void initDatabase() {
        RealmConfiguration config1 = new RealmConfiguration.Builder(this)
                .name("default0")
                .schemaVersion(0)
                .migration(new Migration())
                .build();

        try{
            realm = Realm.getInstance(config1);
        }catch (RealmError er){
            Snackbar.make(this.viewPager, er.getMessage(),Snackbar.LENGTH_SHORT).show();
        }

        //if it is an update and database was not copied then copy
        if(realm.allObjects(Question.class).size()==0){
            String path = copyBundledRealmFile(this.getResources().openRawResource(R.raw.default0),"default0");
        }

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            goToQuestionBucket();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void goToQuestionBucket() {
        Intent intent = new Intent(this,BucketListActivity.class);
        startActivity(intent);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.vorlesung1) {
            readPDF( "vorlesung1.pdf");
        } else if (id == R.id.vorlesung2){
            readPDF( "vorlesung2.pdf");
        } else if (id == R.id.vorlesung3){
            readPDF("vorlesung3.pdf");
        } else if (id == R.id.vorlesung4) {
            readPDF("vorlesung4.pdf");
        }else if(id==R.id.vorlesung5){
            readPDF("vorlesung5.pdf");
        }else if(id==R.id.vorlesung6) {
            readPDF("vorlesung6.pdf");
        }else {
            Snackbar.make(this.viewPager, "Kommt bald",Snackbar.LENGTH_SHORT).show();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void changeAdapter(int from,int to){
        results = realm.where(Question.class).between("id", from, to).findAll();

        QuestionsAdapterRecycleView adapter = new QuestionsAdapterRecycleView(results,this);

        //recyclerView.setAdapter(adapter);
    }

    private void readPDF(String pdfName){
        Intent intent = new Intent(this,PdfActivity.class);
        intent.putExtra("pdfName",pdfName);
        startActivity(intent);
    }


    private void startSprint(){
        Intent intent = new Intent(this,SprintSetupActivity.class);
        startActivity(intent);
    }

}


