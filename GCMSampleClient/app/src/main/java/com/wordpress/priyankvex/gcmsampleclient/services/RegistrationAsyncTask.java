package com.wordpress.priyankvex.gcmsampleclient.services;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;
import com.wordpress.priyankvex.gcmsampleclient.Config;
import com.wordpress.priyankvex.gcmsampleclient.MainActivity;
import com.wordpress.priyankvex.gcmsampleclient.R;

import java.io.IOException;

/**
 * Created by Priyank(@priyankvex) on 9/9/15.
 *
 * Async Task to get the token from GCM server and send it to the application server.
 */
public class RegistrationAsyncTask extends AsyncTask<Void, Void, Void>{

    Activity mActivity;
    ProgressDialog mProgressDialog;
    String token;

    public RegistrationAsyncTask(Activity activity){
        mActivity = activity;
        if (activity != null){
            mProgressDialog = new ProgressDialog(activity);
            mProgressDialog.setMessage("Registering...");
            mProgressDialog.setCancelable(false);
        }

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (mProgressDialog != null) mProgressDialog.show();
    }

    @Override
    protected Void doInBackground(Void... params) {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mActivity);

        try {
            // Get the token from GCM server.
            InstanceID instanceID = InstanceID.getInstance(mActivity);
            token = instanceID.getToken(mActivity.getString(R.string.gcm_sender_id),
                    GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);

            Log.i("test", "GCM Registration Token: " + token);

            // TODO: Implement this method to send any registration to your app's servers.
            //sendRegistrationToServer(token);

            // Storing that the token has already been sent.
            sharedPreferences.edit().putBoolean(Config.KEY_TOKEN_SENT_TO_SEVER, true).apply();

        } catch (Exception e) {
            Log.d("test", "Failed to complete token refresh", e);
            // If an exception happens while fetching the new token or updating our registration data
            // on a third-party server, this ensures that we'll attempt the update at a later time.
            sharedPreferences.edit().putBoolean(Config.KEY_TOKEN_SENT_TO_SEVER, false).apply();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if (mProgressDialog != null) mProgressDialog.dismiss();
        ((MainActivity)mActivity).updateMessage("Device Token : " + token);
    }



}
