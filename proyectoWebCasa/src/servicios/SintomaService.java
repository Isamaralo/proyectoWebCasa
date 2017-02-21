package servicios;

import java.util.ArrayList;
import java.util.List;

import dao.SintomaDAO;

public class SintomaService {
	
	public List<String> buscarSintomasPorInicial (String inicial)
	{
		List<String> lista_sintomas = new ArrayList<String>();
		SintomaDAO sintdao = new SintomaDAO();
		
			lista_sintomas = sintdao.buscarSintomasPorInicial(inicial);
		
		return lista_sintomas;
	}

}
