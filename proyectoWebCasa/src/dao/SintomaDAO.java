package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.SintomaDTO;

public class SintomaDAO {
	
	public List<SintomaDTO> buscarSintomasPorInicial (String inicial)
	{
		List<SintomaDTO> lista_sintomas = new ArrayList<SintomaDTO>();
		
			SintomaDTO sintoma = null;
			Pool pool = null;
			pool = Pool.getInstance();
			Connection conn = Pool.getConnection();
			ResultSet rset = null;
			Statement stmt = null;
			try
			{
				stmt = conn.createStatement();
				rset = stmt.executeQuery(Consulta.CONSULTA_SINTOMAS_POR_INICIAL+inicial+"%'");
				while (rset.next())
			    {
					sintoma = new SintomaDTO(rset.getInt(1), rset.getString(2));
					lista_sintomas.add(sintoma);
			    }
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally 
			{
				Pool.liberarRecursos(conn, stmt, rset);
			}
		
		return lista_sintomas;
	}

}
