package com.provoyants.iper.rest;

import android.content.Intent;

import com.google.android.gms.iid.InstanceIDListenerService;
import com.provoyants.iper.ui.service.GCMRegistrationService;

/**
 * Created by riontech4 on 27/4/16.
 */
public class MyInstanceIDListenerService extends InstanceIDListenerService
{
    /**
     * Called if InstanceID token is updated. This may occur if the security of
     * the previous token had been compromised. This call is initiated by the
     * InstanceID provider.
     */
    // [START refresh_token]
    @Override
    public void onTokenRefresh() {
        // Fetch updated Instance PHOTO_EVENT_ID token and notify our app's server of any changes (if applicable).
        Intent intent = new Intent(this, GCMRegistrationService.class);
        startService(intent);
    }
}
