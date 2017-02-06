package com.example.wifishare;

import com.example.wifishare.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageButton;

public class IdHome_coll extends Activity implements View.OnClickListener  {
	ImageButton b1,b2,b3,b5;
	 String id;
	  
		

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		 setContentView(R.layout.idhome_coll);
		 ((MyApplication) this.getApplication()).isActivityPaused = false; 
		    b1=(ImageButton)findViewById(R.id.aboutme);
	        b2=(ImageButton)findViewById(R.id.noticeBoard);
	        b3=(ImageButton)findViewById(R.id.academics);
	        b5=(ImageButton)findViewById(R.id.mymsg);
	        b5.setOnClickListener(this); 
	        b1.setOnClickListener(this); 
	        b2.setOnClickListener(this); 
	        b3.setOnClickListener(this); 
	     
	}
	  public void onClick(View v) { 
		  
	    	Intent a1;
	        switch(v.getId()) { 
	            case R.id.aboutme: 
	            	
	            	
	            	a1=new Intent(IdHome_coll.this,MyDetails.class);
	            	
					startActivity(a1);
	            break; 
	            case R.id.noticeBoard:
	            	a1=new Intent(IdHome_coll.this,Notification.class);
	            
					startActivity(a1);
	            break; 
	            case R.id.academics:
	            	a1=new Intent(IdHome_coll.this,Academics.class);
	            
					startActivity(a1);
	            break; 
	            case R.id.msg:
	    			a1 = new Intent(IdHome_coll.this, MyMsgs.class);

	    			startActivity(a1);
	    			break;
	        }
	    } 
	

}
