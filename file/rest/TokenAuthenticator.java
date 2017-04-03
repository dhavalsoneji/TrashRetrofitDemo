package com.provoyants.iper.rest;

import com.google.gson.Gson;
import com.kittyapplication.core.utils.Applog;
import com.provoyants.iper.AppApplication;
import com.provoyants.iper.model.LoginResponse;
import com.provoyants.iper.model.ServerRequest;
import com.provoyants.iper.model.ServerResponse;
import com.provoyants.iper.utils.PreferanceUtils;
import com.provoyants.iper.utils.Utils;

import java.io.IOException;

import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import retrofit2.Call;

/**
 * Created by Dhaval Soneji Riontech on 9/11/16.
 */
public class TokenAuthenticator implements Authenticator {
    private static final String TAG = TokenAuthenticator.class.getSimpleName();
    private int mRetryCount = 0;
    private String mToken = "";

    @Override
    public Request authenticate(Route route, Response response) throws IOException {
        Applog.d(TAG, "response.code(): " + response.code());
        if (response.code() == 401) {

            try {
                ServerRequest obj = new ServerRequest();
                obj.setUsername(PreferanceUtils.getUsername(AppApplication.getContext()));
                obj.setPassword(PreferanceUtils.getPassword(AppApplication.getContext()));
//            obj.setImei(Utils.getIMEI(AppApplication.getContext()));
                obj.setImei(PreferanceUtils.getImei(AppApplication.getContext()));
                Applog.d(TAG, new Gson().toJson(obj));

                Call<ServerResponse<LoginResponse>> call = Singleton.getInstance().getRestOkClient().login(obj);
                ServerResponse<LoginResponse> loginResponseServerResponse = call.execute().body();
                if (loginResponseServerResponse != null
                        && loginResponseServerResponse.getResult() != null) {
                    mToken = loginResponseServerResponse.getResult().getToken();
                    Applog.e(TAG, "Got the token.. continue now.. == " + mToken);
                    PreferanceUtils.setUserToken(AppApplication.getContext(), mToken);
                }
            } catch (IOException e) {
                Applog.e(TAG, e.getMessage(), e);
            }
        }
        mRetryCount++;
        Applog.e(TAG, "returning... = " + mRetryCount);
        return response.request().newBuilder()
                .header("Authorization", PreferanceUtils.getUserToken(AppApplication.getContext()))
//                .header("Connection","close")
                .build();
    }
}
