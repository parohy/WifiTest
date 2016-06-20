package com.parohyapps.tomas.wifitest;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.wifi.WifiManager;
import android.widget.Toast;

/**
 * Created by tomas on 6/20/2016.
 */
public class WifiDialogOpen {

    public static AlertDialog build(final Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Enable wifi?");
        builder.setCancelable(false)
                .setMessage("You need enable wifi to continue.")
                .setPositiveButton("Enable", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ((WifiManager)context.getSystemService(Context.WIFI_SERVICE)).setWifiEnabled(true);
                        Toast.makeText(context, "Wifi enabled.", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Don't", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ((WifiManager)context.getSystemService(Context.WIFI_SERVICE)).setWifiEnabled(false);
                    }
                });

        return builder.create();
    }
}
