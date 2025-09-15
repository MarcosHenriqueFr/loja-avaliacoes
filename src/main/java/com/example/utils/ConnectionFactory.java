package com.example.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	
	private final static String URL;
	private final static String USUARIO;
	private final static String SENHA;
	
	static {
		Properties props = new Properties();
		
		try {
			InputStream input = ConnectionFactory.class
					.getClassLoader()
					.getResourceAsStream("db.properties");
			if(input != null) {
				props.load(input);				
			}
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch(IOException e) {
			throw new RuntimeException("Ocorreu um problema de carregamento do arquivo \'db.properties\'");
		} catch(ClassNotFoundException e) {
			throw new RuntimeException("Não foi possível encontrar o connector/j");
		}
		
		URL = props.getProperty("db.url");
		USUARIO = props.getProperty("db.usuario");
		SENHA = props.getProperty("db.senha");
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USUARIO, SENHA);
	}
}
