package master.servers;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import master.servers.JettyServer;
import master.servers.ServerStartStopActionListner;
/* start-stop object is created here*/
public class ServerRunner{
	private static final long serialVersionUID = 8261022096695034L;
	
	private JButton btnStartStop;

	public ServerRunner(final JettyServer jettyServer) {
		
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			@Override
			public void run() {
				if(jettyServer.isStarted()) {
					try {
						jettyServer.stop();
					} catch (Exception exception) {
//						exception.printStackTrace();
					}
				}
			}
		},"Stop Jetty Hook")); 
	}
}

