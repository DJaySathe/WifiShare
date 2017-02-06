package com.example.wifishare;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.example.wifishare.R;

import android.R.color;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager.LayoutParams;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Prescription extends Activity implements View.OnClickListener {
	Socket socket = null;
	DataOutputStream dataOutputStream = null;
	DataInputStream dataInputStream = null;

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.prescription);
		((MyApplication) this.getApplication()).isActivityPaused = false;
		TextView t6 = (TextView) findViewById(R.id.Uname);
		TextView t7 = (TextView) findViewById(R.id.Uid);
		try {
			socket = new Socket(((MyApplication) this.getApplication()).SerIP,
					8888);
			dataOutputStream = new DataOutputStream(socket.getOutputStream());
			dataInputStream = new DataInputStream(socket.getInputStream());
			dataOutputStream.writeUTF("select prescription_ID from prescription_table where U_ID="+ ((MyApplication) this.getApplication()).getU_id());
			// +"and D_ID="+((MyApplication) this.getApplication()).getD_id());
			LinearLayout linear = (LinearLayout) findViewById(R.id.prescriptions);
			linear.setGravity(Gravity.CENTER_VERTICAL);
			int count = dataInputStream.readInt();
			Button[] btn = new Button[count];
			String[] id = new String[count];
			int i = 0;
			while (count > 0) {
				btn[i] = new Button(getApplicationContext());
				String s = dataInputStream.readUTF();
				btn[i].setText("Prescription " + s);
				// btn[i].setTextColor(Color.parseColor("#000000"));
				btn[i].setTextSize(40);
				btn[i].setTag(s);
				btn[i].setWidth(500);
				btn[i].setGravity( Gravity.CENTER_HORIZONTAL);
				linear.addView(btn[i]);
				btn[i].setOnClickListener(this);
				count--;
				i++;
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
		try {
			socket = new Socket(((MyApplication) this.getApplication()).SerIP,
					8888);
			dataOutputStream = new DataOutputStream(socket.getOutputStream());
			dataInputStream = new DataInputStream(socket.getInputStream());
			dataOutputStream
					.writeUTF("select USER_NAME,U_ID from USER_TABLE where U_ID="
							+ ((MyApplication) this.getApplication()).getU_id());

			int count = dataInputStream.readInt();
			t6.setText("User Name:" + dataInputStream.readUTF());
			t7.setText("User ID :" + dataInputStream.readUTF());
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

	public void onClick(View v) {
		try {
			socket = new Socket(((MyApplication) this.getApplication()).SerIP,
					8888);
			dataOutputStream = new DataOutputStream(socket.getOutputStream());
			dataInputStream = new DataInputStream(socket.getInputStream());
			String s = v.getTag().toString();
			dataOutputStream
					.writeUTF("SELECT Medicine_ID,Medicine_Name,Dosage,Frequency FROM medicine_table where prescription_ID="
							+ s.replace("Prescription ", ""));
			int count = dataInputStream.readInt();
			String s1 = "No Med Dosage Freq \n ";
			TextView t1 = (TextView) findViewById(R.id.presDetail);
			while (count > 0) {
				s1 = s1 + dataInputStream.readUTF() + "   "
						+ dataInputStream.readUTF() + "    "
						+ dataInputStream.readUTF() + "     "
						+ dataInputStream.readUTF() + "\n";
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