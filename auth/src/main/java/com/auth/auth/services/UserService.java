/**
 * 
 */
package com.auth.auth.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.auth.model.Usuario;
import com.auth.auth.repositories.UsuarioDAO;

/**
 * @author mabi
 *
 */
@Service
public class UserService {

	@Autowired
	private UsuarioDAO userDAO;

	public Usuario findUser(Long id) {
		Optional<Usuario> optional = userDAO.findById(id);
		return optional.get();
	}
}
