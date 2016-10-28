package gg.gordox.vadfanskajagtittapa;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import com.survivingwithandroid.weather.lib.WeatherClient;
import com.survivingwithandroid.weather.lib.WeatherConfig;
import com.survivingwithandroid.weather.lib.exception.WeatherLibException;
import com.survivingwithandroid.weather.lib.exception.WeatherProviderInstantiationException;
import com.survivingwithandroid.weather.lib.model.CurrentWeather;
import com.survivingwithandroid.weather.lib.model.Weather;
import com.survivingwithandroid.weather.lib.provider.openweathermap.OpenweathermapProviderType;
import com.survivingwithandroid.weather.lib.request.WeatherRequest;

import org.json.JSONException;

import java.io.IOException;

/** 665223979558-gq5j986cmisaa9v2717sq085vl35qfbb.apps.googleusercontent.com
 * https://openweathermap.org/weather-conditions
 * Gamla Staden - 2712995
 * Created by Spellabbet on 2016-10-27.
 */
public class WeatherRetreiver {
    private static final String TAG = WeatherRetreiver.class.getName();
    //private static WeatherRetreiver ourInstance = new WeatherRetreiver();
    //private static WeatherRetreiver getInstance() {
    //    return ourInstance;
    //}

    private static final float KELVIN_OFFSET = -273.15f;
    private static final String API_KEY = "6039dfdf85eb9e8486e84a5753bc019b";
    private Pair<Float, Float> MALMÖ = new Pair<>(55.5872199f, 12.9304129f);
    private Pair<Float, Float> pos;
    private Activity activity;

    private float temp;
    private String cond;
    private Weather.Condition current;

    public WeatherRetreiver(Activity activity) {
        this.activity = activity;
        pos = new Pair<>(MALMÖ.getFirst(), MALMÖ.getSecond());
    }

    public void run()
    {
        WeatherTask t = new WeatherTask();
        t.execute();
    }

    private class WeatherTask extends AsyncTask<String, String, String>
    {
        private String response;
        private ProgressDialog progressDialog;

        @Override
        protected String doInBackground(String... params) {

            try {
                doWork();
            } catch(Exception e)
            {
                e.printStackTrace();
                response = e.getMessage();
            }

            return response;
        }

        private void doWork() throws IOException, JSONException, WeatherProviderInstantiationException {
            Log.d(TAG, "Do WORK");
            int a = (int)pos.getFirst().floatValue();
            int b = (int)pos.getSecond().floatValue();

            WeatherClient.ClientBuilder builder = new WeatherClient.ClientBuilder();
            WeatherConfig config = new WeatherConfig();
            config.unitSystem = WeatherConfig.UNIT_SYSTEM.M;
            config.lang = "en";
            config.maxResult = 5;
            config.numDays = 3;
            config.ApiKey = "6039dfdf85eb9e8486e84a5753bc019b";

            WeatherClient client = builder.attach(activity)
                    .provider(new OpenweathermapProviderType())
                    .httpClient(com.survivingwithandroid.weather.lib.client.okhttp.WeatherDefaultClient.class)
                    .config(config)
                    .build();

            WeatherRequest req = new WeatherRequest("2712995");
            client.getCurrentCondition(req, new WeatherClient.WeatherEventListener() {
                @Override
                public void onWeatherError(WeatherLibException wle) {

                }

                @Override
                public void onConnectionError(Throwable t) {

                }

                @Override
                public void onWeatherRetrieved(CurrentWeather weather) {
                    Weather w = weather.weather;
                    temp = w.temperature.getTemp();
                    Weather.Condition c = w.currentCondition;
                    cond = c.getCondition();
                    current = c;
                }
            });
            //WeatherRequest req = new WeatherRequest(pos.getFirst(), pos.getSecond());
            /*client.searchCity(pos.getFirst(), pos.getSecond(), new WeatherClient.CityEventListener() {
                @Override
                public void onWeatherError(WeatherLibException wle) {
                    Log.d(TAG, "onWeatherError");
                    wle.printStackTrace();
                }

                @Override
                public void onConnectionError(Throwable t) {
                    Log.d(TAG, "onConnectionError");
                }

                @Override
                public void onCityListRetrieved(List<City> cityList) {
                    Log.d(TAG, "onCityListRetrieved");
                    for(int i = 0; i < cityList.size(); i++)
                    {
                        City m = cityList.get(i);
                        Log.d(TAG, m.getName() + " - " + m.getId());
                    }
                }
            });*/
        }

        @Override
        protected void onPostExecute(String result)
        {
            progressDialog.dismiss();
        }

        @Override
        protected void onPreExecute()
        {
            progressDialog = ProgressDialog.show(activity, activity.getResources().getString(R.string.progress_weather), "Vädret");

        }

        @Override
        protected void onProgressUpdate(String... text)
        {

        }
    }
}
