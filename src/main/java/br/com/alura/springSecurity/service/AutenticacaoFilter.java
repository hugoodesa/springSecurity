package br.com.alura.springSecurity.service;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.alura.springSecurity.entity.Usuario;
import br.com.alura.springSecurity.repository.UsuarioRepository;

public class AutenticacaoFilter extends OncePerRequestFilter {

	private TokenService tokenService;
	private UsuarioRepository repository;

	public AutenticacaoFilter(TokenService tokenService, UsuarioRepository repository) {
		this.tokenService = tokenService;
		this.repository = repository;
	}
	
	public TokenService getTokenService() {
		return tokenService;
	}

	public void setTokenService(TokenService tokenService) {
		this.tokenService = tokenService;
	}

	public UsuarioRepository getRepository() {
		return repository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String token = recuperarToken(request);
		boolean isTokenValido = validaToken(token);
		
		if(isTokenValido) {
			Long idUsuario = obterIdUsuario(token);
			Optional<Usuario> usuarioObtido = obterUsuario(idUsuario);

			if(usuarioObtido.isPresent()) {
				autenticarUsuario(usuarioObtido.get());
			}
			
		}

		filterChain.doFilter(request, response);
	}

	private String recuperarToken(HttpServletRequest request) {
		String token = request.getHeader("Authentication");

		if (token == null || token.isEmpty() || !token.contains("Baerer ")) {
			return null;
		}
		
		String tokenSubString = token.substring(7);
		System.out.println("Token recuperado : " + tokenSubString);
		return tokenSubString;
	}
	
	private boolean validaToken(String token) {
		return this.tokenService.isTokenValido(token);
	}
	
	private Long obterIdUsuario(String token) {
		return this.tokenService.autenticar(token);
	}

	private Optional<Usuario> obterUsuario(Long idUsuario) {
		return this.repository.findById(idUsuario);
	}
	
	private void autenticarUsuario(Usuario usuario) {
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}
}
