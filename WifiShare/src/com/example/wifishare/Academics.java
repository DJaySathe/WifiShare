package com.example.wifishare;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.example.wifishare.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Academics extends Activity{
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		 setContentView(R.layout.academics);
		 ((MyApplication) this.getApplication()).isActivityPaused = false; 
		 Socket socket = null;
		 DataOutputStream dataOutputStream = null;
		 DataInputStream dataInputStream = null;
		 TextView t1,t2,t3,t4,t5,t6,t7;
		 t1= (TextView)findViewById(R.id.textView2);
		 t2= (TextView)findViewById(R.id.textView4);
		 t3= (TextView)findViewById(R.id.textView6);
		
		 try {
		  socket = new Socket(((MyApplication) this.getApplication()).SerIP, 8888);
		  dataOutputStream = new DataOutputStream(socket.getOutputStream());
		  dataInputStream = new DataInputStream(socket.getInputStream());
		
		  dataOutputStream.writeUTF("select option_1,option_2,option_3 from user_table where U_ID="+((MyApplication) this.getApplication()).getU_id());
		
		  
		int count= dataInputStream.readInt();
		String s1="\n";
		String s2="\n";
		String s3="\n";
		while(count>0)
		{
			s1=s1+dataInputStream.readUTF()+"\n";
			t1.setText(s1);
			
			s2=s2+dataInputStream.readUTF()+"\n";
			t2.setText(s2);
			s3=s3+dataInputStream.readUTF()+"\n";
			t3.setText(s3);
			
			
			count--;
		}

		 
		 } catch (UnknownHostException e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
		 } catch (IOException e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
		 }
		 finally{
		  if (socket != null){
		   try {
		    socket.close();
		   } catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		   }
		  }

		  if (dataOutputStream != null){
		   try {
		    dataOutputStream.close();
		   } catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		   }
		  }

		  if (dataInputStream != null){
		   try {
		    dataInputStream.close();
		   } catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		   }
		  }
		 }
	}

}