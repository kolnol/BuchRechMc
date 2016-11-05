package com.fortum.nokid.buchrechmc.RealmClasses;

import com.fortum.nokid.buchrechmc.AsyncTasks.GetAllQuestionsTask;
import com.fortum.nokid.buchrechmc.AsyncTasks.LoginTask;
import com.fortum.nokid.buchrechmc.Entities.Answer;
import com.fortum.nokid.buchrechmc.Entities.NewQuestion;
import com.fortum.nokid.buchrechmc.Entities.Question;

import java.util.concurrent.ExecutionException;

import io.realm.Realm;
import io.realm.RealmList;

/**
 * Created by Nokid on 21/10/2016.
 */

public class RealmDatabaseController {
    private Realm realm;

    private void createNewDatabase() {
        Realm realm = Realm.getDefaultInstance();
    }
}
