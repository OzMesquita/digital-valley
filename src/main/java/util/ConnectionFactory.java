package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public static Connection getConnection(){
		try {			
			String []bd = Facade.lerArquivoBancoDeDados();
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection("jdbc:postgresql://192.169.1.2:5432/n2s-ufc","n2s","N2S@UFC");
		} catch (Exception e) {
			throw new RuntimeException("falha ao conectar no banco!");
		}
	}
	
	
}