package br.com.alura.springSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
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
import br.com.alura.springSecurity.entity.Autor;
import br.com.alura.springSecurity.model.RestControllerGeneric;
import br.com.alura.springSecurity.repository.AutorRepository;

@RestController
@RequestMapping("/autor")
public class AutorController extends RestControllerGeneric<Autor, JpaRepository<Autor, Long>> {

	@Autowired
	AutorRepository repository;
	
	@Override
	@PostMapping
	public ResponseEntity<Autor> post(@RequestBody Autor body) {
		return super.post(body);
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<Autor> get(@PathVariable Long id) {
		return super.get(id);
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<Autor> update(@PathVariable Long id, @RequestBody Autor body) {
		return super.update(id, body);
	}

	@Override
	@GetMapping("/todos")
	public Page<Autor> getAll(Pageable paginacao) {
		return super.getAll(paginacao);
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Autor> delete(@PathVariable Long id) {
		return super.delete(id);
	}

}
