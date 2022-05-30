package com.alura.springRest.springRestTemplate.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import com.alura.springRest.springRestTemplate.entity.EntityModel;
import com.alura.springRest.springRestTemplate.interfaces.ICrudController;

public abstract class AControllerMain<Entity extends EntityModel, RepositoryController extends JpaRepository<Entity, Long>>
		implements ICrudController<Entity> {

	@Autowired
	RepositoryController repository;

	@Override
	public ResponseEntity<Entity> post(Entity entity) {
		try {
			Entity savedEntity = this.repository.save(entity);
			return ResponseEntity.ok(savedEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.badRequest().build();
	}

	@Override
	public ResponseEntity<Entity> update(Entity entityUpdated, Long id) {
		try {
			Optional<Entity> entityToUpdate = this.repository.findById(id);
			if (entityToUpdate.isPresent()) {
				entityUpdated.setId(id);
				this.repository.save(entityUpdated);

				return ResponseEntity.ok(entityUpdated);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.badRequest().build();
	}

	@Override
	public ResponseEntity<Entity> select(Long id) {
		try {
			Optional<Entity> entitySelected = this.repository.findById(id);
			if (entitySelected.isPresent()) {
				return ResponseEntity.ok(entitySelected.get());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.badRequest().build();
	}

	@Override
	public ResponseEntity<Entity> delete(Long id) {
		try {
			this.repository.deleteById(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.badRequest().build();
	}

	@Override
	public Page<Entity> getAll(Pageable paginacao) {
		return this.repository.findAll(paginacao);
	}

}
