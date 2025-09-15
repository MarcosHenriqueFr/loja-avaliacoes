package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import com.example.model.Usuario;
import com.example.utils.ConnectionFactory;

public class UsuarioDAO {
	
	public UsuarioDAO() {}
	
	public Usuario insertUsuario(String nome, String email) {
		
		
		
		return null;
	}
	
	public Optional<Usuario> findByEmail(String email) throws ClassNotFoundException, SQLException {
		final String QUERY = "SELECT id, nome, email FROM usuarios WHERE email = ?";
		try (
			Connection connection = ConnectionFactory.getConnection();
			PreparedStatement stmt = connection.prepareStatement(QUERY);
		){
			stmt.setString(1, email);
			try (ResultSet saida = stmt.executeQuery()){
				if(saida.next()) {
					
					Usuario usuario = 
							new Usuario(
									saida.getInt("id"), 
									saida.getString("nome"), 
									saida.getString("email"));
					
					return Optional.of(usuario);
				}
			}
		}
		
		return Optional.empty();
	}
	
}
