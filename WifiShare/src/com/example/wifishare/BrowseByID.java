package com.example.wifishare;

import java.io.DataInputStream;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.example.wifishare.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BrowseByID extends Activity {
	Button b1, b2;
	Intent a;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		((MyApplication) this.getApplication()).isActivityPaused = false;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.browser);
		b1 = (Button) findViewById(R.id.button1);
		b2 = (Button) findViewById(R.id.button2);
		b1.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				a = new Intent(BrowseByID.this, Login.class);
				startActivity(a);
			}
		});
		b2.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				a = new Intent(BrowseByID.this, Register.class);
				startActivity(a);

			}
		});

	}
}
