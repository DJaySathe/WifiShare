package com.example.wifishare;

import android.app.Activity;
import android.app.NotificationManager;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;

public class Download extends Activity {
	Button b1;
	NotificationManager nm;

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		((MyApplication) this.getApplication()).isActivityPaused = false;
		setContentView(R.layout.download);
		 WebView mapview = (WebView)findViewById(R.id.webpg1);
		 mapview.loadUrl("http://192.168.89.1:8080/page");
	}
}