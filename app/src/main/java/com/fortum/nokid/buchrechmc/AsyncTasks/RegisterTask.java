package com.fortum.nokid.buchrechmc.AsyncTasks;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.fortum.nokid.buchrechmc.Entities.User;
import com.fortum.nokid.buchrechmc.Entities.UserToSend;
import com.fortum.nokid.buchrechmc.R;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Nokid on 22/10/2016.
 */

public class RegisterTask extends AsyncTask<UserToSend, Void, String> {
    private Context context;

    public RegisterTask(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(UserToSend... params) {
        final UserToSend user = params[0];

        final String url ="http://85.214.195.89:8080/api/users/register";

        try {
            HttpHeaders requestHeaders = new HttpHeaders();

            HttpEntity<UserToSend> requestEntity = new HttpEntity<>(user, requestHeaders);

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

            ResponseEntity<String> response = restTemplate.postForEntity(url, requestEntity, String.class);

            return null;

        } catch (ResourceAccessException e) {
           return new Throwable(e).getMessage();
        }
    }
}
