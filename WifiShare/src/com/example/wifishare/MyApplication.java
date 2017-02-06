package com.example.wifishare;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.PublicKey;
import java.util.ArrayList;

import com.example.wifishare.R;
import android.app.Application;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.SystemClock;

public class MyApplication extends Application {

	private String U_id;
	private String D_id;
	private String U_NAME;
	private String D_NAME;
	NotificationManager nm;
	public String IMEI=null;
	public String SerIP ="192.168.89.1" ;
	private static final int UniqueId = 136;
	boolean isActivityPaused = false;
	public static ArrayList<Message> msgs;
	static{
		msgs=new ArrayList<Message>();
	}
	Thread T = new Thread(new Runnable() {
		public void run() {
			while (true)
				while (!isActivityPaused) {
					Socket socket = null;
					DataOutputStream dataOutputStream = null;
					DataInputStream dataInputStream = null;
					String title = "abc";
					String body = "abc";
					int Id=0;
					try {
						socket = new Socket(SerIP, 8000);
						dataOutputStream = new DataOutputStream(
								socket.getOutputStream());
						dataInputStream = new DataInputStream(
								socket.getInputStream());
						while (true) {
							title = dataInputStream.readUTF();
							body = dataInputStream.readUTF();
							if (!title.equalsIgnoreCase("abc")) {
								if (!body.equalsIgnoreCase("abc")) {

									doit(Id,title, body);
									title = "abc";
									body = "abc";
									break;
								}
							}
						}
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
	});

	public void doit(int Id,CharSequence title, CharSequence body) {
		nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		Intent intent = new Intent(this, NotificationMessages.class);
		Bundle Basket = new Bundle();
		Basket.putString("Body", (String) body);
		intent.putExtras(Basket);
		PendingIntent pi = PendingIntent.getActivity(this, 0, intent,
				PendingIntent.FLAG_UPDATE_CURRENT);
		// String body = " O+ Blood Required in Ward No 28...!!! Pls Help";
		// String title = "Blood Alert";
		android.app.Notification n = new android.app.Notification(
				R.drawable.notification, title,
				SystemClock.currentThreadTimeMillis()*1000);
		n.setLatestEventInfo(this, title, body, pi);
		n.defaults = android.app.Notification.DEFAULT_ALL;
		n.flags |= n.FLAG_AUTO_CANCEL;
		nm.notify(UniqueId, n);
		isActivityPaused = true;
	}

	public String getD_NAME() {
		return D_NAME;
	}

	public void setD_NAME(String d_NAME) {
		D_NAME = d_NAME;
	}

	public String getU_id() {
		return U_id;
	}

	public void setU_id(String u_id) {
		U_id = u_id;
	}

	public String getD_id() {
		return D_id;
	}

	public void setD_id(String d_id) {
		D_id = d_id;
	}

	public String getU_NAME() {
		return U_NAME;
	}

	public void setU_NAME(String u_NAME) {
		U_NAME = u_NAME;
	}
}
