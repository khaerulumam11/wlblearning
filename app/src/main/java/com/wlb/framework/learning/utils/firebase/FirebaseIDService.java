package com.wlb.framework.learning.utils.firebase;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.wlb.framework.learning.data.DataManager;

/**
 * Created by ThinkPad T430 on 16/11/2017.
 */
public class FirebaseIDService extends FirebaseMessagingService {
    private static final String TAG = "FirebaseIDService";
    private DataManager mDataManager;
    public FirebaseIDService() {
    }
    public FirebaseIDService(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    @Override
    public void onNewToken(String refreshedToken) {
        super.onNewToken(refreshedToken);
        Log.e("NEW_TOKEN", refreshedToken);
//        storeRegIdInPref(refreshedToken);
        if (refreshedToken != null || !refreshedToken.isEmpty()) {
            storeRegIdInPref(refreshedToken);
        }
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
    }

    private void storeRegIdInPref(String token) {
//            mDataManager.setFirebaseID(token);
    }

    private void CheckToken(String token) {
        boolean update_token = true;
        String token_old = mDataManager.getFirebaseTokenID().isEmpty() ? mDataManager.getFirebaseTokenID() : "";
        if (token_old.isEmpty()) {
            storeRegIdInPref(token);
        } else {
            if (token.equals(mDataManager.getFirebaseTokenID())) {
                /**
                 * Update Token Di Server
                 */
                Log.d(TAG, "reNewTokenOnServer");
            }
        }
    }
}