package com.fortum.nokid.buchrechmc.AsyncTasks;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.fortum.nokid.buchrechmc.Entities.NewQuestion;
import com.fortum.nokid.buchrechmc.Entities.Question;
import com.fortum.nokid.buchrechmc.R;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Nokid on 19/10/2016.
 */

public class GetAllQuestionsTask extends AsyncTask<String,Void,String> {

private Context context;

    public GetAllQuestionsTask(Context context) {
        this.context = context.getApplicationContext();
    }

    @Override
    protected String doInBackground(String... params) {
        final String sessionId = params[0];
        final String url = context.getString(R.string.baseServerUrl)
                + context.getString(R.string.baseApiUrl)
                + context.getString(R.string.questionsApiUrl)
                + context.getString(R.string.getAllQuestionsApiUrl);

        try {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Cookie", "JSESSIONID=" + sessionId+";path=/;HttpOnly");

        HttpEntity<?> requestEntity = new HttpEntity<Object>(null, requestHeaders);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);

        String questionsJson = response.getBody();

        return questionsJson;

        } catch (ResourceAccessException e) {
            Log.e("GetAllQuestionsTask", e.getMessage(), e);
        }

        return null;
    }

}
