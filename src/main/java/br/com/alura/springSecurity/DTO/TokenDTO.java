package br.com.alura.springSecurity.DTO;

public class TokenDTO {

	private String token;
	private String autenticacao;

	public TokenDTO() {
	}

	public TokenDTO(String token, String autenticacao) {
		this.token = token;
		this.autenticacao = autenticacao;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getAutenticacao() {
		return autenticacao;
	}

	public void setAutenticacao(String autenticacao) {
		this.autenticacao = autenticacao;
	}

}
