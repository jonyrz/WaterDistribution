package itq.dist;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import itq.dist.*;

public class DisThread {

	private static final Logger logger = LogManager.getLogger(DisThread.class);
	private static final int PORT = 2000;


	public static void main(String[] args) {
		
		boolean alive = true;
		java.net.ServerSocket serverSocket;
		Tank[] tanks = new Tank[3];
		tanks[0]= new Tank(10000f,1,10000f);
		tanks[1]= new Tank(20000f,2,20000f);
		tanks[2]= new Tank(3000f,3,3000f);
		

		try {
			serverSocket = new ServerSocket(PORT);
			logger.debug(" Puerto utilizado : "+PORT);
			try {
				while(alive) {
					Socket socket = serverSocket.accept();
					DisThread t_disthread = new DisThread();
					t_disthread.start();
				}	
			serverSocket.close();			
				}catch(Exception e) {
					e.printStackTrace();
					logger.error("Ocurrio un error con el servidor");
					logger.error(e.getMessage());
				}		
			}catch(IOException e) {
				e.printStackTrace();
				logger.error("Puerto ocupado: "+PORT+" (1)");
				logger.error(e.getMessage());
			}
		}

}
