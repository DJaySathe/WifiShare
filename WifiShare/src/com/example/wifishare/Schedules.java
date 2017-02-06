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
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

public class Schedules extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		((MyApplication) this.getApplication()).isActivityPaused = false;
		setContentView(R.layout.schedule);
		Socket socket = null;
		DataOutputStream dataOutputStream = null;
		DataInputStream dataInputStream = null;

		try {
			socket = new Socket(((MyApplication) this.getApplication()).SerIP,
					8888);
			dataOutputStream = new DataOutputStream(socket.getOutputStream());
			dataInputStream = new DataInputStream(socket.getInputStream());

			dataOutputStream
					.writeUTF("SELECT `NAME`,inTime,OUTTIME,Days FROM schedule_table where D_ID="
							+ ((MyApplication) this.getApplication()).getD_id()
							+ " and name is not null");
			int count = dataInputStream.readInt();
			String s1 = "              ";
			TextView t1 = (TextView) findViewById(R.id.schedule);
			while (count > 0) {
				s1 = s1 + dataInputStream.readUTF() + "\n"
						+ "  Arrival/Opening   " + "     "
						+ dataInputStream.readUTF() + "\n"
						+ "Departure/Closing " + "     "
						+ dataInputStream.readUTF() + "\n"
						+ "      Days   " + "                   "
						+ dataInputStream.readUTF() + "\n\n"+"              ";
				count--;
			}
			t1.setText(s1);
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
