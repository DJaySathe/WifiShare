package master.servers;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import master.servers.JettyServer;
/*start() and stop() method are written over here..*/
public class ServerStartStopActionListner implements ActionListener {

	private final JettyServer jettyServer;

	public ServerStartStopActionListner(JettyServer jettyServer) {
		this.jettyServer = jettyServer;
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		 JButton btnStartStop =  (JButton) actionEvent.getSource();
		 if(jettyServer.isStarted()){
			 btnStartStop.setText("Stopping...");
//			 btnStartStop.setCursor(new Cursor(Cursor.WAIT_CURSOR));
			 try {
				jettyServer.stop();
			} catch (Exception exception) {
//				exception.printStackTrace();
			}
			 btnStartStop.setText("Start");
//			 btnStartStop.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		 }
		 else if(jettyServer.isStopped()){
			 btnStartStop.setText("Starting...");
//			 btnStartStop.setCursor(new Cursor(Cursor.WAIT_CURSOR));
			 try {
				jettyServer.start();
			} catch (Exception exception) {
//				exception.printStackTrace();
			}
			 btnStartStop.setText("Stop");
//			 btnStartStop.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		 }
	}
}
