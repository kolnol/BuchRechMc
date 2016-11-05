package com.fortum.nokid.buchrechmc.AsyncTasks;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.fortum.nokid.buchrechmc.R;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by Nokid on 24/09/2016.
 */
public class LoginTask extends AsyncTask<String,Void,String> {
    private Context context;

    public LoginTask(Context context) {
        this.context = context.getApplicationContext();
    }

    @Override
    protected String doInBackground(String... params) {
        try {
            final String url = context.getString(R.string.baseServerUrl) + context.getString(R.string.loginApiUrl);
            String email = params[0];
            String password = params[1];

            MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
            map.add("username", "mykola.odnoshyvkin@tum.de");
            map.add("password", "Kon4ever");

            RestTemplate restTemplate = new RestTemplate();

            HttpMessageConverter formHttpMessageConverter = new FormHttpMessageConverter();
            HttpMessageConverter stringHttpMessageConverternew = new StringHttpMessageConverter();
            ArrayList<HttpMessageConverter<?>> listOfConverters = new ArrayList<>();
            listOfConverters.add(formHttpMessageConverter);
            listOfConverters.add(stringHttpMessageConverternew);

            restTemplate.setMessageConverters(listOfConverters);


            ResponseEntity<String> response = restTemplate.postForEntity( url, map , String.class );

            //Getting JSESSIONID from header
            HttpHeaders headersResponse = response.getHeaders();
            Set<String> keys = headersResponse.keySet();
            String cookie = "";
            for (String header : keys) {
                if (header.equals("Set-Cookie")) {
                    cookie = headersResponse.get(header).get(0);
                }
            }

            String jsessionid = cookie.split(";")[0];
            jsessionid = jsessionid.split("=", 2)[1];
            return jsessionid;
        } catch (Exception e) {
            Log.e("MainActivity", e.getMessage(), e);
        }

        return null;
    }


}
