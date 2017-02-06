package com.example.adityavd.androidprojects;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class WifiTest extends AppCompatActivity {

    WifiManager wm;
    WifiInfo wifi;
    BroadcastReceiver br;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_test);
        wm = (WifiManager) getSystemService(ContentProviderTest.WIFI_SERVICE);
        if (wm == null) {
            Toast.makeText(WifiTest.this, "OLD PHONE", Toast.LENGTH_SHORT).show();
        } else {
            if (!wm.isWifiEnabled()) {

                wm.setWifiEnabled(true);
            }
            wm.startScan();
            wifi = wm.getConnectionInfo();
            Toast.makeText(WifiTest.this, wifi.getSSID() + "\t" + wifi.getRssi() + "\t" + wifi.getBSSID(), Toast.LENGTH_SHORT).show();

            br = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    String action = intent.getAction();
                    if (action.equals(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION)) ;
                    {
                        List<ScanResult> l = wm.getScanResults();
                        String result = "";
                        for (ScanResult s : l) {
                            result = result + s.SSID + "||" + s.BSSID + "||" + s.level;
                            Toast.makeText(WifiTest.this, result, Toast.LENGTH_SHORT).show();
                        }
                    }
                }

            };

        }
        IntentFilter ifr = new IntentFilter((WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
        registerReceiver(br, ifr);
    }

    @Override
    protected void onStop() {
        super.onStop();
    unregisterReceiver(br);
    }
}
