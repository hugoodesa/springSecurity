package com.alura.springRest.springRestTemplate.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.alura.springRest.springRestTemplate.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByLogin(String login);
	
}
