package com.alura.springRest.springRestTemplate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alura.springRest.springRestTemplate.dto.FormUsuario;
import com.alura.springRest.springRestTemplate.dto.TokenDTO;
import com.alura.springRest.springRestTemplate.security.AuthenticationToken;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
	
	@Autowired
	private AuthenticationManager authManeger;
	
	@Autowired
	private AuthenticationToken authToken;

	@GetMapping
	public ResponseEntity<TokenDTO> auth(@RequestBody FormUsuario form) {
		System.out.println("login : " + form.getLogin());
		System.out.println("senha : " + form.getSenha());
		UsernamePasswordAuthenticationToken dadosLogin = form.converter();
		
		try {
			Authentication authenticate = authManeger.authenticate(dadosLogin);
			String token = authToken.gerarToken(authenticate);
			
			//System.out.println("Token : "+token);
			
			return ResponseEntity.ok(new TokenDTO(token,"Baerer"));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}

}
