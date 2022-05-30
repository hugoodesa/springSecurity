package com.alura.springRest.springRestTemplate.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.alura.springRest.springRestTemplate.entity.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long>{

	Optional<Filme> findByNomeIgnoreCase (String nome);
	
}
