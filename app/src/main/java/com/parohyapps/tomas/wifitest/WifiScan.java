package com.parohyapps.tomas.wifitest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.widget.Toast;

import java.util.List;

/**
 * Created by tomas on 6/20/2016.
 */
public class WifiScan extends AsyncTask<Void, String, Void> {

    private WifiManager wifiManager;
    private RecieverClass recieverClass;

    public WifiScan(Context context) {
        wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);

        if(wifiManager.getWifiState() == WifiManager.WIFI_STATE_DISABLED){
            WifiDialogOpen.build(context).show();
        }
        else{
            Toast.makeText(context, "Wifi enabled.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected Void doInBackground(Void... params) {
        recieverClass = RecieverClass.getInstance(wifiManager);

    }
}
