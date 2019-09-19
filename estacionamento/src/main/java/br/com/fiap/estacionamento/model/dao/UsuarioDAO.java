package br.com.fiap.estacionamento.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.estacionamento.model.entities.Usuario;
import br.com.fiap.estacionamento.model.services.ConnectionFactory;

public class UsuarioDAO {
	
	public Usuario consultarUsuario(String email, String senha) {
		
		Usuario usuario = null;
		
		try(Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("select * from usuario where email = ? and senha = ?");
			
			stmt.setString(1, email);
			stmt.setString(2, senha);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				Long idBD = rs.getLong("id");
				String nomeBD = rs.getString("nome");
				String emailBD = rs.getString("email");
				String senhaBD = rs.getString("senha");
				usuario = new Usuario(nomeBD, emailBD, senhaBD);
				usuario.setId(idBD);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return usuario;
	}

}
