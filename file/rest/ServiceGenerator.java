package com.provoyants.iper.rest;

import com.provoyants.iper.AppApplication;
import com.provoyants.iper.utils.AppConstants;
import com.provoyants.iper.utils.PreferanceUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Dhaval Soneji Riontech on 9/11/16.
 */
public class ServiceGenerator {
    // No need to instantiate this class.
    private ServiceGenerator() {
    }

    /**
     * @param serviceClass
     * @param <S>
     * @return
     */
    public static <S> S createService(Class<S> serviceClass) {

        // set your desired log level
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        // Add the interceptor to OkHttpClient
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(httpLoggingInterceptor);
        builder.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Content-Type", "application/json")
                        .build();
                return chain.proceed(newRequest);

            }
        });


        builder.readTimeout(AppConstants.CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS).
                connectTimeout(AppConstants.CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS);

        // Set the custom client when building adapter
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();

        return retrofit.create(serviceClass);
    }

    public static <S> S createAuthenticated(Class<S> serviceClass) {

        // set your desired log level
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        // Add the interceptor to OkHttpClient
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.authenticator(new TokenAuthenticator());
        builder.addInterceptor(httpLoggingInterceptor);
        builder.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Content-Type", "application/json")
                        .addHeader("Authorization", PreferanceUtils.getUserToken(AppApplication.getContext()))
                        .build();
                return chain.proceed(newRequest);

            }
        });


        builder.readTimeout(AppConstants.CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS).
                connectTimeout(AppConstants.CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS);

        // Set the custom client when building adapter
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();

        return retrofit.create(serviceClass);
    }

    //    /**
//     * @param serviceClass
//     * @param username
//     * @param password
//     * @param <S>
//     * @return
//     */
//    public static <S> S createService(Class<S> serviceClass, String username, String password) {
//        final OkHttpClient okHttpClient = new OkHttpClient();
//        okHttpClient.setReadTimeout(AppConstants.CONNECTION_TIMEOUT, TimeUnit.SECONDS);
//        okHttpClient.setConnectTimeout(AppConstants.CONNECTION_TIMEOUT, TimeUnit.SECONDS);
//
//        // set endpoint url and use OkHTTP as HTTP client
//        RestAdapter.Builder builder = new RestAdapter.Builder()
//                .setEndpoint(AppConstants.BASE_URL)
//                .setLogLevel(RestAdapter.LogLevel.FULL)
//                .setClient(new OkClient(okHttpClient));
//
//        if (username != null && password != null) {
//            // concatenate username and password with colon for authentication
//            final String credentials = username + ":" + password;
//
//            builder.setRequestInterceptor(new RequestInterceptor() {
//                @Override
//                public void intercept(RequestFacade request) {
//                    // create Base64 encodet string
//                    //String string = "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
//                    request.addHeader("Content-Type", "application/json");
//                    //request.addHeader("Authorization", string);
//                }
//            });
//        }
//
//        RestAdapter adapter = builder.build();
//
//        return adapter.create(serviceClass);
//    }
}
