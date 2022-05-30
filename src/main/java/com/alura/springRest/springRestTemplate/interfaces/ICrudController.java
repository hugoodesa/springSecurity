package com.alura.springRest.springRestTemplate.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ICrudController<Entity> {

	ResponseEntity<Entity> post(Entity entity);
	
	ResponseEntity<Entity> update(Entity entity,Long id);
	
	ResponseEntity<Entity> select(Long id);
	
	ResponseEntity<Entity> delete(Long id);
	
	Page<Entity> getAll(Pageable paginacao);
	
}
