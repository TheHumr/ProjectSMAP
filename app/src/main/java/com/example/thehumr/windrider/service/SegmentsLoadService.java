package com.example.thehumr.windrider.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.example.thehumr.windrider.app.MyApplication;
import com.samsandberg.stravaauthenticator.StravaAuthenticateActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by ondraboura on 28/12/2017.
 */

public class SegmentsLoadService extends IntentService {

    public SegmentsLoadService() {
        super("SegmentsLoadService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }

    public static JSONObject getJsonObject(final String urlString) throws IOException, JSONException {
        final StringBuilder jsonResult = new StringBuilder();
        try {

            URL url = new URL(urlString);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStreamReader in = new InputStreamReader(connection.getInputStream());

            int read;
            char[] buff = new char[1024];

            while ((read = in.read(buff)) != -1) {
                jsonResult.append(buff, 0, read);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new JSONObject(jsonResult.toString());
    }

    public static void getAthlete(Context context) {
        final String url = "https://www.strava.com/api/v3/athlete?access_token=" + StravaAuthenticateActivity.getStravaAccessToken(context);
        final JSONObject[] jsonObject = {null};
        final StringBuilder jsonResult = new StringBuilder();

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    jsonObject[0] = SegmentsLoadService.getJsonObject(url);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });

        thread.start();

//            JSONObject jsonObjectData = jsonObject.getJSONObject("data");
//            JSONArray jsonArrayWeather = jsonObjectData.getJSONArray("weather");
//            JSONObject jsonObjectWeatherData = jsonArrayWeather.getJSONObject(0);
//            JSONArray jsonArrayHourly = jsonObjectWeatherData.getJSONArray("hourly");
//            JSONObject jsonObjectHourly = jsonArrayHourly.getJSONObject(0);
//
//            double temperature = jsonObjectHourly.getDouble("tempC");
//            double wind = jsonObjectHourly.getDouble("windspeedKmph");
//            double feelsTemperature = jsonObjectHourly.getDouble("FeelsLikeC");
//
//            JSONArray jsonArrayWeatherDesc = jsonObjectHourly.getJSONArray("weatherDesc");
//            JSONObject jsonObjectWeatherDesc = jsonArrayWeatherDesc.getJSONObject(0);
//            String name = jsonObjectWeatherDesc.getString("value");
//
//            JSONArray jsonArrayWeatherIconURL = jsonObjectHourly.getJSONArray("weatherIconUrl");
//            JSONObject jsonObjectWeatherIconURL = jsonArrayWeatherIconURL.getJSONObject(0);
//            String iconURL = jsonObjectWeatherIconURL.getString("value");
//
//            Weather weather = new Weather(name, iconURL, temperature, feelsTemperature, wind);
//
//            return weather;

        //        return null;

    }
}