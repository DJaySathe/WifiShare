package com.example.wifishare;

import com.example.wifishare.R;

import android.app.Activity;
import android.os.Bundle;

public class Med extends Activity{
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		((MyApplication) this.getApplication()).isActivityPaused = false; 
		 setContentView(R.layout.med);
	}

}

