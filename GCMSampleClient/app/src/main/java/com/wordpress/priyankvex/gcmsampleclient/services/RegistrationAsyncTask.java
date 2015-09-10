package com.wordpress.priyankvex.gcmsampleclient.services;

import android.app.Activity;
import android.os.AsyncTask;

/**
 * Created by Priyank(@priyankvex) on 9/9/15.
 *
 * Async Task to get the token from GCM server and send it to the application server.
 */
public class RegistrationAsyncTask extends AsyncTask<Void, Void, Void>{

    public RegistrationAsyncTask(Activity activity){

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... params) {
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
}
