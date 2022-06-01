package br.com.alura.springSecurity.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface CrudController<Entity> {

	ResponseEntity<Entity> post(Entity body);

	ResponseEntity<Entity> update(Long id, Entity body);

	ResponseEntity<Entity> delete(Long id);

	ResponseEntity<Entity> get(Long id);
	
	Page<Entity> getAll(Pageable paginacao);

}
