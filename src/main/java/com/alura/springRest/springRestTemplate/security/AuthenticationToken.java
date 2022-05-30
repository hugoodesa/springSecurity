package com.alura.springRest.springRestTemplate.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import com.alura.springRest.springRestTemplate.entity.Usuario;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class AuthenticationToken {

	@Value("${jwt.expiration}")
	private String expiration;

	@Value("${jwt.password}")
	private String password;

	public String gerarToken(Authentication authenticate) {
		Long expirationLong = Long.parseLong(expiration);
		Date dataExpiracao = new Date(new Date().getTime()+expirationLong);
		
		Usuario usuario =(Usuario) authenticate.getPrincipal();
		
		//System.out.println("password: " + password);
		
		String token = Jwts.builder()
		.setIssuer("Token gerado para api do Hugo")
		.setIssuedAt(new Date())
		.setExpiration(dataExpiracao)
		.setSubject(usuario.getId().toString())
		.signWith(SignatureAlgorithm.HS256, password)
		.compact();

		return token;
	}
	
	public boolean isTokenValido (String token) {
		try {
			Jwts.parser().setSigningKey(password).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Long autenticarUsuario (String token) {
		try {
			Claims body = Jwts.parser().setSigningKey(password).parseClaimsJws(token).getBody();
			String id = body.getSubject();
			
			return Long.parseLong(id);
		} catch (Exception e) {
			e.printStackTrace();
			return 0L;
		}
	}


}
