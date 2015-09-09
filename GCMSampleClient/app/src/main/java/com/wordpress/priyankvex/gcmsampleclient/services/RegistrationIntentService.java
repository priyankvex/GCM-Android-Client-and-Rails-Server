package com.wordpress.priyankvex.gcmsampleclient.services;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by Priyank(@priyankvex) on 9/9/15.
 *
 * Service that is called to get the token from GCM server and send it to the application server.
 */
public class RegistrationIntentService extends IntentService{

    public RegistrationIntentService(){
        super("Registration ");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }
}
