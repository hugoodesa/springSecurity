package br.com.alura.springSecurity.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.alura.springSecurity.entity.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	@Value("${jwt.chave}")
	private String chave;
	
	@Value("${jwt.tempoSessao}")
	private String tempoSessao;
	
	
	public String gerarToken(Authentication authentication) {
		
		Usuario usuario = (Usuario)	authentication.getPrincipal();
		
		long hojeMilisegundos = new Date().getTime();
		long tempoSessaoMilisegundos = Long.parseLong(tempoSessao);
		Date dataExpiracao = new Date(hojeMilisegundos+tempoSessaoMilisegundos);
		
		String token = Jwts.builder()
		.setIssuer("Token gerado pelo Hugo")
		.setExpiration(dataExpiracao)
		.setIssuedAt(new Date())
		.setSubject(usuario.getId().toString())
		.signWith(SignatureAlgorithm.HS256, chave)
		.compact();
		
		System.out.println(token);
		
		return token;
	}


	public boolean isTokenValido(String token) {
		try {
			Jwts.parser().setSigningKey(chave).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Long autenticar(String token) {
		try {
			Claims body = Jwts.parser().setSigningKey(chave).parseClaimsJws(token).getBody();
			String id = body.getSubject();
			
			return Long.parseLong(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0L;
	}
	
	
}
