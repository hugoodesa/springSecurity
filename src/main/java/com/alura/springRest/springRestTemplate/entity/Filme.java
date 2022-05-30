package com.alura.springRest.springRestTemplate.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "filmes")
public class Filme extends EntityModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate lancamento;
	private BigDecimal bilheteria;

	@JoinTable(name = "filmes_herois", joinColumns = @JoinColumn(name = "id_filme"), inverseJoinColumns = @JoinColumn(name = "id_heroi"))
	@ManyToMany(cascade = CascadeType.PERSIST)
	private List<Heroi> herois;

	public Filme() {
	}

	public Filme(String nome, LocalDate lancamento, BigDecimal bilheteria, List<Heroi> herois) {
		this.nome = nome;
		this.lancamento = lancamento;
		this.bilheteria = bilheteria;
		this.herois = herois;
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

	public LocalDate getLancamento() {
		return lancamento;
	}

	public void setLancamento(LocalDate lancamento) {
		this.lancamento = lancamento;
	}

	public BigDecimal getBilheteria() {
		return bilheteria;
	}

	public void setBilheteria(BigDecimal bilheteria) {
		this.bilheteria = bilheteria;
	}

	public List<Heroi> getHerois() {
		return herois;
	}

	public void setHerois(List<Heroi> herois) {
		this.herois = herois;
	}

}
