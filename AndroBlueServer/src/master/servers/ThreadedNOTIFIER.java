package master.servers;

import hospital.view.HospitalUI;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadedNOTIFIER extends Thread{
	private static int port = 8000, maxConnections = 0;

    public static void closeListener() {
        try {
            listener.close();
        } catch (IOException ex) {
            Logger.getLogger(ThreadedNOTIFIER.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ThreadedNOTIFIER(String name) {
        super(name);
    }
//    private Thread t;
    @Override
    public void run() {
//        t=currentThread();
        todo();
    }
// Listen for incoming connections and handle them
    static ServerSocket listener;

    private void todo() {
        int i = 0;

		try {
			listener = new ServerSocket(port);
			System.out.println("Listening :" + port);
			Socket server;

			while ((i++ < maxConnections) || (maxConnections == 0)) {
				server = listener.accept();
				NotiConn conn_c = new NotiConn(server);
				Thread t = new Thread(conn_c);
				t.start();
			}
                        listener.close();
                        
		} catch (Exception ioe) {
            
//			System.out.println("IOException on socket listen: " + ioe);
//			ioe.printStackTrace();
		}
    }

}