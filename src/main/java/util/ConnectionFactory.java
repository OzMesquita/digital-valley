package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public static Connection getConnection(){
		try {			
			String []bd = Facade.lerArquivoBancoDeDados();
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection(bd[0],bd[1],bd[2]);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void close(){
		
	}
}