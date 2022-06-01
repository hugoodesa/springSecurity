package br.com.alura.springSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.springSecurity.DTO.TokenDTO;
import br.com.alura.springSecurity.DTO.UsuarioDTO;
import br.com.alura.springSecurity.entity.Usuario;
import br.com.alura.springSecurity.repository.UsuarioRepository;
import br.com.alura.springSecurity.service.TokenService;

@RestController
@RequestMapping("/auth")
@Profile("prod")
public class AutenticacaoController {

	@Autowired
	TokenService tokenService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UsuarioRepository repository;
	
	@PostMapping
	public ResponseEntity<TokenDTO> autenticar(@RequestBody UsuarioDTO usuarioDTO){
		System.out.println(usuarioDTO.getLogin());
		System.out.println(usuarioDTO.getSenha());
		
		UsernamePasswordAuthenticationToken dadosLogin = usuarioDTO.converter();
		
		try {
			Authentication authenticate = authenticationManager.authenticate(dadosLogin);
			
			String token = tokenService.gerarToken(authenticate);
			//usuarioDTO.converter();
			System.out.println("Token : "+token);
			TokenDTO tokenDTO = new TokenDTO(token, "Baerer");
			
			return ResponseEntity.ok(tokenDTO);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<UsuarioDTO> cadastrar(@RequestBody UsuarioDTO usuarioDTO){
		System.out.println(usuarioDTO.getLogin());
		System.out.println(usuarioDTO.getSenha());
		
		Usuario usuario = new Usuario("moderador", usuarioDTO.getLogin(), new BCryptPasswordEncoder().encode(usuarioDTO.getSenha()));
		this.repository.save(usuario);
		
		return ResponseEntity.ok(usuarioDTO);
	}
	
}
