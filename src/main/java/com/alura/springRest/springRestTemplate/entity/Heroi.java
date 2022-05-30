package com.alura.springRest.springRestTemplate.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "herois")
public class Heroi extends EntityModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;

	@JsonBackReference
	@ManyToMany(mappedBy = "herois", cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	List<Filme> filmes;

	public Heroi() {
	}

	public Heroi(Long id, String nome, List<Filme> filmes) {
		this.id = id;
		this.nome = nome;
		this.filmes = filmes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}

}
