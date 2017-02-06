package master.servers;

import java.awt.EventQueue;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;

import master.servers.AppContextBuilder;
import master.servers.JettyServer;
import master.servers.ServerRunner;

public class JettyFromMain {
    public final JettyServer jettyServer;
    public JettyFromMain() {
        ContextHandlerCollection contexts = new ContextHandlerCollection();

		contexts.setHandlers(new Handler[] { new AppContextBuilder().buildWebAppContext()});

		jettyServer = new JettyServer();
		jettyServer.setHandler(contexts);
		Runnable runner = new Runnable() {
			@Override
			public void run() {
				new ServerRunner(jettyServer);
			}
		};
		EventQueue.invokeLater(runner);
    }

    public JettyServer getJettyServer() {
        return jettyServer;
    }
    


//	public static void main(String[] args) {
//		ContextHandlerCollection contexts = new ContextHandlerCollection();
//
//		contexts.setHandlers(new Handler[] { new AppContextBuilder().buildWebAppContext()});
//
//		final JettyServer jettyServer = new JettyServer();
//		jettyServer.setHandler(contexts);
//		Runnable runner = new Runnable() {
//			@Override
//			public void run() {
//				new ServerRunner(jettyServer);
//			}
//		};
//		EventQueue.invokeLater(runner);
//	}
}
