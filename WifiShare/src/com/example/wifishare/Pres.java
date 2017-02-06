package com.example.wifishare;

import com.example.wifishare.R;

import android.app.Activity;
import android.os.Bundle;

public class Pres extends Activity{
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		 setContentView(R.layout.prescription);
		 ((MyApplication) this.getApplication()).isActivityPaused = false; 
	}

}
