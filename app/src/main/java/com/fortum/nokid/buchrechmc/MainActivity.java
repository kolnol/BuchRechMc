package com.fortum.nokid.buchrechmc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.ndk.CrashlyticsNdk;
import io.fabric.sdk.android.Fabric;
import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmList;
import io.realm.RealmResults;
import io.realm.exceptions.RealmMigrationNeededException;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static Context contextMain;
    public static Realm realm;
    private RecyclerView recyclerView;
    private RealmResults<Question> results;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics(), new CrashlyticsNdk());
        setContentView(R.layout.activity_main);

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

        recyclerView=(RecyclerView)findViewById(R.id.questionsList);

        RealmConfiguration config1 = new RealmConfiguration.Builder(this)
                .name("default")
                .schemaVersion(0)
                .migration(new Migration())
                .build();

        try{
            realm = Realm.getInstance(config1);
        }catch (RealmMigrationNeededException e){
            realm.deleteRealm(config1);
            realm = Realm.getInstance(config1);
            initRealm(realm);
        }

        //Check if it is first run
        Boolean isFirstRun=getSharedPreferences("Preference",MODE_PRIVATE)
                .getBoolean("isFirstRun", true);
        //If it is first run the we have to initialize the realm database
        if(isFirstRun){
            initRealm(realm);
            //Set the trigger to false
            getSharedPreferences("Preference",MODE_PRIVATE).edit()
                    .putBoolean("isFirstRun",false).commit();
        }



        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //TODO 
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
            readPDF(recyclerView, "vorlesung1.pdf");
        } else if (id == R.id.vorlesung2) {
            readPDF(recyclerView, "vorlesung2.pdf");

        } else if (id == R.id.vorlesung3) {

        } else if (id == R.id.vorlesung4) {

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

    private void readPDF(View v,String pdfName){
        Intent intent = new Intent(this,PdfActivity.class);
        intent.putExtra("pdfName",pdfName);
        startActivity(intent);
    }

    private void initRealm(Realm realm){


        String questionStr1 = "Welcher Teilbereich des Rechnungswesens ist dem externen Rechnungswesen zugeordnet?";
        RealmList<RealmString> answers = new RealmList<>();
        answers.add(new RealmString("Statistik-undVergleichsrechnung"));
        answers.add(new RealmString("Kosten- und Leistungsrechnung"));
        answers.add(new RealmString("Finanzbuchhaltung"));
        answers.add(new RealmString("Planungsrechnung"));

        Question question1 = new Question(0,questionStr1,answers,2);

        String questionStr2 = "Das externe Rechnungswesen...";
        RealmList<RealmString> answers2 = new RealmList<>();
        answers2.add(new RealmString("ist unternehmensspezifisch gestaltbar"));
        answers2.add(new RealmString("wird durch den Betriebsrat gestaltet"));
        answers2.add(new RealmString("wird durch Wirtschaftsprüfer festgelegt"));
        answers2.add(new RealmString("unterliegtgesetzlichenVorschriften"));

        Question question2 = new Question(1,questionStr2,answers2,3);

        String questionStr3 = "Wer ist kein Adressat des Jahresabschlusses?";
        RealmList<RealmString> answers3 = new RealmList<>();
        answers3.add(new RealmString("Eigentümer"));
        answers3.add(new RealmString("Gläubiger"));
        answers3.add(new RealmString("Unternehmensleitung"));
        answers3.add(new RealmString("Abschlussprüfer"));

        Question question3 = new Question(2,questionStr3,answers3,3);

        String questionStr4 = "Was ist keine Aufgabe des externen Rechnungswesens?";
        RealmList<RealmString> answers4 = new RealmList<>();
        answers4.add(new RealmString("Abbildung der finanziellen Beziehung des Unternehmens zu seiner Umwelt"));
        answers4.add(new RealmString("Planung, Kontrolle und Steuerung des Betriebsgeschehens"));
        answers4.add(new RealmString("Rechnungslegung/BilanzierungaufgrundgesetzlicherVorschriften"));
        answers4.add(new RealmString("Erstellung des Jahresabschlusses"));

        Question question4 = new Question(3,questionStr4,answers4,1);

        String questionStr5 = "Das Betriebsergebnis ergibt sich durch Saldierung von ...";
        RealmList<RealmString> answers5 = new RealmList<>();
        answers5.add(new RealmString("Erlös und Kosten"));
        answers5.add(new RealmString("Ertrag und Aufwand"));
        answers5.add(new RealmString("Einnahme und Ausgabe"));
        answers5.add(new RealmString("Einzahlung und Auszahlung"));

        Question question5 = new Question(4,questionStr5,answers5,0);

        ////
        String questionStr6 = "Die Saldierung von Einnahmen und Ausgaben ergibt ...";
        RealmList<RealmString> answers6 = new RealmList<>();
        answers6.add(new RealmString("das Betriebsergebnis"));
        answers6.add(new RealmString("das Jahresergebnis"));
        answers6.add(new RealmString("den Finanzsaldo"));
        answers6.add(new RealmString("den Zahlungssaldo"));

        Question question6 = new Question(5,questionStr6,answers6,2);
        ////

        ////
        String questionStr7 = "Markieren Sie die korrekte Definition für Einnahmen!";
        RealmList<RealmString> answers7 = new RealmList<>();
        answers7.add(new RealmString("Monetärer Wert der in einer Wirtschaftsperiode abgegebenen Wirtschaftsgüter"));
        answers7.add(new RealmString("Zahlungsmittel, die einem Unternehmen innerhalb einer Periode zufließen"));
        answers7.add(new RealmString("Monetärbewerteter,durchLeistungserstellungbedingterWertzuwachs"));
        answers7.add(new RealmString("Wertzuwachs einer Periode (erfolgswirksam)"));

        Question question7 = new Question(6,questionStr7,answers7,0);
        ////

        ////
        String questionStr8 = "Markieren Sie die korrekte Definition für Kosten!";
        RealmList<RealmString> answers8 = new RealmList<>();
        answers8.add(new RealmString("Verbrauch bzw. Gebrauch von Wirtschaftsgütern (erfolgswirksam)"));
        answers8.add(new RealmString("Monetärbewerteter,durchLeistungserstellungbedingterGüter-undDienstleistungsverzehr"));
        answers8.add(new RealmString("Monetärer Wert der in einer Periode einem Unternehmen zugegangenen Wirtschaftsgüter"));
        answers8.add(new RealmString("Zahlungsmittel, die von einem Unternehmen innerhalb einer Periode abfließen"));

        Question question8 = new Question(7,questionStr8,answers8,2);
        ////


        ////
        String questionStr9 = "„Monetärer Wert der in einer Periode einem Unternehmen zugegangenen Wirtschaftsgüter“ ist die Definition für ...";
        RealmList<RealmString> answers9 = new RealmList<>();
        answers9.add(new RealmString("Ausgaben"));
        answers9.add(new RealmString("Einnahmen"));
        answers9.add(new RealmString("Aufwendungen"));
        answers9.add(new RealmString("Erlös"));

        Question question9 = new Question(8,questionStr9,answers9,0);
        ////

        ////
        String questionStr10 = "“Zahlungsmittel, die von einem Unternehmen innerhalb einer Periode abfließen“ ist die Definition für ...";
        RealmList<RealmString> answers10 = new RealmList<>();
        answers10.add(new RealmString("Auszahlungen"));
        answers10.add(new RealmString("Einzahlungen"));
        answers10.add(new RealmString("Einnahmen"));
        answers10.add(new RealmString("Erträge"));

        Question question10 = new Question(9,questionStr10,answers10,0);
        ////

        ////
        String questionStr11 = "Der Geschäftsvorfall „Bezahlung von Maschinen, die in der Vorperiode geliefert wurden“ ist ein(e)";
        RealmList<RealmString> answers11 = new RealmList<>();
        answers11.add(new RealmString("Auszahlung"));
        answers11.add(new RealmString("Auszahlung und Ausgabe"));
        answers11.add(new RealmString("Einnahme"));
        answers11.add(new RealmString("Ausgabe"));

        Question question11 = new Question(10,questionStr11,answers11,0);
        ////

        ////
        String questionStr12 = "Der Geschäftsvorfall „Bezahlung von Maschinen, die in der Folgeperiode geliefert werden“ ist ein(e)";
        RealmList<RealmString> answers12 = new RealmList<>();
        answers12.add(new RealmString("Auszahlung"));
        answers12.add(new RealmString("Auszahlung und Ausgabe"));
        answers12.add(new RealmString("Einnahme"));
        answers12.add(new RealmString("Ausgabe"));

        Question question12 = new Question(11,questionStr12,answers12,0);
        ////

        ////
        String questionStr13 = "Der Geschäftsvorfall „Einkauf von Waren für 600 € auf Ziel“ ist eine";
        RealmList<RealmString> answers13 = new RealmList<>();
        answers13.add(new RealmString("Auszahlung"));
        answers13.add(new RealmString("Auszahlung und Ausgabe"));
        answers13.add(new RealmString("Einnahme"));
        answers13.add(new RealmString("Ausgabe"));

        Question question13 = new Question(12,questionStr13,answers13,3,"￼Hinweis:" + "Hier ist immer die Annahme, dass das Wirtschaftsgut gleich dem K");
        ////

        ////
        String questionStr14 = "Der Geschäftsvorfall „Einkauf von Rohstoffen mit Barbezahlung“ ist eine";
        RealmList<RealmString> answers14 = new RealmList<>();
        answers14.add(new RealmString("Auszahlung"));
        answers14.add(new RealmString("Auszahlung und Ausgabe"));
        answers14.add(new RealmString("Einnahme"));
        answers14.add(new RealmString("Einzahlung und Einnahme"));

        Question question14 = new Question(13,questionStr14,answers14,1);
        ////

        ////
        String questionStr15 = "Der Geschäftsvorfall „Einkauf von Holzbrettern für 200 € auf Ziel“ ist ein(e)";
        RealmList<RealmString> answers15 = new RealmList<>();
        answers15.add(new RealmString("Ausgabe"));
        answers15.add(new RealmString("Ausgabe und Aufwand"));
        answers15.add(new RealmString("Aufwand"));
        answers15.add(new RealmString("Auszahlung,Ausgabe und Aufwand"));

        Question question15 = new Question(14,questionStr15,answers15,0,"￼Hinweis:\n" + "Da keine Angabe, wann der Verbrauch stattfindet, wird nicht geprüft ob ein Aufwand vorherrscht; also: Aufwand wird nur bei expliziter Angabe des Verbrauchs ge");
        ////

        ////
        String questionStr16 = "Der Geschäftsvorfall „Einkauf von Holzbrettern für 200 € auf Ziel, die in der übernächsten Periode verbraucht werden“ ist ein(e)";
        RealmList<RealmString> answers16 = new RealmList<>();
        answers16.add(new RealmString("Ausgabe"));
        answers16.add(new RealmString("Ausgabe und Aufwand"));
        answers16.add(new RealmString("Aufwand"));
        answers16.add(new RealmString("Auszahlung,Ausgabe und Aufwand"));

        Question question16 = new Question(15,questionStr16,answers16,0);
        ////

        ////
        String questionStr17 = "Der Geschäftsvorfall „Einkauf von Holzbrettern für 200 € auf Ziel, die sofort verbraucht werden“ ist ein(e)";
        RealmList<RealmString> answers17 = new RealmList<>();
        answers17.add(new RealmString("Ausgabe"));
        answers17.add(new RealmString("Ausgabe und Aufwand"));
        answers17.add(new RealmString("Aufwand"));
        answers17.add(new RealmString("Auszahlung,Ausgabe und Aufwand"));

        Question question17 = new Question(16,questionStr17,answers17,1);
        ////

        ////
        String questionStr18 = "Der Geschäftsvorfall „Planmäßige lineare Abschreibung einer Produktionsmaschine“ ist ein(e)";
        RealmList<RealmString> answers18 = new RealmList<>();
        answers18.add(new RealmString("Ausgabe"));
        answers18.add(new RealmString("Ausgabe und Aufwand"));
        answers18.add(new RealmString("Aufwand"));
        answers18.add(new RealmString("Auszahlung,Ausgabe und Aufwand"));

        Question question18 = new Question(17,questionStr18,answers18,2);
        ////

        ////
        String questionStr19 = "Der Geschäftsvorfall „Außerplanmäßige Abschreibung einer Produktionsmaschine“ ist ein(e)";
        RealmList<RealmString> answers19 = new RealmList<>();
        answers19.add(new RealmString("Ausgabe"));
        answers19.add(new RealmString("Ausgabe und Aufwand"));
        answers19.add(new RealmString("Aufwand"));
        answers19.add(new RealmString("Auszahlung,Ausgabe und Aufwand"));

        Question question19 = new Question(18,questionStr19,answers19,2);
        ////

        ////
        String questionStr20 = "Der Geschäftsvorfall „Bildung von Rückstellungen“ ist ein(e)";
        RealmList<RealmString> answers20 = new RealmList<>();
        answers20.add(new RealmString("Ausgabe"));
        answers20.add(new RealmString("Ausgabe und Aufwand"));
        answers20.add(new RealmString("Aufwand"));
        answers20.add(new RealmString("Auszahlung,Ausgabe und Aufwand"));

        Question question20 = new Question(19,questionStr20,answers20,2);
        ////

        ////
        String questionStr21 = "Der Geschäftsvorfall „Verkauf von Waren für 700 € auf Kredit“ ist ein(e)";
        RealmList<RealmString> answers21 = new RealmList<>();
        answers21.add(new RealmString("Einnahme"));
        answers21.add(new RealmString("Ausgabe"));
        answers21.add(new RealmString("Ertrag"));
        answers21.add(new RealmString("Aufwand"));

        Question question21 = new Question(20,questionStr21,answers21,0);
        ////

        ////
        String questionStr22 = "Der Geschäftsvorfall „Wertminderung eines Geschäftsfahrzeuges“ ist ein(e)";
        RealmList<RealmString> answers22 = new RealmList<>();
        answers22.add(new RealmString("Ausgabe"));
        answers22.add(new RealmString("Ausgabe und Aufwand"));
        answers22.add(new RealmString("Aufwand"));
        answers22.add(new RealmString("Auszahlung,Ausgabe und Aufwand"));

        Question question22 = new Question(21,questionStr22,answers22,2);
        ////

        ////
        String questionStr23 = "￼Der Geschäftsvorfall „Bezahlung von Miete für ein Geschäftsbüro per Überweisung“ ist ein(e)";
        RealmList<RealmString> answers23 = new RealmList<>();
        answers23.add(new RealmString("Ausgabe"));
        answers23.add(new RealmString("Ausgabe und Aufwand"));
        answers23.add(new RealmString("Aufwand"));
        answers23.add(new RealmString("Auszahlung,Ausgabe und Aufwand"));

        Question question23 = new Question(22,questionStr23,answers23,3);
        ////

        ////
        String questionStr24 = "￼Der Geschäftsvorfall „Bezahlung von Miete für ein Geschäftsbüro per Überweisung“ ist ein(e)";
        RealmList<RealmString> answers24 = new RealmList<>();
        answers24.add(new RealmString("Ausgabe"));
        answers24.add(new RealmString("Ausgabe und Aufwand"));
        answers24.add(new RealmString("Aufwand"));
        answers24.add(new RealmString("Auszahlung,Ausgabe und Aufwand"));

        Question question24 = new Question(23,questionStr24,answers24,0);
        ////

        ////
        String questionStr25 = "Der Geschäftsvorfall „Kauf einer Produktionsmaschine zum Preis von 100.000 €“ ist ein(e)";
        RealmList<RealmString> answers25 = new RealmList<>();
        answers25.add(new RealmString("Ausgabe"));
        answers25.add(new RealmString("Ausgabe und Aufwand"));
        answers25.add(new RealmString("Aufwand"));
        answers25.add(new RealmString("Auszahlung,Ausgabe und Aufwand"));

        Question question25 = new Question(24,questionStr25,answers25,0,"Hinweis:" +
                                                                        "Da keine Angabe, ob Kauf auf Kredit oder in bar => unklar, ob Auszahlung oder nicht, hier aber nicht relevant zur Beantwortung der MC-");
        ////

        ////
        String questionStr26 = "Der Geschäftsvorfall „Gewährung eines Barkredites in Höhe von 1.111 €“ ist eine";
        RealmList<RealmString> answers26 = new RealmList<>();
        answers26.add(new RealmString("Auszahlung"));
        answers26.add(new RealmString("Einnahme"));
        answers26.add(new RealmString("Einzahlung"));
        answers26.add(new RealmString("Einnahme und Einzahlung"));

        Question question26 = new Question(25,questionStr26,answers26,0);
        ////

        ////
        String questionStr27 = "Der Geschäftsvorfall „Tilgung eines Darlehens in Höhe von 50.000 €“ ist eine";
        RealmList<RealmString> answers27 = new RealmList<>();
        answers27.add(new RealmString("Auszahlung"));
        answers27.add(new RealmString("Auszahlung und Ausgabe"));
        answers27.add(new RealmString("Einnahme"));
        answers27.add(new RealmString("Ausgabe"));

        Question question27 = new Question(26,questionStr27,answers27,1);
        ////

        ////
        String questionStr28 = "Der Geschäftsvorfall „Barverkauf von Waren für 300 €“ ist eine";
        RealmList<RealmString> answers28 = new RealmList<>();
        answers28.add(new RealmString("Einzahlung"));
        answers28.add(new RealmString("Einzahlung und Einnahme"));
        answers28.add(new RealmString("Einnahme"));
        answers28.add(new RealmString("Ausgabe"));

        Question question28 = new Question(27,questionStr28,answers28,0);
        ////

        ////
        String questionStr29 = "￼Der Geschäftsvorfall „Verkauf von Sachvermögen zum Buchwert von 5.000 €“ ist ein(e)";
        RealmList<RealmString> answers29 = new RealmList<>();
        answers29.add(new RealmString("Einnahme"));
        answers29.add(new RealmString("Ausgabe"));
        answers29.add(new RealmString("Ertrag"));
        answers29.add(new RealmString("Aufwand"));

        Question question29 = new Question(28,questionStr29,answers29,2);
        ////

        ////
        String questionStr30 = "Der Geschäftsvorfall „Verkauf von Waren für 600 € auf Kredit“ ist eine";
        RealmList<RealmString> answers30 = new RealmList<>();
        answers30.add(new RealmString("Einzahlung"));
        answers30.add(new RealmString("Einzahlung und Einnahme"));
        answers30.add(new RealmString("Einnahme"));
        answers30.add(new RealmString("Ausgabe"));

        Question question30 = new Question(29,questionStr30,answers30,0);
        ////

        ////
        String questionStr31 = "Der Geschäftsvorfall „Verkauf von Waren für 600 € gegen Barzahlung“ ist ein";
        RealmList<RealmString> answers31 = new RealmList<>();
        answers31.add(new RealmString("Einzahlung"));
        answers31.add(new RealmString("Auszahlung"));
        answers31.add(new RealmString("Ausgabe"));
        answers31.add(new RealmString("Keine der vorherigen Antworten ist richtig"));

        Question question31 = new Question(30,questionStr31,answers31,2,"￼Hinweis:" + "es handelt sich um eine Einnahme und Einzahlung; aber Einnahme nicht als");
        ////

        ////
        String questionStr32 = "Der Geschäftsvorfall „Werterhöhung eigener Sachvermögensgegenstände um 100 €“ ist ein(e)";
        RealmList<RealmString> answers32 = new RealmList<>();
        answers32.add(new RealmString("Einzahlung"));
        answers32.add(new RealmString("Einnahme und Ertrag"));
        answers32.add(new RealmString("Ertrag"));
        answers32.add(new RealmString("Aufwand"));

        Question question32 = new Question(31,questionStr32,answers32,3);
        ////

        ////
        String questionStr33 = "Der Geschäftsvorfall „Kunde bezahlt für eine Dienstleistung 6.000 € in bar“ ist ein(e)";
        RealmList<RealmString> answers33 = new RealmList<>();
        answers33.add(new RealmString("Einnahme"));
        answers33.add(new RealmString("Einnahme und Ertrag"));
        answers33.add(new RealmString("Ertrag"));
        answers33.add(new RealmString("Einzahlung, Einnahme und Ertrag"));

        Question question33 = new Question(32,questionStr33,answers33,0);
        ////

        ////
        String questionStr34 = "Der Geschäftsvorfall „Kredit an befreundetes Unternehmen wird von diesem getilgt“ ist eine";
        RealmList<RealmString> answers34 = new RealmList<>();
        answers34.add(new RealmString("Einzahlung"));
        answers34.add(new RealmString("Einzahlung und Einnahme"));
        answers34.add(new RealmString("Einnahme"));
        answers34.add(new RealmString("Ausgabe"));

        Question question34 = new Question(33,questionStr34,answers34,0);
        ////

        ////
        String questionStr35 = "Der Geschäftsvorfall „Aufnahme eines Barkredites (z.B. Bankdarlehen) über 95.000 €“ ist eine";
        RealmList<RealmString> answers35 = new RealmList<>();
        answers35.add(new RealmString("Einzahlung"));
        answers35.add(new RealmString("Auszahlung"));
        answers35.add(new RealmString("Einnahme"));
        answers35.add(new RealmString("Ausgabe"));

        Question question35 = new Question(34,questionStr35,answers35,0);
        ////
                    ///KAPITEL 1.2///
        ////
        String questionStr36 = "Im nationalen deutschen Handelsrecht gilt";
        RealmList<RealmString> answers36 = new RealmList<>();
        answers36.add(new RealmString("nur das HGB"));
        answers36.add(new RealmString("das HGB und GoB"));
        answers36.add(new RealmString("das HGB, GoB und IFRS"));
        answers36.add(new RealmString("das HGB, GoB, IFRS und US-GAAP"));

        Question question36 = new Question(35,questionStr36,answers36,"1.2",1);
        ////

        ////
        String questionStr37 = "Welche der vorliegenden Rechnungslegungsvorschriften ist NICHT gesetzlich definiert?";
        RealmList<RealmString> answers37 = new RealmList<>();
        answers37.add(new RealmString("HGB"));
        answers37.add(new RealmString("GoB"));
        answers37.add(new RealmString("IFRS"));
        answers37.add(new RealmString("US-GAAP"));

        Question question37 = new Question(36,questionStr37,answers37,"1.2",1);
        ////

        ////
        String questionStr38 = "Wenn Rechtsvorschriften des Aktiengesetzes (AktG) für eine Aktiengesellschaft von denen des HGB abweichen, ...";
        RealmList<RealmString> answers38 = new RealmList<>();
        answers38.add(new RealmString("hat das HGB Vorrang."));
        answers38.add(new RealmString("hat das HGB Vorrang."));
        answers38.add(new RealmString("muss sinnvoll abgewogen werden, welches Gesetz Anwendung findet."));
        answers38.add(new RealmString("hatdasAktGVorrang."));

        Question question38 = new Question(37,questionStr38,answers38,"1.2",3);
        ////

        ////
        String questionStr39 = "Kommen für Einzelkaufleute und Personenhandelsgesellschaften weitere Vorschriften zur Rechnungslegung über das HGB hinaus in Betracht?";
        RealmList<RealmString> answers39 = new RealmList<>();
        answers39.add(new RealmString("Ja, das AktG und - möglicherweise - branchenspezifische Regelungen."));
        answers39.add(new RealmString("Ja, das GmbHG und - möglicherweise - branchenspezifische Regelungen."));
        answers39.add(new RealmString("Ja, PublG und - möglicherweise - branchenspezifische Regelungen."));
        answers39.add(new RealmString("Möglicherweise branchenspezifische Regelungen."));

        Question question39 = new Question(38,questionStr39,answers39,"1.2",2);
        ////

        ////
        String questionStr40 = "Die nicht am Kapitalmarkt orientierte Langsam OHG, die keine Tochterunternehmen besitzt, ...";
        RealmList<RealmString> answers40 = new RealmList<>();
        answers40.add(new RealmString("muss keinen Einzelabschluss erstellen."));
        answers40.add(new RealmString("muss einen Einzelabschluss erstellen."));
        answers40.add(new RealmString("kann einen Konzernabschluss erstellen, um ihr Image aufzuwerten."));
        answers40.add(new RealmString("muss sowohl einen Einzelabschluss als auch einen Konzernabschluss erstellen."));

        Question question40 = new Question(39,questionStr40,answers40,"1.2",1);
        ////

        ////
        String questionStr41 = "Die nicht kapitalmarktorientierte Schnöller OHG, ansässig in Deutschland mit Tochterunternehmen im In- und Ausland und insgesamt 150 Arbeitnehmern und einem Umsatz von ca. 5 Millionen € in den vergangenen drei Geschäftsjahren ...";
        RealmList<RealmString> answers41 = new RealmList<>();
        answers41.add(new RealmString("muss einen Einzelabschluss nach HGB erstellen."));
        answers41.add(new RealmString("muss einen Einzelabschluss nach IFRS erstellen."));
        answers41.add(new RealmString("darf keinen Konzernabschluss erstellen, weil sie den größenabhängigen Befreiungen von § 293 HGB nicht genügt."));
        answers41.add(new RealmString("muss sowohl einen Einzelabschluss nach HGB als auch einen Konzernabschluss nach HGB erstellen."));

        Question question41 = new Question(40,questionStr41,answers41,"1.2",0);
        ////

        ////
        String questionStr42 = "Die kapitalmarktorientierte Fast OHG, ansässig in Deutschland mit Tochterunternehmen im In- und Ausland und insgesamt 150 Arbeitnehmern und einem Umsatz von ca. 5 Millionen € in den vergangenen drei Geschäftsjahren ...";
        RealmList<RealmString> answers42 = new RealmList<>();
        answers42.add(new RealmString("muss nur den Einzelabschluss (EA) erstellen."));
        answers42.add(new RealmString("muss keinen Konzernabschluss erstellen, weil sie den größenabhängigen Befreiungen von § 293 HGB genügt."));
        answers42.add(new RealmString("muss einen EA und kann einen Konzernabschluss nach IFRS erstellen, um ihr Image aufzuwerten."));
        answers42.add(new RealmString("muss sowohl einen Einzelabschluss nach HGB als auch einen Konzernabschluss nach IFRS erstellen."));

        Question question42 = new Question(41,questionStr42,answers42,"1.2",0);
        ////
        ////
        String questionStr43 = "Die nicht kapitalmarktorientierte Slow AG ansässig in Deutschland mit Tochterunternehmen im In- und Ausland und insgesamt 350 Arbeitnehmern und einem Umsatz von ca. 50 Millionen € jeweils in den vergangenen drei Geschäftsjahren ...";
        RealmList<RealmString> answers43 = new RealmList<>();
        answers43.add(new RealmString("muss einen Einzelabschluss nach HGB aber keinen Konzernabschluss erstellen."));
        answers43.add(new RealmString("muss einen Einzelabschluss nach HGB und einen Konzernabschluss nach HGB erstellen."));
        answers43.add(new RealmString("muss einen Einzelabschluss nach HGB und einen Konzernabschluss nach IFRS erstellen."));
        answers43.add(new RealmString("muss einen Einzelabschluss nach HGB und einen Konzernabschluss nach HGB oder IFRS erstellen."));

        Question question43 = new Question(42,questionStr43,answers43,"1.2",0);
        ////

        ////
        String questionStr44 = "Die kapitalmarktorientierte Schnöllerle AG, ansässig in Deutschland mit Tochterunternehmen ausschließlich im Inland ...";
        RealmList<RealmString> answers44 = new RealmList<>();
        answers44.add(new RealmString("muss einen Einzelabschluss (EA) nach HGB und einen Konzernabschluss nach HGB erstellen."));
        answers44.add(new RealmString("muss einen Einzelabschluss nach HGB und einen Konzernabschluss nach HGB oder IFRS erstellen."));
        answers44.add(new RealmString("muss einen Einzelabschluss nach HGB und einen Konzernabschluss nach IFRS erstellen."));
        answers44.add(new RealmString("muss einen Einzelabschluss nach HGB und einen Konzernabschluss nach HGB und IFRS erstellen."));

        Question question44 = new Question(43,questionStr44,answers44,"1.2",2);
        ////

        ////
        String questionStr45 = "Für einen Einzelunternehmer gelten handelsrechtlich ...";
        RealmList<RealmString> answers45 = new RealmList<>();
        answers45.add(new RealmString("nur die §§ 264 bis 289a HGB."));
        answers45.add(new RealmString("nur die §§ 238 bis 263 HGB."));
        answers45.add(new RealmString("nur die §§ 238 bis 289a HGB."));
        answers45.add(new RealmString("die §§ 238 bis 335 HGB."));

        Question question45 = new Question(44,questionStr45,answers45,1,"1.2","Anmerkung:" +
                "Handelsrechtlich heißt, dass hier nur Vorschriften des HGB betrachtet werden." +
                "Anmerkung für Nicht-Muttersprachler:" +
                "„Nur die“ bedeutet, dass keine weiteren Gesetzestexte außer die Genannten gelten. „Nur die“ macht die Antwort eindeutig, angenommen die größte Teilmenge (hier Nummer D) wäre korrekt. Ohne dem Wort „nur“ in den ersten drei Antwortmöglichkeiten wären alle vier Fragen korrekt.");
        ////

        ////
        String questionStr46 = "Für eine AG ohne Tochterunternehmen gelten handelsrechtlich ...";
        RealmList<RealmString> answers46 = new RealmList<>();
        answers46.add(new RealmString("nur die §§ 264 bis 289a HGB."));
        answers46.add(new RealmString("nur die §§ 238 bis 263 HGB."));
        answers46.add(new RealmString("nur die §§ 238 bis 289a HGB."));
        answers46.add(new RealmString("die §§ 238 bis 335 HGB."));

        Question question46 = new Question(45,questionStr46,answers46,"1.2",2);
        ////

        ////
        String questionStr47 = "Für eine OHG gelten handelsrechtlich ...";
        RealmList<RealmString> answers47 = new RealmList<>();
        answers47.add(new RealmString("nur die §§ 264 bis 289a HGB."));
        answers47.add(new RealmString("nur die §§ 238 bis 263 HGB."));
        answers47.add(new RealmString("nur die §§ 238 bis 289a HGB."));
        answers47.add(new RealmString("die §§ 238 bis 335 HGB."));

        Question question47 = new Question(46,questionStr47,answers47,"1.2",1);
        ////


        ////
        String questionStr48 = "Die Vorschriften für einen Konzern ...";
        RealmList<RealmString> answers48 = new RealmList<>();
        answers48.add(new RealmString("sind eigenständig."));
        answers48.add(new RealmString("sind in den §§ 238 bis 263 HGB geregelt."));
        answers48.add(new RealmString("sind in den §§ 263 bis 289a HGB geregelt."));
        answers48.add(new RealmString("bauen auf den Normen auf, die für alle Kaufleute und für Kapitalgesellschaften gelten."));

        Question question48 = new Question(47,questionStr48,answers48,"1.2",3);
        ////

        ////
        String questionStr49 = "Für eine GmbH ohne Tochterunternehmen gelten handelsrechtlich ...";
        RealmList<RealmString> answers49 = new RealmList<>();
        answers49.add(new RealmString("nur die §§ 264 bis 289a HGB."));
        answers49.add(new RealmString("nur die §§ 238 bis 263 HGB."));
        answers49.add(new RealmString("nur die §§ 238 bis 289a HGB."));
        answers49.add(new RealmString("die §§ 238 bis 335 HGB."));

        Question question49 = new Question(48,questionStr49,answers49,"1.2",2);
        ////

        ////
        String questionStr50 = "Für eine GmbH mit Tochterunternehmen gelten handelsrechtlich ...";
        RealmList<RealmString> answers50 = new RealmList<>();
        answers50.add(new RealmString("nur die §§ 264 bis 289a HGB."));
        answers50.add(new RealmString("nur die §§ 238 bis 263 HGB."));
        answers50.add(new RealmString("nur die §§ 238 bis 289a HGB."));
        answers50.add(new RealmString("die §§ 238 bis 335 HGB."));

        Question question50 = new Question(49,questionStr50,answers50,"1.2",3);
        ////

        ////
        String questionStr51 = "Für eine GmbH ohne Tochterunternehmen gelten ...";
        RealmList<RealmString> answers51 = new RealmList<>();
        answers51.add(new RealmString("nur die §§ 264 bis 289a HGB."));
        answers51.add(new RealmString("nur die §§ 238 bis 263 HGB und das GmbHG."));
        answers51.add(new RealmString("nur die §§ 238 bis 289a HGB."));
        answers51.add(new RealmString("nur die §§ 238 bis 289a HGB und das GmbHG."));

        Question question51 = new Question(50,questionStr51,answers51,"1.2",3);
        ////

        ////
        String questionStr52 = "Die Rechnungslegungsvorschriften des HGB funktionieren – vereinfacht ausgedrückt – nach dem Prinzip ...";
        RealmList<RealmString> answers52 = new RealmList<>();
        answers52.add(new RealmString("„vom Allgemeinen zum Speziellen“."));
        answers52.add(new RealmString("„vom Speziellen zum Allgemeinen“."));
        answers52.add(new RealmString("„vom Schwierigem zum Trivialen“."));
        answers52.add(new RealmString("der Trennung aller Rechtsformen in spezielle Gesetzestexte."));

        Question question52 = new Question(51,questionStr52,answers52,"1.2",0);
        ////

        ////
        String questionStr53 = "Dürfen die Vorschriften der §§ 264 ff. HGB grundsätzlich auch von kleinen Personenhandelsgesellschaften und Einzelkaufleuten angewandt werden?";
        RealmList<RealmString> answers53 = new RealmList<>();
        answers53.add(new RealmString("Nein, nur die §§ 238-263 HGB dürfen (und müssen) angewandt werden."));
        answers53.add(new RealmString("Nein, nur die §§ 1-263 HGB dürfen (und müssen) angewandt werden."));
        answers53.add(new RealmString("Nein, die §§ 264 ff. HGB müssen angewandt werden. Es besteht Pflicht und nicht Wahlrecht."));
        answers53.add(new RealmString("Grundsätzlich ja, jedoch freiwillig; fraglich jedoch bei Steuerabgrenzung (§ 274 HGB)."));

        Question question53 = new Question(52,questionStr53,answers53,"1.2",3);
        ////

        ////
        String questionStr54 = "Die Architektur-AG ist ...";
        RealmList<RealmString> answers54 = new RealmList<>();
        answers54.add(new RealmString("ein Istkaufmann gemäß § 1 HGB."));
        answers54.add(new RealmString("kein Kaufmann."));
        answers54.add(new RealmString("ein Formkaufmann gemäß § 6 HGB."));
        answers54.add(new RealmString("ein Kann-Kaufmann gemäß § 2 HGB."));

        Question question54 = new Question(53,questionStr54,answers54,"1.2",2);
        ////

        ////
        String questionStr55 = "Die A-B-OHG, die umfangreiche inländische und ausländische Immobiliengeschäfte betreibt, ist ...";
        RealmList<RealmString> answers55 = new RealmList<>();
        answers55.add(new RealmString("ein Istkaufmann gemäß § 1 HGB."));
        answers55.add(new RealmString("kein Kaufmann."));
        answers55.add(new RealmString("ein Formkaufmann gemäß § 6 HGB."));
        answers55.add(new RealmString("ein Kann-Kaufmann gemäß § 2 HGB."));

        Question question55 = new Question(54,questionStr55,answers55,"1.2",2);
        ////

        ////
        String questionStr56 = "Die Kultur-GmbH, die sich mit der Durchführung von Ausstellungen für unbekannte Künstler auf gemeinnütziger Basis befasst, ist ...";
        RealmList<RealmString> answers56 = new RealmList<>();
        answers56.add(new RealmString("ein Istkaufmann gemäß § 1 HGB."));
        answers56.add(new RealmString("kein Kaufmann."));
        answers56.add(new RealmString("ein Formkaufmann gemäß § 6 HGB."));
        answers56.add(new RealmString("ein Kann-Kaufmann gemäß § 2 HGB."));

        Question question56 = new Question(55,questionStr56,answers56,"1.2",2);
        ////

        ////
        String questionStr57 = "Otto Meier betreibt einen kleinen Kiosk, der nur gelegentlich geöffnet hat und dessen Umsatz höchstens 10.000 € pro Geschäftsjahr beträgt. Er ist ...";
        RealmList<RealmString> answers57 = new RealmList<>();
        answers57.add(new RealmString("ein Istkaufmann gemäß § 1 HGB."));
        answers57.add(new RealmString("kein Kaufmann."));
        answers57.add(new RealmString("ein Formkaufmann gemäß § 6 HGB."));
        answers57.add(new RealmString("ein Kann-Kaufmann gemäß § 2 HGB."));

        Question question57 = new Question(56,questionStr57,answers57,"1.2",1);
        ////

        ////
        String questionStr58 = "Rechtsanwalt Hans Rechtslinks betreibt seine Kanzlei in Würzburg und erzielt einen jährlichen Umsatz von ca. 12.000.000 €. Er ist ...";
        RealmList<RealmString> answers58 = new RealmList<>();
        answers58.add(new RealmString("ein Istkaufmann gemäß § 1 HGB."));
        answers58.add(new RealmString("kein Kaufmann."));
        answers58.add(new RealmString("ein Formkaufmann gemäß § 6 HGB."));
        answers58.add(new RealmString("ein Kann-Kaufmann gemäß § 2 HGB."));

        Question question58 = new Question(57,questionStr58,answers58,"1.2",1);
        ////

        ////
        String questionStr59 = "Die Schnöller OHG, die gerade erst gegründet wurde und noch nicht ins Handelsregister eingetragen wurde und (noch) kein Handelsgewerbe betreibt, ist ...";
        RealmList<RealmString> answers59 = new RealmList<>();
        answers59.add(new RealmString("ein Istkaufmann gemäß § 1 HGB."));
        answers59.add(new RealmString("kein Kaufmann."));
        answers59.add(new RealmString("ein Formkaufmann gemäß § 6 HGB."));
        answers59.add(new RealmString("ein Kann-Kaufmann gemäß § 2 HGB."));

        Question question59 = new Question(58,questionStr59,answers59,"1.2",1);
        ////

        ////
        String questionStr60 = "Welcher Grundsatz ist nicht den Rahmengrundsätzen der GoB zuzuordnen?";
        RealmList<RealmString> answers60 = new RealmList<>();
        answers60.add(new RealmString("Vollständigkeit"));
        answers60.add(new RealmString("Vorsicht"));
        answers60.add(new RealmString("Richtigkeit und Willkürfreiheit"));
        answers60.add(new RealmString("Klarheit und Übersichtlichkeit"));

        Question question60 = new Question(59,questionStr60,answers60,"1.2",1);
        ////

        ////
        String questionStr61 = "Welcher Grundsatz ist nicht den Abgrenzungsgrundsätzen der GoB zuzuordnen?";
        RealmList<RealmString> answers61 = new RealmList<>();
        answers61.add(new RealmString("Imparitätsprinzip"));
        answers61.add(new RealmString("Realisationsprinzip"));
        answers61.add(new RealmString("Prinzip der Periodenabgrenzung"));
        answers61.add(new RealmString("Einzelbewertung"));

        Question question61 = new Question(60,questionStr61,answers61,"1.2",3);
        ////

        ////
        String questionStr62 = "Welcher Grundsatz ist NICHT den ergänzenden Grundsätzen der GoB zuzuordnen?";
        RealmList<RealmString> answers62 = new RealmList<>();
        answers62.add(new RealmString("Stetigkeit"));
        answers62.add(new RealmString("Vorsicht"));
        answers62.add(new RealmString("Imparitätsprinzip"));
        answers62.add(new RealmString("Fortführungsgrundsatz"));

        Question question62 = new Question(61,questionStr62,answers62,"1.2",2);
        ////


        realm.beginTransaction();
        realm.clear(Question.class);
        realm.copyToRealm(question1);
        realm.copyToRealm(question2);
        realm.copyToRealm(question3);
        realm.copyToRealm(question4);
        realm.copyToRealm(question5);
        realm.copyToRealm(question6);
        realm.copyToRealm(question7);
        realm.copyToRealm(question8);
        realm.copyToRealm(question9);
        realm.copyToRealm(question10);
        realm.copyToRealm(question11);
        realm.copyToRealm(question12);
        realm.copyToRealm(question13);
        realm.copyToRealm(question14);
        realm.copyToRealm(question15);
        realm.copyToRealm(question16);
        realm.copyToRealm(question17);
        realm.copyToRealm(question18);
        realm.copyToRealm(question19);
        realm.copyToRealm(question20);
        realm.copyToRealm(question21);
        realm.copyToRealm(question22);
        realm.copyToRealm(question23);
        realm.copyToRealm(question24);
        realm.copyToRealm(question25);
        realm.copyToRealm(question26);
        realm.copyToRealm(question27);
        realm.copyToRealm(question28);
        realm.copyToRealm(question29);
        realm.copyToRealm(question30);
        realm.copyToRealm(question31);
        realm.copyToRealm(question32);
        realm.copyToRealm(question33);
        realm.copyToRealm(question34);
        realm.copyToRealm(question35);
        realm.copyToRealm(question36);
        realm.copyToRealm(question37);
        realm.copyToRealm(question38);
        realm.copyToRealm(question39);
        realm.copyToRealm(question40);
        realm.copyToRealm(question41);
        realm.copyToRealm(question42);
        realm.copyToRealm(question43);
        realm.copyToRealm(question44);
        realm.copyToRealm(question45);
        realm.copyToRealm(question46);
        realm.copyToRealm(question47);
        realm.copyToRealm(question48);
        realm.copyToRealm(question49);
        realm.copyToRealm(question50);
        realm.copyToRealm(question51);
        realm.copyToRealm(question52);
        realm.copyToRealm(question53);
        realm.copyToRealm(question54);
        realm.copyToRealm(question55);
        realm.copyToRealm(question56);
        realm.copyToRealm(question57);
        realm.copyToRealm(question58);
        realm.copyToRealm(question59);
        realm.copyToRealm(question60);
        realm.copyToRealm(question61);
        realm.copyToRealm(question62);

        realm.commitTransaction();

        initVorlesungen();
    }

    private void initVorlesungen() {
        int [] arr2={4,6,8,9,17,18,21,22,24,33,34,36,41,46,49};
        RealmList<IntegerRealm> arr = new RealmList<>();

        for(int i = 0;i<arr2.length;i++){
            arr.add(new IntegerRealm(arr2[i]));
        }

        RealmList<Page> pages = new RealmList<>();
        pages.add(new Page(1,3));
        pages.add(new Page(4,4));
        pages.add(new Page(5,6));
        pages.add(new Page(7,8));
        pages.add(new Page(9,16));
        pages.add(new Page(17,26));
        pages.add(new Page(27,30));
        pages.add(new Page(31,32));
        pages.add(new Page(33,34));
        pages.add(new Page(35,36));
        pages.add(new Page(37,38));
        pages.add(new Page(39,43));
        pages.add(new Page(44,52));
        pages.add(new Page(59,61));
        pages.add(new Page(53,58));

        VorlesungPDF v = new VorlesungPDF(0,"vorlesung1.pdf",arr,pages);



        RealmList<IntegerRealm> arrV2 = new RealmList<>();
        RealmList<Page> pagesV2 = new RealmList<>();

        VorlesungPDF v2 = new VorlesungPDF(0,"vorlesung2.pdf",arrV2,pagesV2);



        realm.beginTransaction();
        realm.copyToRealm(v);
        realm.copyToRealm(v2);
        realm.commitTransaction();
    }


    private void startSprint(){
        Intent intent = new Intent(this,SprintSetupActivity.class);
        startActivity(intent);
    }
}
