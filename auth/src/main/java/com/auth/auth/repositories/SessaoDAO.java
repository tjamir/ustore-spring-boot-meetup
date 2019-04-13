package com.auth.auth.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.auth.auth.model.Sessao;

public interface SessaoDAO extends JpaRepository<Sessao, Long> {

	@Transactional(readOnly = true)
	Optional<Sessao> findByToken(String token);
}
