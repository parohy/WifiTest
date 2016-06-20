package com.parohyapps.tomas.wifitest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.util.Log;

import java.util.List;

/**
 * Created by tomas on 6/20/2016.
 */
public class RecieverClass extends BroadcastReceiver {
    private final static String TAG = RecieverClass.class.getSimpleName();

    private static RecieverClass reciever;
    private WifiManager manager;

    private int counter;

    public static RecieverClass getInstance(WifiManager manager){
        if(reciever == null){
            reciever = new RecieverClass();
        }

        reciever.setManager(manager);
        reciever.restratCounter();
        return reciever;
    }

    private void setManager(WifiManager manager) {
        this.manager = manager;
    }
    private void restratCounter(){
        counter = 0;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        List<ScanResult> results = manager.getScanResults();
        for(ScanResult result : results){
            Log.d(TAG, "Scan " + counter++ + ": " + result.SSID);
        }
    }


}
