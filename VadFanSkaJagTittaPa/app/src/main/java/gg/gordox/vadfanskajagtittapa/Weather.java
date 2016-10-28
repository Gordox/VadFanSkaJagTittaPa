package gg.gordox.vadfanskajagtittapa;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

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
    private Pair<Float, Float> MALMÖ = new Pair<>(55.5872199f, 12.9304129f); // Not needed if we fetch using ID
    private Pair<Float, Float> pos;

    public Weather() {
        pos = new Pair<>(MALMÖ.getFirst(), MALMÖ.getSecond());
    }

    public JSONObject requestWeather() throws IOException, JSONException {
        int a = (int)pos.getFirst().floatValue();
        int b = (int)pos.getSecond().floatValue();

        URL idUrl = new URL("api.openweathermap.org/data/2.5/weather?id=2712995&APPID=" + API_KEY); //ID for Malmö, Sweden
        URL url = new URL("api.openweathermap.org/data/2.5/weather?q=London&APPID=" + API_KEY);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        InputStream input = new BufferedInputStream(connection.getInputStream());//connection.getInputStream();
        String str = "";

        //String data = "";

        JSONObject obj = new JSONObject(str);
        //JSONObject temp = obj.getJSONObject("weather");
        /*
        JSONArray jsonArray = obj.optJSONArray("weather");

        for(int i = 0; i < jsonArray.length(); i++)
        {
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            String weatherType = jsonObject.optString("main").toString();

            data += "Weather: " + weatherType;
        }
        */

        return obj;
    }
}
