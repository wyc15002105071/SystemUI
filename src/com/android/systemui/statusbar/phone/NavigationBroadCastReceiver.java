package com.android.systemui.statusbar.phone;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class NavigationBroadCastReceiver extends BroadcastReceiver {
    private String TAG = "NavigationBroadCastReceiver";
    private PhoneStatusBar mPhoneStatusBar = null;
    private boolean flag = true;
    public NavigationBroadCastReceiver(PhoneStatusBar b){
        super();
        mPhoneStatusBar = b;
    }

    public NavigationBroadCastReceiver(){
        super();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if(flag == false)return;
        flag = false;
        Log.d(TAG,"recv action(internel class):android.intent.action.BroadCast_Nav");
        if(mPhoneStatusBar == null)
            return;
        if(mPhoneStatusBar.getNavigationStatus()){
            mPhoneStatusBar.closeNavigationBar();
        }else{
            mPhoneStatusBar.showNavigationBar();
        }
        flag = true;
    }
}
