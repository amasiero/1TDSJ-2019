package br.com.fiap.estacionamento.model.business;

import br.com.fiap.estacionamento.model.dao.UsuarioDAO;
import br.com.fiap.estacionamento.model.entities.Usuario;

public class UsuarioBO {
	
	public Usuario validarLogin(String email, String senha) {
		return new UsuarioDAO().consultarUsuario(email, senha);
	}

}
