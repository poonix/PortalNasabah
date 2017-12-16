package teknologi.azha.portaldebitur.rest.service;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import teknologi.azha.portaldebitur.BuildConfig;
import teknologi.azha.portaldebitur.rest.ApiConstant;
import teknologi.azha.portaldebitur.utils.preference.AppPreference;

/**
 * Created by pooni on 11/10/2017.
 */

public class RestHelper {
    private static final long CONNECTION_TIMEOUT = 30 * 1000;
    private static final long READ_TIMEOUT = 30 * 1000;

    private static final Object LOCK = new Object();
    private static RestHelper sInstance;
    private static RestHelper sInstanceSSO;

    private static AppPreference preference = AppPreference.getInstance();
    private SaveAjukanPinjamanService service;

    public static RestHelper getInstance() {
        synchronized (LOCK) {
            if (sInstance == null) {
                sInstance = new RestHelper(ApiConstant.BASE_URL_INTERNAL, ApiConstant.USER_AUTH, ApiConstant.PASSWORD_AUTH);
            }
        }
        return sInstance;
    }

    public static void Q(String host) {
        synchronized (LOCK) {
            String apiHost = ApiConstant.BASE_URL_INTERNAL;
            sInstance = new RestHelper(apiHost, ApiConstant.USER_AUTH, ApiConstant.PASSWORD_AUTH);
        }
    }

    private RestHelper(String baseUrl, String usernameAuth, String passwordAuth) {
        Retrofit retrofit = buildRetrofit(baseUrl, usernameAuth, passwordAuth);
        service = retrofit.create(SaveAjukanPinjamanService.class);
    }

    protected Retrofit buildRetrofit(String baseUrl, String usernameAuth, String passwordAuth) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(buildHttpClient(usernameAuth, passwordAuth))
                .addConverterFactory(GsonConverterFactory.create(buildGson()))
                .build();
    }

    private Gson buildGson() {
        return new GsonBuilder()
                .setLenient()
                .serializeNulls()
                .create();
    }

    private OkHttpClient buildHttpClient(String usernameAuth, String passwordAuth) {
        HttpLoggingInterceptor loggingInterceptornterceptor = new HttpLoggingInterceptor();
        loggingInterceptornterceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        //loggingInterceptornterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        HeaderInterceptor headerInterceptor = new HeaderInterceptor();
        headerInterceptor.setBasicAuth(usernameAuth, passwordAuth);
        headerInterceptor.addHeader("Content-Type", "application/json");
        headerInterceptor.addHeader("Accept", "application/json");

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptornterceptor)
                .addInterceptor(headerInterceptor)
                .retryOnConnectionFailure(true)
                .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS);


        return httpClient.build();
    }

    public SaveAjukanPinjamanService getRestService() {
        return this.service;
    }


    public static class HeaderInterceptor implements Interceptor {

        private String username, password;
        private HashMap<String, String> headerMap = new HashMap<>();

        public HeaderInterceptor() {

        }

        public void setBasicAuth(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public void addHeader(String key, String value) {
            headerMap.put(key, value);
        }

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request original = chain.request();

            Request.Builder requestBuilder = original.newBuilder();
            if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
                requestBuilder.addHeader("Authorization", Credentials.basic(username, password));
            }

            for (String key : headerMap.keySet()) {
                requestBuilder.addHeader(key, headerMap.get(key));
            }

            Request request = requestBuilder.build();

            //Response response = chain.proceed(request);
            //Log.d("Retrofit@Response --> ", response.body().string());
            //return response;

            return chain.proceed(request);
        }
    }
}

