package com.example.wifishare;

import java.util.List;

import com.example.wifishare.R;

import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class WifiShareMain extends Activity {
	private static final String MY_DB = null;
	Button serverConn, BrowseOffline;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		serverConn = (Button) findViewById(R.id.conn);
	//	BrowseOffline = (Button) findViewById(R.id.prescription);
		((MyApplication) this.getApplication()).isActivityPaused = false;
//		((MyApplication) this.getApplication()).SerIP = getIpAddr();
		TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
		((MyApplication) this.getApplication()).IMEI = tm.getDeviceId();
		serverConn.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
//				 WifiManager wifiManager = (WifiManager) getBaseContext()
//				 .getSystemService(Context.WIFI_SERVICE);
//				 wifiManager.setWifiEnabled(true);
//				
//				 String networkSSID = "BlueShareServer";
//				 String networkPass = "12345678";
//				
//				 WifiConfiguration conf = new WifiConfiguration();
//				 conf.SSID = "\"" + networkSSID + "\"";
//				 conf.preSharedKey = "\"" + networkPass + "\"";
//				 wifiManager.addNetwork(conf);
//				 List<WifiConfiguration> list = wifiManager
//				 .getConfiguredNetworks();
//				 for (WifiConfiguration i : list) {
//				 if (i.SSID != null
//				 && i.SSID.equals("\"" + networkSSID + "\"")) {
//				 wifiManager.disconnect();
//				 wifiManager.enableNetwork(i.networkId, true);
//				 wifiManager.reconnect();
//				
//				 break;
//				 }
//				 }

				Intent a = new Intent(WifiShareMain.this, Welcome.class);
				startActivity(a);
			}
		});
		// Thread timer = new Thread() {
		// public void run() {
		// try {
		// sleep(5000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } finally {
		// Intent a = new Intent(EasyShareMain.this, Welcome.class);
		// startActivity(a);
		// }
		// }
		// };
		// timer.start();
		//
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

	public String getIpAddr() {
		WifiManager wifiManager = (WifiManager) getSystemService(WIFI_SERVICE);
		WifiInfo wifiInfo = wifiManager.getConnectionInfo();
		int ip = wifiInfo.getIpAddress();

		String ipString = String.format("%d.%d.%d.%d", (ip & 0xff),
				(ip >> 8 & 0xff), (ip >> 16 & 0xff), 1);

		return ipString;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}