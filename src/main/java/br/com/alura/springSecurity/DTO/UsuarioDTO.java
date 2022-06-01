package br.com.alura.springSecurity.DTO;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class UsuarioDTO {

	private String login;
	private String senha;

	public UsuarioDTO() {
	}

	public UsuarioDTO(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public UsernamePasswordAuthenticationToken converter() {
		return new UsernamePasswordAuthenticationToken(login, senha);
	}

}
