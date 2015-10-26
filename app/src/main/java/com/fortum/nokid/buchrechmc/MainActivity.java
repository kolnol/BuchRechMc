package com.fortum.nokid.buchrechmc;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.File;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmList;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static Context contextMain;
    public static Realm realm;
    private RecyclerView recyclerView;
    private RealmResults<Question> results;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contextMain=this;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Coming Soon :)", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        recyclerView=(RecyclerView)findViewById(R.id.questionsList);

        RealmConfiguration config1 = new RealmConfiguration.Builder(this)
                .name("default")
                .schemaVersion(0)
                .migration(new Migration())
                .build();

        realm = Realm.getInstance(config1);

        initRealm(realm);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        results = realm.where(Question.class).between("id", 0, realm.allObjects(Question.class).size() - 1).findAll();

        QuestionsAdapterRecycleView adapter = new QuestionsAdapterRecycleView(results,this);

        recyclerView.setAdapter(adapter);
    }

    public void goToFullQuestion(View v,int position) {
        Intent intent = new Intent(this,FullQuestionActivity.class);
        intent.putExtra("position", position);
        startActivity(intent);
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
            readPDF(recyclerView);
        } else if (id == R.id.vorlesung2) {

        } else if (id == R.id.vorlesung3) {

        } else if (id == R.id.vorlesung4) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void changeAdapter(int from,int to){
        results = realm.where(Question.class).between("id", from, to).findAll();

        QuestionsAdapterRecycleView adapter = new QuestionsAdapterRecycleView(results,this);

        recyclerView.setAdapter(adapter);
    }

    private void readPDF(View v){
       startActivity(new Intent(this,PdfActivity.class));

    }

    private void initRealm(Realm realm){
        String questionStr1 = "Welcher Teilbereich des Rechnungswesens ist dem externen Rechnungswesen zugeordnet?";
        RealmList<RealmString> answers = new RealmList<>();
        answers.add(new RealmString("Statistik-undVergleichsrechnung"));
        answers.add(new RealmString("Kosten- und Leistungsrechnung"));
        answers.add(new RealmString("Finanzbuchhaltung"));
        answers.add(new RealmString("Planungsrechnung"));

        Question question1 = new Question(0,questionStr1,answers,0);

        String questionStr2 = "Das externe Rechnungswesen...";
        RealmList<RealmString> answers2 = new RealmList<>();
        answers2.add(new RealmString("ist unternehmensspezifisch gestaltbar"));
        answers2.add(new RealmString("wird durch den Betriebsrat gestaltet"));
        answers2.add(new RealmString("wird durch Wirtschaftsprüfer festgelegt"));
        answers2.add(new RealmString("unterliegtgesetzlichenVorschriften"));

        Question question2 = new Question(1,questionStr2,answers2,0);

        String questionStr3 = "Wer ist kein Adressat des Jahresabschlusses?";
        RealmList<RealmString> answers3 = new RealmList<>();
        answers3.add(new RealmString("Eigentümer"));
        answers3.add(new RealmString("Gläubiger"));
        answers3.add(new RealmString("Unternehmensleitung"));
        answers3.add(new RealmString("Abschlussprüfer"));

        Question question3 = new Question(2,questionStr3,answers3,0);

        String questionStr4 = "Was ist keine Aufgabe des externen Rechnungswesens?";
        RealmList<RealmString> answers4 = new RealmList<>();
        answers4.add(new RealmString("Abbildung der finanziellen Beziehung des Unternehmens zu seiner Umwelt"));
        answers4.add(new RealmString("Planung, Kontrolle und Steuerung des Betriebsgeschehens"));
        answers4.add(new RealmString("Rechnungslegung/BilanzierungaufgrundgesetzlicherVorschriften"));
        answers4.add(new RealmString("Erstellung des Jahresabschlusses"));

        Question question4 = new Question(3,questionStr4,answers4,0);


        realm.beginTransaction();
        realm.clear(Question.class);
        realm.copyToRealm(question1);
        realm.copyToRealm(question2);
        realm.copyToRealm(question3);
        realm.copyToRealm(question4);
        realm.commitTransaction();
    }
}
