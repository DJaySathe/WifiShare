package com.example.wifishare;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import com.example.wifishare.R;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.Settings.System;
import android.support.v4.view.ViewPager.LayoutParams;
import android.text.Layout;
import android.text.format.Time;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class Notification extends Activity {
	Button b1;
	NotificationManager nm;

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Socket socket = null;
		DataOutputStream dataOutputStream = null;
		((MyApplication) this.getApplication()).isActivityPaused = false;
		DataInputStream dataInputStream = null;
		setContentView(R.layout.notification);
		 WebView mapview = (WebView)findViewById(R.id.webpg1);
//		 mapview.loadUrl("http://192.168.54.1:8080/page/Noticeboard/main.html");
		 try {
				socket = new Socket(((MyApplication) this.getApplication()).SerIP, 8888);
				dataOutputStream = new DataOutputStream(socket.getOutputStream());
				dataInputStream = new DataInputStream(socket.getInputStream());
				dataOutputStream
						.writeUTF("select NoticeBoard from Noticeboard_table where D_ID="
								+ ((MyApplication) this.getApplication()).getD_id());
				android.widget.LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 1.0f);

				int count = dataInputStream.readInt();
				mapview.loadUrl("http://192.168.89.1:8080"
						+ dataInputStream.readUTF());

			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (socket != null) {
					try {
						socket.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				if (dataOutputStream != null) {
					try {
						dataOutputStream.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				if (dataInputStream != null) {
					try {
						dataInputStream.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
	}
}