/*
 * Copyright 2014 Realm Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fortum.nokid.buchrechmc.RealmClasses;

import io.realm.DynamicRealm;
import io.realm.DynamicRealmObject;
import io.realm.FieldAttribute;
import io.realm.Realm;
import io.realm.RealmMigration;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;
import io.realm.internal.Table;

/***************************** NOTE: *********************************************
 * The API for migration is currently using internal lower level classes that will
 * be replaced by a new API very soon! Until then you will have to explore and use
 * below example as inspiration.
 *********************************************************************************
 */


public class Migration implements RealmMigration {

    @Override
    public void migrate(final DynamicRealm realm, long oldVersion, long newVersion) {
        RealmSchema schema = realm.getSchema();
        if(oldVersion==0){
            RealmObjectSchema questionSchema = schema.get("Question");
            //content
            questionSchema
                    .addField("content",String.class, FieldAttribute.REQUIRED)
                    .transform(new RealmObjectSchema.Function(){

                        @Override
                        public void apply(DynamicRealmObject obj) {
                            obj.set("content",obj.getString("question"));
                        }
                    })
                    .removeField("question");
            //id change from int to long
            questionSchema
                    .addField("id_tmp",long.class,FieldAttribute.PRIMARY_KEY)
                    .transform(new RealmObjectSchema.Function() {
                        @Override
                        public void apply(DynamicRealmObject obj) {
                            int oldId=obj.getInt("id");
                            obj.setLong("id_tmp",oldId);
                        }
                    })
                    .removeField("id")
                    .renameField("id_tmp","id");
            //possibleAnswers

            oldVersion++;
        }
    }
}
