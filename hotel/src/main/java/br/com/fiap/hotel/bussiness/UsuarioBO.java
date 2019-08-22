package br.com.fiap.hotel.bussiness;

import br.com.fiap.hotel.dao.UsuarioDAO;
import br.com.fiap.hotel.model.entities.Usuario;

public class UsuarioBO {

	public Usuario autenticar(Usuario u) {
		Usuario usuario = new UsuarioDAO().consultarPorLogin(u.getLogin());
		if(usuario == null) return null;
		if(!usuario.getSenha().equals(u.getSenha())) return null;
		return usuario;
	}
	
	public boolean validarUsuario(Usuario u) {
		return u.getNome() != null && 
				u.getLogin() != null && 
				u.getSenha() != null; 
	}
}
