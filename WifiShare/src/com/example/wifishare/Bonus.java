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

public class Bonus extends Activity{
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		 setContentView(R.layout.bonus);
		 Socket socket = null;
		 DataOutputStream dataOutputStream = null;
		 DataInputStream dataInputStream = null;
		 ((MyApplication) this.getApplication()).isActivityPaused = false; 
		 TextView t1;
		 t1= (TextView)findViewById(R.id.textView2);
		
		
		 try {
			socket = new Socket(((MyApplication) this.getApplication()).SerIP,
					8888);
		  dataOutputStream = new DataOutputStream(socket.getOutputStream());
		  dataInputStream = new DataInputStream(socket.getInputStream());
		
		  dataOutputStream.writeUTF("select option_1 from user_table where U_ID="+((MyApplication) this.getApplication()).getU_id());
		
		  
		int count= dataInputStream.readInt();
		String s1="\n";
	
		while(count>0)
		{
			s1=s1+dataInputStream.readUTF()+"\n";
			t1.setText(s1);
			
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