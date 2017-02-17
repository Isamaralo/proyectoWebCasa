package servicios;

import java.util.HashMap;

import dao.MapaPatologias;
import dao.PatologiaDAO;
import dto.PatologiaDTO;

public class PatologiaService {
	
	public PatologiaDTO buscarPatologiaPorId (int id)
	{
		PatologiaDTO pdto = null;
		PatologiaDAO pdao = new PatologiaDAO();
		pdto = MapaPatologias.getHm().get(id);
		//	pdto = pdao.buscarPorId(id);
		return pdto;
	}
}