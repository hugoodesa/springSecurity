package br.com.alura.springSecurity.controller;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.alura.springSecurity.entity.Livro;
import br.com.alura.springSecurity.model.RestControllerGeneric;

@RestController
@RequestMapping("/livro")
@EnableSpringDataWebSupport
public class LivroController extends RestControllerGeneric<Livro, JpaRepository<Livro, Long>> {

	@Override
	@CacheEvict(value = "listagem")
	@PostMapping
	public ResponseEntity<Livro> post(@RequestBody Livro body) {
		return super.post(body);
	}

	@Override
	@Cacheable(value = "listagem")
	@GetMapping("/{id}")
	public ResponseEntity<Livro> get(@PathVariable Long id) {
		return super.get(id);
	}

	@Override
	@CacheEvict(value = "listagem")
	@PutMapping("/{id}")
	public ResponseEntity<Livro> update(@PathVariable Long id, @RequestBody Livro body) {
		return super.update(id, body);
	}

	@Override
	@GetMapping("/todos")
	public Page<Livro> getAll(Pageable paginacao) {
		return super.getAll(paginacao);
	}

	@Override
	@CacheEvict(value = "listagem")
	@DeleteMapping("/{id}")
	public ResponseEntity<Livro> delete(@PathVariable Long id) {
		return super.delete(id);
	}

}
