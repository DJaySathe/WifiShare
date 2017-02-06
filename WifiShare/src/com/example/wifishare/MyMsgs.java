package com.example.wifishare;

import java.util.Random;

import android.R.color;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyMsgs extends Activity implements View.OnClickListener{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// ((MyApplication) this.getApplication()).isActivityPaused = false;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mymsgs);
		int count=((MyApplication) this.getApplication()).msgs.size();
		LinearLayout linear = (LinearLayout) findViewById(R.id.msgDisp);
		linear.setGravity(Gravity.CENTER_VERTICAL);
		Button[] btn = new Button[count];
		String[] id = new String[count];
		int i = 0;
		int col[]={Color.BLUE,Color.CYAN,Color.GRAY,Color.MAGENTA,Color.RED,Color.YELLOW,Color.WHITE};
		while (count > 0) {
			count--;

			btn[i] = new Button(getApplicationContext());
			btn[i].setText(((MyApplication) this.getApplication()).msgs.get(count).header);
			// btn[i].setTextColor(Color.parseColor("#000000"));
			btn[i].setTextSize(20);
			btn[i].setTag(((MyApplication) this.getApplication()).msgs.get(count).header);
			btn[i].setWidth(500);
			btn[i].setOnClickListener(this);
		    btn[i].setBackgroundColor(col[i]);
			linear.addView(btn[i]);
						i++;
		}
	}

	public void onClick(View v) {
		Intent intent = new Intent(this, NotificationMessages.class);
		Bundle Basket = new Bundle();
		String s = null;
		for (Message m1 : ((MyApplication) this.getApplication()).msgs) {
			if(m1.header.equals(v.getTag())){
				s=m1.message;
				
				break;
			}
		}
		Basket.putString("Body", s);
		intent.putExtras(Basket);
		startActivity(intent);
	}
}
