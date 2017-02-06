package master.servers;
import java.io.DataInputStream;

import java.io.DataOutputStream;
import java.io.IOException;

import java.net.Socket;

import java.util.Scanner;

public class NotiConn implements Runnable {
	private Socket socket;
	static String s = "HI";
	String title = "abc";
	String body = "abc";

    public static String getS() {
        return s;
    }

    public static void setS(String s) {
        NotiConn.s = s;
    }
        
        
	NotiConn(Socket server) {
		this.socket = server;
	}

	public void run() {

		DataInputStream dataInputStream = null;
		DataOutputStream dataOutputStream = null;

		try {
			dataInputStream = new DataInputStream(socket.getInputStream());
			dataOutputStream = new DataOutputStream(socket.getOutputStream());
			System.out.println("ip: " + socket.getInetAddress());
			new Thread(new Runnable() {
				public void run() {
					while (true) {
						Scanner in = new Scanner(System.in);
						s = in.nextLine();
					}
				}
			}).start();
			while (true) {
				if (!s.equalsIgnoreCase("HI")) {
					title = "Message Alert";
					body = s;
				} else {
					title = "abc";
					body = "abc";
				}
				dataOutputStream.writeUTF(title);
				dataOutputStream.writeUTF(body);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (dataInputStream != null) {
				try {
					dataInputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (dataOutputStream != null) {
				try {
					dataOutputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}