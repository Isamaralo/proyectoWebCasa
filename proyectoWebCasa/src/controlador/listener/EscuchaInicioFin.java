package controlador.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import controlador.ssh.ConexionSSH;

/**
 * Application Lifecycle Listener implementation class EscuchaInicioFin
 *
 */
@WebListener
public class EscuchaInicioFin implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public EscuchaInicioFin() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	ConexionSSH.desconectate_D_SSH();
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	try {
			ConexionSSH.conectate_A_SSH();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
}