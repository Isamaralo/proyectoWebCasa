package servicios;

import java.util.ArrayList;
import java.util.List;

import dao.SintomaDAO;
import dto.SintomaDTO;

public class SintomaService {
	
	public List<SintomaDTO> buscarSintomasPorInicial (String inicial)
	{
		List<SintomaDTO> lista_sintomas = new ArrayList<SintomaDTO>();
		SintomaDAO sintdao = new SintomaDAO();
		
			lista_sintomas = sintdao.buscarSintomasPorInicial(inicial);
		
		return lista_sintomas;
	}

}
