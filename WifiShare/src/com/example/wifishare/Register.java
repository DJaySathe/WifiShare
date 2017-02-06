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
import android.widget.RadioButton;

public class Register extends Activity {
	Button b1;
	EditText et1, et2, et3, et4, et5, et6;
	RadioButton r1, r2;
	Intent a;
	Socket socket = null;
	String D_id, imei;
	DataOutputStream dataOutputStream = null;
	DataInputStream dataInputStream = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		((MyApplication) this.getApplication()).isActivityPaused = false;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		D_id = ((MyApplication) this.getApplication()).getD_id();
		imei = ((MyApplication) this.getApplication()).IMEI;
		et1 = (EditText) findViewById(R.id.editText1);
		et2 = (EditText) findViewById(R.id.editText2);
		et3 = (EditText) findViewById(R.id.editText3);
		et4 = (EditText) findViewById(R.id.editText4);
		et5 = (EditText) findViewById(R.id.editText5);
		et6 = (EditText) findViewById(R.id.editText6);
		r1 = (RadioButton) findViewById(R.id.radioButton1);
		r2 = (RadioButton) findViewById(R.id.radioButton2);
		b1 = (Button) findViewById(R.id.button1);

		try {
			socket = new Socket(((MyApplication) this.getApplication()).SerIP,
					8888);
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		b1.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				try {

					dataOutputStream = new DataOutputStream(socket
							.getOutputStream());
					dataInputStream = new DataInputStream(socket
							.getInputStream());
//					int i = Integer.parseInt(et1.getText().toString());
					String temp="insert into user_table(GENDER,B_GROUP,ADDRESS,PHONE_NO,DOB,User_NAME,D_ID,U_ID) VALUES('Male','o+ve',9423635252,'02/05/1992','"+ et1.getText() +"',"+ D_id+","+ imei+")";
					dataOutputStream
							.writeUTF(temp);
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

				a = new Intent(Register.this, Login.class);

				startActivity(a);

			}
		});
	}
}
