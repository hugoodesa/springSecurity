package br.com.alura.springSecurity.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import br.com.alura.springSecurity.model.MainEntity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
@Table(name = "livros")
public class Livro extends MainEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Length(min = 5)
	private String titulo;

	@Column(name = "data_lancamento")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataLancamento;

	@Column(name = "numero_paginas")
	private int numeroPaginas;
	
	@ManyToMany(mappedBy = "livros")
	private List<Autor> autores;

	public Livro() {
	}

	public Livro(@Length(min = 5) String titulo, LocalDate dataLancamento, int numeroPaginas) {
		this.titulo = titulo;
		this.dataLancamento = dataLancamento;
		this.numeroPaginas = numeroPaginas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

}
