package com.example.wifishare;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class NotificationMessages extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// ((MyApplication) this.getApplication()).isActivityPaused = false;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.msgs);
		TextView msg = (TextView) findViewById(R.id.msg);
		Bundle gotBasket = getIntent().getExtras();
		String s = gotBasket.getString("Body");
		String h;
		if(s.length()>20)
		 h =s.substring(0, 20);
		else{
			h=s;
			}
		
		Message m = new Message(h, s);
		msg.setText(s);
		boolean f = true;
		// int size=((MyApplication) this.getApplication()).msgs.size();
		for (Message m1 : ((MyApplication) this.getApplication()).msgs) {
			if (m1.header.equals(m.header)) {
				f = false;
			}
		}
		if (f){
			((MyApplication) this.getApplication()).msgs.add(m);
		}

	}
}
