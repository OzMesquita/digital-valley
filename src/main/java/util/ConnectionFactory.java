package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConnection(){
		try {
			String []bd = Facade.lerArquivoBancoDeDados();
			
			return DriverManager.getConnection(bd[0],bd[1],bd[2]);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

