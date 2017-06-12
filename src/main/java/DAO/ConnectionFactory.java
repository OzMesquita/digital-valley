package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection(){
		try {			
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemaDeInscricaoEmSelecao", "postgres", "postgres");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

