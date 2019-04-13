/**
 * 
 */
package com.auth.auth.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.auth.model.Sessao;
import com.auth.auth.model.Usuario;
import com.auth.auth.repositories.SessaoDAO;
import com.auth.auth.repositories.UsuarioDAO;

/**
 * @author mabi
 *
 */
@Service
public class SessaoService {

	@Autowired
	private UsuarioDAO userDAO;

	@Autowired
	private SessaoDAO sessaoDAO;

	public String login(Usuario usuario) throws Exception {
		Usuario user = userDAO.findByLogin(usuario.getLogin()).orElse(null);

		String login = usuario.getLogin();
		String password = usuario.getPassword();
		if (!login.equals(user.getLogin()) && !password.equals(user.getPassword())) {
			throw new Exception("Login ou senha errado");
		}
		Sessao s = new Sessao(user);
		Sessao save = sessaoDAO.save(s);
		return save.getToken();
	}

	public void logout(String token) throws Exception {
		Sessao sessao = sessaoDAO.findByToken(token).orElse(null);
		sessaoDAO.delete(sessao);
	}

	public boolean check(String token) throws Exception {
		boolean isActive = true;
		Sessao sessao = sessaoDAO.findByToken(token).orElse(null);

		Date currentTime = new Date();
		Date endSession = sessao.getData();

		if (!sessao.isActive() || currentTime.after(endSession)) {
			isActive = false;
			sessaoDAO.delete(sessao);
		}
		return isActive;
	}

}
