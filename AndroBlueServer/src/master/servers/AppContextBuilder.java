package master.servers;

import hospital.view.HospitalUI;
import java.io.File;
import java.io.FileOutputStream;
import org.eclipse.jetty.webapp.WebAppContext;

public class AppContextBuilder {
	
	private WebAppContext webAppContext;
	private static String dirPath;
	public WebAppContext buildWebAppContext(){
		webAppContext = new WebAppContext();
		webAppContext.setDescriptor(webAppContext + "/WEB-INF/web.xml");
		webAppContext.setResourceBase(".");
		webAppContext.setContextPath("/");
		webAppContext.setAttribute("webContext", webAppContext);
//                System.out.println(webAppContext.getAttributes());
                dirPath=webAppContext.getAttributes().toString();
                HospitalUI.setMapPath(dirPath);
//                File f= new File("c:\\mandar.txt");
//                try {
//                FileOutputStream outputStream=new FileOutputStream(f);
//                outputStream.write(webAppContext.getAttributes().toString().getBytes());
//            } catch (Exception e) {
//            }

		return webAppContext;
	}

    public static String getDirPath() {
        return dirPath;
    }

    public static void setDirPath(String dirPath1) {
        dirPath = dirPath1;
    }
        
}
