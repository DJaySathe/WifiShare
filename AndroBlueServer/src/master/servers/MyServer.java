package master.servers;

import java.io.DataInputStream;
import java.util.ArrayList;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;

public class MyServer {

	public static void main(String[] args) throws SQLException {

//		System.out.println("MySQL Connect Example.");
		Connection conn = null;
		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost/test",
					"root", "admin");
			System.out.println("Connected to the database");
		} catch (Exception e) {
//			e.printStackTrace();
		}

		ServerSocket serverSocket = null;
		Socket socket = null;
		DataInputStream dataInputStream = null;
		DataOutputStream dataOutputStream = null;

		try {
			serverSocket = new ServerSocket(8888);
			System.out.println("Listening :8888");
		} catch (IOException e) {
//			e.printStackTrace();
		}

		while (true) {
			try {
				socket = serverSocket.accept();
				dataInputStream = new DataInputStream(socket.getInputStream());
				dataOutputStream = new DataOutputStream(
						socket.getOutputStream());
				System.out.println("ip: " + socket.getInetAddress());
				Statement statement = conn.createStatement();

				String string = dataInputStream.readUTF();
				if (string != "") {
					ResultSet rs = statement.executeQuery(string);
					int count = 0;

					while (rs.next()) {
						++count;
						// Get data from the current row and use it
					}
					statement.close();
					statement = conn.createStatement();
					rs = statement.executeQuery(string);
					System.out.println(count);
					dataOutputStream.writeInt(count);
					ResultSetMetaData rsmd = rs.getMetaData();

					int columnsNumber = rsmd.getColumnCount();
					System.out.println("No of coloumns" + columnsNumber);

					int i = 1;
					ArrayList<String> arrayList = new ArrayList<String>();
					while (rs.next()) {

						i = 1;
						while (i <= columnsNumber) {
							arrayList.add(rs.getString(i));
							//
							i++;
						}
					}
					// dataOutputStream.writeUTF(Bloodgrp);
					// dataOutputStream.writeUTF(Address);
					// dataOutputStream.writeUTF(Phone);
					int totalElements = arrayList.size();

					System.out.println("ArrayList contains...");
					// loop through it
					for (int index = 0; index < totalElements; index++) {
						System.out.println(arrayList.get(index));
						dataOutputStream.writeUTF(arrayList.get(index));

					}

					// System.out.println(s);
					// Scanner in = new Scanner(System.in);
					// s = in.nextLine();

					// dataOutputStream.writeUTF(s);
				}

			} catch (IOException e) {
//				e.printStackTrace();
			} finally {
				if (socket != null) {
					try {
						socket.close();
					} catch (IOException e) {
//						e.printStackTrace();
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