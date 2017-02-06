package master.servers;

import java.io.DataInputStream;
import java.util.Scanner;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;

public class Notifier {
	static String s = "HI";

	public static void main(String[] args) throws SQLException {

		System.out.println("MySQL Connect Example.");
		Connection conn = null;
		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost/test",
					"root", "admin");
			System.out.println("Connected to the database");
		} catch (Exception e) {
			e.printStackTrace();
		}

		ServerSocket serverSocket = null;
		Socket socket = null;
		DataInputStream dataInputStream = null;
		DataOutputStream dataOutputStream = null;

		try {
			serverSocket = new ServerSocket(8000);
			System.out.println("Listening :8000");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while (true) {
			try {
				socket = serverSocket.accept();
				dataInputStream = new DataInputStream(socket.getInputStream());
				dataOutputStream = new DataOutputStream(
						socket.getOutputStream());
				System.out.println("ip: " + socket.getInetAddress());
				new Thread(new Runnable() {
					public void run() {
						while (true) {
							Scanner in = new Scanner(System.in);
							s = in.nextLine();
						}
					}
				}).start();
				String a;
				while (true) {
					dataOutputStream.writeUTF(s);

					// System.out.println("Iam sending");
					a = dataInputStream.readUTF();

					// System.out.println(a);

				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (socket != null) {
					try {
						socket.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
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
}