package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SintomaDAO {
	
	public List<String> buscarSintomasPorInicial (String inicial)
	{
		List<String> lista_sintomas = new ArrayList<String>();
		
			String sintoma = null;
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
					sintoma = rset.getString(1);
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
