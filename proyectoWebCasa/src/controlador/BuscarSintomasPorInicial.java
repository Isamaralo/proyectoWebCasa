package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import servicios.SintomaService;

/**
 * Servlet implementation class BuscarSintomasPorInicial
 */
@WebServlet("/BuscarSintomasPorInicial")
public class BuscarSintomasPorInicial extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarSintomasPorInicial() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		SintomaService ss = new SintomaService();
		
		List<String> lista_sintomas = new ArrayList<String>();
		System.out.println(request.getParameter("intro"));
		lista_sintomas = ss.buscarSintomasPorInicial(request.getParameter("intro"));
		
		Gson gson = new Gson();
		for (String string : lista_sintomas) {
			String mensajeJson = gson.toJson(string);
			response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(mensajeJson);
		}
		
		/*for (String string : lista_sintomas) {
			response.getWriter().append(string);
			System.out.println(string);
		}*/
		
		/*PrintWriter out = response.getWriter();
		System.out.println(request.getParameter("intro"));
		
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		
		out = response.getWriter();
		out.println(lista_sintomas.get(1));*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
