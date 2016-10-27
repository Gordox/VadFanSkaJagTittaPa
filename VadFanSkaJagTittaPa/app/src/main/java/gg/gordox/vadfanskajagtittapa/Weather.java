package gg.gordox.vadfanskajagtittapa;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/** 665223979558-gq5j986cmisaa9v2717sq085vl35qfbb.apps.googleusercontent.com
 * http://openweathermap.org/current
 * https://spring.io/guides/gs/consuming-rest-android/
 * http://stackoverflow.com/questions/27609442/how-to-get-the-sha-1-fingerprint-certificate-in-android-studio-for-debug-mode
 *
 * Created by Spellabbet on 2016-10-27.
 */
public class Weather {
    private static Weather ourInstance = new Weather();
    public static Weather getInstance() {
        return ourInstance;
    }

    private static final float KELVIN_OFFSET = -273.15f;
    private static final String API_KEY = "6039dfdf85eb9e8486e84a5753bc019b";
    private Pair<Float, Float> MALMÖ = new Pair<>(55.5872199f, 12.9304129f);
    private Pair<Float, Float> pos;

    public Weather() {
        pos = new Pair<>(MALMÖ.getFirst(), MALMÖ.getSecond());
    }

    public JSONObject requestWeather() throws IOException, JSONException {
        int a = (int)pos.getFirst().floatValue();
        int b = (int)pos.getSecond().floatValue();

        URL url = new URL("api.openweathermap.org/data/2.5/weather?q=London&APPID=" + API_KEY);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        InputStream input = new BufferedInputStream(connection.getInputStream());//connection.getInputStream();
        String str = "";

        JSONObject obj = new JSONObject(str);

        return obj;
    }
}
