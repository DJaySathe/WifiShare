package com.example.wifishare;

import java.io.DataInputStream;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.example.wifishare.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.support.v4.view.ViewPager.LayoutParams;

public class DomainSel extends Activity implements View.OnClickListener {
	Button b1, b2, b3;
	LinearLayout linear;
	Socket socket = null;
	DataOutputStream dataOutputStream = null;
	DataInputStream dataInputStream = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		((MyApplication) this.getApplication()).isActivityPaused = false;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.domainselect);
		((MyApplication) this.getApplication()).isActivityPaused = false;
		try {
			socket = new Socket(((MyApplication) this.getApplication()).SerIP,
					8888);
			dataOutputStream = new DataOutputStream(socket.getOutputStream());
			dataInputStream = new DataInputStream(socket.getInputStream());
			dataOutputStream.writeUTF("select D_NAME,D_ID from MASTER_TABLE");
			linear = (LinearLayout) findViewById(R.id.DomainBtns);
			linear.setGravity(Gravity.CENTER_VERTICAL);

			int count = dataInputStream.readInt();
			Button[] btn = new Button[count];
			String[] id = new String[count];
			String[] s = new String[count];
			int i = 0;
			while (count > 0) {
				btn[i] = new Button(getApplicationContext());
				s[i] = dataInputStream.readUTF();
				btn[i].setText(s[i]);
				id[i] = dataInputStream.readUTF();
				btn[i].setTextColor(Color.parseColor("#000000"));
				btn[i].setTextSize(40);
				btn[i].setTag(s);
				btn[i].setGravity(Gravity.CENTER_VERTICAL
						| Gravity.CENTER_HORIZONTAL);
				btn[i].setBackgroundResource(R.drawable.green);
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
			// ArrayAdapter<String> adapter=new
			// ArrayAdapter<String>(DomainSel.this,
			// android.R.layout.simple_list_item_1,s);
			// grid.setAdapter(adapter);
		}

	}

	@Override
	protected void onResume() {
		super.onCreate(null);
		setContentView(R.layout.domainselect);
		try {
			socket = new Socket(((MyApplication) this.getApplication()).SerIP,
					8888);
			dataOutputStream = new DataOutputStream(socket.getOutputStream());
			dataInputStream = new DataInputStream(socket.getInputStream());
			dataOutputStream.writeUTF("select D_NAME,D_ID from MASTER_TABLE");
			linear = (LinearLayout) findViewById(R.id.DomainBtns);
			linear.setGravity(Gravity.CENTER_VERTICAL);
			int count = dataInputStream.readInt();
			Button[] btn = new Button[count];
			String[] id = new String[count];
			int i = 0;
			while (count > 0) {
				btn[i] = new Button(getApplicationContext());
				String s = dataInputStream.readUTF();
				btn[i].setText(s);
				id[i] = dataInputStream.readUTF();
				btn[i].setTextColor(Color.parseColor("#000000"));
				btn[i].setTextSize(40);
				btn[i].setTag(s);
				btn[i].setGravity(Gravity.CENTER_VERTICAL
						| Gravity.CENTER_HORIZONTAL);
				btn[i].setBackgroundResource(R.drawable.green);
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

		super.onResume();
	}

	@Override
	protected void onRestart() {
		super.onCreate(null);
		setContentView(R.layout.domainselect);
		try {
			socket = new Socket(((MyApplication) this.getApplication()).SerIP,
					8888);
			dataOutputStream = new DataOutputStream(socket.getOutputStream());
			dataInputStream = new DataInputStream(socket.getInputStream());
			dataOutputStream.writeUTF("select D_NAME,D_ID from MASTER_TABLE");
			linear = (LinearLayout) findViewById(R.id.DomainBtns);
			linear.setGravity(Gravity.CENTER_VERTICAL);
			int count = dataInputStream.readInt();
			Button[] btn = new Button[count];
			String[] id = new String[count];
			int i = 0;
			while (count > 0) {
				btn[i] = new Button(getApplicationContext());
				String s = dataInputStream.readUTF();
				btn[i].setText(s);
				id[i] = dataInputStream.readUTF();
				btn[i].setTextColor(Color.parseColor("#000000"));
				btn[i].setTextSize(40);
				btn[i].setTag(s);
				btn[i].setGravity(Gravity.CENTER_VERTICAL
						| Gravity.CENTER_HORIZONTAL);
				btn[i].setBackgroundResource(R.drawable.green);
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

		super.onRestart();
	}

	public void onClick(View v) {
		((MyApplication) this.getApplication())
				.setD_NAME(v.getTag().toString());
		String s = null;
		try {
			socket = new Socket(((MyApplication) this.getApplication()).SerIP,
					8888);
			dataOutputStream = new DataOutputStream(socket.getOutputStream());
			dataInputStream = new DataInputStream(socket.getInputStream());
			dataOutputStream
					.writeUTF("select D_ID from MASTER_TABLE where D_NAME=\""
							+ v.getTag().toString() + "\"");
			linear = (LinearLayout) findViewById(R.id.DomainBtns);
			linear.setGravity(Gravity.CENTER_VERTICAL);
			android.widget.LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 1.0f);

			int count = dataInputStream.readInt();
			s = dataInputStream.readUTF();

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
		((MyApplication) this.getApplication()).setD_id(s);
		Intent a1 = new Intent(DomainSel.this, Home.class);
		startActivity(a1);
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			exitByBackKey();

			// moveTaskToBack(false);

			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	protected void exitByBackKey() {

		AlertDialog alertbox = new AlertDialog.Builder(this)
				.setMessage("Do you want to exit WifiShare?")
				.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {

							// do something when the button is clicked
							public void onClick(DialogInterface arg0, int arg1) {
								finish();
								// close();

							}
						})
				.setNegativeButton("No", new DialogInterface.OnClickListener() {

					// do something when the button is clicked
					public void onClick(DialogInterface arg0, int arg1) {
					}
				}).show();

	}
}
