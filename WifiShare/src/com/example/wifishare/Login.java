package com.example.wifishare;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends Activity {
	Button b1;
	EditText et1, et2;
	Intent a;
	String ip;
	Socket socket = null;
	DataOutputStream dataOutputStream = null;
	DataInputStream dataInputStream = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		((MyApplication) this.getApplication()).isActivityPaused = false;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		b1 = (Button) findViewById(R.id.goId);
		final String j = ((MyApplication) this.getApplication()).getD_id();
		et1 = (EditText) findViewById(R.id.EditText01);
		et2 = (EditText) findViewById(R.id.Domaininput);
		ip = ((MyApplication) this.getApplication()).SerIP;
		// et1.setText(((MyApplication) this.getApplication()).IMEI);

		b1.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				Bundle Basket = null;

				String s = null;
				try {

					socket = new Socket(ip, 8888);
					dataOutputStream = new DataOutputStream(socket
							.getOutputStream());
					dataInputStream = new DataInputStream(socket
							.getInputStream());
					int i = Integer.parseInt(et1.getText().toString());
					dataOutputStream
							.writeUTF("select User_NAME from user_table where U_ID="
									+ i + " and D_ID=" + j);
					int count = dataInputStream.readInt();

					if (count != 0) {
						s = dataInputStream.readUTF();
					} else {
						s = "Incorrect ID";
						et1.setText(s);
					}
					Basket = new Bundle();
					Basket.putString("uname", s);
					Basket.putString("uid", et1.getText().toString());

				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if (socket != null) {
						try {
							socket.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}

					if (dataOutputStream != null) {
						try {
							dataOutputStream.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}

					if (dataInputStream != null) {
						try {
							dataInputStream.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}

				a = new Intent(Login.this, WelcomeId.class);
				a.putExtras(Basket);
				if (!s.equals("Incorrect ID"))
					startActivity(a);

			}
		});
	}
}
