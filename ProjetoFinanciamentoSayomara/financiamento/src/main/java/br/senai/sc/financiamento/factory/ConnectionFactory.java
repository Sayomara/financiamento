package br.senai.sc.financiamento.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	Connection conn = null;
	public Connection connect() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/financiamento", "root", "");
			System.out.println("Connected");
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void close() {
		try {
			conn.close();
			System.out.println("Disconnected");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
