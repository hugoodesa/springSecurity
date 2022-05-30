package com.alura.springRest.springRestTemplate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alura.springRest.springRestTemplate.entity.Filme;
import com.alura.springRest.springRestTemplate.repository.FilmeRepository;

@RestController
@RequestMapping("/filmes")
public class FilmeController extends AControllerMain<Filme, JpaRepository<Filme, Long>> {

	@Autowired
	FilmeRepository repository;
	
	@Override
	@CacheEvict(value = "filmes")
	@PostMapping
	public ResponseEntity<Filme> post(@RequestBody Filme entity) {
		return super.post(entity);
	}

	@Override
	@CacheEvict(value = "filmes")
	@GetMapping("/{id}")
	public ResponseEntity<Filme> select(@PathVariable Long id) {
		return super.select(id);
	}

	@Override
	@CacheEvict(value = "filmes")
	@DeleteMapping("/{id}")
	public ResponseEntity<Filme> delete(@PathVariable Long id) {
		return super.delete(id);
	}
	
	@Override
	@Cacheable(value = "filmes")
	@GetMapping("/todos")
	public Page<Filme> getAll(Pageable paginacao) {
		return super.getAll(paginacao);
	}

	@Override
	@Cacheable(value = "filmes")
	@PutMapping("/{id}")
	public ResponseEntity<Filme> update(@RequestBody Filme entityUpdated,@PathVariable Long id) {
		return super.update(entityUpdated, id);
	}

}
