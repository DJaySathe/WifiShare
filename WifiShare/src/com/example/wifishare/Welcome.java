package com.example.wifishare;

import java.lang.Thread.State;

import com.example.wifishare.R;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;

public class Welcome extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);
		if(((MyApplication)this.getApplication()).T.getState()==State.TERMINATED){
		((MyApplication)this.getApplication()).T.start();
		}else {
			((MyApplication)this.getApplication()).T.stop();
			((MyApplication)this.getApplication()).T.start();
		}
		Thread timer = new Thread() {
			public void run() {

				try {

					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					Intent a = new Intent(Welcome.this, DomainSel.class);
					startActivity(a);
				}
			}
		};
		timer.start();

	}
	


	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		if(((MyApplication)this.getApplication()).T.getState()==State.TERMINATED){
			((MyApplication)this.getApplication()).T.start();
			}else {
				((MyApplication)this.getApplication()).T.stop();
				((MyApplication)this.getApplication()).T.start();
			}
	}
}


