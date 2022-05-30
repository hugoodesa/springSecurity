package com.alura.springRest.springRestTemplate.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.alura.springRest.springRestTemplate.entity.Heroi;
import com.alura.springRest.springRestTemplate.repository.HeroiRepository;

@RestController
@RequestMapping("/herois")
public class HeroiController extends AControllerMain<Heroi, JpaRepository<Heroi, Long>> {

	@Autowired
	HeroiRepository repository;

	@Override
	@PostMapping
	public ResponseEntity<Heroi> post(@RequestBody Heroi entity) {
		return super.post(entity);
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<Heroi> select(@PathVariable Long id) {
		return super.select(id);
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Heroi> delete(@PathVariable Long id) {
		return super.delete(id);
	}

	@Override
	@GetMapping("/todos")
	public Page<Heroi> getAll(Pageable paginacao) {
		return super.getAll(paginacao);
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<Heroi> update(@RequestBody Heroi entityUpdated,@PathVariable Long id) {
		return super.update(entityUpdated, id);
	}

}
