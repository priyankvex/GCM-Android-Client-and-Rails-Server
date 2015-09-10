package com.wordpress.priyankvex.gcmsampleclient.services;

import android.os.Bundle;

import com.google.android.gms.gcm.GcmListenerService;

/**
 * Created by Priyank(@priyankvex) on 9/9/15.
 * Service that is invoked when message is received by the device.
 */
public class MyGcmListenerService extends GcmListenerService {

    /**
     * This method run executed when message is received.
     * @param from Sender ID of the sender.
     * @param data message that has been received.
     */
    @Override
    public void onMessageReceived(String from, Bundle data) {
        super.onMessageReceived(from, data);

    }
}
