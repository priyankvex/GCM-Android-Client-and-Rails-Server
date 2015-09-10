package com.wordpress.priyankvex.gcmsampleclient.services;

import com.google.android.gms.iid.InstanceIDListenerService;

/**
 * Created by Priyank(@priyankvex) on 9/9/15.
 *
 * Service is invoked when token(device ID for GCM) is updated.
 * Could be called when security of the token is compromised.
 */
public class MyInstanceIDListenerService extends InstanceIDListenerService{

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        // Fetch updated token from the server again and send it to application server.
        new RegistrationAsyncTask(null).execute();
    }
}
