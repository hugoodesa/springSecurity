package com.alura.springRest.springRestTemplate.service;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.alura.springRest.springRestTemplate.entity.Usuario;
import com.alura.springRest.springRestTemplate.repository.UsuarioRepository;
import com.alura.springRest.springRestTemplate.security.AuthenticationToken;

public class TokenFilter extends OncePerRequestFilter {

	private AuthenticationToken authenticationToken;
	private UsuarioRepository usuarioRepository;

	public TokenFilter(AuthenticationToken authenticationToken,UsuarioRepository usuarioRepository) {
		this.authenticationToken = authenticationToken;
		this.usuarioRepository=usuarioRepository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String token = recuperarToken(request);
		System.out.println("Token recuperado : " + token);
		
		boolean tokenValido = authenticationToken.isTokenValido(token);
		System.out.println("token valido :"+tokenValido);
		
		if(tokenValido) {
			autenticarUsuario(token);
		}
		
		filterChain.doFilter(request, response);
	}

	private void autenticarUsuario(String token) {
		
		Long idUsuario = getIdUsuarioByHeader(token);
		
		Optional<Usuario> usuario = this.usuarioRepository.findById(idUsuario);
		
		if(usuario.isPresent()) {
			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario.get(), null, usuario.get().getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
	}

	private Long getIdUsuarioByHeader(String token) {
		Long idUsuario = authenticationToken.autenticarUsuario(token);
		return idUsuario;
	}

	private String recuperarToken(HttpServletRequest request) {

		String token = request.getHeader("Authentication");

		if (token == null || token.isEmpty() || !token.contains("Baerer ")) {
			return null;
		}
		
		System.out.println("token :"+token);
		
		return token.substring(7);
	}
	
	public AuthenticationToken getAuthenticationToken() {
		return authenticationToken;
	}

	public void setAuthenticationToken(AuthenticationToken authenticationToken) {
		this.authenticationToken = authenticationToken;
	}

}
