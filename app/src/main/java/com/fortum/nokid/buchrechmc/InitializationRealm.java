package com.fortum.nokid.buchrechmc;

import com.fortum.nokid.buchrechmc.Entities.Exercise;
import com.fortum.nokid.buchrechmc.Entities.Konto;
import com.fortum.nokid.buchrechmc.Entities.Page;
import com.fortum.nokid.buchrechmc.Entities.Question;
import com.fortum.nokid.buchrechmc.Entities.VorlesungPDF;
import com.fortum.nokid.buchrechmc.RealmClasses.RealmInteger;
import com.fortum.nokid.buchrechmc.RealmClasses.RealmString;

import io.realm.Realm;
import io.realm.RealmList;

public class InitializationRealm {
    private Realm realm;

    private InitializationRealm(Realm realm){
        this.realm=realm;

    }

    public static InitializationRealm getInstance(Realm realm){
        InitializationRealm initializationRealm=new InitializationRealm(realm);

        return initializationRealm;
    }

    public void initRealm(){
        initQuestions1();
        initQuestions2();
        initQuestions3();
        initQuestions4();
        //initQuestions5();
        initExercises();

        initVorlesungen();

    }

    //TODO ADD KAPITEL
    //Grundlagen
    private void initQuestions1(){

        String questionStr1 = "Welcher Teilbereich des Rechnungswesens ist dem externen Rechnungswesen zugeordnet?";
        RealmList<RealmString> answers = new RealmList<>();
        answers.add(new RealmString("Statistik-undVergleichsrechnung"));
        answers.add(new RealmString("Kosten- und Leistungsrechnung"));
        answers.add(new RealmString("Finanzbuchhaltung"));
        answers.add(new RealmString("Planungsrechnung"));

        Question question1 = new Question(0,questionStr1,answers,"1.1",2);

        String questionStr2 = "Das externe Rechnungswesen...";
        RealmList<RealmString> answers2 = new RealmList<>();
        answers2.add(new RealmString("ist unternehmensspezifisch gestaltbar"));
        answers2.add(new RealmString("wird durch den Betriebsrat gestaltet"));
        answers2.add(new RealmString("wird durch Wirtschaftsprüfer festgelegt"));
        answers2.add(new RealmString("unterliegtgesetzlichenVorschriften"));

        Question question2 = new Question(1,questionStr2,answers2,"1.1",3);

        String questionStr3 = "Wer ist kein Adressat des Jahresabschlusses?";
        RealmList<RealmString> answers3 = new RealmList<>();
        answers3.add(new RealmString("Eigentümer"));
        answers3.add(new RealmString("Gläubiger"));
        answers3.add(new RealmString("Unternehmensleitung"));
        answers3.add(new RealmString("Abschlussprüfer"));

        Question question3 = new Question(2,questionStr3,answers3,"1.1",3);

        String questionStr4 = "Was ist keine Aufgabe des externen Rechnungswesens?";
        RealmList<RealmString> answers4 = new RealmList<>();
        answers4.add(new RealmString("Abbildung der finanziellen Beziehung des Unternehmens zu seiner Umwelt"));
        answers4.add(new RealmString("Planung, Kontrolle und Steuerung des Betriebsgeschehens"));
        answers4.add(new RealmString("Rechnungslegung/BilanzierungaufgrundgesetzlicherVorschriften"));
        answers4.add(new RealmString("Erstellung des Jahresabschlusses"));

        Question question4 = new Question(3,questionStr4,answers4,"1.1",1);

        String questionStr5 = "Das Betriebsergebnis ergibt sich durch Saldierung von ...";
        RealmList<RealmString> answers5 = new RealmList<>();
        answers5.add(new RealmString("Erlös und Kosten"));
        answers5.add(new RealmString("Ertrag und Aufwand"));
        answers5.add(new RealmString("Einnahme und Ausgabe"));
        answers5.add(new RealmString("Einzahlung und Auszahlung"));

        Question question5 = new Question(4,questionStr5,answers5,"1.1",0);

        ////
        String questionStr6 = "Die Saldierung von Einnahmen und Ausgaben ergibt ...";
        RealmList<RealmString> answers6 = new RealmList<>();
        answers6.add(new RealmString("das Betriebsergebnis"));
        answers6.add(new RealmString("das Jahresergebnis"));
        answers6.add(new RealmString("den Finanzsaldo"));
        answers6.add(new RealmString("den Zahlungssaldo"));

        Question question6 = new Question(5,questionStr6,answers6,"1.1",2);
        ////

        ////
        String questionStr7 = "Markieren Sie die korrekte Definition für Einnahmen!";
        RealmList<RealmString> answers7 = new RealmList<>();
        answers7.add(new RealmString("Monetärer Wert der in einer Wirtschaftsperiode abgegebenen Wirtschaftsgüter"));
        answers7.add(new RealmString("Zahlungsmittel, die einem Unternehmen innerhalb einer Periode zufließen"));
        answers7.add(new RealmString("Monetärbewerteter,durchLeistungserstellungbedingterWertzuwachs"));
        answers7.add(new RealmString("Wertzuwachs einer Periode (erfolgswirksam)"));

        Question question7 = new Question(6,questionStr7,answers7,"1.1",0);
        ////

        ////
        String questionStr8 = "Markieren Sie die korrekte Definition für Kosten!";
        RealmList<RealmString> answers8 = new RealmList<>();
        answers8.add(new RealmString("Verbrauch bzw. Gebrauch von Wirtschaftsgütern (erfolgswirksam)"));
        answers8.add(new RealmString("Monetärbewerteter,durchLeistungserstellungbedingterGüter-undDienstleistungsverzehr"));
        answers8.add(new RealmString("Monetärer Wert der in einer Periode einem Unternehmen zugegangenen Wirtschaftsgüter"));
        answers8.add(new RealmString("Zahlungsmittel, die von einem Unternehmen innerhalb einer Periode abfließen"));

        Question question8 = new Question(7,questionStr8,answers8,"1.1",1);
        ////


        ////
        String questionStr9 = "„Monetärer Wert der in einer Periode einem Unternehmen zugegangenen Wirtschaftsgüter“ ist die Definition für ...";
        RealmList<RealmString> answers9 = new RealmList<>();
        answers9.add(new RealmString("Ausgaben"));
        answers9.add(new RealmString("Einnahmen"));
        answers9.add(new RealmString("Aufwendungen"));
        answers9.add(new RealmString("Erlös"));

        Question question9 = new Question(8,questionStr9,answers9,"1.1",0);
        ////

        ////
        String questionStr10 = "“Zahlungsmittel, die von einem Unternehmen innerhalb einer Periode abfließen“ ist die Definition für ...";
        RealmList<RealmString> answers10 = new RealmList<>();
        answers10.add(new RealmString("Auszahlungen"));
        answers10.add(new RealmString("Einzahlungen"));
        answers10.add(new RealmString("Einnahmen"));
        answers10.add(new RealmString("Erträge"));

        Question question10 = new Question(9,questionStr10,answers10,"1.1",0);
        ////

        ////
        String questionStr11 = "Der Geschäftsvorfall „Bezahlung von Maschinen, die in der Vorperiode geliefert wurden“ ist ein(e)";
        RealmList<RealmString> answers11 = new RealmList<>();
        answers11.add(new RealmString("Auszahlung"));
        answers11.add(new RealmString("Auszahlung und Ausgabe"));
        answers11.add(new RealmString("Einnahme"));
        answers11.add(new RealmString("Ausgabe"));

        Question question11 = new Question(10,questionStr11,answers11,"1.1",0);
        ////

        ////
        String questionStr12 = "Der Geschäftsvorfall „Bezahlung von Maschinen, die in der Folgeperiode geliefert werden“ ist ein(e)";
        RealmList<RealmString> answers12 = new RealmList<>();
        answers12.add(new RealmString("Auszahlung"));
        answers12.add(new RealmString("Auszahlung und Ausgabe"));
        answers12.add(new RealmString("Einnahme"));
        answers12.add(new RealmString("Ausgabe"));

        Question question12 = new Question(11,questionStr12,answers12,"1.1",0);
        ////

        ////
        String questionStr13 = "Der Geschäftsvorfall „Einkauf von Waren für 600 € auf Ziel“ ist eine";
        RealmList<RealmString> answers13 = new RealmList<>();
        answers13.add(new RealmString("Auszahlung"));
        answers13.add(new RealmString("Auszahlung und Ausgabe"));
        answers13.add(new RealmString("Einnahme"));
        answers13.add(new RealmString("Ausgabe"));

        Question question13 = new Question(12,questionStr13,answers13,3,"1.1","￼Hinweis:" + "Hier ist immer die Annahme, dass das Wirtschaftsgut gleich dem K");
        ////

        ////
        String questionStr14 = "Der Geschäftsvorfall „Einkauf von Rohstoffen mit Barbezahlung“ ist eine";
        RealmList<RealmString> answers14 = new RealmList<>();
        answers14.add(new RealmString("Auszahlung"));
        answers14.add(new RealmString("Auszahlung und Ausgabe"));
        answers14.add(new RealmString("Einnahme"));
        answers14.add(new RealmString("Einzahlung und Einnahme"));

        Question question14 = new Question(13,questionStr14,answers14,"1.1",1);
        ////

        ////
        String questionStr15 = "Der Geschäftsvorfall „Einkauf von Holzbrettern für 200 € auf Ziel“ ist ein(e)";
        RealmList<RealmString> answers15 = new RealmList<>();
        answers15.add(new RealmString("Ausgabe"));
        answers15.add(new RealmString("Ausgabe und Aufwand"));
        answers15.add(new RealmString("Aufwand"));
        answers15.add(new RealmString("Auszahlung,Ausgabe und Aufwand"));

        Question question15 = new Question(14,questionStr15,answers15,0,"1.1","￼Hinweis:\n" + "Da keine Angabe, wann der Verbrauch stattfindet, wird nicht geprüft ob ein Aufwand vorherrscht; also: Aufwand wird nur bei expliziter Angabe des Verbrauchs ge");
        ////

        ////
        String questionStr16 = "Der Geschäftsvorfall „Einkauf von Holzbrettern für 200 € auf Ziel, die in der übernächsten Periode verbraucht werden“ ist ein(e)";
        RealmList<RealmString> answers16 = new RealmList<>();
        answers16.add(new RealmString("Ausgabe"));
        answers16.add(new RealmString("Ausgabe und Aufwand"));
        answers16.add(new RealmString("Aufwand"));
        answers16.add(new RealmString("Auszahlung,Ausgabe und Aufwand"));

        Question question16 = new Question(15,questionStr16,answers16,"1.1",0);
        ////

        ////
        String questionStr17 = "Der Geschäftsvorfall „Einkauf von Holzbrettern für 200 € auf Ziel, die sofort verbraucht werden“ ist ein(e)";
        RealmList<RealmString> answers17 = new RealmList<>();
        answers17.add(new RealmString("Ausgabe"));
        answers17.add(new RealmString("Ausgabe und Aufwand"));
        answers17.add(new RealmString("Aufwand"));
        answers17.add(new RealmString("Auszahlung,Ausgabe und Aufwand"));

        Question question17 = new Question(16,questionStr17,answers17,"1.1",1);
        ////

        ////
        String questionStr18 = "Der Geschäftsvorfall „Planmäßige lineare Abschreibung einer Produktionsmaschine“ ist ein(e)";
        RealmList<RealmString> answers18 = new RealmList<>();
        answers18.add(new RealmString("Ausgabe"));
        answers18.add(new RealmString("Ausgabe und Aufwand"));
        answers18.add(new RealmString("Aufwand"));
        answers18.add(new RealmString("Auszahlung,Ausgabe und Aufwand"));

        Question question18 = new Question(17,questionStr18,answers18,"1.1",2);
        ////

        ////
        String questionStr19 = "Der Geschäftsvorfall „Außerplanmäßige Abschreibung einer Produktionsmaschine“ ist ein(e)";
        RealmList<RealmString> answers19 = new RealmList<>();
        answers19.add(new RealmString("Ausgabe"));
        answers19.add(new RealmString("Ausgabe und Aufwand"));
        answers19.add(new RealmString("Aufwand"));
        answers19.add(new RealmString("Auszahlung,Ausgabe und Aufwand"));

        Question question19 = new Question(18,questionStr19,answers19,"1.1",2);
        ////

        ////
        String questionStr20 = "Der Geschäftsvorfall „Bildung von Rückstellungen“ ist ein(e)";
        RealmList<RealmString> answers20 = new RealmList<>();
        answers20.add(new RealmString("Ausgabe"));
        answers20.add(new RealmString("Ausgabe und Aufwand"));
        answers20.add(new RealmString("Aufwand"));
        answers20.add(new RealmString("Auszahlung,Ausgabe und Aufwand"));

        Question question20 = new Question(19,questionStr20,answers20,"1.1",2);
        ////

        ////
        String questionStr21 = "Der Geschäftsvorfall „Verkauf von Waren für 700 € auf Kredit“ ist ein(e)";
        RealmList<RealmString> answers21 = new RealmList<>();
        answers21.add(new RealmString("Einnahme"));
        answers21.add(new RealmString("Ausgabe"));
        answers21.add(new RealmString("Ertrag"));
        answers21.add(new RealmString("Aufwand"));

        Question question21 = new Question(20,questionStr21,answers21,"1.1",0);
        ////

        ////
        String questionStr22 = "Der Geschäftsvorfall „Wertminderung eines Geschäftsfahrzeuges“ ist ein(e)";
        RealmList<RealmString> answers22 = new RealmList<>();
        answers22.add(new RealmString("Ausgabe"));
        answers22.add(new RealmString("Ausgabe und Aufwand"));
        answers22.add(new RealmString("Aufwand"));
        answers22.add(new RealmString("Auszahlung,Ausgabe und Aufwand"));

        Question question22 = new Question(21,questionStr22,answers22,"1.1",2);
        ////

        ////
        String questionStr23 = "Der Geschäftsvorfall „Bezahlung von Miete für ein Geschäftsbüro per Überweisung“ ist ein(e)";
        RealmList<RealmString> answers23 = new RealmList<>();
        answers23.add(new RealmString("Ausgabe"));
        answers23.add(new RealmString("Ausgabe und Aufwand"));
        answers23.add(new RealmString("Aufwand"));
        answers23.add(new RealmString("Auszahlung,Ausgabe und Aufwand"));

        Question question23 = new Question(22,questionStr23,answers23,"1.1",3);
        ////

        ////
        String questionStr24 = "Der Geschäftsvorfall „Bezahlung von Miete für ein Geschäftsbüro per Überweisung“ ist ein(e)";
        RealmList<RealmString> answers24 = new RealmList<>();
        answers24.add(new RealmString("Ausgabe"));
        answers24.add(new RealmString("Ausgabe und Aufwand"));
        answers24.add(new RealmString("Aufwand"));
        answers24.add(new RealmString("Auszahlung,Ausgabe und Aufwand"));

        Question question24 = new Question(23,questionStr24,answers24,"1.1",3);
        ////

        ////
        String questionStr25 = "Der Geschäftsvorfall „Kauf einer Produktionsmaschine zum Preis von 100.000 €“ ist ein(e)";
        RealmList<RealmString> answers25 = new RealmList<>();
        answers25.add(new RealmString("Ausgabe"));
        answers25.add(new RealmString("Ausgabe und Aufwand"));
        answers25.add(new RealmString("Aufwand"));
        answers25.add(new RealmString("Auszahlung,Ausgabe und Aufwand"));

        Question question25 = new Question(24,questionStr25,answers25,0,"1.1","Hinweis:" +
                "Da keine Angabe, ob Kauf auf Kredit oder in bar => unklar, ob Auszahlung oder nicht, hier aber nicht relevant zur Beantwortung der MC-");
        ////

        ////
        String questionStr26 = "Der Geschäftsvorfall „Gewährung eines Barkredites in Höhe von 1.111 €“ ist eine";
        RealmList<RealmString> answers26 = new RealmList<>();
        answers26.add(new RealmString("Auszahlung"));
        answers26.add(new RealmString("Einnahme"));
        answers26.add(new RealmString("Einzahlung"));
        answers26.add(new RealmString("Einnahme und Einzahlung"));

        Question question26 = new Question(25,questionStr26,answers26,"1.1",0);
        ////

        ////
        String questionStr27 = "Der Geschäftsvorfall „Tilgung eines Darlehens in Höhe von 50.000 €“ ist eine";
        RealmList<RealmString> answers27 = new RealmList<>();
        answers27.add(new RealmString("Auszahlung"));
        answers27.add(new RealmString("Auszahlung und Ausgabe"));
        answers27.add(new RealmString("Einnahme"));
        answers27.add(new RealmString("Ausgabe"));

        Question question27 = new Question(26,questionStr27,answers27,"1.1",1);
        ////

        ////
        String questionStr28 = "Der Geschäftsvorfall „Barverkauf von Waren für 300 €“ ist eine";
        RealmList<RealmString> answers28 = new RealmList<>();
        answers28.add(new RealmString("Einzahlung"));
        answers28.add(new RealmString("Einzahlung und Einnahme"));
        answers28.add(new RealmString("Einnahme"));
        answers28.add(new RealmString("Ausgabe"));

        Question question28 = new Question(27,questionStr28,answers28,"1.1",0);
        ////

        ////
        String questionStr29 = "￼Der Geschäftsvorfall „Verkauf von Sachvermögen zum Buchwert von 5.000 €“ ist ein(e)";
        RealmList<RealmString> answers29 = new RealmList<>();
        answers29.add(new RealmString("Einnahme"));
        answers29.add(new RealmString("Ausgabe"));
        answers29.add(new RealmString("Ertrag"));
        answers29.add(new RealmString("Aufwand"));

        Question question29 = new Question(28,questionStr29,answers29,"1.1",2);
        ////

        ////
        String questionStr30 = "Der Geschäftsvorfall „Verkauf von Waren für 600 € auf Kredit“ ist eine";
        RealmList<RealmString> answers30 = new RealmList<>();
        answers30.add(new RealmString("Einzahlung"));
        answers30.add(new RealmString("Einzahlung und Einnahme"));
        answers30.add(new RealmString("Einnahme"));
        answers30.add(new RealmString("Ausgabe"));

        Question question30 = new Question(29,questionStr30,answers30,"1.1",2);
        ////

        ////
        String questionStr31 = "Der Geschäftsvorfall „Verkauf von Waren für 600 € gegen Barzahlung“ ist ein";
        RealmList<RealmString> answers31 = new RealmList<>();
        answers31.add(new RealmString("Einzahlung"));
        answers31.add(new RealmString("Auszahlung"));
        answers31.add(new RealmString("Ausgabe"));
        answers31.add(new RealmString("Keine der vorherigen Antworten ist richtig"));

        Question question31 = new Question(30,questionStr31,answers31,2,"1.1","￼Hinweis:" + "es handelt sich um eine Einnahme und Einzahlung; aber Einnahme nicht als");
        ////

        ////
        String questionStr32 = "Der Geschäftsvorfall „Werterhöhung eigener Sachvermögensgegenstände um 100 €“ ist ein(e)";
        RealmList<RealmString> answers32 = new RealmList<>();
        answers32.add(new RealmString("Einzahlung"));
        answers32.add(new RealmString("Einnahme und Ertrag"));
        answers32.add(new RealmString("Ertrag"));
        answers32.add(new RealmString("Aufwand"));

        Question question32 = new Question(31,questionStr32,answers32,"1.1",3);
        ////

        ////
        String questionStr33 = "Der Geschäftsvorfall „Kunde bezahlt für eine Dienstleistung 6.000 € in bar“ ist ein(e)";
        RealmList<RealmString> answers33 = new RealmList<>();
        answers33.add(new RealmString("Einnahme"));
        answers33.add(new RealmString("Einnahme und Ertrag"));
        answers33.add(new RealmString("Ertrag"));
        answers33.add(new RealmString("Einzahlung, Einnahme und Ertrag"));

        Question question33 = new Question(32,questionStr33,answers33,"1.1",3);
        ////

        ////
        String questionStr34 = "Der Geschäftsvorfall „Kredit an befreundetes Unternehmen wird von diesem getilgt“ ist eine";
        RealmList<RealmString> answers34 = new RealmList<>();
        answers34.add(new RealmString("Einzahlung"));
        answers34.add(new RealmString("Einzahlung und Einnahme"));
        answers34.add(new RealmString("Einnahme"));
        answers34.add(new RealmString("Ausgabe"));

        Question question34 = new Question(33,questionStr34,answers34,"1.1",0);
        ////

        ////
        String questionStr35 = "Der Geschäftsvorfall „Aufnahme eines Barkredites (z.B. Bankdarlehen) über 95.000 €“ ist eine";
        RealmList<RealmString> answers35 = new RealmList<>();
        answers35.add(new RealmString("Einzahlung"));
        answers35.add(new RealmString("Auszahlung"));
        answers35.add(new RealmString("Einnahme"));
        answers35.add(new RealmString("Ausgabe"));

        Question question35 = new Question(34,questionStr35,answers35,"1.1",0);
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

        ////
        String questionStr63 = "Welche der folgenden Aussagen zur Umsatzsteuer ist richtig?";
        RealmList<RealmString> answers63 = new RealmList<>();
        answers63.add(new RealmString("Eine Privatentnahme des Unternehmers aus seinem Unternehmen ist immer ein umsatzsteuerpflichtiger Geschäftsvorfall."));
        answers63.add(new RealmString("Falls im Rahmen des Jahresabschlusses der Saldo des Kontos 1400: Vorsteuer größer ist als der Saldo des Kontos 3800: Umsatzsteuer, so hat das Unternehmen eine Forderung gegenüber dem Finanzamt."));
        answers63.add(new RealmString("Beim Verkauf von Anlagevermögen unter Restbuchwert wird niemals Umsatzsteuer fällig."));
        answers63.add(new RealmString("Keine der oben genannten Antwortmöglichkeiten ist richtig."));

        Question question63 = new Question(62,questionStr63,answers63,"2.1",1);
        ////

        ////
        String questionStr64 = "Für die Produktion von Tischen kauft JUPITER Holzleim im Wert von 143 EUR (brutto) auf Ziel. Welcher der folgenden Buchungssätze bildet den Einkauf korrekt ab?";
        RealmList<RealmString> answers64 = new RealmList<>();
        answers64.add(new RealmString("1030: Betriebsstoffe, 130 an 3300: VLL, 143 1400: Vorsteuer, 13"));
        answers64.add(new RealmString("1020: Hilfsstoffe, 130 1400: Vorsteuer, 13 an 3300: VLL, 143"));
        answers64.add(new RealmString("5020: Aufwand (H) an 1020: Hilfsstoffe, 130"));
        answers64.add(new RealmString("3300: VLL an 1600: Kasse, 143"));

        Question question64 = new Question(63,questionStr64,answers64,"2.1",1);
        ////

        ////
        String questionStr65 = "JUPITER verkauft eine Produktionsmaschine zum Restbuchwert für 2.750 EUR (brutto) an einen befreundeten Unternehmer. Die Bezahlung erfolgt per Banküberweisung. Welcher der folgenden Buchungssätze bildet den Geschäftsvorfall korrekt ab?";
        RealmList<RealmString> answers65 = new RealmList<>();
        answers65.add(new RealmString("1800: Bank, 2.750 an  0440: Maschinen, 2.500 3800: UST, 250"));
        answers65.add(new RealmString("1800: Bank, 2.750 an 0440: Maschinen, 2.750"));
        answers65.add(new RealmString("1800: Bank, 3.025 an 0440: Maschinen, 2.750 3800: UST, 275"));
        answers65.add(new RealmString("1800: Bank, 3.025 an 0440: Maschinen, 2.500 3800: UST, 275 4900: EA, 250"));

        Question question65 = new Question(64,questionStr65,answers65,"2.1",0);
        ////

        ////
        String questionStr66 = "JUPITER verkauft eine Lagerhalle mit Restbuchwert 60.000 EUR zu 55.000 EUR (brutto) auf Ziel. Welcher der folgenden Buchungssätze bildet den Geschäftsvorfall korrekt ab?";
        RealmList<RealmString> answers66 = new RealmList<>();
        answers66.add(new RealmString("1300: Sonstige Forderungen, 60.000 an 0240: Geschäftsbauten, 55.000 3800: UST, 5.000"));
        answers66.add(new RealmString("1300: Sonstige Forderungen, 55.000 6900: VA, 10.000 an 0240: Geschäftsbauten, 60.000 3800: UST, 5.000"));
        answers66.add(new RealmString("1300: Sonstige Forderungen, 55.000 an 0240: Geschäftsbauten, 50.000 3800: UST, 5.000"));
        answers66.add(new RealmString("1200: FLL, 55.000 3800: UST, 5.000 an 0240: Geschäftsbauten, 60.000"));

        Question question66 = new Question(65,questionStr66,answers66,"2.1",1);
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
        realm.copyToRealm(question63);
        realm.copyToRealm(question64);
        realm.copyToRealm(question65);
        realm.copyToRealm(question66);

        realm.commitTransaction();

    }

    //Buchführung
    private void initQuestions2() {

        String questionStr67 = "Der nicht im Handelsregister eingetragene Künstler Picasso muss keine Bücher führen, weil er …";
        RealmList<RealmString> answers67 = new RealmList<>();
        answers67.add(new RealmString("A) Ist-Kaufmann ist"));
        answers67.add(new RealmString("B) die Größenmerkmale aus §241a HGB unterschreitet"));
        answers67.add(new RealmString("C) Freiberufler ist"));
        answers67.add(new RealmString("D) Zwar ein Gewerbe führt, aber kein Handelsgewerbe"));

        Question question67 = new Question(66,questionStr67,answers67,"",2);
        String questionStr68 = "Wer muss Bücher führen?";
        RealmList<RealmString> answers68 = new RealmList<>();
        answers68.add(new RealmString("A) Kegelclub „Gut Holz” "));
        answers68.add(new RealmString("B) Friedhof „Zur letzten Ruhe”"));
        answers68.add(new RealmString("C) Wirtschaftsprüfer Bernd Grottel"));
        answers68.add(new RealmString("D) Baumschule „Deutsche Eiche” (im HR eingetragen)"));

        Question question68 = new Question(67,questionStr68,answers68,"2.1",3);

        String questionStr69 = "Wer muss Bücher führen?";
        RealmList<RealmString> answers69 = new RealmList<>();
        answers69.add(new RealmString("A) Rechtsanwalt Ludwig Sorgenfrei"));
        answers69.add(new RealmString("B) „Arge” Landverschönerung"));
        answers69.add(new RealmString("C) Gleich Fertig KGaA"));
        answers69.add(new RealmString("D) GbR Wörmer"));

        Question question69 = new Question(68,questionStr69,answers69,"",2);
        String questionStr70 = "Wer muss keine Bücher führen?";
        RealmList<RealmString> answers70 = new RealmList<>();
        answers70.add(new RealmString("A) Geldgierbank SchleideneG"));
        answers70.add(new RealmString("B) Enziangroßbrennerei Resi Schluckspecht"));
        answers70.add(new RealmString("C) Eifel AG"));
        answers70.add(new RealmString("D) Zahnarzt Egon Tutnichtweh"));

        Question question70 = new Question(69,questionStr70,answers70,"",3);
        String questionStr71 = "Wer muss keine Bücher führen?";
        RealmList<RealmString> answers71 = new RealmList<>();
        answers71.add(new RealmString("A) Anton Stiller als stiller Gesellschafter"));
        answers71.add(new RealmString("B) Hotel zur gemütlichen Ruhe (im HR eingetragen)"));
        answers71.add(new RealmString("C) Carpe Diem GmbH"));
        answers71.add(new RealmString("D) Schnöller OHG (im HR eingetragen)"));

        Question question71 = new Question(70,questionStr71,answers71,"",0);
        String questionStr72 = "Wer muss im Folgenden Bücher führen? Jahresumsatz beläuft sich auf ca. 2,5 Mio. €. Sein Kiosk ist im Handelsregister eingetragen.";
        RealmList<RealmString> answers72 = new RealmList<>();
        answers72.add(new RealmString("A) Ein freiberuflich tätiger Architekt beschäftigt 10 Architekten und 15 technische Zeichner. Der "));
        answers72.add(new RealmString("B) Ein Kioskbesitzer hat einen Jahresumsatz von 120.000 €und einen Jahresgewinn von 20.000 €"));
        answers72.add(new RealmString("C) Ein anderer Kioskbesitzer hat einen Jahresumsatz von 80.000 €und einen Jahresgewinn von 9.000 €. "));
        answers72.add(new RealmString("D) Ein Schreiner beschäftigt 50 Mitarbeiter. Das Anlagevermögen hat einen Wert von 500.000 €, der Jahresumsatz beläuft sich auf 3,5 Mio. €."));

        Question question72 = new Question(71,questionStr72,answers72,"2.1",3);
        String questionStr73 = " Bei welchen der oben genannten Personen greift §241a HGB, angenommen dass die Zahlen für zwei  aufeinanderfolgende Geschäftsjahre gelten?";
        RealmList<RealmString> answers73 = new RealmList<>();
        answers73.add(new RealmString("A) Nur b ei A) und B)"));
        answers73.add(new RealmString("B) Nur bei B)"));
        answers73.add(new RealmString("C) Nur b ei B)und C)"));
        answers73.add(new RealmString("D) Nur bei C)"));

        Question question73 = new Question(72,questionStr73,answers73,"",2);
        String questionStr74 = "Unternehmer Schneider betreibt sein Handelsgewerbe schon seit langer Zeit.Er hat inden letzten Jahren die folgenden Umsatzerlöse undJahresüberschüsse erzielt: Schneider möchte so schnell wie möglich auf die handelsrechtliche Buchführung verzichten.Ab welchem Zeitpunkt istdas möglich?";
        RealmList<RealmString> answers74 = new RealmList<>();
        answers74.add(new RealmString("A) Jahr 11"));
        answers74.add(new RealmString("B) Jahr 12"));
        answers74.add(new RealmString("C) Jahr 13"));
        answers74.add(new RealmString("D) Jahr 14"));

        Question question74 = new Question(73,questionStr74,answers74,"",3);
        String questionStr75 = "Jahr 10: Jahresüberschuss 48.000 €-Umsatzerlöse 492.000 € Jahr 11: Jahresüberschuss 51.000 €-Umsatzerlöse 498.000 € Jahr 12: Jahresüberschuss 50.000 €-Umsatzerlöse 500.000 € Jahr 13: Jahresüberschuss 48.000 €-Umsatzerlöse 496.000 € Kleinunternehmer Schulzehatsich vonderBuchführung befreienlassen,daerdie Grenzwerte aus§241a HGB bisher unterschritt .Im Jahr 10hat ereinen steuerrechtlichen Gewinnvon48.000 €und steuerrechtliche Umsatzerlösevon485.000 €erzielt .Würde Schulze Bücherführen,wärennoch Forderungen von32.000 €zu berücksichtigen, diedieUmsatzerlöse erhöhenwürden.Bei der Einnahmensüberschussrechnung werdenForderungen nichtbeachtet .Die Forderungen enthalteneinen Gewinnanteil von10.000 €.Wie istfür das Jahr 11vorzugehen?";
        RealmList<RealmString> answers75 = new RealmList<>();
        answers75.add(new RealmString("A) Schulze überschreitet nicht die Grenzen aus §241a HGB und muss deswegen keine Bücher führen."));
        answers75.add(new RealmString("B) Schulze hätte schon im Jahr 2010 Bücher führen müssen."));
        answers75.add(new RealmString("C) Schulze muss ab dem Jahr 2011 Bücher führen."));
        answers75.add(new RealmString("D) Schulze muss ab dem Jahr 2012 Bücher führen, da die Kriterien bei zwei aufeinander folgenden Jahren "));

        Question question75 = new Question(74,questionStr75,answers75,"2.1",2);
        String questionStr76 = " Wer muss ernannt werden, damit ein Unternehmen handlungsfähig wird?";
        RealmList<RealmString> answers76 = new RealmList<>();
        answers76.add(new RealmString("A) Steuerberater"));
        answers76.add(new RealmString("B) Geschäftsführer"));
        answers76.add(new RealmString("C) Wirtschaftsprüfer"));
        answers76.add(new RealmString("D) Eigentümer"));

        Question question76 = new Question(75,questionStr76,answers76,"2.1",1);
        String questionStr77 = "Wer ist berechtigt die Geschäftsführung zu ernennen?";
        RealmList<RealmString> answers77 = new RealmList<>();
        answers77.add(new RealmString("A) Eigentümer"));
        answers77.add(new RealmString("B) Mitarbeiter"));
        answers77.add(new RealmString("C) Gläubiger"));
        answers77.add(new RealmString("D) Lieferanten"));

        Question question77 = new Question(76,questionStr77,answers77,"",0);

        String questionStr78 = "Wie nennt man das Konto über das Unternehmen ihre Zahlungsgeschäfte abwickeln?";
        RealmList<RealmString> answers78 = new RealmList<>();
        answers78.add(new RealmString("A) Anlagekonto"));
        answers78.add(new RealmString("B) Privatkonto"));
        answers78.add(new RealmString("C) Schuldkonto"));
        answers78.add(new RealmString("D) Geschäftskonto"));

        Question question78 = new Question(77,questionStr78,answers78,"",3);
        String questionStr79 = "Der Fachbegriff für alle Schulden eines Unternehmens ist?";
        RealmList<RealmString> answers79 = new RealmList<>();
        answers79.add(new RealmString("A) Aktiva"));
        answers79.add(new RealmString("B) Rückstellungen"));
        answers79.add(new RealmString("C) Passiva"));
        answers79.add(new RealmString("D) Darlehen"));

        Question question79 = new Question(78,questionStr79,answers79,"",2);

        String questionStr80 = "Die Seiteder Bilanz, die Eigenkapital und Fremdkapital aufweist, ist die …";
        RealmList<RealmString> answers80 = new RealmList<>();
        answers80.add(new RealmString("A) Aktivseite"));
        answers80.add(new RealmString("B) Vermögensseite"));
        answers80.add(new RealmString("C) Passivseite"));
        answers80.add(new RealmString("D) Schuldenseite"));

        Question question80 = new Question(79,questionStr80,answers80,"2.1",2);
        String questionStr81 = "Die Seite der Bilanz, die das Vermögen eines Unternehmens aufweist, ist die …";
        RealmList<RealmString> answers81 = new RealmList<>();
        answers81.add(new RealmString("A) Aktivseite"));
        answers81.add(new RealmString("B) Vermögensseite"));
        answers81.add(new RealmString("C) Passivseite"));
        answers81.add(new RealmString("D) Schuldenseite"));

        Question question81 = new Question(80,questionStr81,answers81,"",0);

        String questionStr82 = "Wer von den genannten Personen ist kein Gläubiger?";
        RealmList<RealmString> answers82 = new RealmList<>();
        answers82.add(new RealmString("A) Lieferant, bei dem das Unternehmen Waren auf Ziel eingekauft hat."));
        answers82.add(new RealmString("B) Bank, die dem Unternehmen einen Barkredit gewährt hat. "));
        answers82.add(new RealmString("C) Kunde, dem das Unternehmen auf Kredit eine Ware verkauft hat."));
        answers82.add(new RealmString("D) Eigentümer, der dem Unternehmen einen Kredit gewährt hat."));

        Question question82 = new Question(81,questionStr82,answers82,"2.1",2);
        String questionStr83 = "Wenn eine Person zum Gewerbeamt geht und ein Unternehmen anmeldet, hat das Unternehmen …";
        RealmList<RealmString> answers83 = new RealmList<>();
        answers83.add(new RealmString("A) Verbindlichkeiten"));
        answers83.add(new RealmString("B) Fremdkapital"));
        answers83.add(new RealmString("C) Eigenkapital"));
        answers83.add(new RealmString("D) kein Kapital"));

        Question question83 = new Question(82,questionStr83,answers83,"",3);
        String questionStr84 = "Wie werden die Personen bezeichnet, die neben den Eigentümern einem Unternehmen Kapital zur  Verfügungstellen?";
        RealmList<RealmString> answers84 = new RealmList<>();
        answers84.add(new RealmString("A) Sponsoren"));
        answers84.add(new RealmString("B) Gläubiger"));
        answers84.add(new RealmString("C) Schuldner"));
        answers84.add(new RealmString("D) Spender"));

        Question question84 = new Question(83,questionStr84,answers84,"2.1",1);
        String questionStr85 = "Wenn ein Lieferant einem Kunden einen Lieferantenkredit für einen gewissen Zeitraum einräumt, so nennt  man den gewährten Zeitraum:";
        RealmList<RealmString> answers85 = new RealmList<>();
        answers85.add(new RealmString("A) Kreditlinie"));
        answers85.add(new RealmString("B) Zielvereinbarung"));
        answers85.add(new RealmString("C) Zahlungsziel"));
        answers85.add(new RealmString("D) Freistoß"));

        Question question85 = new Question(84,questionStr85,answers85,"",2);
        String questionStr86 = "Wenn eine Bank einem Kunden einen Bankkredit für einen gewissen Zeitraum einräumt, so nennt man den  gewährten Zeitraum:";
        RealmList<RealmString> answers86 = new RealmList<>();
        answers86.add(new RealmString("A) Kreditlinie"));
        answers86.add(new RealmString("B) Zielvereinbarung"));
        answers86.add(new RealmString("C) Zahlungsziel"));
        answers86.add(new RealmString("D) Freistoß"));

        Question question86 = new Question(85,questionStr86,answers86,"2.1",0);
        String questionStr87 = "Wie lautet der Fachbegriff dafür, dass ein Unternehmen Vermögenswerte beschafft, um damit arbeiten zu  können?";
        RealmList<RealmString> answers87 = new RealmList<>();
        answers87.add(new RealmString("A) Abschreibung"));
        answers87.add(new RealmString("B) Wertermittlung"));
        answers87.add(new RealmString("C) Investition"));
        answers87.add(new RealmString("D) Jahresabschluss"));

        Question question87 = new Question(86,questionStr87,answers87,"",2);
        String questionStr88 = "Wie wird das Kapital bezeichnet, dass Gläubiger einem Unternehmen zur Verfügung stellen?";
        RealmList<RealmString> answers88 = new RealmList<>();
        answers88.add(new RealmString("A) Eigenkapital"));
        answers88.add(new RealmString("B) Risikokapital"));
        answers88.add(new RealmString("C) Verlustkapital"));
        answers88.add(new RealmString("D) Fremdkapital"));

        Question question88 = new Question(87,questionStr88,answers88,"2.1",3);
        String questionStr89 = "Wie wird der Geschäftsvorfall bezeichnet, bei dem Eigentümer ihrem Unternehmen Kapital zur Verfügung  stellen?";
        RealmList<RealmString> answers89 = new RealmList<>();
        answers89.add(new RealmString("A) Kapitaleinlage"));
        answers89.add(new RealmString("B) Überweisung"));
        answers89.add(new RealmString("C) Kapitalaufgabe"));
        answers89.add(new RealmString("D) Darlehen"));

        Question question89 = new Question(88,questionStr89,answers89,"",0);
        String questionStr90 = "Geld,das Eigentümern in ihrem Unternehmen einlegen, nennt man";
        RealmList<RealmString> answers90 = new RealmList<>();
        answers90.add(new RealmString("A) Verlustkapital"));
        answers90.add(new RealmString("B) Darlehen"));
        answers90.add(new RealmString("C) Eigenkapital"));
        answers90.add(new RealmString("D) Sacheinlage"));

        Question question90 = new Question(89,questionStr90,answers90,"2.1",2);
        String questionStr91 = "Wer einem Unternehmen Kapital zur Verfügung stellt, aber kein Eigentümer ist, bezeichnet man als:";
        RealmList<RealmString> answers91 = new RealmList<>();
        answers91.add(new RealmString("A) Firma"));
        answers91.add(new RealmString("B) Nutzer"));
        answers91.add(new RealmString("C) Schuldner"));
        answers91.add(new RealmString("D) Gläubiger"));

        Question question91 = new Question(90,questionStr91,answers91,"",3);
        String questionStr92 = "Wie wird das Kapital bezeichnet, dass Eigentümer einem Unternehmen zur Verfügung stellen?";
        RealmList<RealmString> answers92 = new RealmList<>();
        answers92.add(new RealmString("A) Eigenkapital"));
        answers92.add(new RealmString("B) Risikokapital"));
        answers92.add(new RealmString("C) Verlustkapital"));
        answers92.add(new RealmString("D) Fremdkapital"));

        Question question92 = new Question(91,questionStr92,answers92,"2.1",1);

        String questionStr93 = "Markieren Sie die falsche Aussage :";
        RealmList<RealmString> answers93 = new RealmList<>();
        answers93.add(new RealmString("A) Ein positives Jahresergebnis (Jahresüberschuss) erhöht das Eigenkapital."));
        answers93.add(new RealmString("B) Ein negatives Jahresergebnis (Jahresfehlbetrag) mindert das Eigenkapital."));
        answers93.add(new RealmString("C) Ein negatives Jahresergebnis erhöht das Fremdkapital."));
        answers93.add(new RealmString("D) Das Jahresergebnis hat keinen Einfluss auf das Fremdkapital. "));

        Question question93 = new Question(92,questionStr93,answers93,"2.1",2);
        String questionStr94 = "Markieren Sie die korrekte Aussage :";
        RealmList<RealmString> answers94 = new RealmList<>();
        answers94.add(new RealmString("A) Das Eigenkapital in 02 ist die Summe aus Eigenkapital aus 01 und Jahresergebnis aus 01."));
        answers94.add(new RealmString("B) Das Eigenkapital in 02 ist die Differenz aus Eigenkapital aus 01 und Jahresergebnis aus 01."));
        answers94.add(new RealmString("C) Das Eigenkapital in 02 ist die Summe aus Eigenkapital aus 00 und Jahresergebnis aus 01."));
        answers94.add(new RealmString("D) Das Eigenkapital in 01 besteht lediglich aus dem Jahresergebnis aus 00."));

        Question question94 = new Question(93,questionStr94,answers94,"",0);

        // Kapitel 2.2
        String questionStr95 = "Ein Geschäftsvorfall verändert in einem Unternehmen die";
        RealmList<RealmString> answers95 = new RealmList<>();
        answers95.add(new RealmString("A) Vermögenssituation"));
        answers95.add(new RealmString("B) Kapitalanleihe"));
        answers95.add(new RealmString("C) Bilanzsumme"));
        answers95.add(new RealmString("D) Schulden"));

        Question question95 = new Question(94,questionStr95,answers95,"",0);
        String questionStr96 = "Wer ist berechtigt die Geschäftsführung zu ernennen?";
        RealmList<RealmString> answers96 = new RealmList<>();
        answers96.add(new RealmString("A) Eigentümer"));
        answers96.add(new RealmString("B) Mitarbeiter"));
        answers96.add(new RealmString("C) Gläubiger"));
        answers96.add(new RealmString("D) Lieferanten"));

        Question question96 = new Question(95,questionStr96,answers96,"",0);
        String questionStr97 = "„Ein Geschäftsvorfall hat eine doppelte kaufmännische Auswirkung“. Die Aussage ";
        RealmList<RealmString> answers97 = new RealmList<>();
        answers97.add(new RealmString("A) gilt nie."));
        answers97.add(new RealmString("B) gilt bei Kapitaleinlagen."));
        answers97.add(new RealmString("C) gilt bei Krediten. "));
        answers97.add(new RealmString("D) gilt immer. "));

        Question question97 = new Question(96,questionStr97,answers97,"2.2",3);
        String questionStr98 = "Ein Ereignis, das eine Veränderung der Vermögenssituation eines Unternehmens bewirkt, nennt man";
        RealmList<RealmString> answers98 = new RealmList<>();
        answers98.add(new RealmString("A) Bilanzvorfall"));
        answers98.add(new RealmString("B) Geschäftsvorfall"));
        answers98.add(new RealmString("C) Firmenvorfall"));
        answers98.add(new RealmString("D) Unternehmensvorfall"));

        Question question98 = new Question(97,questionStr98,answers98,"",1);
        String questionStr99 = "Die doppelte Buchführung betrachtet die Geschäftsvorfälle aus Sicht der ";
        RealmList<RealmString> answers99 = new RealmList<>();
        answers99.add(new RealmString("A) Eigentümer"));
        answers99.add(new RealmString("B) Unternehmung"));
        answers99.add(new RealmString("C) Gläubiger"));
        answers99.add(new RealmString("D) Buchhalter"));

        Question question99 = new Question(98,questionStr99,answers99,"2.2",1);
        String questionStr100 = "Wie nennt man Anlagevermögen, Umlaufvermögen, Eigenkapital und Fremdkapital insgesamt?";
        RealmList<RealmString> answers100 = new RealmList<>();
        answers100.add(new RealmString("A) Bilanzsummen"));
        answers100.add(new RealmString("B) Bilanzposten"));
        answers100.add(new RealmString("C) Kapitalbestand"));
        answers100.add(new RealmString("D) Vermögenssituation"));

        Question question100 = new Question(99,questionStr100,answers100,"",1);
        String questionStr101 = "Wie viele kaufmännische Auswirkungen hat ein Geschäftsvorfall mindestens?";
        RealmList<RealmString> answers101 = new RealmList<>();
        answers101.add(new RealmString("A) 1"));
        answers101.add(new RealmString("B) 2"));
        answers101.add(new RealmString("C) 3"));
        answers101.add(new RealmString("D) 4"));

        Question question101 = new Question(100,questionStr101,answers101,"",1);
        String questionStr102 = "Welche Bilanzposten werden mit T -Konten ausgestaltet?";
        RealmList<RealmString> answers102 = new RealmList<>();
        answers102.add(new RealmString("A) Alle"));
        answers102.add(new RealmString("B) Keine"));
        answers102.add(new RealmString("C) Nur Aktiva"));
        answers102.add(new RealmString("D) Nur Passiva"));

        Question question102 = new Question(101,questionStr102,answers102,"",0);
        String questionStr103 = "Was genau wird auf einem T -Konto erfasst?";
        RealmList<RealmString> answers103 = new RealmList<>();
        answers103.add(new RealmString("A) Nur Zugänge"));
        answers103.add(new RealmString("B) Nur Abgänge"));
        answers103.add(new RealmString("C) Zu -und Abgänge"));
        answers103.add(new RealmString("D) Weder noch"));

        Question question103 = new Question(102,questionStr103,answers103,"2.2",2);
        String questionStr104 = "Was passiert mit dem Eigenkapital bei einer Kapitalentnahme?";
        RealmList<RealmString> answers104 = new RealmList<>();
        answers104.add(new RealmString("A) Essinkt."));
        answers104.add(new RealmString("B) Nichts."));
        answers104.add(new RealmString("C) Essteigt ."));
        answers104.add(new RealmString("D) Alles ."));

        Question question104 = new Question(103,questionStr104,answers104,"",0);
        String questionStr105 = "Was passiert beim Wareneinkauf auf Ziel mit dem Bankkonto?";
        RealmList<RealmString> answers105 = new RealmList<>();
        answers105.add(new RealmString("A) Essinkt."));
        answers105.add(new RealmString("B) Nichts."));
        answers105.add(new RealmString("C) Essteigt ."));
        answers105.add(new RealmString("D) Alles ."));

        Question question105 = new Question(104,questionStr105,answers105,"2.2",1);
        String questionStr106 = "Was passiert mit dem Eigenkapital bei einer Kapitaleinlage?";
        RealmList<RealmString> answers106 = new RealmList<>();
        answers106.add(new RealmString("A) Essinkt."));
        answers106.add(new RealmString("B) Nichts."));
        answers106.add(new RealmString("C) Essteigt ."));
        answers106.add(new RealmString("D) Alles ."));

        Question question106 = new Question(105,questionStr106,answers106,"",2);
        String questionStr107 = "Was passiert mit dem Fremdkapital, wenn eine Maschine gekauft und bar bezahlt wird?";
        RealmList<RealmString> answers107 = new RealmList<>();
        answers107.add(new RealmString("A) Essinkt."));
        answers107.add(new RealmString("B) Nichts."));
        answers107.add(new RealmString("C) Essteigt ."));
        answers107.add(new RealmString("D) Alles ."));

        Question question107 = new Question(106,questionStr107,answers107,"2.2",1);
        String questionStr108 = "Beim Anlagevermögen ist die SOLL -Seite aus Bilanzsicht …";
        RealmList<RealmString> answers108 = new RealmList<>();
        answers108.add(new RealmString("A) oben"));
        answers108.add(new RealmString("B) unten"));
        answers108.add(new RealmString("C) außen"));
        answers108.add(new RealmString("D) innen"));

        Question question108 = new Question(107,questionStr108,answers108,"",2);
        String questionStr109 = "Das Anlagevermögen wächst …";
        RealmList<RealmString> answers109 = new RealmList<>();
        answers109.add(new RealmString("A) imSoll."));
        answers109.add(new RealmString("B) imHaben ."));
        answers109.add(new RealmString("C) imSaldo ."));
        answers109.add(new RealmString("D) überhaupt nicht."));

        Question question109 = new Question(108,questionStr109,answers109,"2.2",0);
        String questionStr110 = "Das Konto Anlagevermögen wurde im HABEN gebucht. Damit ist das Anlagevermögen";
        RealmList<RealmString> answers110 = new RealmList<>();
        answers110.add(new RealmString("A) gewachsen."));
        answers110.add(new RealmString("B) geschrumpft"));
        answers110.add(new RealmString("C) gleich geblieben ."));
        answers110.add(new RealmString("D) alles ."));

        Question question110 = new Question(109,questionStr110,answers110,"",1);
        String questionStr111 = "Was passiert mit dem Anlagevermögen, wenn eine Maschine gekauft und bar bezahlt wird?";
        RealmList<RealmString> answers111 = new RealmList<>();
        answers111.add(new RealmString("A) Essinkt."));
        answers111.add(new RealmString("B) Nichts."));
        answers111.add(new RealmString("C) Essteigt ."));
        answers111.add(new RealmString("D) Alles ."));

        Question question111 = new Question(110,questionStr111,answers111,"2.2",2);
        String questionStr112 = "Beim Umlaufvermögen ist die SOLL -Seite aus Bilanzsicht …";
        RealmList<RealmString> answers112 = new RealmList<>();
        answers112.add(new RealmString("A) oben"));
        answers112.add(new RealmString("B) unten"));
        answers112.add(new RealmString("C) außen"));
        answers112.add(new RealmString("D) innen"));

        Question question112 = new Question(111,questionStr112,answers112,"",2);
        String questionStr113 = "Beim Eigenkapital ist die SOLL -Seite aus Bilanzsicht …";
        RealmList<RealmString> answers113 = new RealmList<>();
        answers113.add(new RealmString("A) oben"));
        answers113.add(new RealmString("B) unten"));
        answers113.add(new RealmString("C) außen"));
        answers113.add(new RealmString("D) innen"));

        Question question113 = new Question(112,questionStr113,answers113,"2.2",3);
        String questionStr114 = "Beim Fremdkapital ist die SOLL -Seite aus Bilanzsicht …";
        RealmList<RealmString> answers114 = new RealmList<>();
        answers114.add(new RealmString("A) oben"));
        answers114.add(new RealmString("B) unten"));
        answers114.add(new RealmString("C) außen"));
        answers114.add(new RealmString("D) innen"));

        Question question114 = new Question(113,questionStr114,answers114,"",3);
        String questionStr115 = "Beim Anlagevermögen ist die HABEN -Seite aus Bilanzsicht …";
        RealmList<RealmString> answers115 = new RealmList<>();
        answers115.add(new RealmString("A) oben"));
        answers115.add(new RealmString("B) unten"));
        answers115.add(new RealmString("C) außen"));
        answers115.add(new RealmString("D) innen"));

        Question question115 = new Question(114,questionStr115,answers115,"2.2",3);
        String questionStr116 = "Beim Umlaufvermögen ist die HABEN -Seite aus Bilanzsicht …";
        RealmList<RealmString> answers116 = new RealmList<>();
        answers116.add(new RealmString("A) oben"));
        answers116.add(new RealmString("B) unten"));
        answers116.add(new RealmString("C) außen"));
        answers116.add(new RealmString("D) innen"));

        Question question116 = new Question(115,questionStr116,answers116,"",3);
        String questionStr117 = "Beim Eigenkapital ist die HABEN -Seite aus Bilanzsicht …";
        RealmList<RealmString> answers117 = new RealmList<>();
        answers117.add(new RealmString("A) oben"));
        answers117.add(new RealmString("B) unten"));
        answers117.add(new RealmString("C) außen"));
        answers117.add(new RealmString("D) innen"));

        Question question117 = new Question(116,questionStr117,answers117,"2.2",2);
        String questionStr118 = "Beim Fremdkapital ist die HABEN -Seite aus Bilanzsicht …";
        RealmList<RealmString> answers118 = new RealmList<>();
        answers118.add(new RealmString("A) oben"));
        answers118.add(new RealmString("B) unten"));
        answers118.add(new RealmString("C) außen"));
        answers118.add(new RealmString("D) innen"));

        Question question118 = new Question(117,questionStr118,answers118,"",2);
        String questionStr119 = "Das Umlaufvermögen wächst …";
        RealmList<RealmString> answers119 = new RealmList<>();
        answers119.add(new RealmString("A) im Soll."));
        answers119.add(new RealmString("B) im Haben ."));
        answers119.add(new RealmString("C) im Saldo ."));
        answers119.add(new RealmString("D) überhaupt nicht."));

        Question question119 = new Question(118,questionStr119,answers119,"",0);
        String questionStr120 = "Das Eigenkapital wächst …";
        RealmList<RealmString> answers120 = new RealmList<>();
        answers120.add(new RealmString("A) imSoll."));
        answers120.add(new RealmString("B) imHaben ."));
        answers120.add(new RealmString("C) imSaldo ."));
        answers120.add(new RealmString("D) überhaupt nicht."));

        Question question120 = new Question(119,questionStr120,answers120,"",1);
        String questionStr121 = "Das Fremdkapital wächst …";
        RealmList<RealmString> answers121 = new RealmList<>();
        answers121.add(new RealmString("A) imSoll."));
        answers121.add(new RealmString("B) imHaben ."));
        answers121.add(new RealmString("C) imSaldo ."));
        answers121.add(new RealmString("D) überhaupt nicht."));

        Question question121 = new Question(120,questionStr121,answers121,"",1);
        String questionStr122 = "Das Anlagevermögen schrumpft …";
        RealmList<RealmString> answers122 = new RealmList<>();
        answers122.add(new RealmString("A) im Soll."));
        answers122.add(new RealmString("B) im Haben ."));
        answers122.add(new RealmString("C) im Saldo ."));
        answers122.add(new RealmString("D) überhaupt nicht."));

        Question question122 = new Question(121,questionStr122,answers122,"",1);
        String questionStr123 = "Das Umlaufvermögen schrumpft …";
        RealmList<RealmString> answers123 = new RealmList<>();
        answers123.add(new RealmString("A) im Soll."));
        answers123.add(new RealmString("B) im Haben ."));
        answers123.add(new RealmString("C) im Saldo ."));
        answers123.add(new RealmString("D) überhaupt nicht."));

        Question question123 = new Question(122,questionStr123,answers123,"2.2",1);
        String questionStr124 = "Das Eigenkapital schrumpft …";
        RealmList<RealmString> answers124 = new RealmList<>();
        answers124.add(new RealmString("A) imSoll."));
        answers124.add(new RealmString("B) imHaben ."));
        answers124.add(new RealmString("C) imSaldo ."));
        answers124.add(new RealmString("D) überhaupt nicht."));

        Question question124 = new Question(123,questionStr124,answers124,"",0);
        String questionStr125 = "Das Fremdkapital schrumpft …";
        RealmList<RealmString> answers125 = new RealmList<>();
        answers125.add(new RealmString("A) imSoll."));
        answers125.add(new RealmString("B) imHaben ."));
        answers125.add(new RealmString("C) imSaldo ."));
        answers125.add(new RealmString("D) überhaupt nicht."));

        Question question125 = new Question(124,questionStr125,answers125,"2.2",0);
        String questionStr126 = "Das Konto Umlaufvermögen wurde im HABEN gebucht. Damit ist das Umlaufvermögen";
        RealmList<RealmString> answers126 = new RealmList<>();
        answers126.add(new RealmString("A) gewachsen."));
        answers126.add(new RealmString("B) geschrumpft"));
        answers126.add(new RealmString("C) gleich geblieben ."));
        answers126.add(new RealmString("D) alles ."));

        Question question126 = new Question(125,questionStr126,answers126,"",1);
        String questionStr127 = "Das Konto Eigenkapital wurde im HABEN gebucht. Damit ist das Eigenkapital";
        RealmList<RealmString> answers127 = new RealmList<>();
        answers127.add(new RealmString("A) gewachsen."));
        answers127.add(new RealmString("B) geschrumpft ."));
        answers127.add(new RealmString("C) gleich geblieben ."));
        answers127.add(new RealmString("D) alles ."));

        Question question127 = new Question(126,questionStr127,answers127,"2.2",0);
        String questionStr128 = "Das Konto Fremdkapital wurde im HABEN gebucht. Damit ist das Fremdkapital";
        RealmList<RealmString> answers128 = new RealmList<>();
        answers128.add(new RealmString("A) gewachsen."));
        answers128.add(new RealmString("B) geschrumpft ."));
        answers128.add(new RealmString("C) gleich geblieben ."));
        answers128.add(new RealmString("D) alles ."));

        Question question128 = new Question(127,questionStr128,answers128,"",0);
        String questionStr129 = "Das Konto Umlaufvermögen wurde im SOLL gebucht. Damit ist das Umlaufvermögen";
        RealmList<RealmString> answers129 = new RealmList<>();
        answers129.add(new RealmString("A) gewachsen."));
        answers129.add(new RealmString("B) geschrumpft ."));
        answers129.add(new RealmString("C) gleich geblieben ."));
        answers129.add(new RealmString("D) alles ."));

        Question question129 = new Question(128,questionStr129,answers129,"",0);
        String questionStr130 = "Das Konto Fremdkapital wurde im SOLL gebucht. Damit ist das Fremdkapital";
        RealmList<RealmString> answers130 = new RealmList<>();
        answers130.add(new RealmString("A) gewachsen."));
        answers130.add(new RealmString("B) geschrumpft"));
        answers130.add(new RealmString("C) gleich geblieben ."));
        answers130.add(new RealmString("D) alles ."));

        Question question130 = new Question(129,questionStr130,answers130,"",1);
        String questionStr131 = "Das Konto Eigenkapital wurde im SOLL gebucht. Damit ist das Eigenkapital";
        RealmList<RealmString> answers131 = new RealmList<>();
        answers131.add(new RealmString("A) gewachsen."));
        answers131.add(new RealmString("B) geschrumpft"));
        answers131.add(new RealmString("C) gleich geblieben ."));
        answers131.add(new RealmString("D) alles ."));

        Question question131 = new Question(130,questionStr131,answers131,"2.2",1);
        String questionStr132 = "Das Konto Anlagevermögen wurde im SOLL gebucht. Damit ist das Anlagevermögen";
        RealmList<RealmString> answers132 = new RealmList<>();
        answers132.add(new RealmString("A) gewachsen."));
        answers132.add(new RealmString("B) geschrumpft"));
        answers132.add(new RealmString("C) gleich geblieben ."));
        answers132.add(new RealmString("D) alles ."));

        Question question132 = new Question(131,questionStr132,answers132,"",0);
        String questionStr133 = "Ein T-Konto hat 4 Buchungen zu je 2.000 €im Soll und 8 Buchungen zu je 1.500 €im Haben. Um welchen  Saldo mit welchem Wert handelt es sich?";
        RealmList<RealmString> answers133 = new RealmList<>();
        answers133.add(new RealmString("A) Sollsaldo von 4.000 €"));
        answers133.add(new RealmString("B) Habensaldo von 4.000 €"));
        answers133.add(new RealmString("C) Sollsaldo von 8.000 €"));
        answers133.add(new RealmString("D) Habensaldo von 8.000 €"));

        Question question133 = new Question(132,questionStr133,answers133,"2.2",1);
        String questionStr134 = "Ein T-Konto hat 8 Buchungen zu je 1.500 €im Soll und 4 Buchungen zu je 2.000 €im Haben . Um welchen  Saldo mit welchem Wert handelt es sich?";
        RealmList<RealmString> answers134 = new RealmList<>();
        answers134.add(new RealmString("A) Sollsaldo von 4.000 €"));
        answers134.add(new RealmString("B) Habensaldo von 4.000 €"));
        answers134.add(new RealmString("C) Sollsaldo von 8.000 €"));
        answers134.add(new RealmString("D) Habensaldo von 8.000 €"));

        Question question134 = new Question(133,questionStr134,answers134,"",0);
        String questionStr135 = "EinT-Konto hat 5 Buchungen zu je 1.000 €im Soll und 10 Buchungen zu je 2.000 €im Haben. Um welchen  Saldo mit welchem Wert handelt es sich?";
        RealmList<RealmString> answers135 = new RealmList<>();
        answers135.add(new RealmString("A) Sollsaldo von 15.000 €"));
        answers135.add(new RealmString("B) Habensaldo von 15.000 €"));
        answers135.add(new RealmString("C) Sollsaldo von 20.000 €"));
        answers135.add(new RealmString("D) Habensaldo von 20.000 €"));

        Question question135 = new Question(134,questionStr135,answers135,"2.2",1);
        String questionStr136 = "Ein T-Konto hat 10 Buchungen zu je 2.000 €im Soll und 5 Buchungen zu je 1.000 €im Haben . Um  welchen Saldo mit welchem Wert handelt es sich?";
        RealmList<RealmString> answers136 = new RealmList<>();
        answers136.add(new RealmString("A) Sollsaldo von 15.000 €"));
        answers136.add(new RealmString("B) Habensaldo von 15.000 €"));
        answers136.add(new RealmString("C) Sollsaldo von 20.000 €"));
        answers136.add(new RealmString("D) Habensaldo von 20.000 €"));

        Question question136 = new Question(135,questionStr136,answers136,"",0);
        String questionStr137 = "Wie lautet der Fachbegriff für das zweite Konto (das Haben-Konto) auf dem ein Geschäftsvorfall gebucht  wird? ";
        RealmList<RealmString> answers137 = new RealmList<>();
        answers137.add(new RealmString("A) Kontogegner"));
        answers137.add(new RealmString("B) Gegenposten"));
        answers137.add(new RealmString("C) Zweitkonto"));
        answers137.add(new RealmString("D) Gegenkonto"));

        Question question137 = new Question(136,questionStr137,answers137,"2.2",3);
        String questionStr138 = "Ein Buchungssatz lautet immer";
        RealmList<RealmString> answers138 = new RealmList<>();
        answers138.add(new RealmString("A) Haben anHaben"));
        answers138.add(new RealmString("B) Haben an Soll"));
        answers138.add(new RealmString("C) Soll an Haben"));
        answers138.add(new RealmString("D) Soll anSoll"));

        Question question138 = new Question(137,questionStr138,answers138,"",2);
        String questionStr139 = "Buchungen,die Gewinn oder Verlust beeinflussen, nennt man";
        RealmList<RealmString> answers139 = new RealmList<>();
        answers139.add(new RealmString("A) erfolgreich"));
        answers139.add(new RealmString("B) erfolgsam"));
        answers139.add(new RealmString("C) erfolgswirksam"));
        answers139.add(new RealmString("D) erfolgsneutral"));

        Question question139 = new Question(138,questionStr139,answers139,"2.2",2);
        String questionStr140 = "Ein Ertrag ist ein(e)";
        RealmList<RealmString> answers140 = new RealmList<>();
        answers140.add(new RealmString("A) Werteverzehr"));
        answers140.add(new RealmString("B) Wertezuwachs"));
        answers140.add(new RealmString("C) Werteverlust"));
        answers140.add(new RealmString("D) Werterhellung"));

        Question question140 = new Question(139,questionStr140,answers140,"",1);
        String questionStr141 = "Ertragund Gewinn ist das Gleiche";
        RealmList<RealmString> answers141 = new RealmList<>();
        answers141.add(new RealmString("A) immer"));
        answers141.add(new RealmString("B) nie"));
        answers141.add(new RealmString("C) häufig"));
        answers141.add(new RealmString("D) manchmal"));

        Question question141 = new Question(140,questionStr141,answers141,"2.2",1);
        String questionStr142 = "Aufwand und Verlust ist das Gleiche";
        RealmList<RealmString> answers142 = new RealmList<>();
        answers142.add(new RealmString("A) immer"));
        answers142.add(new RealmString("B) nie"));
        answers142.add(new RealmString("C) häufig"));
        answers142.add(new RealmString("D) manchmal"));

        Question question142 = new Question(141,questionStr142,answers142,"",1);
        String questionStr143 = "Ein Aufwand ist ein(e)";
        RealmList<RealmString> answers143 = new RealmList<>();
        answers143.add(new RealmString("A) Werteverzehr"));
        answers143.add(new RealmString("B) Wertezuwachs"));
        answers143.add(new RealmString("C) Werteverlust"));
        answers143.add(new RealmString("D) Werterhellung"));

        Question question143 = new Question(142,questionStr143,answers143,"2.2",0);
        String questionStr144 = "Ein Geschäftsvorfall, der einen Werteverzehr darstellt (Aufwand) wird gebucht auf ein";
        RealmList<RealmString> answers144 = new RealmList<>();
        answers144.add(new RealmString("A) Privatkonto"));
        answers144.add(new RealmString("B) Erfolgskonto"));
        answers144.add(new RealmString("C) Bestandskonto"));
        answers144.add(new RealmString("D) Keiner dieserKonten"));

        Question question144 = new Question(143,questionStr144,answers144,"",1);
        String questionStr145 = "Ein Geschäftsvorfall, der einen Wertezuwachs darstellt (Ertrag) wird gebucht auf ein";
        RealmList<RealmString> answers145 = new RealmList<>();
        answers145.add(new RealmString("A) Privatkonto"));
        answers145.add(new RealmString("B) Erfolgskonto"));
        answers145.add(new RealmString("C) Bestandskonto"));
        answers145.add(new RealmString("D) Keiner dieserKonten"));

        Question question145 = new Question(144,questionStr145,answers145,"2.2",1);
        String questionStr146 = "Ein Geschäftsvorfall wurde auf die Habenseite eines Erfolgskontos gebucht. Somit handelt es sich um  eine(n)";
        RealmList<RealmString> answers146 = new RealmList<>();
        answers146.add(new RealmString("A) Ertrag"));
        answers146.add(new RealmString("B) Aufwand"));
        answers146.add(new RealmString("C) Entnahme"));
        answers146.add(new RealmString("D) Einlage"));

        Question question146 = new Question(145,questionStr146,answers146,"",0);
        String questionStr147 = "Ein Geschäftsvorfall wurde auf die Sollseite eines Erfolgskontos gebucht. Somit handelt es sich um eine(n)";
        RealmList<RealmString> answers147 = new RealmList<>();
        answers147.add(new RealmString("A) Ertrag"));
        answers147.add(new RealmString("B) Aufwand"));
        answers147.add(new RealmString("C) Entnahme"));
        answers147.add(new RealmString("D) Einlage"));

        Question question147 = new Question(146,questionStr147,answers147,"2.2",1);
        String questionStr148 = "Ein Geschäftsvorfall wurde auf die Habenseite eines Privatkontos gebucht. Somit handelt es sich um  eine(n)";
        RealmList<RealmString> answers148 = new RealmList<>();
        answers148.add(new RealmString("A) Ertrag"));
        answers148.add(new RealmString("B) Aufwand"));
        answers148.add(new RealmString("C) Entnahme"));
        answers148.add(new RealmString("D) Einlage"));

        Question question148 = new Question(147,questionStr148,answers148,"",3);
        String questionStr149 = "Ein Geschäftsvorfall wurde auf die Sollseite eines Privatkontos gebucht. Somit handelt es sich um eine(n)";
        RealmList<RealmString> answers149 = new RealmList<>();
        answers149.add(new RealmString("A) Ertrag"));
        answers149.add(new RealmString("B) Aufwand"));
        answers149.add(new RealmString("C) Entnahme"));
        answers149.add(new RealmString("D) Einlage"));

        Question question149 = new Question(148,questionStr149,answers149,"",2);
        String questionStr150 = "Welcher Geschäftsvorfall berührt ein Eigenkapitalunterkonto?";
        RealmList<RealmString> answers150 = new RealmList<>();
        answers150.add(new RealmString("A) Materialkauf in bar"));
        answers150.add(new RealmString("B) Kredittilgung"));
        answers150.add(new RealmString("C) Zinszahlung"));
        answers150.add(new RealmString("D) Zahlung an Lieferant"));

        Question question150 = new Question(149,questionStr150,answers150,"",2);
        String questionStr151 = "Welcher Geschäftsvorfall berührt ein Umlaufvermögenunterkonto?";
        RealmList<RealmString> answers151 = new RealmList<>();
        answers151.add(new RealmString("A) Materialkauf in bar"));
        answers151.add(new RealmString("B) Kredittilgung"));
        answers151.add(new RealmString("C) Zinszahlung"));
        answers151.add(new RealmString("D) Zahlung an Lieferant"));

        Question question151 = new Question(150,questionStr151,answers151,"2.2",0);
        String questionStr152 = "Welcher Geschäftsvorfall berührt ein Fremdkapitalunterkonto?";
        RealmList<RealmString> answers152 = new RealmList<>();
        answers152.add(new RealmString("A) Materialkauf in bar"));
        answers152.add(new RealmString("B) Kredittilgung"));
        answers152.add(new RealmString("C) Bareinlage von 200 €"));
        answers152.add(new RealmString("D) Kauf eines Gebäudes"));

        Question question152 = new Question(151,questionStr152,answers152,"",1);
        String questionStr153 = "Welcher Geschäftsvorfall berührt ein Anlagevermögenunterkonto?";
        RealmList<RealmString> answers153 = new RealmList<>();
        answers153.add(new RealmString("A) Materialkauf in bar"));
        answers153.add(new RealmString("B) Kredittilgung"));
        answers153.add(new RealmString("C) Zinszahlung"));
        answers153.add(new RealmString("D) Kauf eines Gebäudes"));

        Question question153 = new Question(152,questionStr153,answers153,"2.2",3);
        String questionStr154 = "Welcher Geschäftsvorfall berührt kein Eigenkapitalunterkonto?";
        RealmList<RealmString> answers154 = new RealmList<>();
        answers154.add(new RealmString("A) Gehaltszahlung"));
        answers154.add(new RealmString("B) Kapitalentnahme"));
        answers154.add(new RealmString("C) Materialkauf auf Ziel"));
        answers154.add(new RealmString("D) Zinszahlung"));

        Question question154 = new Question(153,questionStr154,answers154,"",2);
        String questionStr155 = "Welcher Geschäftsvorfall berührt kein Fremdkapitalunterkonto?";
        RealmList<RealmString> answers155 = new RealmList<>();
        answers155.add(new RealmString("A) Materialkauf in bar"));
        answers155.add(new RealmString("B) Kredittilgung"));
        answers155.add(new RealmString("C) Kreditaufnahme"));
        answers155.add(new RealmString("D) Zahlung an Lieferant"));

        Question question155 = new Question(154,questionStr155,answers155,"2.2",0);
        String questionStr156 = "Welcher Geschäftsvorfall berührt kein Anlagevermögenunterkonto?";
        RealmList<RealmString> answers156 = new RealmList<>();
        answers156.add(new RealmString("A) Planmäßige Abschreibung"));
        answers156.add(new RealmString("B) Außerplanmäßige AbschreibungeinerMaschine"));
        answers156.add(new RealmString("C) Kauf einer Maschine"));
        answers156.add(new RealmString("D) Kauf von Holzbrettern"));

        Question question156 = new Question(155,questionStr156,answers156,"",3);
        String questionStr157 = "Welcher Geschäftsvorfall berührt kein Umlaufvermögenunterkonto?";
        RealmList<RealmString> answers157 = new RealmList<>();
        answers157.add(new RealmString("A) Kauf einer Maschine auf Ziel"));
        answers157.add(new RealmString("B) Kredittilgung"));
        answers157.add(new RealmString("C) Zinszahlung"));
        answers157.add(new RealmString("D) Zahlung an Lieferant"));

        Question question157 = new Question(156,questionStr157,answers157,"2.2",0);
        String questionStr158 = "Welcher Geschäftsvorfall berührt kein Umlaufvermögenunterkonto?";
        RealmList<RealmString> answers158 = new RealmList<>();
        answers158.add(new RealmString("A) Kauf einer Maschine in bar"));
        answers158.add(new RealmString("B) Kauf von Vorräten auf Ziel"));
        answers158.add(new RealmString("C) Sacheinlage in Form einesGebäudes"));
        answers158.add(new RealmString("D) Gehaltszahlung"));

        Question question158 = new Question(157,questionStr158,answers158,"",2);
        String questionStr159 = "Aufwendungen und Erträge bucht man auf ";
        RealmList<RealmString> answers159 = new RealmList<>();
        answers159.add(new RealmString("A) Privatkonten"));
        answers159.add(new RealmString("B) Erfolgskonten"));
        answers159.add(new RealmString("C) Schuldkonten"));
        answers159.add(new RealmString("D) Sonstige Konten"));

        Question question159 = new Question(158,questionStr159,answers159,"2.2",1);
        String questionStr160 = "Einlagen und Entnahmen bucht man auf ";
        RealmList<RealmString> answers160 = new RealmList<>();
        answers160.add(new RealmString("A) Privatkonten"));
        answers160.add(new RealmString("B) Erfolgskonten"));
        answers160.add(new RealmString("C) Schuldkonten"));
        answers160.add(new RealmString("D) Sonstige Konten"));

        Question question160 = new Question(159,questionStr160,answers160,"",0);
        String questionStr161 = "Materialkonten gehören zum";
        RealmList<RealmString> answers161 = new RealmList<>();
        answers161.add(new RealmString("A) Anlagevermögen"));
        answers161.add(new RealmString("B) Eigenkapital"));
        answers161.add(new RealmString("C) Umlaufvermögen"));
        answers161.add(new RealmString("D) Fremdkapital"));

        Question question161 = new Question(160,questionStr161,answers161,"2.2",2);
        String questionStr162 = "Das Konto „Fuhrpark“ gehört zum";
        RealmList<RealmString> answers162 = new RealmList<>();
        answers162.add(new RealmString("A) Anlagevermögen"));
        answers162.add(new RealmString("B) Eigenkapital"));
        answers162.add(new RealmString("C) Umlaufvermögen"));
        answers162.add(new RealmString("D) Fremdkapital"));

        Question question162 = new Question(161,questionStr162,answers162,"",0);
        String questionStr163 = "Der Geschäftsvorfall „Einkauf von Material auf Ziel“ führt dazu, dass";
        RealmList<RealmString> answers163 = new RealmList<>();
        answers163.add(new RealmString("A) das Fremdkapital steigt"));
        answers163.add(new RealmString("B) das Fremdkapital sinkt"));
        answers163.add(new RealmString("C) das Eigenkapital steigt"));
        answers163.add(new RealmString("D) das Eigenkapital sinkt"));

        Question question163 = new Question(162,questionStr163,answers163,"",0);
        String questionStr164 = "Der Geschäftsvorfall „Tilgung eines Kredites“ führt dazu, dass";
        RealmList<RealmString> answers164 = new RealmList<>();
        answers164.add(new RealmString("A) das Fremdkapital steigt"));
        answers164.add(new RealmString("B) das Fremdkapital sinkt"));
        answers164.add(new RealmString("C) das Eigenkapital steigt"));
        answers164.add(new RealmString("D) das Eigenkapital sinkt"));

        Question question164 = new Question(163,questionStr164,answers164,"",1);
        String questionStr165 = "Der Geschäftsvorfall „Werteverlust eines Gebäudes“ führt dazu, dass";
        RealmList<RealmString> answers165 = new RealmList<>();
        answers165.add(new RealmString("A) das Fremdkapital steigt"));
        answers165.add(new RealmString("B) das Fremdkapital sinkt"));
        answers165.add(new RealmString("C) das Eigenkapital steigt"));
        answers165.add(new RealmString("D) das Eigenkapital sinkt"));

        Question question165 = new Question(164,questionStr165,answers165,"2.2",3);
        String questionStr166 = "Der Geschäftsvorfall „Bareinlage in Höhe von 1.000 €“ führt dazu, dass";
        RealmList<RealmString> answers166 = new RealmList<>();
        answers166.add(new RealmString("A) das Fremdkapital steigt"));
        answers166.add(new RealmString("B) das Fremdkapital sinkt"));
        answers166.add(new RealmString("C) das Eigenkapital steigt"));
        answers166.add(new RealmString("D) das Eigenkapital sinkt"));

        Question question166 = new Question(165,questionStr166,answers166,"",2);
        String questionStr167 = "Wenn ein Materialkonto mit 4.000 €im Haben gebucht worden ist, dann ist der Materialbestand";
        RealmList<RealmString> answers167 = new RealmList<>();
        answers167.add(new RealmString("A) gesunken"));
        answers167.add(new RealmString("B) gestiegen"));
        answers167.add(new RealmString("C) gleich geblieben"));
        answers167.add(new RealmString("D) alles"));

        Question question167 = new Question(166,questionStr167,answers167,"2.2",0);
        String questionStr168 = "Wenn ein Materialkonto mit 4.000 €im Soll gebucht worden ist, dann ist der Materialbestand";
        RealmList<RealmString> answers168 = new RealmList<>();
        answers168.add(new RealmString("A) gesunken"));
        answers168.add(new RealmString("B) gestiegen"));
        answers168.add(new RealmString("C) gleich geblieben"));
        answers168.add(new RealmString("D) alles"));

        Question question168 = new Question(167,questionStr168,answers168,"",1);
        String questionStr169 = "Wenn ein Privatkonto mit 1.000 €im Haben gebucht worden ist, dann ist das Eigenkapital";
        RealmList<RealmString> answers169 = new RealmList<>();
        answers169.add(new RealmString("A) gesunken"));
        answers169.add(new RealmString("B) gestiegen"));
        answers169.add(new RealmString("C) gleich geblieben"));
        answers169.add(new RealmString("D) alles"));

        Question question169 = new Question(168,questionStr169,answers169,"",1);
        String questionStr170 = "Wenn ein Privatkonto mit 4.000 €im Soll gebucht worden ist, dann ist das Eigenkapital";
        RealmList<RealmString> answers170 = new RealmList<>();
        answers170.add(new RealmString("A) gesunken"));
        answers170.add(new RealmString("B) gestiegen"));
        answers170.add(new RealmString("C) gleich geblieben"));
        answers170.add(new RealmString("D) alles"));

        Question question170 = new Question(169,questionStr170,answers170,"",0);
        String questionStr171 = "Die Methode, um die Abweichung der Buchwerte zur Realität festzustellen, ist das (die)";
        RealmList<RealmString> answers171 = new RealmList<>();
        answers171.add(new RealmString("A) Inquisition"));
        answers171.add(new RealmString("B) Investitur"));
        answers171.add(new RealmString("C) Inventur"));
        answers171.add(new RealmString("D) Inventar"));

        Question question171 = new Question(170,questionStr171,answers171,"",2);
        String questionStr172 = "Buchdruckermeister OttoMüller nimmtseinegewerbliche Tätigkeitam01.04 .01 auf.Sein Eigenkapital beträgt zudiesem Zeitpunkt 200.000 €– Schulden existieren nicht.Zum 31.12.01 erstellt erden Jahresabschluss .Für 01betragen dieErträge 220.000 €und dieAufwendungen 130.000 €. Das Eigenkapital wurdenurdurch betriebliche Vorgängeverändert.Wie hoch istder Erfolg des Geschäftsjahres?";
        RealmList<RealmString> answers172 = new RealmList<>();
        answers172.add(new RealmString("A) 200.000 €"));
        answers172.add(new RealmString("B) 90.000 €"));
        answers172.add(new RealmString("C) 290.000 €"));
        answers172.add(new RealmString("D) 220.000 €"));

        Question question172 = new Question(171,questionStr172,answers172,"2.2",1);
        String questionStr173 = "Aufgabenstellung oben. Wo wirdder Erfolg des Geschäftsjahres ausgewiesen? ";
        RealmList<RealmString> answers173 = new RealmList<>();
        answers173.add(new RealmString("A) Bilanz"));
        answers173.add(new RealmString("B) GuV"));
        answers173.add(new RealmString("C) Anhang"));
        answers173.add(new RealmString("D) Cash Flow"));

        Question question173 = new Question(172,questionStr173,answers173,"",1);
        String questionStr174 = "Buchdruckermeister OttoMüller nimmtseinegewerbliche Tätigkeitam01.04 .01 auf.Sein Eigenkapital beträgt zudiesem Zeitpunkt 200.000 €– Schulden existieren nicht.Zum 31.12.01 erstellt erden Jahresabschluss .Für 01betragen dieErträge 220.000 €und dieAufwendungen 130.000 €. Das Eigenkapital wurdenurdurch betriebliche Vorgängeverändert.Wie hoch istdas Reinvermögen (=Eigenkapital) amEnde desGeschäftsjahres?";
        RealmList<RealmString> answers174 = new RealmList<>();
        answers174.add(new RealmString("A) 200.000 €"));
        answers174.add(new RealmString("B) 90.000 €"));
        answers174.add(new RealmString("C) 290.000 €"));
        answers174.add(new RealmString("D) 220.000 €"));

        Question question174 = new Question(173,questionStr174,answers174,"2.2",2);
        String questionStr175 = "Aufgabenstellung oben. Wo wirddas Reinvermögen ausgewiesen? ";
        RealmList<RealmString> answers175 = new RealmList<>();
        answers175.add(new RealmString("A) Bilanz"));
        answers175.add(new RealmString("B) GuV"));
        answers175.add(new RealmString("C) Anhang"));
        answers175.add(new RealmString("D) Cash Flow"));

        Question question175 = new Question(174,questionStr175,answers175,"",0);
        String questionStr176 = "Buchdruckermeister Otto Müller nimmt seine gewerbliche Tätigkeit am01.04 .01 auf.Sein Eigenkapital beträgt zudiesem Zeitpunkt 200.000 €– Schulden existieren nicht.Zum 31.12.01 erstellt erden Jahresabschluss .Für 01betragen dieErträge 220.000 €und dieAufwendungen 130.000 €. Das Eigenkapital wurdenurdurch betriebliche Vorgängeverändert.Besteht hiereine Reinvermögensmehrung oder –minderung undwiehoch istder jeweilige Betrag?";
        RealmList<RealmString> answers176 = new RealmList<>();
        answers176.add(new RealmString("A) Reinvermögensmehrung um 220.000 €."));
        answers176.add(new RealmString("B) Reinvermögensmehrung um 90.000 €."));
        answers176.add(new RealmString("C) Reinvermögensminderung um 130.000 €."));
        answers176.add(new RealmString("D) Reinvermögensminderung um 290.000 €."));

        Question question176 = new Question(175,questionStr176,answers176,"2.2",1);
        String questionStr177 = "Markieren Sie die falsche Antwort!";
        RealmList<RealmString> answers177 = new RealmList<>();
        answers177.add(new RealmString("A) Die Bilanz ist eine Zeitraumrechnung, z.B. für die Zeit vom 1.1.XX bis 31.12.XX."));
        answers177.add(new RealmString("B) Die Gewinn -und Verlustrechnung ist eine Zeitraumrechnung, z.B. für die Zeit vom 1.1.XX bis 31.12.XX."));
        answers177.add(new RealmString("C) Die Cashflow -Rechnungist eine Zeitraumrechnung, z.B. für die Zeit vom 1.1.XX bis 31.12.XX."));
        answers177.add(new RealmString("D) Der Eigenkapitalspiegel ist eine Zeitraumrechnung, z.B. für die Zeit vom 1.1.XX bis 31.12.XX."));

        Question question177 = new Question(176,questionStr177,answers177,"2.2",0);
        String questionStr178 = "Die Finanzbuchhaltung beinhaltet folgendes nicht:";
        RealmList<RealmString> answers178 = new RealmList<>();
        answers178.add(new RealmString("A) Kreditorenbuchhaltung"));
        answers178.add(new RealmString("B) Personalbuchhaltung"));
        answers178.add(new RealmString("C) Anlagenbuchhaltung"));
        answers178.add(new RealmString("D) Forecastingbuchhaltung"));

        Question question178 = new Question(177,questionStr178,answers178,"2.2",3);
        String questionStr179 = "Debitorenbuchhaltung dokumentiert…";
        RealmList<RealmString> answers179 = new RealmList<>();
        answers179.add(new RealmString("A) den Geschäftsverkehr mit Lieferanten."));
        answers179.add(new RealmString("B) die Lohn-bzw. Gehaltskonten für jeden Arbeitnehmer."));
        answers179.add(new RealmString("C) Wertänderungen, Zugänge und Abgänge von Anlagen."));
        answers179.add(new RealmString("D) den G eschäftsverkehr mit Kunden."));

        Question question179 = new Question(178,questionStr179,answers179,"",3);

        //2.3
        String questionStr180 = "Abschreibungen gehen zu Lasten der ";
        RealmList<RealmString> answers180 = new RealmList<>();
        answers180.add(new RealmString("A) Gläubiger"));
        answers180.add(new RealmString("B) Eigentümer"));
        answers180.add(new RealmString("C) Mitarbeiter"));
        answers180.add(new RealmString("D) Kunden"));

        Question question180 = new Question(179,questionStr180,answers180,"2.3",1);
        String questionStr181 = "Abschreibungen bewirken ein(e)";
        RealmList<RealmString> answers181 = new RealmList<>();
        answers181.add(new RealmString("A) Geldabfluss"));
        answers181.add(new RealmString("B) Geldzufluss"));
        answers181.add(new RealmString("C) Eigenkapitalminderung"));
        answers181.add(new RealmString("D) Eigenkapitalmehrung"));

        Question question181 = new Question(180,questionStr181,answers181,"",2);
        String questionStr182 = "Gleichmäßigejährliche Abschreibungen nennt man ";
        RealmList<RealmString> answers182 = new RealmList<>();
        answers182.add(new RealmString("A) degressive Abschreibung"));
        answers182.add(new RealmString("B) lineare Abschreibung"));
        answers182.add(new RealmString("C) bipolare Abschreibung"));
        answers182.add(new RealmString("D) Suggestivabschreibung"));

        Question question182 = new Question(181,questionStr182,answers182,"2.3",1);

        realm.beginTransaction();
        realm.copyToRealm(question67);
        realm.copyToRealm(question68);
        realm.copyToRealm(question69);
        realm.copyToRealm(question70);
        realm.copyToRealm(question71);
        realm.copyToRealm(question72);
        realm.copyToRealm(question73);
        realm.copyToRealm(question74);
        realm.copyToRealm(question75);
        realm.copyToRealm(question76);
        realm.copyToRealm(question77);
        realm.copyToRealm(question78);
        realm.copyToRealm(question79);
        realm.copyToRealm(question80);
        realm.copyToRealm(question81);
        realm.copyToRealm(question82);
        realm.copyToRealm(question83);
        realm.copyToRealm(question84);
        realm.copyToRealm(question85);
        realm.copyToRealm(question86);
        realm.copyToRealm(question87);
        realm.copyToRealm(question88);
        realm.copyToRealm(question89);
        realm.copyToRealm(question90);
        realm.copyToRealm(question91);
        realm.copyToRealm(question92);
        realm.copyToRealm(question93);
        realm.copyToRealm(question94);
        realm.copyToRealm(question95);
        realm.copyToRealm(question96);
        realm.copyToRealm(question97);
        realm.copyToRealm(question98);
        realm.copyToRealm(question99);
        realm.copyToRealm(question100);
        realm.copyToRealm(question101);
        realm.copyToRealm(question102);
        realm.copyToRealm(question103);
        realm.copyToRealm(question104);
        realm.copyToRealm(question105);
        realm.copyToRealm(question106);
        realm.copyToRealm(question107);
        realm.copyToRealm(question108);
        realm.copyToRealm(question109);
        realm.copyToRealm(question110);
        realm.copyToRealm(question111);
        realm.copyToRealm(question112);
        realm.copyToRealm(question113);
        realm.copyToRealm(question114);
        realm.copyToRealm(question115);
        realm.copyToRealm(question116);
        realm.copyToRealm(question117);
        realm.copyToRealm(question118);
        realm.copyToRealm(question119);
        realm.copyToRealm(question120);
        realm.copyToRealm(question121);
        realm.copyToRealm(question122);
        realm.copyToRealm(question123);
        realm.copyToRealm(question124);
        realm.copyToRealm(question125);
        realm.copyToRealm(question126);
        realm.copyToRealm(question127);
        realm.copyToRealm(question128);
        realm.copyToRealm(question129);
        realm.copyToRealm(question130);
        realm.copyToRealm(question131);
        realm.copyToRealm(question132);
        realm.copyToRealm(question133);
        realm.copyToRealm(question134);
        realm.copyToRealm(question135);
        realm.copyToRealm(question136);
        realm.copyToRealm(question137);
        realm.copyToRealm(question138);
        realm.copyToRealm(question139);
        realm.copyToRealm(question140);
        realm.copyToRealm(question141);
        realm.copyToRealm(question142);
        realm.copyToRealm(question143);
        realm.copyToRealm(question144);
        realm.copyToRealm(question145);
        realm.copyToRealm(question146);
        realm.copyToRealm(question147);
        realm.copyToRealm(question148);
        realm.copyToRealm(question149);
        realm.copyToRealm(question150);
        realm.copyToRealm(question151);
        realm.copyToRealm(question152);
        realm.copyToRealm(question153);
        realm.copyToRealm(question154);
        realm.copyToRealm(question155);
        realm.copyToRealm(question156);
        realm.copyToRealm(question157);
        realm.copyToRealm(question158);
        realm.copyToRealm(question159);
        realm.copyToRealm(question160);
        realm.copyToRealm(question161);
        realm.copyToRealm(question162);
        realm.copyToRealm(question163);
        realm.copyToRealm(question164);
        realm.copyToRealm(question165);
        realm.copyToRealm(question166);
        realm.copyToRealm(question167);
        realm.copyToRealm(question168);
        realm.copyToRealm(question169);
        realm.copyToRealm(question170);
        realm.copyToRealm(question171);
        realm.copyToRealm(question172);
        realm.copyToRealm(question173);
        realm.copyToRealm(question174);
        realm.copyToRealm(question175);
        realm.copyToRealm(question176);
        realm.copyToRealm(question177);
        realm.copyToRealm(question178);
        realm.copyToRealm(question179);
        realm.copyToRealm(question180);
        realm.copyToRealm(question181);
        realm.copyToRealm(question182);
        realm.commitTransaction();
    }

    //JA1
    private void initQuestions3() {
        String questionStr183 = "Einzelhändler Müller betreibt seit Jahren ein Handelsgeschäft in Würzburg mit zehn Angestellten. Er hat  Kredite in Höhe von durchschnittlich 200.000 €bei der X -Bank. Die jährliche Zinsbelastung beträgt  durchschnittlich 20.000 €. Der Angestellte Müller ist 52 Jahre alt und bezieht ein Gehalt von monatlich 2.300  € (die Sozialversicherung ist zu vernachlässigen). Es wird ein 13. Monatsgehalt gezahlt. Großhändler  Schulze liefert Waren an Müller im Wert von durchschnittlich 250.000 € pro Jahr (inklusive Gewinnaufschlag  von 25%). Welche Jahresabschlussadressaten werden betroffen?";
        RealmList<RealmString> answers183 = new RealmList<>();
        answers183.add(new RealmString("A) Keiner"));
        answers183.add(new RealmString("B) Nur Mitarbeiter"));
        answers183.add(new RealmString("C) Nur Mitarbeiter und Bank"));
        answers183.add(new RealmString("D) Mitarbeiter, Bank und Lieferanten"));

        Question question183 = new Question(182,questionStr183,answers183,"3.1",4);
        String questionStr184 = "Aufgabenstellung wieoben . Welches Zielhaben die eben genannten Jahresabschlussadressaten gemeinsam ?";
        RealmList<RealmString> answers184 = new RealmList<>();
        answers184.add(new RealmString("A) Liquidation des Unternehmens , um daraus Zahlungen zubeziehen"));
        answers184.add(new RealmString("B) Zusammenschluss desUnternehmens miteinem kleineren Unternehmen"));
        answers184.add(new RealmString("C) Unternehmenserhaltung"));
        answers184.add(new RealmString("D) Keines"));

        Question question184 = new Question(183,questionStr184,answers184,"",2);
        String questionStr185 = "Welcher der folgenden Funktionen ist keineBasisaufgabedes Jahresabschlusses?";
        RealmList<RealmString> answers185 = new RealmList<>();
        answers185.add(new RealmString("A) Informationsfunktion"));
        answers185.add(new RealmString("B) Vergütungsfunktion"));
        answers185.add(new RealmString("C) Dokumentationsfunktion"));
        answers185.add(new RealmString("D) Zahlungsbemessungsfunktion"));

        Question question185 = new Question(184,questionStr185,answers185,"3.1",1);
        String questionStr186 = "Wer ist kein Stakeholder der Zahlungsbemessungsfunktion des Jahresabschlusses ?";
        RealmList<RealmString> answers186 = new RealmList<>();
        answers186.add(new RealmString("A) Anteilseigner"));
        answers186.add(new RealmString("B) Mitarbeiter"));
        answers186.add(new RealmString("C) Gläubiger"));
        answers186.add(new RealmString("D) Fiskus"));

        Question question186 = new Question(185,questionStr186,answers186,"",2);
        String questionStr187 = "Welche Aufgaben soll ein Jahresabschluss gegenüber den Aktionären primär erfüllen?";
        RealmList<RealmString> answers187 = new RealmList<>();
        answers187.add(new RealmString("A) Zahlungsbemessungsfunktion und Informationsfunktion (Rechenschaftslegung)"));
        answers187.add(new RealmString("B) Vergütungsbemessungsfunktion und Informationsfunktion (Rechenschaftslegung)"));
        answers187.add(new RealmString("C) Vergütungsbemessungsfunktion und Zahlungsbemessungsfunktion"));
        answers187.add(new RealmString("D) Vergütungsbemessungsfunktion und Dokumentationsfunktion"));

        Question question187 = new Question(186,questionStr187,answers187,"3.1",0);
        String questionStr188 = "Welche Aufgabe soll ein Jahresabschluss gegenüber den Gläubigern primär erfüllen?";
        RealmList<RealmString> answers188 = new RealmList<>();
        answers188.add(new RealmString("A) Zahlungsbemessungsfunktion"));
        answers188.add(new RealmString("B) Vergütungsbemessungsfunktion"));
        answers188.add(new RealmString("C) Informationsfunktion (Rechenschaftslegung)"));
        answers188.add(new RealmString("D) Dokumentationsfunktion"));

        Question question188 = new Question(187,questionStr188,answers188,"",2);
        String questionStr189 = "Welche Aufgaben müssen Bilanzen gegenüber V eranlagungsbehörden für die Steuern vom Einkommen  und Ertrag nicht erfüllen?";
        RealmList<RealmString> answers189 = new RealmList<>();
        answers189.add(new RealmString("A) Zahlungsbemessungsfunktion"));
        answers189.add(new RealmString("B) Vergütungsbemessungsfunktion"));
        answers189.add(new RealmString("C) Informationsfunktion (Rechenschaftslegung)"));
        answers189.add(new RealmString("D) Dokumentationsfunktion"));

        Question question189 = new Question(188,questionStr189,answers189,"3.1",1);
        String questionStr190 = "Der (nicht erweiterte) Jahresabschluss für einen Kaufmann besteht aus …";
        RealmList<RealmString> answers190 = new RealmList<>();
        answers190.add(new RealmString("A) Bilanz und GuV -Rechnung."));
        answers190.add(new RealmString("B) Bilanz, GuV-Rechnung und Anhang."));
        answers190.add(new RealmString("C) Bilanz, GuV -Rechnungund Lagebericht."));
        answers190.add(new RealmString("D) Bilanz, GuV -Rechnung, Anhang und Lagebericht."));

        Question question190 = new Question(189,questionStr190,answers190,"3.1",0);
        String questionStr191 = "Aus welchen Bestandteilen bestehtder maximal erweiterteJahresabschluss ? Segmentberichterstattung.";
        RealmList<RealmString> answers191 = new RealmList<>();
        answers191.add(new RealmString("A) Bilanz, GuV -Rechnung und Anhang."));
        answers191.add(new RealmString("B) Bilanz, GuV -Rechnung,Anhang,Kapitalflussrechnung und Eigenkapitalspiegel."));
        answers191.add(new RealmString("C) Bilanz, GuV -Rechnung,Anhang,Kapitalflussrechnung, Eigenkapitalspiegel und "));
        answers191.add(new RealmString("D) Bilanz, GuV -Rechnung,Anhang,Kapitalflussrechnung, Eigenkapitalspiegel, Segmentberichterstattung und Lagebericht."));

        Question question191 = new Question(190,questionStr191,answers191,"",2);
        String questionStr192 = "Der Jahresabschluss der nicht kapitalmarkorientierten und nicht dem PublG unterliegenden SchnölleroHG muss folgende Bestandteile beinhalten:";
        RealmList<RealmString> answers192 = new RealmList<>();
        answers192.add(new RealmString("A) Die Bilanz, GuV -Rechnung und Anhang."));
        answers192.add(new RealmString("B) Nur die Bilanz und die GuV -Rechnung."));
        answers192.add(new RealmString("C) Bilanz, GuV -Rechnungund Lagebericht."));
        answers192.add(new RealmString("D) Der Anhang ist ausreichend sofern ausreichend erläutert."));

        Question question192 = new Question(191,questionStr192,answers192,"3.1",1);
        String questionStr193 = "Welches der folgenden Dokumente ist niemals ein Bestandteil eines Jahresabschlusses?";
        RealmList<RealmString> answers193 = new RealmList<>();
        answers193.add(new RealmString("A) Kapitalflussrechnung"));
        answers193.add(new RealmString("B) Eigenkapitalspiegel"));
        answers193.add(new RealmString("C) Segmentberichterstattung"));
        answers193.add(new RealmString("D) Lagebericht"));

        Question question193 = new Question(192,questionStr193,answers193,"3.1",3);
        String questionStr194 = "Der Jahresabschluss der mittelgroßen, nicht kapitalmarktorientierten Kultur -GmbH muss folgende Bestandteile beinhalten:";
        RealmList<RealmString> answers194 = new RealmList<>();
        answers194.add(new RealmString("A) Nur die BilanzundGuV -Rechnung."));
        answers194.add(new RealmString("B) Bilanz, GuV -Rechnungund Lagebericht."));
        answers194.add(new RealmString("C) Bilanz, GuV -Rechnungund Anhang."));
        answers194.add(new RealmString("D) Bilanz, GuV -Rechnung, Anhang und Lagebericht."));

        Question question194 = new Question(193,questionStr194,answers194,"",2);
        String questionStr195 = "Welches Dokument ergänzt den Jahresabschluss einer mittelgroßen Kapitalgesellschaft?";
        RealmList<RealmString> answers195 = new RealmList<>();
        answers195.add(new RealmString("A) Kapitalflussrechnung"));
        answers195.add(new RealmString("B) Eigenkapitalspiegel"));
        answers195.add(new RealmString("C) Segmentberichterstattung"));
        answers195.add(new RealmString("D) Lagebericht"));

        Question question195 = new Question(194,questionStr195,answers195,"3.1",3);
        String questionStr196 = "Welches der folgenden Dokumente ist von einer mittelgroßen AG nicht zu erstellen?";
        RealmList<RealmString> answers196 = new RealmList<>();
        answers196.add(new RealmString("A) Anhang"));
        answers196.add(new RealmString("B) Eigenkapitalspiegel"));
        answers196.add(new RealmString("C) Lagebericht"));
        answers196.add(new RealmString("D) Alle Dokumente sind erforderlich"));

        Question question196 = new Question(195,questionStr196,answers196,"",1);
        String questionStr197 = "Die kapitalmarktorientierte Fast AG, die keinen Konzernabschluss aufstellen muss, muss folgende  Dokumente erstellen: Segmentberichterstattung. und Lagebericht.";
        RealmList<RealmString> answers197 = new RealmList<>();
        answers197.add(new RealmString("A) Bilanz, GuV -Rechnung,Anhang,Kapitalflussrechnung und Eigenkapitalspiegel."));
        answers197.add(new RealmString("B) Bilanz, GuV -Rechnung,Anhang,Kapitalflussrechnung, Eigenkapitalspiegel und "));
        answers197.add(new RealmString("C) Bilanz, GuV -Rechnung,Anhang,Kapitalflussrechnung, Eigenkapitalspiegel, Segmentberichterstattung "));
        answers197.add(new RealmString("D) Bilanz, GuV -Rechnung,Anhang,Kapitalflussrechnung, Eigenkapitalspiegel und Lagebericht."));

        Question question197 = new Question(196,questionStr197,answers197,"3.1",3);
        String questionStr198 = "Welches der folgenden Dokumente ist niemals verpflichtend ein Bestandteil eines Jahresabschlusses bei  einer kapitalmarktorientierten Kapitalgesellschaft?";
        RealmList<RealmString> answers198 = new RealmList<>();
        answers198.add(new RealmString("A) Kapitalflussrechnung"));
        answers198.add(new RealmString("B) Eigenkapitalspiegel"));
        answers198.add(new RealmString("C) Segmentberichterstattung"));
        answers198.add(new RealmString("D) Lagebericht"));

        Question question198 = new Question(197,questionStr198,answers198,"3.1",2);
        String questionStr199 = "Der Jahresabschluss einer kapitalmarktorientiertenAG, die einen Konzernabschluss aufstellen muss, muss  aus den folgenden Bestandteilen bestehen:";
        RealmList<RealmString> answers199 = new RealmList<>();
        answers199.add(new RealmString("A) Bilanz, GuV -Rechnung und Anhang."));
        answers199.add(new RealmString("B) Bilanz, GuV -Rechnung,Anhang,Kapitalflussrechnung und Eigenkapitalspiegel."));
        answers199.add(new RealmString("C) Bilanz, GuV -Rechnung,Anhang,Kapitalflussrechnung, Eigenkapitalspiegel und Lagebericht."));
        answers199.add(new RealmString("D) Bilanz, GuV -Rechnung,Anhang,Kapitalflussrechnung, Eigenkapitalspiegel, Segmentberichterstattung und Lagebericht."));

        Question question199 = new Question(198,questionStr199,answers199,"",0);
        String questionStr200 = " Aufstellungsfristen Die A-B-OHG besteht ausden Gesellschaftern Aund B.A erkrankte Ende01und fuhr imJahr 02zur Kur.B hat dieAufstellung desJahresabschlusses am15.12 .01 übernommen .Am 15.04 .02 sind dieBilanz und GuV -Rechnung fertiggestellt –alle handelsrechtlichen Vorschriftenwurdenbeachtet .Die Formatierung lässt aber noch zuwünschen übrig.Am 15.05 .02 liegt einmustergültiger Abschlussvor.Nach derRückkehr des A aus derKur unterzeichnen beideGesellschafter denAbschluss (15.07. 02). Wann wurde der Jahresabschluss 01aufgestellt?";
        RealmList<RealmString> answers200 = new RealmList<>();
        answers200.add(new RealmString("A) 15.12.01"));
        answers200.add(new RealmString("B) 15.04.02"));
        answers200.add(new RealmString("C) 15.05.02"));
        answers200.add(new RealmString("D) 15.07.02"));

        Question question200 = new Question(199,questionStr200,answers200,"3.1",1);
        String questionStr201 = "Die A -B-OHG besteht aus den Gesellschaftern A und B. A erkrankte Ende 01 und fuhr im Jahr 02 zur Kur. B  hat die Aufstellung des Jahresabschlusses am 15.12.01 übernommen. Am 15.04.02 sind die Bilanz und  GuV -Rechnung fertiggestellt – alle handelsrechtlichen Vorschriften wurden beachtet. Die Formatierung lässt  aber noch zu wünschen übrig. Am 15.05.02 liegt ein mustergültiger Abschluss vor. Nach der Rückkehr des  A aus der Kur unterzeichnen beide Gesellschafter den Abschluss (15.07.02). Ist der Jahresabschluss  rechtzeitig erstellt worden? Wenn nein um wieviel Monate wurde die Frist überschritten? aufgestellt wurde und somit kann die Frage nicht beantwortet werden. Monate möglich ist.";
        RealmList<RealmString> answers201 = new RealmList<>();
        answers201.add(new RealmString("A) Der Jahresabschluss wurde nicht rechtzeitig erstellt. Die Frist wurde um einen Monat überschritten."));
        answers201.add(new RealmString("B) Es ist unklar, ob der JA innerhalb der einem ordnungsmäßigen Geschäftsgang entsprechenden Zeit "));
        answers201.add(new RealmString("C) Die Frist wurde nicht überschritten, da für kleine Kapitalgesellschaften eine Verlängerung auf sechs "));
        answers201.add(new RealmString("D) Die Frist wurde nicht überschritten, da die Aufstellung innerhalb von sieben Monaten laut Rechtsprechung fristgemäß ist."));

        Question question201 = new Question(200,questionStr201,answers201,"3.1",3);
        String questionStr202 = "Welche Frist haben Einzelunternehmen grundsätzlich nach Auffassung des BFH bei der Aufstellung des  Jahresabschlusses einzuhalten?";
        RealmList<RealmString> answers202 = new RealmList<>();
        answers202.add(new RealmString("A) 1 Monat"));
        answers202.add(new RealmString("B) 3 Monate"));
        answers202.add(new RealmString("C) 5 Monate"));
        answers202.add(new RealmString("D) 12 Monate"));

        Question question202 = new Question(201,questionStr202,answers202,"3.1",3);
        String questionStr203 = "Welche Gesellschaft darf die Frist für die Aufstellung des Jahresabschlusses bis zu 6 Monate verlängern?";
        RealmList<RealmString> answers203 = new RealmList<>();
        answers203.add(new RealmString("A) Kleine Kapitalgesellschaften"));
        answers203.add(new RealmString("B) Mittlere Kapitalgesellschaften"));
        answers203.add(new RealmString("C) Mittelgroße Kapitalgesellschaften"));
        answers203.add(new RealmString("D) Große Kapitalgesellschaften"));

        Question question203 = new Question(202,questionStr203,answers203,"",0);
        String questionStr204 = "Die A -B-OHG besteht aus den Gesellschaftern A und B. A erkrankte Ende 01 und fuhr im Jahr 02 zur Kur. B  hat die Aufstellung des Jahresabschlusses am 15.12.01 übernommen. Am 15.04.02 sind die Bilanz und  GuV -Rechnung fertiggestellt – alle handelsrechtlichen Vorschriften wurden beachtet. Die Formatierung lässt  aber noch zu wünschen übrig. Am 15.05.02 liegt ein mustergültiger Abschluss vor. Nach der Rückkehr des  A aus der Kur unterzeichnen beide Gesellschafter den Abschluss (15.07.02) . Wann wurde der  Jahresabschluss rechtskräftig?";
        RealmList<RealmString> answers204 = new RealmList<>();
        answers204.add(new RealmString("A) 15.12.01"));
        answers204.add(new RealmString("B) 15.04.02"));
        answers204.add(new RealmString("C) 15.05.02"));
        answers204.add(new RealmString("D) 15.07.02"));

        Question question204 = new Question(203,questionStr204,answers204,"3.1",3);
        String questionStr205 = "Das Maßgeblichkeitsprinzip besagt …";
        RealmList<RealmString> answers205 = new RealmList<>();
        answers205.add(new RealmString("A) Der Konzernabschluss ist maßgeblich für die Steuerbilanz. "));
        answers205.add(new RealmString("B) Der Konzernabschluss ist maßgeblich für den Einzelabschluss."));
        answers205.add(new RealmString("C) Die Handelsbilanz ist maßgeblich für die Steuerbilanz."));
        answers205.add(new RealmString("D) Die Steuerbilanz ist maßgeblich für die Handelsbilanz."));

        Question question205 = new Question(204,questionStr205,answers205,"3.1",2);
        String questionStr206 = "Die Steuerbilanz ist relevant für …";
        RealmList<RealmString> answers206 = new RealmList<>();
        answers206.add(new RealmString("A) Anteilseigner"));
        answers206.add(new RealmString("B) Mitarbeiter"));
        answers206.add(new RealmString("C) Gläubiger"));
        answers206.add(new RealmString("D) Fiskus"));

        Question question206 = new Question(205,questionStr206,answers206,"",3);
        String questionStr207 = "DieA-B-OHG bilanziert imAnlagevermögen eineMaschine, derenWertEnde 01vorübergehend außerplanmäßig gesunkenist.Wird dasMaßgeblichkeitsprinzip eingehaltenundinwiefern? Wertminderung der Maschine nicht dauerhaft ist. Wertminderungen. Abschreibungsverbot.";
        RealmList<RealmString> answers207 = new RealmList<>();
        answers207.add(new RealmString("A) Ja. Sowohl in der Handelsbilanz als auch in der Steuerbilanz besteht ein Abschreibungsverbot, da die "));
        answers207.add(new RealmString("B) Ja. Sowohl in der Handelsbilanz als auch in der Steuerbilanz besteht ein Abschreibungsgebot bei "));
        answers207.add(new RealmString("C) Nein. In der Handelsbilanz besteht ein Abschreibungsgebot, in der Steuerbilanz hingegen ein "));
        answers207.add(new RealmString("D) Nein. In der Handelsbilanz besteht ein Abschreibungsverbot, in der Steuerbilanz hingegen ein "));

        Question question207 = new Question(206,questionStr207,answers207,"3.1",0);
        String questionStr208 = "In 01 wurden kurzfristige Wertpapiere für10.000 €erworben .Am Bilanzstichtag istihr Wert vorübergehend auf 8.600 €gesunken .Wird dasMaßgeblichkeitsprinzip eingehalten ? 8.600€. einer voraussichtlich nicht dauernden Wertminderung keine Abschreibung vorgenommen werden";
        RealmList<RealmString> answers208 = new RealmList<>();
        answers208.add(new RealmString("A) Ja. Sowohl in der Handelsbilanz als auch in der Steuerbilanz besteht ein Abschreibungsgebot auf "));
        answers208.add(new RealmString("B) Ja. Sowohl in der Handelsbilanz als auch in der Steuerbilanz besteht ein Abschreibungsverbot."));
        answers208.add(new RealmString("C) Nein. In der Handelsbilanz gilt ein Abschreibungsgebot auf 8.600 €;In der Steuerbilanz darf im Fall "));
        answers208.add(new RealmString("D) Nein. In der Handelsbilanz gilt ein Abschreibungsverbot auf;In der Steuerbilanz muss eine Abschreibung vorgenommen werden."));

        Question question208 = new Question(207,questionStr208,answers208,"3.1",2);

        //3.2

        String questionStr209 = "Wie kann dem Grundsatz der Nachprüfbarkeit der Inventur Rechnung getragen werden? aufnehmenden Personen sowie dem Datum.";
        RealmList<RealmString> answers209 = new RealmList<>();
        answers209.add(new RealmString("A) Aufbewahrung der Inventurlisten und dergleichen mit dem Namen und der Unterschrift der "));
        answers209.add(new RealmString("B) Das Ergebnis der Inventur, also das Inventar ist für die Nachprüfbarkeit ausreichend."));
        answers209.add(new RealmString("C) Eine Übertragung der Inventurergebnisse in die Bilanz ist ausreichend."));
        answers209.add(new RealmString("D) Die Inventur muss nicht nachprüfbar sein."));

        Question question209 = new Question(208,questionStr209,answers209,"3.2",0);
        String questionStr210 = "Welche Folgen ergeben sich für eine Unternehmung, wenn ihre Inventurunterlagen zum 31.12.01 am 15.05.05 durch Brand (höhere Gewalt) vernichtet wurden? ordnungsgemäß durchgeführt worden ist. Die anschließende Dokumentation ist irrelevant. ordnungsgemäß durchgeführt worden ist und im Fall von höherer Gewalt eine fehlerhafte  Dokumentation vertretbar ist.  Aufbewahrungsfrist nach §257 Abs. 1 und 4, 5 HGB vernichtet wurden. Der Mangel betrifft nur das Jahr  2005 , weil die Endbestände 2005 nicht nachweisbar sind.";
        RealmList<RealmString> answers210 = new RealmList<>();
        answers210.add(new RealmString("A) Die Ordnungsmäßigkeit der Buchführung ist zu bejahen, da im entscheidenden Jahr die Inventur ordnungsgemäß durchgeführt worden ist. Die anschließende Dokumentation ist irrelevant."));
        answers210.add(new RealmString("B) Die Ordnungsmäßigkeit der Buchführung ist zu bejahen, da im entscheidenden Jahr die Inventur ordnungsgemäß durchgeführt worden ist und im Fall von höherer Gewalt eine fehlerhafte Dokumentation vertretbar ist."));
        answers210.add(new RealmString("C) Die Ordnungsmäßigkeit der Buchführung ist zu verneinen, da die Unterlagen vor Ablauf der Aufbewahrungsfrist nach §257 Abs. 1 und 4, 5 HGB vernichtet wurden. Der Mangel betrifft nur das Jahr 2005, weil die Endbestände 2005 nicht nachweisbar sind. "));
        answers210.add(new RealmString("D) Die Ordnungsmäßigkeit der Buchführung ist zu verneinen, da die Unterlagen vor Ablauf der Aufbewahrungsfrist nach §257 Abs. 1 und 4, 5 HGB vernichtet wurden. Der Mangel betrifft die Jahre  2005 und 2006, weil sowohl die Endbestände 2005 als auch die Anfangsbestände 2006 nicht  nachweisbar sind."));

        Question question210 = new Question(209,questionStr210,answers210,"3.2",3);
        String questionStr211 = " Welcher Grundsatz ist nicht den Rahmengrundsätzen der GoB zuzuordnen?";
        RealmList<RealmString> answers211 = new RealmList<>();
        answers211.add(new RealmString("A) Vollständigkeit"));
        answers211.add(new RealmString("B) Vorsicht"));
        answers211.add(new RealmString("C) Richtigkeit und Willkürfreiheit"));
        answers211.add(new RealmString("D) Klarheit und Übersichtlichkeit"));

        Question question211 = new Question(210,questionStr211,answers211,"",1);
        String questionStr212 = "Welcher Grundsatz istnicht den Abgrenzungsgrundsätzen derGoB zuzuordnen?";
        RealmList<RealmString> answers212 = new RealmList<>();
        answers212.add(new RealmString("A) Imparitätsprinzip"));
        answers212.add(new RealmString("B) Realisationsprinzip"));
        answers212.add(new RealmString("C) Prinzip der Periodenabgrenzung "));
        answers212.add(new RealmString("D) Einzelbewertung"));

        Question question212 = new Question(211,questionStr212,answers212,"",3);
        String questionStr213 = "Welcher Grundsatz ist nicht den ergänzenden Grundsätzender GoB zuzuordnen?";
        RealmList<RealmString> answers213 = new RealmList<>();
        answers213.add(new RealmString("A) Stetigkeit"));
        answers213.add(new RealmString("B) Vorsicht"));
        answers213.add(new RealmString("C) Imparitätsprinzip"));
        answers213.add(new RealmString("D) Fortführungsgrundsatz"));

        Question question213 = new Question(212,questionStr213,answers213,"",2);
        String questionStr214 = "Welchem Grundsatz istder folgende Ausschnitt ausdem HGB zuzuordnen? „DieBuchführung mußso beschaffen sein,dasssieeinem sachverständigen Dritteninnerhalb angemessener Zeiteinen Überblick über dieGeschäftsvorfälle undüber dieLage desUnternehmens vermittelnkann.“";
        RealmList<RealmString> answers214 = new RealmList<>();
        answers214.add(new RealmString("A) Vollständigkeit"));
        answers214.add(new RealmString("B) Vorsicht"));
        answers214.add(new RealmString("C) Richtigkeit und Willkürfreiheit"));
        answers214.add(new RealmString("D) Klarheit und Übersichtlichkeit"));

        Question question214 = new Question(213,questionStr214,answers214,"",3);
        String questionStr215 = "Welchem Grundsatz ist der folgende Ausschnitt aus dem HGB zuzuordnen? „Aufwendungen und Erträge des Geschäftsjahrs sind unabhängig von den Zeitpunkten der entsprechenden Zahlungen im Jahresabschluß zu berücksichtigen .“";
        RealmList<RealmString> answers215 = new RealmList<>();
        answers215.add(new RealmString("A) Imparitätsprinzip"));
        answers215.add(new RealmString("B) Realisationsprinzip"));
        answers215.add(new RealmString("C) Prinzip der Periodenabgrenzung "));
        answers215.add(new RealmString("D) Einzelbewertung"));

        Question question215 = new Question(214,questionStr215,answers215,"",2);
        String questionStr216 = "Welchem Grundsatz ist der folgende Ausschnitt aus dem HGB zuzuordnen? „Die aufden vorhergehenden Jahresabschluss angewandten Bewertungsmethoden sind beizubehalten .“";
        RealmList<RealmString> answers216 = new RealmList<>();
        answers216.add(new RealmString("A) Stetigkeit"));
        answers216.add(new RealmString("B) Vorsicht"));
        answers216.add(new RealmString("C) Einzelbewertungsgrundsatz"));
        answers216.add(new RealmString("D) Fortführungsgrundsatz"));

        Question question216 = new Question(215,questionStr216,answers216,"",0);
        String questionStr217 = "Welchem Grundsatz ist der folgende Ausschnitt aus dem HGB zuzuordnen? „DieVermögensgegenstände und Schulden sind zum Abschlußstichtag einzeln zu bewerten. “";
        RealmList<RealmString> answers217 = new RealmList<>();
        answers217.add(new RealmString("A) Stetigkeit"));
        answers217.add(new RealmString("B) Vorsicht"));
        answers217.add(new RealmString("C) Einzelbewertungsgrundsatz"));
        answers217.add(new RealmString("D) Fortführungsgrundsatz"));

        Question question217 = new Question(216,questionStr217,answers217,"",2);

        //3.3

        String questionStr218 = "Markieren Sie die korrekte Aussage!";
        RealmList<RealmString> answers218 = new RealmList<>();
        answers218.add(new RealmString("A) Die Werte aus der Buchführung gehen jenen aus der Inventur vor."));
        answers218.add(new RealmString("B) Die Werte aus der Inventur gehen jenen aus der Buchführung vor."));
        answers218.add(new RealmString("C) Die Eröffnungsbilanz aus 01 ist identisch mit der Schlussbilanz aus 01."));
        answers218.add(new RealmString("D) Gesetzliche Pflicht ist lediglich die Erstellung einer Schlussbilanz."));

        Question question218 = new Question(217,questionStr218,answers218,"3.3",1);
        String questionStr219 = "Markieren Sie die falsche Aussage!";
        RealmList<RealmString> answers219 = new RealmList<>();
        answers219.add(new RealmString("A) Ergebnis der Inventur ist das Inventar."));
        answers219.add(new RealmString("B) Die Schlussbilanz aus 01 ist identisch mit der Eröffnungsbilanz aus 02."));
        answers219.add(new RealmString("C) Das Inventar listet Vermögen und Schulden auf."));
        answers219.add(new RealmString("D) Die Werte aus der Buchführung gehen jenen aus der Inventur vor."));

        Question question219 = new Question(218,questionStr219,answers219,"",3);
        String questionStr220 = "Welchen generellen Zweck erfüllt die Inventur?";
        RealmList<RealmString> answers220 = new RealmList<>();
        answers220.add(new RealmString("A) Erstellung des Inventars für die Bilanz."));
        answers220.add(new RealmString("B) Darstellung der zeitlichen Veränderung der Vermögenswerte."));
        answers220.add(new RealmString("C) Buchmäßige Erfassung deram Bilanzstichtag vorhandenen Vermögensgegenstände und Schulden."));
        answers220.add(new RealmString("D) Nachweis bzw. Wiederherstellung der Übereinstimmung zwischen den Werten der Buchhaltung und den tatsächlich vorhandenen Vermögensgegenständen und Schulden"));

        Question question220 = new Question(219,questionStr220,answers220,"3.3",3);
        String questionStr221 = "Was hat zu geschehen, wenn am Jahresende bei der Inventur des Kassenbestandes der Soll -Bestand laut  Buchführung von €1.750,20 nicht mit dem Ist -Bestand laut Inventur von €1.700,20 übereinstimmt?";
        RealmList<RealmString> answers221 = new RealmList<>();
        answers221.add(new RealmString("A) Die Buchführung ist nicht ordentlich, weshalb das Unternehmen schließen muss. "));
        answers221.add(new RealmString("B) Die Differenz von €50, -ist über ein Kassenbestands -Differenzkonto als Aufwand zu buchen."));
        answers221.add(new RealmString("C) Die Differenz von €50, -ist über ein Kassenbestands -Differenzkonto als Ertrag zu buchen."));
        answers221.add(new RealmString("D) Die Buchführung muss in die Vergangenheit nachvollzogen werden bis der Fehler ersichtlich ist."));

        Question question221 = new Question(220,questionStr221,answers221,"",1);
        String questionStr222 = "Müssen alle nach dem Handelsrecht zur Buchführung verpflichteten Unternehmen auch eine Inventur  durchführen?";
        RealmList<RealmString> answers222 = new RealmList<>();
        answers222.add(new RealmString("A) Nein, wenn ordentlich Bücher geführt werden, ist eine Inventur nicht nötig. "));
        answers222.add(new RealmString("B) Nein, nur Gesellschaften sind dazu verpflichtet eine Inventur durchzuführen."));
        answers222.add(new RealmString("C) Ja, aber in besonderen Härtefällen ist eine Ausnahme möglich."));
        answers222.add(new RealmString("D) Ja, jedes Unternehmen ist dazu verpflichtet eine Inventur durchzuführen."));

        Question question222 = new Question(221,questionStr222,answers222,"3.3",3);
        String questionStr223 = "Kann auf eine körperliche Bestandsaufnahme des beweglichen Anlagevermögens verzichtet werden? wenn eine Anlagekartei mit detaillierten Angaben geführt wird.";
        RealmList<RealmString> answers223 = new RealmList<>();
        answers223.add(new RealmString("A) Nein. Eine körperliche Bestandsaufnahme muss in jedem Fall durchgeführt werden."));
        answers223.add(new RealmString("B) Grundsätzlich nein. Auf einekörperliche Bestandsaufnahme kann nur in Härtefällen verzichtet werden."));
        answers223.add(new RealmString("C) Ja, aber nur "));
        answers223.add(new RealmString("D) Ja, ein Verzicht auf die körperliche Bestandsaufnahme des Anlagevermögens ist immer möglich."));

        Question question223 = new Question(222,questionStr223,answers223,"",2);
        String questionStr224 = "BuchdruckermeisterOttoMüller nimmtseinegewerbliche Tätigkeitam01.04 .01 auf.Sein Eigenkapital beträgt zudiesem Zeitpunkt 200.000 €– Schulden existieren nicht.Zum 31.12.01 erstellt erden Jahresabschluss .Für 01betragen dieErträge 220.000 €und dieAufwendungen 130.000 €. Das Eigenkapital wurdenurdurch betriebliche Vorgängeverändert.An welchem derfolgenden Termineistes nicht zulässig dasGeschäftsjahr endenzulassen?";
        RealmList<RealmString> answers224 = new RealmList<>();
        answers224.add(new RealmString("A) 31.11.01"));
        answers224.add(new RealmString("B) 31.12.01"));
        answers224.add(new RealmString("C) 31.03.02"));
        answers224.add(new RealmString("D) 31.04.02"));

        Question question224 = new Question(223,questionStr224,answers224,"3.3",3);
        //TODO FRAGE IST SCHREKLICH FORMATIERT
        String questionStr225 = "Ein Hersteller von Holzregalen benötigt immer die gleichen Sorten Nägel. Im Geschäftsjahr wurden 2.000  kg der einzelnen Sorten gekauft und 1.500 kg davon verbraucht. Es wird die Durchschnittskostenmethode  angewandt. Wie hoch sind die Anschaffungskosten für die insgesamt eingekaufte Menge?";
        RealmList<RealmString> answers225 = new RealmList<>();
        answers225.add(new RealmString("A) 4.800 €"));
        answers225.add(new RealmString("B) 6.000 €"));
        answers225.add(new RealmString("C) 6.400 €"));
        answers225.add(new RealmString("D) 6.800 €"));

        Question question225 = new Question(224,questionStr225,answers225,"3.3",2);
        String questionStr226 = "Siehe Aufgabe oben.Die Anschaffungskosten je Mengeneinheit betragen";
        RealmList<RealmString> answers226 = new RealmList<>();
        answers226.add(new RealmString("A) 3,00 €"));
        answers226.add(new RealmString("B) 3,10 €"));
        answers226.add(new RealmString("C) 3,20 €"));
        answers226.add(new RealmString("D) 3,40 €"));

        Question question226 = new Question(225,questionStr226,answers226,"3.3",2);
        String questionStr227 = "Siehe Aufgabe oben. Der Endbestand in € beträgt …";
        RealmList<RealmString> answers227 = new RealmList<>();
        answers227.add(new RealmString("A) 1.500 €"));
        answers227.add(new RealmString("B) 1.550 €"));
        answers227.add(new RealmString("C) 1.600 €"));
        answers227.add(new RealmString("D) 1.700 €"));

        Question question227 = new Question(226,questionStr227,answers227,"",2);
        String questionStr228 = "Siehe Aufgabe oben. Der Verbrauch in €beträgt …";
        RealmList<RealmString> answers228 = new RealmList<>();
        answers228.add(new RealmString("A) 4.500 €"));
        answers228.add(new RealmString("B) 4.650 €"));
        answers228.add(new RealmString("C) 4.800 €"));
        answers228.add(new RealmString("D) 5.100 €"));

        Question question228 = new Question(227,questionStr228,answers228,"3.3",2);
        String questionStr229 = "Kann ein Unternehmen verschiedene Inventurmethoden nebeneinander anwenden? konsistent bleiben.";
        RealmList<RealmString> answers229 = new RealmList<>();
        answers229.add(new RealmString("A) Nein. Eine Unternehmen muss in der Anwendung der Inventurmethode über alle Gegenstände "));
        answers229.add(new RealmString("B) Nein. Ein Unternehmen darf grundsätzlich nur die Inventur am Stichtag anwenden. Nur in besonderen Fällen ist ein einmaliger Wechsel möglich."));
        answers229.add(new RealmString("C) Ja, aber nur in besonderen Fällen. "));
        answers229.add(new RealmString("D) Ja, ein Unternehmen ist in der Wahl der Inventurmethode frei."));

        Question question229 = new Question(228,questionStr229,answers229,"3.3",3);
        String questionStr230 = "Welche der folgenden Inventurmethoden erlaubt das höchste Maß an zeitlicher Flexibilität?";
        RealmList<RealmString> answers230 = new RealmList<>();
        answers230.add(new RealmString("A) Stichtagsinventur"));
        answers230.add(new RealmString("B) Ausgeweitete Stichtagsinventur"));
        answers230.add(new RealmString("C) Permanente Inventur"));
        answers230.add(new RealmString("D) Zeitlich verlegte Inventur"));

        Question question230 = new Question(229,questionStr230,answers230,"",2);
        String questionStr231 = "Welche Voraussetzung für die permanente Inventur muss nicht erfüllt sein? Markieren Sie die korrekte  Antwort!";
        RealmList<RealmString> answers231 = new RealmList<>();
        answers231.add(new RealmString("A) Lagerbuchführung"));
        answers231.add(new RealmString("B) Mindestens eine körperliche Bestandsaufnahme während des Geschäftsjahres mit Protokoll"));
        answers231.add(new RealmString("C) Keine Lagerhaltung mit unkontrollierten Abgänge und besonders wertvollen Wirtschaftsgütern"));
        answers231.add(new RealmString("D) Alle oben genannten Voraussetzungen müssen erfüllt sein"));

        Question question231 = new Question(230,questionStr231,answers231,"3.3",3);

        realm.beginTransaction();
        realm.copyToRealm(question183);
        realm.copyToRealm(question184);
        realm.copyToRealm(question185);
        realm.copyToRealm(question186);
        realm.copyToRealm(question187);
        realm.copyToRealm(question188);
        realm.copyToRealm(question189);
        realm.copyToRealm(question190);
        realm.copyToRealm(question191);
        realm.copyToRealm(question192);
        realm.copyToRealm(question193);
        realm.copyToRealm(question194);
        realm.copyToRealm(question195);
        realm.copyToRealm(question196);
        realm.copyToRealm(question197);
        realm.copyToRealm(question198);
        realm.copyToRealm(question199);
        realm.copyToRealm(question200);
        realm.copyToRealm(question201);
        realm.copyToRealm(question202);
        realm.copyToRealm(question203);
        realm.copyToRealm(question204);
        realm.copyToRealm(question205);
        realm.copyToRealm(question206);
        realm.copyToRealm(question207);
        realm.copyToRealm(question208);
        realm.copyToRealm(question209);
        realm.copyToRealm(question210);
        realm.copyToRealm(question211);
        realm.copyToRealm(question212);
        realm.copyToRealm(question213);
        realm.copyToRealm(question214);
        realm.copyToRealm(question215);
        realm.copyToRealm(question216);
        realm.copyToRealm(question217);
        realm.copyToRealm(question218);
        realm.copyToRealm(question219);
        realm.copyToRealm(question220);
        realm.copyToRealm(question221);
        realm.copyToRealm(question222);
        realm.copyToRealm(question223);
        realm.copyToRealm(question224);
        realm.copyToRealm(question225);
        realm.copyToRealm(question226);
        realm.copyToRealm(question227);
        realm.copyToRealm(question228);
        realm.copyToRealm(question229);
        realm.copyToRealm(question230);
        realm.copyToRealm(question231);
        realm.commitTransaction();
    }

    //JA2 TODO ANTWORTEN 4.6
    private void initQuestions4() {
        String questionStr232 = "Nach welchen Prinzipienist die Bilanz des §266 HBG nichtaufgebaut bzw. gegliedert?";
        RealmList<RealmString> answers232 = new RealmList<>();
        answers232.add(new RealmString("A) Höhe des Geldbetrages"));
        answers232.add(new RealmString("B) Bruttoprinzip"));
        answers232.add(new RealmString("C) Liquiditätsprinzip/Fristigkeitsprinzip"));
        answers232.add(new RealmString("D) Kontoform"));

        Question question232 = new Question(231,questionStr232,answers232,"",0);
        String questionStr233 = "Markieren Sie die falsche Antwort!";
        RealmList<RealmString> answers233 = new RealmList<>();
        answers233.add(new RealmString("A)Wenn die Klarheit und Übersichtlichkeit es fordern, darf eine Kapitalgesellschaft vomgesetzlich "));
        answers233.add(new RealmString("B) Kurzfristige Verbindlichkeitenund kurzfristige Forderungen dürfen saldiert werden."));
        answers233.add(new RealmString("C)Leerpostenkönnen vernachlässigt werden."));
        answers233.add(new RealmString("D) Bei unerheblichen Beträgen kann eine Zusammenfassung erfolgen."));

        Question question233 = new Question(232,questionStr233,answers233,"",1);

        //4.2

        String questionStr234 = "Software-Unternehmer Hans Computnix ist Kaufmann im Sinne des HGB und zur Aufstellung eines Jahresabschlusses verpflichtet.Bei welchem der folgenden Sachverhalte liegt kein Vermögensgegenstand vor?";
        RealmList<RealmString> answers234 = new RealmList<>();
        answers234.add(new RealmString("A)Einen gebrauchten Transporter zum Vertrieb von Software: 40.000 €"));
        answers234.add(new RealmString("B) Ein neues EDV-Programm, welches im Unternehmen langfristig eingesetzt werden soll: 50.000 €"));
        answers234.add(new RealmString("C)Durchführung einer großen Werbekampagne für 500.000 €, um den Bekanntheitsgrad des "));
        answers234.add(new RealmString("D)Einem Patentzur Erhöhung des Wirkungsgrades des Leistungserstellungsprozesses in Höhe von 2.000.000 €"));

        Question question234 = new Question(233,questionStr234,answers234,"3.2",2);
        String questionStr235 = "Wird in 01 die Kfz-Versicherung für ein Jahr im Vorausgezahlt,muss am Jahresende ein(e) ______ in der Bilanz angesetzt werden.Welcher Begriff gehört in die Lücke?";
        RealmList<RealmString> answers235 = new RealmList<>();
        answers235.add(new RealmString("A)Vermögensgegenstand"));
        answers235.add(new RealmString("B) aktiver Rechnungsabgrenzungsposten"));
        answers235.add(new RealmString("C)Verbindlichkeit"));
        answers235.add(new RealmString("D)Rückstellung"));

        Question question235 = new Question(234,questionStr235,answers235,"3.2",1);
        String questionStr236 = "Istin 01 eine Verpflichtung entstanden, deren Höhe nicht genau zu bestimmen ist, muss ein(e) ______ passiviert werden. Welcher Begriff gehört in die Lücke?";
        RealmList<RealmString> answers236 = new RealmList<>();
        answers236.add(new RealmString("A)Vermögensgegenstand"));
        answers236.add(new RealmString("B) aktiver Rechnungsabgrenzungsposten"));
        answers236.add(new RealmString("C)Verbindlichkeit"));
        answers236.add(new RealmString("D)Rückstellung"));

        Question question236 = new Question(235,questionStr236,answers236,"",3);

        String questionStr237 = "Wird in 01 ein Darlehen aufgenommen,welches nach fünf Jahren in voller Höhe zurückzuzahlen ist,wird ein(e) ______ ausgewiesen.Welcher Begriff gehört in die Lücke?";
        RealmList<RealmString> answers237 = new RealmList<>();
        answers237.add(new RealmString("A)Vermögensgegenstand"));
        answers237.add(new RealmString("B) aktiver Rechnungsabgrenzungsposten"));
        answers237.add(new RealmString("C)Verbindlichkeit"));
        answers237.add(new RealmString("D)Rückstellung"));

        Question question237 = new Question(236,questionStr237,answers237,"3.2",2);
        String questionStr238 = "Wird eine Standardmaschine gekauft, handelt es sich um eine(n) zu aktivierende(n) ______ . Welcher Begriff gehört in die Lücke?";
        RealmList<RealmString> answers238 = new RealmList<>();
        answers238.add(new RealmString("A)Vermögensgegenstand"));
        answers238.add(new RealmString("B) aktiver Rechnungsabgrenzungsposten"));
        answers238.add(new RealmString("C)Verbindlichkeit"));
        answers238.add(new RealmString("D)Rückstellung"));

        Question question238 = new Question(237,questionStr238,answers238,"",0);
        String questionStr239 = "Zu den passivierungspflichtigen ______ gehören im Handelsrecht  Rückstellungen und Verbindlichkeiten. Welcher Begriff gehört in die Lücke?";
        RealmList<RealmString> answers239 = new RealmList<>();
        answers239.add(new RealmString("A)Vermögensgegenständen"));
        answers239.add(new RealmString("B) Schulden"));
        answers239.add(new RealmString("C)Verbindlichkeiten"));
        answers239.add(new RealmString("D)Rückstellungen"));

        Question question239 = new Question(238,questionStr239,answers239,"3.2",1);

        String questionStr240 = "Die Verlags-OHG vermarktet die Werke verschiedener Autoren.In 01 werden diverse Drucktitel erworben bzw.selbst erstellt.In den folgenden Fällen sind jeweils Kosten in Höhe von 200.000€ netto angefallen.Bei welchem der folgenden Fälle besteht Ansatzverbot?";
        RealmList<RealmString> answers240 = new RealmList<>();
        answers240.add(new RealmString("A) Selbst geschaffener Drucktitel, der längerfristig genutzt werden soll."));
        answers240.add(new RealmString("B) Entgeltlich erworbener Drucktitel, der in 02 an einen anderen Verlag veräußert werden soll."));
        answers240.add(new RealmString("C)Entgeltlich erworbener Drucktitel, der längerfristig genutzt werden soll."));
        answers240.add(new RealmString("D) Selbst geschaffener Drucktitel, der in 02 an einen anderen Verlag veräußert werden soll."));

        Question question240 = new Question(239,questionStr240,answers240,"3.2",0);
        String questionStr241 = "Für welchen der folgenden Posten besteht im Jahresabschluss der Kapitalgesellschaft ein Ansatzverbot?";
        RealmList<RealmString> answers241 = new RealmList<>();
        answers241.add(new RealmString("A) Betriebs-und Geschäftsausstattung"));
        answers241.add(new RealmString("B) Geringwertige Wirtschaftsgüter (GWG) (selbständig nutzungsfähige Vermögens-gegenständemit "));
        answers241.add(new RealmString("C) Entgeltlich erworbene immaterielle Vermögensgegenstände des Anlagevermögens"));
        answers241.add(new RealmString("D) Aufwendungen für die Erweiterung des Geschäftsbetriebes"));

        Question question241 = new Question(240,questionStr241,answers241,"3.2",3);
        String questionStr242 = "Für welchen der folgenden Posten besteht im Jahresabschluss der Kapitalgesellschaft ein Ansatzverbot?";
        RealmList<RealmString> answers242 = new RealmList<>();
        answers242.add(new RealmString("A) Aufwendungen für die Gründung des Unternehmens "));
        answers242.add(new RealmString("B) Wertpapiere des Anlagevermögens (AV)"));
        answers242.add(new RealmString("C) entgeltlich erworbener Geschäftswert einer Industrieunternehmung"));
        answers242.add(new RealmString("D) Produktionsmaschine"));

        Question question242 = new Question(241,questionStr242,answers242,"",0);

        String questionStr243 = "Für welchen der folgenden Posten besteht im Jahresabschluss der Kapitalgesellschaft ein Ansatzwahlrecht?";
        RealmList<RealmString> answers243 = new RealmList<>();
        answers243.add(new RealmString("A)entgeltlich erworbene immaterielle Vermögensgegenstände des Umlaufvermögens (zum Verkauf bestimmtes EDV-Programm eines Softwarehauses)"));
        answers243.add(new RealmString("B)Im Geschäftsjahr erworbene eigene Anteile"));
        answers243.add(new RealmString("C)Disagio"));
        answers243.add(new RealmString("D) Rückstellungen für ungewisse Verbindlichkeiten"));

        Question question243 = new Question(242,questionStr243,answers243,"3.2",2);
        String questionStr244 = "Für welchen der folgenden Posten besteht im Jahresabschluss der Kapitalgesellschaft ein Ansatzwahlrecht?";
        RealmList<RealmString> answers244 = new RealmList<>();
        answers244.add(new RealmString("A)Fremdwährungsverbindlichkeiten"));
        answers244.add(new RealmString("B)Aktive latente Steuern"));
        answers244.add(new RealmString("C)Passive latente Steuern"));
        answers244.add(new RealmString("D) Pensionsrückstellungen:Neuzusage ab 1.1.1987 "));

        Question question244 = new Question(243,questionStr244,answers244,"",1);
        String questionStr245 = "Unternehmer Schlau beginnt am 20.03.01 mit der Entwicklung einer Batterie zum Antrieb von Elektrofahrzeugen. Die Entwicklung ist am 15.10.01 abgeschlossen (monatliche Herstellungskosten: 300.000€).Die Serienfertigung wird von Schlau selbst übernommen, der das Know-how aber auch jederzeit veräußern könnte.Das Wissen ist zehn Jahre lang nutzbar(gleichmäßige Entwertung).Wie werden die Entwicklungskosten in 01 bei einem hohen Vermögensausweis behandelt? Gehen Sie vereinfachend davon aus,dass alle Monate gleich lang sind und 30 Tage umfassen.";
        RealmList<RealmString> answers245 = new RealmList<>();
        answers245.add(new RealmString("A)1.620.000 €"));
        answers245.add(new RealmString("B)1.800.000 €"));
        answers245.add(new RealmString("C) 1.998.750 €"));
        answers245.add(new RealmString("D) 2.050.000 €"));

        Question question245 = new Question(244,questionStr245,answers245,"3.2",2);
        String questionStr246 = "Unternehmer Pfiffig führt verschiedene Forschungs-und Entwicklungsarbeiten durch.Um die Belastung auf den Straßen zu reduzieren,will Pfiffig ein Schwimmsystem für LKWs erfinden, damit die Fahrzeuge auch Flüsse nutzen können. Ab dem 01.05.01 erforschter, wie sich LKWs überhaupt im Wasser fortbewegen können. Parallel dazu setzt eine Entwicklungsgruppe die Ergebnisse beim Bau eines Lkw-Prototyps um. Monatlich entstehen Aufwendungen von insgesamt 200.000€. Welches ist das korrekte Vorgehen?";
        RealmList<RealmString> answers246 = new RealmList<>();
        answers246.add(new RealmString("A) Aktivierung von 1.600.00 €als Entwicklungskosten am 31.12.01"));
        answers246.add(new RealmString("B)Aktivierung von 50% der Kosten, also 800.000 €, als Entwicklungskosten am 31.12.01"));
        answers246.add(new RealmString("C) Aktivierung von 20% der Kosten, also 32.000 €, als Entwicklungskosten am 31.12.01"));
        answers246.add(new RealmString("D) Keine Aktivierung der Kosten"));

        Question question246 = new Question(245,questionStr246,answers246,"3.2",3);
        String questionStr247 = "Unternehmer Schulze erfindet einen neuen Biokraftstoff:Beginn der Entwicklung am 01.10.01,Abschluss am 31.10.03. Monatlich fallen Herstellungskosten von 100.000€ an. In folge technischer Probleme ist Ende 01 noch sehr unsicher, ob die Entwicklung erfolgreich abgeschlossen werden kann. Erst Ende 02 ist davon auszugehen, dass das Projekt mit Erfolg beendet werden wird.Wie wird Ende 01 bilanziert?";
        RealmList<RealmString> answers247 = new RealmList<>();
        answers247.add(new RealmString("A)Es werden 300.000 €alsEntwicklungskosten aktiviert"));
        answers247.add(new RealmString("B)Es werden 200.000 €alsEntwicklungskosten aktiviert"));
        answers247.add(new RealmString("C)Es werden 100.000 €alsEntwicklungskosten aktiviert"));
        answers247.add(new RealmString("D) Es werden keine Entwicklungskostenaktiviert"));

        Question question247 = new Question(246,questionStr247,answers247,"3.2",3);
        String questionStr248 = "Angabe wie oben. Wie wird Ende 02 bilanziert?";
        RealmList<RealmString> answers248 = new RealmList<>();
        answers248.add(new RealmString("A)Es werden 1.500.000 €alsEntwicklungskosten aktiviert"));
        answers248.add(new RealmString("B)Es werden 1.200.000 €alsEntwicklungskosten aktiviert"));
        answers248.add(new RealmString("C)Es werden 1.000.000 €alsEntwicklungskosten aktiviert"));
        answers248.add(new RealmString("D) Es werden keine Entwicklungskostenaktiviert"));

        Question question248 = new Question(247,questionStr248,answers248,"",1);
        String questionStr249 = "Unternehmer Schulze nimmt Anfang 01 einen Kredit von 400.000€ auf, der nach vier Jahren zum vollen Betrag zurückzuzahlen ist.Die Auszahlung erfolgt zu 98%, sodass ein Disagio entsteht.Wie ist das Disagio Anfang 01 zu behandeln, wenn ein periodengerechter Erfolgsausweis angestrebt wird?";
        RealmList<RealmString> answers249 = new RealmList<>();
        answers249.add(new RealmString("A)Aktivierung von 394.000 €als Disagio"));
        answers249.add(new RealmString("B)Aktivierung von 8.000€als Disagio"));
        answers249.add(new RealmString("C)Aktivierungvon 4.000 €als Disagio"));
        answers249.add(new RealmString("D) Keine Aktivierung des Disagios"));

        Question question249 = new Question(248,questionStr249,answers249,"3.2",1);
        String questionStr250 = "Angabe wie oben. Wie wird das Disagio in 01 und 02 aufgelöst?";
        RealmList<RealmString> answers250 = new RealmList<>();
        answers250.add(new RealmString("A)Es werden 4.000€jeweils in 01 und 02 aufgelöst"));
        answers250.add(new RealmString("B)Es werden 2.000€jeweils in 01 und 02 aufgelöst"));
        answers250.add(new RealmString("C) Es werden 1.000€jeweils in 01 und 02 aufgelöst"));
        answers250.add(new RealmString("D) Es werden 0€jeweils in 01 und 02 aufgelöst"));

        Question question250 = new Question(249,questionStr250,answers250,"",1);

        String questionStr251 = "Welche Zweck hat die Bildung von aktiven und passiven Posten der Rechnungsabgrenzung?";
        RealmList<RealmString> answers251 = new RealmList<>();
        answers251.add(new RealmString("A) Die Posten der Rechnungsabgrenzung dienen der periodengerechten Anlagevermögenermittlung. "));
        answers251.add(new RealmString("B) Die Posten der Rechnungsabgrenzung dienen der periodengerechten Eigenkapitalermittlung. "));
        answers251.add(new RealmString("C) Die Posten der Rechnungsabgrenzung dienen der periodengerechten Vermögensermittlung. "));
        answers251.add(new RealmString("D) Die Posten der Rechnungsabgrenzung dienen der periodengerechten Erfolgsermittlung. "));

        Question question251 = new Question(250,questionStr251,answers251,"3.2",3);
        String questionStr252 = "Welcher bilanzmäßige Charakter kommt den Posten der Rechnungsabgrenzung zu?";
        RealmList<RealmString> answers252 = new RealmList<>();
        answers252.add(new RealmString("A)Vermögen"));
        answers252.add(new RealmString("B) Kapital"));
        answers252.add(new RealmString("C)Verrechnungsposten"));
        answers252.add(new RealmString("D) Saldierung"));

        Question question252 = new Question(251,questionStr252,answers252,"",2);
        String questionStr253 = "Welcher Unterschied besteht zwischen einer Abgrenzung über Posten der Rechnungsabgrenzung und über  sonstige Forderungen bzw. Verbindlichkeiten?";
        RealmList<RealmString> answers253 = new RealmList<>();
        answers253.add(new RealmString("A) Bei den Posten der Rechnungsabgrenzung erfolgten Zahlungsvorgänge im vergangenen Geschäftsjahr, während diese bei sonstigen Forderungen bzw. Verbindlichkeiten im laufenden Geschäftsjahr oder auch später auftreten."));
        answers253.add(new RealmString("B) Bei den Posten der Rechnungsabgrenzung erfolgten Zahlungsvorgänge im laufenden Geschäftsjahr, bweäi hsorennsdtigdeinesFeorbdeirsuongnesntigbezwn.FVoerrdbeinrudlnicghekneibteznwi.mVeforlbgiennddliecnhGkeistecnhäifmtsjfaohlrgoednedreanuch Gspeästcehräafutsftjraehterno.der auch später auftreten."));
        answers253.add(new RealmString("C) Bei den sonstigen Forderungen bzw. Verbindlichkeiten erfolgten Erwerbsvorgänge im laufenden Geschäftsjahr, während diese bei Posten der Rechnungsabgrenzung im folgenden Geschäftsjahr oder auch später auftreten."));
        answers253.add(new RealmString("D) Keineder oben genannten Antworten ist richtig."));

        Question question253 = new Question(252,questionStr253,answers253,"3.2",1);
        String questionStr254 = "Welche der folgenden Aussagen über Rechnungsabgrenzungsposten (RAP) ist richtig?";
        RealmList<RealmString> answers254 = new RealmList<>();
        answers254.add(new RealmString("A) Antizipative aktive RAP sind durch das Merkmal „Erst Aufwand, dann Auszahlung“ gekennzeichnet."));
        answers254.add(new RealmString("B) Antizipative passive RAP sind durch das Merkmal „Erst Einnahme, dann Ertrag“ gekennzeichnet."));
        answers254.add(new RealmString("C) Transitorische passive RAP sind durch das Merkmal „Erst Ertrag, dann Einnahme“ gekennzeichnet."));
        answers254.add(new RealmString("D) Transitorische aktive RAP sind durch das Merkmal „Erst Ausgabe, dann Aufwand“ gekennzeichnet."));

        Question question254 = new Question(253,questionStr254,answers254,"3.2",3);
        String questionStr255 = "Welche der folgenden Aussagen über Rechnungsabgrenzungsposten (RAP) ist richtig?";
        RealmList<RealmString> answers255 = new RealmList<>();
        answers255.add(new RealmString("A) Wird im Dezember 01 die Miete für die private Wohnung für Januar 02 vom betrieblichen Bankkonto im Voraus gezahlt (1.500 €), wird ein aktiver RAP von 1.500 € gebildet."));
        answers255.add(new RealmString("B) Wird im Dezember 01 die Miete für die private Wohnung für Januar 02 vom privaten Bankkonto im Voraus gezahlt (1.500 €), wird ein aktiver RAP von 1.500 € gebildet."));
        answers255.add(new RealmString("C) Wird im Dezember 01 die Miete für die Büroräume für Januar 02 vom privaten Bankkonto im Voraus gezahlt (1.500 €), wird nach Buchung der Einlage ein aktiver RAP von 1.500 € gebildet."));
        answers255.add(new RealmString("D) Wird im Dezember 01 die Miete für die Büroräume für Januar 02 vom privaten Bankkonto im Voraus gezahlt (1.500 €), wird nach Buchung der Einlage ein passiver RAP von 1.500 € gebildet."));

        Question question255 = new Question(254,questionStr255,answers255,"",2);
        String questionStr256 = "Das Unternehmen zahlt für das 1. Quartal des Jahres 02 €1.500 Miete für Geschäftsräume. Bestimmen Sie  den bilanziellen Ausweis dieses Geschäftsvorfalls zum 31.12.01.";
        RealmList<RealmString> answers256 = new RealmList<>();
        answers256.add(new RealmString("A) Mieteinnahme im Jahr 02 für Jahr 01: sonstiger Vermögensgegenstand"));
        answers256.add(new RealmString("B) Mieteinnahme im Jahr 02 für Jahr 01: sonstige Verbindlichkeit"));
        answers256.add(new RealmString("C) Mietvorauszahlung im Jahr 01 für Jahr 02: passiver RAP"));
        answers256.add(new RealmString("D) Mietvorauszahlung im Jahr 01 für Jahr 02: aktiver RAP"));

        Question question256 = new Question(255,questionStr256,answers256,"3.2",3);
        String questionStr257 = "Im Jahr 02 sind Mieteinnahmen in Höhe von €2.300 zu erwarten, die das Jahr 01 betreffen. Bestimmen Sie  den bilanziellen Ausweis diesen Geschäftsvorfalls zum 31.12.01.";
        RealmList<RealmString> answers257 = new RealmList<>();
        answers257.add(new RealmString("A) Mieteinnahme im Jahr 02 für Jahr 01: sonstiger Vermögensgegenstand"));
        answers257.add(new RealmString("B) Mieteinnahme im Jahr 02 für Jahr 01: sonstige Verbindlichkeit"));
        answers257.add(new RealmString("C) Mietvorauszahlung im Jahr 01 für Jahr 02: passiver RAP"));
        answers257.add(new RealmString("D) Mietvorauszahlung im Jahr 01 für Jahr 02: aktiver RAP"));

        Question question257 = new Question(256,questionStr257,answers257,"",0);
        String questionStr258 = "Am 2. Dezember 01 zahlt das Unternehmen für die erste Hälfte des Jahres 02 die Hypotheken-Zinsen im  Voraus. Bestimmen Sie den bilanziellen Ausweis diesen Geschäftsvorfallszum 31.12.01.";
        RealmList<RealmString> answers258 = new RealmList<>();
        answers258.add(new RealmString("A) sonstiger Vermögensgegenstand"));
        answers258.add(new RealmString("B) sonstige Verbindlichkeit"));
        answers258.add(new RealmString("C) passiver RAP"));
        answers258.add(new RealmString("D) aktiver RAP"));

        Question question258 = new Question(257,questionStr258,answers258,"3.2",3);
        String questionStr259 = "Wir erhalten am 1. Dezember 01 für eine vermietete Garage €50, die den Januar 02 betreffen.Bestimmen  Sie den bilanziellen Ausweis diesen Geschäftsvorfallszum 31.12.01";
        RealmList<RealmString> answers259 = new RealmList<>();
        answers259.add(new RealmString("A) sonstiger Vermögensgegenstand"));
        answers259.add(new RealmString("B) sonstige Verbindlichkeit"));
        answers259.add(new RealmString("C) passiver RAP"));
        answers259.add(new RealmString("D) aktiver RAP"));

        Question question259 = new Question(258,questionStr259,answers259,"",2);

        //4.3

        String questionStr260 = "In welchem der folgenden Fälle ist von einer Unternehmensfortführung auszugehen?";
        RealmList<RealmString> answers260 = new RealmList<>();
        answers260.add(new RealmString("A)Müller wird Ende 01 die Erlaubnis zum Betrieb der Gaststätte zum 31.03.02 entzogen, weil nachträglich bekannt wird, dass er Alkoholiker ist."));
        answers260.add(new RealmString("B)Mülller beschliießt Ende 01 seine Gaststätte Mitte 03 zu schließen,um sich altersbedingt zur Ruhe zu setzen"));
        answers260.add(new RealmString("C)Müller rechnet Ende 01 damit, dass in 02 eine Autobahndurchden Park gebaut wird, wodurch dessen Attraktivität stark herabgesetzt wird. Daher rechnet er mit der Einstellung seines Geschäftsbetriebs in 02."));
        answers260.add(new RealmString("D)Müller konnte in 01 oft seine Rechnungen nicht termingerecht bezahlen und muss in 02 mit einem Insolvenzverfahren rechnen, das zum Ende des Unternehmens führen wird."));

        Question question260 = new Question(259,questionStr260,answers260,"3.3",1);
        String questionStr261 = "Wieso ist in dem oben genannten Fall von einer Unternehmensfortführung auszugehen?";
        RealmList<RealmString> answers261 = new RealmList<>();
        answers261.add(new RealmString("A) Weil nur ein faktischer und kein rechtlicher Grund der Fortführung im Wege stehen könnte."));
        answers261.add(new RealmString("B) Weil nur ein rechtlicher und kein faktischer Grund der Fortführung im Wege stehen könnte."));
        answers261.add(new RealmString("C) Weil von weniger als 12 Monaten Unternehmensfortführung ausgegangen werden kann."));
        answers261.add(new RealmString("D) Weil von mehr als 12 Monaten Unternehmensfortführung ausgegangen werden kann."));

        Question question261 = new Question(260,questionStr261,answers261,"",3);

        String questionStr262 = "Die Finanz-OHG erwirbt in 01 zwei Aktienpakete zur längerfristigen Anlage liquider Mittel. Die Aktien A1 kosten 10.000 € und die Aktien A2 kosten 12.000 €. Am 31.12.01 haben sich die Werte wie folgt entwickelt: A1: 6.000 €, A2: 17.000 €. Die Wertänderungen haben dauernden Charakter. Die Anschaffungskosten bilden die Obergrenze der Bewertung, Wertminderungen sind zu beachten. Wie wird Ende 01 bilanziert?";
        RealmList<RealmString> answers262 = new RealmList<>();
        answers262.add(new RealmString("A)Es wird eine Gesamtbewertung vorgenommen in Höhe von 23.000 €."));
        answers262.add(new RealmString("B)Es wird eine Gesamtbewertung vorgenommen in Höhe von 22.000 €"));
        answers262.add(new RealmString("C)Es wird eine Einzelbewertung wie folgt vorgenommen: Für A1 werden 6.000 € angesetzt. Für A2 werden 17.000 € angesetzt"));
        answers262.add(new RealmString("D) Es wird eine Einzelbewertung wie folgt vorgenommen: Für A1 werden 6.000 € angesetzt. Für A2 12.000 € angesetzt werden."));

        Question question262 = new Question(261,questionStr262,answers262,"3.3",3);
        String questionStr263 = "Unternehmer Meier hat aus einer Warenlieferung in 01 eine Forderung gegenüber Schulze in Höhe von 20.000 € netto (die USt ist zu vernachlässigen). Da Schulzes Unternehmen wirtschaftliche Probleme aufweist, wurde die Forderung bei Meier im Jahresabschluss 01 (Stichtag: 31.12.01) mit 0 € bewertet. Im Dezember 02 gewinnt Schulze im Lotto. Mit dem Gewinn will er seine Schulden vollständig tilgen und das Unternehmen umstrukturieren. Meier stellt den Jahresabschluss 02 am 28.02.03 auf. Er erhält die Informationen vom Lottogewinn und Schulzes Tilgungsabsichten am 15.02.03. Welche Art von Information liegt vor und wie wird diese zum 31.12.02 bilanziert?";
        RealmList<RealmString> answers263 = new RealmList<>();
        answers263.add(new RealmString("A)Es liegen wertbegründende Informationen vor, deswegen wird die Forderung in voller Höhe bilanziert."));
        answers263.add(new RealmString("B)Es liegen wertaufhellende Informationen vor, deswegen wird die Forderung in voller Höhe setzen bilanziert."));
        answers263.add(new RealmString("C)Es liegen wertbegründende Informationen vor, deswegen wird die Forderung nicht bilanziert"));
        answers263.add(new RealmString("D)Es liegen wertaufhellende Informationen vor, deswegen wird die Forderung nicht bilanziert"));

        Question question263 = new Question(262,questionStr263,answers263,"3.3",1);
        String questionStr264 = "Unternehmer Meier hat aus einer Warenlieferung in 01 eine Forderung gegenüber Schulze in Höhe von 20.000 € netto (die USt ist zu vernachlässigen). Da Schulzes Unternehmen wirtschaftliche Probleme aufweist, wurde die Forderung bei Meier im Jahresabschluss 01 (Stichtag: 31.12.01) mit null Euro Bewertet. Im Januar 03 gewinnt Schulze im Lotto. Mit dem Gewinn will er seine Schulden vollständig tilgen und das Unternehmen umstrukturieren. Meier stellt den Jahresabschluss 02 am 28.02.03 auf. Er erhält die Informationen vom Lottogewinn und Schulzes Tilgungsabsichten am 15.02.03. Welche Art von Information liegt vor und wie wird diese zum 31.12.02 bilanziert?";
        RealmList<RealmString> answers264 = new RealmList<>();
        answers264.add(new RealmString("A)Es liegen wertbegründende Informationen vor, deswegen wird die Forderung in voller Höhe bilanziert."));
        answers264.add(new RealmString("B)Es liegen wertaufhellende Informationen vor, deswegen wird die Forderung in voller Höhe bilanziert. setzen."));
        answers264.add(new RealmString("C)Es liegen wertbegründende Informationen vor, deswegen wird die Forderung nicht bilanziert"));
        answers264.add(new RealmString("D)Es liegen wertaufhellende Informationen vor, deswegen wird die Forderung nicht bilanziert"));

        Question question264 = new Question(263,questionStr264,answers264,"3.3",2);
        String questionStr265 = "Unternehmer Müller erwirbt am 01.07.01 ein unbebautes Grundstück für 300.000 €. Am 31.12.01 ist der beizulegende Stichtagswert auf 250.000 € gesunken (voraussichtlich nicht dauernde Wertminderung). Wie ist am Bilanzstichtag zu bewerten, wenn das Grundstück langfristig als Lagerplatz genutzt wird?";
        RealmList<RealmString> answers265 = new RealmList<>();
        answers265.add(new RealmString("A)Das Grundstück gehört zum Anlagevermögen. Es gilt das strenge Niederstwertprinzip und folglich eine Bewertung in Höhe von 250.000."));
        answers265.add(new RealmString("B)Das Grundstück gehört zum Anlagevermögen. Es gilt das gemilderte Niederstwertprinzip und eine Bewertung in Höhe von 300.000."));
        answers265.add(new RealmString("C)Das Grundstück gehört zum Umlaufvermögen. Es gilt das strenge Niederstwertprinzip und folglich eine Bewertung in Höhe von 250.000."));
        answers265.add(new RealmString("D)Das Grundstück gehört zum Umlaufvermögen. Es gilt das gemilderte Niederstwertprinzip und folglich eine Bewertung in Höhe von 300.000."));

        Question question265 = new Question(264,questionStr265,answers265,"3.3",1);
        String questionStr266 = "Unternehmer Müller erwirbt am 01.07.01 ein unbebautes Grundstück für 300.000 €. Am 31.12.01 ist der beizulegende Stichtagswert auf 250.000 € gesunken (voraussichtlich nicht dauernde Wertminderung). Wie ist am Bilanzstichtag zu bewerten, wenn das Grundstück zum Weiterkauf erworben wurde ?";
        RealmList<RealmString> answers266 = new RealmList<>();
        answers266.add(new RealmString("A)Das Grundstück gehört zum Anlagevermögen. Es gilt das strenge Niederstwertprinzip und folglich eine Bewertung in Höhe von 250.000."));
        answers266.add(new RealmString("B)Das Grundstück gehört zum Anlagevermögen. Es gilt das gemilderte Niederstwertprinzip und folglich eine Bewertung in Höhe von 300.000."));
        answers266.add(new RealmString("C)Das Grundstück gehört zum Umlaufvermögen. Es gilt das strenge Niederstwertprinzip und folglich eine Bewertung in Höhe von 250.00."));
        answers266.add(new RealmString("D)Das Grundstück gehört zum Umlaufvermögen. Es gilt das gemilderte Niederstwertprinzip und folglich eine Bewertung in Höhe von 300.000."));

        Question question266 = new Question(265,questionStr266,answers266,"3.3",2);
        String questionStr267 = "Welche der folgenden Aussagen zum Niederstwertprinzip ist nach geltendem HGB richtig?";
        RealmList<RealmString> answers267 = new RealmList<>();
        answers267.add(new RealmString("A) Bei voraussichtlich dauernder Wertminderung im Anlagevermögen muss eine Abwertung vorgenommen werden."));
        answers267.add(new RealmString("B) Im Umlaufvermögen gilt das gemilderte Niederstwertprinzip."));
        answers267.add(new RealmString("C) Werden Wertpapiere für spekulative Zwecke erworben, gilt für diesen Posten das gemilderte Niederstwertprinzip."));
        answers267.add(new RealmString("D) Bei voraussichtlich dauernder Wertminderung im Umlaufvermögen kann eine Abwertung vorgenommen werden."));

        Question question267 = new Question(266,questionStr267,answers267,"3.3",0);
        String questionStr268 = "Markieren Sie die falsche Antwort!";
        RealmList<RealmString> answers268 = new RealmList<>();
        answers268.add(new RealmString("A) Ist der Wert eines selbst genutzten Gebäudes auf Dauer gesunken, muss eine Abwertung vorgenommen werden."));
        answers268.add(new RealmString("B) Ist der Wert eines selbst genutzten Gebäudes vorübergehend gesunken, darf keine Abwertung vorgenommen werden."));
        answers268.add(new RealmString("C) Ist der Werte eines Gebäudes, das veräußert werden soll, vorübergehend gesunken, kann eine Abwertung vorgenommen werden."));
        answers268.add(new RealmString("D) Wertpapiere, die zum Zweck einer dauernden Anlage erworben wurden, sind nach dem gemilderten Niederstwertprinzip zu bewerten."));

        Question question268 = new Question(267,questionStr268,answers268,"",2);
        String questionStr269 = "Die A-B-OHG schließt im Dezember 01 einen Vertrag über die Lieferung von Waren ab: Es sind 20.000 Stück zu je 25 € netto zu liefern. Die Auslieferung erfolgt erst Anfang 02. Die OHG hat für die Ware selbst 15 € pro Stück bezahlt. Markieren Sie die korrekte Aussage!";
        RealmList<RealmString> answers269 = new RealmList<>();
        answers269.add(new RealmString("A) Der Gewinn entstehtim Dezember 01 bei Vertragsabschluss. Es gilt das Stichtagsprinzip."));
        answers269.add(new RealmString("B) Der Gewinn entstehtim Dezember 01 bei Vertragsabschluss. Es gilt das Realisationsprinzip."));
        answers269.add(new RealmString("C) Der Gewinn entstehtAnfang 02 bei Auslieferung der Ware. Es gilt das Stichtagsprinzip."));
        answers269.add(new RealmString("D) Der Gewinn entstehtAnfang 02 bei Auslieferung der Ware. Es gilt das Realisationsprinzip."));

        Question question269 = new Question(268,questionStr269,answers269,"3.3",3);
        String questionStr270 = "Wer wird durch den vorsichtigen Erfolgsausweis geschützt?";
        RealmList<RealmString> answers270 = new RealmList<>();
        answers270.add(new RealmString("A) Das Unternehmen"));
        answers270.add(new RealmString("B) Die Aktionäre"));
        answers270.add(new RealmString("C) DieGläubiger "));
        answers270.add(new RealmString("D) Die Kunden"));

        Question question270 = new Question(269,questionStr270,answers270,"",2);
        String questionStr271 = "Die Inter-OHG erhält in 01 eine Warenlieferung aus dem Ausland, wobei eine umgerechnete Verbindlichkeit in Höhe von 100.000 € entsteht. Am Bilanzstichtag wird die Lieferantenverbindlichkeit in einen langfristigen Kredit umgewandelt. Zu diesem Zeitpunkt haben sich die Wechselkurse aber verändert, sodass nach einer Umrechnung die folgenden Beträge gelten: Fall a) 115.000 € bzw. Fall b) 95.000 €. Mit welchen Beträgen ist die Verbindlichkeit zum 31.12.01 anzusetzen?";
        RealmList<RealmString> answers271 = new RealmList<>();
        answers271.add(new RealmString("A) Falla): 100.000 €, Fall b): 100.000 €"));
        answers271.add(new RealmString("B) Falla): 115.000 €, Fall b): 100.000 €"));
        answers271.add(new RealmString("C) Falla): 100.000 €, Fall b): 95.000 €"));
        answers271.add(new RealmString("D) Falla): 115.000 €, Fall b): 95.000 €"));

        Question question271 = new Question(270,questionStr271,answers271,"3.3",1);
        String questionStr272 = "Der Preis einer Maschine beträgt 150.000 € zzgl. 19% USt. Für den Transport muss der Empfänger 2.000 € zzgl. 19% USt bezahlen. Die Transportversicherung kostet 500 €. Die Einzelkosten der Installation betragen 3.000 €. Die Schulungskosten des Personals für die Bedienung der Anlage betragen 4.000 €. Der Lieferant gewährt einen Rabatt von 3% auf den Anschaffungspreis. Wie hoch sind die Anschaffungskosten?";
        RealmList<RealmString> answers272 = new RealmList<>();
        answers272.add(new RealmString("A) 151.000 €"));
        answers272.add(new RealmString("B) 155.000 €"));
        answers272.add(new RealmString("C) 159.000 €"));
        answers272.add(new RealmString("D) 182.645 €"));

        Question question272 = new Question(271,questionStr272,answers272,"3.3",0);
        String questionStr273 = "In einem Unternehmen wird im Geschäftsjahr 01 ein Produkt gefertigt. Die Materialeinzelkosten betragen 20 € je Stück. Zusätzlich sind 50% Materialgemeinkosten zu verrechnen. Die Fertigungseinzelkosten betragen 40 € pro Stück. Zusätzlich sind 150% Fertigungsgemeinkosten zu verrechnen (angemessener Zuschlag: 120%). Die Verwaltungsgemeinkosten belaufen sich auf 80% der gesamten Material- und Fertigungskosten. Außerdem fallen Vertriebskosten in Höhe von 12 € je Stück an, wobei es sich um Einzelkosten handelt. Wie hoch ist die Wertuntergrenze pro Stück?";
        RealmList<RealmString> answers273 = new RealmList<>();
        answers273.add(new RealmString("A) 30 €"));
        answers273.add(new RealmString("B) 118 €"));
        answers273.add(new RealmString("C) 212.4 €"));
        answers273.add(new RealmString("D) 224.4"));

        Question question273 = new Question(272,questionStr273,answers273,"3.3",1);
        String questionStr274 = "Wie hoch ist die Wertobergrenze pro Stück?";
        RealmList<RealmString> answers274 = new RealmList<>();
        answers274.add(new RealmString("A) 30 €"));
        answers274.add(new RealmString("B) 118 €"));
        answers274.add(new RealmString("C) 212.4 €"));
        answers274.add(new RealmString("D) 224.4"));

        Question question274 = new Question(273,questionStr274,answers274,"",2);
        String questionStr275 = "Die Gemeinkosten betragen in einem Unternehmen 50.000 € pro Monat. Es handelt sich in voller Höhe um Fixkosten. Normalerweise werden pro Monat 20.000 Stück eines Produkts A gefertigt. Durch eine sinkende Auftragszahl können nur noch 8.000 Stück hergestellt werden. Die Einzelkosten betragen 40 € pro Stück. Der Lagerbestand beträgt 2.000 Stück. Wie hoch sind die Kosten pro Stück des Produkts A, wenn die tatsächlichen Kosten verrechnet werden?";
        RealmList<RealmString> answers275 = new RealmList<>();
        answers275.add(new RealmString("A) 30 €"));
        answers275.add(new RealmString("B) 42,5 €"));
        answers275.add(new RealmString("C) 46,25 €"));
        answers275.add(new RealmString("D) 50 €"));

        Question question275 = new Question(274,questionStr275,answers275,"3.3",2);
        String questionStr276 = "Welche Herstellungskosten pro Stück dürfen für A maximal verrechnet werden? ";
        RealmList<RealmString> answers276 = new RealmList<>();
        answers276.add(new RealmString("A) 30 €"));
        answers276.add(new RealmString("B) 42,5 €"));
        answers276.add(new RealmString("C) 46,25 €"));
        answers276.add(new RealmString("D) 50 €"));

        Question question276 = new Question(275,questionStr276,answers276,"",1);
        String questionStr277 = "Die Wertuntergrenze der Herstellungskosten bilden";
        RealmList<RealmString> answers277 = new RealmList<>();
        answers277.add(new RealmString("A) alle Einzelkosten"));
        answers277.add(new RealmString("B) alle Einzelkosten ohne Vertriebskosten"));
        answers277.add(new RealmString("C) alle Einzel-und Gemeinkosten"));
        answers277.add(new RealmString("D) alle Einzel-und Gemeinkosten, ohne allgemeine Verwaltungs-und Vertriebskosten"));

        Question question277 = new Question(276,questionStr277,answers277,"3.3",3);
        String questionStr278 = "MarkierenSie die korrekte Aussage!";
        RealmList<RealmString> answers278 = new RealmList<>();
        answers278.add(new RealmString("A) In die Anschaffungskosten können nach dem HGB Finanzierungskosten einbezogen werden (Wahlrecht)."));
        answers278.add(new RealmString("B) In die Herstellungskosten dürfen handelsrechtlich keine Finanzierungskosten einbezogen werden (Verbot)."));
        answers278.add(new RealmString("C) Eine nachträgliche Veränderung der Anschaffungskosten ist im HGB ausgeschlossen, da der Anschaffungsvorgang abgeschlossen ist."));
        answers278.add(new RealmString("D) Die Verrechnung der Kosten für den betrieblichen Kindergarten in die Herstellungskosten der gefertigten Produkte ist wahlweise möglich."));

        Question question278 = new Question(277,questionStr278,answers278,"",3);
        String questionStr279 = "Die Inter-OHG gewährt am 01.10.01 ihrem ausländischen Abnehmer einen normal verzinslichen Kredit in Höhe von 400.000 US-Dollar (Umrechnungskurs: 1 US-Dollar = 0,9 Euro). Die Ausleihung (Forderung) hat eine Laufzeit von zwei Jahren. Am 31.12.01 ist der Umrechnungskurs auf 0,85 Euro gefallen (voraussichtlich nicht dauerhaft). Wie hoch ist der Wert der Forderung am 01.10.01?";
        RealmList<RealmString> answers279 = new RealmList<>();
        answers279.add(new RealmString("A) 340.000 €"));
        answers279.add(new RealmString("B) 360.000 €"));
        answers279.add(new RealmString("C) 380.000 €"));
        answers279.add(new RealmString("D) 400.000€"));

        Question question279 = new Question(278,questionStr279,answers279,"3.3",1);
        String questionStr280 = "Wie hoch wird die Forderung am 31.12.01 bilanziert?";
        RealmList<RealmString> answers280 = new RealmList<>();
        answers280.add(new RealmString("A) 340.000€"));
        answers280.add(new RealmString("B) 360.000 €"));
        answers280.add(new RealmString("C) 340.000 €oder 360.000 €"));
        answers280.add(new RealmString("D) Keinesder oben genannten."));

        Question question280 = new Question(279,questionStr280,answers280,"",2);
        String questionStr281 = "Die Inter-OHG gewährt am 01.10.01 ihrem ausländischen Abnehmer einen normal verzinslichen Kredit in Höhe von 400.000 US-Dollar (Umrechnungskurs: 1 US-Dollar = 0,9 Euro). Die Ausleihung (Forderung) hat eine Laufzeit von zwei Jahren. Am 31.12.01 ist der Umrechnungskurs auf 0,95 Euro gestiegen. Wie hoch wird die Forderung am 31.12.01 bilanziert?";
        RealmList<RealmString> answers281 = new RealmList<>();
        answers281.add(new RealmString("A) 340.000 €"));
        answers281.add(new RealmString("B) 360.000 €"));
        answers281.add(new RealmString("C) 380.000 €"));
        answers281.add(new RealmString("D) 400.000€"));

        Question question281 = new Question(280,questionStr281,answers281,"3.3",1);
        String questionStr282 = "Die Inter-OHG gewährt am 01.10.01 ihrem ausländischen Abnehmer eine Ausleihung in Höhe von 400.000 US-Dollar (Umrechnungskurs: 1 US-Dollar = 0,9 Euro). Die Ausleihung (Forderung) hat eine Laufzeit von sechs Monaten. Am 31.12.01 ist der Umrechnungskurs auf 0,85 Euro gefallen. Wie hoch ist der Wert der Forderung am 01.10.01?";
        RealmList<RealmString> answers282 = new RealmList<>();
        answers282.add(new RealmString("A) 340.000 €"));
        answers282.add(new RealmString("B) 360.000 €"));
        answers282.add(new RealmString("C) 380.000 €"));
        answers282.add(new RealmString("D) 400.000€"));

        Question question282 = new Question(281,questionStr282,answers282,"3.3",1);
        String questionStr283 = "Wie hoch wird die Forderung am 31.12.01 bilanziert?";
        RealmList<RealmString> answers283 = new RealmList<>();
        answers283.add(new RealmString("A) 340.000€"));
        answers283.add(new RealmString("B) 360.000 €"));
        answers283.add(new RealmString("C) 340.000 €oder 360.000 €"));
        answers283.add(new RealmString("D) Keinesder oben genannten."));

        Question question283 = new Question(282,questionStr283,answers283,"",0);
        String questionStr284 = "Die Inter-OHG gewährt am 01.10.01 ihrem ausländischen Abnehmer eine Ausleihung in Höhe von 400.000 US-Dollar (Umrechnungskurs: 1 US-Dollar = 0,9 Euro). Die Ausleihung (Forderung) hat eine Laufzeit von sechs Monaten. Am 31.12.01 ist der Umrechnungskurs auf 0,95 Euro gestiegen. Wie hoch wird die Forderung am 31.12.01 bilanziert?";
        RealmList<RealmString> answers284 = new RealmList<>();
        answers284.add(new RealmString("A) 340.000 €"));
        answers284.add(new RealmString("B) 360.000 €"));
        answers284.add(new RealmString("C) 380.000 €"));
        answers284.add(new RealmString("D) 400.000€"));

        Question question284 = new Question(283,questionStr284,answers284,"3.3",2);

        //4.4

        String questionStr285 = "Eine Maschine wird am 12.10.01 geliefert (Anschaffungskosten: 120.000 €, Nutzungsdauer acht Jahre). Im Zugangsjahr wird monatsgenau abgeschrieben. Wie hoch ist der Abschreibungsbetrag für ein volles Geschäftsjahr nach der linearen Methode?";
        RealmList<RealmString> answers285 = new RealmList<>();
        answers285.add(new RealmString("A) 3.750€"));
        answers285.add(new RealmString("B) 7.500€"));
        answers285.add(new RealmString("C)11.250 €"));
        answers285.add(new RealmString("D) 15.000 €"));

        Question question285 = new Question(284,questionStr285,answers285,"",3);
        String questionStr286 = "Aufgabenstellung wie oben. Wie hoch sind die Abschreibungen in 01 nach der linearen Methode? (monatsgenaue Abschreibung!)";
        RealmList<RealmString> answers286 = new RealmList<>();
        answers286.add(new RealmString("A) 3.750 €"));
        answers286.add(new RealmString("B) 7.500€"));
        answers286.add(new RealmString("C)11.250 €"));
        answers286.add(new RealmString("D) 15.000 €"));

        Question question286 = new Question(285,questionStr286,answers286,"",0);
        String questionStr287 = "Eine Maschine wird am 12.01.01 geliefert (Anschaffungskosten: 120.000 €, Nutzungsdauer acht Jahre). Im Zugangsjahr wird monatsgenau abgeschrieben. Wie hoch sind die Abschreibungen in 01 nach der geometrisch-degressiven Methode (20%)? (Achtung Lieferung jetzt im Januar!)";
        RealmList<RealmString> answers287 = new RealmList<>();
        answers287.add(new RealmString("A) 6.000 €"));
        answers287.add(new RealmString("B) 12.000€"));
        answers287.add(new RealmString("C)24.000 €"));
        answers287.add(new RealmString("D) 36.000 €"));

        Question question287 = new Question(286,questionStr287,answers287,"",2);
        String questionStr288 = "Eine Maschine wird am 12.10.01 geliefert (Anschaffungskosten: 120.000 €, Nutzungsdauer acht Jahre). Im Zugangsjahr wird monatsgenau abgeschrieben. Wie hoch sind die Abschreibungen in 01 nach der geometrisch-degressiven Methode (20%)? (Achtung Lieferung jetzt im Oktober!)";
        RealmList<RealmString> answers288 = new RealmList<>();
        answers288.add(new RealmString("A) 6.000 €"));
        answers288.add(new RealmString("B) 12.000€"));
        answers288.add(new RealmString("C)24.000 €"));
        answers288.add(new RealmString("D) 36.000 €"));

        Question question288 = new Question(287,questionStr288,answers288,"",0);
        String questionStr289 = "Eine Fertigungsanlage wird Anfang 01 geliefert (Anschaffungspreis: 500.000 € zzgl. 19% Ust., voller Vorsteuerabzug, direkte Nebenkosten in Höhe von 40.000 € netto, Nutzungsdauer acht Jahre). Wie hoch sind die Abschreibungen in 01 und 02 nach der linearen Methode?";
        RealmList<RealmString> answers289 = new RealmList<>();
        answers289.add(new RealmString("A) 50.625 €"));
        answers289.add(new RealmString("B) 54.675€"));
        answers289.add(new RealmString("C) 62.500€"));
        answers289.add(new RealmString("D) 67.500 €"));

        Question question289 = new Question(288,questionStr289,answers289,"",3);
        String questionStr290 = "Aufgabenstellung wie oben. Wie hoch sind die Abschreibungen in 01 und 02 nach der geometrisch- degressiven Methode (25%)?";
        RealmList<RealmString> answers290 = new RealmList<>();
        answers290.add(new RealmString("A) In 01:101.250 €;in 02: 75.937,5 €"));
        answers290.add(new RealmString("B) In 01:109.350€: in 02: 82.012,5 €"));
        answers290.add(new RealmString("C)In 01: 125.000 €, in 02: 93.750 €"));
        answers290.add(new RealmString("D)In01:135.000€,in02:101.250€"));

        Question question290 = new Question(289,questionStr290,answers290,"",3);
        String questionStr291 = "Eine Fertigungsanlage wird Anfang 01 geliefert (Anschaffungspreis: 540.000 €, Nutzungsdauer acht Jahre). Wie hoch sind die Abschreibungen in 01 und 02 nach der arithmetisch-degressiven Methode?";
        RealmList<RealmString> answers291 = new RealmList<>();
        answers291.add(new RealmString("A) In 01: 105.000 €, in 02: 90.000 €"));
        answers291.add(new RealmString("B) In 01: 120.000 €, in 02: 105.000 €"));
        answers291.add(new RealmString("C)In01:135.000€,in02:120.000€"));
        answers291.add(new RealmString("D) Keinesder oben Genannten"));

        Question question291 = new Question(290,questionStr291,answers291,"",1);
        String questionStr292 = "Aufgabenstellung wie oben. Die maximale Anzahl von Betriebsstunden beträgt 1.080.000. Verbrauchte Stunden in 01: 220.000, in 02: 240.000. Wie hoch sind die Abschreibungen in 01 und 02 nach der Leistungsabschreibung?";
        RealmList<RealmString> answers292 = new RealmList<>();
        answers292.add(new RealmString("A) In 01: 55.000 €, in 02: 60.000 €"));
        answers292.add(new RealmString("B) In 01: 110.000 €, in 02: 120.000 €"));
        answers292.add(new RealmString("C)In01:220.000€,in02:240.000€"));
        answers292.add(new RealmString("D) Keinesder oben Genannten"));

        Question question292 = new Question(291,questionStr292,answers292,"",1);
        String questionStr293 = "Bei einem Jahresabschreibungsbetrag von 60.000 € und dem Zugang am 10.05.01 werden in 01 Abschreibungen in welcher Höhe verrechnet?";
        RealmList<RealmString> answers293 = new RealmList<>();
        answers293.add(new RealmString("A) 0 €"));
        answers293.add(new RealmString("B) 20.000€"));
        answers293.add(new RealmString("C)40.000€"));
        answers293.add(new RealmString("D) 60.000€"));

        Question question293 = new Question(292,questionStr293,answers293,"",2);
        String questionStr294 = "Bei einem Jahresabschreibungsbetrag von 60.000 €und dem Abgang am 10.05.05 werden in 05  Abschreibungen in welche Höhe verrechnet?";
        RealmList<RealmString> answers294 = new RealmList<>();
        answers294.add(new RealmString("A) 0 €"));
        answers294.add(new RealmString("B) 20.000€"));
        answers294.add(new RealmString("C)40.000€"));
        answers294.add(new RealmString("D) 60.000€"));

        Question question294 = new Question(293,questionStr294,answers294,"",1);
        String questionStr295 = "Markieren Sie die korrekte Antwort!";
        RealmList<RealmString> answers295 = new RealmList<>();
        answers295.add(new RealmString("A) Bei einer voraussichtlich dauerhaften Wertminderung von Sachanlagen muss eine außerplanmäßige Abschreibung erfolgen."));
        answers295.add(new RealmString("B) Bei einer voraussichtlich nichtdauerhaften Wertminderung im Umlaufvermögen kann eine außerplanmäßige Abschreibung erfolgen."));
        answers295.add(new RealmString("C) Bei einer voraussichtlich nichtdauerhaften Wertminderung von Finanzanlagen muss eine außerplanmäßige Abschreibung erfolgen."));
        answers295.add(new RealmString("D) Bei einer voraussichtlich dauerhaften Wertminderung im Umlaufvermögen kann eine außerplanmäßige Abschreibung erfolgen."));

        Question question295 = new Question(294,questionStr295,answers295,"",0);
        String questionStr296 = "Markieren Sie die falsche Antwort!";
        RealmList<RealmString> answers296 = new RealmList<>();
        answers296.add(new RealmString("A) Bei einer voraussichtlich nichtdauerhaften Wertminderung von Sachanlagen darf keine außerplanmäßige Abschreibung erfolgen."));
        answers296.add(new RealmString("B) Bei einer voraussichtlich nichtdauerhaften Wertminderung von Finanzanlagen darf eine außerplanmäßige Abschreibung erfolgen."));
        answers296.add(new RealmString("C)Im Anlagevermögen gilt das gemilderte Niederstwertprinzip."));
        answers296.add(new RealmString("D) Im Umlaufvermögen gilt das Höchstwertprinzip."));

        Question question296 = new Question(295,questionStr296,answers296,"",3);
        String questionStr297 = "Bei betriebsnotwendigen Rohstoffbeständen muss eine Abschreibung vorgenommen werden, wenn der  Marktwert für vergleichbare Rohstoffe gesunken ist. Hierbei ist welcher Markt von Relevanz?";
        RealmList<RealmString> answers297 = new RealmList<>();
        answers297.add(new RealmString("A) Beschaffungsmarkt"));
        answers297.add(new RealmString("B) Beschaffungsmarkt und Absatzmarkt"));
        answers297.add(new RealmString("C) Absatzmarkt"));
        answers297.add(new RealmString("D) Keineder oben genannten Punkte ist richtig"));

        Question question297 = new Question(296,questionStr297,answers297,"",0);
        String questionStr298 = "Bei Waren und Wertpapieren des Umlaufvermögens ist welcher Wert für den Niederstwerttestrelevant? ";
        RealmList<RealmString> answers298 = new RealmList<>();
        answers298.add(new RealmString("A) Veräußerungswert"));
        answers298.add(new RealmString("B) Wiederbeschaffungswert "));
        answers298.add(new RealmString("C)niedrigereWertausVeräußerungs-undWiederbeschaffungswert"));
        answers298.add(new RealmString("D) Keines der beiden"));

        Question question298 = new Question(297,questionStr298,answers298,"",2);
        String questionStr299 = "Unternehmer Schulze schließt am 01.03.01 einen Kaufvertrag über ein Bürogebäude ab. Der Übergang von Nutzen und Lasten ist der 01.08.01. Der Preis beträgt 400.000 €, die Notargebühren betragen 1.000 €. Die Grunderwerbsteuer beläuft sich auf 3,5% des Kaufpreises. Die Umsatzsteuer ist zu vernachlässigen. Der Abschreibungsprozentsatz beträgt drei Prozent der Anschaffungskosten. Wie hoch sind die Anschaffungskosten?";
        RealmList<RealmString> answers299 = new RealmList<>();
        answers299.add(new RealmString("A) 0 €"));
        answers299.add(new RealmString("B) 400.000€"));
        answers299.add(new RealmString("C)401.000€"));
        answers299.add(new RealmString("D) 415.000€"));

        Question question299 = new Question(298,questionStr299,answers299,"",3);
        String questionStr300 = "Unternehmer Schulze schließt am 01.03.01 einen Kaufvertrag über ein Bürogebäude ab. Der Übergang von Nutzen und Lasten ist der 01.08.01. Der Preis beträgt 400.000 €, die Notargebühren betragen 1.000 €. Die Grunderwerbsteuer beläuft sich auf 3,5% des Kaufpreises. Die Umsatzsteuer ist zu vernachlässigen. Der Abschreibungsprozentsatz beträgt drei Prozent. Wie hoch sind die Abschreibungen in 01?";
        RealmList<RealmString> answers300 = new RealmList<>();
        answers300.add(new RealmString("A) 0 €"));
        answers300.add(new RealmString("B) 5.000€"));
        answers300.add(new RealmString("C)5.125€"));
        answers300.add(new RealmString("D) 5.187,5 €"));

        Question question300 = new Question(299,questionStr300,answers300,"",3);
        String questionStr301 = "Angaben wir oben. Wie hoch ist der Restbuchwert am 31.12.01?";
        RealmList<RealmString> answers301 = new RealmList<>();
        answers301.add(new RealmString("A) 0 €"));
        answers301.add(new RealmString("B) 395.000€"));
        answers301.add(new RealmString("C) 395.875€"));
        answers301.add(new RealmString("D) 409.812,5 €"));

        Question question301 = new Question(300,questionStr301,answers301,"",3);
        String questionStr302 = "Unternehmer Müller erwirbt am 01.07.01 das Unternehmen von Schulze. Müller zahlt 5.000.000 € (Zeitwert des Eigenkapitals des Unternehmens: 4.200.000 €). Welcher Posten entsteht und wie ist er zu bilanzieren?";
        RealmList<RealmString> answers302 = new RealmList<>();
        answers302.add(new RealmString("A) Originärer Firmenwert in Höhe von 800.000 €"));
        answers302.add(new RealmString("B) Originärer Firmenwert in Höhe von 4.200.000 €"));
        answers302.add(new RealmString("C) Derivativer Firmenwert in Höhe von 800.000 €"));
        answers302.add(new RealmString("D) Derivativer Firmenwert in Höhe von 4.200.000 €"));

        Question question302 = new Question(301,questionStr302,answers302,"",2);
        String questionStr303 = "Der bisher angestellte Herr Meier gewinnt im Lotto 1.500.000 €. Er verwirklicht seinen Traum und kauft sich ein Unternehmen. Es kostet 1.200.000 € und umfasst Aktivposten zum Buchwert von 800.000 € (zusätzliche stille Reserven 20%) und Schulden im Wert von 240.000 €. Wie hoch ist der derivative Firmenwert?";
        RealmList<RealmString> answers303 = new RealmList<>();
        answers303.add(new RealmString("A) 240.000 €"));
        answers303.add(new RealmString("B) 400.000€"));
        answers303.add(new RealmString("C)480.000€"));
        answers303.add(new RealmString("D) 720.000€"));

        Question question303 = new Question(302,questionStr303,answers303,"",2);
        String questionStr304 = "Markieren Sie die korrekte Aussage!";
        RealmList<RealmString> answers304 = new RealmList<>();
        answers304.add(new RealmString("A) Für den derivativen Firmenwert besteht Ansatzverbot."));
        answers304.add(new RealmString("B) Für den derivativen Firmenwert besteht Ansatzpflicht."));
        answers304.add(new RealmString("C)Für den derivativen Firmenwert besteht Ansatzwahlrecht."));
        answers304.add(new RealmString("D) Für den derivativen Firmenwert besteht ab einem Betrag von 5.000.000€ Ansatzpflicht, davor Ansatzwahlrecht."));

        Question question304 = new Question(303,questionStr304,answers304,"",1);
        String questionStr305 = "Markieren Sie die korrekte Aussage!";
        RealmList<RealmString> answers305 = new RealmList<>();
        answers305.add(new RealmString("A) Der derivative Firmenwert ist ein Vermögensgegenstand."));
        answers305.add(new RealmString("B) Der derivative Firmenwert ist kein Vermögensgegenstand."));
        answers305.add(new RealmString("C) Der derivative Firmenwert ist eine Schuld."));
        answers305.add(new RealmString("D) Der derivative Firmenwert ist ein Eigenkapitalposten."));

        Question question305 = new Question(304,questionStr305,answers305,"",1);
        String questionStr306 = "Markieren Sie die korrekte Aussage!";
        RealmList<RealmString> answers306 = new RealmList<>();
        answers306.add(new RealmString("A) Für den entgeltlich erworbenen Firmenwert besteht ein Ansatzwahlrecht."));
        answers306.add(new RealmString("B) Entsteht der Firmenwert eines Unternehmens im Laufe der Zeit, besteht für den Posten eine Ansatzpflicht."));
        answers306.add(new RealmString("C) Der derivative Firmenwert ergibt sich als Differenz aus dem Kaufpreis eines Unternehmens und dem Zeitwert seines Eigenkapitals."));
        answers306.add(new RealmString("D) Der derivative Firmenwert ergibt sich als Differenz aus dem Kaufpreis eines Unternehmens und dem Buchwert seines Eigenkapitals."));

        Question question306 = new Question(305,questionStr306,answers306,"",2);
        String questionStr307 = "Markieren Sie die korrekte Aussage!";
        RealmList<RealmString> answers307 = new RealmList<>();
        answers307.add(new RealmString("A) Der derivative Firmenwert ist immer über fünf Jahre abzuschreiben."));
        answers307.add(new RealmString("B) Der derivative Firmenwert wird geometrisch-degressiv abgeschrieben, wenn diese Methode den Wertverlauf richtig widerspiegelt. "));
        answers307.add(new RealmString("C)Der Firmenwert kann im Handelsrecht auch vereinfachend über fünfzehn Jahre abgeschrieben werden, da diese Nutzungsdauer im Steuerrecht gilt."));
        answers307.add(new RealmString("D) Der Firmenwert ist immer linear abzuschreiben."));

        Question question307 = new Question(306,questionStr307,answers307,"",1);
        String questionStr308 = "Markieren Sie die falsche Aussage!";
        RealmList<RealmString> answers308 = new RealmList<>();
        answers308.add(new RealmString("A) Der Firmenwert ist außerplanmäßig abzuschreiben, wenn die Wertminderung voraussichtlich dauernd ist"));
        answers308.add(new RealmString("B) Entfällt der Grund, der zu einer außerplanmäßigen Abschreibung des Firmenwerts geführt hat, darf dieser Posten nicht zugeschrieben werden."));
        answers308.add(new RealmString("C) Entfällt der Grund, der zu einer außerplanmäßigen Abschreibung des Firmenwerts geführt hat, muss dieser Posten zugeschrieben werden."));
        answers308.add(new RealmString("D) Nach §246 Abs. 1 Satz 4 HGB gilt der derivative Firmenwert aber als Vermögensgegenstand."));

        Question question308 = new Question(307,questionStr308,answers308,"",2);
        String questionStr309 = "Anfang 01 entsteht ein derivativer Firmenwert in Höhe von 8.000.000 €. Die Nutzungsdauer des Postens hängt im Wesentlichen von einem Geschäftsleiter ab, der in acht Jahren in den Ruhestand gehen will. Daher wird planmäßig linear über acht Jahre abgeschrieben. Am 31.12.03 verstirbt der Geschäftsleiter unerwartet. Der Firmenwert sinkt wertmäßig auf 2.000.000 €. Wie ist der Firmenwert Ende 01 zu bewerten?";
        RealmList<RealmString> answers309 = new RealmList<>();
        answers309.add(new RealmString("A) 2.000.000 €"));
        answers309.add(new RealmString("B) 6.000.000 €"));
        answers309.add(new RealmString("C) 7.000.000 €"));
        answers309.add(new RealmString("D) 8.000.000 €"));

        Question question309 = new Question(308,questionStr309,answers309,"",2);
        String questionStr310 = "Angaben wie oben. Wie ist der Firmenwert Ende 02 zu bewerten?";
        RealmList<RealmString> answers310 = new RealmList<>();
        answers310.add(new RealmString("A) 2.000.000 €"));
        answers310.add(new RealmString("B) 6.000.000 €"));
        answers310.add(new RealmString("C) 7.000.000 €"));
        answers310.add(new RealmString("D) 8.000.000 €"));

        Question question310 = new Question(309,questionStr310,answers310,"",1);
        String questionStr311 = "Angaben wie oben. Wie ist der Firmenwert Ende 03 zu bewerten?";
        RealmList<RealmString> answers311 = new RealmList<>();
        answers311.add(new RealmString("A) 2.000.000 €"));
        answers311.add(new RealmString("B) 6.000.000 €"));
        answers311.add(new RealmString("C) 7.000.000 €"));
        answers311.add(new RealmString("D) 8.000.000 €"));

        Question question311 = new Question(310,questionStr311,answers311,"",0);
        String questionStr312 = "Angaben wie oben. Wie ist der Firmenwert Ende 04 zu bewerten?";
        RealmList<RealmString> answers312 = new RealmList<>();
        answers312.add(new RealmString("A) 0 €"));
        answers312.add(new RealmString("B) 1.000.000 €"));
        answers312.add(new RealmString("C) 2.000.000 €"));
        answers312.add(new RealmString("D) 4.000.000 €"));

        Question question312 = new Question(311,questionStr312,answers312,"",1);
        String questionStr313 = "Markieren Sie die korrekte Antwort!";
        RealmList<RealmString> answers313 = new RealmList<>();
        answers313.add(new RealmString("A)Das Lifo-Verfahren kann nicht zur vereinfachenden Bewertung von Rohstoffen im Rahmen der GoB eingesetzt werden."));
        answers313.add(new RealmString("B)Das Lifo-Verfahren führt bei kontinuierlich steigenden Preisen grundsätzlich zur niedrigsten Bewertung des Endbestands an Vorräten."));
        answers313.add(new RealmString("C) Das Fifo-Verfahren kann zur vereinfachenden Bewertung von Wertpapieren des Umlaufvermögens im Rahmen der GoB eingesetzt werden."));
        answers313.add(new RealmString("D)Das Fifo-Verfahren kann nur zur vereinfachenden Bewertung genutzt werden, wenn es nicht der tatsächlichen Verbrauchsfolge widerspricht."));

        Question question313 = new Question(312,questionStr313,answers313,"",1);
        String questionStr314 = "Buchdruckermeister Müller erwirbt in 01 zu verschiedenen Zeitpunkten Papier für die Produktion von Büchern. Der Anfangsbestand am 01.01.01 ist null. Am 01.03.01 werden 100.000 Bogen zu je 15 € / Bogen, am 01.09.01: 80.000 Bogen zu je 12 € / Bogen und am 01.12.01: 60.000 Bogen zu je 14 € / Bogen erworben. Am 31.12.01 sind noch 25.000 Bogen auf Lager. Wie hoch ist der Bestandswert der Vorräte zum 31.12.01 nach der Durchschnittsmethode?";
        RealmList<RealmString> answers314 = new RealmList<>();
        answers314.add(new RealmString("A)13 €"));
        answers314.add(new RealmString("B)13,67 €"));
        answers314.add(new RealmString("C) 13,75 €"));
        answers314.add(new RealmString("D)13,9 €"));

        Question question314 = new Question(313,questionStr314,answers314,"",2);
        String questionStr315 = "Unternehmer Müller erwirbt in 01 zur Beheizung seines Schmelzofens nacheinander die folgenden Rohstoffmengen (Kohle): 1.000 kg à 15 € / kg, 1.400 kg à 18 € / kg und 600 kg à 16 € / kg. Am Ende des Jahres sind noch 720 kg auf Lager. Anfangsbestand zum 01.01.01: 300 kg à 12 € / kg. Wie hoch ist der Verbrauch in 01 nach dem Fifo-Verfahren?";
        RealmList<RealmString> answers315 = new RealmList<>();
        answers315.add(new RealmString("A) 9.900 €"));
        answers315.add(new RealmString("B) 11.760 €"));
        answers315.add(new RealmString("C)41.460 €"));
        answers315.add(new RealmString("D) 43.500 €"));

        Question question315 = new Question(314,questionStr315,answers315,"",2);
        String questionStr316 = "Angaben wie oben. Wie hoch ist der Endbestand in 01 nach dem Fifo-Verfahren?";
        RealmList<RealmString> answers316 = new RealmList<>();
        answers316.add(new RealmString("A) 9.900 €"));
        answers316.add(new RealmString("B) 11.760 €"));
        answers316.add(new RealmString("C)41.460 €"));
        answers316.add(new RealmString("D) 43.500 €"));

        Question question316 = new Question(315,questionStr316,answers316,"",1);
        String questionStr317 = "Unternehmer Müller erwirbt in 01 zur Beheizung seines Schmelzofens nacheinander die folgenden Rohstoffmengen (Kohle): 1.000 kg à 15 € / kg, 1.400 kg à 18 € / kg und 600 kg à 16 € / kg. Am Ende des Jahres sind noch 720 kg auf Lager. Anfangsbestand zum 01.01.01: 300 kg à 12 € / kg. Wie hoch ist der Verbrauch in 01 nach dem Lifo-Verfahren?";
        RealmList<RealmString> answers317 = new RealmList<>();
        answers317.add(new RealmString("A) 9.900 €"));
        answers317.add(new RealmString("B) 11.760 €"));
        answers317.add(new RealmString("C)41.460 €"));
        answers317.add(new RealmString("D) 43.500 €"));

        Question question317 = new Question(316,questionStr317,answers317,"",3);
        String questionStr318 = "Angaben wie oben. Wie hoch ist der Endbestand in 01 nach dem Lifo-Verfahren?";
        RealmList<RealmString> answers318 = new RealmList<>();
        answers318.add(new RealmString("A) 9.900 €"));
        answers318.add(new RealmString("B) 11.760 €"));
        answers318.add(new RealmString("C)41.460 €"));
        answers318.add(new RealmString("D) 43.500 €"));

        Question question318 = new Question(317,questionStr318,answers318,"",0);
        String questionStr319 = "Unternehmer Müller erwirbt in 01 zur Beheizung seines Schmelzofens nacheinander die folgenden Rohstoffmengen (Kohle): 1.000 kg à 15 € / kg, 1.400 kg à 18 € / kg und 600 kg à 16 € / kg. Am Ende des Jahres sind noch 720 kg auf Lager. Anfangsbestand zum 01.01.01: 300 kg à 12 € / kg. Wie sind die jeweiligen Endbestände zu bewerten, wenn am Bilanzstichtag der beizulegende Wert 11 € / kg beträgt und das LIFO-Verfahren angewandt wird?";
        RealmList<RealmString> answers319 = new RealmList<>();
        answers319.add(new RealmString("A) 7.920 €"));
        answers319.add(new RealmString("B) 8.450 €"));
        answers319.add(new RealmString("C)9.900 €"));
        answers319.add(new RealmString("D) 11.760 €"));

        Question question319 = new Question(318,questionStr319,answers319,"",0);
        String questionStr320 = "Unternehmer Schulze hat am Bilanzstichtag (31.12.01) zwei Forderungen aus Lieferungen im Bestand. Die Forderung A hat einen Nennwert von 238.000 € und die Forderung B einen Nennwert von 178.500 € (jeweils inklusive 19% USt). Die Forderung A wird wahrscheinlich zu 50% ausfallen. Forderung B fällt sicher zu 60% aus. Wie ist Forderung A am Bilanzstichtag zu bewerten?";
        RealmList<RealmString> answers320 = new RealmList<>();
        answers320.add(new RealmString("A) 0 €"));
        answers320.add(new RealmString("B) 119.000 €"));
        answers320.add(new RealmString("C)138.000 €"));
        answers320.add(new RealmString("D) 238.000 €"));

        Question question320 = new Question(319,questionStr320,answers320,"",2);
        String questionStr321 = "Angaben wir oben. Wie ist Forderung B am Bilanzstichtag zu bewerten?";
        RealmList<RealmString> answers321 = new RealmList<>();
        answers321.add(new RealmString("A) 0 €"));
        answers321.add(new RealmString("B) 71.400 €"));
        answers321.add(new RealmString("C)88.500 €"));
        answers321.add(new RealmString("D) 178.500 €"));

        Question question321 = new Question(320,questionStr321,answers321,"",1);
        String questionStr322 = "Wertpapierhändler Karl Aktie hat am 31.12.01 Wertpapiere der Sorte XY im Umlaufvermögen. Die Anschaffungskosten betrugen in 01: 42 € pro Stück. Am 31.12.01 ist ein Verkauf für 41 € möglich, wobei 1,5 € Veräußerungskosten zu tragen sind. Eine Wiederbeschaffung ist zu 41 € zzgl. 50 Cent Gebühr möglich. Mit welchem Betrag sind die Wertpapiere am 31.12.01 zu bewerten?";
        RealmList<RealmString> answers322 = new RealmList<>();
        answers322.add(new RealmString("A) 39,5 €"));
        answers322.add(new RealmString("B) 41,0 €"));
        answers322.add(new RealmString("C)41,5 €"));
        answers322.add(new RealmString("D) 42,0 €"));

        Question question322 = new Question(321,questionStr322,answers322,"",0);

        //TODO ADD two questions seite 276

        //4.5


        String questionStr323 = "Bei welchen der folgenden ungewissen Verbindlichkeiten besteht ein Verbot zum Ansatz als Rückstellung zum 31.12.02 in der Handelsbilanz eines Einzelunternehmens?";
        RealmList<RealmString> answers323 = new RealmList<>();
        answers323.add(new RealmString("A)Berechnete Gewerbesteuer für 02:5.000€"));
        answers323.add(new RealmString("B)Berechnete Einkommensteuer für 02:3.200€"));
        answers323.add(new RealmString("C)Beitrag zur Berufsgenossenschaft 02:4.000€"));
        answers323.add(new RealmString("D) Keinesder oben Genannten"));

        Question question323 = new Question(322,questionStr323,answers323,"",1);
        String questionStr324 = "Bei welchen der folgenden ungewissen Verbindlichkeiten besteht ein Verbot zum Ansatz als Rückstellung zum 31.12.02 in der Handelsbilanz eines Einzelunternehmens?";
        RealmList<RealmString> answers324 = new RealmList<>();
        answers324.add(new RealmString("A)Der Unternehmer setzt in 02 gemietete Maschinen ein. Im Mietvertrag hat er sich verpflichtet, die Maschinen am Ende der Mietlaufzeit generalüberholt zurückzugeben. Ende 02 ist ein Betrag von 15.000 € angemessen."));
        answers324.add(new RealmString("B)Die Buchführungsarbeiten für Januar 03 werden Ende Januar 03 durchgeführt. Betragjeweils:500€."));
        answers324.add(new RealmString("C)Die Genehmigung zum Abbau eines Erzvorkommens wurde mit der Auflage der späteren Wiederaufforstung erteilt. Auch in 02 findet ein Abbau statt. Ende 02 ist ein Betrag von 50.000 € angemessen."));
        answers324.add(new RealmString("D) Keines der oben Genannten"));

        Question question324 = new Question(323,questionStr324,answers324,"",1);
        String questionStr325 = "Markieren Sie die falsche Antwort!";
        RealmList<RealmString> answers325 = new RealmList<>();
        answers325.add(new RealmString("A) Wird eine in 01 unterlassene Instandhaltung einer eigenen Maschine im März 02 nachgeholt, besteht im Handelsrecht eine Passivierungspflicht."));
        answers325.add(new RealmString("B) Wird eine in 01 unterlassene Instandhaltung einer eigenen Maschine im April 02 nachgeholt, besteht im Handelsrecht eine Passivierungspflicht."));
        answers325.add(new RealmString("C) Wird eine in 01 unterlassene Instandhaltung einer gemieteten Maschine (mit Instandhaltungspflicht im Mietvertrag) im Februar 02 nachgeholt, besteht im Handelsrecht eine Passivierungspflicht."));
        answers325.add(new RealmString("D) Wird eine in 01 unterlassene Instandhaltung einer gemieteten Maschine (mit Instandhaltungspflicht im Mietvertrag) im April 02 nachgeholt, besteht im Handelsrecht eine Passivierungspflicht."));

        Question question325 = new Question(324,questionStr325,answers325,"",1);
        String questionStr326 = "Die A-B-OHG bestellt am 01.10.01 Rohstoffe, die am 01.03.02 geliefert werden. Mit der Lieferung wird der Rechnungsbetrag in Höhe von 200.000 € fällig. Die Umsatzsteuer wird vernachlässigt. Ende Dezember stellt Gesellschafter A fest, dass die Rohstoffpreise gesunken sind und jetzt ein Bezug für 180.000 € möglich wäre. Bilanzstichtag ist der 31.12.01. Welche Art von Geschäft liegt am 31.12.01 vor? Wie wird es im Regelfall bilanziert?";
        RealmList<RealmString> answers326 = new RealmList<>();
        answers326.add(new RealmString("A)Unsicheres Geschäft,im Regelfall keine Bilanzierung"));
        answers326.add(new RealmString("B)Unsicheres Geschäft,im Regelfall Bilanzierung"));
        answers326.add(new RealmString("C)Schwebendes Geschäft,im Regelfall keine Bilanzierung"));
        answers326.add(new RealmString("D) Schwebendes Geschäft, im Regelfall Bilanzierung"));

        Question question326 = new Question(325,questionStr326,answers326,"",2);
        String questionStr327 = "Was ist im obigen Fall handelsrechtlich zu veranlassen?";
        RealmList<RealmString> answers327 = new RealmList<>();
        answers327.add(new RealmString("A)Prüfung aller Rohstoffbestände"));
        answers327.add(new RealmString("B)Verbot zur Bilanzierung einer Rückstellung für drohende Verluste aus schwebenden Geschäften"));
        answers327.add(new RealmString("C)Wahlrecht zur Bilanzierung einer Rückstellung für drohende Verluste aus schwebenden Geschäften in Höhe von 20.000 €"));
        answers327.add(new RealmString("D)Pflicht zur Bilanzierung einer Rückstellung für drohende Verluste aus schwebenden Geschäften in Höhe von 20.000 €"));

        Question question327 = new Question(326,questionStr327,answers327,"",2);
        String questionStr328 = "Unternehmer Müller nimmt am 01.10.01 ein Darlehen mit fünfjähriger Laufzeit auf: Nennbetrag: 100.000 €, Auszahlungsbetrag 97.000 € (= 3% Disagio). Die Rückzahlung hat am Ende der Laufzeit zu 100% zu erfolgen. Wie erfolgt die Bewertung der Verbindlichkeit am 31.12.01?";
        RealmList<RealmString> answers328 = new RealmList<>();
        answers328.add(new RealmString("A)Ansatz als Rückstellung in Höhe von 97.000 €"));
        answers328.add(new RealmString("B)Ansatz als Rückstellung in Höhe von 100.000 €"));
        answers328.add(new RealmString("C)Ansatz als Verbindlichkeit in Höhe von 97.000 €"));
        answers328.add(new RealmString("D)Ansatz als Verbindlichkeit in Höhe von 100.000 €"));

        Question question328 = new Question(327,questionStr328,answers328,"",3);

        //4.6
        //TODO
        String questionStr329 = "Markieren Sie die richtige Antwort!";
        RealmList<RealmString> answers329 = new RealmList<>();
        answers329.add(new RealmString("A) Das Grundkapital der AG beträgt mindestens 25.000 €und wird in der Bilanz als gezeichnetes Kapital "));
        answers329.add(new RealmString("B) Das Stammkapital der AG beträgt mindestens 25.000 €und wird in der Bilanz als gezeichnetes Kapital "));
        answers329.add(new RealmString("C) Das Grundkapital der GmbH beträgt mindestens 50.000 €und wird in der Bilanz als gezeichnetes "));
        answers329.add(new RealmString("D) Das Stammkapital der GmbH beträgt mindestens 25.000 €und wird in der Bilanz als gezeichnetes "));

        Question question329 = new Question(328,questionStr329,answers329,"",2);
        String questionStr330 = "Kapital ausgewiesen. MarkierenSiedierichtigeAntwort!";
        RealmList<RealmString> answers330 = new RealmList<>();
        answers330.add(new RealmString("A)Eine Aktiengesellschaft haftet nur mit ihrem Grundkapital für ihre Verbindlichkeiten."));
        answers330.add(new RealmString("B) Eine Aktiengesellschaft haftet mit ihrem gesamten Vermögen für ihre Verbindlichkeiten."));
        answers330.add(new RealmString("C) Das Grundkapital der AG darf nicht höher sein als 50.000 €."));
        answers330.add(new RealmString("D) Das Grundkapital der AG muss höher sein als 50.000 €."));

        Question question330 = new Question(329,questionStr330,answers330,"",2);
        String questionStr331 = "Eigenkapital der AG und GmbH MarkierenSiedierichtigeAntwort! Kapital ausgewiesen. ausgewiesen. ausgewiesen.";
        RealmList<RealmString> answers331 = new RealmList<>();
        answers331.add(new RealmString("A) Das Grundkapital der GmbH beträgt mindestens 25.000 €und wird in der Bilanz als gezeichnetes "));
        answers331.add(new RealmString("B) Das Grundkapital der AG beträgt mindestens 25.000 €und wird in der Bilanz als Grundkapital "));
        answers331.add(new RealmString("C) Das Grundkapital der AG beträgt mindestens 50.000 €und wird in der Bilanz als gezeichnetes Kapital "));
        answers331.add(new RealmString("D) Das Stammkapital der GmbH beträgt mindestens 50.000 €und wird in der Bilanz als gezeichnetes "));

        Question question331 = new Question(330,questionStr331,answers331,"",2);
        String questionStr332 = "Kapital ausgewiesen. Eigenkapital der AG und GmbH MarkierenSiedierichtigeAntwort! Nr. 4 HGB.";
        RealmList<RealmString> answers332 = new RealmList<>();
        answers332.add(new RealmString("A) Kapitalrücklagen entstehen durch erwirtschaftete Beträge in erfolgreichen Geschäftsjahren."));
        answers332.add(new RealmString("B) Werden Aktien mit einem Agio von 100.000 €platziert, entsteht eine Kapitalrücklage nach §272 Abs. 2 "));
        answers332.add(new RealmString("C) Alle Kapitalrücklagen können bei einer AG jederzeit aufgelöst werden."));
        answers332.add(new RealmString("D) Kapitalrücklagen nach §272 Abs. 2 Nr. 4 HGB können bei einer AG jederzeit aufgelöst werden."));

        Question question332 = new Question(331,questionStr332,answers332,"",2);
        String questionStr333 = "MarkierenSiedierichtigeAntwort! um 100.000 €zu vermindern. zahlen, ist aus Unternehmenssicht zu buchen: „Bank an sonstige betriebliche Erträge 50.000“. Gläubigerschutz verstärkt wird.";
        RealmList<RealmString> answers333 = new RealmList<>();
        answers333.add(new RealmString("A) Werden Aktien unter Nennwert ausgegeben (Disagio: 100.000 €), ist die entsprechende Kapitalrücklage "));
        answers333.add(new RealmString("B) Werden Aktien mit Sonderrechten ausgestattet, wofür die Aktionäre einen Zusatzbetrag von 50.000 €"));
        answers333.add(new RealmString("C) Kapitalrücklagen sollen die Haftungsbasis der Kapitalgesellschaften erhöhen, wodurch der "));
        answers333.add(new RealmString("D) Kapitalrücklagen entstehen durch erwirtschaftete Beträge in erfolgreichen Geschäftsjahren."));

        Question question333 = new Question(332,questionStr333,answers333,"",2);
        String questionStr334 = "Kapitalrücklagen Gesetzliche Rücklage DieA-AGhateingezeichnetesKapitalvon500.000€.Am31.12.02bestehteinegesetzlicheRücklagevon 44.000€.DerJahresüberschuss03beläuftsichauf300.000€.Aus02existiertnocheinVerlustvortragvon 20.000€.Kapitalrücklagensindnichtvorhanden.OhnesatzungsmäßigeBesonderheiten.Welche betragsmäßigeHöhedergesetzlicheRücklageisterforderlich?";
        RealmList<RealmString> answers334 = new RealmList<>();
        answers334.add(new RealmString("A) 40.000€"));
        answers334.add(new RealmString("B) 50.000 €"));
        answers334.add(new RealmString("C) 100.000 €"));
        answers334.add(new RealmString("D) 300.000€"));

        Question question334 = new Question(333,questionStr334,answers334,"",2);
        String questionStr335 = "Angabenwieoben.WelcherBetragsolldergesetzlichenRücklageEnde03zugeführtwerden?";
        RealmList<RealmString> answers335 = new RealmList<>();
        answers335.add(new RealmString("A) 6.000€"));
        answers335.add(new RealmString("B) 14.000 €"));
        answers335.add(new RealmString("C) 15.000 €"));
        answers335.add(new RealmString("D) 50.000€"));

        Question question335 = new Question(334,questionStr335,answers335,"",2);
        String questionStr336 = "DiegesetzlicheRücklagemuss…";
        RealmList<RealmString> answers336 = new RealmList<>();
        answers336.add(new RealmString("A) 10% des Jahresüberschusses betragen."));
        answers336.add(new RealmString("B) 10% des Jahresüberschusses betragen."));
        answers336.add(new RealmString("C) 5% des gezeichneten Kapitals betragen."));
        answers336.add(new RealmString("D) 10% des gezeichneten Kapitals betragen."));

        Question question336 = new Question(335,questionStr336,answers336,"",2);
        String questionStr337 = "Gesetzliche Rücklage Bilanzgewinn GegebenistdieBilanzderX-AGzumBeginndesGeschäftsjahres02.In02entscheidetdie Hauptversammlung,vomBilanzgewinn01nur100.000€auszuschüttenunddenverbleibendenBetragins nächsteJahrvorzutragen.In02entstehteinJahresüberschussvon200.000€.DerVorstandwill50% diesesBetrags,also100.000€,denanderenGewinnrücklagenzuführen.DerRestsolldenAktionärenzur Ausschüttungbereitgestelltwerden. WelchenBetragmussdergesetzlichenRücklagein02zugeführtwerden?";
        RealmList<RealmString> answers337 = new RealmList<>();
        answers337.add(new RealmString("A) 5.000€"));
        answers337.add(new RealmString("B) 9.000 €"));
        answers337.add(new RealmString("C) 10.000 €"));
        answers337.add(new RealmString("D) 14.000€"));

        Question question337 = new Question(336,questionStr337,answers337,"",2);
        String questionStr338 = "ABilanzzum 01.01.02P Diverse Vermögensgegenstände600.000Gezeichnetes Kapital400.000 Gesetzliche Rücklage20.000 Bilanzgewinn180.000 600.000600.000 Bilanzgewinn AngabenwieindervorherigenAufgabe.WelchenBetragkannderVorstandmaximaldenGewinnrücklagen zuführen?";
        RealmList<RealmString> answers338 = new RealmList<>();
        answers338.add(new RealmString("A) 95.000€"));
        answers338.add(new RealmString("B) 100.000 €"));
        answers338.add(new RealmString("C) 140.000 €"));
        answers338.add(new RealmString("D) 185.000€"));

        Question question338 = new Question(337,questionStr338,answers338,"",2);
        String questionStr339 = "WiehochistdasgezeichneteKapitalAnfang03?";
        RealmList<RealmString> answers339 = new RealmList<>();
        answers339.add(new RealmString("A) 400.000€"));
        answers339.add(new RealmString("B) 500.000 €"));
        answers339.add(new RealmString("C) 595.000 €"));
        answers339.add(new RealmString("D) 600.000€"));

        Question question339 = new Question(338,questionStr339,answers339,"",2);
        String questionStr340 = "Bilanzgewinn AngabenwieindervorherigenAufgabe.WiehochistdiegesetzlicheRücklageAnfang03?";
        RealmList<RealmString> answers340 = new RealmList<>();
        answers340.add(new RealmString("A) 10.000€"));
        answers340.add(new RealmString("B) 20.000 €"));
        answers340.add(new RealmString("C) 30.000 €"));
        answers340.add(new RealmString("D) 40.000€"));

        Question question340 = new Question(339,questionStr340,answers340,"",2);
        String questionStr341 = "WiehochistdasKontoandereGewinnrücklagenAnfang03?";
        RealmList<RealmString> answers341 = new RealmList<>();
        answers341.add(new RealmString("A) 0€"));
        answers341.add(new RealmString("B) 95.000 €"));
        answers341.add(new RealmString("C) 100.000 €"));
        answers341.add(new RealmString("D) 180.000€"));

        Question question341 = new Question(340,questionStr341,answers341,"",2);
        String questionStr342 = "Bilanzgewinn AngabenwieindervorherigenAufgabe.WiehochistderBilanzgewinnEnde02?";
        RealmList<RealmString> answers342 = new RealmList<>();
        answers342.add(new RealmString("A) 175.000€"));
        answers342.add(new RealmString("B) 180.000 €"));
        answers342.add(new RealmString("C) 195.000 €"));
        answers342.add(new RealmString("D) 200.000€"));

        Question question342 = new Question(341,questionStr342,answers342,"",2);
        String questionStr343 = "Formen des Erfolgsausweises DerGewinndeslaufendenGeschäftsjahreseinerKapitalgesellschaftwirdwiefolgtbezeichnet:";
        RealmList<RealmString> answers343 = new RealmList<>();
        answers343.add(new RealmString("A) Jahresfehlbetrag"));
        answers343.add(new RealmString("B) Gewinnvortrag"));
        answers343.add(new RealmString("C) Gewinnrücklage"));
        answers343.add(new RealmString("D) Jahresüberschuss"));

        Question question343 = new Question(342,questionStr343,answers343,"",2);
        String questionStr344 = "DerJahresüberschussisteinGewinn…";
        RealmList<RealmString> answers344 = new RealmList<>();
        answers344.add(new RealmString("A) Ohne Verlustvortrag."));
        answers344.add(new RealmString("B) OhneGewinnvortrag."));
        answers344.add(new RealmString("C) OhneSteuern. "));
        answers344.add(new RealmString("D) Nach Steuern."));

        Question question344 = new Question(343,questionStr344,answers344,"",2);
        String questionStr345 = "Formen des Erfolgsausweises EntscheidetdieGesellschafterversammlungeinerGmbHspeziellüberdieEinbehaltungundZuweisung einesGewinnbetrags,wirdwelcherderfolgendenPostenerhöht?";
        RealmList<RealmString> answers345 = new RealmList<>();
        answers345.add(new RealmString("A) Jahresfehlbetrag"));
        answers345.add(new RealmString("B) Gewinnvortrag"));
        answers345.add(new RealmString("C) Gewinnrücklagen"));
        answers345.add(new RealmString("D) Jahresüberschuss"));

        Question question345 = new Question(344,questionStr345,answers345,"",2);
        String questionStr346 = "KannbeieinerGmbHeinJahresfehlbetragnichtausgeglichenwerden,erscheintimneuenGeschäftsjahr folgenderPostenaufderPassivseite:";
        RealmList<RealmString> answers346 = new RealmList<>();
        answers346.add(new RealmString("A) Jahresfehlbetrag"));
        answers346.add(new RealmString("B) Gewinnvortrag"));
        answers346.add(new RealmString("C) Verlustvortrag"));
        answers346.add(new RealmString("D) Jahresüberschuss"));

        Question question346 = new Question(345,questionStr346,answers346,"",2);
        String questionStr347 = "Formen des Erfolgsausweises IneinerAktiengesellschaftwirdbeieinerordentlichenKapitalerhöhungwelcherPostenerhöht?";
        RealmList<RealmString> answers347 = new RealmList<>();
        answers347.add(new RealmString("A)Gezeichnetes Kapital "));
        answers347.add(new RealmString("B) Gewinnvortrag"));
        answers347.add(new RealmString("C) Gewinnrücklagen"));
        answers347.add(new RealmString("D) Jahresüberschuss"));

        Question question347 = new Question(346,questionStr347,answers347,"",2);
        String questionStr348 = "WerdenvoneinerAktiengesellschaftAktienüberdemNennbetragausgegeben,verändert(verändern)sich welche(r)Eigenkapitalposten?";
        RealmList<RealmString> answers348 = new RealmList<>();
        answers348.add(new RealmString("A)Gezeichnetes Kapital "));
        answers348.add(new RealmString("B) Gezeichnetes Kapital und Kapitalrücklage "));
        answers348.add(new RealmString("C) Kapitalrücklage "));
        answers348.add(new RealmString("D) GezeichnetesKapital und Gewinnrücklage"));

        Question question348 = new Question(347,questionStr348,answers348,"",2);


        realm.beginTransaction();
        realm.copyToRealm(question232);
        realm.copyToRealm(question233);
        realm.copyToRealm(question234);
        realm.copyToRealm(question235);
        realm.copyToRealm(question236);
        realm.copyToRealm(question237);
        realm.copyToRealm(question238);
        realm.copyToRealm(question239);
        realm.copyToRealm(question240);
        realm.copyToRealm(question241);
        realm.copyToRealm(question242);
        realm.copyToRealm(question243);
        realm.copyToRealm(question244);
        realm.copyToRealm(question245);
        realm.copyToRealm(question246);
        realm.copyToRealm(question247);
        realm.copyToRealm(question248);
        realm.copyToRealm(question249);
        realm.copyToRealm(question250);
        realm.copyToRealm(question251);
        realm.copyToRealm(question252);
        realm.copyToRealm(question253);
        realm.copyToRealm(question254);
        realm.copyToRealm(question255);
        realm.copyToRealm(question256);
        realm.copyToRealm(question257);
        realm.copyToRealm(question258);
        realm.copyToRealm(question259);
        realm.copyToRealm(question260);
        realm.copyToRealm(question261);
        realm.copyToRealm(question262);
        realm.copyToRealm(question263);
        realm.copyToRealm(question264);
        realm.copyToRealm(question265);
        realm.copyToRealm(question266);
        realm.copyToRealm(question267);
        realm.copyToRealm(question268);
        realm.copyToRealm(question269);
        realm.copyToRealm(question270);
        realm.copyToRealm(question271);
        realm.copyToRealm(question272);
        realm.copyToRealm(question273);
        realm.copyToRealm(question274);
        realm.copyToRealm(question275);
        realm.copyToRealm(question276);
        realm.copyToRealm(question277);
        realm.copyToRealm(question278);
        realm.copyToRealm(question279);
        realm.copyToRealm(question280);
        realm.copyToRealm(question281);
        realm.copyToRealm(question282);
        realm.copyToRealm(question283);
        realm.copyToRealm(question284);
        realm.copyToRealm(question285);
        realm.copyToRealm(question286);
        realm.copyToRealm(question287);
        realm.copyToRealm(question288);
        realm.copyToRealm(question289);
        realm.copyToRealm(question290);
        realm.copyToRealm(question291);
        realm.copyToRealm(question292);
        realm.copyToRealm(question293);
        realm.copyToRealm(question294);
        realm.copyToRealm(question295);
        realm.copyToRealm(question296);
        realm.copyToRealm(question297);
        realm.copyToRealm(question298);
        realm.copyToRealm(question299);
        realm.copyToRealm(question300);
        realm.copyToRealm(question301);
        realm.copyToRealm(question302);
        realm.copyToRealm(question303);
        realm.copyToRealm(question304);
        realm.copyToRealm(question305);
        realm.copyToRealm(question306);
        realm.copyToRealm(question307);
        realm.copyToRealm(question308);
        realm.copyToRealm(question309);
        realm.copyToRealm(question310);
        realm.copyToRealm(question311);
        realm.copyToRealm(question312);
        realm.copyToRealm(question313);
        realm.copyToRealm(question314);
        realm.copyToRealm(question315);
        realm.copyToRealm(question316);
        realm.copyToRealm(question317);
        realm.copyToRealm(question318);
        realm.copyToRealm(question319);
        realm.copyToRealm(question320);
        realm.copyToRealm(question321);
        realm.copyToRealm(question322);
        realm.copyToRealm(question323);
        realm.copyToRealm(question324);
        realm.copyToRealm(question325);
        realm.copyToRealm(question326);
        realm.copyToRealm(question327);
        realm.copyToRealm(question328);
        realm.copyToRealm(question329);
        realm.copyToRealm(question330);
        realm.copyToRealm(question331);
        realm.copyToRealm(question332);
        realm.copyToRealm(question333);
        realm.copyToRealm(question334);
        realm.copyToRealm(question335);
        realm.copyToRealm(question336);
        realm.copyToRealm(question337);
        realm.copyToRealm(question338);
        realm.copyToRealm(question339);
        realm.copyToRealm(question340);
        realm.copyToRealm(question341);
        realm.copyToRealm(question342);
        realm.copyToRealm(question343);
        realm.copyToRealm(question344);
        realm.copyToRealm(question345);
        realm.copyToRealm(question346);
        realm.copyToRealm(question347);
        realm.copyToRealm(question348);
        realm.commitTransaction();
    }

    //ErfolgsRechnung TODO ANTWORTEN
    private void initQuestions5(){

        String questionStr349 = "MarkierenSiediekorrekte Aussage!";
        RealmList<RealmString> answers349 = new RealmList<>();
        answers349.add(new RealmString("A) Das Jahresergebnis beim Umsatzkostenverfahren ist immer geringer als beim Gesamtkostenverfahren."));
        answers349.add(new RealmString("B) Das Jahresergebnis beim Umsatzkostenverfahren ist immer größer als beim Gesamtkostenverfahren."));
        answers349.add(new RealmString("C) Das Jahresergebnis beim Umsatzkostenverfahren ist immer gleich wie beim Gesamtkostenverfahren."));
        answers349.add(new RealmString("D) Beim Umsatzkostenverfahren ist -abhängig von der Branche des Unternehmens -das Jahresergebnis "));

        Question question349 = new Question(348,questionStr349,answers349,"",2);
        String questionStr350 = "größer oder kleiner als beim Umsatzkostenverfahren. Bestandsveränderungen werden…";
        RealmList<RealmString> answers350 = new RealmList<>();
        answers350.add(new RealmString("A) nur i mUmsatzkostenverfahren erfasst."));
        answers350.add(new RealmString("B) nur imGesamtkostenverfahren erfasst."));
        answers350.add(new RealmString("C) sowohl im Umsatzkostenerfahren als auch im Gesamtkostenverfahren erfasst."));
        answers350.add(new RealmString("D) weder im Umsatzkostenerfahren noch im Gesamtkostenverfahren erfasst."));

        Question question350 = new Question(349,questionStr350,answers350,"",2);
        String questionStr351 = "In01 werden 20.000 Stück einesProdukts hergestellt undeswerden nochinderselben Periode12.000 Stück abgesetzt .Die folgenden Aufwendungen sindfürdie Produktion angefallen:Personalaufwand 50.000 €, Materialaufwand 40.000 €und Abschreibungen 60.000 €.Die Vertriebskosten fürden Absatz betragen 1 € pro Stück .Der Preis ist12 €pro Stück (netto) .Ertragssteuern werdennichtberücksichtigt .Berechnen Sie die Herstellungskosten (HK)proStück!";
        RealmList<RealmString> answers351 = new RealmList<>();
        answers351.add(new RealmString("A) 4,5 €"));
        answers351.add(new RealmString("B) 7,5 €"));
        answers351.add(new RealmString("C) 8,1 €"));
        answers351.add(new RealmString("D) Keines der oben Genannten"));

        Question question351 = new Question(350,questionStr351,answers351,"",2);
        String questionStr352 = "Aufgabenstellung wie oben. Ber echnen Sie den absoluten Wert der Bestandserhöhungen!";
        RealmList<RealmString> answers352 = new RealmList<>();
        answers352.add(new RealmString("A) 36.000 €"));
        answers352.add(new RealmString("B) 60.000 €"));
        answers352.add(new RealmString("C) 64.800 €"));
        answers352.add(new RealmString("D) 96.000 €"));

        Question question352 = new Question(351,questionStr352,answers352,"",2);
        String questionStr353 = "In01 werden 20.000 Stück einesProdukts hergestellt undeswerden nochinderselben Periode12.000 Stück abgesetzt .Die folgenden Aufwendungen sindfürdie Produktion angefallen:Personalaufwand 50.000 €, Materialaufwand 40.000 €und Abschreibungen 60.000 €.Die Vertriebskosten fürden Absatz betragen 1 € pro Stück .Der Preis ist12 €pro Stück (netto) .Ertragssteuern werdennichtberücksichtigt .Geben Siean wie derGewinn nachdemGesamtkostenverfahren berechnetwurde!";
        RealmList<RealmString> answers353 = new RealmList<>();
        answers353.add(new RealmString("A) 144.000 €+ 64.800 €-162.000 €"));
        answers353.add(new RealmString("B) 144.000 €-87.200 €"));
        answers353.add(new RealmString("C) 144.000 €-90.000 €-12.000 €"));
        answers353.add(new RealmString("D) 144.000 €+ 60.000 €-150.000 €-12.000 €"));

        Question question353 = new Question(352,questionStr353,answers353,"",2);
        String questionStr354 = "Aufgabenstellung wie oben. Geben Sie an wie der Gewinn nach dem Umsatzkostenverfahren berechnet  wurde!";
        RealmList<RealmString> answers354 = new RealmList<>();
        answers354.add(new RealmString("A) 144.000 €+ 64.800 €-162.000 €"));
        answers354.add(new RealmString("B) 144.000 €-87.200 €"));
        answers354.add(new RealmString("C) 144.000 €-90.000 €-12.000 €"));
        answers354.add(new RealmString("D) 144.000 €+ 60.000 €-150.000 €-12.000 €"));

        Question question354 = new Question(353,questionStr354,answers354,"",2);
        String questionStr355 = "In01 werden 20.000 Stück einesProdukts hergestellt undeswerden nochinderselben Periode12.000 Stück abgesetzt .Die folgenden Aufwendungen sindfürdie Produktion angefallen:Personalaufwand 50.000 €, Materialaufwand 40.000 €und Abschreibungen 60.000 €.Die Vertriebskosten fürden Absatz betragen 1 € pro Stück .Der Preis ist12 €pro Stück (netto) .Ertragssteuern werdennichtberücksichtigt .Wie hoch ist das Jahresergebnis?";
        RealmList<RealmString> answers355 = new RealmList<>();
        answers355.add(new RealmString("A) 42.000 €"));
        answers355.add(new RealmString("B) 54.000 €"));
        answers355.add(new RealmString("C) 102.000 €"));
        answers355.add(new RealmString("D) Keines der oben Genannten"));

        Question question355 = new Question(354,questionStr355,answers355,"",2);
        String questionStr356 = "Aufgabenstellung wie oben. Wie lautet der Buchungssatz für die Bestandsveränderung in 01?";
        RealmList<RealmString> answers356 = new RealmList<>();
        answers356.add(new RealmString("A) „Bestandserhöhung fertiger Erzeugnisse an fertige Erzeugnisse [60.000 €]“"));
        answers356.add(new RealmString("B) „Fertige Erzeugnisse an Bestandserhöhung fertiger Erzeugnisse [60.000 €]“"));
        answers356.add(new RealmString("C) „Bestandserhöhung fertiger Erzeugnisse an fertige Erzeugnisse [42.000 €]“"));
        answers356.add(new RealmString("D) „Fertige Erzeugnisse an Bestandserhöhung fertiger Erzeugnisse [42.000 €]“"));

        Question question356 = new Question(355,questionStr356,answers356,"",2);
        String questionStr357 = "DieHerstellungskosten derProdukte beider Sell-AG betragen in01:20 €pro Stück (ohne allgemeine Verwaltungskosten) .In 01 werden 20.000 Stück hergestellt, vondenen 80% abgesetzt werden.DerRest geht aufLager .In der Verwaltung betragendiePersonalaufwendungen 200.000 €,die Abschreibungen 140 .000 €und diesonstigen betrieblichen Aufwendungen 40.000 €. Das gesetzliche Schemafürdas Umsatzkostenverfahren wirdangewendet (Staffelform).Wie hoch istder Wert derLagerbestände wenn die allgemeinen Verwaltungskosten nichtaktiviert werden?";
        RealmList<RealmString> answers357 = new RealmList<>();
        answers357.add(new RealmString("A) 40.000 €"));
        answers357.add(new RealmString("B) 80 .000 €"));
        answers357.add(new RealmString("C) 120.000 €"));
        answers357.add(new RealmString("D) 156.000 €"));

        Question question357 = new Question(356,questionStr357,answers357,"",2);
        String questionStr358 = "Aufgabenstellung wie oben. Wie hoch sind die Umsatzkosten, wenn die allgemeinen Verwaltungskosten  nicht aktiviert werden?";
        RealmList<RealmString> answers358 = new RealmList<>();
        answers358.add(new RealmString("A) 0€"));
        answers358.add(new RealmString("B) 80 .000 €"));
        answers358.add(new RealmString("C) 320.000 €"));
        answers358.add(new RealmString("D) 624.000 €"));

        Question question358 = new Question(357,questionStr358,answers358,"",2);
        String questionStr359 = "DieHerstellungskosten derProdukte beider Sell-AG betragen in01:20 €pro Stück (ohne allgemeine Verwaltungskosten) .In 01 werden 20.000 Stück hergestellt, vondenen 80% abgesetzt werden.DerRest geht aufLager .In der Verwaltung betragendiePersonalaufwendungen 200.000 €,die Abschreibungen 140 .000 €und diesonstigen betrieblichen Aufwendungen 40.000 €. Das gesetzliche Schemafürdas Umsatzkostenverfahren wirdangewendet .Wie hoch sinddieinder GuV ausgewiesenen allgemeinen Verwaltungskosten, wenndiesenichtaktiviert werden?";
        RealmList<RealmString> answers359 = new RealmList<>();
        answers359.add(new RealmString("A) 0€"));
        answers359.add(new RealmString("B) 240 .000 €"));
        answers359.add(new RealmString("C) 340.000 €"));
        answers359.add(new RealmString("D) 380.000 €"));

        Question question359 = new Question(358,questionStr359,answers359,"",2);
        String questionStr360 = "Wie hoch istder Wert derLagerbestände, wenndieallgemeinen Verwaltungskosten aktiviertwerden?";
        RealmList<RealmString> answers360 = new RealmList<>();
        answers360.add(new RealmString("A) 40.000 €"));
        answers360.add(new RealmString("B) 80 .000 €"));
        answers360.add(new RealmString("C) 120.000 €"));
        answers360.add(new RealmString("D) 156.000 €"));

        Question question360 = new Question(359,questionStr360,answers360,"",2);
        String questionStr361 = "DieHerstellungskosten derProdukte beider Sell-AG betragen in01:20 €pro Stück (ohne allgemeine Verwaltungskosten) .In 01 werden 20.000 Stück hergestellt, vondenen 80% abgesetzt werden.DerRest geht aufLager .In der Verwaltung betragendiePersonalaufwendungen 200.000 €,die Abschreibungen 140 .000 €und diesonstigen betrieblichen Aufwendungen 40.000 €. Das gesetzliche Schemafürdas Umsatzkostenverfahren wirdangewendet .Wie hoch sinddieUmsatzkosten, wenndieallgemeinen Verwaltungskosten aktiviertwerden?";
        RealmList<RealmString> answers361 = new RealmList<>();
        answers361.add(new RealmString("A) 0€"));
        answers361.add(new RealmString("B) 80 .000 €"));
        answers361.add(new RealmString("C) 320.000 €"));
        answers361.add(new RealmString("D) 624.000 €"));

        Question question361 = new Question(360,questionStr361,answers361,"",2);
        String questionStr362 = "Aufgabenstellung wie oben. Wie hoch sind die in der GuV ausgewiesenen allgemeinen Verwaltungskosten,  wenn diese aktiviert werden?";
        RealmList<RealmString> answers362 = new RealmList<>();
        answers362.add(new RealmString("A) 0€"));
        answers362.add(new RealmString("B) 240 .000 €"));
        answers362.add(new RealmString("C) 340.000 €"));
        answers362.add(new RealmString("D) 380.000 €"));

        Question question362 = new Question(361,questionStr362,answers362,"",2);
        String questionStr363 = "DieHerstellungskosten derProdukte beider Sell-AG betragen in01:20 €pro Stück (ohne allgemeine Verwaltungskosten) .In 01 werden 20.000 Stück hergestellt, vondenen 80% abgesetzt werden.DerRest geht aufLager .In der Verwaltung betragendiePersonalaufwendungen 200.000 €,die Abschreibungen 140 .000 €und diesonstigen betrieblichen Aufwendungen 40.000 €. Das gesetzliche Schemafürdas Umsatzkostenverfahren wirdangewendet .Hat dieAktivierung derVerwaltungskosten einenEinfluss auf den Erfolg in01? Wenn jawie hoch istdieser?";
        RealmList<RealmString> answers363 = new RealmList<>();
        answers363.add(new RealmString("A) Nein"));
        answers363.add(new RealmString("B) Ja, der Erfolg steigt um 20.000 €"));
        answers363.add(new RealmString("C) Ja, der Erfolg sinkt um 20.000 €"));
        answers363.add(new RealmString("D) Ja, der Erfolg steigt um 76.000 €"));

        Question question363 = new Question(362,questionStr363,answers363,"",2);
        String questionStr364 = "Ist es langfristig sinnvoll die Verwaltungskosten zu aktivieren, um den Gewinn zu beeinflussen?";
        RealmList<RealmString> answers364 = new RealmList<>();
        answers364.add(new RealmString("A) Nein, weil die Aktivierung keinen Einfluss auf den Gewinn hat."));
        answers364.add(new RealmString("B) Nein, weil die Aktivierung langfristig und durchschnittlich gesehen keinen Einfluss auf den Gewinn hat. "));
        answers364.add(new RealmString("C) Ja, weil durch die Aktivierung der Gewinn in Jahr 01 und den Folgejahren steigt."));
        answers364.add(new RealmString("D) Ja, weil durch die Aktivierung der Gewinn langfristig in den Folgejahren steigt."));

        Question question364 = new Question(363,questionStr364,answers364,"",2);
        realm.beginTransaction();
        realm.copyToRealm(question349);
        realm.copyToRealm(question350);
        realm.copyToRealm(question351);
        realm.copyToRealm(question352);
        realm.copyToRealm(question353);
        realm.copyToRealm(question354);
        realm.copyToRealm(question355);
        realm.copyToRealm(question356);
        realm.copyToRealm(question357);
        realm.copyToRealm(question358);
        realm.copyToRealm(question359);
        realm.copyToRealm(question360);
        realm.copyToRealm(question361);
        realm.copyToRealm(question362);
        realm.copyToRealm(question363);
        realm.copyToRealm(question364);
        realm.commitTransaction();


    }

    //TODO BilanzPolitik

    private void initExtraQuestionsGL(){
        String questionStr365 = "";
        RealmList<RealmString> answers365 = new RealmList<>();
        answers365.add(new RealmString(""));
        answers365.add(new RealmString(""));
        answers365.add(new RealmString(""));
        answers365.add(new RealmString(""));

        Question question365 = new Question(364,questionStr365,answers365,"",2);
    }

    private void initExercises() {
        String aufgabe="JUPITER erwirbt eine Maschine, welche in der Produktion zum Einsatz kommt." +
                "Alle relevante Daten entnehmen Sie bitte dem nebenstehenden Beleg. " +
                "Die Bezahlung erfolgt über das Bankkonto.";
        String beleg="Kunde: JUPITER\n" +
                "Rechnung Nr.: ER 101\n" +
                "Wir lieferten Ihnen\n" +
                "Maschine XYZ Umsatzsteuer\n" +
                "01. März\n" +
                "9.000 € 1.800 €\n" +
                "10.800 €";
        Konto soll=new Konto(1234,"KontoSoll","Aktivkonto");
        Konto haben=new Konto(5678,"KontoHaben","Privatkonto");

        Konto falseSoll=new Konto(1111,"KontoFalseSoll","Aktivkonto");
        Konto falseHaben=new Konto(1111,"KontoFalseHaben","Privatenkonto");

        RealmList<Konto> rightSollList=new RealmList<>();
        rightSollList.add(soll);

        RealmList<Konto> rightHabenList=new RealmList<>();
        rightHabenList.add(haben);

        RealmList<Konto> falseList=new RealmList<>();
        falseList.add(falseHaben);
        falseList.add(falseSoll);

        Exercise exercise= new Exercise(aufgabe,beleg,rightSollList,rightHabenList,falseList);

        realm.beginTransaction();
        realm.copyToRealm(exercise);
        realm.commitTransaction();
    }

    //TODO Ab Buchführung alle Vorlesungen
    private void initVorlesungen() {
        int [] arr2={4,6,8,9,17,18,21,22,24,33,34,36,41,46,49};
        RealmList<RealmInteger> arr = new RealmList<>();

        for(int i = 0;i<arr2.length;i++){
            arr.add(new RealmInteger(arr2[i]));
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



        RealmList<RealmInteger> arrV2 = new RealmList<>();
        RealmList<Page> pagesV2 = new RealmList<>();

        VorlesungPDF v2 = new VorlesungPDF(0,"vorlesung2.pdf",arrV2,pagesV2);



        realm.beginTransaction();
        realm.copyToRealm(v);
        realm.copyToRealm(v2);
        realm.commitTransaction();
    }



}
