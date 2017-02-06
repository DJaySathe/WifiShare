package com.example.wifishare;

import com.example.wifishare.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageButton;

public class IdHome_hosp extends Activity implements View.OnClickListener {
	ImageButton b1, b2, b3, b4, b5;
	String id;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.idhome_hosp);
		((MyApplication) this.getApplication()).isActivityPaused = false;
		b1 = (ImageButton) findViewById(R.id.aboutme);
		b2 = (ImageButton) findViewById(R.id.prescription);
		b4 = (ImageButton) findViewById(R.id.money);
		b5 = (ImageButton) findViewById(R.id.mymsg);
		ImageButton b6 = (ImageButton) findViewById(R.id.feedback);
		ImageButton b7 = (ImageButton) findViewById(R.id.download);
		b5.setOnClickListener(this);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b4.setOnClickListener(this);
		b6.setOnClickListener(this);
		b7.setOnClickListener(this);
	}

	public void onClick(View v) { 
		  
	    	Intent a1;
	        switch(v.getId()) { 
	            case R.id.aboutme: 
	            	
	            	
	            	a1=new Intent(IdHome_hosp.this,MyDetails.class);
	            	
					startActivity(a1);
	            break; 
	            case R.id.prescription:
	            	a1=new Intent(IdHome_hosp.this,Prescription.class);
	            
					startActivity(a1);
	            break; 
	            case R.id.money: 
	            	a1=new Intent(IdHome_hosp.this,Estimate.class);
	            	
					startActivity(a1);
	            break; 
	            case R.id.mymsg:
	    			a1 = new Intent(IdHome_hosp.this, MyMsgs.class);

	    			startActivity(a1);
	    			break;
	            case R.id.feedback:
	    			a1 = new Intent(IdHome_hosp.this, Feedback.class);

	    			startActivity(a1);
	    			break;
	            case R.id.download:
	    			a1 = new Intent(IdHome_hosp.this,Download.class);

	    			startActivity(a1);
	    			break;
	    			
	        }
	    }}
