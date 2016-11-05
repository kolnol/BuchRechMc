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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.ndk.CrashlyticsNdk;
import com.fortum.nokid.buchrechmc.Adapters.TabViewPagerAdapter;
import com.fortum.nokid.buchrechmc.AsyncTasks.GetAllQuestionsTask;
import com.fortum.nokid.buchrechmc.AsyncTasks.LoginTask;

import com.fortum.nokid.buchrechmc.Entities.Answer;
import com.fortum.nokid.buchrechmc.Entities.Question;
import com.fortum.nokid.buchrechmc.Entities.User;
import com.fortum.nokid.buchrechmc.Fragments.QuestionListTabFragment;
import com.fortum.nokid.buchrechmc.R;
import com.fortum.nokid.buchrechmc.Sprint.SprintSetupActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;

import io.fabric.sdk.android.Fabric;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmList;
import io.realm.RealmResults;
import io.realm.exceptions.RealmError;

public class MainActivity extends AppCompatActivity
                            implements NavigationView.OnNavigationItemSelectedListener{
    public static Context contextMain;
    public static Realm realm;


    private RealmResults<Question> results;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Fabric Testing Tool
        Fabric.with(this, new Crashlytics(), new CrashlyticsNdk());
        //Set Layout
        setContentView(R.layout.activity_main);
        //Set the vertical orientation of the screen
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        setupUser();
        setupViewPager();
        setupTabLayout();
        setupToolBar();
        setupFloatingButton();
        setupDrawerLayout();
        setupNavigationView();
        setupDatabase();
        saveUser();

    }

    private void setupUser() {
        Intent intent = getIntent();
        String sessionId = intent.getStringExtra("sessionId");
        String email = intent.getStringExtra("email");
        String password = intent.getStringExtra("password");

        this.user = new User(password, email, sessionId);
        this.user.getEmail();
    }

    private void setupViewPager() {
        //Element for tabs content
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
    }

    private void setupTabLayout() {
        //Element for tabs
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void setupFloatingButton() {
        //Floating button setup
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startSprint();
            }
        });
    }

    private void setupDrawerLayout() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
    }

    private void setupNavigationView() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void setupDatabase() {
        //Initialization of Realm
        Realm.init(this);
        realm = Realm.getDefaultInstance();
        //Check if it is first run
        Boolean isFirstRun = getSharedPreferences("Preference", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);
        //If it is first run then we have to initialize the realm database
        setupUser();
        if (isFirstRun) {

            fillDatabase();

            //Set the trigger to false
            getSharedPreferences("Preference", MODE_PRIVATE).edit()
                    .putBoolean("isFirstRun", false).apply();//todo change to false
        }
    }

    private void fillDatabase() {
        try {
            GetAllQuestionsTask getAllQuestion = new GetAllQuestionsTask(this.getApplicationContext());
            getAllQuestion.execute(user.getSessionId());
            realm.beginTransaction();
            realm.createOrUpdateAllFromJson(Question.class, getAllQuestion.get());
            realm.commitTransaction();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private void saveUser(){
        realm.beginTransaction();
        realm.delete(User.class);
        realm.copyToRealm(user);
        realm.commitTransaction();
    }

    /////////////////////
    //Activity View Setup
    /////////////////////
    private void setupViewPager(ViewPager viewPager) {
        TabViewPagerAdapter adapter = new TabViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new QuestionListTabFragment(), "MC");// Fragment and Title

        // todo uncomment this for exercise tab
        // adapter.addFragment(new ExerciseListTabFragment(), "Übung");

        viewPager.setAdapter(adapter);
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

    /////////////////////
    //Help Functions
    /////////////////////
    private void goToQuestionBucket() {
        Intent intent = new Intent(this,BucketListActivity.class);
        startActivity(intent);
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

    /////////////////////
    //Database setup
    /////////////////////

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
//        RealmConfiguration config1 = new RealmConfiguration.Builder(this)
//                .name("default0")
//                .schemaVersion(0)
//                .deleteRealmIfMigrationNeeded()
//                //.migration(new Migration())
//                .build();
//        try{
//            realm = Realm.getInstance(config1);
//        }catch (RealmError er){
//            Snackbar.make(this.viewPager, er.getMessage(),Snackbar.LENGTH_SHORT).show();
//        }
//        String path3 = copyBundledRealmFile(this.getResources().openRawResource(R.raw.default0), "default0");
//
//        //if it is an update and database was not copied then copy
//        if(realm.where(Question.class).findAll().size()==0){
//            String path = copyBundledRealmFile(this.getResources().openRawResource(R.raw.default0),"default0");
//        }

    }
}


