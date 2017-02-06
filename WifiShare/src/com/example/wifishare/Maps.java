package com.example.wifishare;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.example.wifishare.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager.LayoutParams;
import android.webkit.WebView;
import android.widget.LinearLayout;

public class Maps extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.maps);
		Socket socket = null;
		DataOutputStream dataOutputStream = null;
		((MyApplication) this.getApplication()).isActivityPaused = false;
		DataInputStream dataInputStream = null;
		WebView mapview = (WebView) findViewById(R.id.webpg);
		try {
			socket = new Socket(((MyApplication) this.getApplication()).SerIP, 8888);
			dataOutputStream = new DataOutputStream(socket.getOutputStream());
			dataInputStream = new DataInputStream(socket.getInputStream());
			dataOutputStream
					.writeUTF("select D_MAP from MASTER_TABLE where D_ID="
							+ ((MyApplication) this.getApplication()).getD_id());
			android.widget.LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 1.0f);

			int count = dataInputStream.readInt();
			mapview.loadUrl("http://192.168.89.1:8080/page/"
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