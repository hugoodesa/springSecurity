package com.alura.springRest.springRestTemplate.dto;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class FormUsuario {

	private String login;
	private String senha;

	public FormUsuario() {
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
		UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(this.login, this.senha);
		return user;
	}

}
