package br.com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionFactory {
	
	//nome do usuario do my sql
	private static final String USERNAME = "root";
	
	//senha do banco
	private static final String PASSWORD = "";
	
	//caminho do banco de dados, nome do banco de dados.	
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3312/agenda";
	
	/*	
	 * Conex�o com o banco de dados.
	 */
	public static Connection createConnectionToMySQL() throws Exception {
		// Faz com que a classe seja carregada pela JVM
		Class.forName("com.mysql.jdbc.Driver");
		
	Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
	
	return connection;
	}
	
	public static void main(String[] args) throws Exception {
		
		//Recuper conex�o com o banco de dados
		Connection con = createConnectionToMySQL();
		
		//testar se a conex�o � nulla
		if(con!=null) {
			System.out.println("Conex�o obtida com sucesso");
			con.close();
		}
	}

}
