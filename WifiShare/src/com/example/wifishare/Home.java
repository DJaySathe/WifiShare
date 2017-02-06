package com.example.wifishare;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.example.wifishare.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager.LayoutParams;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Home extends Activity implements View.OnClickListener {
	ImageButton b1, b2, b3, b4;
	String s;
	TextView mar, Dname;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		((MyApplication) this.getApplication()).isActivityPaused = false;
		setContentView(R.layout.homepage);
		Socket socket = null;
		DataOutputStream dataOutputStream = null;
		DataInputStream dataInputStream = null;

		b1 = (ImageButton) findViewById(R.id.button3);
		b2 = (ImageButton) findViewById(R.id.button2);
		b3 = (ImageButton) findViewById(R.id.button4);
		b4 = (ImageButton) findViewById(R.id.button1);
		mar = (TextView) findViewById(R.id.MarqueeText);
		Dname = (TextView) findViewById(R.id.Dname);
		try {
			socket = new Socket(((MyApplication) this.getApplication()).SerIP,
					8888);
			dataOutputStream = new DataOutputStream(socket.getOutputStream());
			dataInputStream = new DataInputStream(socket.getInputStream());
			dataOutputStream
					.writeUTF("select D_NAME from MASTER_TABLE where D_ID="
							+ ((MyApplication) this.getApplication()).getD_id());
			int count = dataInputStream.readInt();
			Dname.setText(dataInputStream.readUTF());

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
		try {
			socket = new Socket(((MyApplication) this.getApplication()).SerIP,
					8888);
			dataOutputStream = new DataOutputStream(socket.getOutputStream());
			dataInputStream = new DataInputStream(socket.getInputStream());
			dataOutputStream.writeUTF("select TIP from tips_table where D_ID="
					+ ((MyApplication) this.getApplication()).getD_id());
			android.widget.LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 1.0f);
			s = "";
			int count = dataInputStream.readInt();
			for (int i = 0; i < count; i++)
				s = s + "            " + dataInputStream.readUTF();

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
		mar.setText(s);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		b4.setOnClickListener(this);

	}

	public void onClick(View v) {

		Intent a1;
		switch (v.getId()) {
		case R.id.button3:
			a1 = new Intent(Home.this, Login.class);

			startActivity(a1);
			break;
		case R.id.button4:
			a1 = new Intent(Home.this, Maps.class);

			startActivity(a1);
			break;
		case R.id.button2:
			a1 = new Intent(Home.this, Schedules.class);

			startActivity(a1);

			break;
		case R.id.button1:
			a1 = new Intent(Home.this, Notification.class);
			startActivity(a1);

			break;
		}
	}
}
