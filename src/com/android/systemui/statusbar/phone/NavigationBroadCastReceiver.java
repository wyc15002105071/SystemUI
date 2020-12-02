package com.android.systemui.statusbar.phone;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class NavigationBroadCastReceiver extends BroadcastReceiver {
    private String TAG = "NavigationBroadCastReceiver";

    public NavigationBroadCastReceiver(PhoneStatusBar b){
        super();
    }

    public NavigationBroadCastReceiver(){
        super();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG,"recv action(internel class):android.intent.action.BroadCast_Nav");
    }
}
