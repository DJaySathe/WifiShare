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
import android.widget.TextView;

public class Feedback extends Activity {
	Button sendfeedback;
	EditText feedback;
	TextView imei, id,result;
	Socket socket = null;
	String ip;
	DataOutputStream dataOutputStream = null;
	DataInputStream dataInputStream = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		((MyApplication) this.getApplication()).isActivityPaused = false;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.feedback);
		final String D_id = ((MyApplication) this.getApplication()).getD_id();
		String Imei = ((MyApplication) this.getApplication()).IMEI;
		final String U_id = ((MyApplication) this.getApplication()).getU_id();
		feedback = (EditText) findViewById(R.id.editText1);
		sendfeedback = (Button) findViewById(R.id.send);
		imei = (TextView) findViewById(R.id.imei);
		id = (TextView) findViewById(R.id.id);
		result = (TextView) findViewById(R.id.result);
		imei.setText(Imei);
		id.setText(U_id);
		
		ip=((MyApplication) this.getApplication()).SerIP;
		sendfeedback.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				try {
					socket = new Socket(ip,
							8888);
					
					dataOutputStream = new DataOutputStream(socket
							.getOutputStream());
					dataInputStream = new DataInputStream(socket
							.getInputStream());
					dataOutputStream
							.writeUTF("insert INTO `feedback_table` (`D_ID`, `U_ID`, `FEEDBACK`) VALUES ('"
									+ D_id
									+ "', '"
									+ U_id
									+ "', '"
									+ feedback.getText() + "')");
					
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
				
				result.setText("Feedback Sent Sucessfully");
			}
		});
	}
}
