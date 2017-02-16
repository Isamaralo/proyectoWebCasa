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
		HashMap<Integer, PatologiaDTO> hm = MapaPatologias.getHm();
		//	pdto = pdao.buscarPorId(id);
			pdto = hm.get(id);
		return pdto;
	}
}