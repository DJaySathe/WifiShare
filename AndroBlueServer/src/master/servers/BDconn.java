package master.servers;
import java.io.DataInputStream;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

class BDconn implements Runnable {
	private Socket server;

	BDconn(Socket server) {
		this.server = server;
	}

	public void run() {

		System.out.println("MySQL Connect Example.");
		Connection conn = null;
		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost/newdb",
					"root", "admin");
			System.out.println("Connected to the database");
		} catch (Exception e) {
			e.printStackTrace();
		}

		DataInputStream dataInputStream = null;
		DataOutputStream dataOutputStream = null;
		try {
			dataInputStream = new DataInputStream(server.getInputStream());
			dataOutputStream = new DataOutputStream(server.getOutputStream());
			System.out.println("ip: " + server.getInetAddress());
			Statement statement = conn.createStatement();

			String string = dataInputStream.readUTF();
				if (string != "") {
				if (string.contains("insert")) {
					int q=statement.executeUpdate(string);

				} else {
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

					int totalElements = arrayList.size();

					System.out.println("ArrayList contains...");
					// loop through it
					for (int index = 0; index < totalElements; index++) {
						System.out.println(arrayList.get(index));
						dataOutputStream.writeUTF(arrayList.get(index));

					}

				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (server != null) {
				try {
					server.close();
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