package com.kidsloop.cordova.plugin;

import android.os.Build;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

public class CookiesSync extends CordovaPlugin {

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("sync")) {
            sync();
            callbackContext.success();
            return true;
        }

        return false;
    }

    public void sync() {
        cordova.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Log.d("CookiesSync", "CookieManager.getInstance().flush()");
                    CookieManager.getInstance().flush();
                } else {
                    Log.d("CookiesSync", "CookieManager.getInstance().sync()");
                    CookieSyncManager.getInstance().sync();
                }
            }
        });
    }
}
