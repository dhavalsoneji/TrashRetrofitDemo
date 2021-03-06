package com.provoyants.iper.rest;

/**
 * Created by Dhaval Soneji Riontech on 9/11/16.
 */
public class Singleton {
    private final static String TAG = Singleton.class.getSimpleName();

    private static FinalWrapper<Singleton> helperWrapper;
    private static final Object LOCK = new Object();
    private final RestClient mRestOkClient;
    private final RestClient mRestAuthenticatedOkClient;
    private boolean launcherRunning;

    public boolean isLauncherRunning() {
        return launcherRunning;
    }

    public void setLauncherRunning(boolean launcherRunning) {
        this.launcherRunning = launcherRunning;
    }

    private Singleton() {
        // Rest client without basic authorization
        mRestOkClient = ServiceGenerator.createService(RestClient.class);
        mRestAuthenticatedOkClient = ServiceGenerator.createAuthenticated(RestClient.class);
    }

    /**
     * @return
     */
    public static Singleton getInstance() {
        FinalWrapper<Singleton> wrapper = helperWrapper;

        if (wrapper == null) {
            synchronized (LOCK) {
                if (helperWrapper == null) {
                    helperWrapper = new FinalWrapper<>(new Singleton());
                }
                wrapper = helperWrapper;
            }
        }
        return wrapper.value;
    }

    public RestClient getRestOkClient() {
        return mRestOkClient;
    }

    public RestClient getRestAuthenticatedOkClient() {
        return mRestAuthenticatedOkClient;
    }
}
