package com.example.wifishare;

import com.example.wifishare.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class WelcomeId extends Activity {
	TextView et1, et2;
	String domain;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcomeid);
		((MyApplication) this.getApplication()).isActivityPaused = false;
		et1 = (TextView) findViewById(R.id.UserName);
		et2 = (TextView) findViewById(R.id.LoginId);
		Bundle gotBasket = getIntent().getExtras();
		((MyApplication) this.getApplication()).setU_NAME(gotBasket
				.getString("uname"));
		((MyApplication) this.getApplication()).setU_id(gotBasket
				.getString("uid"));
		et2.setText(((MyApplication) this.getApplication()).getU_NAME());
		et1.setText("USER ID: "
				+ ((MyApplication) this.getApplication()).getU_id());
		domain = ((MyApplication) this.getApplication()).getD_id();

		Thread timer = new Thread() {
			public void run() {
				try {
					sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					if (domain.equalsIgnoreCase("1")) {
						Intent a = new Intent(WelcomeId.this, IdHome_hosp.class);
						startActivity(a);
					}
					if (domain.equalsIgnoreCase("2")) {
						Intent a = new Intent(WelcomeId.this, IdHome_coll.class);
						startActivity(a);
					}
					if (domain.equalsIgnoreCase("3")) {
						Intent a = new Intent(WelcomeId.this, IdHome_mall.class);
						startActivity(a);
					}
				}
			}
		};
		timer.start();
	}

}
