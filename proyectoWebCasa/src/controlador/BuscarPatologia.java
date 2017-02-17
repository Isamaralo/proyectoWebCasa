package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.PatologiaDTO;
import servicios.PatologiaService;

/**
 * Servlet implementation class BuscarPatologia
 */
@WebServlet("/BuscarPatologia")
public class BuscarPatologia extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<PatologiaDTO> lista_patologias = new ArrayList<PatologiaDTO>(); 
	private HashMap<Integer, PatologiaDTO> hm = new HashMap<Integer, PatologiaDTO>();
	
	public HashMap<Integer, PatologiaDTO> getHm() {
		return hm;
	}

	public void setHm(HashMap<Integer, PatologiaDTO> hm) {
		this.hm = hm;
	}

	public List<PatologiaDTO> getLista_patologias() {
		return lista_patologias;
	}

	public void setLista_patologias(List<PatologiaDTO> lista_patologias) {
		this.lista_patologias = lista_patologias;
	}

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarPatologia() {
        super();
        // TODO Auto-generated constructor stub
    } 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		
		int idn = Integer.parseInt(id); 
		PatologiaService ps = new PatologiaService();
		//long tiempo_inicial = System.currentTimeMillis();
		PatologiaDTO patoDto = ps.buscarPatologiaPorId(idn);
		//response.getWriter().append(patoDto.toString());
		//long tiempo_final = System.currentTimeMillis();
		//long tiempo_empleado = tiempo_final-tiempo_inicial;
		//System.out.println(tiempo_inicial);
		
		switch (idn){
		case 1:
			request.setAttribute("queratocono", patoDto);
			request.getRequestDispatcher(".//html//queratocono.jsp").forward(request, response);
			break;
		case 2:
			request.setAttribute("glaucoma_abierto", patoDto);
			request.getRequestDispatcher(".//html//glaucoma.jsp").forward(request, response);
			break;
		case 3:
			request.setAttribute("glaucoma_cerrado", patoDto);
			request.getRequestDispatcher(".//html//glaucoma.jsp").forward(request, response);
			break;
		case 4:
			request.setAttribute("catarata", patoDto);
			request.getRequestDispatcher(".//html//catarata.jsp").forward(request, response);
			break;
		case 5:
			request.setAttribute("conjuntivitis", patoDto);
			request.getRequestDispatcher(".//html//conjuntivitis.jsp").forward(request, response);
			break;
		case 6:
			request.setAttribute("desprendimiento", patoDto);
			request.getRequestDispatcher(".//html//desprendimiento.jsp").forward(request, response);
			break;
		case 7:
			request.setAttribute("acromatopsia", patoDto);
			request.getRequestDispatcher(".//html//acromatopsia.jsp").forward(request, response);
			break;
		case 8:
			request.setAttribute("estrabismo", patoDto);
			request.getRequestDispatcher(".//html//estrabismo.jsp").forward(request, response);
			break;
		case 9:
			request.setAttribute("presbicia", patoDto);
			request.getRequestDispatcher(".//html//presbicia.jsp").forward(request, response);
			break;
		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}