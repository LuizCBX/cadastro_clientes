package br.com.cadastrocliente.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cadastrocliente.dominio.Estado;

public class DAO {
	
	//Criar Lista
	public List<Estado> todos(){
		List<Estado> lista = new ArrayList<Estado>();
		Connection co = null;//Estabelecer conexao com o banco de dados MYSQL
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			
			co = DriverManager.getConnection("jdbc:mysql://localhost:3306/estadoscidadesdb?serverTimezone=UTC","root","");
			
			String consulta = "Select * from estado";
			
			pst = co.prepareStatement(consulta);
			
			rs = pst.executeQuery();
			
			//Popular lista
			//possibilidade de migrar o cursor para próxima linha
			while(rs.next()) {
				lista.add(new Estado(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4)//não precisa de ponto e virgula
						));
			}
	
	
	
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//Fecha conexão com Banco de dados
		finally {
			try {co.close();}catch(Exception e) {e.printStackTrace();}
		}
		return lista;
	}
}
