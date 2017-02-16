package controlador.listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import controlador.ssh.ConexionSSH;
import dao.MapaPatologias;
import dao.PatologiaDAO;
import dto.PatologiaDTO;

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
    	PatologiaDAO pdao = new PatologiaDAO();
    	MapaPatologias mp = new MapaPatologias();
    	HashMap<Integer, PatologiaDTO> hm  = new HashMap<Integer, PatologiaDTO>();
		List<PatologiaDTO> lista_pato = new ArrayList<PatologiaDTO>();
		
    	try {
			ConexionSSH.conectate_A_SSH();
			lista_pato = pdao.getListaPatologias();
			for (PatologiaDTO patologia : lista_pato) {
	 	    	hm.put(patologia.getId(), patologia);
	  	    }
			mp.setHm(hm);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
}
