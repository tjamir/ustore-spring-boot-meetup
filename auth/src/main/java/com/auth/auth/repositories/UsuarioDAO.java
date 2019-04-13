/**
 * 
 */
package com.auth.auth.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.auth.auth.model.Usuario;

/**
 * @author mabi
 *
 */
@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Long> {
	
	@Transactional(readOnly = true)
	Optional<Usuario> findByLogin(String login);

}
