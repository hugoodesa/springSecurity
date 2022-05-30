package com.alura.springRest.springRestTemplate.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.alura.springRest.springRestTemplate.entity.Heroi;

public interface HeroiRepository extends JpaRepository<Heroi, Long>{

	Optional<Heroi> findByNomeIgnoreCase (String nome);
	
}
