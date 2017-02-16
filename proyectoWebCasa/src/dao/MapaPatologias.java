package dao;

import java.util.HashMap;

import dto.PatologiaDTO;

public class MapaPatologias {
	
	private static HashMap<Integer, PatologiaDTO> hm = new HashMap<Integer, PatologiaDTO>();

	public static HashMap<Integer, PatologiaDTO> getHm() {
		return hm;
	}

	public static void setHm(HashMap<Integer, PatologiaDTO> hm) {
		MapaPatologias.hm = hm;
	}

	public MapaPatologias ()
	{
		MapaPatologias.hm = new HashMap<Integer, PatologiaDTO>();
	}

}
