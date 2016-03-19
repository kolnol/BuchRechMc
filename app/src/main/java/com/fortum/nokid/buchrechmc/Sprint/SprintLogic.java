package com.fortum.nokid.buchrechmc.Sprint;

import com.fortum.nokid.buchrechmc.Activities.MainActivity;
import com.fortum.nokid.buchrechmc.Entities.Question;
import com.fortum.nokid.buchrechmc.RealmClasses.RealmBoolean;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import io.realm.RealmList;
import io.realm.RealmResults;


public class SprintLogic {

    public static String generateResult(Sprint sprint){
        int countRight=getCountRightAnswered(sprint);
        int countFalse=getCountFalseAnswered(sprint);
        String bestKapitel=getKapitelWithMostRightAnswers(sprint);
        String worstKapitel=getKapitelWithLeastRightAnswers(sprint);
        double percent=getPercentRight(sprint);

        String result="Sie haben den Sprint auf "+percent+"% bestanden.\n"
                        +"Es wurde "+countRight+" Fragen richtig und "+countFalse+" Fragen falsch beantwortet.\n"
                        +"In diesem Test waren Sie gut in der Kapitel "+bestKapitel+" aber Sie müssen sich noch in der Kapitel "+worstKapitel+" verbessern.\n" +
                "Viel Erfolg noch! Sie schaffen das!";

        return result;
    }

    public static int getCountRightAnswered(Sprint sprint){
        int sum=0;
        RealmList<RealmBoolean> trigger = sprint.getAnswerTrigger();
        for(int i=0;i<trigger.size();i++){
            if(trigger.get(i).isValue()){
                sum++;
            }
        }
        return sum;
    }

    public static int getCountFalseAnswered(Sprint sprint){
        int sum=0;
        RealmList<RealmBoolean> trigger = sprint.getAnswerTrigger();
        for(int i=0;i<trigger.size();i++){
            if(!trigger.get(i).isValue()){
                sum++;
            }
        }
        return sum;
    }

    private static HashMap<String,Integer> getMapRightAnswers(Sprint sprint){
        RealmList<Question> questions=sprint.getQuestions();
        RealmList<RealmBoolean> trigger = sprint.getAnswerTrigger();

        HashMap<String,Integer> rightMap=new HashMap<>();
        for(int i=0;i<trigger.size();i++){
            if(trigger.get(i).isValue()){
                String kapitel=questions.get(i).getKapitel();
                if(rightMap.containsKey(kapitel)){
                    rightMap.put(kapitel,rightMap.get(kapitel)+1);
                }else{
                    rightMap.put(kapitel,1);
                }

            }
        }
        return rightMap;
    }

    public static String getKapitelWithMostRightAnswers(Sprint sprint){

        return getMaxKapitelFromMap(getMapRightAnswers(sprint));
    }

    private static String getMaxKapitelFromMap(HashMap<String,Integer> map){
        Map.Entry<String,Integer> maxEntry=null;

        for(Map.Entry<String,Integer> entry:map.entrySet()){
            if (maxEntry==null||entry.getValue().compareTo(maxEntry.getValue())>0){
                maxEntry=entry;
            }
        }
        if(maxEntry==null){
            return "Keine Frage wurde beantwortet";
        }
        return maxEntry.getKey();
    }

    public static String getKapitelWithLeastRightAnswers(Sprint sprint){
        return getMinKapitelFromMap(getMapRightAnswers(sprint));
    }


    private static String getMinKapitelFromMap(HashMap<String,Integer> map){
        Map.Entry<String,Integer> minEntry=null;

        for(Map.Entry<String,Integer> entry:map.entrySet()){
            if (minEntry==null||entry.getValue().compareTo(minEntry.getValue())<0){
                minEntry=entry;
            }
        }
        if(minEntry==null){
            return "Keine Frage wurde beantwortet";
        }
        return minEntry.getKey();
    }

    public static double getPercentRight(Sprint sprint){
        double right=getCountRightAnswered(sprint);
        double count=sprint.getCount();

        double res= (right/count)*100;
        return (double) Math.round(res * 100) / 100;
    }

    public static void initQuestions(Sprint sprint){

        RealmList<Question> questionList=new RealmList<>();
        Set<Integer> integerSet=getSetOfIndexes(sprint.getCount());
        Iterator itr=integerSet.iterator();
        RealmResults<Question> questions= MainActivity.realm.allObjects(Question.class);
        int index;

        while(itr.hasNext()){
            index = ((int) itr.next());
            Question question = questions.get(index);
            questionList.add(question);
        }


        sprint.setQuestions(questionList);
    }

    private static Set<Integer> getSetOfIndexes(int count){

        Set<Integer> integerSet = new HashSet<>();

        int size= MainActivity.realm.allObjects(Question.class).size();

        while(integerSet.size()<count){
            integerSet.add(getRandomInt(0,size-1));
        }

        return integerSet;
    }

    private static int getRandomInt(int a,int b){
        int min = Math.min(a,b);
        int max = Math.max(a,b);
        return min+(int)(Math.random()*((max-min) + 1));
    }
}
