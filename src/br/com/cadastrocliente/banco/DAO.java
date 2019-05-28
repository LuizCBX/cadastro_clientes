package br.com.cadastrocliente.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cadastrocliente.dominio.Cidade;
import br.com.cadastrocliente.dominio.Estado;

public class DAO {
	
	//Criar Lista ESTADO
	public List<Estado> todos(){
		List<Estado> lista = new ArrayList<Estado>();

		Connection cn = null; //ESTABELECE CONEXAO COM BANDO DE DADOS
		PreparedStatement pst = null; //EXECUTAR CONSULTAS SQL, (USADO PARA FAZER  CRUD)
		ResultSet rs =  null;//GUARDAR RESULTADOS DO SELECT
		
		
		//ESTADO
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/estadoscidadesdb?serverTimezone=UTC","root","");
			
			String consulta = "Select * from estado";
			
			pst = cn.prepareStatement(consulta);
			
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
			try {cn.close();}catch(Exception e) {e.printStackTrace();}
		}
		return lista;
	}
	
	
	//CIDADES
	public List<Cidade> listarCidades(int id){
		
		Connection cn = null; //ESTABELECE CONEXAO COM BANDO DE DADOS
		PreparedStatement pst = null; //EXECUTAR CONSULTAS SQL, (USADO PARA FAZER  CRUD)
		ResultSet rs =  null;//GUARDAR RESULTADOS DO SELECT
		
		List<Cidade> lista = new ArrayList<Cidade>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();//CARREGAR O DRIVER DE COMUNICAÇÃO SQL
			
			//CHAMAR GERENCIADOR
			cn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/estadoscidadesdb?serverTimezone=UTC", "root","");
			
			//CONSULTA
			String consulta = "Select * from cidade where estado=?";
			
			//PREPARANDO PARA EXECUTAR
			pst = cn.prepareStatement(consulta);
			
			pst.setInt(1, id); 
			
			//EXECUTA A CONSULTA E O QUE VEM DE RETORNO VAI PARA O (rs)
			rs = pst.executeQuery();
			
			//CRIAR A LISTA
			while(rs.next()) {
				lista.add(new Cidade(
						rs.getInt(1),
						rs.getString(2),
						rs.getInt(3)
						));
			}
		}
		//SÃO DOIS CATCH
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {cn.close();}catch(Exception e) {e.printStackTrace();}
		}
		return lista;
	}
	
}
