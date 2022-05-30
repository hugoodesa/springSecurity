package com.alura.springRest.springRestTemplate.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.alura.springRest.springRestTemplate.entity.Usuario;
import com.alura.springRest.springRestTemplate.repository.UsuarioRepository;

@Service
public class UsuarioDetailService implements UserDetailsService {

	@Autowired
	UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = repository.findByLogin(username);

		if (usuario.isPresent()) {
			return usuario.get();
		}

		throw new UsernameNotFoundException("Usuário não encontrado");
	}

}
